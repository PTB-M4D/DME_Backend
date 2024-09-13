FROM openjdk:22-jdk
WORKDIR /app
COPY target/dmebackend.jar /app/dmebackend.jar
EXPOSE 8080
CMD ["java", "-jar" ,"dmebackend.jar"]