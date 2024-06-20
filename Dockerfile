# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-alpine

# Set the working directory in the container
#WORKDIR /app

VOLUME /tmp

# Copy the jar file into the container at /app
#COPY target/volley-0.0.1-SNAPSHOT.jar /app/volley-backend.jar
COPY target/*.jar app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
#ENTRYPOINT ["java", "-jar", "/app/volley-backend.jar"]
ENTRYPOINT ["java","-jar","/app.jar"]

