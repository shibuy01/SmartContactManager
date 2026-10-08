# 📇 Smart Contact Manager

<p align="center">
  <strong>A Secure Contact Management Web Application built with Spring Boot, Spring Security, Hibernate and MySQL</strong>
</p>

<p align="center">
  <a href="https://github.com/shibuy01/SmartContactManager">
    <img src="https://img.shields.io/badge/GitHub-Repository-black?style=for-the-badge&logo=github" alt="GitHub"/>
  </a>
  <img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk" />
  <img src="https://img.shields.io/badge/Spring%20Boot-4.0.4-brightgreen?style=for-the-badge&logo=springboot" />
  <img src="https://img.shields.io/badge/Spring%20Security-6.x-green?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Hibernate-JPA-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql" />
  <img src="https://img.shields.io/badge/Docker-Ready-2496ED?style=for-the-badge&logo=docker" />
</p>

---

# 📇 Smart Contact Manager

---

## 📌 Overview

**Smart Contact Manager** is a secure web-based contact management application developed using **Java and Spring Boot**.

The application allows users to securely manage their personal contacts through a clean web interface. It provides functionality for adding, viewing, updating, deleting and searching contacts while protecting user access using **Spring Security**.

The project follows the **MVC architecture** and uses **Spring Data JPA / Hibernate** for database persistence.

The application also includes validation, email functionality, Thymeleaf-based server-side rendering and Docker support.

---

# 🚀 Live Demo

🔗 **Live Application:** https://smartcontactmanager-ok52.onrender.com

> 🌐 The Smart Contact Manager application is deployed on **Render**.

---

# ✨ Features

### 👤 User Management

* User registration
* User login
* Secure authentication
* User-specific contact management
* Profile management
* Form validation

### 📇 Contact Management

* Add new contacts
* View contacts
* Update contacts
* Delete contacts
* Search contacts
* Contact details management
* User-specific contact data

### 🔐 Security

* Spring Security authentication
* Secure login
* Role-based access support
* Protected application routes
* User authorization
* Password security

### 🔎 Search

* Search contacts efficiently
* Search by contact information
* User-specific search results

### 📧 Email

* Spring Boot Mail integration
* Email-based functionality
* SMTP configuration support

### 🎨 User Interface

* Thymeleaf templates
* HTML
* CSS
* Bootstrap
* Responsive design
* Server-side rendered pages

### 🐳 Docker

* Dockerized Spring Boot application
* Multi-stage Docker build
* Maven-based Docker build
* Production-ready container structure

---

# 🏗️ Application Architecture

```text
                         ┌──────────────────────┐
                         │        USER          │
                         │      Web Browser     │
                         └──────────┬───────────┘
                                    │
                                    ▼
                         ┌──────────────────────┐
                         │     Thymeleaf UI     │
                         │    HTML / Bootstrap  │
                         └──────────┬───────────┘
                                    │
                                    ▼
                         ┌──────────────────────┐
                         │   Spring MVC Layer   │
                         │     Controllers      │
                         └──────────┬───────────┘
                                    │
                                    ▼
                         ┌──────────────────────┐
                         │    Service Layer     │
                         │   Business Logic     │
                         └──────────┬───────────┘
                                    │
                                    ▼
                         ┌──────────────────────┐
                         │ Repository Layer     │
                         │ Spring Data JPA      │
                         └──────────┬───────────┘
                                    │
                                    ▼
                         ┌──────────────────────┐
                         │    MySQL Database    │
                         └──────────────────────┘


                         ┌──────────────────────┐
                         │   Spring Security    │
                         │ Authentication/Auth  │
                         └──────────────────────┘
```

---

# 🛠️ Tech Stack

