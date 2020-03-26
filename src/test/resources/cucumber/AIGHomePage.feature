# new feature
# Tags: optional

Feature: AIG Home page works as expected

  Scenario: Home page should render correctly
    Given a user opens a browser
    When a user navigates to the AIG home page
    Then the user sees the page render successfully

  Scenario: Home page is responsive
    Given a user opens a browser
    When a user navigates to the AIG home page
    Then the page loads in under 4 seconds

  Scenario: AIG Business page renders
    Given a user opens a browser
    When a user navigates to the AIG business page
    Then the user sees the Business page render sucessfully