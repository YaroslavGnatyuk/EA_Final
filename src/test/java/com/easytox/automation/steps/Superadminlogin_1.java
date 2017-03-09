package com.easytox.automation.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber2project.DataStorage;

public class Superadminlogin_1 {

	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "superadmin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="admin";
	private static final String Lab_Profile_URL ="http://bmtechsol.com:8080/easytox/lab/list";
	private WebDriver driver;
	

	
	public codePlace(){
		
		DataStorage.getDriver();
		driver = DataStorage.getDriverType();
	}
	
	

	
	@Given("^I am on easytox login page$")
	public void I_am_on_easytox_login_page() throws Throwable {
	  
		driver.get("http://bmtechsol.com:8080/easytox/");		 
		
		 driver.manage().window().maximize();		 
		
		
		
	}

	@When("^I login with superadmin user 'superadmin' and pwd 'admin'$")
	public void I_login_with_superadmin_user_superadmin_and_pwd_admin() throws Throwable {
		
		 credentials(driver);
	
	}

	@When("^the username and password are correct$")
	public void the_username_and_password_are_correct() throws Throwable {
	    
		
		Thread.sleep(2000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
		
		
	}

	@Then("^the superadmin login page should be displayed$")
	public void the_superadmin_login_page_should_be_displayed() throws Throwable {
	    
		
		Thread.sleep(2000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
		
		
		driver.quit();
		
		
	}


	
	public static void credentials(WebDriver driver2)
	{
		
			WebElement user =  driver2.findElement(By.name(USER_NAME));
			user.clear();
			user.sendKeys(PAGE_ID);
			
			WebElement pwd = driver2.findElement(By.name(PASSWD));
			 pwd.clear();
			 pwd.sendKeys(PAGE_PSWD);		 
			 driver2.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div/button")).click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
