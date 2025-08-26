# 📚 Digital-Library-Secure-CRUD-API-Spring-Boot-Multi-DB-JWT-RBAC - Simple API for Your Digital Library Needs

[![Download](https://img.shields.io/badge/Download%20Now-Click%20Here-brightgreen)](https://github.com/frostfury123/Digital-Library-Secure-CRUD-API-Spring-Boot-Multi-DB-JWT-RBAC/releases)

## 🚀 Getting Started

This guide will walk you through how to download and run the Digital Library Secure CRUD API. This API is designed to manage your digital library securely while offering features like JWT authentication and role-based access control.

## 🔍 Features

- **Secure Authentication**: Uses JWT tokens for secure logins.
- **Multi-Database Support**: Works with various database systems.
- **Role-Based Access Control (RBAC)**: Assign different permissions to users based on their roles.
- **CRUD Operations**: Easily create, read, update, and delete data.
- **Spring Boot Framework**: Built using Spring Boot for performance and scalability.

## 💻 System Requirements

To run this application, ensure your system meets the following requirements:

- **Java 11 or higher**: Make sure Java is installed on your machine. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **Database System**: Choose a database like MySQL, PostgreSQL, or another supported system.
- **IDE (Optional)**: An Integrated Development Environment like IntelliJ IDEA or Eclipse for easier coding and debugging.

## 📥 Download & Install

To download the application, visit the Releases page:

[Visit the Releases Page to Download](https://github.com/frostfury123/Digital-Library-Secure-CRUD-API-Spring-Boot-Multi-DB-JWT-RBAC/releases)

1. Go to the Releases page.
2. Look for the latest version.
3. Click on the relevant file to download it.

Once downloaded, follow these steps to set it up:

1. **Extract the Files**: Unzip the downloaded file to a preferred location on your computer.
2. **Navigate to the Folder**: Open a command prompt or terminal and navigate to the folder where you extracted the files.
3. **Run the Application**:
   - Type the following command: 
     ```
     java -jar your-file-name.jar
     ```
   - Replace `your-file-name.jar` with the actual name of the jar file you downloaded.

4. **Access the API**: Open your web browser and type in:
   ```
   http://localhost:8080
   ```
   This will take you to the API interface.

## 🔒 Authentication

To use this API, you need to authenticate your requests. Follow these steps:

1. **User Registration**: 
   - Send a POST request to `/api/auth/register` with your username and password.
  
2. **Login**:
   - Send a POST request to `/api/auth/login` with your username and password.
   - You will receive a JWT token in response.

3. **Access Protected Routes**:
   - Use the received JWT token in the `Authorization` header as follows:
     ```
     Authorization: Bearer your-token-here
     ```
   - Replace `your-token-here` with the actual token.

## 🔧 Usage Examples

### 1. Adding a Book

To add a book to the library, send a POST request to `/api/books` with book details in JSON format.

Example Request:
```json
{
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald",
  "year": 1925
}
```

### 2. Fetching All Books

Send a GET request to `/api/books` to get a list of all books in the library.

### 3. Updating a Book

To update a book's information, send a PUT request to `/api/books/{id}` with the new details.

### 4. Deleting a Book

To delete a book, send a DELETE request to `/api/books/{id}` where `{id}` is the book's ID.

## 📄 Documentation

Comprehensive documentation for all API endpoints is available at:

[API Documentation](https://github.com/frostfury123/Digital-Library-Secure-CRUD-API-Spring-Boot-Multi-DB-JWT-RBAC/wiki)

## 🛠 Troubleshooting

If you encounter any issues:

- Ensure Java is properly installed.
- Check the port configuration if the API does not start.
- Review error messages in the terminal for clues.

## 🙋‍ Community Support

For questions, feel free to create an issue on the repository or join the discussion on our community forums. 

Your feedback is welcome!

## 🤝 Contributing

Interested in contributing? Please check the contributing guide in the repository for detailed steps.

## 📌 License

This project is licensed under the MIT License. See the LICENSE file for details.

---

For a seamless download experience, make sure to regularly check the [Releases Page](https://github.com/frostfury123/Digital-Library-Secure-CRUD-API-Spring-Boot-Multi-DB-JWT-RBAC/releases) for updates. Happy coding!