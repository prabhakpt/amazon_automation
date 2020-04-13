Feature: Access Products in Amazon app  
	Search for the products and scroll through the products
	
	@sanity
	Scenario Outline: Access Products in Amazon app
	  Given search for a <product> in search bar
	  And results should be displayed in drop down
	  Then user slects the <product> in the list
	  
	  Examples:
		  |product|
		  |Himalaya|
		  
	@sanity
	Scenario Outline: Add product to Cart
		Given User select the <product> from the results page
		Then User navigated to Product details page
		And User check for the price of the product
		Then User clicks on add to cart button
		
		Examples:
			|product|
			|Himalaya Gentle Baby Shampoo (200ml)|