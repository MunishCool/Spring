# Spring Boot Rest API's for tranaction between two accounts.

## Technology stack
- Java 8
- [Maven](https://maven.apache.org/)
- [H2 in memory database](https://www.h2database.com/html/main.html)
- [Maven](https://maven.apache.org/)

### Main Class

com.demo.SpringBootWithH2.SpringBootWithH2Application

### API URL Routings

All the account related end points routing is done in the class as below path.
com.demo.controller.AccountController

User API end points routing is done in class com.demo.controller.UserController


### How to run
```sh
mvn exec:java
```

Application is running in inbuilt tomcat server on localhost port 8000. H2 is a in memory database which has been exposed to this url.
http://localhost:8080/h2-console/


### Available Rest API's for Users

| HTTP METHOD | END POINT | USAGE |
| -----------| ------ | ------ |
| GET | /users | get all users | 
| POST | /user | create a new user | 
| GET | /user/{id} | get user details by userId | 
| DELETE | /user/{id} | delete user | 

### Available Rest API's for Accounts

| HTTP METHOD | END POINT | USAGE |
| -----------| ------ | ------ |
| GET | /account/{id} | get account details by accountId | 
| GET | /accounts | get all accounts | 
| POST | /account | create a new account
| DELETE | /account/{id} | remove account by accountId | 
| PUT | account/wallet/{id}/{amount} | deposit money to account | 
| POST | /transaction | perform transaction between 2 user accounts | 
| PUT | transaction/reverese/{id} | revert a transaction | 
| GET | transaction/status/{id} | get transaction status by txn id | 


### Http Status
- 200 OK: Request is ok and processed successfully.
- 400 Bad Request: Unknown parameter in a request which server doesn't know or accept.
- 404 Not Found: The requested resource is not found, or its not available in db.
- 500 Internal Server Error: The server encountered an unexpected condition or exception.


