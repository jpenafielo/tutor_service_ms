FROM openjdk:17-jdk-alpine
WORKDIR /usr/src/main/TutorServiceApplication
COPY target/tutor_service-0.0.1-SNAPSHOT.jar /tutor_service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/tutor_service-0.0.1-SNAPSHOT.jar"]