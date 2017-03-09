package com.easytox.automation.steps.caseList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditCaseWithAccessionNumberSteps {
	private WebDriver driver;
	
	public EditCaseWithAccessionNumberSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@When("^Click on Case Accession number$")
	public void click_on_Case_Accession_number() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.id("editlink")).click();
	}

	@Then("^Case screen should be displayed for editing$")
	public void case_screen_should_be_displayed_for_editing() throws Throwable {
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), "http://bmtechsol.com:8080/easytox/caseOrder/edit");
	}
}
