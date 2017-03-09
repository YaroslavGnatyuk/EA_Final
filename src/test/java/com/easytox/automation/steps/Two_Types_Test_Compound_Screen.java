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

public class Two_Types_Test_Compound_Screen {

	
	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "lavanya1";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="P@ssw0rd123";
	private static final String COMPOUND_LIST_URL ="http://bmtechsol.com:8080/easytox/compound/list";
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public Two_Types_Test_Compound_Screen(){
		
		DriverBase.instantiateDriverObject();
        this.webElementHelper = new WebElementHelper();
        driver = DriverBase.getDriver();

	}
	
	@Given("^the user is Add Compound popup$")
	public void the_user_is_Add_Compound_popup() throws Throwable {
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
		
		 Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"add\"]")).click();
	}
	@When("^selected Type as Test Screen$")
	public void selected_Type_as_Test_Screen() throws Throwable {
	
		
		
		Thread.sleep(2000);		
		WebElement Name_1 = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		Name_1.clear();
		Name_1.sendKeys(Compound_Test_Type.F_NAME);
			
		WebElement CLASS_NAME = driver.findElement(By.xpath(".//input[@id='classtype']"));
		CLASS_NAME.clear();
		CLASS_NAME.sendKeys(Compound_Test_Type.CLASS_C);	
		
		
new Select(driver.findElement(By.xpath(".//*[@id='type']"))).selectByVisibleText(Compound_Test_Type.TYPE_CLASS1);
		
	
WebElement CUTTOF = driver.findElement(By.xpath(".//*[@id='cutoff']"));
		CUTTOF.clear();
		CUTTOF.sendKeys(Compound_Test_Type.CUTTOFF);	
		
		new Select(driver.findElement(By.xpath(".//*[@id='result']"))).selectByVisibleText(Compound_Test_Type.RESULT);
		
		
		
		
	//continue....
		
		
		WebElement BILLING = driver.findElement(By.xpath(".//*[@id='billingCode']"));
		BILLING.clear();
		BILLING.sendKeys(Compound_Test_Type.Billing_CODE);	
		
		
		WebElement DETECTION = driver.findElement(By.xpath(".//*[@id='detectionOral']"));
		DETECTION.clear();
		DETECTION.sendKeys(Compound_Test_Type.detectionOral);	
		
		
		WebElement URINE = driver.findElement(By.xpath(".//*[@id='detectionUrine']"));
		URINE.clear();
		URINE.sendKeys(Compound_Test_Type.detectionUrine);
		
		WebElement POSTIVE_COMM = driver.findElement(By.xpath(".//*[@id='positiveComments']"));
		POSTIVE_COMM.clear();
		POSTIVE_COMM.sendKeys(Compound_Test_Type.negativeComments);
		
		WebElement NEGATIVE_COMM = driver.findElement(By.xpath(".//*[@id='negativeComments']"));
		NEGATIVE_COMM.clear();
		NEGATIVE_COMM.sendKeys(Compound_Test_Type.positiveComments);
		
		Thread.sleep(3000);//*[@id="form"]/div[2]/button[1]
		driver.findElement(By.xpath(".//*[@id='form']/div[2]/button[2]")).click();	
		

		
		
	}

	@Then("^the result box should be displayed with NEG and POS options and cutoff text box should be displayed$")
	public void the_result_box_should_be_displayed_with_NEG_and_POS_options_and_cutoff_text_box_should_be_displayed() throws Throwable {

		Thread.sleep(2000);	
		String currentUrl = COMPOUND_LIST_URL;
	      String curtUrlDriver = driver.getCurrentUrl();

	     Assert.assertEquals(currentUrl, curtUrlDriver);
		
		
		
	}

	@Given("^the user is Add Compound popup one$")
	public void the_user_is_Add_Compound_popup_one() throws Throwable {
	  
		Thread.sleep(1000);
		driver.navigate().to(COMPOUND_LIST_URL);
        
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//*[@id=\"add\"]")).click();
		
		
	}

	@When("^selected Type as  Validity Testing$")
	public void selected_Type_as_Validity_Testing() throws Throwable {
		
		Thread.sleep(2000);
		
		WebElement Name_two = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		Name_two.clear();
		Name_two.sendKeys(Compound_Test_Type.F_NAME1);
			
		WebElement CLASS_Two = driver.findElement(By.xpath(".//input[@id='classtype']"));
		CLASS_Two.clear();
		CLASS_Two.sendKeys(Compound_Test_Type.CLASS_C1);
		
		
		
		
		new Select(driver.findElement(By.xpath(".//*[@id='type']"))).selectByVisibleText(Compound_Test_Type.TYPE_CLASS);
		
		new Select(driver.findElement(By.xpath(".//*[@id='rangetype']"))).selectByVisibleText(Compound_Test_Type.RANGE);
		WebElement CUTTOF = driver.findElement(By.xpath(".//*[@id='cutoffrange']"));
		CUTTOF.clear();
		CUTTOF.sendKeys(Compound_Test_Type.CUTTOFF);	
		new Select(driver.findElement(By.xpath(".//*[@id='form']/div[1]/div[6]/div[5]/select"))).selectByVisibleText(Compound_Test_Type.UNITS);
		new Select(driver.findElement(By.xpath(".//*[@id='result']"))).selectByVisibleText(Compound_Test_Type.RESULT1);
		
		
		//continue
		
		WebElement BILLING = driver.findElement(By.xpath(".//*[@id='billingCode']"));
		BILLING.clear();
		BILLING.sendKeys(Compound_Test_Type.Billing_CODE);	
		
		
		WebElement DETECTION = driver.findElement(By.xpath(".//*[@id='detectionOral']"));
		DETECTION.clear();
		DETECTION.sendKeys(Compound_Test_Type.detectionOral);	
		
		
		WebElement URINE = driver.findElement(By.xpath(".//*[@id='detectionUrine']"));
		URINE.clear();
		URINE.sendKeys(Compound_Test_Type.detectionUrine);
		
		WebElement POSTIVE_COMM = driver.findElement(By.xpath(".//*[@id='positiveComments']"));
		POSTIVE_COMM.clear();
		POSTIVE_COMM.sendKeys(Compound_Test_Type.negativeComments);
		
		WebElement NEGATIVE_COMM = driver.findElement(By.xpath(".//*[@id='negativeComments']"));
		NEGATIVE_COMM.clear();
		NEGATIVE_COMM.sendKeys(Compound_Test_Type.positiveComments);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='form']/div[2]/button[2]")).click();	
		
		
	}

	@Then("^the result box should be displayed with NORMAL and ABNORMAL options and range drop down box should be displayed$")
	public void the_result_box_should_be_displayed_with_NORMAL_and_ABNORMAL_options_and_range_drop_down_box_should_be_displayed() throws Throwable {
	 
		Thread.sleep(2000);	
		String currentUrl = COMPOUND_LIST_URL;
	      String curtUrlDriver = driver.getCurrentUrl();

	     Assert.assertEquals(currentUrl, curtUrlDriver);
		
		
		
	}

	private static final class Compound_Test_Type 
	{
		
        private static final String F_NAME = "Test6001";
        private static final String CLASS_C = "Test6001";
        
        private static final String F_NAME1 = "Test9001";
        private static final String CLASS_C1 = "Test9001";
		
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
