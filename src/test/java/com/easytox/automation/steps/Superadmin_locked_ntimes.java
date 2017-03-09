package com.easytox.automation.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber2project.DataStorage;

public class Superadmin_locked_ntimes {

	
	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "superadmin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="admi11n";
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
	
	
	public static void  validation(WebDriver driver3) throws Throwable 
	{
		Thread.sleep(2000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver3.getCurrentUrl();	
	    Assert.assertNotEquals(currentUrl, curtUrlDriver);
		
	}
	
	

	
	
	
	
	
	
	
	
}
