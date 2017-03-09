package com.easytox.automation.steps.labUser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyLockingAccessForLabUserSteps {
	private WebDriver driver;
	private String user = "cgilabadmin";
	
	public VerifyLockingAccessForLabUserSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@When("^Click \"([^\"]*)\" icon for any existing user under Action column$")
	public void click_icon_for_any_existing_user_under_Action_column(String arg1) throws Throwable {
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
					row.findElement(By.cssSelector(".fa-unlock-alt")).click();
					break loop; 
				}    
			}
		} 
	}

	@Then("^User should be locked and \"([^\"]*)\" message should be populated$")
	public void user_should_be_locked_and_message_should_be_populated(String arg1) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".alert-success"));
	}

	@Then("^Account locked message should be populated and user should not be able to login to application$")
	public void account_locked_message_should_be_populated_and_user_should_not_be_able_to_login_to_application() throws Throwable {
		String msg = driver.findElement(By.cssSelector(".alert-danger")).getText();
		Assert.assertEquals("Sorry, your account is locked.", msg);
	}
}
