Feature: Test different actions on a list

@List #Siempre que se haga uyn escenario outline pide tabla de eejemplos
Scenario Outline:As a test engineer, I want to validate that a text is present in a list

Given I navigate to the list page
When I search <state> in the list
Then I can find <city> in the list

Examples:
    |state      |city              |            
    |Washington |Seattle, Washington| 
    |Chicago    |Chicago, Illinois  | 
