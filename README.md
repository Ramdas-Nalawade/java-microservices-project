# QuizApp

A Java-based Quiz Application built using Spring Boot that allows users to participate in quizzes, view questions, submit answers, and receive scores based on their performance. The application demonstrates core Java development concepts, REST API development, database integration, and layered architecture best practices.

---

## 🚀 Features

* Create and manage quiz questions
* Create and manage quizzes
* Attempt quizzes
* Submit answers
* Calculate and display scores
* Store quiz-related data in a database
* Scalable layered architecture (Controller → Service → Repository)
* RESTful APIs for quiz management

---

## 🛠️ Technologies Used

### Backend

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate

### Database

* PostgreSQL

### Build Tool

* Maven

### Additional Libraries

* Lombok
* Spring Web
* Spring Boot DevTools

---

## 📋 Prerequisites

Ensure the following software is installed before running the application:

* Java JDK 17 or later
* Maven 3.8+
* PostgreSQL
* IDE (IntelliJ IDEA, Eclipse, or VS Code)

---

## ▶️ How to Run

### 1. Clone the Repository

```bash
git clone <repository-url>
cd quizapp
```

### 2. Create PostgreSQL Database

Connect to PostgreSQL and create a database:

```sql
CREATE DATABASE quizdb;
```

### 3. Configure Database Connection

Update the `application.properties` file:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/quizdb
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### 4. Build the Project

```bash
mvn clean install
```

### 5. Run the Application

Using Maven:

```bash
mvn spring-boot:run
```

Or run the main class:

```text
QuizAppApplication.java
```

### 6. Access the Application

The application will start on:

```text
http://localhost:8080
```

---

## 📂 Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.quizapp
│   │       ├── controller
│   │       ├── service
│   │       ├── repository
│   │       ├── entity
│   │       ├── model
│   │       └── QuizAppApplication.java
│   └── resources
│       └── application.properties
│
└── test
```

---

## 🔮 Future Enhancements

* User Authentication and Authorization (Spring Security + JWT)
* Quiz Categories
* Timer-Based Quizzes
* Leaderboard and Rankings
* Swagger/OpenAPI Documentation
* Quiz History Tracking
* Difficulty Levels for Questions
* Admin Dashboard

---

## 👨‍💻 Author

Developed as a Spring Boot learning project to demonstrate:

* REST API Development
* Spring Data JPA & Hibernate
* PostgreSQL Integration
* Layered Architecture
* Maven Project Management
* Backend Development Best Practices

---
