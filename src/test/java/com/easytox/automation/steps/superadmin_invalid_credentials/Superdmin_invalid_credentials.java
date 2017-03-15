package com.easytox.automation.steps.superadmin_invalid_credentials;

import com.easytox.automation.steps.common_code_for_all.CommonCodeForAll;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Superdmin_invalid_credentials extends CommonCodeForAll {

	
	@Given("^I am on easytox login page$")
	public void I_am_on_easytox_login_page() throws Throwable {
		  
				driver.get(CommonCodeForAll.URL);		 
				
				 driver.manage().window().maximize();
	}

	@When("^I login with superadmin user 'superadmin',pwd 'admin'$")
	public void I_login_with_superadmin_user_superadmin_pwd_admin() throws Throwable {
		
		credentials(driver);
	}

	@When("^the username and password are NOT correct$")
	public void the_username_and_password_are_NOT_correct() throws Throwable {
	    
		validation(driver);	
		
	}

	@Then("^Invalid User name/password should be displayed$")
	public void Invalid_User_name_password_should_be_displayed() throws Throwable {
	   
		
		validation(driver);		
		driver.quit();
		
	}
	
	
	
	
	
	
	
}
