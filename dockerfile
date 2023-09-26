#
# Build Package
#
FROM maven:3.8.3-openjdk-17 AS build
COPY ./PraticaD2 .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:17-jdk-slim
COPY --from=build /target/PraticaD2-0.0.1-SNAPSHOT.jar PraticaD2.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","PraticaD2.jar"]