# Spring Boot Web MVC – Conceptual Explanation (HashMap as Database)

## 1. Project Overview

This project is a **Spring Boot RESTful web application** built using **Spring Web MVC** provided by `spring-boot-starter-web`. The application exposes REST APIs for managing users and a simple test API. Instead of using a real database, it uses a **HashMap as an in-memory database** to store user objects.

The design is suitable for:

* MCA semester exams
* Viva explanations
* REST API fundamentals
* Interview machine-round discussions

---

## 2. Role of `spring-boot-starter-web`

`spring-boot-starter-web` enables full **Web MVC functionality** in Spring Boot. It provides:

* Spring MVC framework
* REST API support
* Embedded servlet container (Tomcat)
* Automatic JSON handling
* Request routing and response processing

It removes the need for manual servlet configuration and external server deployment.

---

## 3. Web MVC Architecture Concept

The application follows **Spring MVC architecture**, which is based on the **Front Controller pattern**.

### Conceptual Flow:

1. Client sends an HTTP request
2. Request is intercepted by **DispatcherServlet**
3. DispatcherServlet identifies the matching endpoint
4. Controller handles the request
5. Service layer performs business logic
6. HashMap acts as the data store
7. Response is converted to JSON
8. JSON response is sent back to client

---

## 4. DispatcherServlet (Core Component)

DispatcherServlet is the **central controller** in Spring MVC.

Its responsibilities include:

* Receiving all incoming HTTP requests
* Mapping requests to controllers
* Managing request parameters
* Invoking message converters
* Returning the final HTTP response

Spring Boot configures it automatically without manual setup.

---

## 5. HashMap as In-Memory Database

### Concept

A **HashMap** is used to store user objects in memory, where:

* Key = User ID
* Value = User Object

### Characteristics

* Fast access (constant-time lookup)
* Data stored in RAM
* Data lost when application restarts
* No persistence or transaction support

### Purpose

* Simplify learning
* Avoid database configuration
* Focus on REST and MVC concepts

---

## 6. Layered Architecture

### Model Layer

* Represents application data
* Defines the structure of a user
* Objects stored in HashMap

### Service Layer

* Contains business logic
* Performs CRUD operations
* Manages interaction with HashMap
* Keeps controllers lightweight

### Controller Layer

* Exposes REST endpoints
* Handles HTTP requests
* Returns JSON responses
* Does not contain business logic

---

## 7. REST API Design Principles

The application follows REST principles:

* Stateless communication
* Resource-based URLs
* Proper use of HTTP methods
* JSON-based data exchange
* Clear separation of concerns

---

## 8. Conceptual Explanation of Endpoints

### 1. `/api/hello` (GET)

* Test endpoint
* Used to verify application is running
* Returns a simple message

---

### 2. `/user` (POST)

* Creates a new user
* Accepts user data in JSON format
* Stores user object in HashMap

Conceptually:

> Client sends data → Object created → Stored in memory

---

### 3. `/user` (GET)

* Retrieves all users
* Reads all values from HashMap
* Returns list of users as JSON

Conceptually:

> Read entire in-memory database

---

### 4. `/user/{id}` (GET)

* Retrieves a single user
* ID is passed through URL
* HashMap lookup using ID as key

Conceptually:

> Primary key-based search

---

### 5. `/user/{id}` (PUT)

* Updates an existing user
* Replaces old object with new data
* Uses ID to identify user

Conceptually:

> Overwrite existing record

---

### 6. `/user/{id}` (DELETE)

* Deletes a user
* Removes entry from HashMap
* Returns confirmation message

Conceptually:

> Remove record from memory

---

## 9. JSON Handling Concept

Spring Boot uses **Jackson** internally to:

* Convert JSON requests into Java objects
* Convert Java objects into JSON responses

This process is automatic and handled by **HTTP Message Converters**.

---

## 10. Embedded Server Concept

* Application runs on embedded Tomcat
* Starts using `main()` method
* No WAR file or external server required
* Default port is 8080

---

## 11. Why HashMap Instead of Database?

Reasons:

* No database setup required
* Faster development
* Ideal for learning and exams
* Focus on REST API flow

Limitations:

* Data loss on restart
* No persistence
* Not production-ready

---

## 12. Advantages of This Approach

* Simple and lightweight
* Clean separation of layers
* Easy to understand
* Demonstrates full REST lifecycle

---

## 13. Limitations

* No permanent data storage
* No transaction management
* No concurrency control
* Not scalable for real-world systems

---

## 14. Upgrade Path (Conceptual)

This design can later be extended by:

* Replacing HashMap with JPA repository
* Adding MongoDB or MySQL
* Adding validation
* Adding global exception handling
* Adding authentication and authorization

---

## 15. Exam / Interview Ready Summary

This is a Spring Boot Web MVC REST application using `spring-boot-starter-web`. It follows layered architecture and REST principles. User data is stored in an in-memory HashMap acting as a database. CRUD operations are exposed through REST endpoints, and JSON handling is done automatically by Spring Boot.
