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


public class ET_LI_006_Verifythedatasorting {

	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "superadmin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="admin";
	private static final String Lab_Profile_URL ="http://bmtechsol.com:8080/easytox/lab/list";
	
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public ET_LI_006_Verifythedatasorting(){
		
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
	
	@When("^Click on \"([^\"]*)\" down arrow icon on any column$")
	public void Click_on_down_arrow_icon_on_any_column(String arg1) throws Throwable {
	     
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='lablist']/thead/tr/th[2]")).click();
		
		
	}

	@Then("^Records should be displayed based on the asecending order of the selected field$")
	public void Records_should_be_displayed_based_on_the_asecending_order_of_the_selected_field() throws Throwable {
	  
		Thread.sleep(2000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
		
	}

	@When("^Click on \"([^\"]*)\"Up arrow icon on any column$")
	public void Click_on_Up_arrow_icon_on_any_column(String arg1) throws Throwable {
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='lablist']/thead/tr/th[2]")).click();
		
		
	}

	@Then("^Records should be displayed based on the descending order of the selected field$")
	public void Records_should_be_displayed_based_on_the_descending_order_of_the_selected_field() throws Throwable {
	
		Thread.sleep(2000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	    
	    
	    driver.quit();
		
	}


	
	
	
	
	
	
}
