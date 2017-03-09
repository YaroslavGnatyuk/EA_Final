package com.easytox.automation.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber2project.DataStorage;

public class Superadmin_forgotpasswd_page {

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
		 credentials(driver);
		
	}

	@When("^I press forgot password click here$")
	public void I_press_forgot_password_click_here() throws Throwable {
	 
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div/div/div/div[3]/a")));
		
		driver.findElement(By.xpath("html/body/div[1]/div/div/div/div[3]/a")).click();
		
		
	}

	@Then("^forgot password page for username and email should be displayed$")
	public void forgot_password_page_for_username_and_email_should_be_displayed() throws Throwable {
	   
		
		
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
