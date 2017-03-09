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

public class Page_Num_records_Drop_Down {

	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "lavanya1";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="P@ssw0rd123";
	private static final String COMPOUND_LIST_URL ="http://bmtechsol.com:8080/easytox/compound/list";
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	public Page_Num_records_Drop_Down(){
		
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

	@When("^clicked on dropdown that shows no of records to be displayed on the page$")
	public void clicked_on_dropdown_that_shows_no_of_records_to_be_displayed_on_the_page() throws Throwable {
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(".//*[@id='example_length']/label/select")).click();
	}

	@Then("^user should be able to view and select the options from the list and the corresponding number of records should be displayed on the page.$")
	public void user_should_be_able_to_view_and_select_the_options_from_the_list_and_the_corresponding_number_of_records_should_be_displayed_on_the_page() throws Throwable {
	
		Thread.sleep(3000);	
		String currentUrl = COMPOUND_LIST_URL;
	      String curtUrlDriver = driver.getCurrentUrl();

	     Assert.assertEquals(currentUrl, curtUrlDriver);
		
	     new Select(driver.findElement(By.xpath(".//*[@id='example_length']/label/select"))).selectByVisibleText(Dropdown.LIST);
	     Thread.sleep(4000);
	     
		driver.quit();
		
		
		
		
	}


	private static final class Dropdown {
        private static final String LIST = "25";
        
	}
	
	
	
	
	
	
}
