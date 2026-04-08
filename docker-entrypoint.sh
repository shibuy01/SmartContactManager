# -------- BUILD STAGE --------
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy POM and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code and build jar
COPY src ./src
RUN mvn clean package -DskipTests

# -------- RUN STAGE --------
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copy built jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Railway automatically provides PORT env variable
ENV PORT=8080
EXPOSE 8080

# Copy dummy entrypoint for Railway
COPY docker-entrypoint.sh .
RUN chmod +x docker-entrypoint.sh

ENTRYPOINT ["./docker-entrypoint.sh"]
