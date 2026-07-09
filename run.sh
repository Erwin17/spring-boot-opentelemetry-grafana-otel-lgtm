#!/bin/bash

for i in $(seq 1 $1)
do
  curl -s -o /dev/null \
  -H "Content-Type: application/json" \
  http://localhost:8080/server-1/user/1;
done
