#!/usr/bin/env bash

fail() {
  echo "There were errors"
}

if /bin/bash /Users/tomys/Documents/Projekty/Task-app\ back-end/runcrud.sh; then
  open -a "Google Chrome" https://adamtomys.github.io/
else
  fail
fi