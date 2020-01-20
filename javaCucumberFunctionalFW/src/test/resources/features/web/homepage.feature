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
@tag
Feature: Launching HomePage
  I want to launch the homepage and perform basic validations

  @Homepage, @Login
  Scenario: Launch Homepage and perform sign-in
    Given I am on homepage
#    And I click on the signin logo
#    And I click on Shop nav link
    And I click on Appliances link
    And I click on Dishwasher link
    