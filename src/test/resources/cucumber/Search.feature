Feature: Search
  Scenario: Search is working
    Given a user navigates to the AIG home page
    When a user searches for "travel"
    Then some results come back