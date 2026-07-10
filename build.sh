#!/bin/bash
cd observer
./gradlew clean build -q -x test
echo "observer"

cd ..
cd observer2
./gradlew clean build -q -x test
echo "observer2"

docker compose down
docker compose build --no-cache
docker compose up 