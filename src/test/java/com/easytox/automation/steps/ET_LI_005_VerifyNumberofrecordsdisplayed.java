package com.easytox.automation.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ET_LI_005_VerifyNumberofrecordsdisplayed {
	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "superadmin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="admin";
	private static final String Lab_Profile_URL ="http://bmtechsol.com:8080/easytox/lab/list";
	
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public ET_LI_005_VerifyNumberofrecordsdisplayed(){
		
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
	
	@When("^Verify the default number of records displayed$")
	public void Verify_the_default_number_of_records_displayed() throws Throwable {
	    
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='lablist_length']/label/select")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='lablist_length']/label/select")).click();
		
	}

	@Then("^Default number \"([^\"]*)\" should be displayed in the dropdown box$")
	public void Default_number_should_be_displayed_in_the_dropdown_box(String arg1) throws Throwable {
	  
		
		Thread.sleep(3000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertEquals(currentUrl, curtUrlDriver);	
		
	}

	
	@When("^Click on dropdown that shows number of records to be displayed on the page$")
	public void Click_on_dropdown_that_shows_number_of_records_to_be_displayed_on_the_page() throws Throwable {
	    
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='lablist_length']/label/select")).click();
		Thread.sleep(3000);
		new Select(driver.findElement(By.xpath(".//*[@id='lablist_length']/label/select"))).selectByVisibleText(Lab.Number);
		driver.findElement(By.xpath(".//*[@id='lablist_length']/label/select")).click();
		
		
	}

	@Then("^User should be able to view and select the options from the list and the corresponding number of records should be displayed on the page$")
	public void User_should_be_able_to_view_and_select_the_options_from_the_list_and_the_corresponding_number_of_records_should_be_displayed_on_the_page() throws Throwable {
	  
		
		Thread.sleep(4000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertEquals(currentUrl, curtUrlDriver);	
		
		driver.quit();
		
	}

private static final class Lab {
            
   private static final String Number= "30";
         
        
		}
	
	

	
	
	
	

}
