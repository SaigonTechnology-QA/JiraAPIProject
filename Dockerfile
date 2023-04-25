# Use Java 8 slim JDK
FROM openjdk:8-jdk-slim
MAINTAINER nxthich

# Maven, allure version
ARG ALLURE_VERSION=2.19.0
ARG MAVEN_VERSION=3.9.1

# Install few utilities
RUN apt-get clean && \
    apt-get update && \
    apt-get -qy install wget telnet iputils-ping unzip

# Create Test folder
RUN mkdir /Auto_Test \
	&& cd /Auto_Test/

# Install Maven
RUN cd /Auto_Test/ \
	&& wget https://dlcdn.apache.org/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.zip \
	&& unzip apache-maven-$MAVEN_VERSION-bin.zip \
	&& rm apache-maven-$MAVEN_VERSION-bin.zip

# Install Allure
RUN cd /Auto_Test/ \
	&& wget https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/$ALLURE_VERSION/allure-commandline-$ALLURE_VERSION.tgz \
	&& tar -xzf allure-commandline-$ALLURE_VERSION.tgz \
	&& rm allure-commandline-$ALLURE_VERSION.tgz

# Set Allure Home
ENV ALLURE_HOME /Auto_Test/allure-$ALLURE_VERSION

# Set Maven Home
ENV MAVEN_HOME /Auto_Test/apache-maven-$MAVEN_VERSION

# Add Maven, Allure to the Path
ENV PATH $MAVEN_HOME/bin:$ALLURE_HOME/bin:$PATH

# Copy source code project from local Or Clone code from github
# ADD JiraProject /Auto_Test/JiraProject
# git@github.com:<user_name>/JiraProject.git

# Install dependency and Run the test
#RUN cd /Auto_Test/JiraProject && mvn clean test -DxmlSuite="src/test/resources/test-suites/Regression.xml"

# Working dir
WORKDIR /Auto_Test
