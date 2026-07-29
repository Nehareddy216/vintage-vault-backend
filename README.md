# 🏛️ Vintage Vault - Backend

<div align="center">

# Buy & Sell Authentic Antique Collectibles

A secure and scalable backend for the **Vintage Vault** antique marketplace built using **Spring Boot**.

[![Java](https://img.shields.io/badge/Java-24-orange?style=for-the-badge&logo=openjdk)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green?style=for-the-badge&logo=springboot)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge&logo=mysql)](https://www.mysql.com/)
[![JWT](https://img.shields.io/badge/JWT-Authentication-red?style=for-the-badge)](https://jwt.io/)
[![Maven](https://img.shields.io/badge/Maven-Build-purple?style=for-the-badge&logo=apachemaven)](https://maven.apache.org/)

</div>

---

# 📖 About the Project

Vintage Vault is a full-stack web application that enables users to buy and sell authentic antique collectibles through a secure online marketplace.

This repository contains the **Spring Boot backend**, which provides REST APIs for user authentication, seller registration, product management, shopping cart, wishlist, orders, reviews, and category management.

---

# 🌐 Frontend Repository

👉 https://github.com/Nehareddy216/vintage-vault-frontend

---

# ✨ Features

- 👤 User Registration
- 🔐 User Login with JWT Authentication
- 🛡️ Spring Security Integration
- 🏪 Seller Registration
- 📦 Product Management
- 🗂️ Category Management
- ❤️ Wishlist Management
- 🛒 Shopping Cart
- 📦 Order Management
- ⭐ Product Reviews
- 🗃️ MySQL Database Integration
- ✅ RESTful APIs

---

# 🏗️ System Architecture

```text
                React Frontend
                       │
                       ▼
                REST APIs (HTTP)
                       │
                       ▼
              Spring Boot Backend
                       │
        ┌──────────────┴──────────────┐
        ▼                             ▼
 Spring Security                 JWT Authentication
        │                             │
        └──────────────┬──────────────┘
                       ▼
                   MySQL Database
```

---

# 🛠️ Tech Stack

## Backend

- Java
- Spring Boot
- Spring Security
- JWT
- Maven

## Database

- MySQL

## Tools

- Spring Tool Suite (STS)
- Eclipse
- Postman
- MySQL Workbench
- Git
- GitHub

---

# 📂 Project Structure

```text
src
├── main
│   ├── java
│   │   ├── controller
│   │   ├── service
│   │   ├── repository
│   │   ├── entity
│   │   ├── dto
│   │   ├── config
│   │   ├── security
│   │   ├── exception
│   │   └── util
│   │
│   └── resources
│       ├── application.properties
│       └── static
│
└── test
```

---

# ⚙️ Installation & Setup

## 1️⃣ Clone the Repository

```bash
git clone https://github.com/Nehareddy216/vintage-vault-backend.git
```

---

## 2️⃣ Open the Project

Import the project as a **Maven Project** in **Spring Tool Suite (STS)** or **Eclipse**.

---

## 3️⃣ Configure MySQL

Create a database named:

```sql
CREATE DATABASE vintage_vault;
```

Update your `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/vintage_vault
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
```

---

## 4️⃣ Run the Application

Run the Spring Boot application.

The backend server starts at:

```
http://localhost:8080
```

---

# 🔗 API Base URL

```
http://localhost:8080/api
```

---

# 📸 Backend Screenshots

## API Testing & Database

| DataBase Tables | Users |
|--------------|--------------|
| <img src="screenshots/Screenshot%202026-07-29%20143058.png" width="450"/> | <img src="screenshots/Screenshot%202026-07-29%20143202.png" width="450"/> |

|Products | Cart |
|--------------|--------------|
| <img src="screenshots/Screenshot%202026-07-29%20143306.png" width="450"/> | <img src="screenshots/Screenshot%202026-07-29%20143357.png" width="450"/> |

| Payment | |
|--------------|--|
| <img src="screenshots/Screenshot%202026-07-29%20143456.png" width="450"/> | |

# 🚀 Future Enhancements

- 👨‍💼 Seller Dashboard
- 👑 Admin Dashboard
- 💳 Online Payment Gateway
- 📧 Email Notifications
- 🔍 Advanced Search & Filters
- 🤖 AI-based Product Recommendation System
- ☁️ AWS Cloud Deployment
- 🐳 Docker Containerization

---

# 👩‍💻 Developer

**Neha Reddy**

B.Tech – Computer Science & Engineering (AI & ML)

GitHub:  
https://github.com/Nehareddy216

---

# ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub.

It motivates me to continue building and improving projects.

---
