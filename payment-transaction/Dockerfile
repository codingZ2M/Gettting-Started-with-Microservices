# Start with base image containing Java 11 runtime
FROM openjdk:11
LABEL MAINTAINER codingz2m.com
COPY target/payment-transaction-1.0.0.jar payment-transaction-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/payment-transaction-1.0.0.jar"]