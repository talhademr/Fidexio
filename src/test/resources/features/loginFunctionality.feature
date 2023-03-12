#Execution
Feature: Login Functionality

  Background: Login page
    Given User is on the login page

  #Test Case 1
  Scenario Outline: Login with valid credentials
    When User enters valid email "<email>"
    And User enters valid password "<password>"
    And User clicks login button
    Then User should be on the homepage

    Examples: Email and Password
      | email                   | password     |
      | salesmanager60@info.com | salesmanager |
      | salesmanager65@info.com | salesmanager |
      | posmanager70@info.com   | posmanager   |
      | posmanager15@info.com   | posmanager   |

  #Test Case 2
  Scenario Outline: Login with invalid credentials
    When User enters invalid email "<email>"
    And User enters invalid password "<password>"
    And User clicks login button
    Then User should see the error message

    Examples: Email and Password
      | email                    | password     |
      | salesmanage6@info.com    | salesmanager |
      | salesmanager100@info.com | salesmanage  |
      | posmanager1@info.com     | posmanager   |
      | posmanager100@info.com   | pomanager    |
