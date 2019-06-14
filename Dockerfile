FROM openjdk:8-jdk-alpine

RUN mkdir /app
WORKDIR /app
EXPOSE 8090
COPY target/wallet-kurs-0.0.1-SNAPSHOT.jar .

ENTRYPOINT [ "java","-jar","wallet-kurs-0.0.1-SNAPSHOT.jar","--spring.profiles.active=deploy" ]