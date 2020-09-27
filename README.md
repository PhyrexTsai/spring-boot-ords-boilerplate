# Spring Boot ORDS Boilerplate

## Table of Content
- [Build and Run](#build-and-run)
- [Folder Structure](#folder-structure)
- [Generate Java Doc](#generate-java-doc)
- [Run ORDS by Docker](#run-ords-by-docker)

## <a name="build-and-run"></a>Build and Run

STEP 1. Install dependancy:
```
mvn install
```

STEP 2. Build war file
```
mvn clean package
```

STEP 3. Run on localhost
Run local by `mvnw`, will start on [http://localhost:8081](http://localhost:8081)
```
./mvnw clean package && java -jar target/spring-boot-ords-boilerplate-1.0.0.war
```

STEP 4. View Swagger UI
Open [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)

## <a name="folder-structure"></a>Folder Structure
- aspect: Using AOP to log RESTful APIs information
- config: Define configuration, ex: swagger config
- controller: Define RESTful APIs
- converter: Convert controller request and response
- entity: Object entity, Java bean
- exception: Define exception
- handler: Define handler, ex: exception handler
- parameter: Define RESTful APIs Parameters such as request and response
- service: Define business logic for controller usage
- webclient: ORDS Web Client, provide CRUD RESTful APIs to Oracle Database

## <a name="generate-java-doc"></a>Generate Java Doc

STEP 1. Run the command to generate Java doc
```
mvn javadoc:javadoc
```

STEP 2. Open Java doc
Open `target/site/apidocs/index.html`, it will show Java doc as well

## <a name="run-ords-by-docker">Run ORDS by Docker
STEP 1. Clone [https://github.com/PhyrexTsai/docker-db-apex-dev/](https://github.com/PhyrexTsai/docker-db-apex-dev/) and run the step by on `README.md`  

STEP 2. Execute SQL and launch API by following [https://github.com/PhyrexTsai/docker-db-apex-dev/blob/master/ORDS.md](https://github.com/PhyrexTsai/docker-db-apex-dev/blob/master/ORDS.md)
