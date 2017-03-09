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


public class TestingProfileViewDataSorting {

	
	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "cgilabadmin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="Welcome@123";
	private static final String Testing_Profile_URL ="http://bmtechsol.com:8080/easytox/profile/list";
	private static final String Add_Insurance_Company_URL ="http://bmtechsol.com:8080/easytox/insuranceCompany/create";
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
public TestingProfileViewDataSorting(){
		
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
	@When("^Click on \"([^\"]*)\" down arrowicon  on Profile Name  column$")
	public void Click_on_down_arrowicon_on_Profile_Name_column(String arg1) throws Throwable {
	  
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[1]")).click();
		
	}

	@Then("^Records should be displayed based on the asecending order of the Profile Name$")
	public void Records_should_be_displayed_based_on_the_asecending_order_of_the_Profile_Name() throws Throwable {
	  
		Thread.sleep(2000);
		String currentUrl = Testing_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
		
		
	}

	@When("^Click on \"([^\"]*)\" Up arrow icon on Profile Name column$")
	public void Click_on_Up_arrow_icon_on_Profile_Name_column(String arg1) throws Throwable {
	  
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[1]")).click();
		
	}

	@Then("^Records should be displayed based on the descending order of the selected field$")
	public void Records_should_be_displayed_based_on_the_descending_order_of_the_selected_field() throws Throwable {
	
		
		Thread.sleep(2000);
		String currentUrl = Testing_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
		driver.quit();
	}

	
		
			
	
	
	
	
	
	
}
