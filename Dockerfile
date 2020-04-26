FROM openjdk:8-alpine

# Required for starting application up.
RUN apk update && apk add bash

RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app
COPY target/customer-service-0.0.1-SNAPSHOT.jar $PROJECT_HOME/customer-service.jar
WORKDIR $PROJECT_HOME
EXPOSE 8103
CMD ["java", "-Dspring.data.mongodb.uri=mongodb://localhost:27017/customer_db","-Djava.security.egd=file:/dev/./urandom","-jar","./customer-service.jar"]
