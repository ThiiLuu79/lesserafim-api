# Step 1: Build the application
FROM maven:3.8.5-openjdk-17 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies first (cache optimization)
COPY pom.xml .
RUN mvn dependency:go-offline

# Now copy the rest of the source code
COPY src ./src

# Package the app (resources will be included in JAR)
RUN mvn clean package -DskipTests

# Step 2: Use slim runtime image
FROM openjdk:17.0.1-jdk-slim

# Copy built JAR from previous stage
COPY --from=build /app/target/lesserafimBE-0.0.1-SNAPSHOT.jar lesserafimBE.jar

# Expose the default port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "lesserafimBE.jar"]
