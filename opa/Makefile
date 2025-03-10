.DEFAULT_GOAL := help

ANTLR_CMD:=java -jar ~/.m2/repository/org/antlr/antlr4/4.13.2/antlr4-4.13.2-complete.jar
ANTLR_CSV_GRAMMAR:=../grammars/csv/CSV.g4
ANTLR_CSV_PACKAGE:=compliance.parser.antlr.csv.gen
ANTLR_CSV_TARGET:=../java/parsing-java/src/main/java/compliance/parser/antlr/csv/gen
ANTLR_GRADLE_GRAMMAR:=../grammars/Gradle.g4
ANTLR_GRADLE_PACKAGE:=compliance.parser.antlr.gradle.gen
ANTLR_GRADLE_TARGET:=../java/parsing-java/src/main/java/compliance/parser/antlr/gradle/gen
ANTLR_GRAPHQL_GRAMMAR:=../grammars/GraphQL.g4
ANTLR_GRAPHQL_PACKAGE:=compliance.parser.antlr.graphql.gen
ANTLR_GRAPHQL_TARGET:=../java/parsing-java/src/main/java/compliance/parser/antlr/graphql/gen
CSV_JSON_SCHEMA_TARGET:=../java/io/schemas/csv-schema.json
CSV_JSON_TARGET:=../java/io/parsed-csv.json
CSV_SOURCE?=<TBD>
GIT_WF_SOURCE:=git-workflows/ci-build.yaml
GRADLE_JSON_SCHEMA_TARGET:=../java/io/schemas/gradle-schema.json
GRADLE_JSON_TARGET:=../java/io/parsed-gradle.json
GRADLE_SOURCE:=../java/io/build.gradle
GRAPHQL_JSON_SCHEMA_TARGET:=../java/io/schemas/graphql-schema.json
GRAPHQL_JSON_TARGET:=../java/io/parsed-graphql.json
GRAPHQL_SOURCE?=<TBD>
JAVA_JSON_SCHEMA_TARGET:=../java/io/schemas/java-schema.json
JAVA_JSON_TARGET:=../java/io/parsed-java.json
JAVA_PARSER_JAR:=~/.m2/repository/compliance/parser/1.0-SNAPSHOT/parser-1.0-SNAPSHOT-shaded.jar
JAVA_PROJECT:=../java/parsing-java
JAVA_SOURCE:=../java/io/Customer.java
OPA_ADMIN_TOKEN:=918C0C92-ADA0-4107-ADDA-5783CD7B62DB
OPA_EVAL_GRADLE_POLICY:=data.grc.gradle.validation.deny
OPA_EVAL_JAVA_POLICY:=data.grc.java.validation.deny
OPA_GIT_WF_POLICY:=grc/git/validation/deny
OPA_GRADLE_POLICY_SOURCE:=bundle/gradle-validation.rego
OPA_GRADLE_POLICY:=grc/gradle/validation/deny
OPA_GRAPHQL_POLICY:=grc/graphql/validation/deny
OPA_HOST:=localhost
OPA_JAVA_POLICY_DENY:=grc/java/validation/deny
OPA_JAVA_POLICY_WARN:=grc/java/validation/warn
OPA_JAVA_POLICY_SOURCE:=bundle/java-validation.rego
OPA_K8S_DEPLOYMENT_POLICY:=grc/k8s/deployment/validation/deny
OPA_K8S_IMAGE_POLICY:=grc/image/validation/deny
OPA_PORT:=8181
OPA_PROTOCOL:=http://
OPA_SBOM_DENY_VULNS_POLICY:=grc/sbom/validation/deny_high_critical
OPA_SBOM_WARN_CRYPTO_POLICY:=grc/sbom/validation/warn_crypto
OPA_SBOM_WARN_DEPENDENCIES_POLICY:=grc/sbom/validation/warn_dependencies
OPA_SOCKET:=localhost:8181
OPA_URL:=$(OPA_PROTOCOL)$(OPA_SOCKET)
OPA_V0_DATA:=v0/data
OPA_V1_DATA:=v1/data
OPA_V1_POLICIES:=v1/policies
OPA_WASM_BUNDLE?=wasm/bundle.tar.gz
OPA_WASM_POLICY?=wasm/policy.wasm
SBOM_JSON_TARGET:=../java/io/sbom-syft.json
SYFT_IMAGE_SOURCE?=<TBD> # Requires Docker running, based on k8s 1.31 kube-proxy container image
SYFT_JAR_SOURCE:=~/.m2/repository/compliance/parser/1.0-SNAPSHOT/parser-1.0-SNAPSHOT-shaded.jar
TIMESTAMP_MASK:='+%Y-%m-%d %H:%M:%S'

