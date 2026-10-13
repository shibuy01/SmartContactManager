# 📇 Smart Contact Manager

<p align="center">
  <strong>A Secure Contact Management Web Application built with Java, Spring Boot, Spring Security, Hibernate, and MySQL.</strong>
</p>

<p align="center">
  <a href="https://github.com/shibuy01/SmartContactManager">
    <img src="https://img.shields.io/badge/GitHub-Repository-black?style=for-the-badge&logo=github" alt="GitHub Repository"/>
  </a>
  <img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk" alt="Java 17"/>
  <img src="https://img.shields.io/badge/Spring%20Boot-4.0.4-brightgreen?style=for-the-badge&logo=springboot" alt="Spring Boot"/>
  <img src="https://img.shields.io/badge/Spring%20Security-Authentication-green?style=for-the-badge" alt="Spring Security"/>
  <img src="https://img.shields.io/badge/Hibernate-JPA-blue?style=for-the-badge" alt="Hibernate JPA"/>
  <img src="https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql" alt="MySQL"/>
  <img src="https://img.shields.io/badge/Docker-Containerized-2496ED?style=for-the-badge&logo=docker" alt="Docker"/>
</p>

---

## 📌 Overview

**Smart Contact Manager** is a web-based contact management application developed using Java and Spring Boot.

It allows users to manage their personal contacts through a web interface, with features for creating, viewing, updating, deleting, and searching contacts.

The application follows the **Model-View-Controller (MVC) architecture** and uses Spring Security for authentication, Spring Data JPA and Hibernate for database operations, and Thymeleaf for server-side rendering.

The project also includes form validation, email integration, and Docker-based deployment support.

## 🚀 Live Demo

