package grc.k8s.deployment.validation

import rego.v1

k8s_registries := {"bad": "k8s.gcr.io", "good": "registry.k8s.io"}

containers := input.spec.template.spec.containers

resource_name := input.metadata.name

resource_namespace := input.metadata.namespace

resource_kind := input.kind

meta_labels := input.metadata.labels

temp_labels := input.spec.template.metadata.labels

status_labels := {
	"invalid_deployment": "INVALID_DEPLOYMENT",
	"invalid_image_version": "INVALID_IMAGE_VERSION",
	"invalid_registry": "INVALID_IMAGE_REGISTRY",
	"invalid_resources": "INVALID_CONTAINER_RESOURCES",
	"invalid_sec_con": "INVALID_SECURITY_CONTEXT",
	"invalid_labels": "INVALID_LABELS",
}

required_labels := {"app", "billing", "owner", "env"}

# latest version bad
deny contains result if {
	some container in containers
	image := container.image
	endswith(lower(image), "latest")
	result := {status_labels.invalid_deployment: {
		"error": status_labels.invalid_image_version,
		"severity": "deny",
		"msg": "Container version cannot be latest.",
		"container-name": container.name,
		"container-image": container.image,
		"namespace": resource_namespace,
		"name": resource_name,
		"kind": resource_kind,
	}}
}

# no version bad
deny contains result if {
	some container in containers
	image := container.image
	count(split(image, ":")) == 1
	result := {status_labels.invalid_deployment: {
		"error": status_labels.invalid_image_version,
		"severity": "deny",
		"msg": "Image with no version found.",
		"container-name": container.name,
		"container-image": container.image,
		"namespace": resource_namespace,
		"name": resource_name,
		"kind": resource_kind,
	}}
}

# deprecated registry
deny contains result if {
	some container in containers
	image := container.image
	contains(lower(image), k8s_registries.bad)
	result := {status_labels.invalid_deployment: {
		"error": status_labels.invalid_registry,
		"severity": "warn",
		"msg": sprintf(
			"Deprecated registry (%q) found: %q. %q should be used.",
			[k8s_registries.bad, image, k8s_registries.good],
		),
		"container-name": container.name,
		"container-image": container.image,
		"namespace": resource_namespace,
		"name": resource_name,
		"kind": resource_kind,
	}}
}

# Security context missing
deny contains result if {
	resource_kind == "Deployment"
	some container in containers
	not container.securityContext
	result := {status_labels.invalid_deployment: {
		"error": status_labels.invalid_sec_con,
		"severity": "deny",
		"msg": sprintf(
			"Valid securityContext element not found in %q container.",
			[container.name],
		),
		"container-name": container.name,
		"container-image": container.image,
		"namespace": resource_namespace,
		"name": resource_name,
		"kind": resource_kind,
	}}
}

# Security context privilege escalation
deny contains result if {
	resource_kind == "Deployment"
	some container in containers
	container.securityContext.allowPrivilegeEscalation
	result := {status_labels.invalid_deployment: {
		"error": status_labels.invalid_sec_con,
		"severity": "deny",
		"msg": sprintf(
			"The securityContext element for %q container is privileged. Security Context: %q",
			[container.name, container.securityContext],
		),
		"container-name": container.name,
		"container-image": container.image,
		"namespace": resource_namespace,
		"name": resource_name,
		"kind": resource_kind,
	}}
}

# Security context user 0
deny contains result if {
	resource_kind == "Deployment"
	some container in containers
	not container.securityContext.runAsUser > 0
	result := {status_labels.invalid_deployment: {
		"error": status_labels.invalid_sec_con,
		"severity": "deny",
		"msg": sprintf(
			"The securityContext element for container %q is set to run as UID 0. Security Context: %q",
			[container.name, container.securityContext],
		),
		"container-name": container.name,
		"container-image": container.image,
		"namespace": resource_namespace,
		"name": resource_name,
		"kind": resource_kind,
	}}
}

# Security context run as root
deny contains result if {
	resource_kind == "Deployment"
	some container in containers
	container.securityContext.runAsRoot
	result := {status_labels.invalid_deployment: {
		"error": status_labels.invalid_sec_con,
		"severity": "deny",
		"msg": sprintf(
			"The securityContext element for container %q is set to run as root. Security Context: %q",
			[container.name, container.securityContext],
		),
		"container-name": container.name,
		"container-image": container.image,
		"namespace": resource_namespace,
		"name": resource_name,
		"kind": resource_kind,
	}}
}

# Security context read only root fs
deny contains result if {
	resource_kind == "Deployment"
	some container in containers
	not container.securityContext.readOnlyRootFilesystem
	result := {status_labels.invalid_deployment: {
		"error": status_labels.invalid_sec_con,
		"severity": "deny",
		"msg": sprintf(
			"The securityContext element for container %q does not have a readonly root filesystem. Security Context: %q",
			[container.name, container.securityContext],
		),
		"container-name": container.name,
		"container-image": container.image,
		"namespace": resource_namespace,
		"name": resource_name,
		"kind": resource_kind,
	}}
}