##################################
# Git info
##################################
GIT_URL ?= $(shell git remote get-url --push origin)
GIT_COMMIT ?= $(shell git rev-parse HEAD)
#GIT_SHORT_COMMIT := $(shell git rev-parse --short HEAD)
TIMESTAMP := $(shell date $(TIMESTAMP_MASK))

VERSION_HASH := $(shell echo $(GIT_COMMIT)|cut -c 1-10)
# $(info [$(VERSION_HASH)])
VERSION_FROM_FILE ?= $(shell head -n 1 ../version)
VERSION ?=

ifeq ($(strip $(VERSION_HASH)),)
VERSION := $(VERSION_FROM_FILE)
else
VERSION := $(VERSION_FROM_FILE)-$(VERSION_HASH)
endif

##@ General

.PHONY: help
help:	## Display this help
	@awk 'BEGIN {FS = ":.*##"; printf "\nUsage:\n  make \033[36m<target>\033[0m\n"} /^[a-zA-Z_0-9-]+:.*?##/ { printf "  \033[36m%-15s\033[0m %s\n", $$1, $$2 } /^##@/ { printf "\n\033[1m%s\033[0m\n", substr($$0, 5) } ' $(MAKEFILE_LIST)

##################################
# Metadata
##################################
##@ Metadata

.PHONY: meta
meta:	## Generate metadata, mostly used by other targets
	$(info    [METADATA])
	$(info    timestamp: [$(TIMESTAMP)])
	$(info    git commit: [$(GIT_COMMIT)])
	$(info    git URL: [$(GIT_URL)])
	$(info    Version: [$(VERSION)])
# -@echo
#	$(info	)

##################################
# Git WF with OPA exec
##################################
##@ Git WF validation

.PHONY:	opa-git-wf-json
opa-git-wf-json:	## Call `opa exec` for Git validation
	cat $(GIT_WF_SOURCE) | yq e -o json | \
	opa exec --decision $(OPA_GIT_WF_POLICY) -b bundle --stdin-input | jq .

.PHONY:	opa-git-wf-yaml
opa-git-wf-yaml:	## Call `opa exec` for Git validation on static file
	opa exec $(GIT_WF_SOURCE) --decision $(OPA_GIT_WF_POLICY) -b bundle | jq .

.PHONY:	post-git-wf-json
post-git-wf-json:	## Post Git WF YAML to OPA server
	cat $(GIT_WF_SOURCE) | yq e -o json | \
	curl -s $(OPA_URL)/$(OPA_V0_DATA)/$(OPA_GIT_WF_POLICY) \
	--http1.1 \
	-H 'Content-Type: application/json' \
	-H 'Accept: application/json' \
    --data-binary @- \
	| jq .

.PHONY:	post-git-wf-yaml
post-git-wf-yaml:	## Post Git WF YAML to OPA server
	cat $(GIT_WF_SOURCE) | yq . | \
	curl -s $(OPA_URL)/$(OPA_V0_DATA)/$(OPA_GIT_WF_POLICY) \
	--http1.1 \
	-H 'Content-Type: application/x-yaml' \
	-H 'Accept: application/json' \
    --data-binary @- \
	| jq .

.PHONY:	parse-git-wf-ct
parse-git-wf-ct:	## Parse Git WF YAML with conftest
	conftest parse git-workflows/ci-build.yaml | jq .

