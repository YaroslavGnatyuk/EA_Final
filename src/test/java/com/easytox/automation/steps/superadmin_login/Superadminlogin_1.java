package com.easytox.automation.steps.superadmin_login;

import com.easytox.automation.steps.common_code_for_all.CommonCodeForAll;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Superadminlogin_1 extends CommonCodeForAll {

	@Given("^I am on easytox login page$")
	public void I_am_on_easytox_login_page() throws Throwable {
	  
		driver.get(CommonCodeForAll.URL);		 
		
		 driver.manage().window().maximize();		 
		
		
		
	}

	@When("^I login with superadmin user 'superadmin' and pwd 'admin'$")
	public void I_login_with_superadmin_user_superadmin_and_pwd_admin() throws Throwable {
		
		 credentials(driver);
	
	}

	@When("^the username and password are correct$")
	public void the_username_and_password_are_correct() throws Throwable {
	    
		
		validation(driver);
		
		
	}

	@Then("^the superadmin login page should be displayed$")
	public void the_superadmin_login_page_should_be_displayed() throws Throwable {
	    
		
		validation(driver);
		
		
		driver.quit();
		
		
	}


	

	
	
	
	
	
	
	
	
	
}
