FROM openjdk:13-jdk-alpine
#ARG JAR_FILE=build/libs/*.jar
ARG JAR_FILE=build_jar/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]