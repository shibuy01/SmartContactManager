# -------- BUILD STAGE --------
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

COPY . .

# optional: local dependency jar install
RUN if [ -f "SPRINGBOOTRESTAPI.jar" ]; then \
    mvn install:install-file \
    -Dfile=SPRINGBOOTRESTAPI.jar \
    -DgroupId=com.test \
    -DartifactId=SPRINGBOOTRESTAPI \
    -Dversion=0.0.1-SNAPSHOT \
    -Dpackaging=jar ; \
    fi

# build project
RUN mvn clean package -DskipTests


# -------- RUN STAGE --------
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
