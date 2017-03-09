package com.easytox.automation.steps.accessionPrefix;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchBoxSteps {
	
	private WebDriver driver;
	
	public SearchBoxSteps() {
		DriverBase.instantiateDriverObject();
		this.driver = DriverBase.getDriver();
	}

	@When("^entered some text in the Searchbox AP$")
	public void entered_some_text_in_the_Searchbox() throws Throwable {
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.cssSelector("#example_filter > label")));
		actions.click();
		actions.sendKeys("Urine");
		actions.build().perform();
		Thread.sleep(2000);
	}

	@Then("^user should be able to view the search results AP$")
	public void user_should_be_able_to_view_the_search_results() throws Throwable {
		WebElement table = driver.findElement(By.id("example"));
		List<WebElement> rows = table.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		for(int i=1;i<=rows.size();i++) {
			String cell = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[2]")).getText();
			Assert.assertTrue(cell.contains("Urine"));
		}
	}
}
