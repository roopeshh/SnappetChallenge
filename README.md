# SnappetChallenge

This repository contains tests for Teacher Dashboard from URL: https://teacher.snappet.org

Automation framework is a gradle project which uses Selenium Webdriver, Cucumber, TestNG and Java. The IDE used for developing is IntelliJ IDEA.

To execute tests:
- Clone the project
- Import the project in IntelliJ IDEA as a gradle project.
- To run tests on headless browser use command - ```gradle clean test --stacktrace -DbrowserType=headless```
- To run tests on chrome browser use command - ```gradle clean test --stacktrace -DbrowserType=chrome```
- At the end, screenshots are taken for failed scenario and stored in /screenshots folder for future reference and test report is generated in /build/reports/tests/test/index.html file.

**NOTE:** Automation framework is developed on Mac.
