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

public class VerifyUnlockingAccessForLabUserSteps {
	private WebDriver driver;
	private String user = "cgilabadmin";
	
	public VerifyUnlockingAccessForLabUserSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@When("^Select a user which is locked and click \"([^\"]*)\" icon under Action column$")
	public void select_a_user_which_is_locked_and_click_icon_under_Action_column(String arg1) throws Throwable {
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
					row.findElement(By.cssSelector(".fa-lock")).click();
					break loop; 
				}    
			}
		} 
	}

	@Then("^User account should be unlocked and \"([^\"]*)\" message should be populated$")
	public void user_account_should_be_unlocked_and_message_should_be_populated(String arg1) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".alert-success"));
	}
}
