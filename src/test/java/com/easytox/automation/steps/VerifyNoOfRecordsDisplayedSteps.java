package com.easytox.automation.steps.caseList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyNoOfRecordsDisplayedSteps {
	private WebDriver driver;
	private int[] nrOfRes = new int[4];
	private Select select;
	
	public VerifyNoOfRecordsDisplayedSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@When("^Verify the default number of records displayed CL$")
	public void verify_the_default_number_of_records_displayed() throws Throwable {
		Thread.sleep(2000);
		Select select = new Select(driver.findElement(By.name("caseorder_length")));
		nrOfRes[0] = Integer.parseInt(select.getFirstSelectedOption().getText());
	}

	@Then("^Default number \"([^\"]*)\" should be displayed in the dropdown box CL$")
	public void default_number_should_be_displayed_in_the_dropdown_box(String arg1) throws Throwable {
		Assert.assertEquals(nrOfRes[0], 10);
	}

	@When("^Click on dropdown that shows no of records to be displayed on the page CL$")
	public void click_on_dropdown_that_shows_no_of_records_to_be_displayed_on_the_page() throws Throwable {
		Thread.sleep(2000);
		select = new Select(driver.findElement(By.name("caseorder_length")));
		driver.findElement(By.name("caseorder_length")).click();
		Thread.sleep(2000);
	}

	@Then("^User should be able to view and select the options from the list and the corresponding number of records should be displayed on the page CL$")
	public void user_should_be_able_to_view_and_select_the_options_from_the_list_and_the_corresponding_number_of_records_should_be_displayed_on_the_page() throws Throwable {
		WebElement tableBody = driver.findElement(By.id("caseorder")).findElement(By.tagName("tbody"));
		int nrOfRows = tableBody.findElements(By.tagName("tr")).size();
		
		for (int i = 1; i < 4 ; i++) {
			select.selectByIndex(i);
			Assert.assertTrue(nrOfRows <= Integer.parseInt(select.getFirstSelectedOption().getText()));
			Thread.sleep(2000);
		}
	}
}
