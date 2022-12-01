FROM openjdk:17
MAINTAINER Italo Moura <italo.moura1201@gmail.com>

COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]