.PHONY:	parse-git-wf-yq
parse-git-wf-yq:	## Parse Git WF YAML with yq
	cat git-workflows/ci-build.yaml|yq e -o json|jq .

.PHONY:	parse-countries
parse-countries:	## Parse countries to illustrate the Norway problem
	conftest parse countries/countries.yaml | jq .

##################################
# Syft/Grype with OPA exec
##################################
##@ Syft/Grype operations

.PHONY:	syft-image
syft-image:	## Syft container image from Docker
	syft $(SYFT_IMAGE_SOURCE) -o cyclonedx-json | jq . | \
	opa exec --decision $(OPA_SBOM_WARN_CRYPTO_POLICY) -b bundle --stdin-input | jq .

.PHONY:	syft-jar
syft-jar:	## Syft JAR in local Maven repo
	syft $(SYFT_JAR_SOURCE) -o cyclonedx-json | jq . | \
	opa exec --decision $(OPA_SBOM_WARN_DEPENDENCIES_POLICY) -b bundle --stdin-input | jq .

.PHONY:	grype-image
grype-image:	## Grype image, and pass SBOM with vulns to OPA
	grype --by-cve -o cyclonedx-json $(SYFT_IMAGE_SOURCE) | jq .| \
	opa exec --decision $(OPA_SBOM_DENY_VULNS_POLICY) -b bundle --stdin-input | jq .

##################################
# OPA
##################################
##@ OPA operations (server, API, exec, eval, etc.)

.PHONY:	start-server
start-server:	## Start OPA server, leaves make process running
	opa run -s -l debug --bundle bundle --addr $(OPA_SOCKET) --disable-telemetry

.PHONY:	start-server-auth
start-server-auth:	## Start OPA server with token authz settings
	opa run -s -l debug --bundle bundle --addr $(OPA_SOCKET) --disable-telemetry \
	--authentication=token --authorization=basic

.PHONY:	stop-server
stop-server:	## Stop OPA sever from other terminal sessions
	@./scripts/kill-server.sh > /dev/null 2>&1

.PHONY:	query-server-data
query-server-data:	## Query OPA server data
	curl $(OPA_URL)/$(OPA_V1_DATA) | jq .

.PHONY:	query-server-policies
query-server-policies:	## Query OPA server policies
	curl $(OPA_URL)/$(OPA_V1_POLICIES) | jq .

.PHONY:	view-k8s-admission-review
view-k8s-admission-review:	## View the k8s admission review JSON
	jq . k8s-admission/review-v1.json

.PHONY:	view-k8s-admission-review-yaml
view-k8s-admission-review-yaml:	## View the k8s admission review YAML
	yq k8s-admission/review-v1.yaml

.PHONY:	post-k8s-admission-review
post-k8s-admission-review:	## Post k8s admission review JSON to OPA server with metrics
	curl -s $(OPA_URL)/$(OPA_V1_DATA)/$(OPA_K8S_IMAGE_POLICY)?metrics \
	-H "Authorization: Bearer $(OPA_ADMIN_TOKEN)" \
	--data-binary @k8s-admission/review-v1.json \
	| jq .

.PHONY:	post-k8s-admission-review-yaml
post-k8s-admission-review-yaml:	## Post k8s admission review YAML to OPA server
	curl -s $(OPA_URL)/$(OPA_V1_DATA)/$(OPA_K8S_IMAGE_POLICY)?metrics \
	--http1.1 \
	-H 'Content-Type: application/x-yaml' \
	-H 'Accept: application/json' \
	-H "Authorization: Bearer $(OPA_ADMIN_TOKEN)" \
    --data-binary @k8s-admission/review-v1.yaml \
	| jq .

.PHONY:	post-deployment-yaml
post-deployment-yaml:	## Post k8s deployment YAML to OPA server
	curl -s $(OPA_URL)/$(OPA_V0_DATA)/$(OPA_K8S_DEPLOYMENT_POLICY)?metrics \
	--http1.1 \
	-H 'Content-Type: application/x-yaml' \
	-H 'Accept: application/json' \
	-H "Authorization: Bearer $(OPA_ADMIN_TOKEN)" \
    --data-binary @conftest/deployment.yaml \
	| jq .

