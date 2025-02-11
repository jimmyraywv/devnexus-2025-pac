

package grc.image.validation

import rego.v1

deny contains result if {
	# Resource matching
	input.request.kind.kind == "Pod"
	input.request.operation in ["CREATE", "DELETE", "UPDATE"]

	# Condition matching
	some container in input.request.object.spec.containers
	not startswith(container.image, "example.com/")

	# Build result
	# 	result := build_result(input.request, container)

	result := {"container": {
		"severity": "high",
		"msg": "Container sourced from untrusted registry.",
		"name": container.name,
		"image": container.image,
	}}
}

# build_result(request, container) := result if {
# 	data.DEBUG == true
#
# 	result := {"input": {"request": request}, "container": {
# 		"severity": "high",
# 		"msg": "Container sourced from untrusted registry.",
# 		"name": container.name,
# 		"image": container.image,
# 	}}
# }
# build_result(_, container) := result if {
# 	data.DEBUG == false
#
# 	result := {"container": {
# 		"severity": "high",
# 		"msg": "Container sourced from untrusted registry.",
# 		"name": container.name,
# 		"image": container.image,
# 	}}
# }
