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

public class Edit_Action_Column {
	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "lavanya1";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="P@ssw0rd123";
	private static final String COMPOUND_LIST_URL ="http://bmtechsol.com:8080/easytox/compound/list";
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	public Edit_Action_Column(){
		
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
	@When("^clicked on Edit button under Action column$")
	public void clicked_on_Edit_button_under_Action_column() throws Throwable {
	   Thread.sleep(3000);
	  
	   
	   //testscreeen
	   driver.findElement(By.xpath("//*[@id=\"editbutton\"]/i")).click();
	   
	   
	   // validity testing
	/*   
	   driver.findElement(By.xpath(".//*[@id='example']/tbody/tr[3]/td[12]")).click();
		*/
	}

	@Then("^Edit Compound popup should be displayed$")
	public void Edit_Compound_popup_should_be_displayed() throws Throwable{
		//driver.navigate().to(COMPOUND_LIST_URL);
		Thread.sleep(3000);	
		String currentUrl = COMPOUND_LIST_URL;
	      String curtUrlDriver = driver.getCurrentUrl();
System.out.println("1"+currentUrl);
System.out.println("2+currtUrlDriver"+curtUrlDriver);

	     //Assert.assertEquals(currentUrl, curtUrlDriver);
	     Assert.assertNotEquals(currentUrl,curtUrlDriver);
		
	}

	@Given("^the user is Compound Library page one$")
	public void the_user_is_Compound_Library_page_one() throws Throwable {
		Thread.sleep(2000);
		driver.navigate().to(COMPOUND_LIST_URL);
		
	}

	@When("^clicked on Edit under Actions column and Edit Compound popup is displayed$")
	public void clicked_on_Edit_under_Actions_column_and_Edit_Compound_popup_is_displayed() throws Throwable {
	  
		Thread.sleep(2000);
		
		//test screen
	   driver.findElement(By.xpath("//*[@id=\"editbutton\"]/i")).click();
	   Thread.sleep(2000);
	  //driver.findElement(By.xpath("//*[@id=\"editCompounddiv\"]/div/button")).click();	
	   
	   
	   //validitytesting
	   
	   /*   
	   driver.findElement(By.xpath(".//*[@id='example']/tbody/tr[3]/td[12]")).click();
		
	   
	   Thread.sleep(3000);	
		String currentUrl = COMPOUND_LIST_URL;
	      String curtUrlDriver = driver.getCurrentUrl();

	     Assert.assertEquals(currentUrl, curtUrlDriver);
	     */
	}

	@Then("^user should be able to edit the data$")
	public void user_should_be_able_to_edit_the_data() throws Throwable {
	 
			
		//validity testing
		
		/*
		
		
		WebElement CLASS_NAME = driver.findElement(By.xpath(".//*[@id='classtype']"));
		CLASS_NAME.clear();
		CLASS_NAME.sendKeys(Action_Column.CLASS_C);	
		
		
		new Select(driver.findElement(By.xpath(".//*[@id='editrangetype']"))).selectByVisibleText(Action_Column.RANGE);
		
		WebElement CUTTOF = driver.findElement(By.xpath(".//*[@id='editcutoffrange']"));
		CUTTOF.clear();
		CUTTOF.sendKeys(Action_Column.CUTTOFF);	
		new Select(driver.findElement(By.xpath(".//*[@id='editunits']"))).selectByVisibleText(Action_Column.UNITS);
		new Select(driver.findElement(By.xpath(".//*[@id='editresult']"))).selectByVisibleText(Action_Column.RESULT1);
		
		
		*/
		
		
		//Test Screen
		
		Thread.sleep(2000);
		
		
		WebElement CLAS_NAME = driver.findElement(By.xpath("//input[@name='classtype']"));
		CLAS_NAME.clear();
		CLAS_NAME.sendKeys(Action_Column.CLASS_C);	
		
		
		WebElement CUTOF = driver.findElement(By.xpath(".//*[@id='editcutoff']"));
		CUTOF.clear();
		CUTOF.sendKeys(Action_Column.CUTTOFF);	
		
		new Select(driver.findElement(By.xpath(".//*[@id='editresult']"))).selectByVisibleText(Action_Column.RESULT);
		
		
		
		
		
		//continue
		
		WebElement BILLING = driver.findElement(By.xpath(".//*[@id='billingCode']"));
		BILLING.clear();
		BILLING.sendKeys(Action_Column.Billing_CODE);	
		
		WebElement DETECTION = driver.findElement(By.xpath(".//*[@id='detectionOral']"));
		DETECTION.clear();
		DETECTION.sendKeys(Action_Column.detectionOral);
		
		
		WebElement URINE = driver.findElement(By.xpath(".//*[@id='detectionUrine']"));
		URINE.clear();
		URINE.sendKeys(Action_Column.detectionUrine);
		
		
		WebElement NEGATIVE_COMM = driver.findElement(By.xpath(".//*[@id='negativeComments']"));
		NEGATIVE_COMM.clear();
		NEGATIVE_COMM.sendKeys(Action_Column.negativeComments);
		
		
		WebElement POSTIVE_COMM = driver.findElement(By.xpath(".//*[@id='positiveComments']"));
		POSTIVE_COMM.clear();
		POSTIVE_COMM.sendKeys(Action_Column.positiveComments);
		
		 driver.findElement(By.xpath(".//*[@id='form1']/div[1]/div[13]/div/label/span")).click();
		
	}

	@Given("^the user is Compound Library page two$")
	public void the_user_is_Compound_Library_page_two() throws Throwable {
		Thread.sleep(2000);
		driver.navigate().to(COMPOUND_LIST_URL);
		
	}

	@When("^Edit Compound popup is displayed and user can edit the data and click on submit$")
	public void Edit_Compound_popup_is_displayed_and_user_can_edit_the_data_and_click_on_submit() throws Throwable {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"editbutton\"]/i")).click();
		
