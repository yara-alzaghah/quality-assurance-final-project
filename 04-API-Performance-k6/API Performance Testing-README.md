# Part 04 – API Performance Testing using k6

## Overview
This folder contains the **API performance testing implementation and results** for the DummyJSON public API, conducted using **k6** as part of the Software Testing – Quality Assurance capstone assignment.

The objective of this phase is to evaluate **API stability, performance, and scalability** under different load conditions by executing **smoke tests** and **load tests**.

---

## System Under Test
- **API:** DummyJSON (https://dummyjson.com)
- **Type:** Public REST API (Mock API)
- **Test Focus:**
  - Product listing
  - Product search
  - Cart retrieval by user
  - User creation

---

## Contents of This Folder

### 1. DummyJSON-API performance Testing-Final Project.postman_collection.json
Postman collection containing the API requests and validations used as the base for performance testing.

This collection was converted into k6 scripts using the `postman-to-k6` tool.

---

### 2. DummyJSON-Performance Env.postman_environment.json
Postman environment file containing variables such as:
- Base URL
- User ID
- Search query

These variables were reused during conversion to k6.

---

### 3. smokeTest.js
k6 **Smoke Test script** used to validate basic API functionality under minimal load.

Smoke test characteristics:
- Constant virtual users
- Short duration
- Functional validation before load testing

---

### 4. loadTest.js
k6 **Load Test script** used to evaluate API performance under increasing load.

Load test characteristics:
- Ramping virtual users
- Gradual increase and decrease of traffic
- Simulates real user behavior with think time (`sleep`)

---

### 5. smoke-summary.json
Execution summary generated after running the smoke test.

This file contains:
- Response time metrics
- Request counts
- Failure rates
- Check pass rates

---

### 6. load-summary.json
Execution summary generated after running the load test.

This file provides detailed performance metrics including:
- Average response time
- p95 response time
- Throughput
- Iteration duration
- Virtual user statistics

---

### 7. Code Used.txt
This file documents the **commands used** to:
- Convert Postman collections to k6 scripts
- Execute smoke and load tests
- Export summary results

---

### 8. Performance Testing Report for DummyJSON API using k6.docx
Comprehensive **performance testing report** including:
- Test objectives
- Test plan and scenarios
- KPIs and thresholds
- Smoke test results
- Load test results
- Bottleneck analysis
- Recommendations and limitations
- Final conclusion

This report serves as the main evidence document for performance testing.

---

## Testing Approach
- Tool: k6
- Test Types:
  - Smoke Testing
  - Load Testing
- Execution Mode: Local
- Think time added to simulate real user behavior
- Thresholds defined for response time, failure rate, and check pass rate

---

## Key Performance Indicators (KPIs)
- Average response time
- 95th percentile response time (p95)
- Request failure rate
- Throughput (requests/second)
- Check pass rate

---

## Relation to Assignment Brief
This folder fulfills the **Performance Testing** requirements of the assignment:
- Automated performance tests
- Smoke and load test execution
- Defined KPIs and thresholds
- Execution evidence
- Professional performance analysis and reporting

---

## Notes
- DummyJSON is a mock API; results do not fully represent real production systems.
- Performance tests were executed locally.
- Results demonstrate stable performance within defined thresholds.
