package com.amazon.test.steps;

import com.amazon.base.BasePOM;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class OrderPlacementSteps extends BasePOM{
	
	@Given("^User click on Proceed to Checkout button cart page$")
	public void clickProceedtoCheckoutButton() {
		orderPlacementPage().verifyProceedtoCheckoutButtonEnabled();
		orderPlacementPage().clickProceedtoCheckoutButton();
	}
	
	@Then("^user selects the delivery address$")
	public void userSelectDeliveryAddress() {
		orderPlacementPage().selectDeliveryAddress();
	}
	
	@And("^user continue in delivery optoins page$")
	public void userContinueDeliveryOptions() {
		orderPlacementPage().continueDeliveryOptions();
	}
	
	@And("^Verify user is in payent page$")
	public void verifyUserInPaymentPage() {
		orderPlacementPage().isPaymentPageVisible();
	}
}
