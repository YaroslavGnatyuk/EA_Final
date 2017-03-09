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


public class ET_LI_003_VerifytheSearchResults {
	
	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "superadmin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="admin";
	private static final String Lab_Profile_URL ="http://bmtechsol.com:8080/easytox/lab/list";
	
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public ET_LI_003_VerifytheSearchResults(){
		
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

	@When("^Enter any search criteria and click on search icon$")
	public void Enter_any_search_criteria_and_click_on_search_icon() throws Throwable {
	   
		
		
		
		Thread.sleep(2000);
		WebElement search1 = driver.findElement(By.xpath(".//*[@id='lablist_filter']/label/input"));		
		search1.clear();
		search1.sendKeys(Lab.Name.trim());
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		WebElement search2 = driver.findElement(By.xpath(".//*[@id='lablist_filter']/label/input"));		
		search2.clear();
		search2.sendKeys(Lab.Description.trim());
		Thread.sleep(2000);
		
		
		Thread.sleep(2000);
		WebElement search3 = driver.findElement(By.xpath(".//*[@id='lablist_filter']/label/input"));		
		search3.clear();
		search3.sendKeys(Lab.Address.trim());
		Thread.sleep(2000);
		
		
		
	}

	@Then("^Matching records with entered data should be displayed in the Lab list$")
	public void Matching_records_with_entered_data_should_be_displayed_in_the_Lab_list() throws Throwable {
		
		Thread.sleep(2000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertEquals(currentUrl, curtUrlDriver);	
		
	    
	    driver.quit();
	    
	}

private static final class Lab {
            
        
        private static final String Name= "LabTest";
        private static final String Description = "lab1 desc";
         private static final String Address ="add1, add2, city, state, 12311";
    
         
        
		}
	
	
	
	
	

}
