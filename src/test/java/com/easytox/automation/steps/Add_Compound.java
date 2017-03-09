package com.easytox.automation.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Add_Compound {
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "lavanya1";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="P@ssw0rd123";
	private static final String COMPOUND_LIST_URL ="http://bmtechsol.com:8080/easytox/compound/list";
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	public Add_Compound (){
		
		DriverBase.instantiateDriverObject();
        this.webElementHelper = new WebElementHelper();
        driver = DriverBase.getDriver();

	}
	
	
	/// Scenario: Adding a compound
	
	
	
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

	@When("^clicked on '\\+'; button next to search box$")
	public void clicked_on_plus_button_next_to_search_box() throws Throwable {
		
	Thread.sleep(2000);
		
	driver.findElement(By.xpath("//*[@id=\"add\"]")).click();
	Thread.sleep(3000);
	
	
	}

	@Then("^Add Compound popup should be displayed$")
	public void Add_Compound_popup_should_be_displayed() throws Throwable {
		Thread.sleep(2000);
		String currentUrl = COMPOUND_LIST_URL;
        String curtUrlDriver = driver.getCurrentUrl();

    Assert.assertEquals(currentUrl, curtUrlDriver);
	Thread.sleep(2000);	
		
		 	   
	}

	
	@Given("^the user is Compound Library page one$")
	public void the_user_is_Compound_Library_page_one() throws Throwable {
		
		Thread.sleep(2000);
	     driver.navigate().to(COMPOUND_LIST_URL);
	 	
	}
	
	
	@When("^Add Compound popup is displayed$")
	public void Add_Compound_popup_is_displayed() throws Throwable {
		Thread.sleep(2000);
	     driver.findElement(By.xpath("//*[@id=\"add\"]")).click();
		
     
	 
	} 
	

	@Then("^user should be able to enter the data in all the fields$")
	public void user_should_be_able_to_enter_the_data_in_all_the_fields() throws Throwable {
		Thread.sleep(5000);
		
		WebElement Name_1 = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		Name_1.clear();
		Name_1.sendKeys(AddCompound.F_NAME);
		
		
		
		WebElement CLASS_NAME = driver.findElement(By.xpath(".//input[@id='classtype']"));
		CLASS_NAME.clear();
		CLASS_NAME.sendKeys(AddCompound.CLASS_C);		
		
	// for Validity Testing	
		
		/*	new Select(driver.findElement(By.xpath(".//*[@id='type']"))).selectByVisibleText(AddCompound.TYPE_CLASS);
		new Select(driver.findElement(By.xpath(".//*[@id='rangetype']"))).selectByVisibleText(AddCompound.RANGE);
		WebElement CUTTOF = driver.findElement(By.xpath(".//*[@id='cutoffrange']"));
		CUTTOF.clear();
		CUTTOF.sendKeys(AddCompound.CUTTOFF);	
		new Select(driver.findElement(By.xpath(".//*[@id='form']/div[1]/div[6]/div[5]/select"))).selectByVisibleText(AddCompound.UNITS);
		new Select(driver.findElement(By.xpath(".//*[@id='result']"))).selectByVisibleText(AddCompound.RESULT1);
		
	*/	
	// TEST SCREEN	
		
		new Select(driver.findElement(By.xpath(".//*[@id='type']"))).selectByVisibleText(AddCompound.TYPE_CLASS1);
		
		WebElement CUTTOF = driver.findElement(By.xpath(".//*[@id='cutoff']"));
		CUTTOF.clear();
		CUTTOF.sendKeys(AddCompound.CUTTOFF);	
		new Select(driver.findElement(By.xpath(".//*[@id='result']"))).selectByVisibleText(AddCompound.RESULT);
		
		
		
		
	//continue....
		
		
		WebElement BILLING = driver.findElement(By.xpath(".//*[@id='billingCode']"));
		BILLING.clear();
		BILLING.sendKeys(AddCompound.Billing_CODE);	
		
		
		WebElement DETECTION = driver.findElement(By.xpath(".//*[@id='detectionOral']"));
		DETECTION.clear();
		DETECTION.sendKeys(AddCompound.detectionOral);	
		
		
		WebElement URINE = driver.findElement(By.xpath(".//*[@id='detectionUrine']"));
		URINE.clear();
		URINE.sendKeys(AddCompound.detectionUrine);
		
		WebElement POSTIVE_COMM = driver.findElement(By.xpath(".//*[@id='positiveComments']"));
		POSTIVE_COMM.clear();
		POSTIVE_COMM.sendKeys(AddCompound.negativeComments);
		
		WebElement NEGATIVE_COMM = driver.findElement(By.xpath(".//*[@id='negativeComments']"));
		NEGATIVE_COMM.clear();
		NEGATIVE_COMM.sendKeys(AddCompound.positiveComments);
		
		
		Thread.sleep(2000);
	  
	}
	@Given("^the user is Compound Library page two$")
	public void the_user_is_Compound_Library_page_two() throws Throwable {
		Thread.sleep(3000);
		driver.navigate().to(COMPOUND_LIST_URL);
	    
	}
	
	
	@When("^Add Compound popup is displayed and user entered all the required fields and click on submit$")
	public void Add_Compound_popup_is_displayed_and_user_entered_all_the_required_fields_and_click_on_submit() throws Throwable {
		Thread.sleep(2000);
	     driver.findElement(By.xpath("//*[@id=\"add\"]")).click();
			
	     Thread.sleep(3000);
			
			WebElement Name_1 = driver.findElement(By.xpath("//*[@id=\"name\"]"));
			Name_1.clear();
			Name_1.sendKeys(AddCompound.F_NAME);
				
			WebElement CLASS_NAME = driver.findElement(By.xpath(".//input[@id='classtype']"));
			CLASS_NAME.clear();
			CLASS_NAME.sendKeys(AddCompound.CLASS_C);		
		
		// for Validity Testing	
			/*		new Select(driver.findElement(By.xpath(".//*[@id='type']"))).selectByVisibleText(AddCompound.TYPE_CLASS);
			new Select(driver.findElement(By.xpath(".//*[@id='rangetype']"))).selectByVisibleText(AddCompound.RANGE);
			WebElement CUTTOF = driver.findElement(By.xpath(".//*[@id='cutoffrange']"));
			CUTTOF.clear();
			CUTTOF.sendKeys(AddCompound.CUTTOFF);	
			new Select(driver.findElement(By.xpath(".//*[@id='form']/div[1]/div[6]/div[5]/select"))).selectByVisibleText(AddCompound.UNITS);
			new Select(driver.findElement(By.xpath(".//*[@id='result']"))).selectByVisibleText(AddCompound.RESULT1);
			
		*/	
		// TEST SCREEN	
			
			new Select(driver.findElement(By.xpath(".//*[@id='type']"))).selectByVisibleText(AddCompound.TYPE_CLASS1);
			
			WebElement CUTOF = driver.findElement(By.xpath(".//*[@id='cutoff']"));
			CUTOF.clear();
			CUTOF.sendKeys(AddCompound.CUTTOFF);	
			new Select(driver.findElement(By.xpath(".//*[@id='result']"))).selectByVisibleText(AddCompound.RESULT);
			
				
			//continuation
			
			WebElement BILLING = driver.findElement(By.xpath(".//*[@id='billingCode']"));
			BILLING.clear();
			BILLING.sendKeys(AddCompound.Billing_CODE);	
			
			
			WebElement DETECTION = driver.findElement(By.xpath(".//*[@id='detectionOral']"));
			DETECTION.clear();
			DETECTION.sendKeys(AddCompound.detectionOral);	
			
			
			WebElement URINE = driver.findElement(By.xpath(".//*[@id='detectionUrine']"));
			URINE.clear();
			URINE.sendKeys(AddCompound.detectionUrine);
			
			WebElement POSTIVE_COMM = driver.findElement(By.xpath(".//*[@id='positiveComments']"));
			POSTIVE_COMM.clear();
			POSTIVE_COMM.sendKeys(AddCompound.negativeComments);
			
			WebElement NEGATIVE_COMM = driver.findElement(By.xpath(".//*[@id='negativeComments']"));
			NEGATIVE_COMM.clear();
			NEGATIVE_COMM.sendKeys(AddCompound.positiveComments);
		
		//submit button	
		
			Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='form']/div[2]/button[2]")).click();	
	}

	@Then("^user should be able to submit the data and the added compound should be displayed on the list$")
	public void user_should_be_able_to_submit_the_data_and_the_added_compound_should_be_displayed_on_the_list() throws Throwable {
		
		Thread.sleep(2000);	
		String currentUrl = COMPOUND_LIST_URL;
	      String curtUrlDriver = driver.getCurrentUrl();

	     Assert.assertEquals(currentUrl, curtUrlDriver);
		
		
		
	}

	@Given("^the user is Compound Library page three$")
	public void the_user_is_Compound_Library_page_three() throws Throwable {
	 Thread.sleep(2000);
	 driver.navigate().to(COMPOUND_LIST_URL);
	}
	
	@When("^Add Compound popup is displayed and user is not entered all the required fields and click on submit$")
	public void Add_Compound_popup_is_displayed_and_user_is_not_entered_all_the_required_fields_and_click_on_submit() throws Throwable {
	 
		
		Thread.sleep(3000);
	     driver.findElement(By.xpath("//*[@id=\"add\"]")).click();
		
		
	     Thread.sleep(3000);			
			
			WebElement DETECTION = driver.findElement(By.xpath(".//*[@id='detectionOral']"));
			DETECTION.clear();
			DETECTION.sendKeys(AddCompound.detectionOral);	
			
			
			WebElement URINE = driver.findElement(By.xpath(".//*[@id='detectionUrine']"));
			URINE.clear();
			URINE.sendKeys(AddCompound.detectionUrine);
			
			
		
		//submit button	
		
			Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='form']/div[2]/button[2]")).click();	

		
		
		
		
	}

	@Then("^user should not be able to submit the data and should be displayed with the missing fields.$")
	public void user_should_not_be_able_to_submit_the_data_and_should_be_displayed_with_the_missing_fields() throws Throwable {
	  
		Thread.sleep(2000);	
		String currentUrl = COMPOUND_LIST_URL;
	      String curtUrlDriver = driver.getCurrentUrl();

	     Assert.assertEquals(currentUrl, curtUrlDriver);
		
		
	}

	@Given("^the user is Compound Library page four$")
	public void the_user_is_Compound_Library_page_four() throws Throwable {
	    
		Thread.sleep(2000);
		 driver.navigate().to(COMPOUND_LIST_URL);
		
		
		
	}
	
	@When("^Add Compound popup is displayed and the user clicks on 'Close' button$")
	public void Add_Compound_popup_is_displayed_and_the_user_clicks_on_Close_button() throws Throwable {
	   
		Thread.sleep(3000);
	     driver.findElement(By.xpath("//*[@id=\"add\"]")).click();
	     
	     Thread.sleep(4000);
	     driver.findElement(By.xpath(".//*[@id='form']/div[2]/button[1]")).click();
		
	}

	@Then("^the popup should be closed and the user should land on the Compound Library page.$")
	public void the_popup_should_be_closed_and_the_user_should_land_on_the_Compound_Library_page() throws Throwable {
	
		Thread.sleep(2000);	
		String currentUrl = COMPOUND_LIST_URL;
	      String curtUrlDriver = driver.getCurrentUrl();

	     Assert.assertEquals(currentUrl, curtUrlDriver);
		
	}

	@Given("^the user is Compound Library page five$")
	public void the_user_is_Compound_Library_page_five() throws Throwable {
	    
		Thread.sleep(2000);
		 driver.navigate().to(COMPOUND_LIST_URL);
		
		
	}
	
	@When("^Add Compound popup is displayed and the user clicks on 'x' button$")
	public void Add_Compound_popup_is_displayed_and_the_user_clicks_on_x_button() throws Throwable {
	   

		Thread.sleep(3000);
	     driver.findElement(By.xpath("//*[@id=\"add\"]")).click();
	     
// x button
			Thread.sleep(4000);
		     driver.findElement(By.xpath(".//*[@id='addCompounddiv']/div/button")).click();
		
		
	}
	@Then("^the popup should be closed and the user should land on the Compound Library page one.$")
	public void the_popup_should_be_closed_and_the_user_should_land_on_the_Compound_Library_page_one() throws Throwable {
	    
		Thread.sleep(4000);	
		String currentUrl = COMPOUND_LIST_URL;
	      String curtUrlDriver = driver.getCurrentUrl();

	     Assert.assertEquals(currentUrl, curtUrlDriver);
		
		driver.quit();
		
	}
	

	
	private static final class AddCompound {
        private static final String F_NAME = "Test14517";
        private static final String CLASS_C = "Test14517";
        private static final String TYPE_CLASS = "Validity Testing";
        private static final String TYPE_CLASS1 = "Test Screen";
        
        private static final String RANGE = "=";
        private static final String CUTTOFF= "3";
        private static final String UNITS = "mg/dL";
        private static final String Billing_CODE = "0140";
        private static final String detectionOral = "24HRS";
        private static final String detectionUrine = "24HRS";
        private static final String negativeComments = "NO COMMENTS";
        private static final String positiveComments = "NO COMMENTS";
        private static final String RESULT = "POS";
        private static final String RESULT1 = "NORMAL";
        
	
	
	}

	
	
	
	
	
	
	

}
