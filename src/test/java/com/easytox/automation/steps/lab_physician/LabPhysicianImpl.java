package com.easytox.automation.steps.lab_physician;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.LocatorType;
import com.easytox.automation.utils.MyWebDriverUtils;
import com.easytox.automation.utils.StringUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Alexander on 20.12.2016.
 */
public class LabPhysicianImpl {
    private static final String PASSWORD = "Welcome@123";
    private static final String LOGIN = "cgilabadmin";
    private static final String LOGIN_PAGE_URL = "http://bmtechsol.com:8080/easytox/";
    private static final String FIND_USERNAME = "j_username";
    private static final String FIND_PASSWORD = "j_password";
    private static final String LOGIN_BUTTON_XPATH = "//*[@id=\"loginform\"]/div[3]/div/button";
    private static final String SETTINGS_LOCATOR = "body > div.navbar > div > div > div.navbar-header.pull-right > div > ul > li:nth-child(8) > a";
    private static final String PHYSICIAN_ICON_LOCATOR = "#topmenu > li:nth-child(10) > a";
    private static final String PHYSICIAN_LIST_URL = "http://bmtechsol.com:8080/easytox/clinician/clinicianlist";
    private static final String WIDGET_PHYSICIAN_LIST_LOCATOR = "#maincontentdiv > div.page-body > div.row > div > div > div.widget-header > span";
    private static final String WIDGET_PHYSICIAN_LIST_VALUE = "Physician List";
    private static final String PLUS_ICON_LOCATOR = "#example_wrapper > div.toolbar > a";
    private static final String PHYSICIAN_PAGE_URL = "http://bmtechsol.com:8080/easytox/clinician/create";
    private static final String WIDGET_PHYSICIAN_PAGE_LOCATOR = "#maincontentdiv > div.page-body > div > div.widget-header.bg-blue > span";
    private static final String WIDGET_PHYSICIAN_PAGE_VALUE = "Add Physician";
    private static final String EDIT_ICON_LOCATOR = "#example > tbody > tr:nth-child(1) > td:nth-child(8) > form > a";
    private static final String UPDATE_PHYSICIAN_PAGE_URL = "http://bmtechsol.com:8080/easytox/clinician/edit";
    private static final String WIDGET_UPDATE_PHYSICIAN_LOCATOR = "#maincontentdiv > div.page-body > div > div.widget-header > span";
    private static final String WIDGET_UPDATE_PHYSICIAN_VALUE = "Update Physician";
    private static final String USER_NAME_LOCATOR = "username";
    private static final String PASSWORD_LOCATOR = "password";
    private static final String LOCK_ATTRIBUTE = "readonly";
    private static final String UPDATE_BUTTON_LOCATOR = "#form > button.btn.btn-danger.btn-md";
    private static final String SUCCESS_UPDATE_LOCATOR = "#maincontentdiv > div.page-body > div.alert.alert-success.fade.in";
    private static final String SUCCESS_UPDATE_MESSAGE = "x\nSuccess Clinician cgiclinician1 updated";
    private static final String SEARCH_LOCATOR = "#example_filter > label > input";
    private static final String DROP_DOWN_LOCATOR = "example_length";
    private static final String DEFAULT_NUMBER_OF_RECORDS = "10";
    private static final String PAGINATE_LOCATOR = "example_paginate";
    private static final String ALL_NUMBER_OF_RECORDS = "All";

    private static final String SORT_ATTRIBUTE_LOCATOR = "aria-sort";
    private static final String SORT_ATTRIBUTE_VALUE = "ascending";
    private static final String SORT_DESCENDING_VALUE = "descending";
    private static final String SORT_ASCENDING_LOCATOR = "#example > thead > tr > th.sorting_asc";
    private static final String PAGINATION_LOCATOR = "#example_paginate > ul";
    private static final String ATTRIBUTE_CLASS_LOCATOR = "class";
    private static final String MESSAGE_LOCATOR = "#example_info";


    private static final String CELLS_LOCATOR = "./*";
    private static final String CELL_LOCATOR = "td";
    private static final String TBODY_LOCATOR = "tbody";
    private static final String ROWS_LOCATOR = "tr";
    private static final String TABLE_LOCATOR = "example";
    private static final String LIST_LOCATOR = "li";


    private static Map<String, WebElement> map;
    private static List<WebElement> selectOptions;
    private static String navigateButton;

    private WebDriver driver;

    public LabPhysicianImpl() {
        DriverBase.instantiateDriverObject();
        driver = DriverBase.getDriver();
    }

