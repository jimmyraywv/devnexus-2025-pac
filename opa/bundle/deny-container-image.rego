package grc.image.validation

import rego.v1

allowed_image_sources := {"artifactory","jimmys-place"}
allowed_ops := {"CREATE", "DELETE", "UPDATE"}

deny contains result if {
	# Resource matching
	input.request.kind.kind == "Pod"
	input.request.operation in allowed_ops

	# Condition matching
	some container in input.request.object.spec.containers
	some source in allowed_image_sources
	not startswith(container.image, source)

	result := {"container": {
		"severity": "deny",
		"msg": "Container sourced from untrusted source.",
		"name": container.name,
		"image": container.image,
		"trustedSources":allowed_image_sources
	}}
}


