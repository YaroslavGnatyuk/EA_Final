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


public class ET_LI_0010_Verifythepagination {

	
	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "superadmin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="admin";
	private static final String Lab_Profile_URL ="http://bmtechsol.com:8080/easytox/lab/list";
	
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public ET_LI_0010_Verifythepagination (){
		
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
	@When("^Navigate back and forth by selecting page numbers \"([^\"]*)\"$")
	public void Navigate_back_and_forth_by_selecting_page_numbers(String arg1) throws Throwable {
	 
		
		Thread.sleep(2000);
		 driver.findElement(By.xpath(".//*[@id='lablist_paginate']/ul/li[7]/a")).click();
		 
		 
		 Thread.sleep(4000);
		 driver.findElement(By.xpath(".//*[@id='lablist_paginate']/ul/li[1]/a")).click(); 
	}

	@Then("^User should be navigate to the selected page$")
	public void User_should_be_navigate_to_the_selected_page() throws Throwable {
	
		Thread.sleep(2000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertEquals(currentUrl, curtUrlDriver);	
		
	}

	@When("^searches the results$")
	public void searches_the_results() throws Throwable {
	   
		 Thread.sleep(4000);
		 driver.findElement(By.xpath(".//*[@id='lablist_filter']/label/input")).sendKeys("One");
		
		
	}

	@Then("^A text message ?Showing x to y of z entries? should be displayed on the bottom left corner of the list.$")
	public void A_text_message_Showing_x_to_y_of_z_entries_should_be_displayed_on_the_bottom_left_corner_of_the_list() throws Throwable {
	    
		
		Thread.sleep(2000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	    
	    
	    driver.quit();
		
	}


	
	
	
	
	
}
