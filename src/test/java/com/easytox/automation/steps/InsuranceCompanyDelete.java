package com.easytox.automation.steps;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class InsuranceCompanyDelete {

	private static final String Search_Box = "Test45";
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "cgilabadmin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="Welcome@123";
	private static final String Insurance_Company_URL ="http://bmtechsol.com:8080/easytox/insuranceCompany/list";
	private static final String Add_Insurance_Company_URL ="http://bmtechsol.com:8080/easytox/insuranceCompany/create";
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public InsuranceCompanyDelete(){
		
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

	@When("^Click Edit icon for a Insurance Company.$")
	public void Click_Edit_icon_for_a_Insurance_Company() throws Throwable {
		//next page
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example_paginate']/ul/li[4]/a")).click();
		Thread.sleep(2000);
		//edit option	
		
		driver.findElement(By.xpath(".//*[@id='example']/tbody/tr[3]/td[8]/form")).click();
		
		
		
		
	}

	@Then("^Update Insurance Company page should be displayed$")
	public void Update_Insurance_Company_page_should_be_displayed() throws Throwable {
		
		
		Thread.sleep(1000);
		String currentUrl = Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertNotEquals(currentUrl, curtUrlDriver);
		
		
		
		
	}

	@When("^Click Delete button$")
	public void Click_Delete_button() throws Throwable {
	  
		
		Thread.sleep(2000);
		
		
		//delete button
		driver.findElement(By.xpath(".//*[@id='form']/div[9]/div/input")).click();
		
		
			
	}

	@Then("^Confirmation message is displayed$")
	public void Confirmation_message_is_displayed() throws Throwable {
	  
	
		Thread.sleep(5000);  
	
	}

	@When("^Click No on confirmation message$")
	public void Click_No_on_confirmation_message() throws InterruptedException {
	 
        			Alert pop = driver.switchTo().alert();
			pop.dismiss();
		
			}

	@Then("^Insurance Company should not be deleted$")
	public void Insurance_Company_should_not_be_deleted() throws Throwable {

		Thread.sleep(2000);
		String currentUrl = "http://bmtechsol.com:8080/easytox/insuranceCompany/edit";
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
		
		
		
		
	}

	@When("^Click Delete button and Yes on confirmation message$")
	public void Click_Delete_button_and_Yes_on_confirmation_message() throws Throwable {
		//delete button
				driver.findElement(By.xpath(".//*[@id='form']/div[9]/div/input")).click();
				Thread.sleep(3000);
				
			
				Alert pop = driver.switchTo().alert();
				pop.accept();
				  //next page
				Thread.sleep(4000);
				driver.findElement(By.xpath(".//*[@id='example_paginate']/ul/li[4]/a")).click();
	}

	@Then("^Insurance Company should be deleted successfully$")
	public void Insurance_Company_should_be_deleted_successfully() throws Throwable {
	 
		Thread.sleep(2000);
		String currentUrl = Add_Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertNotEquals(currentUrl, curtUrlDriver);
	
		
		
		driver.quit();
	}


	
	
		
	
	
	
}