| Category         | Technologies                    |
| ---------------- | ------------------------------- |
| Language         | Java 17                         |
| Framework        | Spring Boot 4.0.4               |
| Web              | Spring MVC                      |
| Security         | Spring Security                 |
| ORM              | Hibernate / JPA                 |
| Template Engine  | Thymeleaf                       |
| Validation       | Spring Boot Validation          |
| Database         | MySQL                           |
| Database Support | PostgreSQL                      |
| Email            | Spring Boot Mail                |
| Frontend         | HTML, CSS, Bootstrap, Thymeleaf |
| Build Tool       | Maven                           |
| Containerization | Docker                          |
| Deployment       | Render                          |
| Version Control  | Git / GitHub                    |
| IDE              | IntelliJ IDEA                   |
| API Testing      | Postman                         |

The repository's Maven configuration currently defines Spring Boot 4.0.4 with Java 17 and dependencies including JPA, Security, Thymeleaf, Validation, Mail and MySQL/PostgreSQL drivers.

---

# 🔐 Security

The application uses **Spring Security** for authentication and authorization.

Security features include:

* User authentication
* Protected routes
* Secure login
* Authorization
* Role-based access
* User-specific data access
* Password protection

Spring Security and Thymeleaf Spring Security integration are included in the project's Maven dependencies.

---

# 📸 Screenshots

> Add your actual screenshots inside the `screenshots` folder.

## 🏠 Home Page

