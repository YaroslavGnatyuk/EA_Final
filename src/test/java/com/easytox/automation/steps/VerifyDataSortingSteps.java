package com.easytox.automation.steps.caseList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyDataSortingSteps {
	private WebDriver driver;
	private WebElement element;
	
	public VerifyDataSortingSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	        
	@When("^Click on down arrow on any column CL$")
	public void click_on_down_arrow_on_any_column(String arg1) throws Throwable {
		Thread.sleep(2000);
		element = driver.findElement(By.cssSelector("table > thead > tr > th:nth-child(2)"));
		element.click();
	}

	@Then("^Records should be displayed based on the asecending order of the selected field CL$")
	public void records_should_be_displayed_based_on_the_asecending_order_of_the_selected_field() throws Throwable {
		Thread.sleep(2000);
		Assert.assertTrue(element.getAttribute("class").equals("sorting_asc"));
	}

	@When("^Click on \"([^\"]*)\"Up arrow on any column CL$")
	public void click_on_Up_arrow_on_any_column(String arg1) throws Throwable {
		Thread.sleep(2000);
		element.click();
	}

	@Then("^Records should be displayed based on the descending order of the selected field CL$")
	public void records_should_be_displayed_based_on_the_descending_order_of_the_selected_field() throws Throwable {
		Thread.sleep(2000);
		Assert.assertTrue(element.getAttribute("class").equals("sorting_desc"));
	}
}
