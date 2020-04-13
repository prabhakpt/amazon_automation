package com.amazon.pageobjects;

public class CheckoutFlowPO {
	public String[] proceedtoCheckout = new String[] {"xpath","//android.widget.Button[@resource-id='a-autoid-1-announce']"};
	
	public String[] fullName = new String[] {"xpath","//android.widget.EditText[@resource-id='enterAddressFullName']"};
	public String[] phoneNumber = new String[] {"xpath","//android.widget.EditText[[@resource-id='enterAddressPhoneNumber']"};
	public String[] addressLine1 = new String[] {"xpath","//android.widget.EditText[[@resource-id='enterAddressAddressLine1']"};
	public String[] addressLine2 = new String[] {"xpath","//android.widget.EditText[[@resource-id='enterAddressAddressLine2']"};
	public String[] postalCode = new String[] {"xpath","//android.widget.EditText[[@resource-id='enterAddressPostalCode']"};
	public String[] city = new String[] {"xpath","//android.widget.EditText[[@resource-id='enterAddressCityText']"};
	public String[] state = new String[] {"xpath","//android.widget.EditText[[@resource-id='enterAddressStateOrRegionText']"};
	public String[] continueButton = new String[] {"xpath","//android.widget.Button[@text='Continue']"};
	
	public String[] selectDeliveryAddress = new String[] {"id","a-autoid-0-announce"};
	public String[] selectDeliveryOptions = new String[] {"xpath","//android.widget.Button[@text='Continue']"};
	public String[] paymentPage = new String[] {"xpath","//android.view.View[@text='Select a payment method']"};
	
}
