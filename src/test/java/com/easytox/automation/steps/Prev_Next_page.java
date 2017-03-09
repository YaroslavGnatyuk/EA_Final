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

public class Prev_Next_page {

	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "lavanya1";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="P@ssw0rd123";
	private static final String COMPOUND_LIST_URL ="http://bmtechsol.com:8080/easytox/compound/list";
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	public Prev_Next_page(){
		
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
	@When("^clicked on next button$")
	public void clicked_on_next_button() throws Throwable {
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(".//*[@id='example_paginate']/ul/li[3]/a")).click();
	}

	@Then("^the user should be able to navigate to the next page$")
	public void the_user_should_be_able_to_navigate_to_the_next_page() throws Throwable {
	Thread.sleep(2000);
	String currentUrl = COMPOUND_LIST_URL;
    String curtUrlDriver = driver.getCurrentUrl();

   Assert.assertEquals(currentUrl, curtUrlDriver);
		
		
		
	}

	@Given("^the user is Compound Library page one$")
	public void the_user_is_Compound_Library_page_one() throws Throwable {
	   Thread.sleep(2000);
	   driver.navigate().to(COMPOUND_LIST_URL);
	   Thread.sleep(2000);
	    driver.findElement(By.xpath(".//*[@id='example_paginate']/ul/li[3]/a")).click();
		
		
		
	}

	@When("^clicked on Prev button$")
	public void clicked_on_Prev_button() throws Throwable {
	
		
		Thread.sleep(2000);
	    driver.findElement(By.xpath(".//*[@id='example_paginate']/ul/li[1]/a")).click();
		
	}

	@Then("^the user should be able to navigate to the Previous page$")
	public void the_user_should_be_able_to_navigate_to_the_Previous_page() throws Throwable {
	  
		Thread.sleep(2000);
		String currentUrl = COMPOUND_LIST_URL;
	    String curtUrlDriver = driver.getCurrentUrl();

	   Assert.assertEquals(currentUrl, curtUrlDriver);
		
		
	}


	
	
	
	
	
	
	
	
	
	
	
}
