# Start with base image containing Java 11 runtime
FROM openjdk:11
LABEL MAINTAINER codingz2m.com
COPY target/savings-account-1.0.0.jar savings-accounts-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/savings-accounts-1.0.0.jar"]