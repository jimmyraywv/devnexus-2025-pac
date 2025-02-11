package grc.java.validation

import rego.v1

known_bad_imports := {"io.jimmyray.thisimportisbad", "io.jimmyray.thisimportisworse"}

# Begin with lowercase, no special chars
regex_name_pattern_field_method := "^[a-z][A-Za-z0-9]+$"

# Begin with uppercase, no special chars
regex_name_pattern_class := "^[A-Z][A-Za-z0-9]+$"

# Vailidate RegEx patterns
deny contains result if {
	not regex.is_valid(regex_name_pattern_field_method)

	result := {"opa-policy-issues": {
		"severity": "deny",
		"msg": "RegEx pattern failed validation.",
		"regex_name_pattern_field_method":regex_name_pattern_field_method,
	}}
}

deny contains result if {
	not regex.is_valid(regex_name_pattern_class)

	result := {"opa-policy-issues": {
		"severity": "deny",
		"msg": "RegEx pattern failed validation.",
		"regex_name_pattern_class":regex_name_pattern_class,
	}}
}

# Known bad imports
deny contains result if {
	some i in input.imports
	lower(i) in known_bad_imports

	result := {"java-class-issues": {
		"severity": "deny",
		"msg": "Class contains known bad import(s).",
		"import": i,
	}}
}

# No package declaration
deny contains result if {
	not input.packageName

	result := {"java-class-issues": {
		"severity": "deny",
		"msg": "Class contains no package declaration.",
	}}
}

# No package name
deny contains result if {
	input.packageName == ""

	result := {"java-class-issues": {
		"severity": "deny",
		"msg": "Class contains no package declaration.",
		"package": "",
	}}
}

# No imports
deny contains result if {
	count(input.imports) == 0

	result := {"java-class-issues": {
		"severity": "deny",
		"msg": "Class contains no imports.",
		"imports": [],
	}}
}

# Field name doesn't match allowd pattern
deny contains result if {
	some field in input.fields
	not regex.match(regex_name_pattern_field_method, field.fieldName)

	result := {"java-class-issues": {
		"severity": "warn",
		"msg": "Field name doesn't match allowed pattern.",
		"field": field.fieldName,
	}}
}

# Method name doesn't match allowd pattern
deny contains result if {
	some method in input.methods
	not regex.match(regex_name_pattern_field_method, method.methodName)

	result := {"java-class-issues": {
		"severity": "warn",
		"msg": "Method name doesn't match allowed pattern.",
		"method": method.methodName,
	}}
}

# Class name doesn't match allowd pattern
deny contains result if {
	not regex.match(regex_name_pattern_class, input.className)

	result := {"java-class-issues": {
		"severity": "warn",
		"msg": "Class name doesn't match allowed pattern.",
		"method": input.className,
	}}
}


