FROM amazoncorretto:11-alpine-jdk

WORKDIR /elk-stack

COPY target/elk-stack-0.0.1-SNAPSHOT.jar ./
CMD ["java", "-jar", "elk-stack-0.0.1-SNAPSHOT.jar", "-Dserver.port=8081"]

EXPOSE 8081