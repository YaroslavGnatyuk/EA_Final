package com.easytox.automation.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SuperAdmin_request_submitMessage extends CommonCodeForAll {
	
	@Given("^I am on easytox login page$")
	public void I_am_on_easytox_login_page() throws Throwable {
	    
		driver.get(CommonCodeForAll.URL);		 
		
		 driver.manage().window().maximize();
		 credentials(driver);
		
		
	}

	@When("^I press forgot password click here$")
	public void I_press_forgot_password_click_here() throws Throwable {
	  
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div/div/div/div[3]/a")));
		
		driver.findElement(By.xpath("html/body/div[1]/div/div/div/div[3]/a")).click();
		
		
	}

	@When("^I enter username and email id$")
	public void I_enter_username_and_email_id() throws Throwable {
	  
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='actionRequestBy']")));
		
		driver.findElement(By.xpath(".//*[@id='actionRequestBy']")).sendKeys("Superadmin");
		
		
		
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='actionRequestEmail']")));
		
		driver.findElement(By.xpath(".//*[@id='actionRequestEmail']")).sendKeys("superadmin@gmail.com");
		
		
		driver.findElement(By.xpath(".//*[@id='form']/fieldset/div[3]/input")).click();
	}

	@Then("^forgot password request submitted message should be displayed$")
	public void forgot_password_request_submitted_message_should_be_displayed() throws Throwable {
	
		

		validation(driver);
		driver.quit();
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
