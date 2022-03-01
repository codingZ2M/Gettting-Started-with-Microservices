# Start with base image containing Java 11 runtime
FROM openjdk:11
LABEL MAINTAINER codingz2m.com
COPY target/gateway-server-1.0.0.jar gateway-server-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/gateway-server-1.0.0.jar"]