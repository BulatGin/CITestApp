FROM openjdk:8-jre-alpine

EXPOSE 9876

WORKDIR /app

COPY ./target/CITestApp.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]