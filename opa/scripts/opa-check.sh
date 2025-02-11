#!/usr/bin/env zsh

# error handling
set -e
trap 'catch $? $LINENO' ERR
catch() {
  if [ "$1" != "0" ]; then
    echo "Error $1 occurred on $2"
  fi
}

for file in bundle/*.rego; do
  # trap error and then continue
  echo $file && opa check --strict --v1-compatible $file || true
done
