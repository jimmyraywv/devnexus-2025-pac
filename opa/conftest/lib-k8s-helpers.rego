package lib.k8s.helpers

meta_labels := metadata.labels

temp_labels := spec.template.metadata.labels

deployment_error := "DEPLOYMENT_INVALID"

deployment_containers := spec.template.spec.containers

required_deployment_labels := {"app", "owner", "env"}

deployment_role := spec.template.metadata.annotations["iam.amazonaws.com/role"]

resource_id := sprintf("%v/%v/%v", [
	resource_namespace,
	resource_name,
	resource_kind,
])

rresource_name := input.request.metadata.name

resource_namespace := input.request.metadata.namespace

resource_kind := input.request.kind.kind
