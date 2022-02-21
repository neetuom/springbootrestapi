# FROM openjdk:jdk-13.0.2_8-alpine-slim
# docker pull openjdk:17-jdk-alpine3.14

# FROM adoptopenjdk/openjdk13:jdk-13.0.2_8-alpine-slim
FROM openjdk:17-jdk-alpine3.14
VOLUME /tmp
ADD build/libs/springbootrestapi-0.0.1.jar springbootrestapi-0.0.1.jar
EXPOSE 8084
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Djava.net.preferIPv4Stack=true","-Dspring.profiles.active=container","-jar","/springbootrestapi-0.0.1.jar"]