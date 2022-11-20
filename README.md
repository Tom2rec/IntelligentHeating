# IntelligentHeating

---

## Authors
- Jakub Woźniak
- Sebastian Zdybiowski
- Mateusz Szymonek
- Tomasz Turek

# Requirements:
- JDK 17
- Maven
- Docker

# Connect to database using psql
````
export PGPASSWORD='admin'; psql -h localhost -d heatingsystem -U db -p 5431
````

# Prepare local database
````
create user db with encrypted password 'admin';
create database heatingsystem;
\connect heatingsystem
create schema heatingsystem;
grant all privileges on database heatingsystem to db;
grant all privileges on schema heatingsystem to db;
````

# Swagger
http://localhost:8880/heatingsystem/api/swagger-ui/index.html