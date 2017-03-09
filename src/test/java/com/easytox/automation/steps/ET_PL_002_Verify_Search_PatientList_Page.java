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


public class ET_PL_002_Verify_Search_PatientList_Page {

	
	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "cgilabadmin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="Welcome@123";
	private static final String Patient_Profile_URL ="http://bmtechsol.com:8080/easytox/patient/list";
	private static final String Add_Insurance_Company_URL ="http://bmtechsol.com:8080/easytox/insuranceCompany/create";
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public ET_PL_002_Verify_Search_PatientList_Page(){
		
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
	@When("^Enter any search criteria and click on search icon$")
	public void Enter_any_search_criteria_and_click_on_search_icon() throws Throwable {
	   
		
		Thread.sleep(2000);
		WebElement search1 = driver.findElement(By.xpath(".//*[@id='example_filter']/label/input"));		
		search1.clear();
		search1.sendKeys(Patient.Name.trim());
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		WebElement search2 = driver.findElement(By.xpath(".//*[@id='example_filter']/label/input"));		
		search2.clear();
		search2.sendKeys(Patient.Address.trim());
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		WebElement search3 = driver.findElement(By.xpath(".//*[@id='example_filter']/label/input"));		
		search3.clear();
		search3.sendKeys(Patient.DOB.trim());
		Thread.sleep(2000);
	
		
		Thread.sleep(2000);
		WebElement search4 = driver.findElement(By.xpath(".//*[@id='example_filter']/label/input"));		
		search4.clear();
		search4.sendKeys(Patient.Gender.trim());
		Thread.sleep(2000);
		

		Thread.sleep(2000);
		WebElement search5 = driver.findElement(By.xpath(".//*[@id='example_filter']/label/input"));		
		search5.clear();
		search5.sendKeys(Patient.HomePhone.trim());
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		WebElement search6 = driver.findElement(By.xpath(".//*[@id='example_filter']/label/input"));		
		search6.clear();
		search6.sendKeys(Patient.email.trim());
		Thread.sleep(2000);
	
		
		Thread.sleep(2000);
		WebElement search7 = driver.findElement(By.xpath(".//*[@id='example_filter']/label/input"));		
		search7.clear();
		search7.sendKeys(Patient.medicalrecord.trim());
		Thread.sleep(2000);
		
		search7.clear();
	}

	@Then("^Matching records with entered data should be displayed in the patient list$")
	public void Matching_records_with_entered_data_should_be_displayed_in_the_patient_list() throws Throwable {
	   
		Thread.sleep(3000);
		String currentUrl = Patient_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertEquals(currentUrl, curtUrlDriver);	    
		driver.quit();
	}



private static final class Patient {
            
        
        private static final String Name= "	qa test";
        private static final String Address = "4000 exec sanramon calfornia 94583";
         private static final String HomePhone ="(123) 456-7890";
         private static final String DOB = "06/Jan/2009";
         private static final String Gender = "Female";
         
         private static final String email = "nagendra.nelluri@gmail.com"; 
         private static final String medicalrecord = "1654";
         
        
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