.PHONY:	opa-exec-image
opa-exec-image:	## Call `opa exec` for image validation
	opa exec k8s-admission/review-v0.json --decision $(OPA_K8S_IMAGE_POLICY) -b bundle | jq .

.PHONY:	opa-exec-java
opa-exec-java:	## Call `opa exec` for Java class validation
	java -jar $(JAVA_PARSER_JAR) -f $(JAVA_SOURCE) -t java | \
	opa exec -I --decision $(OPA_JAVA_POLICY_DENY) -b bundle | jq .

.PHONY:	opa-exec-java-static
opa-exec-java-static:	## Call `opa exec` for Java class validation
	opa exec $(JAVA_JSON_TARGET) --decision $(OPA_JAVA_POLICY_DENY) -b bundle | jq .
	
.PHONY:	opa-exec-gradle-static
opa-exec-gradle-static:	## Call `opa exec` for Gradle validation
	opa exec $(GRADLE_JSON_TARGET) --decision $(OPA_GRADLE_POLICY) -b bundle | jq .

.PHONY:	opa-exec-graphql-static
opa-exec-graphql-static:	## Call `opa exec` for GraphQL validation
	opa exec $(GRAPHQL_JSON_TARGET) --decision $(OPA_GRAPHQL_POLICY) -b bundle | jq .

.PHONY:	opa-test
opa-test:	## Call `opa test` to test policies with different data inputs
	opa test bundle -v

.PHONY:	opa-eval-java-with-json-schema
opa-eval-java-with-json-schema:	## Call `opa eval` for Java class validation with JSON schema
	opa eval -f json -i $(JAVA_JSON_TARGET) -d $(OPA_JAVA_POLICY_SOURCE) -s $(JAVA_JSON_SCHEMA_TARGET) \
	$(OPA_EVAL_JAVA_POLICY) | jq .

.PHONY:	opa-eval-gradle-with-json-schema
opa-eval-gradle-with-json-schema:	## Call `opa eval` for Gradle validation with JSON schema
	opa eval -f json -i $(GRADLE_JSON_TARGET) -d $(OPA_GRADLE_POLICY_SOURCE) -s $(GRADLE_JSON_SCHEMA_TARGET) \
	$(OPA_EVAL_GRADLE_POLICY) | jq .

##################################
# CONFTEST
##################################
##@ Conftest OPA code artifact scans

.PHONY: ct-docker
ct-docker:	ct-parse-docker	ct-test-docker	## Parse and test Dockerfile

.PHONY: ct-test-docker
ct-test-docker:	## Scan Dockerfile for bad stuff
	conftest test -p conftest/docker.rego conftest/Dockerfile.bad

.PHONY: ct-parse-docker
ct-parse-docker:	## Parse Dockerfile to JSON
	conftest parse conftest/Dockerfile.bad | jq .

.PHONY: ct-test-k8s-deployment
ct-test-k8s-deployment:	## Scan k8s manifest for latest
	conftest test -p conftest/deployment.rego conftest/deployment.yaml -o github

.PHONY: ct-java-properties
ct-java-properties:		ct-parse-java-properties	ct-test-java-properties	## Parse and test Java properties

.PHONY: ct-test-java-properties
ct-test-java-properties:	## Scan Java properties for potential secrets
	conftest test -p conftest/properties.rego conftest/bad.properties

.PHONY: ct-parse-java-properties
ct-parse-java-properties:	## Parse Java properties
	conftest parse conftest/bad.properties | jq .

.PHONY: ct-test-sbom-vulns
ct-test-sbom-vulns:	## Scan SBOM for vulnerabilities
	conftest test -p conftest/sbom-with-vulns.rego conftest/sbom-with-vulns.json

.PHONY: ct-test-sbom-crypto
ct-test-sbom-crypto:	## Scan SBOM for crypto
	conftest test -p conftest/sbom-with-crypto.rego conftest/sbom-with-crypto.json

