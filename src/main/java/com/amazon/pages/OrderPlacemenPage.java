package com.amazon.pages;

import com.amazon.base.BasePOM;
import com.amazon.pageobjects.CheckoutFlowPO;
import com.amazon.test.data.UserData;

public class OrderPlacemenPage extends BasePOM{
	
	CheckoutFlowPO checkoutFlow = new CheckoutFlowPO();
	
	public void verifyProceedtoCheckoutButtonEnabled() {
		appHelper().isElementEnabled(checkoutFlow.proceedtoCheckout[0], checkoutFlow.proceedtoCheckout[1]);
	}

	public void clickProceedtoCheckoutButton() {
		appHelper().clickByElement(checkoutFlow.proceedtoCheckout[0], checkoutFlow.proceedtoCheckout[1]);
	}
	
	public void selectDeliveryAddress() {
		if(appHelper().isElementDisplayed(checkoutFlow.fullName[0], checkoutFlow.fullName[1])) {
			enterCustomerData();
			appHelper().clickByElement(checkoutFlow.continueButton[0], checkoutFlow.continueButton[1]);
		}else {
			appHelper().clickByElement(checkoutFlow.selectDeliveryAddress[0], checkoutFlow.selectDeliveryAddress[1]);
		}
	}
	
	public void continueDeliveryOptions() {
		if(appHelper().isElementDisplayed(checkoutFlow.selectDeliveryOptions[0], checkoutFlow.selectDeliveryOptions[1]))
			appHelper().clickByElement(checkoutFlow.selectDeliveryOptions[0], checkoutFlow.selectDeliveryOptions[1]);
	}
	
	public void isPaymentPageVisible() {
		appHelper().isElementEnabled(checkoutFlow.paymentPage[0], checkoutFlow.paymentPage[1]);
	}
	
	public void enterCustomerData() {
		appHelper().enterTextByElement(checkoutFlow.fullName[0], checkoutFlow.fullName[1], UserData.fullName);
		appHelper().enterTextByElement(checkoutFlow.addressLine1[0], checkoutFlow.addressLine2[1], UserData.address1);
		appHelper().enterTextByElement(checkoutFlow.phoneNumber[0], checkoutFlow.phoneNumber[1], UserData.phoneNumber);
		appHelper().enterTextByElement(checkoutFlow.postalCode[0], checkoutFlow.postalCode[1], UserData.postalCode);		
	}
}
