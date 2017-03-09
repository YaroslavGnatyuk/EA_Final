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


public class InsuranceCompanyDropdown {
	

	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "cgilabadmin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="Welcome@123";
	private static final String Insurance_Company_URL ="http://bmtechsol.com:8080/easytox/insuranceCompany/list";
	private static final String Add_Insurance_Company_URL ="http://bmtechsol.com:8080/easytox/insuranceCompany/create";
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public InsuranceCompanyDropdown(){
		
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
	@When("^Verify the default number of records displayed$")
	public void Verify_the_default_number_of_records_displayed() throws Throwable {
	  
 	Thread.sleep(2000);
		
	}

	@Then("^Default number \"([^\"]*)\" should be displayed in the dropdown box$")
	public void Default_number_should_be_displayed_in_the_dropdown_box(String arg1) throws Throwable {
	   	
		//selecting defualt value 10
		Thread.sleep(2000);
		new Select(driver.findElement(By.xpath(".//*[@id='example_length']/label/select"))).selectByVisibleText(Insurance.box1);
		
	}

	@When("^Click on dropdown that shows no of records to be displayed on the page$")
	public void Click_on_dropdown_that_shows_no_of_records_to_be_displayed_on_the_page() throws Throwable {
	   
		Thread.sleep(3000);
		//click on drowpdown 
		driver.findElement(By.xpath(".//*[@id='example_length']/label/select")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example_length']/label/select")).click();
		Thread.sleep(2000);
	}

	@Then("^User should be able to view and select the options from the list and the corresponding number of records should be displayed on the page$")
	public void User_should_be_able_to_view_and_select_the_options_from_the_list_and_the_corresponding_number_of_records_should_be_displayed_on_the_page() throws Throwable {
	  
		
		//dropdown click default value
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example_length']/label/select")).click();
		Thread.sleep(2000);
		new Select(driver.findElement(By.xpath(".//*[@id='example_length']/label/select"))).selectByVisibleText(Insurance.box2);
		Thread.sleep(2000);
		driver.quit();
	}



	private static final class Insurance {
            
        
        private static final String box1= "10";
        private static final String box2 = "25";
         
         
        
		}

	
	

	
	
	

}
