package main

import rego.v1

bad_severities := {"high", "critical"}

default compliant := false

compliant if {
	count(violation_high_critical) == 0
}

violation_high_critical contains info if {
	some vulnerability in input.vulnerabilities
	some rating in vulnerability.ratings
	some affect in vulnerability.affects
	sev := rating.severity
	sev in bad_severities
	ref := affect.ref
	id := vulnerability.id
	url := vulnerability.source.url
	info := sprintf("severity: %s, id: %s, ref: %s, url: %s", [sev, id, ref, url])
}
