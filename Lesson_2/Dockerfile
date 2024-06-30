FROM openjdk:17-oracle
WORKDIR /app
COPY build/libs/Lesson_2-0.0.1-SNAPSHOT.jar app.jar
ENV app.auto-create-students.enabled=true
CMD ["java", "-jar", "app.jar"]