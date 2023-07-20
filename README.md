**Project Name**

# Signature Verification Project Backend

## Description

This repository contains a Java Spring Boot project that serves as a backend bart signature verification project.

## Prerequisites

Before setting up the project, ensure you have the following installed on your local machine:

- Java Development Kit (JDK) 17 or higher
- Apache Maven

## Setup Instructions

1. Clone the repository to your local machine using Git:

   ```bash
   git clone https://github.com/your-username/java-spring-boot-project.git
   ```

2. Navigate to the project directory:

   ```bash
   cd java-spring-boot-project
   ```

3. Build the project using Maven:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```

5. The application will start running on `http://localhost:8080`.

8. Access the application Rest API call using Postman:

   Open postman and hit post call with username and password at `http://localhost:8080/verify-signature/auth/login`.

## Additional Notes

- If you encounter any issues during the setup process, check the project's documentation or contact the maintainers for support.
- This project is designed as a starting point and can be extended to fit specific requirements.

## Contributing

If you wish to contribute to this project, please follow the guidelines in the CONTRIBUTING.md file.

## License

This project is licensed under the [MIT License](LICENSE).
