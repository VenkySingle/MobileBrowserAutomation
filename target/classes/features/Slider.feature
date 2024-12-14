Feature: Slider Interaction

  Background: 
    Given I am on the slider website "https://demo.automationtesting.in/Slider.html"

  Scenario: Slide the Sample Slider Given
    When Sliding the Field
    Then field should be slided and taken screenshot