FROM openjdk:17-jdk
ADD target/supportchatApplication.jar Sup.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./Sup.jar"]