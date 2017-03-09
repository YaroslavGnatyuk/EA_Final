package com.easytox.automation.steps.accessionPrefix;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.constants.*;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SelectPrefixTypeSteps {
	private WebDriver driver;
    private int rowIndexOfDefault;
    
    public SelectPrefixTypeSteps() {
    	DriverBase.instantiateDriverObject();
    	driver = DriverBase.getDriver();
	}

	@When("^the user is on Accession Prefix page user should be able to view the options and select them$")
	public void the_user_is_on_Accession_Prefix_page_user_should_be_able_to_view_the_options_and_select_them() throws Throwable {
		user_should_be_login_to_the_lab();

		Thread.sleep(1000);
        driver.findElement(By.cssSelector(".account-area > li:nth-child(9) > a > img")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".account-area > li:nth-child(9) > ul > li:first-child > a")).click();
        Thread.sleep(2000);
	}
	
	@When("^selected Prefix as Case Type AP$")
	public void selected_Prefix_as_Case_Type() throws Throwable {
		selectPrefix(1);
	}
	
	@Then("^user should be able to select case type and enter prefix, sequence number check default and can click on Add AP$")
	public void user_should_be_able_to_select_case_type_and_enter_prefix_sequence_number_check_default_and_can_click_on_Add() throws Throwable {
		addAccessionPrefix("casetype", "UR", "002");
	}
	
	@When("^selected Prefix as Location AP$")
	public void selected_Prefix_as_Location() throws Throwable {
		selectPrefix(2);
	}
	
	@Then("^user should be able to select Location and enter prefix, sequence number, check default and can click on Add AP$")
	public void user_should_be_able_to_select_Location_and_enter_prefix_sequence_number_check_default_and_can_click_on_Add() throws Throwable {
		addAccessionPrefix("lablocation", "LQ", "003");
	}
	
	@When("^selected Prefix as Pathologist AP$")
	public void selected_Prefix_as_Pathologist() throws Throwable {
		selectPrefix(3);
	}
	
	@Then("^user should be able to select Pathologist and enter prefix, sequence number check default and can click on Add AP$")
	public void user_should_be_able_to_select_Pathologist_and_enter_prefix_sequence_number_check_default_and_can_click_on_Add() throws Throwable {
		addAccessionPrefix("labprovider", "MN", "004");
	}
	
	@When("^the user should be able to select prefix type,enter prefix, sequence number check default and can click on Add AP$")
	public void the_user_should_be_able_to_select_prefix_type_enter_prefix_sequence_number_check_default_and_can_click_on_Add() throws Throwable {
		rowIndexOfDefault = getRowIndexOfDefault();
		selectPrefix(2);
		addAccessionPrefix("lablocation", "LCBC", "012");
		
		Thread.sleep(2000);
	}
	
	@Then("^the added prefix should display in the list with Default AP$")
	public void the_added_prefix_should_display_in_the_list_with_Default() throws Throwable {
		driver.findElement(By.cssSelector(".alert-success"));
	}
	
	@When("^there is a prefix added with default AP$")
	public void there_is_a_prefix_added_with_default() throws Throwable {
		Thread.sleep(2000);
		Select dropdown = new Select(driver.findElement(By.name("example_length")));
		dropdown.selectByIndex(4);
		Assert.assertTrue(getRowIndexOfDefault() > 0);
	}
	
	@Then("^the newly added prefix should display in the list with Default And the default from the previous one should be gone AP$")
	public void the_newly_added_prefix_should_display_in_the_list_with_Default_And_the_default_from_the_previous_one_should_be_gone() throws Throwable {
		Assert.assertTrue(rowIndexOfDefault != getRowIndexOfDefault());
	}
	
	@When("^the user is not selected Prefix type AP$")
	public void the_user_is_not_selected_Prefix_type() throws Throwable {
		Select dropdown = new Select(driver.findElement(By.id("prefixType")));
		dropdown.selectByIndex(0);
	}
	
	@Then("^Add button should not be enabled AP$")
	public void add_button_should_not_be_enabled() throws Throwable {
		Thread.sleep(2000);
		Assert.assertTrue(!driver.findElement(By.cssSelector(".btn-success")).isEnabled());
	}
	
	public int getRowIndexOfDefault() throws InterruptedException {
		Thread.sleep(1000);
		WebElement table = driver.findElement(By.id("example"));
		List<WebElement> rows = table.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		for(int i=1;i<=rows.size();i++) {
			String cell = driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[4]")).getText();
			if(cell.contains("Default")){
				return i;
			}
		}
		
		return -1;
	}
	
	public void user_should_be_login_to_the_lab() throws Throwable {
        driver.navigate().to(Constants.URL);

        WebElement username = driver.findElement(By.name(Constants.FIND_USERNAME));
        username.clear();
        username.sendKeys(Constants.USERNAME);

        WebElement psw = driver.findElement(By.name(Constants.FIND_PASSWORD));
        psw.clear();
        psw.sendKeys(Constants.PASSWORD);

        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div/button")).click();
    }
	
	
	public void selectPrefix(int index) {
		Select dropdown = new Select(driver.findElement(By.id("prefixType")));
		dropdown.selectByIndex(index);
	}
	
	public void addAccessionPrefix(String prefixType, String prefix, String sequenceNumber) throws InterruptedException {
		Select dropdown = new Select(driver.findElement(By.id(prefixType)));
		dropdown.selectByIndex(1);
		
		System.out.println(dropdown.getFirstSelectedOption().getText().substring(0, 2));
		
		driver.findElement(By.name("prefixInstance.prefixName")).sendKeys(prefix);
		driver.findElement(By.name("prefixInstance.seqnumber")).sendKeys(sequenceNumber);
		
		WebElement element = driver.findElement(By.name("prefixInstance.makeDefault"));		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".btn-success")).click();
	}
	
	public class AccessionPrefix {
		public AccessionPrefix(int accessionPrefix, int prefixType, String prefix, String sequenceNumber) {
			this.accessionPrefix = accessionPrefix;
			this.prefixType = prefixType;
			this.prefix = prefix;
			this.sequenceNumber = sequenceNumber;
		}
		
		private int accessionPrefix;
		private int prefixType;
		private String prefix;
		private String sequenceNumber;
		public int getAccessionPrefix() {
			return accessionPrefix;
		}
		public void setAccessionPrefix(int accessionPrefix) {
			this.accessionPrefix = accessionPrefix;
		}
		public int getPrefixType() {
			return prefixType;
		}
		public void setPrefixType(int prefixType) {
			this.prefixType = prefixType;
		}
		public String getPrefix() {
			return prefix;
		}
		public void setPrefix(String prefix) {
			this.prefix = prefix;
		}
		public String getSequenceNumber() {
			return sequenceNumber;
		}
		public void setSequenceNumber(String sequenceNumber) {
			this.sequenceNumber = sequenceNumber;
		}
	}
}


