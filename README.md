## Library Management System

### Description
This Java application allows librarians to manage a library system efficiently. It includes functionalities such as adding new books, updating book details, checking out books to users, and managing user accounts. The application also provides error handling, validation checks, and simple file-based data persistence using an SQLite database.

### Features and Functionalities
- **User Authentication:** Users can log in as either a regular user or an archivist.
- **User Actions:**
  - Regular users can view the book collection and borrow books.
  - Archivists can manage the book collection by adding new books, adding new users, returning books, and searching for books.
- **Database Connectivity:** The application uses SQLite as its database for storing book and user information.
- **Error Handling:** Error handling is implemented to handle invalid user inputs and edge cases gracefully.
- **Validation:** Validation checks ensure that book and user information is entered correctly.
- **Menu-Driven Interface:** Users can interact with the system through a simple menu-driven interface.

### Usage Instructions
1.	**Clone the Repository:**

2. **Setup SQLite Database:**
- Ensure you have SQLite installed on your system.
- The database file `forJava.db` will be created automatically when the application runs.

2.	**Compile and Run the Application:**

4. **Follow On-Screen Instructions:** Use the menu-driven interface to perform various tasks such as adding books, adding users, checking out books, returning books, and searching for books.

### Directory Structure
- `Main.java`: Main class containing the entry point for the program and menu-driven interface.
- `Book.java`: Class representing a book with attributes such as book ID, title, author, genre, and availability.
- `User.java`: Class representing a user with attributes such as user ID, name, contact information, and borrowed books.
- `Library.java`: Class representing the library system containing methods for managing users and books.
- `Database.java`: Class handling database operations using SQLite.

### Dependencies
- Java Development Kit (JDK)
- SQLite

### Contributors
- [Your Name](https://github.com/your-username)
