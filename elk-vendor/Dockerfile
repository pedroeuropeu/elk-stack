FROM amazoncorretto:11-alpine-jdk

WORKDIR /elk-vendor

COPY target/elk-vendor-0.0.1-SNAPSHOT.jar ./
CMD ["java", "-jar", "elk-vendor-0.0.1-SNAPSHOT.jar", "-Dserver.port=8082"]

EXPOSE 8082