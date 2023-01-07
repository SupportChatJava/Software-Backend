##Building the app
#FROM adoptopenjdk/openjdk11:ubi as build
#
#
#ARG JAR_FILE=target/*.jar
##Creates folder on base image and create app folder
#WORKDIR /app
#
##Copy maven executable
#COPY mvnw ./
#COPY .mvn .mvn
#
##Copy pom file
#COPY pom.xml ./
#
## Build dependencies in prepatarion to go offline
#RUN ./mvnw dependency:go-offline -B
#
#COPY src src
#
## Package application
#RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)
#
#
#
#FROM adoptopenjdk/openjdk11:ubi
#
#
##Run command
#ENTRYPOINT ["java","-cp","app:app/lib/*","SupportchatApplication.SupportchatApplication"]

#FROM openjdk:17-jdk
#
##Copy maven executable
#COPY mvnw ./
#COPY .mvn .mvn
#
##Copy pom file
#COPY pom.xml ./
#
#
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]



FROM openjdk:17-jdk
ADD target/supportchatApplication.jar Sup.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./Sup.jar"]