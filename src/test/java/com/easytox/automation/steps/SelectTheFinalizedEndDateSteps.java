package com.easytox.automation.steps.printReports;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SelectTheFinalizedEndDateSteps {
	private WebDriver driver;
	
	public SelectTheFinalizedEndDateSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}

	@When("^Click on the End date field select the date and verify if the correct date is shown in the box\\.$")
	public void click_on_the_End_date_field_select_the_date_and_verify_if_the_correct_date_is_shown_in_the_box() throws Throwable {
		driver.navigate().to("http://bmtechsol.com:8080/easytox/caseOrder/finalizedCaselist");
		Thread.sleep(2000);
		
		driver.findElement(By.id("max")).click();
		WebElement table = driver.findElement(By.cssSelector(".datepicker-days table"));
		WebElement datepickerSwitch = table.findElement(By.cssSelector(".datepicker-switch"));
		WebElement prev = table.findElement(By.cssSelector(".prev"));
		
		while(!datepickerSwitch.getText().equals("March 2016")){
			prev.click();
			Thread.sleep(100);
		}
		
		List<WebElement> cells = table.findElements(By.tagName("td"));
		for (WebElement cell : cells) {
			if(cell.getText().equals("16")) {
				cell.click();
				break;
			}
		}
	
		Thread.sleep(2000);
	}

	@Then("^Select date should be diplayed in the date field then Finalized case list results should be displayed$")
	public void select_date_should_be_diplayed_in_the_date_field_then_Finalized_case_list_results_should_be_displayed() throws Throwable {
		Assert.assertTrue(driver.findElement(By.id("max")).getAttribute("value").equals("03/16/2016"));
	}
}
