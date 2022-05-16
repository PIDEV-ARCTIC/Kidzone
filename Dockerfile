FROM openjdk:8-jdk-alpine
EXPOSE 8081
ARG JAR_FILE=target/PIDEV-KidZone-1.0.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]