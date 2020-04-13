Feature: Access Amazon APP and Login  
	Veirfy Login is success in amazon APP
	
	@sanity
	Scenario: Access and Login to Amazon App
	  Given user tap on Amazon APP on device
	  When the app opens verify the app loded successfully
	  Then the user tap on SignIn button
	  Then User enters email address and click on continue button
	  And User verifies password page
	  Then User enters password and click on Login button
	  Then User verifies search bar appearing in homepage