package com.easytox.automation.steps.editing_case_under_action_column;

import com.easytox.automation.driver.DriverBase;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class EditingACaseUnderActionColumnSteps {
	private WebDriver driver;
	private WebElement row;
	
	public EditingACaseUnderActionColumnSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}

	@When("^Verify that for a case under column \"([^\"]*)\" as \"([^\"]*)\"$")
	public void verify_that_for_a_case_under_column_as(String arg1, String arg2) throws Throwable {
		
	}

	@SuppressWarnings("unused")
	@Then("^\"([^\"]*)\" should be displayed under column \"([^\"]*)\"$")
	public void should_be_displayed_under_column(String arg1, String arg2) throws Throwable {
		Thread.sleep(5000);
		WebElement tableBody = driver.findElement(By.xpath("//table[@id='caseorder']/tbody"));
		
		List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
		for(int i=1;i<=rows.size();i++) {
			row = driver.findElement(By.xpath("//table[@id='caseorder']/tbody/tr["+i+"]"));
			String cell = row.findElement(By.xpath("//td[7]")).getText();
			Assert.assertTrue(cell.contains("finalized"));
			break;
		}
	}

	@When("^Click on the Edit icon under the Action column for \"([^\"]*)\" case$")
	public void click_on_the_Edit_icon_under_the_Action_column_for_case(String arg1) throws Throwable {
		row.findElement(By.cssSelector(".fa-pencil")).click();
	}

	@Then("^\"([^\"]*)\" window should be displayed$")
	public void window_should_be_displayed(String arg1) throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.id("caseCorrectionModal"));
	}
}
