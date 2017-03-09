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


public class ET_PL_006_Verify_Patient_Information {

	
	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "cgilabadmin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="Welcome@123";
	private static final String Patient_Profile_URL ="http://bmtechsol.com:8080/easytox/patient/list";
	private static final String Add_Insurance_Company_URL ="http://bmtechsol.com:8080/easytox/insuranceCompany/create";
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public ET_PL_006_Verify_Patient_Information(){
		
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
	
	
	@When("^Click on \"([^\"]*)\" icon beside the Patient record in the patient results list$")
	public void Click_on_icon_beside_the_Patient_record_in_the_patient_results_list(String arg1) throws Throwable {
	   
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(".//*[@id='example']/tbody/tr[1]/td[1]")).click();
	}

	@Then("^Selected patient detailed information should be displayed in a popup window$")
	public void Selected_patient_detailed_information_should_be_displayed_in_a_popup_window() throws Throwable {
	
		
		
		Thread.sleep(4000);
		String currentUrl = Patient_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	    
	    driver.quit();
		
	}



	
	
	
	
	
	
	
}
