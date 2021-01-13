# Star Wars API Project
For this project, you will be building a testing framework to test the Star Wars API

## Service Object Model
Since the API has a number of different responses, you will need to use a Service Object Model. This model represents the various API requests using the following components:

1. DTO: Classes that represent the different types of responses that can be called
2. ConnectionManager: A class which handles the connection to the live system and collecting the response.
3. Injector: A class responsible for injecting the payload into an appropriate DTO

These are the main components and you are not limited to just these. The DTOs should provide access to all the data that testers could find useful.

Along with providing the DTOs, you should also provide an example test bed showing examples of ALL the different types of test that can be performed.

## Artifacts
- Kanban Board
- README file explaining how to use the framework to perform tests

## Git
- Follow good standards for Git:
    - Have a dev branch for working code
    - Have feature branches for specific areas you are working on
    - The main branch should only ever have production ready code for public use

## Key Points
- The focus is on the quality of the framework. Test as much as you can but focus on the framework itself
- Put yourself in the place of the tester. What would make your life easier?
- Think about which tests are vital and need to be prioritied higher