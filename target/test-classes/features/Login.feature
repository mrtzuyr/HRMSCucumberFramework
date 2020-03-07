@sprint1,login
Feature: Login

  @smoke
  Scenario: Valid Login
    When I enter valid username and valid password
    And I click login button
    Then I successfully logged in

  @regression
  Scenario: Invalid Login
    When I enter valid username and invalid password
    And I click login button
    Then I see error message

  @regression
  Scenario Outline: Invalid login and message validation
    When I enter "<Username>" and "<Password>"
    And I click login button
    Then I see "<ErrorMessage>"

    Examples: 
      | Username | Password   | ErrorMessage             |
      | Admin    | Admin123   | Invalid credentials      |
      | Admin    |            | Password cannot be empty |
      |          | Syntax@123 | Username cannot be empty |
      |          |            | Username cannot be empty |
