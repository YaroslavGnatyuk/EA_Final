package com.easytox.automation.steps;

import static org.testng.AssertJUnit.assertEquals;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

/**
 * Created by dhanumandla on 28/09/16.
 */
public class SeleniumSteps {

    private WebDriver driver;
    private WebElementHelper webElementHelper;

    public SeleniumSteps() {
        DriverBase.instantiateDriverObject();
        this.webElementHelper = new WebElementHelper();
        driver = DriverBase.getDriver();
    }
    @When("^I open selenium website$")
    public void openSeleniumSite() throws Throwable {
        driver.get("http://www.seleniumframework.com");
    }

    @Then("^I validate title and URL$")
    public void assertText() throws Throwable {
        assertEquals("Selenium Framework | Selenium, Cucumber, Ruby, Java et al.", driver.getTitle());
        assertEquals("http://www.seleniumframework.com/", driver.getCurrentUrl());
    }
}
