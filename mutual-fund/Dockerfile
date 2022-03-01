# Start with base image containing Java 11 runtime
FROM openjdk:11
LABEL MAINTAINER codingz2m.com
COPY target/mutual-fund-1.0.0.jar mutual-fund-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/mutual-fund-1.0.0.jar"]