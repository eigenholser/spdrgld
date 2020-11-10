# SPDR GLD

An API for SPDR GLD NAV data using Spring Boot.

# Docker

Build the Docker image:

    docker build -t spdrgld:latest .

Run the container:

    docker run --rm -d --link pg-docker \
        -e OUTRIDER_DB_URL="jdbc:postgresql://pg-docker:5432/outrider" \
        -p 8080:8080 \
        -t \
        spdrgld:latest

This assumes a running PostgreSQL container with port 5432 exposed.

# Read Me First
The following was discovered as part of building this project:

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.0-RC1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.0-RC1/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.3.5.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/2.3.5.RELEASE/reference/htmlsingle/#howto-execute-flyway-database-migrations-on-startup)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

