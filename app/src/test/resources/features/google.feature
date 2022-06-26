Feature: Test Google Search functionality

Scenario: As a user I enter a search criteria in Google
    Given I am on ther Google seach page
    When I enter a search criteria
    And click on the search button
    Then the results march the criteria

