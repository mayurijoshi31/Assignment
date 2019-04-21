Developed a Maven project to implement a simple Spring based web application with a controller
exposing the following 4 APIs Functionalities for User Details

CRUD Operations like

• GET /user
• POST /user
• PUT /user
• DELETE /user

Tools and Technologies:
Technology : Springboot, Java 1.8, Hibernate, Maven, Spring security.
Application Servicer: Apache Tomcat Server
Database : inmemory HSQL Database.
Development Platform - STS
Build Tool - Maven

Download the project and run UserApiApplication.

Spring Security Basic Authentication:
Username - user
Password - password

Sample JSON POST request.
 {
 	"id": "1",
 	"userName":"user",
 "password":"pass",
 "status":"ACTIVATED"
 }
 
 URL - localhost:9090/assignement/user
