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


public class Insurancecompanypagenavigation {
	
	
	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "cgilabadmin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="Welcome@123";
	private static final String Insurance_Company_URL ="http://bmtechsol.com:8080/easytox/insuranceCompany/list";
	private static final String Add_Insurance_Company_URL ="http://bmtechsol.com:8080/easytox/insuranceCompany/create";
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public Insurancecompanypagenavigation(){
		
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
	@When("^Navigate back and forth by selecting page numbers \"([^\"]*)\"$")
	public void Navigate_back_and_forth_by_selecting_page_numbers(String arg1) throws Throwable {
	    
		Thread.sleep(2000);
		//next page
		driver.findElement(By.xpath("//*[@id='example_paginate']/ul/li[4]/a")).click();
		Thread.sleep(3000);
		//previous page
		driver.findElement(By.xpath(".//*[@id='example_paginate']/ul/li[1]/a")).click();
	}

	@Then("^User should be navigate to the selected page$")
	public void User_should_be_navigate_to_the_selected_page() throws Throwable {
		Thread.sleep(1000);
		String currentUrl = Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	}

	@When("^Checking the message of no of records displayed on the current page bottom left corner of the screen$")
	public void Checking_the_message_of_no_of_records_displayed_on_the_current_page_bottom_left_corner_of_the_screen() throws Throwable {
		
		Thread.sleep(3000);
		//fullscren
		driver.findElement(By.xpath(".//*[@id='maincontentdiv']/div[6]/div/div/div/div[1]/div/a[1]/i")).click();
		 Thread.sleep(2000);
		String currentUrl = Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	}

	@Then("^A text message Showing x to y of z entries should be displayed on the bottom left corner of the list.$")
	public void A_text_message_Showing_x_to_y_of_z_entries_should_be_displayed_on_the_bottom_left_corner_of_the_list() throws Throwable {

		Thread.sleep(2000);
		String currentUrl = Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	    
	    driver.quit();
	}

	
	
	

}
