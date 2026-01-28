# -------- Build stage --------
FROM gradle:8.5-jdk17 AS build
WORKDIR /home/gradle/project

# Copy everything and build the JAR
COPY . .
RUN gradle clean bootJar --no-daemon

# -------- Runtime stage --------
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy Spring Boot JAR
COPY --from=build /home/gradle/project/build/libs/*-SNAPSHOT.jar /app/loggers_docker.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "loggers_docker.jar"]
