FROM maven:3.8.2-jdk-17 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:17-jdk-slim
COPY --from=build /target/PraticaD2-0.0.1-SNAPSHOT.jar demo.jar
ENV PORT=9091
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]