package com.easytox.automation.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;

public class Search_Box {

	///copy from here
	// Scenario: Search Box
	private static final String SEARCH_BOX = "Test45";
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "lavanya1";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="P@ssw0rd123";
	private static final String COMPOUND_LIST_URL ="http://bmtechsol.com:8080/easytox/compound/list";
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	public Search_Box(){
		
		DriverBase.instantiateDriverObject();
        this.webElementHelper = new WebElementHelper();
        driver = DriverBase.getDriver();

	}
	
		@Given("^the user is Compound Library page$")
		public void the_user_is_Compound_Library_page() throws Throwable {
		    
			driver.get("http://bmtechsol.com:8080/easytox/");		 
			
			 driver.manage().window().maximize();		 
			WebElement user =  driver.findElement(By.name(USER_NAME));
			user.clear();
			user.sendKeys(PAGE_ID);
			
			WebElement pwd = driver.findElement(By.name(PASSWD));
			 pwd.clear();
			 pwd.sendKeys(PAGE_PSWD);		 
			 driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div/button")).click();		
			 Thread.sleep(2000);
			driver.navigate().to(COMPOUND_LIST_URL);
			
		}

		@When("^entered some text in the Search box$")
		public void entered_some_text_in_the_Search_box() throws Throwable {
			
			Thread.sleep(2000);
			WebElement TEXT = driver.findElement(By.xpath("//input[@class='form-control input-sm']"));
			 TEXT.clear();
			 TEXT.sendKeys(Searchbox.TEXT_BOX);
			 Thread.sleep(2000);
			
		   
		}

		@Then("^user should be able to view the search results$")
		public void user_should_be_able_to_view_the_search_results() throws Throwable {
		    
			
			String currentUrl = "http://bmtechsol.com:8080/easytox/compound/list";
	        String curtUrlDriver = driver.getCurrentUrl();

	        Assert.assertEquals(currentUrl, curtUrlDriver);
			Thread.sleep(2000);	
			
		}

		private static final class Searchbox {
			
			
			private static final String  TEXT_BOX = "45";
			
			
			
			
			
		}
	
	
	
	
	
	
	
	
	
	
	
}
