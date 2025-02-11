# OPA AuthZ policy
package system.authz

import rego.v1

# permissions := {"admin": {"path": "*"}, "user": {"path": "v1/data/*"}}

# tokens := {
# 	"918C0C92-ADA0-4107-ADDA-5783CD7B62DB": {"roles": ["admin"]},
# 	"4C3D5313-8982-4ACD-9D0A-9D5802812480": {"roles": ["user"]},
# }

# default allow := false
default allow := {
	"allowed": false, #disallow requests by default
	"reason": "unauthorized resource access",
}

allow := {"allowed": true} if {
	input.method == "POST"
	input.path == [""]
}

allow := {"allowed": true} if {
	some permission
	lookup_permissions[permission]
	permission.path[0] == "*"
}

allow := {"allowed": true} if { #allow POST for specific path
	input.method == "POST"
	some permission
	lookup_permissions[permission]
	# permission.path == "v1/data/*"
	input.path == permission.path
}

# lookup_permissions[permission] {
# 	token := tokens[input.identity]
# 	role := token.roles[_]
# 	permission := permissions[role]
# }

lookup_permissions[permission] if {
	some token in data.tokens
	id := token[input.identity]
	role := id.roles[_]
	permission := data.permissions[role]
}