.PHONY: ct-maven-pom
ct-maven-pom:	ct-parse-maven-pom	ct-test-maven-pom	## Parse and test maven POM

.PHONY: ct-test-maven-pom
ct-test-maven-pom:	## Scan Maven POM for issues
	conftest test -p conftest/pom.rego conftest/bad-pom.xml

.PHONY: ct-parse-maven-pom
ct-parse-maven-pom:	## Parse Maven POM XML to JSON
	conftest parse conftest/bad-pom.xml | jq .

.PHONY:	ct-git-wf-static
ct-git-wf-static:	## Git validation on static file
	conftest test -p bundle/git-wf-validation.rego $(GIT_WF_SOURCE) --show-builtin-errors

.PHONY: ct-iac-tf-vars
ct-iac-tf-vars:
	conftest test -p conftest/tf-vars.rego conftest/terraform.tfvars \
	-n examples.ch11.terraform -o github

.PHONY: ct-iac-tf-plan
ct-iac-tf-plan:
	conftest test -p conftest/tfplan.rego conftest/long-tfplan.json \
	-n examples.ch11.terraform -o github

##################################
# OPA Java SDK
##################################
##@ OPA Java SDK Ops

.PHONY: java-opa-sdk-validation
java-opa-sdk-validation:	java-opa-sdk-validation-deny	java-opa-sdk-validation-warn	## Use OPA server and OPA Java SDK to validate Java class parsed into JSON, deny and warn modes
	
.PHONY: java-opa-sdk-validation-deny
java-opa-sdk-validation-deny:	## Use OPA server and OPA Java SDK to validate Java class parsed into JSON
	@java -jar $(JAVA_PARSER_JAR) \
    -f $(JAVA_SOURCE) -p $(OPA_JAVA_POLICY_DENY) -t java | jq .

.PHONY: java-opa-sdk-validation-warn
java-opa-sdk-validation-warn:	## Use OPA server and OPA Java SDK to validate Java class parsed into JSON, warn mode
	@java -jar $(JAVA_PARSER_JAR) \
    -f $(JAVA_SOURCE) -p $(OPA_JAVA_POLICY_WARN) -t java | jq .

.PHONY: java-opa-sdk-validation-wasm
java-opa-sdk-validation-wasm:	## Use OPA wasm policy and OPA Java SDK to validate Java class parsed into JSON
	@java -jar $(JAVA_PARSER_JAR) \
    -f $(JAVA_SOURCE) -t java -a $(OPA_WASM_POLICY)

.PHONY: gradle-opa-sdk-validation
gradle-opa-sdk-validation:	## Use OPA server and OPA Java SDK to validate Gradle build file parsed into JSON
	@java -jar $(JAVA_PARSER_JAR) \
    -f $(GRADLE_SOURCE) -p $(OPA_GRADLE_POLICY) -t gradle | jq .

.PHONY:	parse-java
parse-java:	## Parse Java file to JSON, formatted with JQ
	@java -jar $(JAVA_PARSER_JAR) \
    -f $(JAVA_SOURCE) -t Java | jq .

.PHONY:	parse-java-schema
parse-java-schema:	## Parse gradle, add schema
	java -jar $(JAVA_PARSER_JAR) -f $(JAVA_SOURCE) -t java -o $(JAVA_JSON_TARGET) -s $(JAVA_JSON_SCHEMA_TARGET)

.PHONY:	post-java
post-java:	## cURL post JSON (parsed from Java file) to OPA server v0 data API, without "input" object
	@java -jar $(JAVA_PARSER_JAR) \
    -f $(JAVA_SOURCE) -t Java | jq . \
	| curl -s $(OPA_URL)/$(OPA_V0_DATA)/$(OPA_JAVA_POLICY_DENY) \
	--data-binary @- | jq .

.PHONY:	parse-gradle
parse-gradle:	## Parse gradle
	java -jar $(JAVA_PARSER_JAR) -f $(GRADLE_SOURCE) -t gradle -o $(GRADLE_JSON_TARGET)

