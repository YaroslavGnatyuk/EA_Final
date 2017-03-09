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


public class TestingProfileEditWindow {

	

	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "cgilabadmin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="Welcome@123";
	private static final String Testing_Profile_URL ="http://bmtechsol.com:8080/easytox/profile/list";
	private static final String Add_Insurance_Company_URL ="http://bmtechsol.com:8080/easytox/insuranceCompany/create";
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
public TestingProfileEditWindow(){
		
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

	@When("^Click on Library Icon and Select the Testing Profile$")
	public void Click_on_Library_Icon_and_Select_the_Testing_Profile() throws Throwable {
	   
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("html/body/div[2]/div/div/div[3]/div/ul/li[9]/a/img")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//img[@src='/easytox/static/images/profile.gif']")).click();
		
	//Thread.sleep(3000);
		
		
	}

	@Then("^Testing Profile page should be open$")
	public void Testing_Profile_page_should_be_open() throws Throwable {
	  
		
		Thread.sleep(2000);
		String currentUrl = Testing_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	   
	
	    
		
		
	}
	

	@When("^Click on Edit icon under Action column$")
	public void Click_on_Edit_icon_under_Action_column() throws Throwable {
	   
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='editbutton']/i")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(".//*[@id='form1']/div[2]/button[1]")).click();
		
	}

	@Then("^\"([^\"]*)\" window should be displayed$")
	public void window_should_be_displayed(String arg1) throws Throwable {
	
		
		Thread.sleep(2000);
		String currentUrl = Testing_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertNotEquals(currentUrl, curtUrlDriver);
		
		
		driver.quit();
		
	}


	
	
	
	
	
}
