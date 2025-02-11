package main

import rego.v1

bad_dependencies := {
	"dontusethis-core",
}

allowed_java_versions := {
	"11",
	"17",
	"21",
}

plugin_list := input.project.build.plugins
dependency_list := input.project.dependencies.dependency
s := input.project.properties["maven.compiler.source"]
t := input.project.properties["maven.compiler.target"]

deny contains msg if {
	expected_version := "3.6.0"

	some p in plugin_list
	p.artifactId == "maven-shade-plugin"
	not p.version == expected_version
	msg = sprintf("in %s \n--- maven-plugin must have the version: %s \n", [p.artifactId, expected_version])
}

deny contains msg if {
	some p in plugin_list
	p.artifactId == "maven-shade-plugin"
	not p.executions.execution.goals.goal == "shade"
	msg = sprintf("in %s \n--- There must be defined 'shade goal' for maven-shade-plugin \n", [p.artifactId])
}

deny contains msg if {
	not s in allowed_java_versions
	msg = sprintf("Java version must be in %q for maven.compiler.source=%q", [allowed_java_versions, s])
}

deny contains msg if {
	not t in allowed_java_versions
	msg = sprintf("Java version must be in %q for maven.compiler.target=%q", [allowed_java_versions, t])
}

warn contains msg if {
	not s == t
	msg = sprintf("Java versions should match: maven.compiler.source = %q and maven.compiler.target = %q.", [s, t])
}

warn contains msg if {
	some d in dependency_list
	d.artifactId in bad_dependencies
	msg = sprintf("%s is considered a potentially dangerous dependency.", [d.artifactId])
}