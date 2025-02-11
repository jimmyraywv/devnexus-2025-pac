package grc.sbom.validation

import rego.v1

# Syft ontainer image
warn_crypto contains result if {
	some component in input.components
	contains(lower(component.purl), "crypto")

	result := {"sbom-issues": {
		"severity": "warn",
		"msg": "SBOM contains crypto libs",
		"packageUrl": component.purl,
	}}
}

# Syft Java jar
warn_dependencies contains result if {
	some d in input.dependencies[0].dependsOn
	contains(lower(d), "log4j")

	result := {"sbom-issues": {
		"severity": "warn",
		"msg": "SBOM contains log4j dependencies",
		"dependency": d,
	}}
}

bad_severities := {"high", "critical"}

# Grype container image
deny_high_critical contains result if {
	some vulnerability in input.vulnerabilities
	some rating in vulnerability.ratings
	rating.severity in bad_severities

	result := {"sbom-critical-high-vulns": {
		"severity": "deny",
		"msg": "SBOM contains high/critical vuln(s)",
		"cveId": vulnerability.id,
		"cveNvdCpe": vulnerability.source.url,
		"ratings": vulnerability.ratings,
	}}
}
