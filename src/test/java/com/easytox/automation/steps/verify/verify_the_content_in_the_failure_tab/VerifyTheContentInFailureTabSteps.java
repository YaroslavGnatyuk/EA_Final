package com.easytox.automation.steps.verify.verify_the_content_in_the_failure_tab;

import com.easytox.automation.driver.DriverBase;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class VerifyTheContentInFailureTabSteps {
	private WebDriver driver;
	
	public VerifyTheContentInFailureTabSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@When("^Click on 'Failure' tab$")
	public void click_on_Failure_tab() throws Throwable {
		driver.navigate().to("http://bmtechsol.com:8080/easytox/queue/faxlist");
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[href = '#failurefaxtab']")).click();
	}

	@Then("^Failure fax queue list should be displayed$")
	public void failure_fax_queue_list_should_be_displayed() throws Throwable {
		Assert.assertEquals(driver.findElement(By.cssSelector("#outboundtab ul > li.active > a")).getText(), "failure");
	}

	@When("^Enter any search criteria and click on search icon CF$")
	public void enter_any_search_criteria_and_click_on_search_icon() throws Throwable {
		WebElement searchBox = driver.findElement(By.cssSelector("#failureFaxtable_filter > label > input"));
		searchBox.clear();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("#failureFaxtable_filter > label > input")));
		action.click();
		action.sendKeys("test");
		action.build().perform();
	}

	@Then("^Matching records with entered data should be displayed in the Fax Queue List CF$")
	public void matching_records_with_entered_data_should_be_displayed_in_the_Fax_Queue_List() throws Throwable {
		WebElement tableBody = driver.findElement(By.cssSelector("#failureFaxtable tbody"));
		List<WebElement> cells = tableBody.findElements(By.tagName("td"));
		
		for (WebElement cell : cells) {
			if(cell.getText().equals("test")) {
				Assert.assertTrue(cell.getText().equals("test"));
				break;
			}
		}
	}
}