    /*
    Scenario: Verify adding a new physician
     */

    @Given("^Sign in web app$")
    public void sign_in() {
        MyWebDriverUtils.authorization(driver, LOGIN_PAGE_URL,
                FIND_USERNAME, LocatorType.NAME, LOGIN,
                FIND_PASSWORD, LocatorType.NAME, PASSWORD,
                LOGIN_BUTTON_XPATH, LocatorType.XPATH);
    }

    @When("^Select Settings -> Physician$")
    public void go_to_physician_page() {
        MyWebDriverUtils.waitContainerThenClick(driver, SETTINGS_LOCATOR, LocatorType.CSS);
        MyWebDriverUtils.click(driver, PHYSICIAN_ICON_LOCATOR, LocatorType.CSS);
    }

    @Then("^Physician List screen is displayed$")
    public void physician_list_screen_is_displayed() {
        MyWebDriverUtils.checkCurrentUrl(driver, PHYSICIAN_LIST_URL);
        MyWebDriverUtils.checkWidgetCaption(driver, WIDGET_PHYSICIAN_LIST_LOCATOR, LocatorType.CSS, WIDGET_PHYSICIAN_LIST_VALUE);
    }

    @When("^Click Add Physician '\\+' icon$")
    public void click_add_physician_plus_icon() {
        MyWebDriverUtils.waitContainerThenClick(driver, PLUS_ICON_LOCATOR, LocatorType.CSS);
    }

    @Then("^Add Physician page is displayed$")
    public void add_physician_page_is_displayed() {
        MyWebDriverUtils.checkCurrentUrl(driver, PHYSICIAN_PAGE_URL);
        MyWebDriverUtils.checkWidgetCaption(driver, WIDGET_PHYSICIAN_PAGE_LOCATOR, LocatorType.CSS, WIDGET_PHYSICIAN_PAGE_VALUE);
    }

    @When("^Enter all the data in the screen and click Submit$")
    public void enter_all_the_data_in_the_screen_and_click_submit() {
        Physician.physicianUserName = StringUtils.generateRandom();
        MyWebDriverUtils.selectOption(driver, Physician.LAB_CLIENT_LOCATOR, LocatorType.ID, Physician.LAB_CLIENT);
        MyWebDriverUtils.enterData(driver, Physician.USER_NAME_LOCATOR, LocatorType.NAME, Physician.physicianUserName);
        MyWebDriverUtils.enterData(driver, Physician.PASSWORD_LOCATOR, LocatorType.NAME, Physician.PASSWORD);
        MyWebDriverUtils.enterData(driver, Physician.FIRST_NAME_LOCATOR, LocatorType.NAME, Physician.FIRST_NAME);
        MyWebDriverUtils.enterData(driver, Physician.LAST_NAME_LOCATOR, LocatorType.NAME, Physician.LAST_NAME);
        MyWebDriverUtils.enterData(driver, Physician.MIDDLE_NAME_LOCATOR, LocatorType.NAME, Physician.MIDDLE_NAME);
        MyWebDriverUtils.enterData(driver, Physician.MEDICAL_DEGREE_LOCATOR, LocatorType.NAME, Physician.MEDICAL_DEGREE);
        MyWebDriverUtils.enterData(driver, Physician.PHONE_NUMBER_LOCATOR, LocatorType.NAME, Physician.PHONE_NUMBER);
        MyWebDriverUtils.enterData(driver, Physician.EMAIL_ADDRESS_LOCATOR, LocatorType.NAME, Physician.EMAIL_ADDRESS);
        MyWebDriverUtils.enterData(driver, Physician.SALUTATION_LOCATOR, LocatorType.NAME, Physician.SALUTATION);
        MyWebDriverUtils.enterData(driver, Physician.FIRST_NAME_LOCATOR, LocatorType.NAME, Physician.FIRST_NAME);
        MyWebDriverUtils.enterData(driver, Physician.MEDICARE_NUMBER_LOCATOR, LocatorType.NAME, Physician.MEDICARE_NUMBER);
        MyWebDriverUtils.enterData(driver, Physician.MEDICAID_NUMBER_LOCATOR, LocatorType.NAME, Physician.MEDICAID_NUMBER);
        MyWebDriverUtils.enterData(driver, Physician.UPIN_NUMBER_LOCATOR, LocatorType.NAME, Physician.UPIN_NUMBER);
        MyWebDriverUtils.enterData(driver, Physician.STATE_LICENCE_LOCATOR, LocatorType.NAME, Physician.STATE_LICENCE);
        MyWebDriverUtils.enterData(driver, Physician.NPI_LOCATOR, LocatorType.NAME, Physician.NPI);

        MyWebDriverUtils.selectOption(driver, Physician.COMPOUND_PROFILE_LOCATOR, LocatorType.ID, Physician.COMPOUND_PROFILE);

        MyWebDriverUtils.waitContainerThenClick(driver, Physician.PLUS_ONE_ICON_LOCATOR, LocatorType.CSS);

        MyWebDriverUtils.selectOption(driver, Physician.LOCATION_LOCATOR, LocatorType.ID, Physician.LOCATION);

        MyWebDriverUtils.click(driver, Physician.CHECKBOX_ONE_LOCATOR, LocatorType.CSS);
        MyWebDriverUtils.click(driver, Physician.PLUS_TWO_ICON_LOCATOR, LocatorType.CSS);
        MyWebDriverUtils.click(driver, Physician.CHECKBOX_TWO_LOCATOR, LocatorType.CSS);
        MyWebDriverUtils.click(driver, Physician.SUBMIT_LOCATOR, LocatorType.CSS);
    }

