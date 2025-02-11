# devnexus-2025-pac
Companion to Devnexus 2025 talk: Software Supply Chain Security with Policy as Code

> Policy as Code to automate Governance, Risk, and Compliance (GRC) - a.k.a. Governance as Code

> This repo contains several examples of using Open Policy Agent (OPA) and Kyverno to evaluate different software supply chain artifacts.

- AuthZ (Bearer Tokens) for OPA server
- CycloneDX SBOM validation (using OPA and OPA/Conftest)
- CycloneDX SBOM validation (using Anchore Syft & Grype, and OPA exec)
- Dockerfile validation (using Conftest)
- Gradle parsing and validation (using ANTLRv4 and OPA)
- Java parsing and validation (using JavaParser and OPA)
- Java Properties file validation (using OPA/Conftest)
- Kubernetes Deployment (using OPA/Conftest)
- Maven POM (using OPA/Conftest)

## OPA

```
├── opa
│   ├── .regal - OPA policy linter (Regal) configuration
│   ├── Makefile - Demo automation
│   ├── bundle - Rego policy files, test Rego files, and JSON data
│   ├── config.properties - Java properties files for Java and Gradle parsing program
│   ├── conftest - Conftest Rego files and source artifact files
│   ├── git-workflows - Git YAML action/workflow files
│   ├── httpExamples of how to send HTTP requests to the OPA server
│   ├── input - Misc. input artifacts
│   ├── policy - Rego policies for use in OPA v0/v1 versions
│   └── scripts - Additional automation scripts
```

## Parsing

```
├── java
│   ├── io - Misc. input and output files
│   └── parsing-java - IntelliJ project for CSV, Java, Gradle, and GraphQL parsing
```
