package grc.git.validation

import rego.v1

allowed_branches := {"main"}

allowed_java_versions := {"11", "17"}

allowed_java_distros := {"corretto", "temurin", "zulu"}

# Deny invalid PUSH branches
deny contains result if {
	some branch in input.on.push.branches
	not lower(branch) in allowed_branches

	result := {"git-wf-issues": {
		"severity": "deny",
		"msg": "Invalid PUSH trigger branch",
		"branch": branch,
	}}
}

# Deny invalid PR branches
deny contains result if {
	some branch in input.on.pull_request.branches
	not lower(branch) in allowed_branches

	result := {"git-wf-issues": {
		"severity": "deny",
		"msg": "Invalid PR trigger branch",
		"branch": branch,
	}}
}

# Deny invalid Java version
deny contains result if {
	some step in input.jobs.build.steps

	# with keyword and hyphenated java-version must be moved from dot-notation to brackets
	not lower(step["with"]["java-version"]) in allowed_java_versions

	result := {"git-wf-issues": {
		"severity": "deny",
		"msg": "Invalid Java version",
		"javaVersion": step["with"]["java-version"],
	}}
}

# Deny invalid Java distro
deny contains result if {
	some step in input.jobs.build.steps

	# with keyword must be moved from dot-notation to brackets
	not lower(step["with"].distribution) in allowed_java_distros

	result := {"git-wf-issues": {
		"severity": "deny",
		"msg": "Invalid Java distribution",
		"javaDistribution": step["with"].distribution,
	}}
}
