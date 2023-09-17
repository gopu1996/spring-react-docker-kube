# FROM openjdk:17
# ADD target/*.jar clinicaldata-0.0.1-SNAPSHOT.jar
# ENTRYPOINT ["java","-jar","clinicaldata-0.0.1-SNAPSHOT.jar"]
FROM openjdk:17

WORKDIR /app

COPY target/clinicaldata-0.0.1-SNAPSHOT.jar /app/clinicaldata-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "clinicaldata-0.0.1-SNAPSHOT.jar"]

