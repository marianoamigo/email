# Etapa 1: compilar JAR usando Maven
FROM maven:3.9.6-eclipse-temurin AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: usar solo el JAR para correr la app
FROM openjdk:21-slim
WORKDIR /app
COPY --from=build /app/target/mic_email.jar mic_email.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "mic_email.jar"]