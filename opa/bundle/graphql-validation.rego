package grc.graphql.validation

import rego.v1

valid_object_types := {"Query"}

deny contains result if {
	some o in input.objectTypes
	not o.name in valid_object_types

	result := {"graphql-issues": {
		"severity": "deny",
		"msg": "Invalid object type",
		"objectType": o.name,
	}}
}
