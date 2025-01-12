# Job Application Management System

## Overview
This project is a **Job Application Management System** designed to allow users to access and update information about jobs in various companies, with each company featuring its own set of reviews. The application is structured into three main layers:

1. **Presentation Layer**: Handles user input, validation, and passes data to the Service Layer.
2. **Service Layer**: Contains business logic and coordinates between the Presentation and Data Access layers.
3. **Data Access Layer**: Interacts with the database for CRUD operations.

The project employs **Spring Boot** for application development, **Docker** for containerization, and transitions from **H2** to **PostgreSQL** for database management.

---

## Features

### HTTP Status Codes

- **1xx** - Informational
- **2xx** - Successful
- **3xx** - Redirection
- **4xx** - Client Error
- **5xx** - Server Error

**Common Codes:**
- `200 OK`
- `201 Created`
- `204 No Content` - No response body.
- `301 Moved Permanently`
- `400 Bad Request`
- `401 Unauthorized`
- `404 Not Found`
- `500 Internal Server Error`

### HTTP Methods

- **GET**: Retrieve data from the server.
- **POST**: Create new data on the server.
- **PUT**: Update existing data on the server.
- **DELETE**: Remove data from the server.

### Key Components

- **`pom.xml`**: Lists project dependencies.
- **`application.properties`**: Defines environment variables.
- **Maven**: A build management tool.

---

## Project Phases

### Phase 1: Core Logic for Jobs and Companies

**Objective:** Implement the controller and service layers to manage jobs.

**Highlights:**
- Mapped HTTP methods using annotations like `@GetMapping` and `@PostMapping`.
- Used `@RequestBody` to pass request body parameters.
- Returned HTTP status codes using `HttpStatus`.

**Code Example:**

*Before:*
```java
public Job getJobById(@PathVariable Long id) {
    Job job = jobService.getJobById(id);
    if (job != null) {
        return job;
    }
    return new Job(1L, "Test Job", "Test Job", "30000", "50000", "Test Location");
}
```

*After:*
```java
public ResponseEntity<Job> getJobById(@PathVariable Long id) {
    Job job = jobService.getJobById(id);
    if (job != null) {
        return new ResponseEntity<>(job, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
```

---

### Phase 2: Adding Reviews and H2 Database Integration

**Objective:** Enhance the system to handle company reviews and integrate a database.

**Highlights:**
- Leveraged **JPA (Java Persistence API)** to map Java objects to relational database tables.
- Annotated classes with `@Entity` for JPA management.
- Utilized **H2 Database Engine** for development and testing.
- Introduced functionality for managing companies and reviews.

---

### Phase 3: Docker Integration and PostgreSQL Migration

**Objective:** Containerize the application and transition from H2 to PostgreSQL.

**Key Concepts:**
- **Spring Boot Actuator** for production-ready monitoring and management features:
  - `/health`: Application health status.
  - `/info`: Application metadata (e.g., version, git commit).
  - `/metrics`, `/loggers`, `/beans`: Detailed monitoring data.

**Docker Concepts:**
- **Docker Images**: Templates defining the container and dependencies.
- **Containers**: Runtime environments created from Docker Images.
- **DockerFile**: File containing instructions to build a Docker Image.
- **Docker Hub**: Registry for Docker images.
- **Docker Compose**: Simplifies container management with configuration files.

**Commands:**
```bash
./mvnw spring-boot:build-image "-Dspring-boot.build-image.imageName=Fsherwani/jobapp"
```

**Database Migration:** Transitioned to **PostgreSQL**, suitable for production use, while retaining H2 for testing.

---

### Phase 4: Restructuring to Microservices Architecture

**Objective:** Improve scalability and flexibility by restructuring the app into microservices.

**Plan:**
- Split the application into three services: **Company**, **Job**, and **Reviews**, each running on separate ports.
- Maintain a unified user interface for seamless interaction.

---

## Technologies Used

- **Spring Boot**
- **Docker**
- **PostgreSQL**
- **H2 Database**
- **Java Persistence API (JPA)**
- **Maven**

---

## Future Enhancements

- Implement a unified API Gateway for microservices.
- Add authentication and authorization using Spring Security.
- Optimize database queries for improved performance.

---

## Getting Started

1. Clone the repository.
2. Configure the `application.properties` file with your database credentials.
3. Build and run the application using Maven:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
4. Use Docker Compose to manage containers:
   ```bash
   docker-compose up
   ```

---

