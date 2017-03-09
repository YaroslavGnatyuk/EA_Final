package com.easytox.automation.steps.labAdmin.verifyLabUserList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyTheUserListSteps {
	private WebDriver driver;
	
	public VerifyTheUserListSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@When("^Click on User List icon under 'action' column$")
	public void click_on_User_List_icon_under_action_column() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".fa-users")).click();
	}

	@Then("^Lab User List screen should be displayed$")
	public void lab_User_List_screen_should_be_displayed() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "http://bmtechsol.com:8080/easytox/user/list");
	}
}
