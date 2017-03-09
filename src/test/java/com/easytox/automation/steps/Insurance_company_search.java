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


public class Insurance_company_search {
	
	
	private static final String Search_Box = "Test45";
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "cgilabadmin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="Welcome@123";
	private static final String Insurance_Company_URL ="http://bmtechsol.com:8080/easytox/insuranceCompany/list";
	private static final String Add_Insurance_Company_URL ="http://bmtechsol.com:8080/easytox/insuranceCompany/create";
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public Insurance_company_search(){
		
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

	@When("^Select settings and choose Insurance Company$")
	public void Select_settings_and_choose_Insurance_Company() throws Throwable {

		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[2]/div/div/div[3]/div/ul/li[8]/a/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='topmenu']/li[6]/a")).click();
		
		
		
	}

	@Then("^Insurance Company List screen is displayed$")
	public void Insurance_Company_List_screen_is_displayed() throws Throwable {

		
		Thread.sleep(1000);
		String currentUrl = Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	
		
		
	}
	@When("^Enter any search criteria Search and click on search icon$")
	public void Enter_any_search_criteria_Search_and_click_on_search_icon() throws Throwable {
		
		Thread.sleep(2000);
		WebElement search1 = driver.findElement(By.xpath(".//*[@id='example_filter']/label/input"));		
		search1.clear();
		search1.sendKeys(Insurance.box1.trim());
		Thread.sleep(2000);
		
		
		
		Thread.sleep(2000);
		WebElement search2 = driver.findElement(By.xpath(".//*[@id='example_filter']/label/input"));		
		search2.clear();
		search2.sendKeys(Insurance.Company_Name.trim());
		Thread.sleep(3000);
		
		
		Thread.sleep(2000);
		WebElement search3 = driver.findElement(By.xpath(".//*[@id='example_filter']/label/input"));		
		search3.clear();
		search3.sendKeys(Insurance.Fax.trim());
		Thread.sleep(2000);
		
		
		
		
		Thread.sleep(2000);
		WebElement search6 = driver.findElement(By.xpath(".//*[@id='example_filter']/label/input"));		
		search6.clear();
		search6.sendKeys(Insurance.website.trim());
		Thread.sleep(2000);
		
		
		
		
		
		
		Thread.sleep(2000);
		WebElement search4 = driver.findElement(By.xpath(".//*[@id='example_filter']/label/input"));		
		search4.clear();
		search4.sendKeys(Insurance.mail.trim());
		Thread.sleep(2000);
		
	}

	@Then("^Matching records with entered data should be displayed in the Insurance Company List$")
	public void Matching_records_with_entered_data_should_be_displayed_in_the_Insurance_Company_List() throws Throwable {
	 
		
		
		Thread.sleep(2000);
		String currentUrl = Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	    
	    
	    driver.quit();
	}




	private static final class Insurance {
            
        
        private static final String box1= "Varma";
        private static final String Company_Name = "Easx";
         private static final String Fax ="(874) 562-9639";
         
         private static final String mail = "Street@gmail.com"; 
         private static final String website = "http://www.easy.com";
         
        
		}

	
	

	
	

}
