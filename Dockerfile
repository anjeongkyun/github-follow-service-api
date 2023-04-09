FROM openjdk:11.0.16-jdk

# Application
RUN mkdir -p /var/log/app
RUN mkdir -p /var/log/app/gc

COPY api/build/libs/api-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar", "-XX:MinRAMPercentage=50.0 -XX:MaxRAMPercentage=80.0"]
