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


public class ET_LSD_004_Verify_Edit_Subscription_Details {
	
	
	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "superadmin";
	private static final String PAGE_ID1 = "admin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="admin";
	private static final String PAGE_PSWD1 ="admin";
	private static final String Lab_Profile_URL ="http://bmtechsol.com:8080/easytox/lab/list";
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	

	
	public ET_LSD_004_Verify_Edit_Subscription_Details(){
		
		DriverBase.instantiateDriverObject();
        this.webElementHelper = new WebElementHelper();
        driver = DriverBase.getDriver();
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
	




	@Given("^Enter valid Username and Password click on \"([^\"]*)\" button$")
	public void Enter_valid_Username_and_Password_click_on_button(String arg1) throws Throwable {
	   
		driver.get("http://bmtechsol.com:8080/easytox/");
		 driver.manage().window().maximize();		 
		 credentials(driver);
		
		}

	@Then("^Lab admin user should be able to login successfully$")
	public void Lab_admin_user_should_be_able_to_login_successfully() throws Throwable {
		

		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertEquals(currentUrl, curtUrlDriver);	
		   
	}

	@When("^Click on lab name$")
	public void Click_on_lab_name() throws Throwable {
	
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='editlink']")).click();
	}

@Then("^\"([^\"]*)\" screen should be displayed$")
public void screen_should_be_displayed(String arg1) throws Throwable {
   
	Thread.sleep(2000);
	String currentUrl = Lab_Profile_URL;
    String curtUrlDriver = driver.getCurrentUrl();	
    Assert.assertNotEquals(currentUrl, curtUrlDriver);	
	
	
	
}

@When("^Click on Subscription Details icon on top right corner of the screen$")
public void Click_on_Subscription_Details_icon_on_top_right_corner_of_the_screen() throws Throwable {
 
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='subscription']/i")));
	driver.findElement(By.xpath(".//*[@id='subscription']/i")).click();
	
	
}

@Then("^Subscription details window should be populated$")
public void Subscription_details_window_should_be_populated() throws Throwable {
	
	String currentUrl = Lab_Profile_URL;
    String curtUrlDriver = driver.getCurrentUrl();	
    Assert.assertNotEquals(currentUrl, curtUrlDriver);	
    
}

@When("^Edit the Subscription Details field values and Waive off field values and click Update$")
public void Edit_the_Subscription_Details_field_values_and_Waive_off_field_values_and_click_Update() throws Throwable {
   
	Thread.sleep(2000);	
	WebElement user = driver.findElement(By.xpath(".//*[@id='noOfUsers']"));
	user.clear();
	user.sendKeys(Lab.user);		 
	
	Thread.sleep(2000);
	WebElement date = driver.findElement(By.xpath(".//*[@id='trialUpto']"));
	date.clear();
	date.sendKeys(Lab.date);
	
	
	Thread.sleep(4000);
	driver.findElement(By.xpath(".//*[@id='subscriptionform']/div/div[2]/fieldset/div[1]/div/div/div/label/span")).click();
	driver.findElement(By.xpath(".//*[@id='subscriptionform']/div/div[2]/fieldset/div[2]/div/div/div/label/span")).click();
	driver.findElement(By.xpath(".//*[@id='subscriptionform']/div/div[2]/fieldset/div[3]/div/div/div/label/span")).click();
	driver.findElement(By.xpath(".//*[@id='updateSubscription']")).click();
	Thread.sleep(3000);
}

@Then("^All the field values should be editable and updaed successfullly$")
public void All_the_field_values_should_be_editable_and_updaed_successfullly() throws Throwable {
   
	Thread.sleep(3000);
	String currentUrl = Lab_Profile_URL;
    String curtUrlDriver = driver.getCurrentUrl();	
    Assert.assertNotEquals(currentUrl, curtUrlDriver);
    
    
    driver.quit();
	
	
	
}

private static final class Lab {
    
	private static final String user = "25";
    private static final String date= "01/11/2017";
     
	} 


	
	
	

}