		//validity testing
		
				/*
				
				
				WebElement CLASS_NAME = driver.findElement(By.xpath(".//*[@id='classtype']"));
				CLASS_NAME.clear();
				CLASS_NAME.sendKeys(Action_Column.CLASS_C);	
				
				
				new Select(driver.findElement(By.xpath(".//*[@id='editrangetype']"))).selectByVisibleText(Action_Column.RANGE);
				
				WebElement CUTTOF = driver.findElement(By.xpath(".//*[@id='editcutoffrange']"));
				CUTTOF.clear();
				CUTTOF.sendKeys(Action_Column.CUTTOFF);	
				new Select(driver.findElement(By.xpath(".//*[@id='editunits']"))).selectByVisibleText(Action_Column.UNITS);
				new Select(driver.findElement(By.xpath(".//*[@id='editresult']"))).selectByVisibleText(Action_Column.RESULT1);
				
				
				*/
				
				
				//Test Screen
				
				Thread.sleep(2000);
				
				
				WebElement CLAS_NAME = driver.findElement(By.xpath("//input[@name='classtype']"));
				CLAS_NAME.clear();
				CLAS_NAME.sendKeys(Action_Column.CLASS_C);	
				
				
				WebElement CUTOF = driver.findElement(By.xpath(".//*[@id='editcutoff']"));
				CUTOF.clear();
				CUTOF.sendKeys(Action_Column.CUTTOFF);	
				
				new Select(driver.findElement(By.xpath(".//*[@id='editresult']"))).selectByVisibleText(Action_Column.RESULT);
				
				
				
				
				
				//continue
				
				WebElement BILLING = driver.findElement(By.xpath(".//*[@id='billingCode']"));
				BILLING.clear();
				BILLING.sendKeys(Action_Column.Billing_CODE);	
				
				WebElement DETECTION = driver.findElement(By.xpath(".//*[@id='detectionOral']"));
				DETECTION.clear();
				DETECTION.sendKeys(Action_Column.detectionOral);
				
				
				WebElement URINE = driver.findElement(By.xpath(".//*[@id='detectionUrine']"));
				URINE.clear();
				URINE.sendKeys(Action_Column.detectionUrine);
				
				
				
