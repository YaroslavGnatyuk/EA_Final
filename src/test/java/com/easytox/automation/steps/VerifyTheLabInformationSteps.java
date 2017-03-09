package com.easytox.automation.steps.labAdmin.verifyLabClientList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyTheLabInformationSteps {
	private WebDriver driver;
	
	public VerifyTheLabInformationSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@When("^Click on '\\+' icon against the lab client record in results list$")
	public void click_on_icon_against_the_lab_client_record_in_results_list() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".fa-list-ul")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#example > tbody .details-control")).click();
	}

	@Then("^Existing Lab Client Following values should be populated: Address: Address(\\d+),address(\\d+) Lab: LabTest$")
	public void existing_Lab_Client_Following_values_should_be_populated_Address_Address_address_Lab_LabTest(int arg1, int arg2) throws Throwable {
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("#example > tbody .table"));
	}

}
