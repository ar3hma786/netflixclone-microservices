# Step 1: Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the packaged JAR file into the container
# Replace 'target/app.jar' with the path to your built JAR file
COPY target/movieservice-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose the port on which the application will run
EXPOSE 8082

# Step 5: Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]




















