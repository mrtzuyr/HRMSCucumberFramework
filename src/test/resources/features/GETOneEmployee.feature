Feature: Validating Syntax /getOneEmployee.php HRMS API
Background:
Given user generates token

#This is the only homework Assignment
@APITest
Scenario: Retrieving created Employee using /getOneEmployee.php API
Given user calls getOneEmployee API
When User retrieves response for get one employee
Then status code is 200
Then user validates created employee exists
