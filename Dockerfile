FROM openjdk:17
COPY ./target/catalog-service-0.0.1-SNAPSHOT.jar /usr/src/catalog/
WORKDIR /usr/src/catalog
EXPOSE 8080
CMD ["java", "-jar", "catalog-service-0.0.1-SNAPSHOT.jar"]