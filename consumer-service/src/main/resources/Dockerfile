FROM openjdk:17-jdk-slim AS build

COPY . /app

WORKDIR /app
RUN ./mvnw package

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/consumer-service.jar consumer-service.jar

ENTRYPOINT ["java", "-jar", "consumer-service.jar"]
