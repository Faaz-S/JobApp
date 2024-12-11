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
PROJECT PHASE 1

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
PROJECT PHASE 2

JPA [Java Persistence API] - allows us to map Java objects to tables in a relational database.
- Used JPA to handle jobs and modified all the methods in the JobImplementation to use JobRepository
interface which extends the JpaRepository interface.
- Used H2 Database Engine to test the database
- Add companies and reviews functionality


