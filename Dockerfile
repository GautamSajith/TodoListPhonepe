# Use an OpenJDK base image
FROM openjdk:8-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR into the container
COPY target/my-application.jar /app/application.jar

# Copy the config file into the container
COPY config.yml /app/config.yml

# Expose the port your application listens on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "application.jar", "server", "config.yml"]
