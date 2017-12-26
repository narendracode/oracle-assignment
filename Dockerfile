FROM openjdk:8u121-jre-alpine


MAINTAINER narendra <narendrasoni2@gmail.com>

# disable interactive functions
ENV DEBIAN_FRONTEND noninteractive

RUN apt-get update
RUN apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv EA312927
RUN echo "deb http://repo.mongodb.org/apt/ubuntu "$(lsb_release -sc)"/mongodb-org/3.2 multiverse" | sudo tee /etc/apt/sources.list.d/mongodb-org-3.2.list
RUN sudo apt-get install -y mongodb-org

ADD mongod.service /lib/systemd/system/

RUN systemctl daemon-reload
RUN systemctl start mongod
RUN systemctl enable mongod


ADD target/oracle-assignment-0.0.1-SNAPSHOT.jar oracle-assignment-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /oracle-assignment-0.0.1-SNAPSHOT.jar"]
