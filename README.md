# Final-restapi-

Tools and Technologies Used:

.Spring Boot 3
.JDK - 1.8 or later
.Spring MVC
.Spring Security 6
.Hibernate
.Maven
.Spring Data JPA
.Vscode
.MYSQL

Description:

This project is a backend implementation of a restapi application using Spring Boot. It provides REST APIs for user registration, login, and other related functionalities. The project utilizes H2 database for data storage and security/web tokens for authentication and authorization.

Installation and Setup:
  Spring Boot provides a web tool called Spring Initializer to bootstrap an application             quickly. Just go to https://start.spring.io/ and generate a new spring boot project.
  
  Use the below details in the Spring boot creation:

  Name: springboot-blog-rest-api

  Project Type: Maven

  Dependencies: Spring Web, Lombok, Spring Data JPA, Spring Security, Dev Tools and MySQL  

  Packaging: Jar

 Download the Spring Boot project as a zip file, unzip it and import it in Vscode.
 
Configure MySQL Database:
 
  create datbase mytask(daybase name)
 
 
Run Spring Boot Application:
 mvn spring-boot:run
 
 From your Vscode, run the Application.main() method as a standalone Java class that will start the embedded Tomcat server on port 8080 and point the browser to http://localhost:8080/.
 
 Access the application:

.To test the REST APIs, you can use tools like Postman or cURL.
.The available endpoints will be provided in the API documentation or codebase.
.Make requests to the appropriate endpoints for user registration, login, and other    
   functionalities as per the API specifications.

Security/Web Tokens:

.The project includes security/web token-based authentication and authorization.
.User registration and login APIs will generate a token upon successful authentication.
.Include the generated token in the request headers for protected endpoints requiring 
   authentication.
  
