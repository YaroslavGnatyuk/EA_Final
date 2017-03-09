package com.easytox.automation.steps.labAdmin.verifyLabClientList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyLabClientListSteps {
	private WebDriver driver;
	
	public VerifyLabClientListSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}

	@When("^Click on Client List Icon under 'action' column$")
	public void click_on_Client_List_Icon_under_action_column() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".fa-list-ul")).click();
	}

	@Then("^Lab Client List screen should be displayed$")
	public void lab_Client_List_screen_should_be_displayed() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "http://bmtechsol.com:8080/easytox/labClient/labclientlists");
	}
}
