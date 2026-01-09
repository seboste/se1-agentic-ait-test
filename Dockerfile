# Multi-stage build for factorial calculator web app

# Stage 1: Build
FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app

# Copy Maven wrapper and project files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src src

# Build the application
RUN ./mvnw clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy the built jar from builder stage
COPY --from=builder /app/target/factorial-calculator-1.0-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
