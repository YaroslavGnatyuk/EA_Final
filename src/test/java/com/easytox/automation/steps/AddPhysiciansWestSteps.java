package com.easytox.automation.steps.addPhysicians;
import java.util.List;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddPhysiciansWestSteps {
	
	private static final String USERNAME = "lavanya1";
	private static final String PASSWORD = "P@ssw0rd123";
	private static final String FIND_USERNAME = "j_username";
    private static final String FIND_PASSWORD = "j_password";
	private static final String LAB_CLIENT = "West";
	private static final String URL = "http://bmtechsol.com:8080/easytox/";
	private static final String LAB_CLIENTS_LIST_URL = "http://bmtechsol.com:8080/easytox/labClient/list";
	private static final String CLINICIANS_LIST_URL = "http://bmtechsol.com:8080/easytox/clinician/clinicianslist";
	private static final String ADD_PHYSICIAN_URL = "http://bmtechsol.com:8080/easytox/clinician/create";
	private static final String EDIT_PHYSICIAN_URL = "http://bmtechsol.com:8080/easytox/clinician/edit";
	private static final String FIND_PHYSICIAN_USERNAME = "user.username";
	private static final String FIND_PHYSICIAN_PASSWORD = "user.password";
	private static final String CLINICIAN_PSW = "Welcome@123";
	
    private WebDriver driver;
    private WebElementHelper webElementHelper;

    public AddPhysiciansWestSteps() {
        DriverBase.instantiateDriverObject();
        this.webElementHelper = new WebElementHelper();
        driver = DriverBase.getDriver();
    }
    
    @Given("^Locations should be available West$")
    public void locations_should_be_available() throws Throwable {
    	driver.navigate().to(LAB_CLIENTS_LIST_URL);
    	Thread.sleep(2000);
    	driver.findElement(By.linkText(LAB_CLIENT));
    }

    @When("^Click on the Phisician icon on the LabClient list page for West lab$")
    public void click_on_the_Phisician_icon_on_the_LabClient_list_page_for_West_lab() throws Throwable {
    	Thread.sleep(2000);
    	
    	WebElement table = driver.findElement(By.id("example"));

    	List<WebElement> allRows = table.findElements(By.tagName("tr"));
    	loop : {
	    	for (WebElement row : allRows) {
	    		List<WebElement> cells = row.findElements(By.xpath("./*"));
		    	for (WebElement cell : cells) {
		    		String cellText = cell.getText();
					if(cellText.equals(LAB_CLIENT)) {
						WebElement icon = row.findElement(By.cssSelector(".fa.fa-user-md.fa-2x"));
						icon.click();
						break loop;
					}
		    	 }
	    	}
    	}
		Thread.sleep(2000);
    }

    @When("^Select 'Edit' icon next to 'Angelina' physician$")
    public void select_Edit_icon_next_to_Angelina_physician() throws Throwable {
    	Thread.sleep(2000);
    	
    	WebElement table = driver.findElement(By.id("example"));
    	List<WebElement> allRows = table.findElements(By.tagName("tr"));
    	loop: {
	    	for (WebElement row : allRows) {
	    		List<WebElement> cells = row.findElements(By.xpath("./*"));
		    	for (WebElement cell : cells) {
		    		String cellText = cell.getText();
					if(cellText.equals("Angelia")) {
						WebElement icon = row.findElement(By.cssSelector(".fa.fa-pencil-square-o.fa-2x"));
						icon.click();
						break loop;
					}
		    	 }
	    	}
    	}
		Thread.sleep(2000);
    }

    @Then("^'Edit Physician' page should be displayed$")
    public void edit_Physician_page_should_be_displayed() throws Throwable {
    	Assert.assertEquals(EDIT_PHYSICIAN_URL, driver.getCurrentUrl());
    }

    @When("^Select Lab Client Locations as 'West' and select Location as 'West' and add the location$")
    public void select_Lab_Client_Locations_as_West_and_select_Location_as_West_and_add_the_location() throws Throwable {
    	
    	Select dropdown = new Select(driver.findElement(By.id("labclientselect")));
    	dropdown.selectByVisibleText(LAB_CLIENT);
     	Thread.sleep(1000);
     	dropdown = new Select(driver.findElement(By.id("lablocations")));
     	dropdown.selectByVisibleText(LAB_CLIENT);
     	
     	driver.findElement(By.cssSelector(".addLocation")).click();
     	
     	Thread.sleep(2000);
    }

    @When("^Click on 'Submit'$")
    public void click_on_Submit() throws Throwable {
    	driver.findElement(By.cssSelector(".btn.btn-danger.btn-md")).click();
    	Thread.sleep(2000);
    }

    @Then("^Physician should be added to the West Lab Client$")
    public void physician_should_be_added_to_the_West_Lab_Client() throws Throwable {
    	Thread.sleep(1000);
    	driver.findElement(By.cssSelector(".alert.alert-success"));
    }

    @When("^Enter Username as 'Bansal' and pwd as 'Welcome@(\\d+)'$")
    public void enter_Username_as_Bansal_and_pwd_as_Welcome(int arg1) throws Throwable {
    	String username = "Bansal3";
    	driver.findElement(By.name(FIND_PHYSICIAN_USERNAME)).sendKeys(username);
    	driver.findElement(By.name(FIND_PHYSICIAN_PASSWORD)).sendKeys(CLINICIAN_PSW);
    	Thread.sleep(5000);
    }

    @When("^Enter Username as 'Brigade' and pwd as 'Welcome@(\\d+)'$")
    public void enter_Username_as_Brigade_and_pwd_as_Welcome(int arg1) throws Throwable {
    	String username = "Brigade3";
    	driver.findElement(By.name(FIND_PHYSICIAN_USERNAME)).sendKeys(username);
    	driver.findElement(By.name(FIND_PHYSICIAN_PASSWORD)).sendKeys(CLINICIAN_PSW);
    	Thread.sleep(5000);
    }

    @When("^Enter Username as 'BradLemon' and pwd as 'Welcome@(\\d+)'$")
    public void enter_Username_as_BradLemon_and_pwd_as_Welcome(int arg1) throws Throwable {
    	String username = "BradLemon3";
    	driver.findElement(By.name(FIND_PHYSICIAN_USERNAME)).sendKeys(username);
    	driver.findElement(By.name(FIND_PHYSICIAN_PASSWORD)).sendKeys(CLINICIAN_PSW);
    	Thread.sleep(5000);
    }
}

