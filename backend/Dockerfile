FROM openjdk:17-jdk-alpine

WORKDIR /usr/app/

MAINTAINER petredumitru1@gmail.com

COPY target/hotel_recommendation-0.0.1-SNAPSHOT.jar app.jar

COPY src/main/resources/application.properties application.properties

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]