[Smart Contact Manager Home](https://chatgpt.com/c/screenshots/home-page.png)

---

## 🔐 Login Page

[Login Page](https://chatgpt.com/c/screenshots/login-page.png)

---

## 📝 Registration Page

[Registration Page](https://chatgpt.com/c/screenshots/register-page.png)

---

## 📇 Contact Dashboard

[Contact Dashboard](https://chatgpt.com/c/screenshots/contact-dashboard.png)

---

## ➕ Add Contact

[Add Contact](https://chatgpt.com/c/screenshots/add-contact.png)

---

## 🔎 Search Contact

[Search Contact](https://chatgpt.com/c/screenshots/search-contact.png)

---

## 👤 Contact Details

[Contact Details](https://chatgpt.com/c/screenshots/contact-details.png)

---

# 📁 Project Structure

```text
SmartContactManager/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/demo/
│   │   │
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       └── application.properties
│   │
│   └── test/
│
├── .mvn/
│   └── wrapper/
│
├── Dockerfile
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── README.md
```

---

# 🚀 Getting Started

## Prerequisites

Make sure you have installed:

* Java 17+
* Maven
* MySQL
* Git
* Docker
* IntelliJ IDEA / Eclipse / STS

---

# 📥 Clone Repository

```bash
git clone https://github.com/shibuy01/SmartContactManager.git
```

Go inside the project:

```bash
cd SmartContactManager
```

---

# 🗄️ Database Configuration

Create a MySQL database:

```sql
CREATE DATABASE smartcontactmanager;
```

Configure your database credentials in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/smartcontactmanager
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> ⚠️ Do not commit real database passwords to GitHub.

---

# ▶️ Run the Application

Using Maven:

```bash
mvn spring-boot:run
```

Or on Windows:

```bash
.\mvnw.cmd spring-boot:run
```

The application will normally be available at:

```text
http://localhost:8080
```

---

# 🐳 Docker

The repository contains a multi-stage Dockerfile that builds the application using Maven and then runs the generated Spring Boot JAR using Eclipse Temurin Java 17.

### Build Docker Image

```bash
docker build -t smart-contact-manager .
```

### Run Container

```bash
docker run -p 8080:8080 smart-contact-manager
```

Application:

```text
http://localhost:8080
```

---

# 🔄 Application Flow

```text
User
 │
 ▼
Login / Register
 │
 ▼
Spring Security
 │
 ▼
Authenticated User
 │
 ▼
Contact Dashboard
 │
 ├── Add Contact
 │
 ├── View Contact
 │
 ├── Update Contact
 │
 ├── Delete Contact
 │
 └── Search Contact
 │
 ▼
Spring MVC
 │
 ▼
Service Layer
 │
 ▼
Spring Data JPA / Hibernate
 │
 ▼
MySQL
```

---

# 🧪 Testing

The application can be tested through:

* Browser
* Postman
* Spring Boot tests

Important application areas to test:

```text
✓ User Registration
✓ User Login
✓ Authentication
✓ Add Contact
✓ View Contact
✓ Update Contact
✓ Delete Contact
✓ Search Contact
✓ Validation
✓ Authorization
```

---

# ☁️ Deployment

The application is deployed on **Render** using Docker.

### 🚀 Production Deployment

**Platform:** Render

**Live URL:** https://smartcontactmanager-ok52.onrender.com

### Production Architecture

```text
                     Internet
                        │
                        ▼
                ┌───────────────┐
                │    Render     │
                │ Cloud Platform│
                └───────┬───────┘
                        │
                        ▼
                ┌───────────────┐
                │    Docker     │
                │ Spring Boot   │
                └───────┬───────┘
                        │
                        ▼
                ┌───────────────┐
                │     MySQL     │
                │    Database   │
                └───────────────┘
```

---

# 🔒 Production Security Recommendations

For production deployment:

* Store database credentials in environment variables.
* Never commit passwords or API credentials.
* Use HTTPS.
* Configure secure cookies.
* Use strong password hashing.
* Configure CORS carefully.
* Use production database credentials.
* Keep Spring Boot and dependencies updated.
* Use environment-specific configuration.

---

# 💡 Key Learning Outcomes

This project demonstrates practical knowledge of:

* Java backend development
* Spring Boot
* Spring MVC
* Spring Security
* Authentication & Authorization
* Hibernate / JPA
* MySQL
* Server-side rendering
* Thymeleaf
* Form validation
* CRUD operations
* MVC architecture
* Email integration
* Docker
* Maven
* Git & GitHub
* Cloud deployment

---

# 🔮 Future Improvements

### 🔐 Authentication

* JWT-based authentication
* OAuth2 / Google Login
* Refresh tokens
* Advanced RBAC

### 📇 Contact Management

* Contact groups
* Contact tags
* Profile images
* Import/export contacts
* Bulk contact operations

### 📧 Communication

* Email contact directly
* Email notifications
* Password reset
* Email verification

### 🔎 Advanced Search

* Filter by category
* Search by multiple fields
* Pagination
* Sorting

### 📊 Dashboard

* Contact statistics
* Recent contacts
* User activity
* Analytics dashboard

### ☁️ DevOps

* AWS EC2 deployment
* CI/CD pipeline
* GitHub Actions
* Docker Compose
* Production monitoring

---

# 🎯 Why This Project?

**Smart Contact Manager** demonstrates how a real-world Java web application can be developed using the Spring ecosystem.

The project covers:

```text
Java
   ↓
Spring Boot
   ↓
Spring MVC
   ↓
Spring Security
   ↓
Hibernate / JPA
   ↓
MySQL
   ↓
Thymeleaf
   ↓
Docker
   ↓
Render
```

This makes it a strong portfolio project for:

**Java Developer | Java Backend Developer | Spring Boot Developer | Software Engineer**

---

# 👨‍💻 Author

## Shibu Kumar

**Java Backend Developer | Spring Boot Developer**

### Technical Skills

```text
Java
SQL
JavaScript

Spring Boot
Spring MVC
Spring Security
REST API Development
Hibernate / JPA
JWT Authentication
Microservices

React.js
HTML
CSS
Bootstrap

MySQL
PostgreSQL

Git
GitHub
Maven
Docker
IntelliJ IDEA
Postman
Swagger

Apache Kafka
Redis
Spring AI
Google Gemini
AWS EC2
CI/CD
```

---

# 🔗 Repository

**GitHub:**

https://github.com/shibuy01/SmartContactManager

---

# ⭐ Support

If you find this project useful, please consider giving the repository a ⭐ on GitHub.
