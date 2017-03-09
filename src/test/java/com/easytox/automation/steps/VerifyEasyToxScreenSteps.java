package com.easytox.automation.steps.labAdmin.verifyLabAdmin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Then;

public class VerifyEasyToxScreenSteps {
	private WebDriver driver;
	
	public VerifyEasyToxScreenSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}

	@Then("^'Lab List' results screen should be diplayed$")
	public void lab_List_results_screen_should_be_diplayed() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "http://bmtechsol.com:8080/easytox/lab/list");
	}
}
