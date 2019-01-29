FROM openjdk:11
ADD ./target/Music-Eruka-Server-0.0.1-SNAPSHOT.jar /usr/src/Music-Eruka-Server-0.0.1-SNAPSHOT.jar
EXPOSE 8761
WORKDIR usr/src
ENTRYPOINT ["java","-jar","Music-Eruka-Server-0.0.1-SNAPSHOT.jar"]