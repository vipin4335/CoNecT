Login Page Project
Overview
This project is a Java Spring Boot application that implements Spring Security to handle user authentication. It leverages JWT (JSON Web Token) for secure user sessions and returns the token in a cookie for enhanced security. The application is containerized using Docker for seamless deployment.

Features
Spring Security Integration for robust authentication.
Generates JWT tokens and stores them in cookies.
Docker Support for easy deployment.
Exposes API endpoints for user credential validation.
Runs on port 8080.
Setup Instructions
1. Clone the Repository
Download the project to your local system:

bash
Copy code
git clone <repository-url>
cd LoginPage
2. Build the Project
Run the Maven command to clean and package the project:

bash
Copy code
mvn clean package
3. Set Up Docker
Ensure Docker is installed and running. Use the following commands to set up and run the project in a Docker container:

Build and run the application using Docker Compose:

bash
Copy code
docker-compose up --build
This will:

Automatically pull the necessary Docker image.
Set up and run the application on port 8080.
Accessing the Application
The application will be accessible at:
arduino
Copy code
http://localhost:8080
Technical Highlights
Spring Security: Protects endpoints and manages authentication workflows.
JWT Tokens in Cookies: Ensures secure and stateless sessions by storing JWT in HTTP-only cookies to prevent client-side tampering.
Docker: Simplifies deployment by bundling the application into a container.
Usage
On user login, the application:
Validates credentials.
Generates a JWT token.
Sends the token back in an HTTP-only cookie for security.
Protected API endpoints require valid JWT cookies for access.
Dependencies
Java Spring Boot
Spring Security
JWT
Maven
Docker
Contributing
Contributions are welcome! Submit issues or pull requests to improve functionality or add new features.

License
This project is licensed under the Apache License 2.0. See the LICENSE file for details.





