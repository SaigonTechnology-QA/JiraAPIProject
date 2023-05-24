# This a very simple automation framework to test Jira API using TestNG, Maven and Allure report

## The document for Jira API is available at [Link](https://developer.atlassian.com/cloud/jira/platform/rest/v3/api-group-issues/#api-rest-api-3-issue-post)

## Setup and run locally
1. Download and install IntelliJ IDEA Community Edition: [Link download](https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC)
2. Download and install Java JDK 8:
- Create `JAVA_HOME` environment variables
- Add `JAVA_HOME` to Path: `%JAVA_HOME%\bin`

![Alt text](./assets/JavaHome.png?raw=true "JAVA_HOME")

- Check if `JAVA_HOME` is configured properly or not by typing the command `echo %JAVA_HOME%` and `java -version` on terminal/cmd

3. Download and unzip latest Maven source file: [Link download](https://dlcdn.apache.org/maven/maven-3)
- Create `MAVEN_HOME` environment variables
- Add `MAVEN_HOME` to Path: `%MAVEN_HOME%\bin`

![Alt text](./assets/MavenHome.png?raw=true "MAVEN_HOME")

- Check if `MAVEN_HOME` is configured properly or not by typing the command `echo %MAVEN_HOME%` and `mvn -v` on terminal/cmd

4. Open this base project
5. Project structure settings:
- From the main menu of IntelliJ select: `File => Project Structure => Project Settings => Project`
- Select the wanted SDK

![Alt text](./assets/ProjectSetings.png?raw=true "JAVA_HOME")

6. Select Maven plugin for IntelliJ:
- From IntelliJ select: `Ctrl+Alt+S -> Build, Execution, Deployment -> Build tool -> Maven -> Maven home directory`
- Select the Maven plugin at `C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.1\plugins\maven\lib\maven3\bin`
- Add the path of Maven plugin above to the Path environment variables

![Alt text](./assets/MavenPlugins.png?raw=true "MavenPlugins")

7. Download and unzip latest Allure report source file: [Link download](https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/)
- Create `ALLURE_HOME` environment variables
- Add `ALLURE_HOME` to Path: `%ALLURE_HOME%\bin`

![Alt text](./assets/AllureHome.png?raw=true "ALLURE_HOME")

- Check if `ALLURE_HOME` is configured properly or not by typing the command `echo %ALLURE_HOME%` and `allure --version` on terminal/cmd

8. Install dependencies: `mvn clean install`
9. Prepare test data on Jira:
- Create a project on Jira then get the `product key`, `base uri` at: [Link here](https://nxthich.atlassian.net/jira/projects)
- Update the variables `baseUri`, `projectKey` in file `src/test/java/test/BaseTest.java`

![Alt text](./assets/ProjectKey_BaseUri.png?raw=true "ProjectKey_BaseUri")
![Alt text](./assets/Project_Uri_Key.png?raw=true "Project_Uri_Key")

- Create `API token` at: [Link here](https://id.atlassian.com/manage-profile/security/api-tokens)
- Update the variables `email`, `apiToken` in file `src/test/java/model/RequestCapability.java`

![Alt text](./assets/email.png?raw=true "email")
![Alt text](./assets/apiToken.png?raw=true "apiToken")
![Alt text](./assets/Email_APIToken.png?raw=true "Email_APIToken")

10. Run the tests by commandline: `mvn clean test -DxmlSuite="src/test/resources/test-suites/Regression.xml"`

![Alt text](./assets/ExecuteTest.png?raw=true "ExecuteTest")

11. Generate Allure report by commandline:
- `allure generate allure-results`
- `allure open`

![Alt text](./assets/Report.png?raw=true "Report")

## Project structure
1. Structure

![Alt text](./assets/FWStructure.png?raw=true "FWStructure")

2. Steps to develop new test cases for new API
- Define new Json body for API as an object

![Alt text](./assets/BodyJsonObject.png?raw=true "BodyJsonObject")
  
- Define test steps

![Alt text](./assets/DefineTestSteps.png?raw=true "DefineTestSteps")

- Define testcases

![Alt text](./assets/DefineTestCase.png?raw=true "DefineTestCase")

- Define testsuite

![Alt text](./assets/TestSuites.png?raw=true "TestSuites")

## Run on GitHub Actions
1. Create Docker image for CI/CD (GitHub Actions, CircleCI)
- Build image: `docker build -t <user_name>/testng-allure .`
- Push image to Docker Hub: `docker push <user_name>/testng-allure`
2. Run tests on GitHub Actions:
- Check/update the file `.github/workflows/actions.yml`
- Commit and push code, the test will be triggered

![Alt text](./assets/RunWhenPushCode.png?raw=true "RunWhenPushCode")

- Download Allure report

![Alt text](./assets/AllureReport.png?raw=true "AllureReport")
