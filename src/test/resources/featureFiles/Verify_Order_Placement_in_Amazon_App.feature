Feature: Access Amazon APP and Login  
	Veirfy Login is success in amazon APP
	
	@regression
	Scenario Outline: Access and Login to Amazon App
	  Given user tap on Amazon APP on device
	  When the app opens verify the app loded successfully
	  Then the user tap on SignIn button
	  Then User enters email address and click on continue button
	  And User verifies password page
	  Then User enters password and click on Login button
	  Then User verifies search bar appearing in homepage
	  And search for a <searchKeyword> in search bar
	  Then user slects the <searchKeyword> in the list
	  And User select the <productName> from the results page
	  Then User navigated to Product details page
	  And User save the product details for valdite
	  Then User clicks on add to cart button
	  And verify the product price and name in cart page
	  Then User click on Proceed to Checkout button cart page
	  And user continue in delivery optoins page
	  Then Verify user is in payent page
	  
	  Examples:
		  |searchKeyword|productName|
		  |65-inch TV|65"|