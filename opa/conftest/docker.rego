package main

import rego.v1

places_where_secrets_hide := {
	"secret",
	"apikey",
	"access",
	"pass",
	"token",
}

bad_adds := {"example.com"}

bad_args := {"example.com"}

bad_runs := {
	"wget",
	"curl",
}

maybe_bad_runs := {
	"apk",
	"yum",
}

known_bad_versions := {
	"bad",
	"verybad",
	"horid",
	"career-ending",
	"muliple-opportunities-for-sadness",
}

# secrets bad
deny_secrets contains msg if {
	some x in input
	x.Cmd == "env"
	value := x.Value[0]
	some s in places_where_secrets_hide
	contains(lower(value), s)
	msg := sprintf("secrets (%q) found: %q", [s, value])
}

# versions bad
deny_bad_versions contains msg if {
	some x in input
	x.Cmd == "from"
	value := x.Value[0]
	some v in known_bad_versions
	contains(lower(value), v)

	# image := split(value, ":")
	# lower(image[1]) == "latest"
	msg := sprintf("FROM with bad version (%q) found: %q", [v, value])
}

# latest bad
deny_latest contains msg if {
	some x in input
	x.Cmd == "from"
	value := x.Value[0]
	endswith(lower(value), "latest")

	# image := split(value, ":")
	# lower(image[1]) == "latest"
	msg := sprintf("FROM with latest found: %q", [value])
}

# no version bad
deny_no_version contains msg if {
	some x in input
	x.Cmd == "from"
	value := x.Value[0]
	count(split(value, ":")) == 1
	msg := sprintf("Image with no version found: %q", [value])
}

# add maybe bad
warn_add contains msg if {
	some x in input
	x.Cmd == "add"
	value := x.Value[0]
	msg := sprintf("ADD found: %q", [value])
}

# run apk maybe bad
warn_run_apk contains msg if {
	some x in input
	x.Cmd == "run"
	value := x.Value[0]
	contains(lower(value), "apk")
	msg := sprintf("RUN with maybe bad commands found: %q", [value])
}

# run with curl/wget bad
deny_curl_wget contains msg if {
	some x in input
	x.Cmd == "run"
	value := x.Value[0]
	some run in bad_runs
	contains(lower(value), run)
	msg := sprintf("RUN with bad commands, %q, found: %q", [bad_runs, value])
}

# add with example.com bad
deny_add_domain contains msg if {
	some x in input
	x.Cmd == "add"
	value := x.Value[0]
	some add in bad_adds
	contains(lower(value), add)
	msg := sprintf("ADD with bad source, %q, found: %q", [bad_adds, value])
}

# example.com bad
deny_arg contains msg if {
	some x in input
	x.Cmd == "arg"
	value := x.Value[0]
	some barg in bad_args
	contains(lower(value), barg)
	msg := sprintf("ARG with bad args, %q, found: %q", [bad_args, value])
}