    @Then("^New Physician is created successfully$")
    public void new_physician_is_created_successfully() {
        MyWebDriverUtils.checkCurrentUrl(driver, PHYSICIAN_LIST_URL);
        MyWebDriverUtils.checkWidgetCaption(driver, SUCCESS_UPDATE_LOCATOR, LocatorType.CSS, "x\nSuccess Clinician "+Physician.physicianUserName+" created");
    }

    /*
    Scenario: Verify updating a physician
     */

    @When("^Click Edit icon for an existing physician$")
    public void click_edit_icon_for_an_existing_physician() {
        MyWebDriverUtils.waitContainerThenClick(driver, EDIT_ICON_LOCATOR, LocatorType.CSS);
    }

    @Then("^Update Physician screen is displayed$")
    public void update_physician_screen_is_displayed() {
        MyWebDriverUtils.checkCurrentUrl(driver, UPDATE_PHYSICIAN_PAGE_URL);
        MyWebDriverUtils.checkWidgetCaption(driver, WIDGET_UPDATE_PHYSICIAN_LOCATOR, LocatorType.CSS, WIDGET_UPDATE_PHYSICIAN_VALUE);
    }

    @When("^Verify Clinician Information section$")
    public void verify_clinician_information_section() {
        if (map == null) {
            map = new HashMap<>();
        }
        WebElement userName = driver.findElement(By.id(USER_NAME_LOCATOR));
        WebElement password = driver.findElement(By.id(PASSWORD_LOCATOR));

        map.put(USER_NAME_LOCATOR, userName);
        map.put(PASSWORD_LOCATOR, password);
    }

    @Then("^Clinician Information should be locked for editing$")
    public void clinician_information_should_be_locked_for_editing() {
        Assert.assertTrue(Boolean.parseBoolean(map.get(USER_NAME_LOCATOR).getAttribute(LOCK_ATTRIBUTE)));
        Assert.assertTrue(Boolean.parseBoolean(map.get(PASSWORD_LOCATOR).getAttribute(LOCK_ATTRIBUTE)));
    }

    @When("^Make all required changes and click Update$")
    public void make_all_required_changes_and_click_update() {
        MyWebDriverUtils.enterData(driver, Physician.SALUTATION_LOCATOR, LocatorType.NAME, Physician.SALUTATION);
        MyWebDriverUtils.enterData(driver, Physician.MEDICARE_NUMBER_LOCATOR, LocatorType.NAME, Physician.MEDICARE_NUMBER);
        MyWebDriverUtils.enterData(driver, Physician.MEDICAID_NUMBER_LOCATOR, LocatorType.NAME, Physician.MEDICAID_NUMBER);

        MyWebDriverUtils.waitContainerThenClick(driver, UPDATE_BUTTON_LOCATOR, LocatorType.CSS);
    }

