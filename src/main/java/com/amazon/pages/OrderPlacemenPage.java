package com.amazon.pages;

import com.amazon.base.BasePOM;
import com.amazon.pageobjects.CheckoutFlowPO;

public class OrderPlacemenPage extends BasePOM{
	
	CheckoutFlowPO checkoutFlow = new CheckoutFlowPO();
	
	public void verifyProceedtoCheckoutButtonEnabled() {
		appHelper().isElementEnabled(checkoutFlow.proceedtoCheckout[0], checkoutFlow.proceedtoCheckout[1]);
	}

	public void clickProceedtoCheckoutButton() {
		appHelper().clickByElement(checkoutFlow.proceedtoCheckout[0], checkoutFlow.proceedtoCheckout[1]);
	}
	
	public void selectDeliveryAddress() {
		appHelper().clickByElement(checkoutFlow.selectDeliveryAddress[0], checkoutFlow.selectDeliveryAddress[1]);
	}
	
	public void continueDeliveryOptions() {
		appHelper().clickByElement(checkoutFlow.selectDeliveryOptions[0], checkoutFlow.selectDeliveryOptions[1]);
	}
	
	public void isPaymentPageVisible() {
		appHelper().isElementEnabled(checkoutFlow.paymentPage[0], checkoutFlow.paymentPage[1]);
	}
}
