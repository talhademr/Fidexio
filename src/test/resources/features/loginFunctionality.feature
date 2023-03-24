@FIDEX10-320 @regression
Feature: Login Functionality

  Background: Login page
    Given User is on the login page

  @FIDEX10-406
  Scenario Outline: Users can log in with valid credentials
    When User enters valid email "<email>"
    And User enters valid password "<password>"
    And User clicks login button
    Then User should be on the homepage

    Examples: Email and Password
      | email                   | password     |
      | salesmanager60@info.com | salesmanager |
      | salesmanager65@info.com | salesmanager |
      | salesmanager75@info.com | salesmanager |
      | posmanager70@info.com   | posmanager   |
      | posmanager15@info.com   | posmanager   |
      | posmanager25@info.com   | posmanager   |


  @FIDEX10-407
  Scenario Outline: "Wrong login/password" should be displayed for invalid
  (valid username-invalid password and invalid username-valid password) credentials
    When User enters invalid email "<email>"
    And User enters invalid password "<password>"
    And User clicks login button
    Then User should see warning message
    Examples:
      | email                    | password       |
      | posmanager0870@info.com  | posmanager     |
      | salesmanager640@info.com | salesmanager   |
      | posmanage8@info.com      | ASDFSHTRHvdfg  |
      | smanager4@info.com       | posmanager^(*  |
      | posmanag123@info.com     | *+/.123456dfşk |
      | posmange987@info.com     | tjfzgs12345    |

  @FIDEX10-408
  Scenario Outline: "Please fill out this field" message should be displayed if the password or username is empty
    When User enters empty email "<email>"
    And User enters  empty password "<password>"
    And User clicks login button
    Then user should see "Please fill out this field." validation message
    Examples:
      | email                    | password   |
      |                          |            |
      | salesmanager123@info.com |            |
      |                          | posmanager |
    @FIDEX10-409
    Scenario: User land on the ‘reset password’ page after clicking on the "Reset password" link
      When user click "Reset password" link
      Then  User land on reset  password page

      @FIDEX10-410
  Scenario: User should see the password in bullet signs by default
    When User enters a password "posmanager"
    Then User sees the password in bullet sign

      @FIDEX10-411
  Scenario Outline: ‘Enter’ key of the keyboard is working correctly on the login page
    When User enters an email "<email>"
    And User enters a password "<password>"
    And User presses enter key
    Then User should be on the homepage
        Examples:Email and Passwords
          | email                   | password     |
          | salesmanager70@info.com | salesmanager |
