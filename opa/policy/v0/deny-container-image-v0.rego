

package grc.image.validation.v0

import rego.v1

deny contains result if {
	# Resource matching
	input.request.kind.kind == "Pod"
	input.request.operation in ["CREATE", "DELETE", "UPDATE"]

	# Condition matching
	some container in input.request.object.spec.containers
	not startswith(container.image, "example.com/")

	result := {"container": {
		"severity": "high",
		"msg": "Container sourced from untrusted registry.",
		"name": container.name,
		"image": container.image,
	}}
}

