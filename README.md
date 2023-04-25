# This a very simple automation framework to test Jira API using TestNG, Maven and Allure report

## Setup and run locally
1. Download and install IntelliJ IDEA Community Edition: https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC
2. Download and install Java JDK 8:
- Create `JAVA_HOME` environment variables
- Add `JAVA_HOME` to Path: `%JAVA_HOME%\bin`
3. Download and unzip latest Maven source file: https://dlcdn.apache.org/maven/maven-3
- Create `MAVEN_HOME` environment variables
- Add `MAVEN_HOME` to Path: `%MAVEN_HOME%\bin`
4. Open existing project or create new one
5. Project structure settings:
- From the main menu of IntelliJ select: `File => Project Structure => Project Settings => Project`
- Select the wanted SDK
6. Select Maven plugin for IntelliJ:
- From IntelliJ select: `Ctrl+Alt+S -> Build, Execution, Deployment -> Build tool -> Maven -> Maven home directory`
- Select the Maven plugin at `C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.1\plugins\maven\lib\maven3\bin`
- Add the path of Maven plugin above to the Path environment variables
7. Download and unzip latest Allure report source file: https://docs.qameta.io/allure/
- Create `ALLURE_HOME` environment variables
- Add `ALLURE_HOME` to Path: `%ALLURE_HOME%\bin`
8. Install dependencies: `mvn clean install`
9. Prepare test data on Jira:
- Create a project on Jira then get the `product key`, `base uri` and create `API token` at: https://id.atlassian.com/manage-profile/security/api-tokens
- Update the variables `baseUri`, `projectKey` in file `src/test/java/test/BaseTest.java`
- Update the variables `email`, `apiToken` in file `src/test/java/model/RequestCapability.java`
10. Run the tests by commandline: `mvn clean test -DxmlSuite="src/test/resources/test-suites/Regression.xml"`
11. Generate Allure report by commandline:
- `allure generate allure-results`
- `allure open`

## Run on GitHub Actions
1. Create Docker image for CI/CD (GitHub Actions, CircleCI)
- Build image: `docker build -t <user_name>/testng-allure .`
- Push image to Docker Hub: `docker push <user_name>/testng-allure`
2. Run tests on GitHub Actions:
- Check/update the file `.github/workflows/actions.yml`
- Commit and push code
