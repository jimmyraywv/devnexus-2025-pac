package main

import rego.v1

places_where_secrets_hide := {
	"secret",
	"apikey",
	"access",
	"pass",
	"token",
}

# secrets bad
warn_secrets contains msg if {
	some name
	value := input[name]
	contains(lower(name), places_where_secrets_hide[_])
	msg := sprintf("secrets found: %q=%q", [name, value])
}