    @Then("^Changes should be reflected appropriately$")
    public void changes_should_be_reflected_appropriately() {
        try {
            List<WebElement> listCells = MyWebDriverUtils.getCells(driver, TABLE_LOCATOR, LocatorType.ID, 1, 8);
            if (listCells != null) {
                MyWebDriverUtils.checkCurrentUrl(driver, PHYSICIAN_LIST_URL);
                WebElement element = MyWebDriverUtils.findPresenceElement(driver, SUCCESS_UPDATE_LOCATOR, LocatorType.CSS);
                if (element != null) {
                    Assert.assertEquals(element.getText(), SUCCESS_UPDATE_MESSAGE);
                } else {
                    Assert.fail("element is null!");
                }
                Assert.assertEquals(listCells.get(4).getText(), Physician.SALUTATION);
                Assert.assertEquals(listCells.get(5).getText(), Physician.MEDICARE_NUMBER);
                Assert.assertEquals(listCells.get(6).getText(), Physician.MEDICAID_NUMBER);
            } else {
                throw new StaleElementReferenceException("listCells is null!");
            }
        } catch (StaleElementReferenceException ex) {
            changes_should_be_reflected_appropriately();
        }
    }

    /*
    Scenario: Verify the Search Results
     */

    @Then("^Physician List screen with list of Physicians should be displayed$")
    public void physician_list_screen_with_list_of_Physicians_should_be_displayed() {
        physician_list_screen_is_displayed();
        int size = MyWebDriverUtils.getRowsSize(driver, TABLE_LOCATOR, LocatorType.ID);
        Assert.assertTrue(size > 0);

    }

    @When("^Enter (.*) and click on search icon$")
    public void enter_search_criteria_and_click_on_search_icon(String criteria) {
        MyWebDriverUtils.enterData(driver, SEARCH_LOCATOR, LocatorType.CSS, criteria);
    }

    @Then("^Matching records with entered data should be displayed in the Lab Physician list, (.*), (.*)$")
    public void matching_records_with_entered_data_should_be_displayed(String cellNum, String criteria) {
        List<WebElement> listCells;
        int cell = Integer.parseInt(cellNum);
        for (int i = 1; i < 11; i++) {

            listCells = MyWebDriverUtils.getCells(driver, TABLE_LOCATOR, LocatorType.ID, i, 8);
            if(listCells == null){
                break;
            }
            String cellText = listCells.get(cell).getText();
            Assert.assertTrue(cellText.contains(criteria));
        }

    }

    /*
    Scenario Outline: Verify Number of records displayed per page
     */

    @When("^Verify the default num of records displayed$")
    public void verify_the_default_num_of_records_displayed(){
        WebElement el = MyWebDriverUtils.findElement(driver, DROP_DOWN_LOCATOR, LocatorType.NAME);
        if (el != null) {
            selectOptions = new Select(el).getAllSelectedOptions();
        }
    }

    @Then("^Default num '10' should be displayed in the dropdown box$")
    public void default_num_10_should_be_displayed_in_he_dropdown_box(){
        for (WebElement option : selectOptions) {
            Assert.assertEquals(option.getText(), DEFAULT_NUMBER_OF_RECORDS);
        }
    }

    @When("^Click on dropdown that shows (.*) of records to be displayed on the page$")
    public void click_on_dropdown(String number){
        MyWebDriverUtils.selectOption(driver, DROP_DOWN_LOCATOR, LocatorType.NAME, number);
    }

    @Then("^User should be able to view and select the options from the list and the corresponding (.*) of records should be displayed on the page$")
    public void check_number_of_records(String number){
        WebElement table = driver.findElement(By.id(TABLE_LOCATOR));
        int size = table.findElements(By.tagName(ROWS_LOCATOR)).size() - 1;

        WebElement element = driver.findElement(By.id(PAGINATE_LOCATOR));
        List<WebElement> list = element.findElements(By.tagName(LIST_LOCATOR));

        if (number.equals(ALL_NUMBER_OF_RECORDS)) {
            Assert.assertEquals(list.size(), 2);
        } else{
            int num = Integer.parseInt(number);
            if(num > size){
                Assert.assertEquals(list.size(), 3);
            } else {
                Assert.assertEquals(num, size);
            }
        }
    }

    /*
    Scenario Outline: Verify data sorting
     */

    @When("^Click on down arrow icon on (.*)$")
    public void click_on_down_arrow_icon(String column){
        String locator = chooseLocator(column);
        MyWebDriverUtils.waitContainerThenClick(driver, locator, LocatorType.CSS);
    }

