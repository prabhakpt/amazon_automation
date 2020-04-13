package com.amazon.test.steps;

import com.amazon.base.BasePOM;
import com.amazon.pages.ProductsPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ProductNavigationPageSteps extends BasePOM{
	
	@Given("^search for a (.*) in search bar$")
	public void searchProductinSearchBar(String product) {
		productsSearch().enterProductinSearchBar(product);
	}
	
	@And("^results should be displayed in drop down$")
	public void verifyProductsListDisplayed() {
		//productSearchPage.getListofProducts();
	}
	
	@Then("^user slects the (.*) in the list$")
	public void userSelectsProductList(String product) {
		productsSearch().accessFirstProductInSearchResults();
	}
	
	@Given("^User select the (.*) from the results page$")
	public void userSelectsTheProductfromResult(String product) {
		productsSearch().selectGetProductNamefromResults(product);
	}
	
	@Then("^User navigated to Product details page$")
	public void userNavigatedtoProductDetailsPage() {
		productsSearch().isImagePresentInProductPage();
	}
	
	@And("^User check for the price of the product$")
	public void checkPriceoftheProduct() {
		// should get product name and price to validate in checkout flow
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
	
}
