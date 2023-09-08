# Java-backend-Spring-boot-MySQL-login-logout-Authentication-System
* Java Backend Spring Boot Authentication System is a comprehensive and secure authentication solution developed using the Spring Boot framework. This system integrates various essential components, including Spring Security, JWT (JSON Web Tokens), and MySQL, to establish a robust user authentication experience. It offers features such as user registration, login, role-based access control, and secure logout functionality.

# Table of Contents
* Features
* Technologies Used
* Project Structure
* The main packages are
* Dependencies
* How to Run
* Usage
* Handling Bad Credentials
* Additional Note



# Features
* User registration with username, email, and password
* User login with username or email and password
* Role-based access control with "ROLE_USER" and "ROLE_ADMIN" roles
* Admin panel accessible only to users with "ROLE_ADMIN" role
* Token-based authentication using JSON Web Tokens (JWT)
* Logout functionality

# Technologies Used
* Java 8
* Spring Boot
* Spring Security
* Spring Data JPA
* JWT (JSON Web Tokens)
* MySQL
* Maven
* JUnit and Mockito for testing

# Project Structure

* The project follows the standard Spring Boot project structure with separate packages for
* controllers,
* services,
* repositories,
* entities,
* payloads, and
* utils,
* security configuration.

 # The main packages are:
* com.woromedia.auth.api.controller: Contains the REST API controllers.
* com.woromedia.auth.api.entity: Contains JPA entity classes.
* com.woromedia.auth.api.payload: Contains payload classes for request and response.
* com.woromedia.auth.api.repository: Contains JPA repositories.
* com.woromedia.auth.api.security: Contains security-related classes like JWT token provider,
  custom user details service, and authentication filter.
* com.woromedia.auth.api.service: Contains service interfaces and their implementations.
* com.woromedia.auth.api.utils: Contains utility classes.

# Dependencies

The project uses the following dependencies:

* Spring Boot Starter Web: This dependency enables the development of web applications using Spring Boot.
  It provides essential components for building RESTful APIs.

* Spring Boot Starter Data JPA: This dependency enables JPA (Java Persistence API) support
   in the application. It simplifies the interaction with the database.

* Spring Boot Starter Security: This dependency provides security support for Spring Boot
  applications. It allows you to secure your API endpoints and handle authentication and authorization.

* Spring Boot Starter Validation: This dependency enables validation support
  for the request payloads. It allows you to enforce constraints on the incoming request data.

* JUnit: This dependency is used for writing unit tests.

* Mockito: This dependency is used for mocking objects in unit tests.

* JWT (JSON Web Tokens): This dependency provides support for generating and validating JSON Web Tokens for token-based authentication.

* MySQL Connector/J: This dependency provides the MySQL JDBC driver to connect the application with the MySQL database.

# How to Run
Follow the steps below to run the application:

* Clone the repository to your local machine.
* Make sure you have Java 8 and MySQL installed and running.
* Set up the database by configuring the application.properties file with the correct database URL, username, and password.
  * (my mysql database is authentication_system , so create only database with any name as per your requirement)
* Run the application using Intellij IDE.

* This is my application.properties
```http
* #Database Configuration
* spring.datasource.url=jdbc:mysql://localhost:3306/authentication_system  <---Add your database name only

* spring.datasource.username=****    <--Add your database username

* spring.datasource.password=****    <--Add your database password

* #Enable SQL query logging
spring.jpa.show-sql=true

*  #Hibernate DDL auto
spring.jpa.hibernate.ddl-auto=update

 * #Hibernate properties
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

* #App Properties
app.jwt-secret=JWTSecretKey
app.jwt-expiration-milliseconds=604800000

```


# Usage
You can interact with the API endpoints using Postman or any other API testing tool.I am using Postman

* Handling API Endpoints with Different Responses
 
* 1 User Registration Endpoint:

 URL:
* Method POST: http://localhost:8080/api/auth/register
     Select --> Body --> raw --> JSON
Request Body:
```http
*  JSON Structure
 {
"username": "woromedia_1",
"password": "password123",
"email": "woromedia_1@example.com"
 }
```
click on ---> Send  
* Response: HTTP 200 OK with "User registered successfully" message.

