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


public class Insurancecompanysortingdata {
	

	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "cgilabadmin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="Welcome@123";
	private static final String Insurance_Company_URL ="http://bmtechsol.com:8080/easytox/insuranceCompany/list";
	private static final String Add_Insurance_Company_URL ="http://bmtechsol.com:8080/easytox/insuranceCompany/create";
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public Insurancecompanysortingdata(){
		
		DriverBase.instantiateDriverObject();
        this.webElementHelper = new WebElementHelper();
        driver = DriverBase.getDriver();

	}
	
	
	@Given("^the user is on home screen$")
	public void the_user_is_on_home_screen() throws Throwable {
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

	@When("^Select settings and choose Insurance Company$")
	public void Select_settings_and_choose_Insurance_Company() throws Throwable {

		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[2]/div/div/div[3]/div/ul/li[8]/a/i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='topmenu']/li[6]/a")).click();
		
		
		
	}

	@Then("^Insurance Company List screen is displayed$")
	public void Insurance_Company_List_screen_is_displayed() throws Throwable {

		
		Thread.sleep(1000);
		String currentUrl = Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	
		
		
	}
	@When("^Click on \"([^\"]*)\" down arrow icon on  Sorting  column one$")
	public void Click_on_down_arrow_icon_on_Sorting_column_one(String arg1) throws Throwable {
	
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[2]")).click();
		Thread.sleep(3000);
		
		
	}

	@Then("^Records should be displayed based on the asecending order of the selected  field one$")
	public void Records_should_be_displayed_based_on_the_asecending_order_of_the_selected_field_one() throws Throwable {
	   
		Thread.sleep(1000);
		String currentUrl = Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
		
	}

	@When("^Click on \"([^\"]*)\"  Up arrow icon  on sorting column five one$")
	public void Click_on_Up_arrow_icon_on_sorting_column_five_one(String arg1) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[2]")).click();
		Thread.sleep(3000);
	}

	@Then("^Records should be displayed based on the descending order of the selected field five two$")
	public void Records_should_be_displayed_based_on_the_descending_order_of_the_selected_field_five_two() throws Throwable {
		Thread.sleep(1000);
		String currentUrl = Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	}

	@When("^Click on  \"([^\"]*)\" Up arrow icon  on sorting column one one$")
	public void Click_on_Up_arrow_icon_on_sorting_column_one_one(String arg1) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[3]")).click();
		Thread.sleep(3000);
	}

	@Then("^Records should be displayed based on the descending order of the selected field one one$")
	public void Records_should_be_displayed_based_on_the_descending_order_of_the_selected_field_one_one() throws Throwable {
		Thread.sleep(1000);
		String currentUrl = Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	}

	@When("^Click on \"([^\"]*)\"  down arrow icon on  Sorting  column two$")
	public void Click_on_down_arrow_icon_on_Sorting_column_two(String arg1) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[3]")).click();
		Thread.sleep(3000);
	}

	@Then("^Records should be displayed based on the asecending order of the selected  field two$")
	public void Records_should_be_displayed_based_on_the_asecending_order_of_the_selected_field_two() throws Throwable {
		Thread.sleep(1000);
		String currentUrl = Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	}

	@When("^Click on  \"([^\"]*)\" Up arrow icon  on sorting column two two$")
	public void Click_on_Up_arrow_icon_on_sorting_column_two_two(String arg1) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[4]")).click();
		Thread.sleep(3000);
	}

	@Then("^Records should be displayed based on the descending order of the selected field two two$")
	public void Records_should_be_displayed_based_on_the_descending_order_of_the_selected_field_two_two() throws Throwable {
		Thread.sleep(1000);
		String currentUrl = Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	}

	@When("^Click on \"([^\"]*)\" down arrow icon on  Sorting  column three$")
	public void Click_on_down_arrow_icon_on_Sorting_column_three(String arg1) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[4]")).click();
		Thread.sleep(3000);
	}

	@Then("^Records should be displayed based on the asecending order of the selected  field three$")
	public void Records_should_be_displayed_based_on_the_asecending_order_of_the_selected_field_three() throws Throwable {
		Thread.sleep(1000);
		String currentUrl = Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	}

	@When("^Click on  \"([^\"]*)\" Up arrow icon  on sorting column three three$")
	public void Click_on_Up_arrow_icon_on_sorting_column_three_three(String arg1) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[5]")).click();
		Thread.sleep(3000);
	}

	@Then("^Records should be displayed based on the descending order of the selected field thee$")
	public void Records_should_be_displayed_based_on_the_descending_order_of_the_selected_field_thee() throws Throwable {
		Thread.sleep(1000);
		String currentUrl = Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	}

	@When("^Click on \"([^\"]*)\"  down arrow icon on  Sorting  column four$")
	public void Click_on_down_arrow_icon_on_Sorting_column_four(String arg1) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[5]")).click();
		Thread.sleep(3000);
	}

	@Then("^Records should be displayed based on the asecending order of the selected  field four$")
	public void Records_should_be_displayed_based_on_the_asecending_order_of_the_selected_field_four() throws Throwable {
		Thread.sleep(1000);
		String currentUrl = Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	}

	@When("^Click on \"([^\"]*)\"  Up arrow icon  on sorting column four four$")
	public void Click_on_Up_arrow_icon_on_sorting_column_four_four(String arg1) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[6]")).click();
		Thread.sleep(3000);
	}

	@Then("^Records should be displayed based on the descending order of the selected field foo$")
	public void Records_should_be_displayed_based_on_the_descending_order_of_the_selected_field_foo() throws Throwable {
		Thread.sleep(1000);
		String currentUrl = Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	}

	@When("^Click on \"([^\"]*)\" down arrow icon on  Sorting  column five$")
	public void Click_on_down_arrow_icon_on_Sorting_column_five(String arg1) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[6]")).click();
		Thread.sleep(3000);   
	}

	@Then("^Records should be displayed based on the asecending order of the selected  field five$")
	public void Records_should_be_displayed_based_on_the_asecending_order_of_the_selected_field_five() throws Throwable {
		Thread.sleep(1000);
		String currentUrl = Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	}

	
	
	
	
	@When("^Click on \"([^\"]*)\"  Up arrow icon  on sorting column six$")
	public void Click_on_Up_arrow_icon_on_sorting_column_six(String arg1) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[7]")).click();
		Thread.sleep(3000); 
	}

	@Then("^Records should be displayed based on the descending order of the selected field sooo$")
	public void Records_should_be_displayed_based_on_the_descending_order_of_the_selected_field_sooo() throws Throwable {
		Thread.sleep(1000);
		String currentUrl = Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	}
	
	@When("^Click on \"([^\"]*)\" down arrow icon on  Sorting  column six six$")
	public void Click_on_down_arrow_icon_on_Sorting_column_six_six(String arg1) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/thead/tr/th[7]")).click();
		Thread.sleep(3000); 
	}

	@Then("^Records should be displayed based on the asecending order of the selected  field five six$")
	public void Records_should_be_displayed_based_on_the_asecending_order_of_the_selected_field_five_six() throws Throwable {
		Thread.sleep(1000);
		String currentUrl = Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
	    
	    
	    driver.quit();
	}

	
	

}
