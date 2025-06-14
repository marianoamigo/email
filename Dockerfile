# Etapa 1: build con Maven
FROM maven:3.9.6-eclipse-temurin AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: correr solo el JAR
FROM openjdk:21-slim
WORKDIR /app
COPY --from=build /app/target/email-0.0.1.jar mic_email.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "mic_email.jar"]
