@FIDEX10-314
Feature: US-002 Logout Functionality

 # User Story : As a user, I should be able to log out.
  # Acceptance Criteria:
  #   1- User can log out and ends up in login page.
  #   2- The user can not go to the home page again by clicking the step back
  #   button after successfully logged out.


  Background: User is on the home page
    Given User goes to the login page
    And User logged in with valid credentials
    Then User sees the home page

  @FIDEX10-497
  Scenario: User can log out and ends up in login page
    When User clicks the username button
    And User clicks the logout button
    Then User goes back to login page

  @FIDEX10-498
  Scenario: The user can not go to the home page again by clicking the step back button after successfully logged out
    When User clicks the username button
    And User clicks the logout button
    And User goes back to login page
    And User clicks back button
    Then User can not go to the home page again