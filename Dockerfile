FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/spdr-gld-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
EXPOSE 8080/tcp
ENTRYPOINT ["java", "-jar", "app.jar"]
