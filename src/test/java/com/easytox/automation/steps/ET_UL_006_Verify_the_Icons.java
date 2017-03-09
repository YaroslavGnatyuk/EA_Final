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


public class ET_UL_006_Verify_the_Icons {
	
	
	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "superadmin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="admin";
	private static final String Lab_Profile_URL ="http://bmtechsol.com:8080/easytox/lab/list";
	
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public ET_UL_006_Verify_the_Icons (){
		
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

	@When("^Click on lab name$")
	public void Click_on_lab_name() throws Throwable {
	
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='editlink']")).click();
		
		
	}

	@Then("^\"([^\"]*)\" screen should be displayed$")
	public void screen_should_be_displayed(String arg1) throws Throwable {
	  
		Thread.sleep(1000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertNotEquals(currentUrl, curtUrlDriver);	
	    
	  	
	}
	@When("^Click on\"([^\"]*)\" icon on the right corner of the Update lab screen$")
	public void Click_on_icon_on_the_right_corner_of_the_Update_lab_screen(String arg1) throws Throwable {
	    
		
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='maincontentdiv']/div[8]/div/div[1]/div/div[1]/div/div[1]/form/a/i")).click();
		
	}

	@Then("^That Particular Lab is Locked message should be populated$")
	public void That_Particular_Lab_is_Locked_message_should_be_populated() throws Throwable {
	    
		Thread.sleep(2000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	    
	    //click on lab name
	    
	    Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='editlink']")).click();
	
		
	}

	@When("^Click on\"([^\"]*)\" icon on the right corner of the Update lab screen one$")
	public void Click_on_icon_on_the_right_corner_of_the_Update_lab_screen_one(String arg1) throws Throwable {
	    
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='userlist']/i")).click();
	
	
		
	}

	@Then("^\"([^\"]*)\" screen should be dispalyed$")
	public void screen_should_be_dispalyed(String arg1) throws Throwable {
	   
		Thread.sleep(2000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertNotEquals(currentUrl, curtUrlDriver);
	    
	    
	///move to lablist page
		
		driver.get("http://bmtechsol.com:8080/easytox/lab/list");
		 Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='editlink']")).click();
		
	}

	@When("^Click on\"([^\"]*)\" icon on the right corner of the Update lab screen two$")
	public void Click_on_icon_on_the_right_corner_of_the_Update_lab_screen_two(String arg1) throws Throwable {
	    
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='subscription']/i")).click();
		
		
		
		
	}

	@Then("^\"([^\"]*)\" windoe should be populated$")
	public void windoe_should_be_populated(String arg1) throws Throwable {
	 
		Thread.sleep(2000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertNotEquals(currentUrl, curtUrlDriver);
	    
	    
	    
	///move to lablist page
		
		driver.get("http://bmtechsol.com:8080/easytox/lab/list");
		 Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='editlink']")).click();
		
	}

	@When("^Click on\"([^\"]*)\" icon on the right corner of the Update lab screen three$")
	public void Click_on_icon_on_the_right_corner_of_the_Update_lab_screen_three(String arg1) throws Throwable {
	   
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='maincontentdiv']/div[8]/div/div[1]/div/div[1]/div/div[4]/form/a/i")).click();
		
		
	}

	@Then("^\"([^\"]*)\" screen should be dispalyed one$")
	public void screen_should_be_dispalyed_one(String arg1) throws Throwable {
	   
		Thread.sleep(3000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertNotEquals(currentUrl, curtUrlDriver);
	    
	    
	    Thread.sleep(2000);
	    driver.quit();

		
		
	}


	
	
	
	
	
	
	
	
	
	

}
