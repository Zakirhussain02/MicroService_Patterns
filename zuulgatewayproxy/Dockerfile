FROM openjdk:11
ADD ./target/zuulgatewayproxy-0.0.1-SNAPSHOT.jar /usr/src/zuulgatewayproxy-0.0.1-SNAPSHOT.jar
EXPOSE 8800
WORKDIR usr/src
ENTRYPOINT ["java","-jar","zuulgatewayproxy-0.0.1-SNAPSHOT.jar"]