package com.easytox.automation.steps.labAdmin.verifyLabAdmin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Then;

public class LoginAsALabAdminSteps {
	private WebDriver driver;
	
	public LoginAsALabAdminSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@Then("^Lab user should be able to login successfully$")
	public void lab_user_should_be_able_to_login_successfully() throws Throwable {
		Thread.sleep(500);
		Assert.assertEquals(driver.getCurrentUrl(), "http://bmtechsol.com/easytox/lab/list");
	}
}
