# Java Test Automation Framework

This is a Java-based test automation framework designed for UI testing with TestNG.
It supports:

Cross-browser execution

Cloud execution on LambdaTest

Headless execution for faster runs

Data-driven testing using OpenCSV, Apache POI, and Gson

Fake test data generation using Faker

Detailed HTML reporting via Extent Reports

Logging with Log4j

The framework is Maven-based and can be executed directly from the command line or integrated into CI/CD pipelines.


## 🚀 About Me
Hi, My name is Shahaji Pawar and I have 12 years of experience into Manual and Automation Testing using techonologies like Selenium Webdriver, RestAssured.

My major expertise is in Java Programming Language.
## Authors

- [@shahajipawar](https://github.com/shahajipawar)

- EmailAddress: Shahaji.pawar07@gmail.com
## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/shahajipawar)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/shahaji-pawar/)



## Prerequisites

- Install Java 11+
- Install Maven 3.6+
- Configure Maven in your system path
- Ensure environment variables are set for Java/Maven

## Features

- **Data Driver testing**: Using OpenCSV, Aache POI, Gson for reading test data from CSV, Excel files and JSON.
- **Cross-Browser testing**: Supports running tests on different browsers.
- **Headless mode**: Faster execution by running tests in headless mode.
- **Could Testing**: Integrated with LambdaTest to run tests on the cloud
- **Logging***: Uses Log4j for detailed logs.
- **Reporting**: Generates detailed reports using Extent Reports.


## Tech Stack
- Java 11
- TestNG → Testing framework
- OpenCSV → CSV-based test data
- Apache POI → Excel-based test data
- Gson → JSON parsing
- Faker → Generate fake test data
- Selenium WebDriver → Browser automation
- LambdaTest → Cloud execution
- Extent Reports → Test reporting
- Log4j → Logging
- Maven Surefire Plugin → CLI test execution
## Set-up Intructions

***Run Tests from CLI:**
- Tests are executed using the Maven Surefire Plugin.
- You can pass parameters at runtime:
- -Dbrowser → Browser to run tests (chrome, firefox, edge)
- -DisLambdaTest → Run on LambdaTest cloud (true / false)
- -DisHeadless → Run in headless mode (true / false)

**Run tests on local Chrome in headless mode:**
```bash
  mvn clean test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true
``` 
**Run tests on LambdaTest (Chrome):**
```bash
  mvn clean test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false
``` 

## Reporting

- After test execution, a detailed HTML report is generated at: ./reports.html
- Reports include: Test execution summary, Passed/Failed test cases, Screenshots on failure.

## Logging
- Logs are generated using Log4j and All logs are stored under ./logs directory.
- Logs include: Test execution steps, Browser actions, Failures & exceptions.

## Integrated the project with Github Actions
This automation framework is integrated with github actions.
The test will be executed at 11:30pm IST every single day

The reports will be archieved in gh-pages branch.
You can view the html reports at: shahajipawar.github.io/Test-Automation-Framework-Assignment/report.html