    @Then("^Records should be displayed  on the ascending order of the selected field$")
    public void records_should_be_displayed_on_the_ascending_order(){
        try {
            WebElement table = driver.findElement(By.id(TABLE_LOCATOR));
            List<WebElement> allRows = table.findElements(By.tagName(ROWS_LOCATOR));
            int j;
            j = getSortColumn(allRows);
            String temp = allRows.get(1).findElements(By.xpath(CELLS_LOCATOR)).get(j).getText();

            for (int i = 2; i < allRows.size(); i++) {
                if (temp.toLowerCase().contains(allRows.get(i).findElements(By.xpath(CELLS_LOCATOR)).get(j).getText().toLowerCase())) {
                    Assert.assertTrue(true);
                } else {
                    int order = temp.toLowerCase().compareTo(allRows.get(i).findElements(By.xpath(CELLS_LOCATOR)).get(j).getText().toLowerCase());
                    Assert.assertTrue(order <= 0);
                }
            }
        } catch (StaleElementReferenceException ex){
            records_should_be_displayed_on_the_ascending_order();
        }
    }

    @When("^Click on up arrow icon on (.*)$")
    public void click_on_up_arrow_icon(String column){
        MyWebDriverUtils.waitContainerThenClick(driver, SORT_ASCENDING_LOCATOR, LocatorType.CSS);
    }

    @Then("^Records should be displayed  on the descendig order of the selected field$")
    public void records_should_be_displayed_on_the_descending_order(){
        int j;

        WebElement table = driver.findElement(By.id(TABLE_LOCATOR));

        List<WebElement> allRows = table.findElements(By.tagName(ROWS_LOCATOR));

        j = getSortDescColumn(allRows);

        String temp = allRows.get(1).findElements(By.xpath(CELLS_LOCATOR)).get(j).getText();

        for (int i = 2; i < allRows.size(); i++) {
            int order = temp.toLowerCase().compareTo(allRows.get(i).findElements(By.xpath(CELLS_LOCATOR)).get(j).getText().toLowerCase());
            Assert.assertTrue(order >= 0);
        }
    }

    private String chooseLocator(String column) {
        switch (column) {
            case "Username":
                return "#example > thead > tr > th:nth-child(2)";
            case "Name":
                return "#example > thead > tr > th:nth-child(3)";
            case "Lab Clients":
                return "#example > thead > tr > th:nth-child(4)";
            case "Salutation":
                return "#example > thead > tr > th:nth-child(5)";
            case "Medicare Num":
                return "#example > thead > tr > th:nth-child(6)";
            case "Medicaid Num":
                return "#example > thead > tr > th:nth-child(7)";
        }
        return null;
    }

    private int getSortColumn(List<WebElement> rows) {
        for (int i = 2; i < 8; i++) {
            if (rows.get(0).findElements(By.xpath(CELLS_LOCATOR)).get(i)
                    .getAttribute(SORT_ATTRIBUTE_LOCATOR) != null &&
                    rows.get(0).findElements(By.xpath(CELLS_LOCATOR)).get(i)
                            .getAttribute(SORT_ATTRIBUTE_LOCATOR).equals(SORT_ATTRIBUTE_VALUE)) {
                return i;
            }
        }
        return 0;
    }
    private int getSortDescColumn(List<WebElement> rows) {
        for (int i = 2; i < 8; i++) {
            if (rows.get(0).findElements(By.xpath(CELLS_LOCATOR)).get(i)
                    .getAttribute(SORT_ATTRIBUTE_LOCATOR) != null &&
                    rows.get(0).findElements(By.xpath(CELLS_LOCATOR)).get(i)
                            .getAttribute(SORT_ATTRIBUTE_LOCATOR).equals(SORT_DESCENDING_VALUE)) {
                return i;
            }
        }
        return 0;
    }

    /*
    Scenario Outline: Verify the page navigation
     */

    @When("^Navigate back and forth by selecting page number (.*)$")
    public void navigate(String button){
        int i;

        if (button.equals("Prev") || button.equals("1")) {
            MyWebDriverUtils.waitContainerThenClick(driver, "#example_paginate > ul > li:nth-child(3) > a", LocatorType.CSS);
        }

        String locator = chooseButtonLocator(button);
        if (locator != null) {
            MyWebDriverUtils.waitContainerThenClick(driver, locator, LocatorType.CSS);
        }

        navigateButton = button;
    }

