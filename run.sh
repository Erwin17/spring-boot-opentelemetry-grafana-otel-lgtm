#!/bin/bash

# Valida que el usuario pase el número de repeticiones como argumento
if [ -z "$1" ]; then
  echo "Uso: $0 <numero_de_peticiones>"
  exit 1
fi

for i in $(seq 1 "$1")
do
  # El número aleatorio debe concatenarse directamente al final de la URL
  curl  -o /dev/null \
  -H "Content-Type: application/json" \
  "http://localhost:8081/server-1/user/$(( RANDOM % 5 + 1 ))"
done

