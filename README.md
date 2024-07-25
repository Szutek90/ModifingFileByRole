# Simple design to manage files according to the degree of access.
![Install](https://img.shields.io/badge/install-passing-green)
![Install](https://img.shields.io/badge/coverage-91%25-light%20green)

The project implements a text file management system with three main classes: User, Data, and Data Processing. The system allows users (both administrators and regular users) to interact with text files to varying degrees, depending on their permissions.

The project enables the management of text files by system users. Administrators have full permissions to modify the contents of files, while ordinary users can only read data and count occurrences of given patterns. Finally, the modified file contents are saved.

## Technologies and libraries used

* Java
* Maven
* Lombok
* JUnit
* AssertJ
* Slf4j
* Log4j

## Jacoco Coverage

![App Screenshot](src/test/resources/jacoco_raport.PNG)


## Required files

* Users file with pattern:

  password1;username1;role1;id1
  password2;username2;role2;id2

* Data with pattern:

  any text

## Description

### User Class:

* Fields: describing the user, password, role (administrator or user).
* Methods: ensuring the correct operation of the class.
* Collection: storing sample objects of the User class, without repeating elements.

### Class Data:

* Field: map, where the key is the name of the text file and the value is the content of the file.
* Constructor: taking a collection of unique text file names and populating the map with data from those files.
* Methods: ensuring the correct operation of the class.

### Data Processing class:

* Field: a map whose key is an object of the User class and whose value is an object of the Data class.

Methods:
* Adding a user-data pair to the map.
* Data processing:
1. Administrator: can modify the contents of files.
2. User: can read how many times a given pattern has occurred in the files.
3. Saving modified file contents if changes were made by an administrator.

### Simulation:
An application simulating file management based on the presented scenario.