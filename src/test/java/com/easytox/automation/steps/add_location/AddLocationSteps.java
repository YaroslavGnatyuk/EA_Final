package com.easytox.automation.steps.add_location;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



/**
 * Created by Alexander on 15.11.2016.
 */
public class AddLocationSteps {

    private static final String PASSWORD = "P@ssw0rd123";
    private static final String LOGIN = "lavanya1";
    private static final String FIND_LOCATION_NAME = "lab_location_name";
    private static final String FIND_LOCATION_DEPARTMENT = "lab_location_department";
    private static final String FIND_LOCATION_ADDRESS = "lab_location_address";
    private static final String FIND_FAX_NUMBER = "faxNumber";
    private static final String FIND_USERNAME = "j_username";
    private static final String FIND_LOGIN = "j_password";
    private static final String LAB_CLIENT_NAME = "Quest";

    private WebDriver driver;
    private WebElementHelper webElementHelper;


    public AddLocationSteps() {
        DriverBase.instantiateDriverObject();
        this.webElementHelper = new WebElementHelper();
        driver = DriverBase.getDriver();
    }

    @Given("^User should be login to the lab$")
    public void user_should_be_login_to_the_lab() throws Throwable {
        driver.navigate().to("http://bmtechsol.com:8080/easytox/");

        WebElement element = driver.findElement(By.name(FIND_USERNAME));
        element.clear();
        element.sendKeys(LOGIN);

        WebElement el = driver.findElement(By.name(FIND_LOGIN));
        el.clear();
        el.sendKeys(PASSWORD);

        driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div/button")).click();

    }

    @Given("^Lab Client should be available$")
    public void lab_Client_should_be_available() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("i.icon.fa.fa-cog")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#topmenu > li:nth-child(5) > a > img")).click();
        Thread.sleep(5000);

    }

    @When("^Click on the Lab Client 'Quest'$")
    public void click_on_the_Lab_Client_Quest() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.linkText(LAB_CLIENT_NAME)).click();
    }

    @Then("^Update Lab Client page should be displayed$")
    public void update_Lab_Client_page_should_be_displayed() throws Throwable {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://bmtechsol.com:8080/easytox/labClient/edit");
    }

    @When("^Click on the location Icon$")
    public void click_on_the_location_Icon() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("i.fa.fa-location-arrow.fa-2x")).click();
    }

    @Then("^Add Lab Location page should be displayed$")
    public void add_Lab_Location_page_should_be_displayed() throws Throwable {
        String currentUrl = "http://bmtechsol.com:8080/easytox/labLocation/create";
        String currentUrlFromDriver = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl, currentUrlFromDriver);
    }

    @When("^Enter Location Name as (.*) and enter the remaining details and click on 'Submit'$")
    public void enter_Location_Name_as_QAmeerpet_and_enter_the_remaining_details_and_click_on_Submit(String location) throws Throwable {
        LabLocation labLocation = createLocation(location);

        driver.findElement(By.name(FIND_LOCATION_NAME)).sendKeys(labLocation.getLocationName());
        driver.findElement(By.name(FIND_LOCATION_DEPARTMENT)).sendKeys(labLocation.getDepartment());
        driver.findElement(By.name(FIND_LOCATION_ADDRESS)).sendKeys(labLocation.getAddress());
        driver.findElement(By.name(FIND_FAX_NUMBER)).sendKeys(labLocation.getFaxNumber());

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"form\"]/div[5]/div/button")).click();
    }

    @Then("^Added location should be added to the location list$")
    public void added_location_should_be_added_to_the_location_list() throws Throwable {
        String currentUrl = "http://bmtechsol.com:8080/easytox/labLocation/save";
        String currentUrlFromDriver = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl, currentUrlFromDriver);
    }

    private LabLocation createLocation(String locationName){

        LabLocation labLocation = new LabLocation();
        labLocation.setLocationName(locationName);
        labLocation.setDepartment("someDepartment");
        labLocation.setAddress("someAdsress");
        labLocation.setFaxNumber("1234567890");

        return labLocation;
    }

    private static class LabLocation{
        private String LocationName;
        private String Department;
        private String Address;
        private String FaxNumber;

        public String getLocationName() {
            return LocationName;
        }

        public void setLocationName(String locationName) {
            LocationName = locationName;
        }

        public String getDepartment() {
            return Department;
        }

        public void setDepartment(String department) {
            Department = department;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String address) {
            Address = address;
        }

        public String getFaxNumber() {
            return FaxNumber;
        }

        public void setFaxNumber(String faxNumber) {
            FaxNumber = faxNumber;
        }
    }
}
