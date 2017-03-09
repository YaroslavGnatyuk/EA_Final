package com.easytox.automation.steps;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Choose_file {


	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "lavanya1";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="P@ssw0rd123";
	private static final String COMPOUND_LIST_URL ="http://bmtechsol.com:8080/easytox/compound/list";
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	public Choose_file(){
		
		DriverBase.instantiateDriverObject();
        this.webElementHelper = new WebElementHelper();
        driver = DriverBase.getDriver();

	}
    
///  Scenario: Choose File
@Given("^the user is on Compound Library page$")
public void the_user_is_on_Compound_Library_page() throws Throwable 
{		 driver.get(COMPOUND_LIST_URL);		 

	driver.manage().window().maximize();		 
	WebElement user =  driver.findElement(By.name(USER_NAME));
	user.clear();
	user.sendKeys(PAGE_ID);

	WebElement pwd = driver.findElement(By.name(PASSWD));
	pwd.clear();
	pwd.sendKeys(PAGE_PSWD);		 
	driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div/button")).click();		
	Thread.sleep(4000);
	driver.navigate().to(COMPOUND_LIST_URL);
   
}

	@When("^the user clicked on Choose file$")
	public void the_user_clicked_on_Choose_file() throws Throwable 
	{		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='form']/div/input")).click();
				
	    	}
	
	@Then("^upload popup to select the files should be displayed$")
	public void upload_popup_to_select_the_files_should_be_displayed() throws Throwable 
	{
		
		Thread.sleep(1000);
		String currentUrl = COMPOUND_LIST_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
		Thread.sleep(2000);	
		
			
	}
	
	@Given("^the user is Compound Library page$")
	public void the_user_is_Compound_Library_page() throws Throwable 
	{
		Thread.sleep(2000);
		String currentUrl = COMPOUND_LIST_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
		Thread.sleep(2000);	
		
		
	}
	
	
	@When("^the user selected the required file to upload$")
	public void the_user_selected_the_required_file_to_upload() throws Throwable 
	{
		Thread.sleep(3000);
		
		StringSelection filename = new StringSelection("F:\\tuesday.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filename,null);
		
		Robot rt = new Robot();
		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyRelease(KeyEvent.VK_ENTER);
		
		rt.keyPress(KeyEvent.VK_CONTROL);
		//rt.keyRelease(KeyEvent.VK_V);
		
		rt.keyPress(KeyEvent.VK_V);
		rt.keyRelease(KeyEvent.VK_V);
		
		rt.keyRelease(KeyEvent.VK_CONTROL);
		//rt.keyRelease(KeyEvent.VK_ENTER);
		
		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(1000);
		
		
	}
	
	@Then("^the selected file name should be displayed next to the Choose file$")
	public void the_selected_file_name_should_be_displayed_next_to_the_Choose_file() throws Throwable
	{
		//Thread.sleep(1000);
		String currentUrl = COMPOUND_LIST_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
		Thread.sleep(2000);	
		
		
		
	}
	
	@When("^the user selected the required file to upload and click on upload$")
	public void the_user_selected_the_required_file_to_upload_and_click_on_upload() throws Throwable 
	{
	    
		
		driver.findElement(By.xpath("//*[@id='form']/input")).click();
		Thread.sleep(2000);
	}
	
	@Then("^the selected file should be uploaded and data should be loaded    under compounds table$")
	public void the_selected_file_should_be_uploaded_and_data_should_be_loaded_under_compounds_table() throws Throwable 
	{
		Thread.sleep(1000);
		String currentUrl = COMPOUND_LIST_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
		Thread.sleep(2000);	
			
			driver.quit();
		
		
	    
	}
	
		
}
