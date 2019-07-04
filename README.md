## Mellisphera API

This is the back-end of MelliHealth beekeeping platform. 
It is closely linked with its front-end [mellihealth-web](https://github.com/mellisphera/mellihealth-web) .
An overview of the whole architecture is given below :

![](img/mellihealth_scheme.png)


## Give it a test before downloading
go to [app.mellisphera.com](https://app.mellisphera.com)
create an account and visit a demo apiary


## want to go further ?
follow the next quick start guide

### Prerequisites

- Java 8
- Maven > 3.0
- MongoDB


### Configuration
configure the API with the `application.properties` file 
There is a template of this file into the setup folder
   ```
    cp ./setup/application.properties /src/main/ressources
   ```
Edit this file with your own configuration:
```
spring.data.mongodb.database=[DB NAME]
spring.data.mongodb.uri=mongodb://[USERNAME]:[PASSWORD]@[ADRESS]:[PORT]/?authSource=admin&authMechanism=SCRAM-SHA-1
server.port=PORT
```
### Load the demo data onto MongoDB
Demo json files for apiaries, user, hives and sensor data  are available into ./setup

### Import the project to Eclipse (Spring Tool Suite)
Import as *Existing Maven Project* and run it as *Spring Boot App*.

### Build and run
Go on the project's root folder, then type:

    mvn spring-boot:run

or

    mvn install
    cd target
    java -jar [FILE].jar

- then go to http://localhost:8080/


## Need help?
if something goes wrong, contact us at info@mellisphera.com we'll be glad to help.
