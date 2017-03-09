package com.easytox.automation.steps.instruments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddingANewInstrumentsSteps {
	private WebDriver driver;
	
	public AddingANewInstrumentsSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@When("^Click on '\\+' icon beside the Search Box I$")
	public void click_on_icon_beside_the_Search_Box() throws Throwable {
		driver.navigate().to("http://bmtechsol.com:8080/easytox/instruments/list");
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".fa-plus-circle")).click();
	}

	@Then("^'Add Instruments' screen should be displayed I$")
	public void add_Instruments_screen_should_be_displayed() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "http://bmtechsol.com:8080/easytox/instruments/create");
	}
}
