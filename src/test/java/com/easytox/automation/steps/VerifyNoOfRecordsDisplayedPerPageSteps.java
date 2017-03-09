package com.easytox.automation.steps.labUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyNoOfRecordsDisplayedPerPageSteps {
	
	private WebDriver driver;
	
	public VerifyNoOfRecordsDisplayedPerPageSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@When("^Verify the default number of records displayed LU$")
	public void verify_the_default_number_of_records_displayed() throws Throwable {
		WebElement table = driver.findElement(By.id("example"));
		int rowsCount = table.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
		
		Assert.assertTrue(rowsCount <= 10);
	}

	@Then("^Default number \"([^\"]*)\" should be displayed in the dropdown box LU$")
	public void default_number_should_be_displayed_in_the_dropdown_box(String arg1) throws Throwable {
		Thread.sleep(2000);
		Select dropdown = new Select (driver.findElement(By.name("example_length")));
		System.out.println("test:"+dropdown.getFirstSelectedOption().getText());
		int defaultNo = Integer.valueOf(dropdown.getFirstSelectedOption().getText());
		
		Assert.assertEquals(10, defaultNo);
	}

	@When("^Click on dropdown that shows no of records to be displayed on the page LU$")
	public void click_on_dropdown_that_shows_no_of_records_to_be_displayed_on_the_page() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.name("example_length")).click();
		Thread.sleep(2000);
	}

	@Then("^User should be able to view and select the options from the list and the corresponding number of records should be displayed on the page LU$")
	public void user_should_be_able_to_view_and_select_the_options_from_the_list_and_the_corresponding_number_of_records_should_be_displayed_on_the_page() throws Throwable {
		Select dropdown = new Select (driver.findElement(By.name("example_length")));
		dropdown.selectByIndex(1);
		Thread.sleep(2000);
		
		WebElement table = driver.findElement(By.id("example"));
		int rowsCount;
		
		for (int i = 0; i < 4; i++) {
			dropdown.selectByIndex(i);
			int value = Integer.parseInt(dropdown.getFirstSelectedOption().getText());
			rowsCount = table.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
			
			Assert.assertTrue(rowsCount <= value);
			
			Thread.sleep(2000);
		}
	}
}