.PHONY:	parse-gradle-schema
parse-gradle-schema:	## Parse gradle, add schema
	java -jar $(JAVA_PARSER_JAR) -f $(GRADLE_SOURCE) -t gradle -o $(GRADLE_JSON_TARGET) -s $(GRADLE_JSON_SCHEMA_TARGET)

.PHONY:	parse-gradle-stdout
parse-gradle-stdout:	## Parse gradle
	java -jar $(JAVA_PARSER_JAR) -f $(GRADLE_SOURCE) -t gradle | jq .

.PHONY:	parse-graphql
parse-graphql:	## Parse GraphQL
	java -jar $(JAVA_PARSER_JAR) -f $(GRAPHQL_SOURCE) -t graphql -o $(GRAPHQL_JSON_TARGET) \
	-s $(GRAPHQL_JSON_SCHEMA_TARGET)

.PHONY:	parse-graphql-debug
parse-graphql-debug:	## Parse GraphQL (DEBUG)
	java -jar $(JAVA_PARSER_JAR) -f $(GRAPHQL_SOURCE) -t graphql -o $(GRAPHQL_JSON_TARGET) \
	-s $(GRAPHQL_JSON_SCHEMA_TARGET) > out-gql-visitor.txt

.PHONY:	parse-csv
parse-csv:	## Parse CSV
	java -jar $(JAVA_PARSER_JAR) -f $(CSV_SOURCE) -t csv -o $(CSV_JSON_TARGET) \
	-s $(CSV_JSON_SCHEMA_TARGET)

.PHONY:	parse-garbage
parse-garbage:	## Parse GraphQL
	java -jar $(JAVA_PARSER_JAR) -f $(JAVA_SOURCE) -t garbage -d

##################################
# ANTLR
##################################
##@ ANTLR Ops

.PHONY:	antlr-gen-java
antlr-gen-java:	## Use ANTLR to generate Java parser code for Java files
	$(ANTLR_CMD) -o $(ANTLR_JAVA_TARGET) -visitor $(ANTLR_JAVA_GRAMMAR) \
	-package $(ANTLR_JAVA_PACKAGE)

.PHONY:	antlr-gen-gradle
antlr-gen-gradle:	## Use ANTLR to generate Java parser code for Gradle files
	$(ANTLR_CMD) -o $(ANTLR_GRADLE_TARGET) -visitor $(ANTLR_GRADLE_GRAMMAR) \
	-package $(ANTLR_GRADLE_PACKAGE)

.PHONY:	antlr-gen-graphql
antlr-gen-graphql:	## Use ANTLR to generate Java parser code for GraphQL files
	$(ANTLR_CMD) -o $(ANTLR_GRAPHQL_TARGET) -visitor $(ANTLR_GRAPHQL_GRAMMAR) \
	-package $(ANTLR_GRAPHQL_PACKAGE)

.PHONY:	antlr-gen-csv
antlr-gen-csv:	## Use ANTLR to generate Java parser code for CSV files
	$(ANTLR_CMD) -o $(ANTLR_CSV_TARGET) -visitor $(ANTLR_CSV_GRAMMAR) \
	-package $(ANTLR_CSV_PACKAGE)

##################################
# Misc
##################################
##@ Misc Ops
.PHONY:	count-loc
count-loc:	## Count lines of Java code
	find $(JAVA_PROJECT) -name "*.java" | xargs wc -l | sort -nr

##################################
# OPA WASM
##################################
##@ OPA WASM

.PHONY:	opa-build-wasm
opa-build-wasm:	## OPA build wasm module
	rm -rf wasm && mkdir wasm && \
	opa build -t wasm -e $(OPA_JAVA_POLICY_DENY) $(OPA_JAVA_POLICY_SOURCE) -o $(OPA_WASM_BUNDLE) \
	&& tar -xzvf $(OPA_WASM_BUNDLE) -C wasm

##################################
# Kubernetes
##################################
##@ Kubernetes

.PHONY:	mk-up
mk-up:	## Start minikube
	minikube start -p DEMO

.PHONY:	mk-down
mk-down:	## Stop minikube
	minikube delete -p DEMO
