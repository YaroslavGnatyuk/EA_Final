package com.easytox.automation.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Superadmin_locked_ntimes extends CommonCodeForAll{

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

	@When("^I make (\\d+) unsuccessful login attempts$")
	public void I_make_unsuccessful_login_attempts(int arg1) throws Throwable {
	    
		Thread.sleep(2000);
		credentials(driver);
		
		Thread.sleep(2000);
		credentials(driver);
		
		Thread.sleep(2000);
		credentials(driver);
		
		Thread.sleep(2000);
		credentials(driver);
	}

	@Then("^'superadmin' user should be locked$")
	public void _superadmin_user_should_be_locked() throws Throwable {
	 
		
		validation(driver);
		
	}

	@Then("^userid locked due to maximum unsuccessful attempts should be displayed.$")
	public void userid_locked_due_to_maximum_unsuccessful_attempts_should_be_displayed() throws Throwable {
	    
		validation(driver);		
		driver.quit();
		
	}

		


	
	
	
	
	
	
}
