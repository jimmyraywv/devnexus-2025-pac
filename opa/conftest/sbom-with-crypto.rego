package main

import rego.v1

default crypto_found := false

crypto_found if {
	count(warn_crypto) > 0
}

warn_crypto contains info if {
	some component in input.components
	purl := component.purl
	ref := component["bom-ref"]
	contains(lower(purl), "crypto")
	info := sprintf("ref: %s", [ref])
}