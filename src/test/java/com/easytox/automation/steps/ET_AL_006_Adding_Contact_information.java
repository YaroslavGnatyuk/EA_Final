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


public class ET_AL_006_Adding_Contact_information {

	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "superadmin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="admin";
	private static final String Lab_Profile_URL ="http://bmtechsol.com:8080/easytox/lab/list";
	
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public ET_AL_006_Adding_Contact_information(){
		
		DriverBase.instantiateDriverObject();
        this.webElementHelper = new WebElementHelper();
        driver = DriverBase.getDriver();
	}
	

	@Given("^Enter valid Username and Password click on \"([^\"]*)\" button$")
	public void Enter_valid_Username_and_Password_click_on_button(String arg1) throws Throwable {
	   
		driver.get("http://bmtechsol.com:8080/easytox/");		 
		
		 driver.manage().window().maximize();		 
		WebElement user =  driver.findElement(By.name(USER_NAME));
		user.clear();
		user.sendKeys(PAGE_ID);
		
		WebElement pwd = driver.findElement(By.name(PASSWD));
		 pwd.clear();
		 pwd.sendKeys(PAGE_PSWD);		 
		 driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div/button")).click();
		
		
		
	}

	@Then("^Lab admin user should be able to login successfully$")
	public void Lab_admin_user_should_be_able_to_login_successfully() throws Throwable {
		
			Thread.sleep(2000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver.getCurrentUrl();	
	    Assert.assertEquals(currentUrl, curtUrlDriver);	
		
		
	    
	}


@When("^Enter all the values in the following fields$")
public void Enter_all_the_values_in_the_following_fields() throws Throwable {
    
	
	
	//+ new lab window
	Thread.sleep(2000);
	driver.findElement(By.xpath(".//*[@id='add']/i")).click();
	
	
	Thread.sleep(2000);
	WebElement name_code = driver.findElement(By.xpath(".//*[@id='lab_name']"));
	name_code.clear();
	name_code.sendKeys(Lab.LabName);
	
	
	Thread.sleep(2000);
	WebElement description = driver.findElement(By.xpath(".//*[@id='lab_desc']"));
	description.clear();
	description.sendKeys(Lab.Description);
	
	
	
	Thread.sleep(2000);
	WebElement email_id = driver.findElement(By.xpath(".//*[@id='form']/div[1]/div[4]/div/input"));
	email_id.clear();
	email_id.sendKeys(Lab.Email);
	
	
	
	Thread.sleep(2000);
	WebElement address_1 = driver.findElement(By.xpath(".//*[@id='form']/div[1]/div[5]/div[1]/input"));
	address_1.clear();
	address_1.sendKeys(Lab.Address);
	
	
	
	
	
	Thread.sleep(2000);
	WebElement address_2 = driver.findElement(By.xpath(".//*[@id='form']/div[1]/div[5]/div[2]/input"));
	address_2.clear();
	address_2.sendKeys(Lab.Address2);
	
	
	
	Thread.sleep(2000);
	WebElement zipcode = driver.findElement(By.xpath(".//*[@id='zip']"));
	zipcode.clear();
	zipcode.sendKeys(Lab.Zipcode);
	
	
	
	Thread.sleep(2000);
	WebElement country = driver.findElement(By.xpath(".//*[@id='form']/div[1]/div[7]/div[2]/input"));
	country.clear();
	country.sendKeys(Lab.Country);
	
	
	
	Thread.sleep(2000);
	new Select( driver.findElement(By.xpath(".//*[@id='plan']"))).selectByVisibleText("Demo 0.0");
	
	
	
	
	
}


@Then("^Click on \"([^\"]*)\" contact icon  Add the values to Contact info fields$")
public void Click_on_contact_icon_Add_the_values_to_Contact_info_fields(String arg1) throws Throwable {
 
	Thread.sleep(2000);
	driver.findElement(By.xpath(".//*[@id='form']/div[1]/div[1]/button")).click();
	
	
	Thread.sleep(2000);
	WebElement contactName = driver.findElement(By.xpath(".//*[@id='form']/div[1]/div[9]/div[1]/div[1]/input"));
	contactName.clear();
	contactName.sendKeys(Lab.ContactName);
	
	
	Thread.sleep(2000);
	WebElement Contact_email = driver.findElement(By.xpath(".//*[@id='form']/div[1]/div[9]/div[1]/div[2]/input"));
	Contact_email.clear();
	Contact_email.sendKeys(Lab.ContactEmail);
	
	
	
	
	Thread.sleep(2000);
	WebElement fax_Number = driver.findElement(By.xpath(".//*[@id='form']/div[1]/div[9]/div[2]/div[1]/input"));
	fax_Number.clear();
	fax_Number.sendKeys(Lab.FaxNumber);
	
	
	Thread.sleep(2000);
	WebElement Contact_Number = driver.findElement(By.xpath(".//*[@id='form']/div[1]/div[9]/div[2]/div[2]/input"));
	Contact_Number.clear();
	Contact_Number.sendKeys(Lab.ContactNumber);
	
	driver.findElement(By.xpath(".//*[@id='form']/div[1]")).click();
	
	
}

@Then("^Contact Info fields should be populated and  user should able to add the values or hide the fields to clicking on \"([^\"]*)\" icon$")
public void Contact_Info_fields_should_be_populated_and_user_should_able_to_add_the_values_or_hide_the_fields_to_clicking_on_icon(String arg1) throws Throwable {
  
	
	//closing contact details
	Thread.sleep(2000);
	driver.findElement(By.xpath(".//*[@id='form']/div[1]/div[9]/div[1]/div[3]/button")).click();
	Thread.sleep(3000);
	driver.quit();
	
}


private static final class Lab {
    
	private static final String Email = "email1233@easytox.com";
    private static final String LabName= "LabCorp1233";
    private static final String Description = "LabTest233";
     private static final String Address ="6100 ";
     private static final String Zipcode = "43213";
private static final String Address2 = "E Main St #107";
  private static final String Country = "USA";    
  
  private static final String ContactName ="Hutch";
  private static final String ContactEmail = "conta@gmail.com";
private static final String FaxNumber = "9874561230";
private static final String ContactNumber = "8745129635";
	} 

	
	
	
	
	
	
	
	
	
	
	
}
