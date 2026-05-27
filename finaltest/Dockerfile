FROM --platform=linux/amd64/v4 eclipse-temurin:17-jdk

ARG JAR_FILE=target/finaltest-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} flight-service.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/flight-service.jar"]