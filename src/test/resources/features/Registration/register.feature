Feature: User Registration

  Background:
    Given I am on the registration page

  @Smoke
  @RegisterFeature
  @Regression
  Scenario: Register a new user with valid credentials
    When I fill in the registration form with valid data from "validData.csv"
    And I submit the registration form
    Then I should see a "Your account was created successfully" message

  @RegisterFeature
  @Regression
  Scenario: Register an existing username
    When I fill in the registration form with an existing username from "validData.csv"
    And I submit the registration form
    Then I should see "This username already exist" message on "errorUsername" title

# Trying to show different approaches
  @Smoke
    @RegisterFeature
    @Regression
  Scenario Outline: : Registration with empty field
    And I fill in the registration form with an empty field by following details
      | <First Name>       |
      | <Last Name>        |
      | <Address>          |
      | <City>             |
      | <State>            |
      | <Zip Code>         |
      | <Phone>            |
      | <Ssn>              |
      | <Username>         |
      | <Password>         |
      | <Password Confirm> |
    When I submit the registration form
    Then I should see "required" message on "<Error Field>" title
    Examples:
      | First Name | Last Name | Address      | City         | State | Zip Code | Phone      | Ssn       | Username   | Password  | Password Confirm | Error Field          |
      | John       | Doe       | 123 Main St  | Springfield  |       | 62701    | 1234567890 | 123456789 | johndoe    | password1 | password1        | errorState           |
      | John       | Doe       | 123 Main St  | Springfield  | CA    | 62701    | 1234567890 | 123456789 | johndoe    |           | password1        | errorPassword        |
      | Alice      | Smith     | 456 Elm St   | Exampleville | CA    | 90210    | 9876543210 | 987654321 | alicesmith | password2 |                  | errorPasswordConfirm |
      | Bob        | Johnson   |              | Smalltown    | TX    | 12345    | 5555555555 | 555555555 | bobjohn    | password3 | password3        | errorAddress         |
      | Emma       | Wilson    | 789 Oak St   | Bigcity      | NY    |          | 1112223333 | 111222333 | emmawil    | password4 | password4        | errorZipCode         |
      | David      | Lee       | 789 Oak St   |              | PA    | 54321    | 4444444444 | 444444444 | dlee       | password5 | password5        | errorCity            |
      |            | Brown     | 789 Oak St   | Suburbia     | FL    | 54321    | 7778889999 | 777888999 | ebrown     | password6 | password6        | errorFirstName       |
      | Olivia     |           | 101 Pine St  | Villageton   | OH    | 12345    | 1112223333 | 999999999 | oltaylor   | password7 | password7        | errorLastName        |
      | Liam       | Martinez  | 321 Cedar St | Townsville   | AZ    | 54321    | 6666666666 |           | liamm      | password8 | password8        | errorSsn             |
      | Liam       | Martinez  | 321 Cedar St | Townsville   | AZ    | 54321    | 6666666666 | 999999999 |            | password8 | password8        | errorUsername        |
      | Liam       | Martinez  | 321 Cedar St | Townsville   | AZ    | 54321    |            | 999999999 | liamm      | password8 | password8        | errorPhone           |