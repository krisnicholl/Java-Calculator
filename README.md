# Java Spring Calculator API

A simple RESTful API for performing basic arithmetic operations such as addition, subtraction, multiplication, and division. The API supports chaining operations and provides an endpoint for clearing results.

## Features
- Addition, Subtraction, Multiplication, Division operations
- Chaining of operations (using previous results in future operations)
- Clear operation to reset the previous result

## Getting Started

### Prerequisites
- [Java 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/) (for building and running the project)
- Any REST client (Postman, cURL, etc.) for testing API requests

### Installation

1. **Clone the repository**:
   ```bash
   git clone git@github.com:krisnicholl/Java-Calculator.git
   
2. **Navigate into the project directory**:
   ```bash
   cd Java-Calculator

3. **Build the project using Maven**:
   ```bash
   mvn clean install

4. **Run the project**:
   ```bash
   mvn spring-boot:run

Alternatively you can run the application using an IDE such as IntelliJ which can also perform the maven commands.


---

## Endpoints

### 1. **Addition**
   - **URL**: `/add`
   - **Method**: `GET`
   - **Description**: Adds two numbers (`a` and `b`). If `a` is not provided, the result of the previous operation will be used.
   - **Example**:
     ```bash
     GET /add?a=2.0&b=3.0
     Response: 5.0
     ```

### 2. **Subtraction**
   - **URL**: `/subtract`
   - **Method**: `GET`
   - **Description**: Subtracts `b` from `a`. If `a` is not provided, the result of the previous operation will be used.
   - **Example**:
     ```bash
     GET /subtract?a=5.0&b=2.0
     Response: 3.0
     ```

### 3. **Multiplication**
   - **URL**: `/multiply`
   - **Method**: `GET`
   - **Description**: Multiplies `a` by `b`. If `a` is not provided, the result of the previous operation will be used.
   - **Example**:
     ```bash
     GET /multiply?a=3.0&b=4.0
     Response: 12.0
     ```

### 4. **Division**
   - **URL**: `/divide`
   - **Method**: `GET`
   - **Description**: Divides `a` by `b`. If `a` is not provided, the result of the previous operation will be used. Will return an error if `b` is 0.
   - **Example**:
     ```bash
     GET /divide?a=10.0&b=2.0
     Response: 5.0
     ```

### 5. **Clear**
   - **URL**: `/clear`
   - **Method**: `POST`
   - **Description**: Clears the last result stored on the server.
   - **Example**:
     ```bash
     POST /clear
     Response: "Last results cleared"
     ```

