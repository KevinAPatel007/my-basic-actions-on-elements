Feature: Login

  @smoke
  Scenario: Validate login page
    Given I am on the home page
    When I click on the "Log in"
    Then I should see "Welcome, Please Sign In!" text on login page
    And the url should contain with "/login"

  Scenario: Validate login with valid email and password
    Given I am on the home page
    When I click on the "Log in"
    And I enter email "test@gmail.com" and password "hello@123"
    And I click on log in on login page
    Then I should see log out button displayed

  Scenario Outline: Validate login with more then one email and password
    Given I am on the home page
    When I click on the "Log in"
    And I enter email "<myEmail>" and password "<myPassword>"
    And I click on log in on login page
    Then I should see log out button displayed
    Examples:
      | myEmail         | myPassword   |
      |  test@gmail.com    | hello@123     |