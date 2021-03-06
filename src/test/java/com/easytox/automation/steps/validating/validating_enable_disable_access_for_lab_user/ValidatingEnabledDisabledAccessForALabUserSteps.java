package com.easytox.automation.steps.validating.validating_enable_disable_access_for_lab_user;

import com.easytox.automation.driver.DriverBase;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ValidatingEnabledDisabledAccessForALabUserSteps {
	private WebDriver driver;
	
	public ValidatingEnabledDisabledAccessForALabUserSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}

	@When("^Click 'Disable User' icon for any existing user under Enable/ Disable column$")
	public void click_Disable_User_icon_for_any_existing_user_under_Enable_Disable_column() throws Throwable {
		Thread.sleep(5000);
		List<WebElement> rows = driver.findElements(By.cssSelector("#lablist > tbody > tr"));
		
		for (WebElement row : rows) {
			if(row.findElement(By.cssSelector("td:nth-child(2")).getText().equals("RLab")) {
				row.findElement(By.cssSelector(".fa-users")).click();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		rows = driver.findElements(By.cssSelector("#example > tbody > tr"));
		
		for (WebElement row : rows) {
			if(row.findElement(By.cssSelector("td:nth-child(2")).getText().equals("zanfina123")) {
				row.findElement(By.cssSelector(".fa-check")).click();
				break;
			}
		}
		
		Thread.sleep(5000);
	}

	@Then("^User should be disabled and 'User disabled successfully' message should be populated$")
	public void user_should_be_disabled_and_User_disabled_successfully_message_should_be_populated() throws Throwable {
		Assert.assertEquals(driver.findElement(By.cssSelector(".alert-success")).getText(), "User zanfina123 disabled sucessfully");
	}

	@Then("^Account disabled message should be populated and user should not be able to login to application LUL$")
	public void account_disabled_message_should_be_populated_and_user_should_not_be_able_to_login_to_application() throws Throwable {
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.cssSelector(".alert-danger")).getText(), "Sorry, your account is disabled.");
	}

	@When("^Select a user which is disabled and click 'Enable' icon under Enabled column$")
	public void select_a_user_which_is_disabled_and_click_Enable_icon_under_Enabled_column() throws Throwable {
		login("superadmin", "admin");
		
		Thread.sleep(5000);
		List<WebElement> rows = driver.findElements(By.cssSelector("#lablist > tbody > tr"));
		
		for (WebElement row : rows) {
			if(row.findElement(By.cssSelector("td:nth-child(2")).getText().equals("RLab")) {
				row.findElement(By.cssSelector(".fa-users")).click();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		rows = driver.findElements(By.cssSelector("#example > tbody > tr"));
		
		for (WebElement row : rows) {
			if(row.findElement(By.cssSelector("td:nth-child(2")).getText().equals("zanfina123")) {
				row.findElement(By.cssSelector(".fa-ban")).click();
				break;
			}
		}
		
		Thread.sleep(5000);
		
	}

	@Then("^User account should be enabled and 'User enabled successfully' message should be populated$")
	public void user_account_should_be_enabled_and_User_enabled_successfully_message_should_be_populated() throws Throwable {
		Assert.assertEquals(driver.findElement(By.cssSelector(".alert-success")).getText(), "User zanfina123 enabled sucessfully");
	}

	private void login(String USERNAME, String PASSWORD) {
		String FIND_USERNAME = "j_username";
		String FIND_PASSWORD = "j_password";
		String URL = "http://bmtechsol.com:8080/easytox";
		
		driver.navigate().to(URL);
		
		WebElement username = driver.findElement(By.name(FIND_USERNAME));
		username.clear();
		username.sendKeys(USERNAME);
		
		WebElement password = driver.findElement(By.name(FIND_PASSWORD));
		password.clear();
		password.sendKeys(PASSWORD);
		
		driver.findElement(By.cssSelector(".btn")).click();		
	}
	
	private void logout() {
		driver.findElement(By.cssSelector(".account-area > li:nth-child(2)")).click();
		driver.findElement(By.cssSelector(".dropdown-menu > li > a")).click();
	}
}
