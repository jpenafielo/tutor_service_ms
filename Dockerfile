FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/tutor_service-0.0.1-SNAPSHOT.jar /app/tutor_service.jar
EXPOSE 8080
CMD ["java", "-jar", "tutor_service.jar"]
