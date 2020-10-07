# gradle-docker-contract-first-service

This project is a starting point for delivering a SpringBoot service within Docker, using contract first development.

## Guide

Please follow this article to understand what this project offers: 

https://medium.com/@JoeHonour/java-developing-a-spring-service-using-an-openapi-contract-first-approach-37dfd6422a9c

extensions on-top of the guide:
- docker support has been added, allowing the building and testing of the application in docker.
- componentTests are added (in addition to unit tests) which allow testing of the application at the HTTP layer.

## Using the project

You will need to build the application to resolve any compilation issues, as the build step triggers code generation of classes used by the Api.

building the application 

```bash
./gradlew build
```

running the application standalone

```bash
./gradlew bootRun
```

building and running the application with docker

```bash
# only dependencies (not the service itself)
./gradlew composeDependenciesUp 

# full dependencies and service
./gradlew composeUp

# turn anything thats on, off
./gradlew composeDown
```

running the component tests (this handles building and running the application in docker beforehand)

```bash
./gradlew componentTestDocker
```

running the unit and component tests, producing a code coverage report with Jacoco (location build/jacoco-reports/index.html): 

```bash
./gradlew fullCoverageReport
```

publishing the application standalone (with sources JAR)

```bash
./gradlew publishToMavenLocal
```





