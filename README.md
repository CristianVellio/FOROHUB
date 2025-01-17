# ForoHub 📢

## Intro
ForoHub is a RESTful web application built using Spring Boot, designed to facilitate the creation of topics and publication of responses within a user-centric forum. The application includes robust security features, user management, and a modular design to ensure scalability and maintainability.

---

## Features

### User Management
- **Create User**: Allows registration of new users with hashed passwords.
- **Update User**: Enables users to update personal information, roles, or passwords.
- **Delete User**: Soft-deletes users, marking them as disabled.
- **List Users**: Lists all users (active and inactive) or only active ones.

### Security
- **Authentication**: Utilizes JWT for secure authentication.
- **Authorization**: Roles and permissions are managed to restrict access to specific endpoints.
- **Password Encryption**: Uses BCrypt for password hashing.

### Forum Functionality
- **Create Topics**: Users can create discussion topics.
- **Post Replies**: Users can post responses to topics.
- **Moderation**: Admin users can edit or remove topics and replies.

### API Documentation
- **Swagger UI**: Provides an interactive API documentation interface for testing and exploring the endpoints.

---

## API Endpoints

### User Endpoints

#### Create User
- **POST** `/usuarios`
- **Description**: Registers a new user in the system.
- **Request Body**:
  ```json
  {
      "username": "string",
      "password": "string",
      "email": "string",
      "nombre": "string",
      "apellido": "string",
      "role": "USER"
  }
  ```
- **Response**: HTTP 201 Created

#### List All Users
- **GET** `/usuarios/all`
- **Description**: Retrieves all users regardless of status.
- **Response**: HTTP 200 OK

#### List Active Users
- **GET** `/usuarios`
- **Description**: Retrieves only active users.
- **Response**: HTTP 200 OK

#### Get User by id
- **GET** `/usuarios/username/{id}`
- **Description**: Retrieves user details by username.
- **Response**: HTTP 200 OK

#### Update User
- **PUT** `/usuarios/{id}`
- **Description**: Updates user details, including optional password change.
- **Request Body**:
  ```json
  {
      "password": "string",
      "email": "string",
      "nombre": "string",
      "apellido": "string"
  }
  ```
- **Response**: HTTP 200 OK

#### Disable User
- **DELETE** `/usuarios/{id}`
- **Description**: Disables a user account.
- **Response**: HTTP 204 No Content

---

## Security Implementation

### Token-Based Authentication
- JWT tokens are used for secure user authentication.
- Tokens are expected in the `Authorization` header in the format `Bearer {token}`.

### Password Encryption
- Passwords are hashed using `BCryptPasswordEncoder` before storage.
- Ensures security and prevents plaintext password storage.

### Role Management
- Roles such as `USER` and `ADMIN` are defined to manage access.
- Admin users have elevated permissions for moderation tasks.

---

## Technologies Used
- **Spring Boot**: Backend framework.
- **Spring Security**: For authentication and authorization.
- **Hibernate**: ORM for database interactions.
- **MySQL**: Relational database.
- **Swagger**: API documentation and testing.
- **Maven**: Build and dependency management tool.

---
