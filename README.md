# Java Coding Challenge - Task Management API Suite

This is a maven project which uses an embedded derby database to store tasks in a table.

The table structure is provided below:

**Table name** - *tasks*

**Table columns:**
- *id* int not null generated always as identity,
- *title* varchar(256) not null,
- *description* varchar(1024),
- *due_date* date,
- *status* varchar(10),
- *creation_date* date not null,
- *primary key (id)*

Your challenge is to build a production grade API suite that uses HTTP to allow users to manage their task data. 

## Requirements

You will need to provide APIs for the following actions:  
 
1. Fetch all tasks.
1. Fetch all overdue tasks.
1. Fetch data for a single task.
1. Add a new task.
1. Modify a task.
1. Delete a task.


## Pre-requisites
1. Java needs to be installed on the system and environment variable JAVA_HOME should be set correctly to the JDK path.  
   Check by running below command in command prompt  
   `java -version`  
2. Maven needs to be installed on the system.  
   Check by running below command in command prompt  
   `mvn -v`  

## Run the application
This project implemented using springboot framework.
To run this project:
1. Run SpringbootApplication main class
2. Create a docker image and run spring-boot
   1. docker build --file Dockerfile --tag demo-test .
   2. docker run --rm -it -p 127.0.0.1:8080:8080 demo-test

## Enhancements
1. Unit test and API test need to be implemented.
2. Javadoc needs to be added to the code.
3. Docker image can be deployed to the cloud.

