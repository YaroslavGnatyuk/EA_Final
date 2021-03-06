package com.easytox.automation.steps.navigate_to_next_prev_page;

import com.easytox.automation.driver.DriverBase;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class NavigatingToNextPrevPageSteps {
	
	private WebDriver driver;
	private int activePage;
	
	public NavigatingToNextPrevPageSteps() {
		DriverBase.instantiateDriverObject();
		driver = DriverBase.getDriver();
	}

	@When("^clicked on next button AP$")
	public void clicked_on_next_button() throws Throwable {
		Thread.sleep(1000);
		WebElement next = driver.findElement(By.cssSelector(".next > a"));
		
		if(next.isEnabled()) {
			next.click();
			activePage = Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText());
		}
	}
	
	@Then("^the user should be able to navigate to the next page AP$")
	public void the_user_should_be_able_to_navigate_to_the_next_page() throws Throwable {
		Assert.assertTrue(activePage == Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText()));
	}
	
	@When("^clicked on Prev button AP$")
	public void clicked_on_Prev_button() throws Throwable {
		Thread.sleep(1000);
		WebElement prev = driver.findElement(By.cssSelector(".prev > a"));
		
		if(prev.isEnabled()) {
			prev.click();
			activePage = Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText());
		}
	}
	
	@Then("^the user should be able to navigate to the Previous page AP$")
	public void the_user_should_be_able_to_navigate_to_the_Previous_page() throws Throwable {
		Assert.assertTrue(activePage == Integer.parseInt(driver.findElement(By.cssSelector(".pagination li.active a")).getText()));
	}
	
	public void user_should_be_login_to_the_lab() throws Throwable {
		String USERNAME = "lavanya1";
		String PASSWORD = "P@ssw0rd123";
		String FIND_USERNAME = "j_username";
	    String FIND_PASSWORD = "j_password";
		String URL = "http://bmtechsol.com:8080/easytox/";
		
        driver.navigate().to(URL);

        WebElement username = driver.findElement(By.name(FIND_USERNAME));
        username.clear();
        username.sendKeys(USERNAME);

        WebElement psw = driver.findElement(By.name(FIND_PASSWORD));
        psw.clear();
        psw.sendKeys(PASSWORD);

        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div/button")).click();
    }
}
