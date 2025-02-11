package grc.java.validation_test

import rego.v1

import data.grc.java.validation

data_no_imports := {"imports": []}

data_no_package := {"packageName": ""}

data_bad_imports := {"imports": [,
	"io.jimmyray.thisimportisbad",
	"io.jimmyray.thisimportisworse",
]}

data_good := {
	"packageName": "org.jimmyray.mongo.data.model",
	"imports": ["org.jimmyray.mongo.framework.Strings"],
}

# Unit test rule with data_no_imports
test_deny if {
	print("TEST: NO_IMPORTS")
	validation.deny[result] with input as data_no_imports
	print(result)
}

# Unit test rule with data_no_package
test_deny if {
	print("TEST: NO_PACKAGE")
	validation.deny[result] with input as data_no_package
	print(result)
}

# Unit test rule with data_bad_imports
test_deny if {
	print("TEST: BAD_IMPORTS")
	result := validation.deny with input as data_bad_imports
	print(result)
}

# Unit test with data_good
test_deny if {
	print("TEST: GOOD_DATA")
	result := validation.deny with input as data_good
	print(result)
	result == set()
}