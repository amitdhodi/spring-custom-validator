# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

// Install docker
RUN curl -fsSLO https://get.docker.com/builds/Linux/x86_64/docker-17.04.0-ce.tgz \
&& tar xzvf docker-17.04.0-ce.tgz \
&& mv docker/docker /usr/local/bin \
&& rm -r docker docker-17.04.0-ce.tgz

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/customvalidator-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} customvalidator-demo.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/customvalidator-demo.jar"]
