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
COPY --from=build /target/PraticaPicPay-0.0.1-SNAPSHOT.jar petcare.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","PraticaPicPay.jar"]