# Labels in Pod template
deny contains result if {
	resource_kind == "Deployment"
	missing_labels := required_labels - {k | temp_labels[k]}
	count(missing_labels) > 0
	result := {status_labels.invalid_deployment: {
		"error": status_labels.invalid_labels,
		"severity": "deny",
		"msg": sprintf(
			"%q label(s) missing. %q are required labels in the spec.template.metadata.labels element.",
			[concat(", ", missing_labels), concat(", ", required_labels)],
		),
		"namespace": resource_namespace,
		"name": resource_name,
		"kind": resource_kind,
	}}
}

# Labels in metadata
deny contains result if {
	resource_kind == "Deployment"
	missing_labels := required_labels - {k | meta_labels[k]} # perform set difference
	count(missing_labels) > 0
	result := {status_labels.invalid_deployment: {
		"error": status_labels.invalid_labels,
		"severity": "deny",
		"msg": sprintf(
			"%q label(s) missing. %q are required labels in the metadata.labels element.",
			[concat(", ", missing_labels), concat(", ", required_labels)],
		),
		"namespace": resource_namespace,
		"name": resource_name,
		"kind": resource_kind,
	}}
}

# Resources missing
deny contains result if {
	resource_kind == "Deployment"
	some container in containers
	not container.resources
	result := {status_labels.invalid_deployment: {
		"error": status_labels.invalid_resources,
		"severity": "deny",
		"msg": sprintf(
			"Valid resources element not found in %q container.",
			[container.name],
		),
		"container-name": container.name,
		"container-image": container.image,
		"namespace": resource_namespace,
		"name": resource_name,
		"kind": resource_kind,
	}}
}

# Resources limits missing
deny contains result if {
	resource_kind == "Deployment"
	some container in containers
	not container.resources.limits
	result := {status_labels.invalid_deployment: {
		"error": status_labels.invalid_resources,
		"severity": "warn",
		"msg": sprintf(
			"Valid resources.limits element not found in %q container. Resources: %q",
			[container.name, container.resources],
		),
		"container-name": container.name,
		"container-image": container.image,
		"namespace": resource_namespace,
		"name": resource_name,
		"kind": resource_kind,
	}}
}

# Resources limits cpu missing
deny contains result if {
	resource_kind == "Deployment"
	some container in containers
	not container.resources.limits.cpu
	result := {status_labels.invalid_deployment: {
		"error": status_labels.invalid_resources,
		"severity": "warn",
		"msg": sprintf(
			"Valid resources.limits.cpu element not found in %q container., Resources: %q",
			[container.name, container.resources],
		),
		"container-name": container.name,
		"container-image": container.image,
		"namespace": resource_namespace,
		"name": resource_name,
		"kind": resource_kind,
	}}
}

# Resources limits mem missing
deny contains result if {
	resource_kind == "Deployment"
	some container in containers
	not container.resources.limits.memory
	result := {status_labels.invalid_deployment: {
		"error": status_labels.invalid_resources,
		"severity": "warn",
		"msg": sprintf(
			"Valid resources.limits.memory element not found in %q container. Resources: %q",
			[container.name, container.resources],
		),
		"container-name": container.name,
		"container-image": container.image,
		"namespace": resource_namespace,
		"name": resource_name,
		"kind": resource_kind,
	}}
}

# Resources requests missing
deny contains result if {
	resource_kind == "Deployment"
	some container in containers
	not container.resources.requests
	result := {status_labels.invalid_deployment: {
		"error": status_labels.invalid_resources,
		"severity": "deny",
		"msg": sprintf(
			"Valid resources.requests element not found in %q container. Resources: %q",
			[container.name, container.resources],
		),
		"container-name": container.name,
		"container-image": container.image,
		"namespace": resource_namespace,
		"name": resource_name,
		"kind": resource_kind,
	}}
}

# Resources requests cpu missing
deny contains result if {
	resource_kind == "Deployment"
	some container in containers
	not container.resources.requests.cpu
	result := {status_labels.invalid_deployment: {
		"error": status_labels.invalid_resources,
		"severity": "deny",
		"msg": sprintf(
			"Valid resources.requests.cpu element not found in %q container. Resources: %q",
			[container.name, container.resources],
		),
		"container-name": container.name,
		"container-image": container.image,
		"namespace": resource_namespace,
		"name": resource_name,
		"kind": resource_kind,
	}}
}

# Resources requests mem missing
deny contains result if {
	resource_kind == "Deployment"
	some container in containers
	not container.resources.requests.memory
	result := {status_labels.invalid_deployment: {
		"error": status_labels.invalid_resources,
		"severity": "deny",
		"msg": sprintf(
			"Valid resources.requests.memory element not found in %q container. Resources: %q",
			[container.name, container.resources],
		),
		"container-name": container.name,
		"container-image": container.image,
		"namespace": resource_namespace,
		"name": resource_name,
		"kind": resource_kind,
	}}
}
