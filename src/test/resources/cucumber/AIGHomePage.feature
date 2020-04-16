# new feature
# Tags: optional

Feature: AIG Home page works as expected

  Scenario: Home page should render correctly
    Given a user opens a browser
    When a user navigates to the AIG home page
    Then the user sees the page render successfully

  Scenario: Home page is fast
    Given a user opens a browser
    When a user navigates to the AIG home page
    Then the page loads within established baseline