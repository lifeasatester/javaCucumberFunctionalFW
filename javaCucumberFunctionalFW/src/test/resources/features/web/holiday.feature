#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tagBookFlightHotel
Feature: Going on Holiday
  I want to book flight ticket and a hotel

  @tag
  Scenario: Book Hotel
    Given I live in Bangalore
    And I want to go on holiday
    And we are 10 adults
    And we want to book from 10th Jan 2020 to 20th Feb 2020
    When I go to travel agent
    Then he should be able to help me in a budget of 10000 Rs
    And he should provide option to cancel
    
