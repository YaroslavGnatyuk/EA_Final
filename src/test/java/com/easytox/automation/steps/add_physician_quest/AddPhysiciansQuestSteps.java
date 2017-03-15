package com.easytox.automation.steps.add_physician_quest;
import com.easytox.automation.driver.DriverBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class AddPhysiciansQuestSteps {
	
	private static final String USERNAME = "lavanya1";
	private static final String PASSWORD = "P@ssw0rd123";
	private static final String FIND_USERNAME = "j_username";
    private static final String FIND_PASSWORD = "j_password";
	private static final String LAB_CLIENT = "Quest";
	private static final String URL = "http://bmtechsol.com:8080/easytox/";
	private static final String LAB_CLIENTS_LIST_URL = "http://bmtechsol.com:8080/easytox/labClient/list";
	private static final String CLINICIANS_LIST_URL = "http://bmtechsol.com:8080/easytox/clinician/clinicianslist";
	private static final String ADD_PHYSICIAN_URL = "http://bmtechsol.com:8080/easytox/clinician/create";
	private static final String FIND_PHYSICIAN_USERNAME = "user.username";
	private static final String FIND_PHYSICIAN_PASSWORD = "user.password";
	private static final String CLINICIAN_PSW = "Welcome@123";
	
    private WebDriver driver;
    private Physician physician;

    public AddPhysiciansQuestSteps() {
        DriverBase.instantiateDriverObject();
        driver = DriverBase.getDriver();
    }

    @Given("^Locations should be available Quest$")
    public void locations_should_be_available() throws Throwable {
    	driver.navigate().to(LAB_CLIENTS_LIST_URL);
    	Thread.sleep(2000);
    	driver.findElement(By.linkText(LAB_CLIENT));
    }

    @When("^Click on the Phisician icon on the LabClient list page for Quest lab$")
    public void click_on_the_Phisician_icon_on_the_LabClient_list_page_for_Quest_lab() throws Throwable {
    	Thread.sleep(2000);
    	
    	WebElement table = driver.findElement(By.id("example"));

    	List<WebElement> allRows = table.findElements(By.tagName("tr"));
    	loop : {
	    	for (WebElement row : allRows) {
	    		List<WebElement> cells = row.findElements(By.xpath("./*"));
		    	for (WebElement cell : cells) {
		    		String cellText = cell.getText();
					if(cellText.equals(LAB_CLIENT)) {
						WebElement icon = row.findElement(By.cssSelector(".fa.fa-user-md.fa-2x"));
						icon.click();
						break loop;
					}
		    	 }
	    	}
    	}
		Thread.sleep(2000);
    }

    @Then("^'Clinician List' page should be displayed$")
    public void clinician_List_page_should_be_displayed() throws Throwable {
    	 Assert.assertEquals(CLINICIANS_LIST_URL, driver.getCurrentUrl());
    }

    @When("^Select '\\+' icon next to search box$")
    public void select_icon_next_to_search_box() throws Throwable {
    	driver.findElement(By.cssSelector(".fa.fa-plus-circle.fa-2x")).click();
    }

    @Then("^'Add Physician' page should be displayed$")
    public void add_Physician_page_should_be_displayed() throws Throwable {
    	Assert.assertEquals(ADD_PHYSICIAN_URL, driver.getCurrentUrl());
    }
    
    @When("^Enter Username as 'Angelia' and pwd as 'Welcome@(\\d+)'$")
    public void enter_Username_as_Angelia_and_pwd_as_Welcome(int arg1) throws Throwable {
    	String username = "Angelia7";
    	driver.findElement(By.name(FIND_PHYSICIAN_USERNAME)).sendKeys(username);
    	driver.findElement(By.name(FIND_PHYSICIAN_PASSWORD)).sendKeys(CLINICIAN_PSW);
    	Thread.sleep(5000);
    }
    
    @Then("^User should be able to enter the data$")
    public void user_should_be_able_to_enter_the_data() throws Throwable {
    }

    @When("^Select and add Compound Profile$")
    public void select_and_add_Compound_Profile() throws Throwable {
    	Select dropdown = new Select(driver.findElement(By.id("profiles")));
    	dropdown.selectByIndex(1);
    	
    	driver.findElement(By.cssSelector(".addProfile")).click();
    	
    	Thread.sleep(2000);
    }
    
    @Then("^User should be able to add the Compound Profile$")
    public void user_should_be_able_to_add_the_Compound_Profile() throws Throwable {
    	
    }

    @When("^Select Lab Client Locations as 'Quest' and select Location as 'Quest' and add the location$")
    public void select_Lab_Client_Locations_as_Quest_and_select_Location_as_Quest_and_add_the_location() throws Throwable {
    	Select dropdown = new Select(driver.findElement(By.id("labclientselect")));
    	dropdown.selectByVisibleText(LAB_CLIENT);
    	Thread.sleep(1000);
    	dropdown = new Select(driver.findElement(By.id("lablocations")));
    	dropdown.selectByVisibleText(LAB_CLIENT);
    	
    	driver.findElement(By.cssSelector(".addLocation")).click();
    	
    	Thread.sleep(2000);
    }
    
    @Then("^User should be able to select the location$")
    public void user_should_be_able_to_select_the_location() throws Throwable {
    }

    @When("^Enter the remaining information and click on 'Submit'$")
    public void enter_the_remaining_information_and_click_on_Submit() throws Throwable {
		Physician physician = initailizePhysician();
    	driver.findElement(By.name("user.firstName")).sendKeys(physician.getFirstName());
    	driver.findElement(By.name("user.middleIntial")).sendKeys(physician.getMiddleName());
    	driver.findElement(By.name("user.lastName")).sendKeys(physician.getLastName());
    	driver.findElement(By.name("user.medicalDegree")).sendKeys(physician.getMedicalDegree());
    	driver.findElement(By.name("user.contact")).sendKeys(physician.getPhoneNumber());
    	driver.findElement(By.name("user.email")).sendKeys(physician.getEmail());
    	driver.findElement(By.name("salutation")).sendKeys(physician.getSalutation());
    	driver.findElement(By.name("medicare_num")).sendKeys(physician.getMedicalNumber());
    	driver.findElement(By.name("medicaid_num")).sendKeys(physician.getMedicaidNumber());
    	driver.findElement(By.name("upin_num")).sendKeys(physician.getUpinNumer());
    	driver.findElement(By.name("state_license")).sendKeys(physician.getStateLicence());	
    	driver.findElement(By.name("npi")).sendKeys(physician.getNpi());
    	
    	Thread.sleep(2000);
    	
    	driver.findElement(By.cssSelector(".btn.btn-primary.btn-md")).click();
    	Thread.sleep(2000);
    }
    
    @Then("^Physician should be added to the Phisicians list$")
    public void physician_should_be_added_to_the_Phisicians_list() throws Throwable {
    	Thread.sleep(1000);
    	driver.findElement(By.cssSelector(".alert.alert-success"));
    }
    
   @When("^Enter Username as 'Anaron' and pwd as 'Welcome@(\\d+)'$")
    public void enter_Username_as_Anaron_and_pwd_as_Welcome(int arg1) throws Throwable {
    	String username = "Anaron7";
    	driver.findElement(By.name(FIND_PHYSICIAN_USERNAME)).sendKeys(username);
    	driver.findElement(By.name(FIND_PHYSICIAN_PASSWORD)).sendKeys(CLINICIAN_PSW);
    	Thread.sleep(5000);
    }

    @When("^Enter Username as 'Avondale' and pwd as 'Welcome@(\\d+)'$")
    public void enter_Username_as_Avondale_and_pwd_as_Welcome(int arg1) throws Throwable {
    	String username = "Avondale7";
    	driver.findElement(By.name(FIND_PHYSICIAN_USERNAME)).sendKeys(username);
    	driver.findElement(By.name(FIND_PHYSICIAN_PASSWORD)).sendKeys(CLINICIAN_PSW);
    	Thread.sleep(5000);
    }

    @When("^Enter Username as 'Aarthi' and pwd as 'Welcome@(\\d+)'$")
    public void enter_Username_as_Aarthi_and_pwd_as_Welcome(int arg1) throws Throwable {
    	String username = "Aarthi7";
    	driver.findElement(By.name(FIND_PHYSICIAN_USERNAME)).sendKeys(username);
    	driver.findElement(By.name(FIND_PHYSICIAN_PASSWORD)).sendKeys(CLINICIAN_PSW);
    	Thread.sleep(5000);
    }
    
    private Physician initailizePhysician(){
    	physician = new Physician();
    	
    	physician.setFirstName("Name");
    	physician.setMiddleName("Test");
    	physician.setLastName("LastName");
    	physician.setMedicalDegree("Doctor");
    	physician.setPhoneNumber("2222222222");
    	physician.setEmail("test@domian.com");
    	physician.setSalutation("hello");
    	physician.setMedicaidNumber("1234");
    	physician.setMedicalNumber("5678");
    	physician.setUpinNumer("9955");
    	physician.setStateLicence("125564");
    	physician.setNpi("58282");
    	
    	return physician;
    }

    private static class Physician {
    	private String username;
    	private String firstName;
    	private String middleName;
    	private String lastName;
    	private String medicalDegree;
    	private String phoneNumber;
    	private String email;
    	private String salutation;
    	private String medicalNumber;
    	private String medicaidNumber;
    	private String upinNumer;
    	private String stateLicence;
    	private String npi;
    	  	
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getMiddleName() {
			return middleName;
		}
		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getMedicalDegree() {
			return medicalDegree;
		}
		public void setMedicalDegree(String medicalDegree) {
			this.medicalDegree = medicalDegree;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getSalutation() {
			return salutation;
		}
		public void setSalutation(String salutation) {
			this.salutation = salutation;
		}
		public String getMedicalNumber() {
			return medicalNumber;
		}
		public void setMedicalNumber(String medicalNumber) {
			this.medicalNumber = medicalNumber;
		}
		public String getMedicaidNumber() {
			return medicaidNumber;
		}
		public void setMedicaidNumber(String medicaidNumber) {
			this.medicaidNumber = medicaidNumber;
		}
		public String getUpinNumer() {
			return upinNumer;
		}
		public void setUpinNumer(String upinNumer) {
			this.upinNumer = upinNumer;
		}
		public String getStateLicence() {
			return stateLicence;
		}
		public void setStateLicence(String stateLicence) {
			this.stateLicence = stateLicence;
		}
		public String getNpi() {
			return npi;
		}
		public void setNpi(String npi) {
			this.npi = npi;
		}   	
    } 
}
