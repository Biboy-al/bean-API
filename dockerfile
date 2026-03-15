FROM gradle:9.3.1-jdk25-alpine AS builder

WORKDIR /app
COPY . .
RUN ./gradlew build -x test

FROM amazoncorretto:25-alpine3.23

WORKDIR /APP
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]