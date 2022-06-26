Feature: Test different actions on a list

@List
Scenario:As a test engineer, I want to validate that a text is present in a list

Given I navigate to the list page
When I search the list
Then I can find the text in the list