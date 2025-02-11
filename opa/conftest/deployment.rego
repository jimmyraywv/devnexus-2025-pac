package kubnernetes.admission

# import data.lib.k8s.helpers as helpers
import rego.v1

bad_registry := "k8s.gcr.io"

good_registry := "registry.k8s.io"

# latest bad
deny_latest contains msg if {
	some container in input.spec.template.spec.containers
	image := container.image
	endswith(lower(image), "latest")
	msg := sprintf("Image with latest found: %q", [image])
}

# no version bad
deny_no_version contains msg if {
	some container in input.spec.template.spec.containers
	image := container.image
	count(split(image, ":")) == 1
	msg := sprintf("Image with no version found: %q", [image])
}

# deprecated registry
deny_bad_registry contains msg if {
	some container in input.spec.template.spec.containers
	image := container.image
	contains(lower(image), bad_registry)
	msg := sprintf("Deprecated registry (%q) found: %q. %q should be used.", [bad_registry, image, good_registry])
}

deny_sec_con contains msg if {
	helpers.resource_kind == "Deployment"
	helpers.request_operation in helpers.allowed_k8s_ops
	some container in helpers.deployment_containers
	not container.securityContext
	msg = sprintf("%q: Valid securityContext element not found in %q container.  Resource ID (ns/name/kind): %q.", [helpers.deployment_error, container.name, helpers.resource_id])
}

deny_sec_con_priv contains msg if {
	helpers.resource_kind == "Deployment"
	helpers.request_operation in helpers.allowed_k8s_ops
	some container in helpers.deployment_containers
	container.securityContext.privileged
	msg = sprintf("%q: The securityContext element for %q container is privileged. Resource ID (ns/name/kind): %q", [helpers.deployment_error, container.name, helpers.resource_id])
}

# deny[msg] {
#   helpers.request_kind = "Deployment"
#   helpers.request_operation in helpers.allowed_k8s_ops
#   container = helpers.deployment_containers[_]
#   container.securityContext.allowPrivilegeEscalation
#   msg = sprintf("%q: The securityContext element for container %q allows privilege escalation.Resource ID (ns/name/kind): %q", [helpers.deployment_error,container.name,helpers.request_id])
# }
# deny[msg] {
#   helpers.request_kind = "Deployment"
#   helpers.allowed_operations[helpers.request_operation]
#   container = helpers.deployment_containers[_]
#   not container.securityContext.runAsUser > 0
#   msg = sprintf("%q: The securityContext element for container %q is set to run as UID 0. Resource ID (ns/name/kind): %q", [helpers.deployment_error,container.name,helpers.request_id])
# }
# deny[msg] {
#   helpers.request_kind = "Deployment"
#   helpers.allowed_operations[helpers.request_operation]
#   container = helpers.deployment_containers[_]
#   not container.securityContext.readOnlyRootFilesystem
#   msg = sprintf("%q: The securityContext element for container %q does not have a readonly root filesystem element.Resource ID (ns/name/kind): %q", [helpers.deployment_error,container.name,helpers.request_id])
# }
# deny[msg] {
#   helpers.request_kind = "Deployment"
#   helpers.allowed_operations[helpers.request_operation]
#   container = helpers.deployment_containers[_]
#   container.securityContext.readOnlyRootFilesystem == false
#   msg = sprintf("%q: The securityContext element for container %q does not have a readonly root filesystem.Resource ID (ns/name/kind): %q", [helpers.deployment_error,container.name,helpers.request_id])
# }
