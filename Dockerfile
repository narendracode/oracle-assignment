#FROM openjdk:8u121-jre-alpine
FROM nimmis/ubuntu:16.04

MAINTAINER narendra <narendrasoni2@gmail.com>

# disable interactive functions
ENV DEBIAN_FRONTEND noninteractive

RUN apt-get update

RUN apt-get install software-properties-common
#RUN add-apt-repository ppa:webupd8team/java
#RUN apt-get install oracle-java8-installer
RUN apt-get install -y openjdk-8-jdk

RUN echo "JAVA_HOME=$(which java)" | tee -a /etc/environment

# Install MongoDB Following the Instructions at MongoDB Docs
# Ref: http://docs.mongodb.org/manual/tutorial/install-mongodb-on-ubuntu/

# Add the package verification key
RUN apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 7F0CEB10

# Add MongoDB to the repository sources list
RUN echo 'deb http://downloads-distro.mongodb.org/repo/ubuntu-upstart dist 10gen' | tee /etc/apt/sources.list.d/mongodb.list

# Update the repository sources list once more
RUN apt-get update

# Install MongoDB package (.deb)
RUN apt-get install -y mongodb-10gen

# Create the default data directory
RUN mkdir -p /data/db


ADD target/oracle-assignment-0.0.1-SNAPSHOT.jar oracle-assignment-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar oracle-assignment-0.0.1-SNAPSHOT.jar"]