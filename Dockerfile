FROM eclipse-temurin:17.0.9_9-jdk
ARG JAR_FILE=target/*.jar
COPY source dest