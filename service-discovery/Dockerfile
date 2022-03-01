# Start with base image containing Java 11 runtime
FROM openjdk:11
LABEL MAINTAINER codingz2m.com
COPY target/service-discovery-1.0.0.jar service-discovery-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/service-discovery-1.0.0.jar"]