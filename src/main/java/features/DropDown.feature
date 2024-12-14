Feature: Dropdown Interaction

  Background: 
    Given I am on the website "https://demoqa.com"

  Scenario: Select an option from the dropdown using select class
    When I select "Blue" from the dropdown
    Then the selected option should be "Blue"
