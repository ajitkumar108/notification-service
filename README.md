# Notification Service

A Spring Boot based Notification Service that supports JWT Authentication, Role-Based Authorization, Kafka Messaging, Redis Caching, Docker Deployment, and Unit Testing.

## Features

- JWT Authentication
- Role-Based Authorization (ADMIN, USER)
- Notification Management
- User Preference Management
- Kafka Producer & Consumer
- Redis Caching
- Swagger Documentation
- Docker Support
- Unit Testing using JUnit & Mockito

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Security
- JWT
- MySQL
- Hibernate
- JPA
- Kafka
- Redis
- Docker
- Swagger
- JUnit 5
- Mockito

## Architecture

```text
Client
   |
   ▼
Spring Boot API
   |
   ├── JWT Security
   ├── Redis Cache
   ├── Kafka Producer
   ├── Kafka Consumer
   └── MySQL
```

## Kafka Flow

```text
POST /notifications
       |
       ▼
Kafka Producer
       |
       ▼
notification-topic
       |
       ▼
Kafka Consumer
```

## Redis Flow

```text
GET /notifications
      |
      ▼
Redis Cache
      |
      ▼
MySQL (Cache Miss)
```

## API Endpoints

### Authentication

```http
POST /auth/register
POST /auth/login
```

### Notifications

```http
POST /notifications
GET /notifications
DELETE /notifications/{id}
```

## Run Application

```bash
mvnw spring-boot:run
```

## Run Tests

```bash
mvn test
```

### Tests Implemented

- NotificationServiceTest
- NotificationControllerTest
- JwtUtilTest

## Docker

Build Image

```bash
docker build -t notification-service .
```

Run Container

```bash
docker run -p 8080:8080 notification-service
```

## Swagger

```text
http://localhost:8080/swagger-ui.html
```

## Author

Ajit Kumar
