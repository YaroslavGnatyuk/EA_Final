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


public class ET_UL_007_Verify_Updating_or_hiding_Contact_Details {

	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "superadmin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="admin";
	private static final String Lab_Profile_URL ="http://bmtechsol.com:8080/easytox/lab/list";
	
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public ET_UL_007_Verify_Updating_or_hiding_Contact_Details(){
		
		DriverBase.instantiateDriverObject();
        this.webElementHelper = new WebElementHelper();
        driver = DriverBase.getDriver();
	}
	

	@Given("^Enter valid Username and Password click on \"([^\"]*)\" button$")
	public void Enter_valid_Username_and_Password_click_on_button(String arg1) throws Throwable {
	   
		driver.get("http://bmtechsol.com:8080/easytox/");		 
		
		 driver.manage().window().maximize();		 
		WebElement user =  driver.findElement(By.name(USER_NAME));
		user.clear();
		user.sendKeys(PAGE_ID);
		
		WebElement pwd = driver.findElement(By.name(PASSWD));
		 pwd.clear();
		 pwd.sendKeys(PAGE_PSWD);		 
		 driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div/button")).click();
		
		
		
	}

	@Then("^Lab admin user should be able to login successfully$")
	public void Lab_admin_user_should_be_able_to_login_successfully() throws Throwable {
		
			Thread.sleep(2000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertEquals(currentUrl, curtUrlDriver);	
		
		
	    
	}

	@When("^Click on lab name$")
	public void Click_on_lab_name() throws Throwable {
	
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='editlink']")).click();
		
		
	}

	@Then("^\"([^\"]*)\" screen should be displayed$")
	public void screen_should_be_displayed(String arg1) throws Throwable {
	  
		Thread.sleep(1000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertNotEquals(currentUrl, curtUrlDriver);	
	    
	  	
	}
	@When("^Click on \"([^\"]*)\" icon besides the Cantact Details$")
	public void Click_on_icon_besides_the_Cantact_Details(String arg1) throws Throwable {
	   
		
		
		Thread.sleep(2000);
		WebElement ContactName = driver.findElement(By.xpath(".//*[@id='form']/fieldset[2]/div[1]/div[1]/div[1]/input"));
		ContactName.clear();
		ContactName.sendKeys(Lab.ContactName);
		
		
		
		
		Thread.sleep(2000);
		WebElement ContactEmail = driver.findElement(By.xpath(".//*[@id='form']/fieldset[2]/div[1]/div[1]/div[2]/input"));
		ContactEmail.clear();
		ContactEmail.sendKeys(Lab.ContactEmail);
		
		
		
		Thread.sleep(2000);
		WebElement FaxNumber = driver.findElement(By.xpath(".//*[@id='form']/fieldset[2]/div[1]/div[2]/div[1]/input"));
		FaxNumber.clear();
		FaxNumber.sendKeys(Lab.FaxNumber);
		
		
		Thread.sleep(2000);
		WebElement ContactNumber = driver.findElement(By.xpath(".//*[@id='form']/fieldset[2]/div[1]/div[2]/div[2]/input"));
		ContactNumber.clear();
		ContactNumber.sendKeys(Lab.ContactNumber);
		
		//on form
				driver.findElement(By.xpath(".//*[@id='maincontentdiv']/div[8]/div/div[1]/div/div[2]")).click();
		
		//update button
		
		driver.findElement(By.xpath(".//*[@id='form']/div/div/button")).click();
		
		
			
		
		
		
	}

	@Then("^Contact Details fields should be updated successfully and   user can change the the values or hide the fields by clicking on \"([^\"]*)\" icon$")
	public void Contact_Details_fields_should_be_updated_successfully_and_user_can_change_the_the_values_or_hide_the_fields_by_clicking_on_icon(String arg1) throws Throwable {
	    
		
		Thread.sleep(1000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	    
	    
	    Thread.sleep(3000);
		driver.quit();
	}



private static final class Lab {	  		   
  
  private static final String ContactName ="Harisigew";
  private static final String ContactEmail = "conta5024@gmail.com";
private static final String FaxNumber = "9140581129";
private static final String ContactNumber = "8140030495";
	} 

	
	
	
	
	
	
	
	
	
	
}
