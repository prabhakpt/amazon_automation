package com.amazon.pageobjects;

public class CheckoutFlowPO {
	public String[] proceedtoCheckout = new String[] {"xpath","//android.widget.Button[@text='Proceed to Buy']"};
	public String[] selectDeliveryAddress = new String[] {"id","a-autoid-0-announce"};
	public String[] selectDeliveryOptions = new String[] {"xpath","//android.widget.Button[@text='Continue']"};
	public String[] paymentPage = new String[] {"xpath","//android.view.View[@text='Select a payment method']"};
}
