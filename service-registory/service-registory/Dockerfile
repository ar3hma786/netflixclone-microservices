# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the current directory contents into the container at /usr/src/app
COPY . .

# Add the Eureka JAR file to the container
ADD https://repo1.maven.org/maven2/org/springframework/cloud/spring-cloud-netflix-eureka-server/3.0.3/spring-cloud-netflix-eureka-server-3.0.3.jar eureka-server.jar

# Run the Eureka server
CMD ["java", "-jar", "eureka-server.jar"]
