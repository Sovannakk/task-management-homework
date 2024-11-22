# BUILD STAGE
FROM maven:3.8.7-eclipse-temurin-19 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the current local directory to /app which is the current directory in the container
COPY . .

# Clean the existing build, package the application, and skip tests
RUN mvn clean package -DskipTests -Dmaven.compiler.failOnError=false

# RUN STAGE
FROM eclipse-temurin:22.0.1_8-jre-ubi9-minimal

# Copy the executable JAR file from the build stage to /app directory in the container and rename it to app.jar
COPY --from=build /app/target/*.jar /app/app.jar

# Expose the port on which your Spring application will run (change as per your application)
EXPOSE 8080

# Set the command to run your Spring application when the container starts
CMD ["java", "-jar", "/app/app.jar"]