![User_register](https://github.com/SDEParag/Java-backend-Spring-boot-MySQL-login-logout-Authentication-System/assets/137553676/9f503ac4-834d-409e-ad7c-01bcd9c40558)

* Bad Credentials: If the provided username or email is already taken, 
the endpoint returns HTTP 400 Bad Request with an appropriate error message.


![User_already](https://github.com/SDEParag/Java-backend-Spring-boot-MySQL-login-logout-Authentication-System/assets/137553676/0f9feb76-23f0-49a8-b731-46c75834ed67)



* 2 User Login Endpoint:

URL:
* Method POST: http://localhost:8080/api/auth/login
     Select --> Body --> raw --> JSON
Request Body:
```http
*  JSON Structure
{
  "usernameOrEmail": "woromediaintern_1",
  "password": "password123"
}
```
* Response: HTTP 200 OK with a JWT token in the response body.

![login](https://github.com/SDEParag/Java-backend-Spring-boot-MySQL-login-logout-Authentication-System/assets/137553676/c17d8308-a24b-4d27-af94-39571bd7d8df)

* JWT token (On successful login):
```http
    {
       "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ3b3JvbWVkaWFfMUBleGFtcGxlLmNvb
         SIsImlhdCI6MTY5MTcwOTA0NywiZXhwIjoxNjkyMzEzODQ3fQ.d4GRTnppSYzlONRFleCqRbRgi7WsJe_fxv6Ui
           EOpfl9h5sr5FG5D3EQ9IdkKGNxZVKnNbKTU-hZi_bPtRMtafg",
         "tokenType": "Bearer"
    }
  ```
* Bad Credentials: If the provided username or email and password combination is invalid, the endpoint returns HTTP 401 Unauthorized with an error message.

![wrong input password or username](https://github.com/SDEParag/Java-backend-Spring-boot-MySQL-login-logout-Authentication-System/assets/137553676/139656f1-a667-4ad8-8817-49c04fbe48ae)


* 3 Admin Panel Endpoint:
```http
URL:
* Method GET : http://localhost:8080/api/auth/admin
  
   * Select --> Authorization --> Bearer token --> copy login token  paste in Token like below,
 
Token:
[eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ3b3JvbWVkaWFfMUBleGFtcGxlLmNvbSIsImlhdCI6MTY5MTcwOTA0NywiZXhwI
joxNjkyMzEzODQ3fQ.d4GRTnppSYzlONRFleCqRbRgi7WsJe_fxv6UiEOpfl9h5sr5FG5D3EQ9IdkKGNxZVKnNbKTU-hZi_bPtRMtafg] 
```

Click on Send
* Response: HTTP 200 OK with "Admin Panel" message.

![Admin](https://github.com/SDEParag/Java-backend-Spring-boot-MySQL-login-logout-Authentication-System/assets/137553676/0478778a-7aa7-4764-8553-7e0407ec3a2d)
 
* Authorization Error: If a user without the "ROLE_ADMIN" role tries to access
 this endpoint, the application returns HTTP 403 Forbidden with an error message.

![wrong input jwt  token](https://github.com/SDEParag/Java-backend-Spring-boot-MySQL-login-logout-Authentication-System/assets/137553676/125a8442-8b90-4119-a480-14fd02263f9f)

* User Logout Endpoint:

URL:
* Method POST : http://localhost:8080/api/auth/logout
* Click on Send 
* Response: HTTP 200 OK with "Logged out successfully" message

![logout](https://github.com/SDEParag/Java-backend-Spring-boot-MySQL-login-logout-Authentication-System/assets/137553676/a4f51992-80b1-4c83-bce4-a4e83642e79b)

* Easily Collect User Registration Data with Postman, Keep it Safe in a MySQL Database, and Improve the User Signup Process.

![authentication_system roles](https://github.com/SDEParag/Java-backend-Spring-boot-MySQL-login-logout-Authentication-System/assets/137553676/a6e4647f-3106-47b4-a118-2682dfb565b7)

![authentication_system user_roles](https://github.com/SDEParag/Java-backend-Spring-boot-MySQL-login-logout-Authentication-System/assets/137553676/ec1e89ff-ac89-4ed3-8954-fa7a0d1a1e6a)

![authentication_system users](https://github.com/SDEParag/Java-backend-Spring-boot-MySQL-login-logout-Authentication-System/assets/137553676/a8424f77-9bbd-4ab7-9dc1-ca586708622d)


# Handling Bad Credentials
* If the provided username or email during registration is already taken, the application returns HTTP 400 Bad Request with an appropriate error message.

* If the provided username or email and password combination during login is invalid, the application returns HTTP 401 Unauthorized with an error message.
  
# Additional Note
Remember to configure the application.properties file with the correct database connection details and secret key for JWT token generation.