**Live Application:** [Smart Contact Manager](https://smartcontactmanager-ok52.onrender.com)

**GitHub Repository:** [SmartContactManager](https://github.com/shibuy01/SmartContactManager)

> Note: The live application may take some time to respond if the hosting service has put it to sleep.

---

## ✨ Features

### 👤 User Management
- User registration and login
- Authentication using Spring Security
- Form validation
- User profile management
- User-specific contact management

### 📇 Contact Management
- Add new contacts
- View contact details
- Update existing contacts
- Delete contacts
- Search contacts
- Manage personal contact information

### 🔐 Security
- Spring Security integration
- Protected application routes
- Authentication and authorization
- Password protection
- User-specific access control

### 📧 Email Integration
- Spring Boot Mail integration
- SMTP configuration support
- Email-related application functionality

### 🎨 User Interface
- Thymeleaf template engine
- HTML and CSS
- Bootstrap styling
- Server-side rendered pages
- Responsive user interface

### 🐳 Docker
- Dockerized Spring Boot application
- Multi-stage Docker build
- Maven-based application build
- Containerized application deployment

---

## 🏗️ Application Architecture

```text
              User / Web Browser
                      |
                      v
              Thymeleaf Templates
                      |
                      v
                Spring MVC
                 Controllers
                      |
                      v
                 Service Layer
                Business Logic
                      |
                      v
               Repository Layer
               Spring Data JPA
                      |
                      v
                Hibernate ORM
                      |
                      v
                MySQL Database

        Spring Security protects
        authentication and access
        to secured application routes.
```

### Architecture Explanation

1. **Presentation Layer:** Thymeleaf, HTML, CSS, and Bootstrap render the user interface.
2. **Controller Layer:** Spring MVC controllers handle incoming web requests.
3. **Service Layer:** Contains application business logic.
4. **Repository Layer:** Spring Data JPA handles database access.
5. **Persistence Layer:** Hibernate maps Java entities to database tables.
6. **Security Layer:** Spring Security handles authentication and authorization.

---

## 🛠️ Tech Stack

| Category | Technologies |
|---|---|
| Programming Language | Java 17 |
| Backend Framework | Spring Boot 4.0.4 |
| Web Framework | Spring MVC |
| Security | Spring Security |
| ORM | Hibernate / JPA |
| Template Engine | Thymeleaf |
| Validation | Spring Boot Validation |
| Database | MySQL |
| Email | Spring Boot Mail |
| Frontend | HTML, CSS, Bootstrap |
| Build Tool | Maven |
| Containerization | Docker |
| Deployment | Render |
| Version Control | Git, GitHub |
| IDE | IntelliJ IDEA |
| API Testing | Postman |

---

## 🔐 Security Implementation

Spring Security is used to protect application resources and manage user authentication.

The security implementation includes the following areas:

- Authentication and login
- Access control for protected routes
- Authorization of application resources
- Password security
- Integration with Thymeleaf

The exact authorization rules and password-encoding implementation depend on the application's security configuration.

---

## 📸 Screenshots

Add actual application screenshots to the `screenshots` directory in the repository.

### 🏠 Home Page

![Smart Contact Manager Home Page](screenshots/home-page.png)

### 🔐 Login Page

![Login Page](screenshots/login-page.png)

### 📝 Registration Page

![Registration Page](screenshots/register-page.png)

### 📇 Contact Dashboard

![Contact Dashboard](screenshots/contact-dashboard.png)

### ➕ Add Contact

![Add Contact](screenshots/add-contact.png)

### 🔎 Search Contacts

![Search Contacts](screenshots/search-contact.png)

> Replace these image paths with the actual screenshot filenames if they differ. The images must be uploaded to GitHub for them to display.

---

## 📁 Project Structure

```text
SmartContactManager/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/demo/
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       └── application.properties
│   └── test/
├── .mvn/
│   └── wrapper/
├── Dockerfile
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── README.md
```

> This is a simplified structure. Update the package and directory names to match the actual repository.

---

## 🚀 Getting Started

### Prerequisites

Install the following tools before running the project:

- Java 17 or a compatible version
- Maven, if you are not using the Maven Wrapper
- MySQL
- Git
- Docker, if you want to run the container
- IntelliJ IDEA, Eclipse, or Spring Tool Suite

### 1. Clone the Repository

```bash
git clone https://github.com/shibuy01/SmartContactManager.git
cd SmartContactManager
```

### 2. Create the Database

Open MySQL and execute:

```sql
CREATE DATABASE smartcontactmanager;
```

### 3. Configure Database Credentials

Open:

```text
src/main/resources/application.properties
```

Configure the database connection according to your local MySQL setup:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/smartcontactmanager
spring.datasource.username=${DB_USERNAME:root}
spring.datasource.password=${DB_PASSWORD:your_password}

spring.jpa.hibernate.ddl-auto=update
```

Make sure the MySQL server is running and the database credentials are correct.

> **Security:** Never commit real database passwords, email credentials, or other secrets to GitHub. Configure them using environment variables or a secure secret-management mechanism.

### 4. Run the Application

Using Maven:

```bash
mvn spring-boot:run
```

Or use the Maven Wrapper on Windows PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

On Linux or macOS:

```bash
./mvnw spring-boot:run
```

Once the application starts successfully, open:

http://localhost:8080

> The application may require additional email or database configuration depending on the settings in your project.

---

## 🐳 Docker

The repository includes a Dockerfile for building and running the Spring Boot application.

### Build the Docker Image

```bash
docker build -t smart-contact-manager .
```

### Run the Container

```bash
docker run --rm -p 8080:8080 smart-contact-manager
```

Open the application:

http://localhost:8080

> If the application requires MySQL or SMTP configuration, pass the necessary environment variables and ensure the container can reach those services. The Docker command above assumes the application can start with its existing configuration.

---

## 🔄 Application Flow

```text
User
 |
 v
Registration / Login
 |
 v
Spring Security
 |
 v
Authenticated User
 |
 v
Contact Dashboard
 |
 +---- Add Contact
 |
 +---- View Contact
 |
 +---- Update Contact
 |
 +---- Delete Contact
 |
 +---- Search Contacts
 |
 v
Spring MVC Controller
 |
 v
Service Layer
 |
 v
Spring Data JPA / Hibernate
 |
 v
MySQL Database
```

---

## 🧪 Testing

The following areas should be tested before releasing changes:

- User registration
- User login
- Authentication and authorization
- Adding contacts
- Viewing contacts
- Updating contacts
- Deleting contacts
- Searching contacts
- Form validation
- User-specific data access

Use the browser and Postman where applicable. Automated test coverage depends on the tests implemented in the repository.

---

## ☁️ Deployment

The application is deployed on Render.

- **Platform:** Render
- **Live URL:** [Smart Contact Manager](https://smartcontactmanager-ok52.onrender.com)
- **Containerization:** Docker

### Deployment Architecture

```text
             Internet
                |
                v
          Render Platform
                |
                v
        Docker Container
                |
                v
        Spring Boot App
                |
                v
          MySQL Database
```

> Ensure the deployed application has a reachable database and the required environment variables configured. The diagram represents the intended deployment flow; the actual database hosting should match your Render configuration.

---

## 🔒 Production Security Recommendations

For a production deployment:

- Store database and email credentials in environment variables.
- Never expose passwords or API keys in source code.
- Use HTTPS.
- Configure secure session cookies where applicable.
- Use a suitable password encoder.
- Restrict access to protected resources.
- Configure CSRF protection appropriately for the authentication model.
- Keep Spring Boot and dependencies updated.
- Use separate development and production configurations.
- Configure database backups and monitoring.

---

## 💡 Key Learning Outcomes

This project provides practical experience with:

- Java backend development
- Spring Boot and Spring MVC
- Spring Security
- Authentication and authorization
- Hibernate and Spring Data JPA
- MySQL database integration
- MVC architecture
- Thymeleaf server-side rendering
- Form validation and CRUD operations
- Email integration
- Maven build management
- Docker containerization
- Git and GitHub
- Cloud deployment

---

## 🔮 Future Improvements

Potential enhancements include:

### Authentication and Security
- JWT-based authentication
- OAuth2 / Google Login
- Email verification
- Password reset workflow
- Advanced role-based access control

### Contact Management
- Contact groups and tags
- Profile images
- Import and export functionality
- Bulk contact operations
- Pagination and sorting

### User Experience
- Advanced search and filtering
- Dashboard statistics
- Recent contacts
- Improved mobile responsiveness

### DevOps
- GitHub Actions CI/CD
- Docker Compose
- AWS EC2 deployment
- Production monitoring and logging

---

## 🎯 Why This Project?

Smart Contact Manager demonstrates the development of a Java web application using the Spring ecosystem.

It brings together server-side web development, database persistence, authentication, contact CRUD operations, and containerization in a single project.

**Suitable portfolio project for:**
- Java Developer
- Java Backend Developer
- Spring Boot Developer
- Junior Software Engineer

---

## 👨‍💻 Author

### Shibu Kumar

**Java Backend Developer | Spring Boot | REST APIs | Microservices**

- **GitHub:** [github.com/shibuy01](https://github.com/shibuy01)
- **Project Repository:** [SmartContactManager](https://github.com/shibuy01/SmartContactManager)
- **Live Demo:** [Smart Contact Manager](https://smartcontactmanager-ok52.onrender.com)

---

## ⭐ Support

If you find this project useful, please consider giving the repository a ⭐ on GitHub.
