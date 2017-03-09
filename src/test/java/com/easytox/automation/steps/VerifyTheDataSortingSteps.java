package com.easytox.automation.steps.printReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyTheDataSortingSteps {
	private WebDriver driver;
	private WebElement element;
	
	public VerifyTheDataSortingSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@When("^Click on '\\˅' down arrow icon on sorting column PR$")
	public void click_on_down_arrow_icon_on_sorting_column() throws Throwable {
		driver.navigate().to("http://bmtechsol.com:8080/easytox/caseOrder/finalizedCaselist");
		
		Thread.sleep(2000);
		element = driver.findElement(By.cssSelector("thead > tr > th:nth-child(3)"));
		element.click();
	}

	@Then("^Records should be displayed based on the asecending order of the selected sorting column PR$")
	public void records_should_be_displayed_based_on_the_asecending_order_of_the_selected_sorting_column() throws Throwable {
		Thread.sleep(3000);
		Assert.assertTrue(element.getAttribute("class").contains("sorting_asc"));
	}

	@When("^Click on '\\^' Up icon arrow on Profile Name column PR$")
	public void click_on_Up_icon_arrow_on_Profile_Name_column() throws Throwable {
		element.click();
	}

	@Then("^Records should be displayed based on the descending order of the selected sorting column PR$")
	public void records_should_be_displayed_based_on_the_descending_order_of_the_selected_sorting_column() throws Throwable {
		Thread.sleep(1000);
		Assert.assertTrue(element.getAttribute("class").equals("sorting_desc"));
	}
}
