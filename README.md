# gradle-docker-contract-first-service

This project is a starting point for delivering a SpringBoot service within Docker, using contract first development.

## Guide

Please follow this article to understand what this project offers: 

https://medium.com/@JoeHonour/java-developing-a-spring-service-using-an-openapi-contract-first-approach-37dfd6422a9c

Please follow this article for understanding how the component tests and code coverage are implemented:

https://medium.com/@JoeHonour/java-how-to-run-component-tests-with-code-coverage-using-gradle-and-docker-47fc023969a4 

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





