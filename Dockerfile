FROM eclipse-temurin:21-jre-alpine

WORKDIR /app
COPY ms-services*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]