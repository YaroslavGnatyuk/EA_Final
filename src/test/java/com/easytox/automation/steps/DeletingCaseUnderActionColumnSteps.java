package com.easytox.automation.steps.caseList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeletingCaseUnderActionColumnSteps {
	private WebDriver driver;
	private WebElement row;
	
	public DeletingCaseUnderActionColumnSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@When("^Verify that for a case under column 'Status' as 'Processing'$")
	public void verify_that_for_a_case_under_column_Status_as_Processing() throws Throwable {
	}

	@Then("^'Processing' should be displayed under column 'status'$")
	public void processing_should_be_displayed_under_column_status() throws Throwable {
		Thread.sleep(5000);
		WebElement tableBody = driver.findElement(By.xpath("//table[@id='caseorder']/tbody"));
		
		List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
		for(int i=1;i<=rows.size();i++) {
			row = driver.findElement(By.xpath("//table[@id='caseorder']/tbody/tr["+i+"]"));
			String cell = row.findElement(By.xpath("//td[7]")).getText();
			if(cell.contains("processing")) {
				Assert.assertTrue(cell.contains("processing"));
				break;
			}
		}
	}

	@When("^Click on the delete icon under the column 'Action' field for a Processing case$")
	public void click_on_the_delete_icon_under_the_column_Action_field_for_a_Processing_case() throws Throwable {
		if(row != null) {
			row.findElement(By.cssSelector(".fa-remove")).click();
		}
	}
	
	@Then("^Delete conformation window should be displayed$")
	public void delete_conformation_window_should_be_displayed() throws Throwable {
		if(row != null) {
			Thread.sleep(1000);
			driver.findElement(By.id("caseCorrectionModal"));
		}
	}
}
