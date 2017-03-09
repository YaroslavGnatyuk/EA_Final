package com.easytox.automation.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;

import PlaceofCode.codePlace.Patient;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber2project.DataStorage;

public class ET_PL_004_Verify_Number_records_displayed {

	
	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "cgilabadmin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="Welcome@123";
	private static final String Patient_Profile_URL ="http://bmtechsol.com:8080/easytox/patient/list";
	private static final String Add_Insurance_Company_URL ="http://bmtechsol.com:8080/easytox/insuranceCompany/create";
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public ET_PL_004_Verify_Number_records_displayed(){
		
		DriverBase.instantiateDriverObject();
        this.webElementHelper = new WebElementHelper();
        driver = DriverBase.getDriver();
	}
	
	
	@Given("^the user is on home screen$")
	public void the_user_is_on_home_screen() throws Throwable {
		
		
		
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

	@When("^Click on Library icon and click on the Patient$")
	public void Click_on_Library_icon_and_click_on_the_Patient() throws Throwable {
	   
	
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("html/body/div[2]/div/div/div[3]/div/ul/li[9]/a/img")).click();		
		Thread.sleep(2000);		
		
		driver.findElement(By.xpath("//img[@src='/easytox/static/images/patient-icon.png']")).click();
		Thread.sleep(2000);
		
	}

	@Then("^Patient List  page should be displayed$")
	public void Patient_List_page_should_be_displayed() throws Throwable {
	  
	
		Thread.sleep(2000);
		String currentUrl = Patient_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertEquals(currentUrl, curtUrlDriver);	    
		
		
	}
	
	
	
	@When("^Verify the default number of records displayed$")
	public void Verify_the_default_number_of_records_displayed() throws Throwable {
	   
		
		Thread.sleep(1000);
		String currentUrl = Patient_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertEquals(currentUrl, curtUrlDriver);	
		
	  
	}

	@Then("^Default number \"([^\"]*)\" should be displayed in the dropdown box$")
	public void Default_number_should_be_displayed_in_the_dropdown_box(String arg1) throws Throwable {
	 
		Thread.sleep(2000);
		String currentUrl = Patient_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertEquals(currentUrl, curtUrlDriver);	
		
		
		
	}

	@When("^Click on dropdown that shows no of records to be displayed on the page$")
	public void Click_on_dropdown_that_shows_no_of_records_to_be_displayed_on_the_page() throws Throwable {
	  
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example_length']/label/select")).click();
		
		Thread.sleep(2000);
		
		
		
	}

	@Then("^User should be able to view and select the options from the list and the corresponding number of records should be displayed on the page$")
	public void User_should_be_able_to_view_and_select_the_options_from_the_list_and_the_corresponding_number_of_records_should_be_displayed_on_the_page() throws Throwable {
	    
		
		Thread.sleep(3000);
		new Select(driver.findElement(By.xpath(".//*[@id='example_length']/label/select"))).selectByVisibleText(Patient.box1);
		Thread.sleep(2000);
		driver.quit();	
		
	}


private static final class Patient {
            
        
        private static final String box1= "50";
        
         
        
		}
	
	
	
	
	
	
	
	
	
	
	
}
