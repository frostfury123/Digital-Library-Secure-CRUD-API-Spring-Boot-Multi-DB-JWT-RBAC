# Secure CRUD API for Digital Library
A **Spring Boot RESTful API** for managing a collection of books in a digital library system with **role-based authentication, JWT, OAuth2, auditing, and HTTPS enforcement.**

This project is designed to showcase **enterprise-grade application design** with a focus on **security, scalability, and maintainability.**

---

## Features

### Authentication & Authorization

- **JWT-based Authentication (Stateless)** – Issue JWT tokens containing user roles & permissions.

- **OAuth2 Login (Google & GitHub)** – Session-based login for social authentication.

- **Role-Based Access Control (RBAC)** – Four roles with specific permissions:

    - **Reader** → View books only.

    - **Editor** → View, Create, Update books.

    - **Librarian** → View, Create, Update, Delete books.

    - **Administrator** → All book operations + Manage Users.

- **Password Encryption** – User passwords secured using **BCryptPasswordEncoder.**

### Book Management API (CRUD)

- **GET /books** – View all books (Reader, Editor, Librarian, Admin).

- **GET /book/{id}** - View a particular book (Reader, Editor, Librarian, Admin).

- **POST /book** – Add new book (Editor, Librarian, Admin).

- **PUT /book** – Update book details (Editor, Librarian, Admin).

- **DELETE /book/{id}** – Delete book (Librarian, Admin).

- **Book attributes**: id, title, author, publishedYear, genre.

### User Management

- **POST /api/users** – Admin can create new users with roles (Reader, Editor, Librarian, Administrator).

- **POST /register** – Readers can self-register.

- **Role enforcement** on all APIs.

### Audit Logging

- Every action is tracked:

        CREATE_BOOK, UPDATE_BOOK, DELETE_BOOK, CREATE_USER.

- **Audit Log Schema**: id, action, book_id, timestamp, user_id.

- Stored in **Postgres** for durability.

### Security

- **HTTPS Enforcement** – Redirect HTTP → HTTPS automatically.

- **TLS/SSL Certificates** for secure communication.

- **Audit Logging** for all user actions.

- **OAuth2 + JWT Hybrid Security.**

### Database Setup

- **H2 (In-memory)** → Book Data.

- **Postgres** → Users & Audit Logs.

- **data.sql** → Preloads sample books for testing.

## Tech Stack

- **Java** 

- **Spring Boot / Spring Framework**

- **Spring Web (REST API)**

- **Spring Security (JWT + OAuth2 + RBAC)**

- **Spring Data JPA** (H2 + PostgreSQL)

- **Maven** (Dependency Management)

- **Postman** (API Testing)

- **Git** (Version Control)

## Project Setup

#### Clone the Repository

```
git clone https://github.com/your-username/springboot-multidb-crud-rbac-api.git
cd springboot-multidb-crud-rbac-api
```
#### Configure Databases

- **Postgres**: Create a database library_db.

- Update application.properties:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/library_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```
- **H2**: Auto-configured for Book data (no setup needed).

#### Generate Keystore for HTTPS
```
keytool -genkeypair -alias libraryapi -keyalg RSA -keysize 2048 \
  -storetype PKCS12 -keystore keystore.p12 -validity 3650
```

- Place keystore.p12 in src/main/resources.

- Update application.properties:
```
server.ssl.enabled=true
server.ssl.key-store=classpath:keystore.p12
server.ssl.key-store-password=your_password
server.ssl.key-store-type=PKCS12
server.port=8443
```

#### Generate Certificates for Postman Testing

- Extract public certificate:
```
openssl pkcs12 -in keystore.p12 -clcerts -nokeys -out mycert.pem
```
- import **mycert.pem** in Postman:

    - Go to **Settings → Certificates → CA Certificates**

    - Upload mycert.pem.

#### Enable Postman Settings

- Go to **Postman Settings → General.**

- Enable **Follow Original HTTP Method.**

#### Run the Project
```
mvn spring-boot:run
```
Server runs at: https://localhost:8443




## API Testing (Postman)
### Authentication

- **Login Endpoint** -> POST /auth/login

Request
```
{
  "username": "admin",
  "password": "admin123"
}
```

Response
```
{
  "access_token": "jwt_token",
  "expires_in": 3600
}
```

Use **Authorization: Bearer <token>** in all secured requests.

**Note**: Any role (Reader, Librarian, Editor, Admin) can login via /auth/login and receive a valid JWT token. The **role determines access** to other endpoints.


## Default Data

- Preloaded via data.sql.

- Example Book:
```
INSERT INTO books (title, author, published_year, genre) VALUES
('The Pragmatic Programmer', 'Andrew Hunt', 1999, 'Programming');
```

## Audit Logs

- Stored in Postgres.

- Example record:
```
{
  "id": 1,
  "action": "CREATE_BOOK",
  "book_id": 10,
  "timestamp": "2025-08-20T10:15:30",
  "user_id": 3
}
```

## Highlights

- Multi-Database Integration (**H2 + PostgreSQL**)
- Secure API with **HTTPS + TLS**
- **JWT + OAuth2 Hybrid Authentication**
- Role-Based Access Control (RBAC)
- **BCrypt Password Hashing**
- Default data loading with data.sql
- Comprehensive **Audit Logging**
- **Postman Ready** with HTTPS certificate setup

## Why this project?

This project demonstrates proficiency in:

- **Spring Framework (Core, Boot, Web, Security, Data JPA)**

- **Enterprise Security (JWT, OAuth2, RBAC, HTTPS, BCrypt)**

- **Database Management (H2 for dev/test, PostgreSQL for persistence)**

- **REST API Design & Documentation**

- **Testing & API Tooling (Postman)**

- **Best Practices (Audit Logs, HTTPS, Data Preloading)**

This project reflects real-world challenges in **enterprise application development** and proves capability to handle them effectively.

### Author

**Prem Swaroop** – Java Developer passionate about **secure, scalable, and maintainable enterprise solutions.**

### License

MIT License – feel free to use, learn, and extend.
