FROM openjdk:21-slim
ARG JAR_FILE=target/email-0.0.1.jar
COPY ${JAR_FILE} mic_email.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "mic_email.jar"]