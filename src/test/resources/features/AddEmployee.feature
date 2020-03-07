#Author: syntax team (asel@syntaxtechs.com)
@sprint2 @addemployee
Feature: Add Employee

  Background: 
    Given I am logged into HRMS
    And I navigated to Add Employee Page

  @inProgress
  Scenario: Add new Employee
  When I add "John", "S" and "Smith"
  And I click Save
  Then I see Employee has been succesfully added
  
  @regression
  Scenario Outline: Add new Employee
  When I add "<FirstName>", "<MiddleName>" and "<LastName>"
  And I click Save
  Then I see Employee with "<FirstName>", "<MiddleName>" and "<LastName>" is displayed
  
  Examples:
  | FirstName | MiddleName | LastName |
  | James     |            | Smith    |
  | Jane      | J          | Smith    |
  | Sasha     | J          | Smith    |
  | David     | J          | Smith    |
  
  Scenario: Add Employee without employee id
  When I add "John", "S" and "Smith"
  And I delete employee id
  And I click Save
  Then I see employee without employee id is being added
  
  Scenario: Add Employee negative scenario
  When I click Save
  Then I see required error message next to the first and last name
  
  Scenario: AddEmployee and Login Credentials
  When I add "John", "S" and "Smith"
  And I click on create login checkbox
  And I enter "cocukAdam22", "Synt@9999" and "Synt@9999"
  When I click Save
  Then I see Employee has been succesfully added
  @inProgress
  Scenario: Add and Modify Employee Details
    When I enter employee details
      | FirstName | MiddleName | LastName |
      | Tester    | J          | Testere  |
    And I click Save
    And I click on Edit
    Then I am able to modify Employee Details
      | DriverLisence | ExpirationDate | SSN         | SIN     | Gender | MaritalStatus | Nationality | DOB        |
      | N78787886     | 2021-12-08     | 123-45-6789 | 7687687 | Male   | Other         | Afghan      | 1980-10-10 |
      | Nhkjkgkhgkg   | 2018-12-08     | 456-45-6789 | 5464466 | Female | Married       | Burmese     | 1990-10-10 |
   
