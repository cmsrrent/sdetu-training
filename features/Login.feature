#Each feature file contains just one feature
#Feature files use Gherkin language - business language
#Use of tags that can be used within the runner to identify which 
#features or scenarios we wish to run within the cucumber runner 
@endtoend
Feature: Test the login functionality on sdet university

Background:
    Given user is on the login page

#A feature may have given different specific scenarios
#Scenarios use Given-When-Then structure
@singleScenario
  Scenario: the user should be able to login with correct username and password    
    When user enters correct username and correct password    
    Then user gets confirmation
    
@multiScenario
	Scenario Outline: the user should be able to login		
		When user enters email <username>
		And user enters password <password>
		And user clicks login button
		Then user gets confirmation
		
		Examples:
		| username | password |
		| tim@testemail.com | trpass |
		| testhide@mailinator.com | rwpass |
		| testhide2@mailinator.com | jvpass |
