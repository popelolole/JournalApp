FROM openjdk:22-jdk-oracle

WORKDIR /app

COPY target/ .

EXPOSE 8080

CMD ["java", "-jar", "JournalApp-1.0.0.jar"]