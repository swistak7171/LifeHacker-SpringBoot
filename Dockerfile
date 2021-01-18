FROM swistak7171/repository:openjdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar", "--spring.profiles.active=debug"]
EXPOSE 8080