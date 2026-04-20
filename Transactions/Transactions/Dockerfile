FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","app.jar"]

# Docker starts from the Java 17 base image.
# Creates /app folder inside the container.
# Copies your JAR file into /app/app.jar.
# Opens the port (8080 or whichever you set).
# Runs java -jar app.jar → your Spring Boot microservice starts inside the container.