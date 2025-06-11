FROM openjdk:21-slim
COPY deploy/email-0.0.1.jar mic_email.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "mic_email.jar"]