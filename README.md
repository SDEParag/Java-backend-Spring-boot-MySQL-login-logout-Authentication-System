![authentication_system roles](https://github.com/SDEParag/Java-backend-Spring-boot-MySQL-login-logout-Authentication-System/assets/137553676/a6e4647f-3106-47b4-a118-2682dfb565b7)

![authentication_system user_roles](https://github.com/SDEParag/Java-backend-Spring-boot-MySQL-login-logout-Authentication-System/assets/137553676/ec1e89ff-ac89-4ed3-8954-fa7a0d1a1e6a)

![authentication_system users](https://github.com/SDEParag/Java-backend-Spring-boot-MySQL-login-logout-Authentication-System/assets/137553676/a8424f77-9bbd-4ab7-9dc1-ca586708622d)

# Java-backend-Spring-boot-MySQL-login-logout-Authentication-System
| Java backend |  Simple authentication  system using Spring Security, JWT, MySQL, and authenticate users with the login and logout  functionalities.

This is a Spring Boot-based authentication system developed for the Woro-media assignment. It provides user registration, login, role-based access control, and logout functionalities.

# Table of Contents
* Features
* Technologies Used
* Project Structure
* How to Run
* Usage
* Testing
* Database Configuration
* Contact

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
*  repositories,
*   entities,
*   payloads, and
*    utils,
*    security configuration.

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

* Spring Boot Starter Web: This dependency enables the development of web applications using Spring Boot. It provides essential components for building RESTful APIs.

* Spring Boot Starter Data JPA: This dependency enables JPA (Java Persistence API) support in the application. It simplifies the interaction with the database.

* Spring Boot Starter Security: This dependency provides security support for Spring Boot applications. It allows you to secure your API endpoints and handle authentication and authorization.

* Spring Boot Starter Validation: This dependency enables validation support for the request payloads. It allows you to enforce constraints on the incoming request data.

* JUnit: This dependency is used for writing unit tests.

* Mockito: This dependency is used for mocking objects in unit tests.

* JWT (JSON Web Tokens): This dependency provides support for generating and validating JSON Web Tokens for token-based authentication.

* MySQL Connector/J: This dependency provides the MySQL JDBC driver to connect the application with the MySQL database.
