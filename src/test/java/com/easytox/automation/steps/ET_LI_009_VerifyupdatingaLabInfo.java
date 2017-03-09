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


public class ET_LI_009_VerifyupdatingaLabInfo {

	
	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "superadmin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="admin";
	private static final String Lab_Profile_URL ="http://bmtechsol.com:8080/easytox/lab/list";
	
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public ET_LI_009_VerifyupdatingaLabInfo(){
		
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
	
	@When("^Click on Lab record under Lab Name$")
	public void Click_on_Lab_record_under_Lab_Name() throws Throwable {
	
		
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

	@When("^Make changes as needed and click update.$")
	public void Make_changes_as_needed_and_click_update() throws Throwable {
	  
		Thread.sleep(2000);
		WebElement address_code = driver.findElement(By.xpath(".//*[@id='form']/fieldset[1]/div[4]/div[1]/input"));
		address_code.clear();
		address_code.sendKeys(Lab.address);
		
		
		Thread.sleep(2000);
		WebElement address_code1 = driver.findElement(By.xpath(".//*[@id='form']/fieldset[1]/div[4]/div[2]/input"));
		address_code1.clear();
		address_code1.sendKeys(Lab.address);
		

		
		
		//update button
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='form']/div/div/button")).click();	
		
		
	}

	@Then("^Lab info is updated successfully.$")
	public void Lab_info_is_updated_successfully() throws Throwable {
	   
		Thread.sleep(4000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
			
	driver.quit();	
	}

	
	private static final class Lab {
            
        
        private static final String address= "adasiasdjf158";
}


	
	
	
	
	
	
	
	
}
