package com.easytox.automation.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class ET_LO_004_Verify_the_Lock_Lab {
	
	
	
	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "superadmin";
	private static final String PAGE_ID1 = "retestuser";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="admin";
	private static final String PAGE_PSWD1 ="Test@123";
	private static final String Lab_Profile_URL ="http://bmtechsol.com:8080/easytox/lab/list";
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	

	
	public ET_LO_004_Verify_the_Lock_Lab(){
		
		DriverBase.instantiateDriverObject();
        this.webElementHelper = new WebElementHelper();
        driver = DriverBase.getDriver();
	}
	
	
	@Given("^Enter valid Username and Password click on \"([^\"]*)\" button$")
	public void Enter_valid_Username_and_Password_click_on_button(String arg1) throws Throwable {
	   
		driver.get("http://bmtechsol.com:8080/easytox/");		 
		
		 driver.manage().window().maximize();		 
		 credentials(driver);
		
		}

	@Then("^Lab admin user should be able to login successfully$")
	public void Lab_admin_user_should_be_able_to_login_successfully() throws Throwable {
		
			Thread.sleep(2000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertEquals(currentUrl, curtUrlDriver);	
		   
	}
	
	
	
	@When("^Click on lab User List name$")
	public void Click_on_lab_User_List_name() throws Throwable {
		
		
	 //next page
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='lablist_paginate']/ul/li[3]/a")).click();
		
		// click on lab user list 
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='lablist']/tbody/tr[4]/td[5]/div/div[1]/form/a/i")));
		driver.findElement(By.xpath(".//*[@id='lablist']/tbody/tr[4]/td[5]/div/div[1]/form/a/i")).click();
		
		
		
	}

	@Then("^Lab User  screen should be displayed$")
	public void Lab_User_screen_should_be_displayed() throws Throwable {
	
		Thread.sleep(2000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertNotEquals(currentUrl, curtUrlDriver);
				
	}
		


	@When("^Click \"([^\"]*)\" icon for that existing lab on right corner of the screen$")
	public void Click_icon_for_that_existing_lab_on_right_corner_of_the_screen(String arg1) throws Throwable {
	  
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='locklink']/i")).click();
		
			}

	@Then("^Lab should be locked and \"([^\"]*)\" message should be populated$")
	public void Lab_should_be_locked_and_message_should_be_populated(String arg1) throws Throwable {
	  
		Thread.sleep(2000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertNotEquals(currentUrl, curtUrlDriver);		
		
	}

	@When("^Logout and attempt logging in with the above lab credentials$")
	public void Logout_and_attempt_logging_in_with_the_above_lab_credentials() throws Throwable {
	   
		// click on superadmin
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[2]/div/div/div[3]/div/ul/li[2]/a")).click();
		
			
		//logout click
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[2]/div/div/div[3]/div/ul/li[2]/ul/li/a")).click();
		
		
		//  lockedlogin details
		lockedcredentials(driver);
		
	}

	@Then("^Account locked message should be populated and Lab should not be able to login to application$")
	public void Account_locked_message_should_be_populated_and_Lab_should_not_be_able_to_login_to_application() throws Throwable {
	  
		Thread.sleep(4000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertNotEquals(currentUrl, curtUrlDriver);	    
	    
	 // login details:	    
	    credentials(driver);	
		
		
	}

	@When("^Select a lab which is locked and click \"([^\"]*)\" icon$")
	public void Select_a_lab_which_is_locked_and_click_icon(String arg1) throws Throwable {
	 
		//next page
				Thread.sleep(2000);
				driver.findElement(By.xpath(".//*[@id='lablist_paginate']/ul/li[3]/a")).click();
				
				// click on lab user list 
				WebDriverWait wait = new WebDriverWait(driver,20);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='lablist']/tbody/tr[4]/td[5]/div/div[1]/form/a/i")));
				driver.findElement(By.xpath(".//*[@id='lablist']/tbody/tr[4]/td[5]/div/div[1]/form/a/i")).click();	
		
	}

	@Then("^Lab account should be unlocked and \"([^\"]*)\" message should be populated$")
	public void Lab_account_should_be_unlocked_and_message_should_be_populated(String arg1) throws Throwable {
	
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='unlocklink']/i")).click();
		
		
		
		
	}

	@When("^Logout and attempt logging in with the above lab credentials one$")
	public void Logout_and_attempt_logging_in_with_the_above_lab_credentials_one() throws Throwable {
		
		// click on superadmin
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[2]/div/div/div[3]/div/ul/li[2]/a")).click();
		
		//logout click
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[2]/div/div/div[3]/div/ul/li[2]/ul/li/a")).click();
		
	 // login with lockedcredentials details:
		Thread.sleep(2000);
		lockedcredentials(driver);
		
	}

	@Then("^Lab login should be successful.$")
	public void Lab_login_should_be_successful() throws Throwable {
	   
		Thread.sleep(2000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertNotEquals(currentUrl, curtUrlDriver);
	    
	    driver.quit();
		
		
	}


private static final class Lab {	  		   
  
  private static final String ContactName ="Harisigew";
  private static final String ContactEmail = "conta5024@gmail.com";
private static final String FaxNumber = "9140581129";
private static final String ContactNumber = "8140030495";
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
public static void lockedcredentials(WebDriver driver3) throws InterruptedException
{
	
	
	WebDriverWait wait = new WebDriverWait(driver3,20);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.name(USER_NAME)));
		WebElement user =  driver3.findElement(By.name(USER_NAME));
		user.clear();
		user.sendKeys(PAGE_ID1);
		
		
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(PASSWD)));
		WebElement pwd = driver3.findElement(By.name(PASSWD));
		 pwd.clear();
		 pwd.sendKeys(PAGE_PSWD1);	
		
		 Thread.sleep(1000);
			 
		
		 Thread.sleep(1000);
		 driver3.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div/button")).click();
		
	
}

	
	
	

}
