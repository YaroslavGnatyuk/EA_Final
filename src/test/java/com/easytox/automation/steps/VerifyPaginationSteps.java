package com.easytox.automation.steps.instruments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifyPaginationSteps {
	private WebDriver driver;
	private int activePage = 1;
	
	public VerifyPaginationSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}
	
	@When("^Navigate back and forth by selecting page numbers 'Prev/(\\d+),(\\d+),(\\d+)/Next' I$")
	public void navigate_back_and_forth_by_selecting_page_numbers_Prev_Next(int arg1, int arg2, int arg3) throws Throwable {
		driver.navigate().to("http://bmtechsol.com:8080/easytox/instruments/list");
		
		Thread.sleep(1000);
		WebElement next = driver.findElement(By.cssSelector(".next > a"));
		WebElement prev = driver.findElement(By.cssSelector(".prev > a"));
		
		while(!driver.findElement(By.cssSelector(".next")).getAttribute("class").contains("disabled")) {
			next.click();
			activePage = Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText());
			Thread.sleep(500);
		}
		
		while(!driver.findElement(By.cssSelector(".prev")).getAttribute("class").contains("disabled")) {
			prev.click();
			activePage = Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText());
			Thread.sleep(500);
		}
	}

	@Then("^User should be navigate to the selected page I$")
	public void user_should_be_navigate_to_the_selected_page() throws Throwable {
		Thread.sleep(2000);
		Assert.assertTrue(activePage == Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText()));
	}

	@When("^Checking the message of no of records displayed on the current page bottom left corner of the screen I$")
	public void checking_the_message_of_no_of_records_displayed_on_the_current_page_bottom_left_corner_of_the_screen() throws Throwable {
		Assert.assertTrue(!driver.findElement(By.cssSelector(".dataTables_info")).getText().equals(null));
	}

	@Then("^A text message “Showing x to y of z entries” should be displayed on the bottom left corner of the list I$")
	public void a_text_message_Showing_x_to_y_of_z_entries_should_be_displayed_on_the_bottom_left_corner_of_the_list() throws Throwable {
		String msg = driver.findElement(By.cssSelector(".dataTables_info")).getText();
		Assert.assertTrue(msg.matches("Showing (\\d)+ to (\\d)+ of (\\d)+ entries"));
	}
}
