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
		"msg": "RegEx pattern failed validation",
		"regex_name_pattern_field_method":regex_name_pattern_field_method,
	}}
}

deny contains result if {
	not regex.is_valid(regex_name_pattern_class)

	result := {"opa-policy-issues": {
		"severity": "deny",
		"msg": "RegEx pattern failed validation",
		"regex_name_pattern_class":regex_name_pattern_class,
	}}
}

# Known bad imports
deny contains result if {
	some i in input.imports
	lower(i) in known_bad_imports

	result := {"java-class-issues": {
		"severity": "deny",
		"msg": "Class contains known bad import(s)",
		"import": i,
	}}
}

# Log4j imports
warn contains result if {
	some i in input.imports
	contains(lower(i), "log4j")

	result := {"java-class-issues": {
		"severity": "warn",
		"msg": "Log4j import detected",
		"import": i,
	}}
}

# No package declaration
deny contains result if {
	not input.packageName

	result := {"java-class-issues": {
		"severity": "deny",
		"msg": "Class contains no package declaration",
	}}
}

# No imports
deny contains result if {
	count(input.imports) == 0

	result := {"java-class-issues": {
		"severity": "deny",
		"msg": "Class contains no imports",
		"imports": [],
	}}
}

# No imports
deny contains result if {
	not input.imports

	result := {"java-class-issues": {
		"severity": "deny",
		"msg": "Class contains no imports",
		"imports": [],
	}}
}

# No package name
deny contains result if {
	input.packageName == ""

	result := {"java-class-issues": {
		"severity": "deny",
		"msg": "Class contains no package name",
		"packageName": "",
	}}
}

# Class name doesn't match allowed pattern
deny contains result if {
	not regex.match(regex_name_pattern_class, input.className)

	result := {"java-class-issues": {
		"severity": "deny",
		"msg": "Class name doesn't match allowed pattern",
		"className": input.className,
	}}
}

# Field name doesn't match allowed pattern
deny contains result if {
	some field in input.fields
	not regex.match(regex_name_pattern_field_method, field.fieldName)

	result := {"java-class-issues": {
		"severity": "deny",
		"msg": "Field name doesn't match allowed patter.",
		"field": field.fieldName,
	}}
}

# Method name doesn't match allowd pattern
deny contains result if {
	some method in input.methods
	not regex.match(regex_name_pattern_field_method, method.methodName)

	result := {"java-class-issues": {
		"severity": "deny",
		"msg": "Method name doesn't match allowed pattern",
		"method": method.methodName,
	}}
}

# Do not return null
deny contains result if {
	some method in input.methods
	contains(method.body,"return null;")
	result := {"java-class-issues": {
		"severity": "deny",
		"msg": "Method should not return null",
		"method": method.methodName,
	}}
}

# Deny DES KeyGenerator
deny contains result if {
	some method in input.methods
	contains(method.body,"KeyGenerator.getInstance(\"DES\")")
	result := {"java-class-issues": {
		"severity": "deny",
		"msg": "Method should not use DES encryption key generator",
		"method": method.methodName,
		# "methodBody":method.body,
	}}
}

# Deny DES Cipher
deny contains result if {
	some method in input.methods
	contains(method.body,"Cipher.getInstance(\"DES\")")
	result := {"java-class-issues": {
		"severity": "deny",
		"msg": "Method should not use DES encryption cipher",
		"method": method.methodName,
		# "methodBody":method.body,
	}}
}

# Deny weak AES key size
deny contains result if {
	some method in input.methods
	contains(method.body,"KeyGenerator.getInstance(\"AES\")")
	not contains(method.body, ".init(256)")
	result := {"java-class-issues": {
		"severity": "deny",
		"msg": "Method should use AES encryption with 256 bit key size",
		"method": method.methodName,
		# "methodBody":method.body,
	}}
}

# Warn possible SQL injection without prepared statement
warn contains result if {
	some method in input.methods
	contains(method.body, ".createStatement(")
	# contains(lower(method.body),"\"select")
	not contains(method.body, ".prepareStatement(")
	result := {"java-class-issues": {
		"severity": "warn",
		"msg": "Method has possible SQL injection vulnerability, prepared statement not found",
		"method": method.methodName,
		# "methodBody":method.body,
	}}
}

# Deny possible XXE vuln
deny contains result if {
	# some i in input.imports
	# lower(i) == "javax.xml.parsers.DocumentBuilderFactory"
	some method in input.methods
	contains(method.body,"DocumentBuilderFactory.newInstance()")
	not contains(method.body, ".setFeature(\"http://apache.org/xml/features/disallow-doctype-decl\", true)")
	result := {"java-class-issues": {
		"severity": "deny",
		"msg": "DocumentBuilderFactory missing XXE settings",
		"method": method.methodName,
		# "methodBody":method.body,
	}}
}

# Deny possible XXE vuln
deny contains result if {
	# some i in input.imports
	# lower(i) == "javax.xml.parsers.DocumentBuilderFactory"
	some method in input.methods
	contains(method.body,"DocumentBuilderFactory.newInstance()")
	not contains(method.body, ".setFeature(\"http://xml.org/sax/features/external-general-entities\", false)")
	result := {"java-class-issues": {
		"severity": "deny",
		"msg": "DocumentBuilderFactory missing XXE settings",
		"method": method.methodName,
		# "methodBody":method.body,
	}}
}

# Deny possible XXE vuln
deny contains result if {
	# some i in input.imports
	# lower(i) == "javax.xml.parsers.DocumentBuilderFactory"
	some method in input.methods
	contains(method.body,"DocumentBuilderFactory.newInstance()")
	not contains(method.body, ".setFeature(\"http://xml.org/sax/features/external-parameter-entities\", false)")
	result := {"java-class-issues": {
		"severity": "deny",
		"msg": "DocumentBuilderFactory missing XXE settings",
		"method": method.methodName,
		# "methodBody":method.body,
	}}
}

# Deny possible XXE vuln
deny contains result if {
	# some i in input.imports
	# lower(i) == "javax.xml.parsers.DocumentBuilderFactory"
	some method in input.methods
	contains(method.body,"DocumentBuilderFactory.newInstance()")
	not contains(method.body, ".setFeature(\"http://apache.org/xml/features/nonvalidating/load-external-dtd\", false)")
	result := {"java-class-issues": {
		"severity": "deny",
		"msg": "DocumentBuilderFactory missing XXE settings",
		"method": method.methodName,
		# "methodBody":method.body,
	}}
}

# Deny possible XXE vuln
deny contains result if {
	# some i in input.imports
	# lower(i) == "javax.xml.parsers.DocumentBuilderFactory"
	some method in input.methods
	contains(method.body,"DocumentBuilderFactory.newInstance()")
	not contains(method.body, ".setXIncludeAware(false)")
	result := {"java-class-issues": {
		"severity": "deny",
		"msg": "DocumentBuilderFactory missing XXE settings",
		"method": method.methodName,
		# "methodBody":method.body,
	}}
}

# Deny possible XXE vuln
deny contains result if {
	# some i in input.imports
	# lower(i) == "javax.xml.parsers.DocumentBuilderFactory"
	some method in input.methods
	contains(method.body,"DocumentBuilderFactory.newInstance()")
	not contains(method.body, ".setExpandEntityReferences(false)")
	result := {"java-class-issues": {
		"severity": "deny",
		"msg": "DocumentBuilderFactory missing XXE settings",
		"method": method.methodName,
		# "methodBody":method.body,
	}}
}


