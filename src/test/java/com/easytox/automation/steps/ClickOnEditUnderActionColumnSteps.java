package com.easytox.automation.steps.instruments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ClickOnEditUnderActionColumnSteps {
	private WebDriver driver;
	
	public ClickOnEditUnderActionColumnSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@When("^Click on Edit icon under Action column I$")
	public void click_on_Edit_icon_under_Action_column() throws Throwable {
		driver.navigate().to("http://bmtechsol.com:8080/easytox/instruments/list");
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".fa-pencil-square-o")).click();
	}

	@Then("^'Update Instruments' window should be displayed$")
	public void update_Instruments_window_should_be_displayed() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "http://bmtechsol.com:8080/easytox/instruments/edit");
	}
}
