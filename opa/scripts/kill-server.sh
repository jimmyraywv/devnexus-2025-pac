#!/usr/bin/env zsh

# error handling
set -e
trap 'catch $? $LINENO' ERR
catch() {
  if [ "$1" != "0" ]; then
    echo "Error $1 occurred on $2"
  fi
}

kill $(ps u | grep '[o]pa run -s'| awk '{print $2}')
#   1> /dev/null 2>& 1


