package com.amazon.test.steps;

import com.amazon.base.BasePOM;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ProductNavigationPageSteps extends BasePOM{
	
	@And("^search for a (.*) in search bar$")
	public void searchProductinSearchBar(String product) {
		productsSearch().enterProductinSearchBar(product);
	}
	
	@Then("^user slects the (.*) in the list$")
	public void userSelectsProductList(String product) {
		productsSearch().accessFirstProductInSearchResults();
	}
	
	@And("^User select the (.*) from the results page$")
	public void userSelectsTheProductfromResult(String product) {
		productsSearch().selectGetProductNamefromResults(product);
	}
	
	@Then("^User navigated to Product details page$")
	public void userNavigatedtoProductDetailsPage() {
		productsSearch().isImagePresentInProductPage();
	}
	
	@And("^User save the product details for valdite$")
	public void checkPriceoftheProduct() {
		productsSearch().getProductTitle();
		productsSearch().getProductPrice();
	}
	
	@Then("^User clicks on add to cart button$")
	public void userClicksonAddToCartButton() {
		
		productsSearch().clickOnAddtoCartButton();
		productsSearch().navigateToSoppingCartPage();
	}
	
	@Then("^User verifies search bar appearing in homepage$")
	public void userSearchForSearchBar() {
		productsSearch().verifySearchBarInHomePage();
	}
	
	@And("^verify the product price and name in cart page$")
	public void verifyPriceAndProduct(){
		productsSearch().verifyPriceAndProductName();
	}
	
}