				WebElement NEGATIVE_COMM = driver.findElement(By.xpath(".//*[@id='negativeComments']"));
				NEGATIVE_COMM.clear();
				NEGATIVE_COMM.sendKeys(Action_Column.negativeComments);
				
				
				WebElement POSTIVE_COMM = driver.findElement(By.xpath(".//*[@id='positiveComments']"));
				POSTIVE_COMM.clear();
				POSTIVE_COMM.sendKeys(Action_Column.positiveComments);
				
				   driver.findElement(By.xpath(".//*[@id='form1']/div[1]/div[13]/div/label/span")).click();
				
				
				
		
		//submit button
		   driver.findElement(By.xpath(".//*[@id='form1']/div[2]/button[2]")).click();
		  
	}

	@Then("^user should be able to submit the data and the edited compound should be displayed on the list$")
	public void user_should_be_able_to_submit_the_data_and_the_edited_compound_should_be_displayed_on_the_list() throws Throwable {
		Thread.sleep(3000);	
		String currentUrl = COMPOUND_LIST_URL;
	      String curtUrlDriver = driver.getCurrentUrl();

	     Assert.assertEquals(currentUrl, curtUrlDriver);
		
	}

	@Given("^the user is Compound Library page three$")
	public void the_user_is_Compound_Library_page_three() throws Throwable {
		Thread.sleep(2000);
		driver.navigate().to(COMPOUND_LIST_URL);
	}

	@When("^Edit Compound popup is displayed and the user clicks on Close button$")
	public void Edit_Compound_popup_is_displayed_and_the_user_clicks_on_Close_button() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"editbutton\"]/i")).click();
		Thread.sleep(3500);
		   driver.findElement(By.xpath(".//*[@id='form1']/div[2]/button[1]")).click();
	}

	@Then("^the popup should be closed and the user should land on the Compound Library page one$")
	public void the_popup_should_be_closed_and_the_user_should_land_on_the_Compound_Library_page_one() throws Throwable {
		Thread.sleep(3000);	
		String currentUrl = COMPOUND_LIST_URL;
	      String curtUrlDriver = driver.getCurrentUrl();

	     Assert.assertNotEquals(currentUrl, curtUrlDriver);
	}

	@Given("^the user is Compound Library page four$")
	public void the_user_is_Compound_Library_page_four() throws Throwable {
		Thread.sleep(2000);
		driver.navigate().to(COMPOUND_LIST_URL);
	}

	@When("^Edit Compound popup is displayed and the user clicks on x button$")
	public void Edit_Compound_popup_is_displayed_and_the_user_clicks_on_x_button() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"editbutton\"]/i")).click();
		Thread.sleep(3500);
		   driver.findElement(By.xpath(".//*[@id='editCompounddiv']/div/button")).click();
	}

	@Then("^the popup should be closed and the user should land on the Compound Library page.$")
	public void the_popup_should_be_closed_and_the_user_should_land_on_the_Compound_Library_page() throws Throwable {
	  
		Thread.sleep(2000);	
		String currentUrl = COMPOUND_LIST_URL;
	      String curtUrlDriver = driver.getCurrentUrl();

	     Assert.assertEquals(currentUrl, curtUrlDriver);
		
		driver.quit();
		
		
	}
	
	
	
	private static final class Action_Column {
        private static final String F_NAME = "Test14577";
        private static final String CLASS_C = "Test19";
        private static final String TYPE_CLASS = "Validity Testing";
        private static final String TYPE_CLASS1 = "Test Screen";
        
        private static final String RANGE = "<";
        private static final String CUTTOFF= "4";
        private static final String UNITS = "mg/dL";
        private static final String Billing_CODE = "0140";
        private static final String detectionOral = "24HRS";
        private static final String detectionUrine = "24HS";
        private static final String negativeComments = "No CMMENTS";
        private static final String positiveComments = "POSSD";
        private static final String RESULT = "POS";
        private static final String RESULT1 = "NORMAL";
        
	
	
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
