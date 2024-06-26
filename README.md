# Getting Started
## Local
### Preinstall:
1. Docker, Docker Compose; (Docker Desktop for Windows);
2. Java 21 (For native env start);
### Environment:
1. SignUp on [currencyapi.com](https://currencyapi.com/);
2. Create API Key. Use Link: [api keys](https://app.currencyapi.com/api-keys);
3. Add api key as environment variable with name:
```
CURRENCY_CLIENT_API_KEY
```
### How to start:
1. Open terminal in the root folder of the repo (folder with this README.md file);
2. Run the command:
```shell
docker-compose up -d
```
This command will start PostgreSQL locally on port **5432** and required db user and database will be created.
4. Now application can be started. Run this command:
```shell
./gradlew bootRun
```
or for Win:
```shell
.\gradlew bootRun
```
This command will build application, and after passing all tests start application
5. Swagger is available on:
```http request
http://localhost:8080/swagger-ui/index.html
```
6. To stop:

`Ctrl + z` on Mac or Linux

`Ctrl + c` on Windows
