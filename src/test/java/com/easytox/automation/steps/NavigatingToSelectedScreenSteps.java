package com.easytox.automation.steps.faxQueue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NavigatingToSelectedScreenSteps {
	private WebDriver driver;
	
	public NavigatingToSelectedScreenSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}

	@When("^Click on 'Fax Queue' tab on the menu and click on 'See All'$")
	public void click_on_Fax_Queue_tab_on_the_menu_and_click_on_See_All() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".account-area > li:nth-child(5)")).click();
		
		Thread.sleep(200);
		driver.findElement(By.cssSelector("#pendingfaxjobs > li:nth-child(2) a")).click();
		
	}

	@Then("^Fax Queue list page should be displayed$")
	public void fax_Queue_list_page_should_be_displayed() throws Throwable {
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), "http://bmtechsol.com:8080/easytox/queue/faxlist");
		Thread.sleep(2000);
	}
}
