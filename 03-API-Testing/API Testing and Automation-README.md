# Part 03 – API Testing & Automation (Postman & Newman)

## Overview
This folder contains the **API testing deliverables** for the DummyJSON API, completed as part of the Software Testing – Quality Assurance capstone assignment.

The objective of this phase is to validate backend functionality using **API testing**, apply automated assertions using Postman, and execute collections via **Newman** for reporting and repeatable test execution.

---

## System Under Test
- **API:** DummyJSON (https://dummyjson.com)
- **Type:** Public REST API
- **Focus Areas:**
  - Authentication
  - Token management
  - User retrieval
  - Cart operations
  - Data-driven API testing

---

## Contents of This Folder

### 1. DummyJSON API Testing-Final Project.postman_collection.json
This Postman collection contains all API test requests and automated assertions.

The collection includes:
- Authentication endpoints (login, token refresh)
- User-related endpoints
- Cart operations
- Positive and negative test scenarios
- Automated validations using Postman test scripts (status code, response time, headers, body validation)

---

### 2. DummyJSON-QA.postman_environment.json
This file defines the **Postman environment variables**, including:
- Base URL
- Authentication tokens
- User IDs
- Product and cart IDs
- Invalid data used for negative testing

These variables allow test reuse and maintainability.

---

### 3. Add New Cart Data Driven.csv
This CSV file is used for **data-driven API testing**.

It enables:
- Multiple test iterations
- Dynamic request execution
- Validation of cart creation with different input data

---

### 4. Newman Command.txt
This file contains the **Newman CLI command** used to execute the Postman collection.

The command:
- Runs the collection using the specified environment
- Uses CSV data for data-driven execution
- Generates HTML reports for test results

---

### 5. Newman Reports (PDF & HTML)
The following files provide **execution evidence** for the API automation:

- Newman Report First Iteration.pdf  
- Newman Report Second Iteration.pdf  
- Newman Report Third Iteration.pdf  
- Newman Report Fourth Iteration.pdf  
- Newman_Report.html  

These reports demonstrate:
- Multiple execution iterations
- 100% test pass rate
- Detailed request/response information
- Assertion results and performance metrics

---

## Tools Used
- API Testing: Postman
- Automation Runner: Newman (CLI)
- Data-Driven Testing: CSV
- Reporting: HTML & PDF
- Runtime: Node.js

---

## Relation to Assignment Brief
This folder satisfies **Part C – API Testing** requirements:
- API test design and execution
- Automated assertions
- Environment configuration
- Data-driven testing
- Execution reports as evidence

---

## Notes
- API tests are independent of UI tests.
- Authentication tokens are dynamically generated and reused.
- Newman reports are included to demonstrate automation execution and results.
