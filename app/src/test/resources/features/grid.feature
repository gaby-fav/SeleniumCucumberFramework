
Feature: Test differents actions on a static grid

Rule: The user can return values from the table and validate them. 
#Si se tiene una regla, todos los escenarios de este archivo deberan serbvir para verificar esta regla.

# //Si tengo pasos repetidos en todos los escenarios, puedo meterlos dentro del Background. Por ejemplo, este Given 

Background: Navigate to Table Web app
    Given I navigate to the static table


Scenario: As a test engineer I want to retrieve then value from a specific cell of a static table
    Then I can return  the value I want


Scenario: As a test engineer I want to validate the static table is displayed
    Then I can validate the table is displayed


