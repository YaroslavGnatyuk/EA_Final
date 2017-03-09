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




public class Insurance_Company_Add {
	
	
	private static final String USER_NAME = "j_username";
	private static final String PAGE_ID = "cgilabadmin";
	private static final String PASSWD = "j_password";
	private static final String PAGE_PSWD ="Welcome@123";
	private static final String Insurance_Company_URL ="http://bmtechsol.com:8080/easytox/insuranceCompany/list";
	private static final String Add_Insurance_Company_URL ="http://bmtechsol.com:8080/easytox/insuranceCompany/create";
	private WebDriver driver;
	private WebElementHelper webElementHelper;
	
	public Insurance_Company_Add(){
		
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

	@When("^Click Add Insurance Company plus icon.$")
	public void Click_Add_Insurance_Company_icon() throws Throwable {
		
		Thread.sleep(1000);	
		driver.findElement(By.xpath(".//*[@id='example_wrapper']/div[2]/a/i")).click();
		
		Thread.sleep(1000);	
		
		
		
	 
	}

	@Then("^Add Insurance Company  page should be displayed$")
	public void Add_Insurance_Company_page_should_be_displayed() throws Throwable {
	   
		
		Thread.sleep(1000);
		String currentUrl = Add_Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertEquals(currentUrl, curtUrlDriver);
		
	}

	@When("^Enter all the information in the screen and click Submit.$")
	public void Enter_all_the_information_in_the_screen_and_click_Submit() throws Throwable {
	  
		
		Thread.sleep(3000);
		
		WebElement Compnd_code = driver.findElement(By.xpath(".//*[@id='form']/div[1]/div/input"));
		Compnd_code.clear();
		Compnd_code.sendKeys(Insurance.Company_Code);
		
		
		
		
		WebElement Compnd_name = driver.findElement(By.xpath(".//*[@id='form']/div[2]/div/input"));
		Compnd_name.clear();
		Compnd_name.sendKeys(Insurance.Company_Name);
		
		
		
		WebElement Addres_1= driver.findElement(By.xpath(".//*[@id='form']/div[3]/div[1]/input"));
		Addres_1.clear();
		Addres_1.sendKeys(Insurance.Address_1);
		
		
		
		
		WebElement Addres_2 = driver.findElement(By.xpath(".//*[@id='form']/div[3]/div[2]/input"));
		Addres_2.clear();
		Addres_2.sendKeys(Insurance.Address_2);
		
		
		
		WebElement ziop = driver.findElement(By.xpath(".//*[@id='zip']"));
		ziop.clear();
		ziop.sendKeys(Insurance.Zip_Code);
		
	
		
		WebElement Contaft = driver.findElement(By.xpath(".//*[@id='form']/div[5]/div[1]/input"));
		Contaft.clear();
		Contaft.sendKeys(Insurance.Contact);
		
		WebElement Contact2 = driver.findElement(By.xpath(".//*[@id='form']/div[5]/div[2]/input"));
		Contact2.clear();
		Contact2.sendKeys(Insurance.Contact2);
		
		WebElement Faxxx = driver.findElement(By.xpath(".//*[@id='form']/div[5]/div[3]/input"));
		Faxxx.clear();
		Faxxx.sendKeys(Insurance.Fax);
		
		
		WebElement E_mail = driver.findElement(By.xpath(".//*[@id='form']/div[6]/div[1]/input"));
		E_mail.clear();
		E_mail.sendKeys(Insurance.Email);
		
		
		
		
		WebElement Websitee = driver.findElement(By.xpath(".//*[@id='form']/div[6]/div[2]/input"));
		Websitee.clear();
		Websitee.sendKeys(Insurance.Website);
		
		
		
		WebElement PaylerId = driver.findElement(By.xpath(".//*[@id='form']/div[7]/div[1]/input"));
		PaylerId.clear();
		PaylerId.sendKeys(Insurance.Payer_Id);
		
		
	
		
		WebElement Adjus_ster = driver.findElement(By.xpath(".//*[@id='form']/div[7]/div[2]/input"));
		Adjus_ster.clear();
		Adjus_ster.sendKeys(Insurance.Adjuster);
		
		
		WebElement Statuss = driver.findElement(By.xpath(".//*[@id='form']/div[8]/div[1]/input"));
		Statuss.clear();
		Statuss.sendKeys(Insurance.Status);
		
		
		
		
		WebElement Pay_Numm = driver.findElement(By.xpath(".//*[@id='form']/div[8]/div[2]/input"));
		Pay_Numm.clear();
		Pay_Numm.sendKeys(Insurance.PayNum);
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='form']/div[9]/div/button")).click();
		
		
	}

	@Then("^A new insurance company should be created successfully.$")
	public void A_new_insurance_company_should_be_created_successfully() throws Throwable {
	 
		
		Thread.sleep(1000);
		String currentUrl = Add_Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertNotEquals(currentUrl, curtUrlDriver);
		
		
	}

	@When("^Click plus icon against the new insurance company.$")
	public void Click_icon_against_the_new_insurance_company() throws Throwable {
	   
		Thread.sleep(2000);
		//next page
		driver.findElement(By.xpath(".//*[@id='example_paginate']/ul/li[4]/a")).click();
		//edit option beside company
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='example']/tbody/tr[3]/td[1]")).click();
		Thread.sleep(1000);
		
		
		
	}

	@Then("^All the values should be populated correctly as per entered data.$")
	public void All_the_values_should_be_populated_correctly_as_per_entered_data() throws Throwable {
	    
		Thread.sleep(1000);
		String currentUrl = Add_Insurance_Company_URL;
	    String curtUrlDriver = driver.getCurrentUrl();
	
	    Assert.assertNotEquals(currentUrl, curtUrlDriver);
		
		
		driver.quit();
	}


	private static final class Insurance {
            
        
        private static final String Company_Code= "EasyAutomation";
        private static final String Company_Name = "Esy7845dads";
        private static final String Address_1 = "17855";
        
        private static final String Fax = "8745629639";
        private static final String Contact2 = "8745629630";
        
        private static final String Address_2 = "Oak Street";
        private static final String Zip_Code ="43018";
       
        private static final String Contact = "8745129630";
        private static final String Email = "Easytox@gmail.com";
        private static final String Website = "http://www.Automation.com";
        private static final String Payer_Id= "DJ445J";
        private static final String Adjuster = "sdfkj";
         private static final String Status = "Good";
        private static final String PayNum = "5715";
        
	
	
	}

	
	
	
	

}
