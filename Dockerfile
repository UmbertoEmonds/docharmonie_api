# Build stage

FROM maven:3.8.4-openjdk-17-slim
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean install

# Package stage

FROM openjdk:17.0.2-jdk-oraclelinux8
ARG JAR_FILE=target/docharmonie-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/app.jar"]

# openjdk:17.0.2-jdk-oraclelinux8