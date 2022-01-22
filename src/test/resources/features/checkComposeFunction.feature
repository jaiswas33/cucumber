Feature: Test the compose function in Gmail

Background: User is Logged In
	  Given navigate to base url
		And perform login

  Scenario: check compose button exist
    Then verify compose button exist
	
  Scenario: compose button is clickable
    And click on compose button
    Then new email body should display

  Scenario: compose email
    And click on compose button
    And enter recipients "lifi@incubyte.co"
    And enter subject "Incubyte"
    And enter email body "Automation QA test for Incubyte"
    And click on send button
    And click on main menu button
    Then click sent button
    Then verify latest email subject