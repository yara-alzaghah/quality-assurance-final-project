QA Final Project – Software Testing & Quality Assurance


Project Scope

This project demonstrates a complete Software Testing and Quality Assurance workflow applied to web and API-based systems. The scope includes test planning, manual testing, API functional testing, API performance testing, and UI automation testing. The goal of the project is to apply industry-standard QA practices and tools while following ethical testing guidelines.


Project Setup

To work with this project, ensure the following tools are installed on your local machine:
- Java (for UI automation)
- Selenium WebDriver
- TestNG
- Microsoft Edge browser and EdgeDriver
- Postman
- Node.js (for Newman)
- k6 (for performance testing)


All test execution was performed locally and not through CI automation for external systems.


Test Execution (Postman, Newman, k6, and UI Automation)


API Testing using Postman and Newman
API functional testing was implemented using Postman collections and environments.


To run the API tests:
1. Open Postman
2. Import the Postman collection and environment from the 03-API-Testing folder
3. Select the environment
4. Execute the requests manually or using the Collection Runner


To run the same tests via Newman (CLI), use the following command:
newman run collection.json -e environment.json -d data.csv -r html


The exact Newman command used in this project is documented in:
03-API-Testing/Newman Command.txt


API execution evidence can be found in:
03-API-Testing/Newman_Report.html


API Performance Testing using k6
Performance testing was conducted using k6 and includes both smoke and load tests.


To execute the performance tests locally:
k6 run smokeTest.js
k6 run loadTest.js


Load testing was executed locally only and is intentionally not automated in GitHub Actions to avoid impacting public APIs. Performance results, summaries, and analysis are available in the 04-API-Performance-k6 folder.


UI Automation Testing using Selenium
UI automation testing was implemented using Selenium WebDriver and TestNG for the SauceDemo web application.


To run the UI automation tests:
1. Open the UI automation project in an IDE such as Eclipse or IntelliJ
2. Navigate to StandardUserTests.java
3. Run the test class as a TestNG test


The automated tests validate login, product listing, cart operations, sorting, checkout, and logout functionality.


Test Evidence and Reports
All testing evidence and reports are included in the repository as follows:
- Test plan and scenarios: 01-Planning
- Manual test cases and defect reports: 02-Manual-Testing
- API automation evidence (Postman and Newman): 03-API-Testing
- Performance testing scripts, summaries, and report: 04-API-Performance-k6
- UI automation source code: 05-UI-Automation


Notes

-Public APIs are used strictly for learning and demonstration purposes.

-Load tests are not executed in CI pipelines for ethical reasons.

-All execution results and reports were generated locally.
