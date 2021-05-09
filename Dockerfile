FROM openjdk:8-jdk-alpine
EXPOSE 2222
ADD target/microservice-a-example.jar microservice-a-example.jar
ENTRYPOINT ["java","-jar","/microservice-a-example.jar"]