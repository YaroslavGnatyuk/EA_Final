package com.easytox.automation.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Checking_Sorting_Order {

	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "lavanya1";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="P@ssw0rd123";
	private static final String COMPOUND_LIST_URL ="http://bmtechsol.com:8080/easytox/compound/list";
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	public Checking_Sorting_Order(){
		
		DriverBase.instantiateDriverObject();
        this.webElementHelper = new WebElementHelper();
        driver = DriverBase.getDriver();

	}
	
	@Given("^the user is Compound Library page$")
	public void the_user_is_Compound_Library_page() throws Throwable {
		driver.get("http://bmtechsol.com:8080/easytox/");		 
		
		 driver.manage().window().maximize();		 
		WebElement user =  driver.findElement(By.name(USER_NAME));
		user.clear();
		user.sendKeys(PAGE_ID);
		
		WebElement pwd = driver.findElement(By.name(PASSWD));
		 pwd.clear();
		 pwd.sendKeys(PAGE_PSWD);		 
		 driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div/button")).click();		
		 Thread.sleep(2000);
		driver.navigate().to(COMPOUND_LIST_URL);
	}

	@When("^clicked on Class column of the list$")
	public void clicked_on_Class_column_of_the_list() throws Throwable {
	    
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[1]")).click();
		
		
	}

	@Then("^the list should be displayed in the alphabetical order$")
	public void the_list_should_be_displayed_in_the_alphabetical_order() throws Throwable {
	   
		
		Thread.sleep(3000);	
		String currentUrl = COMPOUND_LIST_URL;
	      String curtUrlDriver = driver.getCurrentUrl();

	     Assert.assertEquals(currentUrl, curtUrlDriver);
		
		
	}

	@Given("^the user is Compound Library page one$")
	public void the_user_is_Compound_Library_page_one() throws Throwable {
		
		Thread.sleep(3000);
		driver.navigate().to(COMPOUND_LIST_URL);
		
		
	}

	@When("^clicked on Type column of the list$")
	public void clicked_on_Type_column_of_the_list() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[2]")).click();
	}

	@Then("^the list should be displayed in the alphabetical order one$")
	public void the_list_should_be_displayed_in_the_alphabetical_order_one() throws Throwable {
	  
				Thread.sleep(3000);	
		String currentUrl = COMPOUND_LIST_URL;
	      String curtUrlDriver = driver.getCurrentUrl();

	     Assert.assertEquals(currentUrl, curtUrlDriver);
		
		
	}

	@Given("^the user is Compound Library page two$")
	public void the_user_is_Compound_Library_page_two() throws Throwable {
	  
		Thread.sleep(3000);
		driver.navigate().to(COMPOUND_LIST_URL);
		
		
	}

	@When("^clicked on Name column of the list$")
	public void clicked_on_Name_column_of_the_list() throws Throwable {
	   
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[3]")).click();
		
		
	}

	@Then("^the list should be displayed in the alphabetical order two$")
	public void the_list_should_be_displayed_in_the_alphabetical_order_two() throws Throwable {
	  

		Thread.sleep(3000);	
String currentUrl = COMPOUND_LIST_URL;
  String curtUrlDriver = driver.getCurrentUrl();

 Assert.assertEquals(currentUrl, curtUrlDriver);
		
		
	}

	@Given("^the user is Compound Library page three$")
	public void the_user_is_Compound_Library_page_three() throws Throwable {
	
		Thread.sleep(3000);
		driver.navigate().to(COMPOUND_LIST_URL);	
		
		
		
	}

	@When("^clicked on Result column of the list$")
	public void clicked_on_Result_column_of_the_list() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[4]")).click();
	}

	@Then("^the list should be displayed in the alphabetical order three$")
	public void the_list_should_be_displayed_in_the_alphabetical_order_three() throws Throwable {
	  
		Thread.sleep(3000);	
		String currentUrl = COMPOUND_LIST_URL;
		  String curtUrlDriver = driver.getCurrentUrl();

		 Assert.assertEquals(currentUrl, curtUrlDriver);
	}

	@Given("^the user is Compound Library page four$")
	public void the_user_is_Compound_Library_page_four() throws Throwable {
		Thread.sleep(3000);
		driver.navigate().to(COMPOUND_LIST_URL);	
		
	}

	@When("^clicked on Range column of the list$")
	public void clicked_on_Range_column_of_the_list() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[5]")).click();
	}

	@Then("^the list should be displayed in the numerical order$")
	public void the_list_should_be_displayed_in_the_numerical_order() throws Throwable {
	  
		Thread.sleep(3000);	
		String currentUrl = COMPOUND_LIST_URL;
		  String curtUrlDriver = driver.getCurrentUrl();

		 Assert.assertEquals(currentUrl, curtUrlDriver);
		
		
	}

	@Given("^the user is Compound Library page five$")
	public void the_user_is_Compound_Library_page_five() throws Throwable {
		Thread.sleep(3000);
		driver.navigate().to(COMPOUND_LIST_URL);	
		   
	}

	@When("^clicked on Cut off column of the list$")
	public void clicked_on_Cut_off_column_of_the_list() throws Throwable {
	   
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[6]")).click();
		
	}

	@Then("^the list should be displayed in the numerical order five$")
	public void the_list_should_be_displayed_in_the_numerical_order_five() throws Throwable {
	    
		Thread.sleep(3000);	
		String currentUrl = COMPOUND_LIST_URL;
		  String curtUrlDriver = driver.getCurrentUrl();

		 Assert.assertEquals(currentUrl, curtUrlDriver);
		
	}

	@Given("^the user is Compound Library page six$")
	public void the_user_is_Compound_Library_page_six() throws Throwable {
	 
		Thread.sleep(3000);
		driver.navigate().to(COMPOUND_LIST_URL);	
		
	}

	@When("^clicked on Positive Comments column of the list$")
	public void clicked_on_Positive_Comments_column_of_the_list() throws Throwable {
	  
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[7]")).click();
		
	}

	@Then("^the list should be displayed in the alphabetical order six$")
	public void the_list_should_be_displayed_in_the_alphabetical_order_six() throws Throwable {
	   
		Thread.sleep(3000);	
		String currentUrl = COMPOUND_LIST_URL;
		  String curtUrlDriver = driver.getCurrentUrl();

		 Assert.assertEquals(currentUrl, curtUrlDriver);
		
		
	}

	@Given("^the user is Compound Library page seven$")
	public void the_user_is_Compound_Library_page_seven() throws Throwable {

		Thread.sleep(3000);
		driver.navigate().to(COMPOUND_LIST_URL);	
		
		
	}

	@When("^clicked on Negative Comments column of the list$")
	public void clicked_on_Negative_Comments_column_of_the_list() throws Throwable {
	    
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[8]")).click();
		
	}

	@Then("^the list should be displayed in the alphabetical order seven$")
	public void the_list_should_be_displayed_in_the_alphabetical_order_seven() throws Throwable {
	   
		Thread.sleep(3000);	
		String currentUrl = COMPOUND_LIST_URL;
		  String curtUrlDriver = driver.getCurrentUrl();

		 Assert.assertEquals(currentUrl, curtUrlDriver);
	}

	@Given("^the user is Compound Library page ei$")
	public void the_user_is_Compound_Library_page_ei() throws Throwable {
	 
		Thread.sleep(3000);
		driver.navigate().to(COMPOUND_LIST_URL);	
	}

	@When("^clicked on billing code column of the list$")
	public void clicked_on_billing_code_column_of_the_list() throws Throwable {
	  
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[9]")).click();
	}

	@Then("^the list should be displayed in the numerical order ei$")
	public void the_list_should_be_displayed_in_the_numerical_order_ei() throws Throwable {
	    
		Thread.sleep(3000);	
		String currentUrl = COMPOUND_LIST_URL;
		  String curtUrlDriver = driver.getCurrentUrl();

		 Assert.assertEquals(currentUrl, curtUrlDriver);
	}

	@Given("^the user is Compound Library page ni$")
	public void the_user_is_Compound_Library_page_ni() throws Throwable {
	   

		Thread.sleep(3000);
		driver.navigate().to(COMPOUND_LIST_URL);	
	}

	@When("^clicked on Oral detection column of the list$")
	public void clicked_on_Oral_detection_column_of_the_list() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[10]")).click(); 
		
	}

	@Then("^the list should be displayed in the alphabetical order ni$")
	public void the_list_should_be_displayed_in_the_alphabetical_order_ni() throws Throwable {
		Thread.sleep(3000);	
		String currentUrl = COMPOUND_LIST_URL;
		  String curtUrlDriver = driver.getCurrentUrl();

		 Assert.assertEquals(currentUrl, curtUrlDriver);
	}

	@Given("^the user is Compound Library page ten$")
	public void the_user_is_Compound_Library_page_ten() throws Throwable {
		Thread.sleep(3000);
		driver.navigate().to(COMPOUND_LIST_URL);	
	}

	@When("^clicked on Urine detection column of the list$")
	public void clicked_on_Urine_detection_column_of_the_list() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[11]")).click(); 
	}

	@Then("^the list should be displayed in the alphabetical order ten$")
	public void the_list_should_be_displayed_in_the_alphabetical_order_ten() throws Throwable {
	   
		Thread.sleep(3000);	
		String currentUrl = COMPOUND_LIST_URL;
		  String curtUrlDriver = driver.getCurrentUrl();

		 Assert.assertEquals(currentUrl, curtUrlDriver);
		 driver.quit();
		
	}


	
	
	
	
	
	
}
