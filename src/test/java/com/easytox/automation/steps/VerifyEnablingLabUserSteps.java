package com.easytox.automation.steps.labUser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyEnablingLabUserSteps {
	private WebDriver driver;
	private String user = "cgilabadmin";
	
	public VerifyEnablingLabUserSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@When("^Select a user which is disabled and click \"([^\"]*)\" icon under Enable/Disable column$")
	public void select_a_user_which_is_disabled_and_click_icon_under_Enable_Disable_column(String arg1) throws Throwable {
		driver.manage().window().maximize();
		user = "CGILabUser1";
		Thread.sleep(2000);
		WebElement table = driver.findElement(By.id("example"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		loop:
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				if(cell.getText().equals(user)) {
					Thread.sleep(1000);
					row.findElement(By.cssSelector(".fa-ban")).click();
					break loop; 
				}    
			}
		} 
	}

	@Then("^User account should be enabled and \"([^\"]*)\" message should be populated$")
	public void user_account_should_be_enabled_and_message_should_be_populated(String arg1) throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".alert-success"));
	}

	@Then("^User login should be successful$")
	public void user_login_should_be_successful() throws Throwable {
		Assert.assertEquals("http://bmtechsol.com:8080/easytox/caseOrder/list", driver.getCurrentUrl());
	}
}