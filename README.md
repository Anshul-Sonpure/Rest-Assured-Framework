# _Rest Assured Framework_
This is a Java-based framework for testing RESTful APIs using the Rest Assured library. The framework includes a Java class file named GoRestEndPoint and a test script file named GoRestEndPointTest.

### Getting Started
To use this framework, follow the steps below:
- Clone the repository to your local machine.
- Import the project into your IDE.
- Modify the endpoint variable in the test methods to point to the API you want to test.
- Run the test methods.

## Usage
### GoRestEndPoint Class
The GoRestEndPoint class contains a method named sendRequest that takes four parameters:
- endpoint (String): The API endpoint to send the request to.
- httpMethod (String): The HTTP method to use for the request (e.g. GET, POST, PATCH, DELETE).
- payload (Object): The payload to include in the request (if applicable).
- id (String): The ID of the request (for logging purposes).
The method returns a Response object, which contains the response from the API.

### GoRestEndPointTest Class
The GoRestEndPointTest class contains several test methods that use the GoRestEndPoint class to perform different HTTP methods (e.g. GET, POST, PATCH, DELETE) on the API. The responses from these requests are logged using a logger.

## Dependencies
This framework requires the following dependencies:
- RestAssured: To test REST APIs.
- Log4j: To log the responses.
- TestNG: To run the test methods.

## Logging
The framework implements logging using Log4j. The logs are stored in the logs directory in the root of the project. Separate log files are generated for each test method.

## Future Improvements
- Add support for SOAP APIs.
- Implement test data management using a data provider.
- Add support for parallel test execution.
- Implement reporting using a reporting tool such as ExtentReports.

## Contributing
If you would like to contribute to this framework, please fork the repository and submit a pull request with your changes. We welcome all contributions and appreciate your help in making this framework even better!



Thank You\
Happy Coding,\
Learn,Code and Earn\
Stay Safe and Stay Positive :)
