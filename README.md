## State sync refactoring

### Overview

This project demonstrates the process of refactoring a poorly structured codebase step-by-step. The initial code is intentionally difficult to read and maintain, showcasing common issues that can be improved through refactoring.

### Project Structure

- `step-1-initial-state/`: Contains the initial version of the code with poor structure and bad practices.
- `build.gradle.kts`: Gradle build script for the project.
- `gradle/libs.versions.toml`: Dependency management file.

### Initial Code Issues

The initial code in `StateSynchronizer` class has several issues:
- Deeply nested conditionals.
- Lack of modularization and helper methods.
- Poor separation of concerns.

### Refactoring Steps

1. **Step 1: Initial State**
    - The initial version of the code with all the issues mentioned above.
    - This step serves as the starting point for the refactoring process.

### How to Run

1. **Build the project:**
   ```sh
   ./gradlew build
   ```

2. **Run the tests:**
   ```sh
   ./gradlew test
   ```

### Dependencies

- Java 21
- JUnit 5.12.0
