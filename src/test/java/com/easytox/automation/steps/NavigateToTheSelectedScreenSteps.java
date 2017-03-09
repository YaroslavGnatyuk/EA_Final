package com.easytox.automation.steps.instruments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NavigateToTheSelectedScreenSteps {
	WebDriver driver;
	
	public NavigateToTheSelectedScreenSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@When("^Click on Settings icon and click on the 'Instruments List' I$")
	public void click_on_Settings_icon_and_click_on_the_Instruments_List() throws Throwable {
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector(".account-area > li:nth-child(8)")).click();
		driver.findElement(By.cssSelector("#topmenu > li:nth-child(2)")).click();
	}

	@Then("^Instruments List screen should be displayed I$")
	public void instruments_List_screen_should_be_displayed() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "http://bmtechsol.com:8080/easytox/instruments/list");
	}
}
