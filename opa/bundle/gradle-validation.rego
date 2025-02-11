package grc.gradle.validation

import rego.v1

valid_application_keys := {"mainClass", "applicationName", "executableDir", "version"}

valid_java_versions := {"11", "18"}

valid_dependency_configuration_types := {
	"api",
	"implementation",
	"compileOnly",
	"compileOnlyApi",
	"runtimeOnly",
	"testImplementation",
	"testCompileOnly",
	"testRuntimeOnly",
}

known_bad_repos := {"jcenter()", "jimmys-place"}

# Vailidate Java version
deny contains result if {
	some entry in input.java
	not entry.sourceCompatibility in valid_java_versions

	result := {"gradle-issues": {
		"severity": "deny",
		"msg": "Java version not valid",
		"version": entry.sourceCompatibility,
		"validVersions": valid_java_versions,
	}}
}

# Vailidate application mainClass is present
deny contains result if {
	# Use https://docs.styra.com/regal/rules/style/comprehension-term-assignment
	keys := [entry.key | some entry in input.application]
	not "mainClass" in keys

	result := {"gradle-issues": {
		"severity": "deny",
		"msg": "mainClass not found in application statement",
		"applicationKeys": keys,
	}}
}

# Vailidate application keys are valid
deny contains result if {
	some entry in input.application
	not entry.key in valid_application_keys

	result := {"gradle-issues": {
		"severity": "deny",
		"msg": sprintf("Application key (%q) not allowed", [entry.key]),
		"application": input.application,
		"allowedApplicationKeys": valid_application_keys,
	}}
}

# Validate that application statement exists if application plugin exists
deny contains result if {
	some plugin in input.plugins
	plugin.id == "application"
	not input.application

	result := {"gradle-issues": {
		"severity": "deny",
		"msg": "application plugin exists without application statement",
	}}
}

# Validate dependency config types
deny contains result if {
	some d in input.dependencies
	not d.configurationType in valid_dependency_configuration_types

	result := {"gradle-issues": {
		"severity": "deny",
		"msg": "dependency confifguration type is invalid",
		"dependency": d,
		"configurationType": d.configurationType,
		"validValues": valid_dependency_configuration_types,
	}}
}

# Validate dependency versions - absent
deny contains result if {
	some d in input.dependencies
	d.configurationType == "implementation"
	not "version" in object.keys(d)

	result := {"gradle-issues": {
		"severity": "deny",
		"msg": "dependency version cannot be empty",
		"dependency": d,
	}}
}

# Validate dependency versions - latest
deny contains result if {
	some d in input.dependencies
	d.configurationType == "implementation"
	d.version
	lower(d.version) == "latest"

	result := {"gradle-issues": {
		"severity": "deny",
		"msg": "dependency version cannot be latest",
		"dependency": d,
		"version": d.version,
	}}
}

# Validate repos not in bad repos
deny contains result if {
	some r in input.repositories
	r in known_bad_repos

	result := {"gradle-issues": {
		"severity": "deny",
		"msg": "repository is found in known bad repository list",
		"repo": r,
		"knownBadRepos": known_bad_repos,
	}}
}
