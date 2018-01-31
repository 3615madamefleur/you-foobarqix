# FooBarQix Kata for Wemanity / WeSquad
Kata rules are described [there](http://codingdojo.org/kata/FooBarQix/) !
Made up for Wemanity / WeSquad internal administration.

## Usage
In order to run this tool you need at least 2 things :
* [Java SE Runtime Environment 9](http://www.oracle.com/technetwork/java/javase/downloads/jre9-downloads-3848532.html) or [Java Open-Source Development Kit 9](http://www.oracle.com/technetwork/java/javase/downloads/jdk9-downloads-3848520.html?printOnly=1)

  or
* [Docker](https://www.docker.com/community-edition#/download) and [Docker-compose](https://docs.docker.com/compose/install/)

  with
* Project files

Assuming you downloaded the files inside a ```~/Downloads/yolo/``` directory :
* Open up a ```terminal``` window
* Navigate through your files to make ```~/Downloads/yolo/``` your working directory with ```cd``` command

Now you have 3 ways to execute program :
* with **Java** :

  ```java -jar build/foobarqix-1.0-spring-boot.jar```

* with the **Dockerfile** (run as admin) :

  ```docker build -t foobarqix:latest .```
  and then
  ```docker run foobarqix```

* with **Docker-compose** (run as admin) :

  ```docker-compose build```
  and then
  ```docker-compose up```

## Architecture
```
root
 ├─ src        
 │  └─ main/java/
 │  │  └─ ... some Java classes
 │  └─ test/java/
 │     └─ ... some Java test classes
 ├─ target
 │  └─ site
 │  │  ├─ ... some web files
 │  │  └─ index.html    // Dev documentation entry-point
 │  └─ xxx.jar          // Java archive
 ├─ pom.xml             // Maven build configuration file
 ├─ docker-compose.yml  // Docker-compose configuration file
 ├─ Dockerfile          // Docker build configuration file
 └─ README.md           // the file you're reading right now
```
