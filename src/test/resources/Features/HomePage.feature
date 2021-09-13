Feature: Home Page Functionality

Scenario: Verify our brands listing
Given I am on homepage
When I click on Our Brands
Then JW Marriott must be listed there
And Close the browser

Scenario Outline: Verify if searched hotels are from correct city
Given I am on homepage
When I search for <city>
Then first hotel in the search result should contain <city> name
And Close the browser

Examples:
|city|
|Paris|
|London|

Scenario: Verify if Mobile Check-In and Mobile Key are present in Member Benefits page 
Given I am on homepage
When I go to Members Benefits Page
Then  Mobile Check-In and Mobile Key must be present there
And Close the browser
