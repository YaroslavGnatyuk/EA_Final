package com.easytox.automation.steps.instruments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyTheSearchResultsSteps {
	private WebDriver driver;
	
	public VerifyTheSearchResultsSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@When("^Enter any search criteria and click on search icon I$")
	public void enter_any_search_criteria_and_click_on_search_icon() throws Throwable {
		driver.navigate().to("http://bmtechsol.com:8080/easytox/instruments/list");
		
		String data[] = { "Test 123", "123456", "02/May/2016", "First floor", "28"};
		
		for (int i = 0; i < data.length; i++) {
			search(data[i]);
			Thread.sleep(2000);
		}
	}

	@Then("^Matching records with entered data should be displayed in the Instruments list I$")
	public void matching_records_with_entered_data_should_be_displayed_in_the_Instruments_list() throws Throwable {
		Thread.sleep(2000);
		WebElement table = driver.findElement(By.id("example"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		loop:
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				if(cell.getText().equals("Test 123")) {
					Assert.assertTrue(cell.getText().equals("test"));
					break loop; 
				}    
			}
		} 
	}
	
	private void search(String searchKey){
		WebElement searchBox = driver.findElement(By.cssSelector("#example_filter > label > input"));
		searchBox.clear();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.cssSelector("#example_filter > label")));
		actions.click();
		actions.sendKeys(searchKey);
		actions.build().perform();
	}
}
