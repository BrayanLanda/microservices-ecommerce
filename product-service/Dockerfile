FROM maven:3.9.6-eclipse-temurin-25-jdk-alpine AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:25-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar product.jar
ENTRYPOINT [ "java", "-jar", "product.jar" ]