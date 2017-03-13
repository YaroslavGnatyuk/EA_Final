package com.easytox.automation.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;



public class CommonCodeForAll {
	
	
	
	protected static final String USER_NAME = "j_username";
	protected static final String PAGE_ID = "superadmin";
	protected static final String PASSWD = "j_password";
	protected static final String PAGE_PSWD ="admi11n";
	protected static final String Lab_Profile_URL ="http://162.243.2.94:8080/easytox/";
	protected static final String URL = "http://162.243.2.94:8080/easytox/";
	protected WebDriver driver;
	private WebElementHelper webElementHelper;
	
	
	public CommonCodeForAll(){
		
		DriverBase.instantiateDriverObject();
        this.webElementHelper = new WebElementHelper();
        driver = DriverBase.getDriver();
	}
	


	
	public static void  validation(WebDriver driver3) throws InterruptedException
	{
		Thread.sleep(2000);
		String currentUrl = Lab_Profile_URL;
	    String curtUrlDriver = driver3.getCurrentUrl();	
	    Assert.assertNotEquals(currentUrl, curtUrlDriver);
		
	}
	
	
	
	public static void credentials(WebDriver driver2)
	{
		
			WebElement user =  driver2.findElement(By.name(USER_NAME));
			user.clear();
			user.sendKeys(PAGE_ID);
			
			WebElement pwd = driver2.findElement(By.name(PASSWD));
			 pwd.clear();
			 pwd.sendKeys(PAGE_PSWD);		 
			 driver2.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div/button")).click();
		
	}
	
	
	
	
	

}
