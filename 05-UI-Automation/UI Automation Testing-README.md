# Part 05 – UI Automation Testing (Selenium & TestNG)

## Overview
This folder contains the **UI automation testing implementation** for the SauceDemo web application, developed using **Selenium WebDriver** and **TestNG** as part of the Software Testing – Quality Assurance capstone assignment.

The objective of this phase is to automate key **end-to-end user workflows** and validate core application functionality through browser-based testing.

---

## System Under Test
- **Application:** SauceDemo (https://www.saucedemo.com)
- **Type:** Web-based e-commerce demo application
- **Browser:** Microsoft Edge
- **Test User:** standard_user

---

## Contents of This Folder

### 1. StandardUserTests.java
This Java class contains automated UI test cases written using Selenium WebDriver and TestNG.

The test suite automates the following user journey:

- User login with valid credentials
- Product page validation
- Product count verification
- Add all products to cart
- Remove product from cart
- Navigate to cart page
- Sort products by price (Low to High)
- Sort products by price (High to Low)
- Complete checkout with valid information
- Logout from the application

Each test includes assertions to validate expected behavior and ensure application correctness.

---

## Testing Approach
- UI automation using Selenium WebDriver
- Test execution management using TestNG
- Happy path testing for main user flows
- Sequential test execution using TestNG priorities
- Assertions used to validate UI behavior and navigation

---

## Tools & Technologies
- Programming Language: Java
- Automation Tool: Selenium WebDriver
- Test Framework: TestNG
- Browser Driver: Microsoft Edge (EdgeDriver)
- IDE: Eclipse / IntelliJ IDEA

---

## Test Design
- Tests are designed to follow real user behavior
- Implicit waits are used for element synchronization
- `Thread.sleep()` is added to allow visual observation of test execution (demo purposes)
- Tests are structured for clarity and readability

---

## How to Execute the Tests
1. Ensure Java is installed and configured
2. Install Selenium WebDriver dependencies
3. Install TestNG
4. Ensure Microsoft Edge and EdgeDriver are installed
5. Run the `StandardUserTests` class as a TestNG test

---

## Relation to Assignment Brief
This folder fulfills **Part E – UI Automation Testing** requirements:
- Automated UI test coverage
- Selenium-based browser testing
- End-to-end user workflow validation
- Clear assertions and structured test execution

---

## Notes
- Tests are designed for demonstration and academic purposes
- Hard-coded test data is used for simplicity
- Thread.sleep() is intentionally added for visibility during execution
- The SauceDemo application is a demo site and does not represent a production system
