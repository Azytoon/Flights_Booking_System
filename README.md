# Flights_Booking_System app

This project was generated with Spring Initializr and based on postgres DB


## to run this project

##### from psql run this commands 
* CREATE DATABASE test;  
* \c test;  // to connect to this database
* CREATE EXTENSION "uuid-ossp";  // to can use uuid_generate_v4() method while creating tables
* SELECT uuid_generate_v4();
* CREATE TABLE users // copy from src/main/resources/db/migration/users.sql
* \i (directory of clone)/src/main/resources/db/migration/users.sql  // to import dummy data to test
* CREATE TABLE flights // copy from src/main/resources/db/migration/flights.sql
* \i (directory of clone)/src/main/resources/db/migration/flights.sql  // to import dummy data to test
* CREATE TABLE tickets // copy from src/main/resources/db/migration/tickets.sql

##### from your IDE
* open (application.properties file) and change your local database configuration like username and password
* run project from your IDE
* now if you visit http://localhost:8080/ // you should see --> Hellow in Flights_Booking_System App

## note 

flightId, ticketId & userId of type UUID like : `a734dc6c-9cbc-4396-abfb-21bd34ac5792`

## End Points Exist in this app

### flight
```
1)GET ALL FLIGHTS            -->   localhost:8080/api/flights
2)GET FLIGHT BY FLIGHT ID    -->   localhost:8080/api/flights/:flightId

3)GET FILTER FLIGHTs --> localhost:8080/api/flights/filter?from=Tofa&to=Jeddah&fareA=7000&fareB=5000
you can filter by 4 things (from, to, fareA, fareB or any combination of them)

4)POST ADD FLIGHT            -->   localhost:8080/api/flights
example of requestBody :
{
    "classA_Fare": 7000,
    "classB_Fare": 5000,
    "from": "Alex, Borg el arab",
    "departureTime": "2021-12-30 20:04:52",
    "arrivalTime": "2021-12-30 09:56:59",
    "to": "Jeddah"
}

5)DELETE FLIGHT BY ID        -->   localhost:8080/api/flights/:flightId

6)PUT UPDATE FLIGHT          -->   localhost:8080/api/flights/:flightId
example of requestBody :  you can only select fields you want to update
{
    "classA_Fare": 7000,
    "classB_Fare": 5000,
    "from": "Alex, Borg el arab",
    "departureTime": "2021-12-30 20:04:52",
    "arrivalTime": "2021-12-30 09:56:59",
    "to": "Jeddah"
}
```
### ticket
```
1)GET ALL TICKETS            -->   localhost:8080/api/tickets
2)GET TICKETS BY TICKET ID   -->   localhost:8080/api/tickets/:ticketId
3)GET TICKETS BY USER ID     -->   localhost:8080/api/tickets/:userId
4)GET TICKETS BY FLIGHT ID   -->   localhost:8080/api/tickets/:flightId

5)POST ADD TICKET            -->   localhost:8080/api/tickets
example of requestBody :
{
    "flightId" : "463945b0-dd1f-4484-ad07-3cdd30dd5887",
    "userId" : "22603d5e-3826-4f93-bf24-951cacdab2fe",
    "ticketClass": "classA"
}

6)DELETE TICKET BY ID        -->   localhost:8080/api/tickets/:ticketId

7)PUT UPDATE TICKET CLASS    -->   localhost:8080/api/tickets/:ticketId?updatedClass=classB
updatedClass parameter can be only classA or classB to update
```

### user
```
1)GET ALL USERS              -->   localhost:8080/api/users

2)POST ADD USER              -->   localhost:8080/api/users
example of requestBody :
{
    "Name": "Ahmed Zaytoun"
}

3)DELETE USER BY ID          -->   localhost:8080/api/users/:userId

4)PUT UPDATE USER            -->   localhost:8080/api/users/:userId
example of requestBody :  
{
    "Name" : "Ahmed Mahmoud"
}
```