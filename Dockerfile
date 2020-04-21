FROM openjdk:8


RUN mkdir -p /opt/app

ENV PROJECT_HOME /opt/app

COPY target/hellospring-0.0.1-SNAPSHOT.jar $PROJECT_HOME/spring-boot-restapp.jar

WORKDIR $PROJECT_HOME

CMD ["java","-jar","./spring-boot-restapp.jar"]