
# Spring boot REST API
API coding assesment with basic front-end using [Spring Boot](http://projects.spring.io/spring-boot/).

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven 3](https://maven.apache.org/download.cgi)

## Setting environment variables (Windows).
This step is required when building the application from command line. If you'r using an IDE most likley this is already set up.

Type `Edit Environment Variables` in Windows search bar -> click `Environment variables` -> Create `MAVEN_HOME` (ex: `C:\apache-maven-3.8.7`) and `JAVA_HOME` (ex: `C:\Program Files\Java\jdk-17.0.5`) system variables.
Add `%MAVEN_HOME%\bin` to the `PATH` system variable.

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `CapgeminiRestApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) from home folder like so:

```shell
mvn spring-boot:run
```

## Testing the application
### Browser
Navigate to [localhost:8080/index.html](http://localhost:8080/index.html) and try to retrieve preloaded customer information by using customer id 1.

### Curl

```shell
curl -X GET localhost:8080/customers/1 -H "Content-Type:application/json"
```

```shell
curl -X POST localhost:8080/customers/1/accounts -H "Content-Type:application/json" -d "{\"initialCredit\": \"12.12\"}"
```