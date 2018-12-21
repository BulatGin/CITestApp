FROM jenkins/jenkins:lts

USER root

WORKDIR /usr/lib/jvm

# Install and set up oracle jdk (default openjdk has bag)
RUN wget --no-cookies --no-check-certificate \
--header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" \
"http://download.oracle.com/otn-pub/java/jdk/8u191-b12/2787e4a523244c269598db4e85c51e0c/jdk-8u191-linux-x64.tar.gz" && \
    tar xzf jdk-8u191-linux-x64.tar.gz && \
    rm jdk-8u191-linux-x64.tar.gz

ENV JAVA_HOME="/usr/lib/jvm/jdk1.8.0_191"

WORKDIR /

# Install docker
RUN apt-get update && \
    apt-get install -y \
         apt-transport-https \
         ca-certificates \
         curl \
         gnupg2 \
         software-properties-common || true && \
    curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add - && \
    echo "deb [arch=amd64] https://download.docker.com/linux/debian stretch stable" >> /etc/apt/sources.list && \
    apt-get update && \
    apt-get install -y docker-ce

RUN addgroup jenkins docker

USER jenkins
