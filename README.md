# bean-API

## Dev-tools

To ease development a number of dev tools have been imported and integrated in the build process and CI/CD:

- Spotless
  - A static analysis tool for linting. Can also automate formating of code.
  - Commands:
    - Checks if code is conforming to the right formating:
      - ```./gradlew spotlessCheck``` 
    - Apply changes to the whole code base:
      - ```./gradlew spotlessApply``` 
      
- Spotbugs
  - A static analysis tool to spot bugs.
  - Commands:
    - Runs Spotbugs on Java source files:
      - ```./gradlew spotbugsMain```
    - Runs Spotbugs on Java tests files:
      - ```./gradlew spotbugsTest```
      
- Junit
  - Unit testing for Java.
  - Commands:
    - Run tests:
      - ```./gradlew test```

- Flyway
  - Migration tool.
   - Intellij can be used to init flyway (DDL) migration files:
    - Refere to: [link](https://blog.jetbrains.com/idea/2024/11/how-to-use-flyway-for-database-migrations-in-spring-boot-applications/#:~:text=Once%20the%20project%20has%20been,spring.)