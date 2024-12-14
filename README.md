BACKGROUND INFORMATION

API status codes [3 digit codes]

1xx - informational
2xx - successful
3xx - redirection
4xx - client error
5xx - server

Common codes

200 OK
201 Created
204 No Content [nothing to return]
301 Moved permanently
400 Bad request
401 Unauthorised
404 Not found [trying to find a url that doesn't exist]
500 Internal server error

Types of request

Get
Post [create something new onto the server]
Put [update some information already on the server]
Delete

Spring Boot

We have different layers

Presentation Layer
has controller classes which accept input from user, validate it and pass it on to Service layer.
Service Layer
has the API logic. Interacts with both presentation layer and data layer
Data Access Layer
interacts with database

pom.xml - contains all the dependencies needed for the project
appllication.properties - contains all the environment variables
maven is just a build management tool

------------------------------------------------------------------------------------------------------
PROJECT DESCRIPTION

This is a job application in which the user can access and update information about jobs in different 
companies with each company having its own reviews. The project will have 3 layers [Presentation, Service,
Data Access].

------------------------------------------------------------------------------------------------------
PROJECT PHASE 1 [Creating the logic for Jobs and Companies]

This will only consist of the controller and service layer which will handle different Jobs.
// GET mapping implies that this is a get method
// POST mapping implies that this is a post method
// @RequestBody means that the parameter will be supplied by the request body.

We use the HttpStatus Class to return http codes.
Example Usage -

Before
- 
public Job getJobById(@PathVariable Long id){
Job job = jobService.getJobById(id);
if (job != null){
return job;
}
return new Job(1L, "Test Job", "Test Job", "30000", "50000", "Test Location" );
}

After
-
public ResponseEntity<Job> getJobById(@PathVariable Long id){
Job job = jobService.getJobById(id);
if (job != null){
return new ResponseEntity<>(job, HttpStatus.OK);
}
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}

------------------------------------------------------------------------------------------------
PROJECT PHASE 2 [Add Reviews to each job in a company + H2 database]

JPA [Java Persistence API] - allows us to map Java objects to tables in a relational database.
- Used JPA to handle jobs and modified all the methods in the JobImplementation to use JobRepository
interface which extends the JpaRepository interface.
- Every class managed by Jpa has to be declared as @Entity
- Used H2 Database Engine to test the database
- Add companies and reviews functionality

--------------------------------------------------------------------------------------------------
PROJECT PHASE 3 [Implementing Docker containers and migrating to Postgres]

Spring Boot Actuator - provides built in production ready features to monitor and manage the 
                       application.
Actuator Endpoints
/health - shows application health info, useful for checking status of application, database
          connectivity, disk space and custom health checks.
/info - application version, git commit info etc.
/metrics, /loggers, /beans

Docker is an open source platform that allows you to automate the deployment, scaling and management
of applications using containers.

Difference between Virtual Machines and Docker
Size - Relatively large and resource intensive.
       Lightweight and Resource Efficient
Startup time - longer boot time as full OS needs to start
                shorter time as no OS
Memory - consumes more system resources.
         fewer system resources
Isolation - Strong isolation between VM's
            Isolated but shares host OS kernel
Portability - Portable but requires OS compatibility
              Highly portable independent of host OS

Docker Terminology

Docker Images - templates that define the container and its dependencies.
Container - runtime environments created from Docker Images
Docker Engine - Manages Containers
DockerFile - file that contains instructions to build a Docker Image.
Docker Hub - Cloud based registry which holds  vast collection of Docker images.

// we do not need to define a new docker file as when working with spring boot we can 
// just make use of the maven plugin dependency.
Command: ./mvnw spring-boot:build-image "-Dspring-boot.build-image.imageName=Fsherwani/jobapp"

Migrating from H2 database to PostgresSQL.
H2 database is more suitable for development and testing purposes.

Docker compose file is used to manage the containers easily rather than doing it on the
command line.

--------------------------------------------------------------------------------------------------
PROJECT PHASE 4 [Restructuring the app to microservices architecture - more scalable and flexible]

Planning the changes:
Stage 1
- We will have 3 different applications [Company, Job , Reviews] running on 3 different ports
- For the end user it will be like interacting with one app.







