FROM openjdk:17-jdk-slim AS build

COPY . /app

WORKDIR /app
RUN ./mvnw package

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/producer-service.jar producer-service.jar

ENTRYPOINT ["java", "-jar", "producer-service.jar"]
