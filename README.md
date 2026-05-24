# bean-API

## Architecture

To model entites in this application Domain Driven Design (DDD) will be used.

### Sub Domains

There has been 5 sub domains identified, split between, core, supporting, and generic domains.

Core Domains:
- Bean
- Review
- User

Supporting Domain:
- Analytics (TBA)

Generic Domain:
- Auth (TBA)

### Bounded Context

Further more bounded contexts have been identified:
- Bean catalog context
 - Bean aggregate
 - Roaster aggregate

- Review context
 - Review Aggregate

Identity Context
 - User aggregate 
 - Auth aggregate 


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
