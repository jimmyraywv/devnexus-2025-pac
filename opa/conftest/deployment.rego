package main

import rego.v1

deployment_error := "INVALID_DEPLOYMENT"

bad_registry := "k8s.gcr.io"

good_registry := "registry.k8s.io"

pod_spec := input.spec.template.spec

containers := pod_spec.containers

resource_id := sprintf("%s/%s/%s", [input.metadata.namespace, input.metadata.name, input.kind])

# latest bad
deny_latest contains msg if {
	input.kind == "Deployment"
	some container in containers
	image := container.image
	endswith(lower(image), "latest")
	msg := sprintf("%q: Image with latest found: %q. Resource ID (ns/name/kind): %q.", [deployment_error, image, resource_id])
}

# # no version bad
deny_no_version contains msg if {
	input.kind == "Deployment"
	some container in containers
	image := container.image
	count(split(image, ":")) == 1
	msg := sprintf("%q: Image with no version found: %q. Resource ID (ns/name/kind): %q.", [deployment_error, image, resource_id])
}

# deprecated registry
deny_bad_registry contains msg if {
	input.kind == "Deployment"
	some container in containers
	image := container.image
	contains(lower(image), bad_registry)
	msg := sprintf("%q: Deprecated registry (%q) found: %q. %q should be used. Resource ID (ns/name/kind): %q.", [deployment_error, bad_registry, image, good_registry, resource_id])
}

# Security context rules

deny_sec_con contains msg if {
	input.kind == "Deployment"
	some container in containers
	not container.securityContext
	msg = sprintf("%q: Valid securityContext element not found in %q container. Resource ID (ns/name/kind): %q.", [deployment_error, container.name, resource_id])
}

deny_sec_con_priv contains msg if {
	input.kind == "Deployment"
	some container in containers
	container.securityContext
	container.securityContext.allowPrivilegeEscalation

	# privileged
	msg = sprintf("%q: The securityContext element for %q container allow privilege escalation. Resource ID (ns/name/kind): %q", [deployment_error, container.name, resource_id])
}

deny_runasuser_0 contains msg if {
	input.kind == "Deployment"
	some container in containers
	container.securityContext
	not container.securityContext.runAsUser > 0
	msg = sprintf("%q: The securityContext element for container %q is set to run as UID 0. Resource ID (ns/name/kind): %q", [deployment_error, container.name, resource_id])
}

deny_no_runasuser contains msg if {
	input.kind == "Deployment"
	some container in containers
	container.securityContext
	not container.securityContext.runAsUser
	not pod_spec.securityContext.runAsUser
	msg = sprintf("%q: The securityContext elements for container %q, and its pod, do not have runasuser elements. Resource ID (ns/name/kind): %q", [deployment_error, container.name, resource_id])
}

deny_no_readOnlyRootFilesystem contains msg if {
	input.kind == "Deployment"
	some container in containers
	container.securityContext
	not container.securityContext.readOnlyRootFilesystem
	msg = sprintf("%q: The securityContext element for container %q does not have a readonly root filesystem element.Resource ID (ns/name/kind): %q", [deployment_error, container.name, resource_id])
}

deny_readOnlyRootFilesystem_false contains msg if {
	input.kind == "Deployment"
	some container in containers
	container.securityContext.readOnlyRootFilesystem == false
	msg = sprintf("%q: The securityContext element for container %q does not have a readonly root filesystem.Resource ID (ns/name/kind): %q", [deployment_error, container.name, resource_id])
}

# Resource rules

deny_no_resources contains msg if {
	input.kind == "Deployment"
	some container in containers
	not container.resources
	msg = sprintf("%q: Valid resources element not found in %q container. Resource ID (ns/name/kind): %q", [deployment_error, container.name, resource_id])
}

deny_no_resources_limits contains msg if {
	input.kind == "Deployment"
	some container in containers
	container.resources
	not container.resources.limits
	msg = sprintf("%q: Valid resources.limits element not found in %q container. Resource ID (ns/name/kind): %q", [deployment_error, container.name, resource_id])
}

deny_no_resources_limits_cpu contains msg if {
	input.kind == "Deployment"
	some container in containers
	container.resources.limits
	not container.resources.limits.cpu
	msg = sprintf("%q: Valid resources.limits.cpu element not found in %q container. Resource ID (ns/name/kind): %q", [deployment_error, container.name, resource_id])
}

deny_no_resources_limits_memory contains msg if {
	input.kind == "Deployment"
	some container in containers
	container.resources.limits
	not container.resources.limits.memory
	msg = sprintf("%q: Valid resources.limits.memory element not found in %q container. Resource ID (ns/name/kind): %q", [deployment_error, container.name, resource_id])
}

deny_no_resources_requests contains msg if {
	input.kind == "Deployment"
	some container in containers
	container.resources
	not container.resources.requests
	msg = sprintf("%q: Valid resources.requests element not found in %q container. Resource ID (ns/name/kind): %q", [deployment_error, container.name, resource_id])
}

deny_no_resources_requests_cpu contains msg if {
	input.kind == "Deployment"
	some container in containers
	container.resources.requests
	not container.resources.requests.cpu
	msg = sprintf("%q: Valid resources.requests.cpu element not found in %q container. Resource ID (ns/name/kind): %q", [deployment_error, container.name, resource_id])
}

deny_no_resources_requests_memory contains msg if {
	input.kind == "Deployment"
	some container in containers
	container.resources.requests
	not container.resources.requests.memory
	msg = sprintf("%q: Valid resources.requests.memory element not found in %q container. Resource ID (ns/name/kind): %q", [deployment_error, container.name, resource_id])
}
