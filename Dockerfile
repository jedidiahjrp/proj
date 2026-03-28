FROM maven:3.8.8-openjdk-11 AS builder
WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn -B -DskipTests package
FROM eclipse-temurin:11-jre-jammy
WORKDIR /app
COPY --from=builder /app/target/ecommerce-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 9002
ENTRYPOINT [\
java\, \-jar\, \/app/app.jar\]
