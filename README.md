# Getting Started with Task Management App

## Prerequisites

1. Java 17
2. Preferred Java IDE  (Optional)
3. MySql

**Note: This Spring boot project version is 3.0+. So, this project needs Java 17 or higher. But this project was implemented using 17. So, Java 17 is needed to run this project.**

## Set up the Project
### 1. Download the project.
### 2. Open the project using Java IDE.
### 3. Download the maven dependencies

Most of the IDEs download maven dependencies automatically. If maven dependency is not downloaded automatically please use the below command to download maven dependencies.
#### `mvn clean compile test`

### 4. Configure the project

1. Change the parameters mentioned in the application.properties file. (TODO added)
2. Change the Cross Origin URL in the TaskRestController.java file. (TODO added)

### 5. Create a MySQL database and table

* Database Name: task_manager
* Table Name: task 

**Note: Table Create query below**

CREATE TABLE task ( id BINARY(16), task VARCHAR(255) NOT NULL, priority TINYINT, status TINYINT, timestamp VARCHAR(255), PRIMARY KEY(id) );

### 6. Run the project

Easily build and run the project using Java IDE.

If you can't run the project using IDE, please use the below command to run the project.

`mvn spring-boot:run`

***Enjoy the Project!!!***