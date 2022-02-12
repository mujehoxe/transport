#!/bin/bash

echo "Performing a clean Maven build"
./mvnw clean package -DskipTests=true

echo "Setting the default builder for pack"
pack config default-builder paketobuildpacks/builder:tiny

echo "Packing the auth-service image"
cd auth-service
pack build auth-service --env "BP_JAVA_VERSION=8.*"
cd ..

echo "Packing the booking-service image"
cd booking
pack build booking --env "BP_JAVA_VERSION=8.*"
cd ..

echo "Packing the config server"
cd config
pack build config --env "BP_JAVA_VERSION=8.*"
cd ..

echo "Packing the Eureka Discovery Server"
cd discovery
pack build discovery --env "BP_JAVA_VERSION=8.*"
cd ..

echo "Packing the Spring Cloud Gateway"
cd gateway
pack build gateway --env "BP_JAVA_VERSION=8.*"
cd ..

echo "Packing the planing-service image"
cd planing
pack build planing --env "BP_JAVA_VERSION=8.*"
cd ..

echo "Packing the registration-service image"
cd registration
pack build registration --env "BP_JAVA_VERSION=8.*"
cd ..
