## Description
This project provides an opportunity for users to create groups and events.
Also users can check their upcoming events (which are within a radius of 1 km and which will occur within 24 hours).

  
## Prerequisites
 - JDK 1.7 or later
 - Maven 3 or later

## Run
> mvn spring-boot:run

Application start on port 8070

## Stack
* Spring Boot
* Spring Security
* Mongo DB
* Maven
* Java Servlets
* Bootstrap 3
* JSTL
* JSP

## Functions application:
* Registration users
* Login
* Logout
* Creating groups
* Creating events
* Set user coordinate
* Checking for near events

## Logging
All actions performed by users are logged are logged into a special logfile (log_file.log) and displayed on the console.
All logging is done using the library (Log4j), whose configuration is in the resource directory.