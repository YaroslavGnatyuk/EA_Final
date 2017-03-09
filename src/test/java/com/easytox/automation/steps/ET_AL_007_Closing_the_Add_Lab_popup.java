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


public class ET_AL_007_Closing_the_Add_Lab_popup {

	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "superadmin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="admin";
	private static final String Lab_Profile_URL ="http://bmtechsol.com:8080/easytox/lab/list";
	
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public ET_AL_007_Closing_the_Add_Lab_popup(){
		
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


@When("^Click on \"([^\"]*)\" icon beside the Search Box$")
public void Click_on_icon_beside_the_Search_Box(String arg1) throws Throwable {

	
	Thread.sleep(2000);
	 driver.findElement(By.xpath(".//*[@id='add']/i")).click();
	
	
	
}

@Then("^Click on \"([^\"]*)\" button$")
public void Click_on_button(String arg1) throws Throwable {

	
	
	Thread.sleep(2000);
	driver.findElement(By.xpath(".//*[@id='addLabdiv']/div/button")).click();
	
	
}

@Then("^\"([^\"]*)\" popup should be closed and the user should be navigate to Lab List Screen$")
public void popup_should_be_closed_and_the_user_should_be_navigate_to_Lab_List_Screen(String arg1) throws Throwable {
 
	
	
	

	Thread.sleep(2000);
String currentUrl = Lab_Profile_URL;
String curtUrlDriver = driver.getCurrentUrl();	
Assert.assertEquals(currentUrl, curtUrlDriver);
	
driver.quit();

}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
