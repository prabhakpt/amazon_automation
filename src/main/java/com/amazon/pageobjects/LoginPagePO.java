package com.amazon.pageobjects;

public class LoginPagePO {
	
	public String[] emailID = new String[] {"id","ap_email_login"};
	public String[] continueButton = new String[] {"id","continue"};
	public String[] password = new String[] {"id","ap_password"};
	public String[] userName = new String[] {"xpath","//android.view.View[@index='3']"};
	public String[] loginButton = new String[] {"id","signInSubmit"};
	public String[] changeLink = new String[] {"id","ap_change_login_claim"};
	public String[] twoWayAuthentication = new String[] {"id","continue"};
	
}
