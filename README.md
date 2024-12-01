Login Page Project
Overview
This project is a Java Spring Boot application designed to check user credentials and provide secure access via JWT authentication. It also includes a Docker configuration to containerize and run the application seamlessly.

Features
Java Spring Boot API for user authentication.
JWT Token Integration for secure communication.
Docker Support for containerized deployment.
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
Ensure Docker is installed and running. Then use the following commands to set up and run the project in a Docker container:

Build and run using Docker Compose:

bash
Copy code
docker-compose up --build
This will:

Automatically pull the necessary Docker image.
Set up and run the project on port 8080.
Accessing the Application
Once the Docker container is running, you can access the API via:
arduino
Copy code
http://localhost:8080
Dependencies
Java Spring Boot
Maven
Docker
Usage
The application validates user credentials and generates a JWT token upon successful login.
API endpoints are protected and require a valid JWT for access.
Contributing
Feel free to submit issues or pull requests to enhance the functionality of the project.

License
This project is licensed under the Apache License 2.0. See the LICENSE file for details.






