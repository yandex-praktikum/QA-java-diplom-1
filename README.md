# Unit Testing Showcase - Burger Customizer

## Project Overview
This Java project, 'Burger Customizer', serves as a showcase of advanced unit testing techniques, including the use of mocks, stubs, and parameterized tests, to ensure the reliability of code. It also integrates JaCoCo for code coverage analysis.

## Key Concepts Demonstrated
- **Mocking**: Illustrates how to use Mockito for creating mock objects to isolate and test specific components.
- **Stubbing**: Demonstrates the implementation of stubs to simulate dependencies and control their behavior during tests.
- **Parameterized Testing**: Utilizes parameterized tests to systematically test multiple scenarios with different inputs.
- **Code Coverage Analysis**: Integrates JaCoCo to measure code coverage, ensuring that tests cover a significant portion of the codebase.

## Technologies Used
- **Java 11**: The primary programming language.
- **JUnit 4.13.2**: Employed for writing unit tests.
- **Mockito 4.2.0**: Used to create mocks and stubs.
- **Maven 3.9.0**: Handles project management and dependencies.
- **JaCoCo 0.8.7**: Provides code coverage analysis.

## How to Run Tests
To run the unit tests and see code coverage analysis, follow these steps:

1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Run the following Maven command:
   ```bash
   mvn clean test
