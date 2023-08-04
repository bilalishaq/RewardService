# Use Java 17
FROM openjdk:17-jdk-slim
MAINTAINER Bilal Ishaq <ishaq.bilal@gmail.com>
#COPY JAR FILE
COPY target/RewardService-1.0.0.jar RewardService-1.0.0.jar
ENTRYPOINT ["java","-jar","/RewardService-1.0.0.jar"]