    @Then("^User should be navigate to the selected page.$")
    public void user_should_be_navigate_to_the_selected_page(){
        WebElement el = MyWebDriverUtils.findElement(driver, PAGINATION_LOCATOR, LocatorType.CSS);
        if (el != null) {
            List<WebElement> list = MyWebDriverUtils.findElements(driver, LIST_LOCATOR, LocatorType.TAG, el);
            if (list != null) {
                WebElement activeButton;
                String attribute;
                switch (navigateButton) {
                    case "Next":
                        activeButton = list.get(2);
                        attribute = activeButton.getAttribute(ATTRIBUTE_CLASS_LOCATOR);
                        Assert.assertEquals(attribute, "active");
                        break;
                    case "Prev":
                        activeButton = list.get(1);
                        attribute = activeButton.getAttribute(ATTRIBUTE_CLASS_LOCATOR);
                        Assert.assertEquals(attribute, "active");
                        break;
                    default:
                        int num = Integer.parseInt(navigateButton);
                        activeButton = list.get(num);
                        attribute = activeButton.getAttribute(ATTRIBUTE_CLASS_LOCATOR);
                        Assert.assertEquals(attribute, "active");
                }
            }

        }
    }

    @Then("^A text message 'Showing x to y of z entries' should be displayed on the bottom left corner of the list.$")
    public void show_messqge(){
        WebElement el = MyWebDriverUtils.findElement(driver, MESSAGE_LOCATOR, LocatorType.CSS);
        if(el != null){
            String message = el.getText();
            Assert.assertTrue(message.contains("Showing"));
            Assert.assertTrue(message.contains("to"));
            Assert.assertTrue(message.contains("of"));
            Assert.assertTrue(message.contains("entries"));
        }
    }

    private String chooseButtonLocator(String button) {
        switch (button) {
            case "Next":
                return "#example_paginate > ul > li.next > a";
            case "Prev":
                return "#example_paginate > ul > li.prev > a";
            case "1":
                return "#example_paginate > ul > li:nth-child(2) > a";
            case "2":
                return "#example_paginate > ul > li:nth-child(3) > a";
        }
        return null;
    }

    private static final class Physician {
        private Physician() {
        }

        private static String physicianUserName;
        private static final String PASSWORD = "Welcome@123";
        private static final String FIRST_NAME = "Alexander";
        private static final String MIDDLE_NAME = "Khasanovich";
        private static final String LAST_NAME = "Bainaiev";
        private static final String MEDICAL_DEGREE = "Master";
        private static final String PHONE_NUMBER = "1111111111";
        private static final String EMAIL_ADDRESS = "master@gmail.com";
        private static final String SALUTATION = "Salutation";
        private static final String MEDICARE_NUMBER = "123";
        private static final String MEDICAID_NUMBER = "456";
        private static final String UPIN_NUMBER = "789";
        private static final String STATE_LICENCE = "licence";
        private static final String NPI = "npi";
        private static final String COMPOUND_PROFILE = "Test Profile 1";
        private static final String LAB_CLIENT = "CGI Tox Client1";
        private static final String LOCATION = "Location";


        private static final String USER_NAME_LOCATOR = "user.username";
        private static final String PASSWORD_LOCATOR = "user.password";
        private static final String FIRST_NAME_LOCATOR = "user.firstName";
        private static final String MIDDLE_NAME_LOCATOR = "user.middleIntial";
        private static final String LAST_NAME_LOCATOR = "user.lastName";
        private static final String MEDICAL_DEGREE_LOCATOR = "user.medicalDegree";
        private static final String PHONE_NUMBER_LOCATOR = "user.contact";
        private static final String EMAIL_ADDRESS_LOCATOR = "user.email";
        private static final String SALUTATION_LOCATOR = "salutation";
        private static final String MEDICARE_NUMBER_LOCATOR = "medicare_num";
        private static final String MEDICAID_NUMBER_LOCATOR = "medicaid_num";
        private static final String UPIN_NUMBER_LOCATOR = "upin_num";
        private static final String STATE_LICENCE_LOCATOR = "state_license";
        private static final String NPI_LOCATOR = "npi";
        private static final String COMPOUND_PROFILE_LOCATOR = "profiles";
        private static final String LAB_CLIENT_LOCATOR = "labclientselect";
        private static final String LOCATION_LOCATOR = "lablocations";
        private static final String PLUS_ONE_ICON_LOCATOR = "#form > div:nth-child(13) > div:nth-child(2) > button";
        private static final String PLUS_TWO_ICON_LOCATOR = "#form > div:nth-child(18) > div:nth-child(3) > button";
        private static final String CHECKBOX_ONE_LOCATOR = "#form > table:nth-child(16) > tbody > tr:nth-child(1) > td:nth-child(2) > div > label > span";
        private static final String CHECKBOX_TWO_LOCATOR = "#form > table:nth-child(21) > tbody > tr:nth-child(1) > td:nth-child(2) > div > label > span";
        private static final String SUBMIT_LOCATOR = "#form > button.btn.btn-primary.btn-md";

    }
}
