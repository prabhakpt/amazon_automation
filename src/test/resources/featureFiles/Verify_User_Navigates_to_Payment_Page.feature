Feature: Access checkout flow in Amaon App 
	User proceed to checkout and navigate to payment page
	
	@sanity
	Scenario: Navigate to payment page
	  Given User click on Proceed to Checkout button cart page
		Then user selects the delivery address
	  And user continue in delivery optoins page
	  Then Verify user is in payent page