FROM openjdk:21-slim
COPY target/mic_email.jar mic_email.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "mic_email.jar"]