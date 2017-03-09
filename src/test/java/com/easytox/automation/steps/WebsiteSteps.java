package com.easytox.automation.steps;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by dhanumandla on 28/09/16.
 */
public class WebsiteSteps {

    private WebDriver driver;
    private WebElementHelper webElementHelper;

    public WebsiteSteps() {
        DriverBase.instantiateDriverObject();
        this.webElementHelper = new WebElementHelper();
        driver = DriverBase.getDriver();
    }
    @When("^I open website with URL '(.*)'$")
    public void openSeleniumSite(String URL) throws Throwable {
        driver.get(URL);
    }

    @Then("^I validate title and URL '(.*)', '(.*)'$")
    public void assertText(String title, String URL) throws Throwable {
        assertEquals(title, driver.getTitle());
        assertEquals(URL, driver.getCurrentUrl());
    }
}
