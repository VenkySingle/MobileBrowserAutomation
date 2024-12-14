Feature: Slider Interaction

  Background: 
    Given I am on the draganddrop website "https://www.globalsqa.com/demo-site/draganddrop/"

  Scenario: Drag and drop the pictures
    When Dragging the pictures and drop to trash
    Then field should be dragged and taken screenshot