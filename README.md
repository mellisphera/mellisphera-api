## Mellisphera API

This is the back end of MelliHealth beekeeping platform. 
It is closely linked with [mellihealth-api](https://github.com/mellisphera/mellihealth-api) backend.
An overview of the whole architecture is given below :

![](img/mellihealth_scheme.png)

### Build and run

Go on the project's root folder, then type:

    $ mvn spring-boot:run

or

    $ mvn install
    cd target
    java -jar [FICHIER].jar

#### Configurations

Open the `application.properties` file and set your own configurations.

#### Prerequisites

- Java 8
- Maven > 3.0

#### From Eclipse (Spring Tool Suite)

Import as *Existing Maven Project* and run it as *Spring Boot App*.

### Usage

- Launch the application and go on http://localhost:8080/
- Optional: if you setted a log file in the `application.properties` open such file to see the log

