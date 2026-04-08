#!/bin/sh
# Entrypoint script for Spring Boot app
# Ensure app.jar is run inside container

echo "Starting SmartContactManager..."
exec java -jar app.jar
