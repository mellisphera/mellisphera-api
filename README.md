## MelliHealth API

This is the back-end of MelliHealth beekeeping platform. 
It is closely linked with its front-end [mellihealth-web](https://github.com/mellisphera/mellihealth-web) .
An overview of the whole architecture is given below :

![](img/mellihealth_scheme.png)


## Give it a test
Go to [app.mellisphera.com](https://app.mellisphera.com)
create an account and visit a demo apiary


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

- Java 8
- Maven > 3.0
- MongoDB


### Configuration
Configure the API with the `application.properties` file 
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

## Install the front-end
To have the whole platform running you need to install the front-end.\
See details at [mellihealth-web](https://github.com/mellisphera/mellihealth-web).

## Need help?
if something goes wrong, contact us at info@mellisphera.com we'll be glad to help.

## Wish to contribute?
Please review [CONTRIBUTING](https://github.com/mellisphera/mellihealth-web/blob/master/CONTRIBUTING.md) 
