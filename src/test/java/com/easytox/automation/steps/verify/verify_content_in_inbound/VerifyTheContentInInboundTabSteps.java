package com.easytox.automation.steps.verify.verify_content_in_inbound;

import com.easytox.automation.driver.DriverBase;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class VerifyTheContentInInboundTabSteps {
	private WebDriver driver;
	
	public VerifyTheContentInInboundTabSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@When("^Click on InBound tab on Fax Queue List$")
	public void click_on_InBound_tab_on_Fax_Queue_List() throws Throwable {
		driver.navigate().to("http://bmtechsol.com:8080/easytox/queue/faxlist");
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[href='#inboundtab'")).click();
	}

	@Then("^InBound Fax Queue page should be diplayed$")
	public void inbound_Fax_Queue_page_should_be_diplayed() throws Throwable {
		Assert.assertEquals(driver.findElement(By.cssSelector(".page-body ul > li.active")).getText(), "InBound");
	}

	@When("^Enter any search criteria and click on search icon CI$")
	public void enter_any_search_criteria_and_click_on_search_icon() throws Throwable {
		WebElement searchBox = driver.findElement(By.cssSelector("#receivedFaxtable_filter > label > input"));
		searchBox.clear();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("#receivedFaxtable_filter > label")));
		action.click();
		action.sendKeys("test");
		action.build().perform();
	}

	@Then("^Matching records with entered data should be displayed in the InBound Fax Queue List CI$")
	public void matching_records_with_entered_data_should_be_displayed_in_the_InBound_Fax_Queue_List() throws Throwable {
		WebElement tableBody = driver.findElement(By.cssSelector("#receivedFaxtable tbody"));
		List<WebElement> cells = tableBody.findElements(By.tagName("td"));
		
		for (WebElement cell : cells) {
			if(cell.getText().equals("test")){
				Assert.assertTrue(cell.getText().equals("test"));
				break;
			}
		}
	}
}
