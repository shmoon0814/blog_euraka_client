FROM openjdk:11-jdk
VOLUME /tmp
EXPOSE 8761
ARG JAR_FILE=target/client-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} client.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/client.jar"]