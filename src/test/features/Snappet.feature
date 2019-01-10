Feature: Snappet feature

  @smoke
  Scenario: To check login options are present on app launch
    Given I am on the login page
    Then username field is displayed on login page
    And password field is displayed on login page
    And login button is displayed on login page

  @smoke
  Scenario: Login to the teacher dashboard
    Given I am on the login page
    And I login to the teacher dashboard
    Then I am on the dashboard page

  @smoke
  Scenario: Activating a subject
    Given I am on the dashboard page
    Then I click on activate subject button on dashboard page
    And activate the first subject

  @Implemented @smoke
  Scenario: Check created lessons are present
    Given I am on the dashboard page
    Then I click on lessons tab on dashboard page
    And I am on the lessons page
    And I should find the lessons

  @Implemented @smoke
  Scenario: Deleting a subject
    Given I am on the dashboard page
    Then I delete the subject
    And I click on lessons tab on dashboard page
    And I should not find the lessons

  @Implemented @smoke
  Scenario: Log out of the app
    Given I am on the dashboard page
    And I click on user icon on dashboard page
    Then I click on logout button on dashboard page
    And I am on the login page
