package com.easytox.automation.steps;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 15.12.2016.
 */
public class LabClientImpl {

    private static final String PASSWORD = "Welcome@123";
    private static final String LOGIN = "cgilabadmin";
    private static final String LOGIN_PAGE_URL = "http://bmtechsol.com:8080/easytox/";
    private static final String FIND_USERNAME = "j_username";
    private static final String FIND_LOGIN = "j_password";
    private static final String LOGIN_BUTTON_XPATH = "//*[@id=\"loginform\"]/div[3]/div/button";
    private static final String SETTINGS_LOCATOR = "body > div.navbar > div > div > div.navbar-header.pull-right > div > ul > li:nth-child(8) > a";
    private static final String LAB_CLIENT_LOCATOR = "#topmenu > li:nth-child(5) > a";
    private static final String LAB_CLIENT_URL = "http://bmtechsol.com:8080/easytox/labClient/list";
    private static final String CONTAINER_LOCATOR = "loadingDiv";
    private static final String ADD_LIB_CLIENT_LOCATOR = "#example_wrapper > div.toolbar > a";
    private static final String BUSINESS_NAME_LOCATOR = "business_name";
    private static final String BUSINESS_NAME_VALUE = "business";
    private static final String ADDRESS_1_LOCATOR = "address_1";
    private static final String ADDRESS_1_VALUE = "address1";
    private static final String ADDRESS_2_LOCATOR = "address_2";
    private static final String ADDRESS_2_VALUE = "address2";
    private static final String ZIP_LOCATOR = "zip";
    private static final String ZIP_VALUE = "12345";
    private static final String CITY_LOCATOR = "city";
    private static final String CITY_VALUE = "Kharkiv";
    private static final String STATE_LOCATOR = "state";
    private static final String STATE_VALUE = "Kharkiv State";
    private static final String CONTACT_PERSON_LOCATOR = "contact_person";
    private static final String CONTACT_PERSON_VALUE = "Alexander";
    private static final String CONTACT_NUMBER_LOCATOR = "contact_number";
    private static final String CONTACT_NUMBER_VALUE = "1234567890";
    private static final String CONTACT_NUMBER_REAL_VALUE = "(123) 456-7890";
    private static final String FAX_NUMBER_LOCATOR = "faxNumber";
    private static final String FAX_NUMBER_VALUE = "9876543210";
    private static final String CONTACT_EMAIL_LOCATOR = "contact_email";
    private static final String CONTACT_EMAIL_VALUE = "bink@gmail.com";
    private static final String WIDGET_ADD_LOCATOR = "#maincontentdiv > div.page-body > div > div.widget-header.bg-blue > span";
    private static final String WIDGET_ADD_VALUE = "Add Lab Client";
    private static final String FORM_LOCATOR = "form";
    private static final String FORM_METHOD_ATTRIBUTE = "method";
    private static final String FORM_METHOD_VALUE = "post";
    private static final String SUBMIT_BUTTON_LOCATOR = "#form > div:nth-child(12) > div > button";

    private static final String SUCCESS_LOCATOR = "#maincontentdiv > div.page-body > div.alert.alert-success.fade.in > strong";
    private static final String SUCCESS_VALUE = "Success";
    // private static final String NEXT_BUTTON_LOCATOR = "#example_paginate > ul > li.next > a";
    private static final String PAGINATION_LOCATOR = "#example_paginate > ul";
    private static final String DROP_DOWN_LOCATOR = "example_length";
    private static final String DROP_DOWN_ALL_VALUE = "All";
    private static final String LAB_CLIENT_VALUE = "CGI DEMO Lab";
    private static final String LAB_CLIENT_ANOTHER_VALUE = "CGI Tox Client1";
    private static final String REGEX = ", ";
    private static final String LAB_CLIENT_NAME = "#editlink";
    private static final String WIDGET_UPDATE_LOCATOR = "#maincontentdiv > div.page-body > div > div.widget-header.bg-danger > span";
    private static final String WIDGET_UPDATE_VALUE = "Update Lab Client";
    private static final String EDIT_LAB_CLIENT_URL = "http://bmtechsol.com:8080/easytox/labClient/edit";

    private static final String ADD_LOCATION_LOCATOR = "#maincontentdiv > div.page-body > div > div.widget-header.bg-danger > div > div:nth-child(1) > form > a";
    private static final String ADD_LAB_LOCATION_URL = "http://bmtechsol.com:8080/easytox/labLocation/create";
    private static final String WIDGET_ADD_LAB_LOCATION_LOCATOR = "#maincontentdiv > div.page-body > div > div.widget-header.bg-blue > span";
    private static final String WIDGET_ADD_LAB_LOCATION_VALUE = "Add Lab Location";


    private static final String LAB_LOCATION_NAME_LOCATOR = "lab_location_name";
    private static final String LAB_LOCATION_DEPARTMENT_LOCATOR = "lab_location_department";
    private static final String LAB_LOCATION_ADDRESS_LOCATOR = "lab_location_address";
    private static final String LAB_LOCATION_NAME_VALUE = "New Lab Location Name";
    private static final String LAB_LOCATION_DEPARTMENT_VALUE = "New Department";
    private static final String LAB_LOCATION_ADDRESS_VALUE = "New Address";
    private static final String EDIT_SUBMIT_LOCATOR = "#form > div:nth-child(7) > div > button";
    private static final String SAVE_LOCATION_URL = "http://bmtechsol.com:8080/easytox/labLocation/save";
    private static final String WIDGET_LAB_LOCATION_LIST_LOCATOR = "#maincontentdiv > div.page-body > div.row > div > div > div.widget-header > span";
    private static final String WIDGET_LAB_LOCATION_LIST_VALUE = "Lab Location List";
    private static final String WIDGET_LAB_LOCATION_LIST_ANOTHER_LOCATOR = "#maincontentdiv > div.page-body > div > div > div > div.widget-header > span";

    private static final String LOCATION_LIST_LOCATOR = "#example > tbody > tr:nth-child(1) > td:nth-child(9) > div > div:nth-child(2) > form > a";
    private static final String LAB_LOCATION_LIST_URL = "http://bmtechsol.com:8080/easytox/labLocation/locationlist";
    private static final String EDIT_ICON_LOCATOR = "#editlink";
    private static final String EDIT_LAB_LOCATION_LIST_URL = "http://bmtechsol.com:8080/easytox/labLocation/edit";

    private static final String WIDGET_UPDATE_LOCATION_LOCATOR = "#maincontentdiv > div.page-body > div > div.widget-header.bg-blue > span";
    private static final String WIDGET_UPDATE_LOCATION_VALUE = "Update Lab Location";
    private static final String UPDATE_SUBMIT_LOCATOR = "#form > div:nth-child(6) > div > button";
    private static final String UPDATE_SUCCESS_URL = "http://bmtechsol.com:8080/easytox/labLocation/update/1011";

    private static final String ADD_USER_ICON_LOCATOR = "#maincontentdiv > div.page-body > div > div.widget-header.bg-danger > div > div:nth-child(2) > form > a";
    private static final String ADD_LAB_CLIENT_USER_URL = "http://bmtechsol.com:8080/easytox/user/clientusercreate";
    private static final String WIDGET_ADD_LAB_CLIENT_USER_VALUE = "Add Lab Client User";


    private static final String USER_USERNAME_LOCATOR = "username";
    private static final String USER_PASSWORD_LOCATOR = "password";
    private static final String USER_FIRST_NAME_LOCATOR = "#form > div:nth-child(6) > div:nth-child(1) > div > span > input";
    private static final String USER_LAST_NAME_LOCATOR = "#form > div:nth-child(6) > div:nth-child(2) > div > span > input";
    private static final String USER_EMAIL_LOCATOR = "email";
    private static final String USER_PHONE_NUMBER_LOCATOR = "contact";
    private static final String SELECT_ROLE_LOCATOR = "#form > div:nth-child(9) > select";
    private static final String LAB_LOCATIONS_LOCATOR = "lablocations";
    private static final String USER_SUBMIT_LOCATOR = "#form > div:nth-child(12) > button";

    private static final String USER_PASSWORD_VALUE = "Welcome@123";
    private static final String USER_FIRST_NAME_VALUE = "Henry";
    private static final String USER_LAST_NAME_VALUE = "Ford";
    private static final String USER_EMAIL_VALUE = "bink@gmail.com";
    private static final String USER_PHONE_NUMBER_VALUE = "1234567890";
    private static final String ROLE = "OFFICE_ADMIN";
    private static final String LAB_LOCATIONS_VALUE = "Location";
    private static final String CLIENT_USER_LIST_URL = "http://bmtechsol.com:8080/easytox/user/clientusersave";
    private static final String USER_CONTACT = "(123) 456-7890";

    private static final String USER_ICON_LOCATOR = "#example > tbody > tr:nth-child(1) > td:nth-child(9) > div > div:nth-child(3) > form > a";
    private static final String USER_LIST_PAGE_URL = "http://bmtechsol.com:8080/easytox/user/userslist";
    private static final String WIDGET_USER_LIST_LOCATOR = "#maincontentdiv > div.page-body > div > div > div > div.widget-header > span";
    private static final String WIDGET_USER_LIST_VALUE = "User List";
    private static final String EDIT_LIST_PAGE_ICON_LOCATOR = "#example > tbody > tr:nth-child(1) > td:nth-child(8) > div > div:nth-child(1) > form > a";
    private static final String UPDATE_LAB_USER_PAGE_URL = "http://bmtechsol.com:8080/easytox/user/edit";
    private static final String WIDGET_UPDATE_LAB_USER_VALUE = "Update Lab User";
    private static final String UPDATE_BUTTON_LOCATOR = "#form > div:nth-child(9) > button";
    private static final String CLIENT_USERS_LIST_URL = "http://bmtechsol.com:8080/easytox/user/userslist";
    private static final String CLIENT_USER_NAME = "CGIclient1admin";
    private static final String PLUS_ICON_LOCATOR = "#example > tbody > tr:nth-child(1) > td.details-control.sorting_1";

    private static final String LOCK_ICON_LOCATOR = "#example > tbody > tr:nth-child(4) > td:nth-child(8) > div > div:nth-child(2) > form > a";
    private static final String LOCK_LOCATOR = "#example > tbody > tr:nth-child(4) > td:nth-child(8) > div > div:nth-child(2) > form > a > i";
    private static final String LOCK_VALUE = "fa fa-lock fa-2x";
    private static final String MESSAGE_LOCATOR = "#maincontentdiv > div.page-body > div.alert.alert-success.fade.in";
    private static final String MESSAGE_VALUE = "x\nSuccess User DRTN1P3XBS locked sucessfully";
    private static final String FIRST_CGI_LAST_CGI_LOCATOR = "body > div.navbar > div > div > div.navbar-header.pull-right > div > ul > li:nth-child(7) > a";
    private static final String SIGN_OUT_LOCATOR = "body > div.navbar > div > div > div.navbar-header.pull-right > div > ul > li.open > ul > li.dropdown-footer > a";

    private static final String LOCK_USER = "DRTN1P3XBS";
    private static final String LOCKED_MESSAGE_LOCATOR = "body > div > div > div > div > div.panel-body > div";

    private static final String ADD_NOTES_ICON_LOCATOR = "#maincontentdiv > div.page-body > div > div.widget-header.bg-danger > div > div:nth-child(3) > form > a";
    private static final String UPDATE_LAB_CLIENTS_NOTES_URL = "http://bmtechsol.com:8080/easytox/labClient/createNotes";
    private static final String WIDGET_UPDATE_NOTES_VALUE = "Update Lab Client Notes";
    private static final String NOTES_PLUS_ICON_LOCATOR = "#labClientNotesDiv > div.row.bg-blue > div > button";
    private static final String NEW_NOTE_LOCATOR = "labClientNote";
    private static final String NEW_NOTE_VALUE = "My notes";
    private static final String UPDATE_NOTES_BUTTON_LOCATOR = "#form > div > div:nth-child(2) > button";
    private static final String NOTES_ALERT_VALUE = "Notes For CGI Tox Client1 updated";
    private static final String UPDATE_NOTES_URL = "http://bmtechsol.com:8080/easytox/labClient/updateNotes";
    private static final String ICON_NOTES_LOCATOR = "#labClientNote0";
    private static final String NOTE_UNLOCK_FOR_EDIT_LOCATOR = "data-bv-field";
    private static final String NOTE_UNLOCK_FOR_EDIT_CLASS_VALUE = "form-control";

    private static final String CLINICIAN_ICON_LOCATOR = "#example > tbody > tr:nth-child(1) > td:nth-child(9) > div > div:nth-child(1) > form > a";
    private static final String CLINICIAN_LIST_URL = "http://bmtechsol.com:8080/easytox/clinician/clinicianslist";
    private static final String WIDGET_CLINITIAN_LIST_VALUE = "Clinician List";
    private static final String ADD_PHYSICIAN_LOCATOR = "#newCreate";
    private static final String ADD_PHYSICIAN_URL = "http://bmtechsol.com:8080/easytox/clinician/create?labclient=1017";
    private static final String ADD_PHYSICIAN_VALUE = "Add Physician";

    private static final String SEARCH_LOCATOR = "#example_filter > label > input";
    private static final String SEARCH_BUSINESS_NAME = "Demo Client";
    private static final String SEARCH_CITY = "Dublin";
    private static final String SEARCH_STATE = "OH";
    private static final String SEARCH_ZIP = "43016";
    private static final String SEARCH_CONTACT_PERSON = "Demoperson";
    private static final String SEARCH_CONTACT_NUMBER = "(111) 111-1111";
    private static final String SEARCH_EMAIL = "test@gmail.com";

    private static final String DROP_DOWN_SELECT_LOCATOR = "#example_length > label > select";
    private static final String PAGINATE_LOCATOR = "example_paginate";
    private static final String DEFAULT_NUMBER_OF_RECORDS = "10";
    private static final String ALL_NUMBER_OF_RECORDS = "All";

    private static final String SORT_ATTRIBUTE_LOCATOR = "aria-sort";
    private static final String SORT_ATTRIBUTE_VALUE = "ascending";
    private static final String SORT_DESCENDING_VALUE = "descending";
    private static final String SORT_ASCENDING_LOCATOR = "#example > thead > tr > th.sorting_asc";


    private static final String CELLS_LOCATOR = "./*";
    private static final String CELL_LOCATOR = "td";
    private static final String TBODY_LOCATOR = "tbody";
    private static final String ROWS_LOCATOR = "tr";
    private static final String TABLE_LOCATOR = "example";
    private static final String LIST_LOCATOR = "li";
    private static final String LINK_LOCATOR = "a";

    private static final int TIME_STOP = 2000;
    private static final int TIME_OUT_IN_SECONDS = 10;

    private static final String ATTRIBUTE_VALUE_LOCATOR = "value";
    private static final String ATTRIBUTE_CLASS_LOCATOR = "class";

    private static String userNameValue;
    private static int count;
    private static WebElement userNameEl;
    private static WebElement passwordEl;
    private static List<Boolean> searchResult;
    private static List<WebElement> selectOptions;
    private static String navigateButton;


    private WebDriver driver;

    public LabClientImpl() {
        DriverBase.instantiateDriverObject();
        driver = DriverBase.getDriver();
    }

    /*
      Scenario: Verify creation of a new lab client
     */

    @Given("^Login in web app$")
    public void login() {
        authorization();
    }

    @When("^Select Settings -> Lab Client$")
    public void select_settings_then_lab_client() {
        WebElement el = MyWebDriverUtils.findElement(driver, SETTINGS_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(el);
        } else {
            Assert.fail("flag is false!");
        }

        WebElement lab = MyWebDriverUtils.findElement(driver, LAB_CLIENT_LOCATOR, LocatorType.CSS);
        checkAndClick(lab);

    }

    @Then("^Lab Client List screen with list of Clients is displayed$")
    public void list_displayed() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, LAB_CLIENT_URL);
    }

    @When("^Click Add Lab Client '\\+' icon displayed$")
    public void click_plus_icon() {
        WebElement el = MyWebDriverUtils.findElement(driver, ADD_LIB_CLIENT_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(el);
        } else {
            Assert.fail("flag is false!");
        }
    }

    @Then("^Add Lab Client screen is displayed$")
    public void add_lab_client_scrren_is_displayed() {
        WebElement el = MyWebDriverUtils.findPresenceElement(driver, WIDGET_ADD_LOCATOR, LocatorType.CSS);
        if (el != null) {
            String title = el.getText();
            Assert.assertEquals(title, WIDGET_ADD_VALUE);
        }

        WebElement form = MyWebDriverUtils.findPresenceElement(driver, FORM_LOCATOR, LocatorType.ID);
        if (form != null) {
            String method = form.getAttribute(FORM_METHOD_ATTRIBUTE);
            Assert.assertEquals(method, FORM_METHOD_VALUE);
        }

    }


    @When("^Enter all the information in the screen and click Submit$")
    public void enter_all_the_information_in_the_screen_and_click_submit() {
        WebElement business = MyWebDriverUtils.findElement(driver, BUSINESS_NAME_LOCATOR, LocatorType.NAME);
        if (business != null) {
            business.clear();
            business.sendKeys(BUSINESS_NAME_VALUE);
        } else {
            Assert.fail("business is null!");
        }

        WebElement address1 = MyWebDriverUtils.findElement(driver, ADDRESS_1_LOCATOR, LocatorType.NAME);
        if (address1 != null) {
            address1.clear();
            address1.sendKeys(ADDRESS_1_VALUE);
        } else {
            Assert.fail("address1 is null!");
        }

        WebElement address2 = MyWebDriverUtils.findElement(driver, ADDRESS_2_LOCATOR, LocatorType.NAME);
        if (address2 != null) {
            address2.clear();
            address2.sendKeys(ADDRESS_2_VALUE);
        } else {
            Assert.fail("address2 is null!");
        }

        WebElement zipCode = MyWebDriverUtils.findElement(driver, ZIP_LOCATOR, LocatorType.ID);
        if (zipCode != null) {
            zipCode.clear();
            zipCode.sendKeys(ZIP_VALUE);
        } else {
            Assert.fail("zipCode is null!");
        }

        WebElement city = MyWebDriverUtils.findElement(driver, CITY_LOCATOR, LocatorType.ID);
        if (city != null) {
            city.clear();
            city.sendKeys(CITY_VALUE);
        } else {
            Assert.fail("city is null!");
        }

        WebElement state = MyWebDriverUtils.findElement(driver, STATE_LOCATOR, LocatorType.ID);
        if (state != null) {
            state.clear();
            state.sendKeys(STATE_VALUE);
        } else {
            Assert.fail("state is null!");
        }

        WebElement contactPerson = MyWebDriverUtils.findElement(driver, CONTACT_PERSON_LOCATOR, LocatorType.NAME);
        if (contactPerson != null) {
            contactPerson.clear();
            contactPerson.sendKeys(CONTACT_PERSON_VALUE);
        } else {
            Assert.fail("contactPerson is null!");
        }

        WebElement contactNumber = MyWebDriverUtils.findElement(driver, CONTACT_NUMBER_LOCATOR, LocatorType.NAME);
        if (contactNumber != null) {
            contactNumber.clear();
            contactNumber.sendKeys(CONTACT_NUMBER_VALUE);
        } else {
            Assert.fail("contactNumber is null!");
        }

        WebElement faxNumber = MyWebDriverUtils.findElement(driver, FAX_NUMBER_LOCATOR, LocatorType.NAME);
        if (faxNumber != null) {
            faxNumber.clear();
            faxNumber.sendKeys(FAX_NUMBER_VALUE);
        } else {
            Assert.fail("faxNumber is null!");
        }

        WebElement contactEmail = MyWebDriverUtils.findElement(driver, CONTACT_EMAIL_LOCATOR, LocatorType.NAME);
        if (contactEmail != null) {
            contactEmail.clear();
            contactEmail.sendKeys(CONTACT_EMAIL_VALUE);
        } else {
            Assert.fail("contactEmail is null!");
        }

        WebElement submit = MyWebDriverUtils.findElement(driver, SUBMIT_BUTTON_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(submit);
        } else {
            Assert.fail("flag is false!");
        }


    }

    @Then("^New lab client is added successfully and newly added lab client is listed in the Lab Client List screen$")
    public void check_added_lab_client() throws InterruptedException {
        if (count == 0) {
            WebElement el = MyWebDriverUtils.findElement(driver, DROP_DOWN_SELECT_LOCATOR, LocatorType.CSS);
            if(el != null){
                new Select(el).selectByVisibleText(DROP_DOWN_ALL_VALUE);
            }


        }

        try {
            count++;
            final WebElement table = MyWebDriverUtils.findElement(driver, TABLE_LOCATOR, LocatorType.ID);
            if (table != null) {

                List<WebElement> listRows = MyWebDriverUtils.findElements(driver, ROWS_LOCATOR, LocatorType.TAG, table);
                if (listRows != null) {
                    int size = listRows.size();
                    List<WebElement> listCells = MyWebDriverUtils.findElements(driver, CELL_LOCATOR, LocatorType.TAG, listRows.get(size - 1));

                    if (listCells != null && listCells.size() == 9) {
                        Assert.assertEquals(listCells.get(2).getText(), CITY_VALUE);
                        Assert.assertEquals(listCells.get(3).getText(), STATE_VALUE);
                        Assert.assertEquals(listCells.get(4).getText(), ZIP_VALUE);
                        Assert.assertEquals(listCells.get(5).getText(), CONTACT_PERSON_VALUE);
                        Assert.assertEquals(listCells.get(6).getText(), CONTACT_NUMBER_REAL_VALUE);
                        Assert.assertEquals(listCells.get(7).getText(), CONTACT_EMAIL_VALUE);
                    } else {
                        throw new StaleElementReferenceException("listCells size is not equal 9");
                    }

                } else {
                    Assert.fail("listRows is null!");
                }
            } else {
                Assert.fail("table is null!");
            }
        } catch (StaleElementReferenceException ex) {
            check_added_lab_client();
        }
        WebElement el = MyWebDriverUtils.findPresenceElement(driver, SUCCESS_LOCATOR, LocatorType.CSS);
        if (el != null) {
            String elValue = el.getText();
            Assert.assertEquals(elValue, SUCCESS_VALUE);
            count = 0;
        } else {
            Assert.fail("el is false!");
        }
    }

    @When("^Click '\\+' icon against newly created lab client$")
    public void click_plus_icon_against_newly_created_lab_clients() {
        try {
            final WebElement table = MyWebDriverUtils.findElement(driver, TABLE_LOCATOR, LocatorType.ID);
            if (table != null) {

                List<WebElement> listRows = MyWebDriverUtils.findElements(driver, ROWS_LOCATOR, LocatorType.TAG, table);
                if (listRows != null) {
                    int size = listRows.size();
                    List<WebElement> listCells = MyWebDriverUtils.findElements(driver, CELL_LOCATOR, LocatorType.TAG, listRows.get(size - 1));

                    if (listCells != null && listCells.size() == 9) {
                        WebElement el = listCells.get(0);
                        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

                        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
                        if (flag) {
                            checkAndClick(el);
                        } else {
                            Assert.fail("flag is false!");
                        }
                    } else {
                        throw new StaleElementReferenceException("listCells size is not equal 9");
                    }

                } else {
                    Assert.fail("listRows is null!");
                }
            } else {
                Assert.fail("table is null!");
            }
        } catch (StaleElementReferenceException ex) {
            click_plus_icon_against_newly_created_lab_clients();
        }
    }

    @Then("^Following values should be populated: Address - it should populate entered Address lines 1 and 2 Lab - it should populate Lab name$")
    public void check_populate_fields() {
        try {
            final WebElement table = MyWebDriverUtils.findElement(driver, TABLE_LOCATOR, LocatorType.ID);
            if (table != null) {
                List<WebElement> listRows = MyWebDriverUtils.findElements(driver, ROWS_LOCATOR, LocatorType.TAG, table);
                if (listRows != null) {
                    int size = listRows.size();
                    List<WebElement> listCells = MyWebDriverUtils.findElements(driver, CELL_LOCATOR, LocatorType.TAG, listRows.get(size - 1));

                    if (listCells != null && listCells.size() == 2) {
                        WebElement labCell = listCells.get(1);
                        Assert.assertEquals(labCell.getText(), LAB_CLIENT_VALUE);

                    } else {
                        throw new StaleElementReferenceException("listCells size is not equal 2");
                    }

                    List<WebElement> addressCells = MyWebDriverUtils.findElements(driver, CELL_LOCATOR, LocatorType.TAG, listRows.get(size - 2));

                    if (addressCells != null && addressCells.size() == 2) {
                        WebElement addressCell = addressCells.get(1);
                        String[] address = addressCell.getText().split(REGEX);
                        Assert.assertEquals(address[0], ADDRESS_1_VALUE);
                        Assert.assertEquals(address[1], ADDRESS_2_VALUE);

                    } else {
                        throw new StaleElementReferenceException("addressCells size is not equal 2");
                    }

                } else {
                    Assert.fail("listRows is null!");
                }
            } else {
                Assert.fail("table is null!");
            }
        } catch (StaleElementReferenceException ex) {
            check_populate_fields();
        }
    }

    /*
      Scenario: Verify updating data for an existing lab client
     */


    @When("^Click on a lab client name$")
    public void click_on_a_lab_client_name() {
        WebElement el = MyWebDriverUtils.findElement(driver, LAB_CLIENT_NAME, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(el);
        } else {
            Assert.fail("flag is false!");
        }
    }

    @Then("^Update Lab Client screen is displayed$")
    public void update_lab_client_screen_is_displayed() {
        WebElement el = MyWebDriverUtils.findPresenceElement(driver, WIDGET_UPDATE_LOCATOR, LocatorType.CSS);
        if (el != null) {
            String title = el.getText();
            Assert.assertEquals(title, WIDGET_UPDATE_VALUE);
        }

        WebElement form = MyWebDriverUtils.findPresenceElement(driver, FORM_LOCATOR, LocatorType.ID);
        if (form != null) {
            String method = form.getAttribute(FORM_METHOD_ATTRIBUTE);
            Assert.assertEquals(method, FORM_METHOD_VALUE);
        }

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, EDIT_LAB_CLIENT_URL);
    }

    @When("^Make changes as needed and click update$")
    public void make_changes_as_needed_and_click_update() {

        WebElement address1 = MyWebDriverUtils.findElement(driver, ADDRESS_1_LOCATOR, LocatorType.NAME);
        if (address1 != null) {
            address1.clear();
            address1.sendKeys(ADDRESS_1_VALUE);
        } else {
            Assert.fail("address1 is null!");
        }

        WebElement address2 = MyWebDriverUtils.findElement(driver, ADDRESS_2_LOCATOR, LocatorType.NAME);
        if (address2 != null) {
            address2.clear();
            address2.sendKeys(ADDRESS_2_VALUE);
        } else {
            Assert.fail("address2 is null!");
        }

        WebElement faxNumber = MyWebDriverUtils.findElement(driver, FAX_NUMBER_LOCATOR, LocatorType.NAME);
        if (faxNumber != null) {
            faxNumber.clear();
            faxNumber.sendKeys(FAX_NUMBER_VALUE);
        } else {
            Assert.fail("faxNumber is null!");
        }

        WebElement submit = MyWebDriverUtils.findElement(driver, SUBMIT_BUTTON_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(submit);
        } else {
            Assert.fail("flag is false!");
        }
    }

    @Then("^Lab client is updated successfully$")
    public void lab_client_is_updated_successfully() {
        WebElement el = driver.findElement(By.cssSelector(MESSAGE_LOCATOR));
        Assert.assertTrue(el.isDisplayed());

        WebElement el1 = MyWebDriverUtils.findPresenceElement(driver, SUCCESS_LOCATOR, LocatorType.CSS);
        if (el1 != null) {
            String elValue = el1.getText();
            Assert.assertEquals(elValue, SUCCESS_VALUE);
        } else {
            Assert.fail("el is false!");
        }
    }

    @When("^Click '\\+' icon against updated lab client$")
    public void click_plus_icon_against_updated_lab_client() {
        final WebElement table = MyWebDriverUtils.findElement(driver, TABLE_LOCATOR, LocatorType.ID);
        if (table != null) {

            List<WebElement> listRows = MyWebDriverUtils.findElements(driver, ROWS_LOCATOR, LocatorType.TAG, table);
            if (listRows != null) {
                List<WebElement> listCells = MyWebDriverUtils.findElements(driver, CELL_LOCATOR, LocatorType.TAG, listRows.get(1));

                if (listCells != null && listCells.size() == 9) {
                    WebElement el = listCells.get(0);
                    WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

                    boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
                    if (flag) {
                        checkAndClick(el);
                    } else {
                        Assert.fail("flag is false!");
                    }
                } else {
                    throw new StaleElementReferenceException("listCells size is not equal 9");
                }

            } else {
                Assert.fail("listRows is null!");
            }
        } else {
            Assert.fail("table is null!");
        }
    }

    @Then("^Following values should be updated with changed data: Address - it should populate entered Address lines 1 and 2 Lab - it should populate Lab name$")
    public void check_updated_data() {
        try {
            final WebElement table = MyWebDriverUtils.findElement(driver, TABLE_LOCATOR, LocatorType.ID);
            if (table != null) {
                List<WebElement> listRows = MyWebDriverUtils.findElements(driver, ROWS_LOCATOR, LocatorType.TAG, table);
                if (listRows != null) {
                    List<WebElement> listCells = MyWebDriverUtils.findElements(driver, CELL_LOCATOR, LocatorType.TAG, listRows.get(4));

                    if (listCells != null && listCells.size() == 2) {
                        WebElement labCell = listCells.get(1);
                        Assert.assertEquals(labCell.getText(), LAB_CLIENT_VALUE);

                    } else {
                        throw new StaleElementReferenceException("listCells size is not equal 2");
                    }

                    List<WebElement> addressCells = MyWebDriverUtils.findElements(driver, CELL_LOCATOR, LocatorType.TAG, listRows.get(3));

                    if (addressCells != null && addressCells.size() == 2) {
                        WebElement addressCell = addressCells.get(1);
                        String[] address = addressCell.getText().split(REGEX);
                        Assert.assertEquals(address[0], ADDRESS_1_VALUE);
                        Assert.assertEquals(address[1], ADDRESS_2_VALUE);

                    } else {
                        throw new StaleElementReferenceException("addressCells size is not equal 2");
                    }

                } else {
                    Assert.fail("listRows is null!");
                }
            } else {
                Assert.fail("table is null!");
            }
        } catch (StaleElementReferenceException ex) {
            check_updated_data();
        }
    }

    /*
      Scenario: Verify adding location to a lab client
     */

    @When("^Click on the location Icon in the editPage$")
    public void click_on_the_location_icon_in_the_edit_page() {
        WebElement el = MyWebDriverUtils.findElement(driver, ADD_LOCATION_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(el);
        } else {
            Assert.fail("flag is false!");
        }
    }

    @Then("^Add Lab Location' page should be displayed$")
    public void add_lab_location_page_should_be_displayed() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, ADD_LAB_LOCATION_URL);

        WebElement el = MyWebDriverUtils.findPresenceElement(driver, WIDGET_ADD_LAB_LOCATION_LOCATOR, LocatorType.CSS);
        if (el != null) {
            String title = el.getText();
            Assert.assertEquals(title, WIDGET_ADD_LAB_LOCATION_VALUE);
        }
    }

    @When("^Enter Location Name and the remaining details and click on 'Submit'$")
    public void enter_location_name_and_the_remaining_details_and_click_on_submit() {
        WebElement labName = MyWebDriverUtils.findElement(driver, LAB_LOCATION_NAME_LOCATOR, LocatorType.NAME);
        if (labName != null) {
            labName.clear();
            labName.sendKeys(LAB_LOCATION_NAME_VALUE);
        } else {
            Assert.fail("labName is null!");
        }

        WebElement labDepartment = MyWebDriverUtils.findElement(driver, LAB_LOCATION_DEPARTMENT_LOCATOR, LocatorType.NAME);
        if (labDepartment != null) {
            labDepartment.clear();
            labDepartment.sendKeys(LAB_LOCATION_DEPARTMENT_VALUE);
        } else {
            Assert.fail("labDepartment is null!");
        }

        WebElement labAddress = MyWebDriverUtils.findElement(driver, LAB_LOCATION_ADDRESS_LOCATOR, LocatorType.NAME);
        if (labAddress != null) {
            labAddress.clear();
            labAddress.sendKeys(LAB_LOCATION_ADDRESS_VALUE);
        } else {
            Assert.fail("labAddress is null!");
        }

        WebElement faxNumber = MyWebDriverUtils.findElement(driver, FAX_NUMBER_LOCATOR, LocatorType.NAME);
        if (faxNumber != null) {
            faxNumber.clear();
            faxNumber.sendKeys(FAX_NUMBER_VALUE);
        } else {
            Assert.fail("faxNumber is null!");
        }

        WebElement el = MyWebDriverUtils.findElement(driver, EDIT_SUBMIT_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(el);
        } else {
            Assert.fail("flag is false!");
        }


    }

    @Then("^Added location should be added to the Location list$")
    public void added_location_should_be_added_to_the_location_list() {
        if (count == 0) {
            WebElement el = MyWebDriverUtils.findElement(driver, DROP_DOWN_SELECT_LOCATOR, LocatorType.CSS);
            if(el != null){
                new Select(el).selectByVisibleText(DROP_DOWN_ALL_VALUE);
            }
        }

        try {
            count++;
            final WebElement table = MyWebDriverUtils.findElement(driver, TABLE_LOCATOR, LocatorType.ID);
            if (table != null) {

                List<WebElement> listRows = MyWebDriverUtils.findElements(driver, ROWS_LOCATOR, LocatorType.TAG, table);
                if (listRows != null) {
                    int size = listRows.size();
                    List<WebElement> listCells = MyWebDriverUtils.findElements(driver, CELL_LOCATOR, LocatorType.TAG, listRows.get(size - 1));

                    if (listCells != null && listCells.size() == 5) {
                        Assert.assertEquals(listCells.get(0).getText(), LAB_LOCATION_NAME_VALUE);
                        Assert.assertEquals(listCells.get(1).getText(), LAB_LOCATION_ADDRESS_VALUE);
                        Assert.assertEquals(listCells.get(2).getText(), LAB_LOCATION_DEPARTMENT_VALUE);
                        Assert.assertEquals(listCells.get(3).getText(), LAB_CLIENT_ANOTHER_VALUE);
                    } else {
                        throw new StaleElementReferenceException("listCells size is not equal 5");
                    }

                } else {
                    Assert.fail("listRows is null!");
                }
            } else {
                Assert.fail("table is null!");
            }
        } catch (StaleElementReferenceException ex) {
            added_location_should_be_added_to_the_location_list();
        }
        WebElement el = MyWebDriverUtils.findPresenceElement(driver, SUCCESS_LOCATOR, LocatorType.CSS);
        if (el != null) {
            String elValue = el.getText();
            Assert.assertEquals(elValue, SUCCESS_VALUE);
            count = 0;
        } else {
            Assert.fail("el is false!");
        }


        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, SAVE_LOCATION_URL);

        WebElement success = MyWebDriverUtils.findPresenceElement(driver, SUCCESS_LOCATOR, LocatorType.CSS);
        if (success != null) {
            String elValue = success.getText();
            Assert.assertEquals(elValue, SUCCESS_VALUE);
        } else {
            Assert.fail("el is false!");
        }

        WebElement widget = MyWebDriverUtils.findPresenceElement(driver, WIDGET_LAB_LOCATION_LIST_LOCATOR, LocatorType.CSS);
        if (widget != null) {
            String title = widget.getText();
            Assert.assertEquals(title, WIDGET_LAB_LOCATION_LIST_VALUE);
        }


    }

    /*
      Scenario: Verify editing location of a lab client
     */

    @When("^Click on the Location icon for a lab client")
    public void click_on_the_location_icon_for_a_lab_client() {
        WebElement el = MyWebDriverUtils.findElement(driver, LOCATION_LIST_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(el);
        } else {
            Assert.fail("flag is false!");
        }
    }

    @Then("^Lab Location List page should be displayed$")
    public void lab_location_list_page_should_be_displayed() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, LAB_LOCATION_LIST_URL);

        WebElement widget = MyWebDriverUtils.findPresenceElement(driver, WIDGET_LAB_LOCATION_LIST_ANOTHER_LOCATOR, LocatorType.CSS);
        if (widget != null) {
            String title = widget.getText();
            Assert.assertEquals(title, WIDGET_LAB_LOCATION_LIST_VALUE);
        }


    }

    @When("^Click on the Edit icon for a lab location$")
    public void click_on_the_edit_icon_for_a_lab_location() {
        WebElement el = MyWebDriverUtils.findElement(driver, EDIT_ICON_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(el);
        } else {
            Assert.fail("flag is false!");
        }
    }

    @Then("^Update Lab location page should be displayed$")
    public void update_lab_location_page_should_be_displayed() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, EDIT_LAB_LOCATION_LIST_URL);

        WebElement widget = MyWebDriverUtils.findPresenceElement(driver, WIDGET_UPDATE_LOCATION_LOCATOR, LocatorType.CSS);
        if (widget != null) {
            String title = widget.getText();
            Assert.assertEquals(title, WIDGET_UPDATE_LOCATION_VALUE);
        }
    }

    @When("^Make required changes and click Update$")
    public void make_required_changes_and_click_update() {
        WebElement labName = MyWebDriverUtils.findElement(driver, LAB_LOCATION_NAME_LOCATOR, LocatorType.NAME);
        if (labName != null) {
            labName.clear();
            labName.sendKeys(LAB_LOCATION_NAME_VALUE);
        } else {
            Assert.fail("labName is null!");
        }

        WebElement labDepartment = MyWebDriverUtils.findElement(driver, LAB_LOCATION_DEPARTMENT_LOCATOR, LocatorType.NAME);
        if (labDepartment != null) {
            labDepartment.clear();
            labDepartment.sendKeys(LAB_LOCATION_DEPARTMENT_VALUE);
        } else {
            Assert.fail("labDepartment is null!");
        }

        WebElement labAddress = MyWebDriverUtils.findElement(driver, LAB_LOCATION_ADDRESS_LOCATOR, LocatorType.NAME);
        if (labAddress != null) {
            labAddress.clear();
            labAddress.sendKeys(LAB_LOCATION_ADDRESS_VALUE);
        } else {
            Assert.fail("labAddress is null!");
        }

        WebElement faxNumber = MyWebDriverUtils.findElement(driver, FAX_NUMBER_LOCATOR, LocatorType.NAME);
        if (faxNumber != null) {
            faxNumber.clear();
            faxNumber.sendKeys(FAX_NUMBER_VALUE);
        } else {
            Assert.fail("faxNumber is null!");
        }

        WebElement el = MyWebDriverUtils.findElement(driver, UPDATE_SUBMIT_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(el);
        } else {
            Assert.fail("flag is false!");
        }
    }

    @Then("^Lab location should be updated successfully$")
    public void lab_location_should_be_updated_successfully() {
        try {
            final WebElement table = MyWebDriverUtils.findElement(driver, TABLE_LOCATOR, LocatorType.ID);
            if (table != null) {

                List<WebElement> listRows = MyWebDriverUtils.findElements(driver, ROWS_LOCATOR, LocatorType.TAG, table);
                if (listRows != null) {
                    int size = listRows.size();
                    List<WebElement> listCells = MyWebDriverUtils.findElements(driver, CELL_LOCATOR, LocatorType.TAG, listRows.get(size - 1));

                    if (listCells != null && listCells.size() == 5) {
                        Assert.assertEquals(listCells.get(0).getText(), LAB_LOCATION_NAME_VALUE);
                        Assert.assertEquals(listCells.get(1).getText(), LAB_LOCATION_ADDRESS_VALUE);
                        Assert.assertEquals(listCells.get(2).getText(), LAB_LOCATION_DEPARTMENT_VALUE);

                        String currentUrl = driver.getCurrentUrl();
                        Assert.assertEquals(currentUrl, UPDATE_SUCCESS_URL);

                        WebElement widget = MyWebDriverUtils.findPresenceElement(driver, SUCCESS_LOCATOR, LocatorType.CSS);
                        if (widget != null) {
                            String title = widget.getText();
                            Assert.assertEquals(title, SUCCESS_VALUE);
                        }
                    } else {
                        throw new StaleElementReferenceException("listCells size is not equal 5");
                    }

                } else {
                    Assert.fail("listRows is null!");
                }
            } else {
                Assert.fail("table is null!");
            }
        } catch (StaleElementReferenceException ex) {
            lab_location_should_be_updated_successfully();
        }

    }

    /*
     Scenario: Verify adding user to a lab client
     */

    @When("^Click on the Add User Icon$")
    public void click_on_the_add_user_icon() {
        WebElement el = MyWebDriverUtils.findElement(driver, ADD_USER_ICON_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(el);
        } else {
            Assert.fail("flag is false!");
        }
    }

    @Then("^Add Lab Client User page should be displayed$")
    public void add_lab_client_user_page_should_be_displayed() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, ADD_LAB_CLIENT_USER_URL);

        WebElement widget = MyWebDriverUtils.findPresenceElement(driver, WIDGET_ADD_LOCATOR, LocatorType.CSS);
        if (widget != null) {
            String title = widget.getText();
            Assert.assertEquals(title, WIDGET_ADD_LAB_CLIENT_USER_VALUE);
        }
    }

    @When("^Enter User information, Personal information and select lab information. click on 'Submit'$")
    public void enter_information_and_submit() throws InterruptedException {
        Thread.sleep(TIME_STOP);
        WebElement userName = MyWebDriverUtils.findElement(driver, USER_USERNAME_LOCATOR, LocatorType.NAME);
        if (userName != null) {
            userNameValue = StringUtils.generateRandom();
            userName.clear();
            userName.sendKeys(userNameValue);
        } else {
            Assert.fail("userName is null!");
        }

        WebElement password = MyWebDriverUtils.findElement(driver, USER_PASSWORD_LOCATOR, LocatorType.NAME);
        if (password != null) {
            password.clear();
            password.sendKeys(USER_PASSWORD_VALUE);
        } else {
            Assert.fail("password is null!");
        }

        WebElement firstName = MyWebDriverUtils.findElement(driver, USER_FIRST_NAME_LOCATOR, LocatorType.CSS);
        if (firstName != null) {
            firstName.clear();
            firstName.sendKeys(USER_FIRST_NAME_VALUE);
        } else {
            Assert.fail("firstName is null!");
        }

        WebElement lastName = MyWebDriverUtils.findElement(driver, USER_LAST_NAME_LOCATOR, LocatorType.CSS);
        if (lastName != null) {
            lastName.clear();
            lastName.sendKeys(USER_LAST_NAME_VALUE);
        } else {
            Assert.fail("lastName is null!");
        }


        WebElement email = MyWebDriverUtils.findElement(driver, USER_EMAIL_LOCATOR, LocatorType.NAME);
        if (email != null) {
            email.clear();
            email.sendKeys(USER_EMAIL_VALUE);
        } else {
            Assert.fail("email is null!");
        }

        WebElement phoneNumber = MyWebDriverUtils.findElement(driver, USER_PHONE_NUMBER_LOCATOR, LocatorType.NAME);
        if (phoneNumber != null) {
            phoneNumber.clear();
            phoneNumber.sendKeys(USER_PHONE_NUMBER_VALUE);
        } else {
            Assert.fail("phoneNumber is null!");
        }

        new Select(driver.findElement(By.cssSelector(SELECT_ROLE_LOCATOR))).selectByVisibleText(ROLE);

        new Select(driver.findElement(By.id(LAB_LOCATIONS_LOCATOR))).selectByVisibleText(LAB_LOCATIONS_VALUE);


        WebElement el = MyWebDriverUtils.findElement(driver, USER_SUBMIT_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(el);
        } else {
            Assert.fail("flag is false!");
        }

    }

    @Then("^Added user should be added to the Lab Client User list$")
    public void added_user_should_be_added_to_the_lab_client_user_list() {
        if (count == 0) {
            WebElement el = MyWebDriverUtils.findPresenceElement(driver, DROP_DOWN_SELECT_LOCATOR, LocatorType.CSS);
            if (el != null) {
                new Select(el).selectByVisibleText(DROP_DOWN_ALL_VALUE);
            } else {
                Assert.fail("el is null!");
            }

        }

        try {
            count++;
            final WebElement table = MyWebDriverUtils.findElement(driver, TABLE_LOCATOR, LocatorType.ID);
            if (table != null) {

                List<WebElement> listRows = MyWebDriverUtils.findElements(driver, ROWS_LOCATOR, LocatorType.TAG, table);
                if (listRows != null) {
                    int size = listRows.size();
                    List<WebElement> listCells = MyWebDriverUtils.findElements(driver, CELL_LOCATOR, LocatorType.TAG, listRows.get(size - 1));

                    if (listCells != null && listCells.size() == 8) {
                        Assert.assertEquals(listCells.get(1).getText(), userNameValue);
                        Assert.assertEquals(listCells.get(2).getText(), USER_FIRST_NAME_VALUE + " " + USER_LAST_NAME_VALUE);
                        Assert.assertEquals(listCells.get(3).getText(), USER_CONTACT);
                        Assert.assertEquals(listCells.get(4).getText(), USER_EMAIL_VALUE);
                        Assert.assertEquals(listCells.get(5).getText(), ROLE);
                        Assert.assertEquals(listCells.get(6).getText(), LAB_CLIENT_ANOTHER_VALUE);

                        String currentUrl = driver.getCurrentUrl();
                        Assert.assertEquals(currentUrl, CLIENT_USER_LIST_URL);

                        WebElement widget = MyWebDriverUtils.findPresenceElement(driver, SUCCESS_LOCATOR, LocatorType.CSS);
                        if (widget != null) {
                            String title = widget.getText();
                            Assert.assertEquals(title, SUCCESS_VALUE);
                        }
                        count = 0;
                    } else {
                        throw new StaleElementReferenceException("listCells size is not equal 8");
                    }

                } else {
                    Assert.fail("listRows is null!");
                }
            } else {
                Assert.fail("table is null!");
            }
        } catch (StaleElementReferenceException ex) {
            added_user_should_be_added_to_the_lab_client_user_list();
        }
    }

    /*
      Scenario: Verify editing user to a lab client
     */

    @When("^Click on the User icon for a lab client$")
    public void click_on_the_user_icon_for_a_lab_client() {
        WebElement el = MyWebDriverUtils.findElement(driver, USER_ICON_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(el);
        } else {
            Assert.fail("flag is false!");
        }
    }

    @Then("^User List page should be displayed$")
    public void user_list_page_should_be_displayed() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, USER_LIST_PAGE_URL);

        WebElement el = MyWebDriverUtils.findPresenceElement(driver, WIDGET_USER_LIST_LOCATOR, LocatorType.CSS);
        if (el != null) {
            String title = el.getText();
            Assert.assertEquals(title, WIDGET_USER_LIST_VALUE);
        }
    }

    @When("^Click on the Edit Icon$")
    public void click_on_the_edit_icon() {
        WebElement el = MyWebDriverUtils.findElement(driver, EDIT_LIST_PAGE_ICON_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(el);
        } else {
            Assert.fail("flag is false!");
        }
    }

    @Then("^Update Lab User page should be displayed$")
    public void update_lab_user_page_should_be_displayed() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, UPDATE_LAB_USER_PAGE_URL);

        WebElement el = MyWebDriverUtils.findPresenceElement(driver, WIDGET_UPDATE_LOCATOR, LocatorType.CSS);
        if (el != null) {
            String title = el.getText();
            Assert.assertEquals(title, WIDGET_UPDATE_LAB_USER_VALUE);
        }
    }

    @When("^Verify User Information section$")
    public void verify_user_information_section() {
        userNameEl = MyWebDriverUtils.findPresenceElement(driver, USER_USERNAME_LOCATOR, LocatorType.NAME);
        passwordEl = MyWebDriverUtils.findPresenceElement(driver, USER_PASSWORD_LOCATOR, LocatorType.NAME);
    }

    @Then("^User Information should be locked for editing$")
    public void user_information_should_be_locked_for_editing() {
        Assert.assertTrue(!userNameEl.isEnabled());
        Assert.assertTrue(!passwordEl.isEnabled());
    }

    @When("^Make changes to Personal Information and click update$")
    public void make_changes_to_personal_information_and_click_update() {
        WebElement firstName = MyWebDriverUtils.findElement(driver, USER_FIRST_NAME_LOCATOR, LocatorType.CSS);
        if (firstName != null) {
            firstName.clear();
            firstName.sendKeys(USER_FIRST_NAME_VALUE);
        } else {
            Assert.fail("firstName is null!");
        }

        WebElement lastName = MyWebDriverUtils.findElement(driver, USER_LAST_NAME_LOCATOR, LocatorType.CSS);
        if (lastName != null) {
            lastName.clear();
            lastName.sendKeys(USER_LAST_NAME_VALUE);
        } else {
            Assert.fail("lastName is null!");
        }


        WebElement email = MyWebDriverUtils.findElement(driver, USER_EMAIL_LOCATOR, LocatorType.NAME);
        if (email != null) {
            email.clear();
            email.sendKeys(USER_EMAIL_VALUE);
        } else {
            Assert.fail("email is null!");
        }

        WebElement phoneNumber = MyWebDriverUtils.findElement(driver, USER_PHONE_NUMBER_LOCATOR, LocatorType.NAME);
        if (phoneNumber != null) {
            phoneNumber.clear();
            phoneNumber.sendKeys(USER_PHONE_NUMBER_VALUE);
        } else {
            Assert.fail("phoneNumber is null!");
        }

        new Select(driver.findElement(By.id(LAB_LOCATIONS_LOCATOR))).selectByVisibleText(LAB_LOCATIONS_VALUE);

        WebElement el = MyWebDriverUtils.findElement(driver, UPDATE_BUTTON_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(el);
        } else {
            Assert.fail("flag is false!");
        }


    }

    @Then("^Changes made to personal information should be saved successfully$")
    public void changes_made_to_personal_information_should_be_saved_successfully() {
        try {
            final WebElement table = MyWebDriverUtils.findElement(driver, TABLE_LOCATOR, LocatorType.ID);
            if (table != null) {

                List<WebElement> listRows = MyWebDriverUtils.findElements(driver, ROWS_LOCATOR, LocatorType.TAG, table);
                if (listRows != null) {
                    List<WebElement> listCells = MyWebDriverUtils.findElements(driver, CELL_LOCATOR, LocatorType.TAG, listRows.get(1));

                    if (listCells != null && listCells.size() == 8) {
                        Assert.assertEquals(listCells.get(1).getText(), CLIENT_USER_NAME);
                        Assert.assertEquals(listCells.get(2).getText(), USER_FIRST_NAME_VALUE + " " + USER_LAST_NAME_VALUE);
                        Assert.assertEquals(listCells.get(3).getText(), USER_CONTACT);
                        Assert.assertEquals(listCells.get(4).getText(), USER_EMAIL_VALUE);
                        Assert.assertEquals(listCells.get(5).getText(), ROLE);
                        Assert.assertEquals(listCells.get(6).getText(), LAB_CLIENT_ANOTHER_VALUE);

                        String currentUrl = driver.getCurrentUrl();
                        Assert.assertEquals(currentUrl, CLIENT_USERS_LIST_URL);

                        WebElement widget = MyWebDriverUtils.findPresenceElement(driver, SUCCESS_LOCATOR, LocatorType.CSS);
                        if (widget != null) {
                            String title = widget.getText();
                            Assert.assertEquals(title, SUCCESS_VALUE);
                        }
                    } else {
                        throw new StaleElementReferenceException("listCells size is not equal 8");
                    }

                } else {
                    Assert.fail("listRows is null!");
                }
            } else {
                Assert.fail("table is null!");
            }
        } catch (StaleElementReferenceException ex) {
            changes_made_to_personal_information_should_be_saved_successfully();
        }

    }

    @When("^Click '\\+' icon against newly created user$")
    public void click_plus_icon_against_newly_created_user() {
        WebElement el = MyWebDriverUtils.findElement(driver, PLUS_ICON_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(el);
        } else {
            Assert.fail("flag is false!");
        }
    }

    @Then("^Following values should be populated with updated information: Modified By Modified Date\\(with Timestamp\\)$")
    public void values_should_be_populated_with_updated_information() {
        try {
            final WebElement table = MyWebDriverUtils.findElement(driver, TABLE_LOCATOR, LocatorType.ID);
            if (table != null) {
                List<WebElement> listRows = MyWebDriverUtils.findElements(driver, ROWS_LOCATOR, LocatorType.TAG, table);
                if (listRows != null) {
                    List<WebElement> listCells = MyWebDriverUtils.findElements(driver, CELL_LOCATOR, LocatorType.TAG, listRows.get(4));
                    String dataCreated;
                    String dataModified;

                    if (listCells != null && listCells.size() == 2) {
                        WebElement dataCell = listCells.get(1);
                        dataCreated = dataCell.getText();
                        Assert.assertNotNull(dataCreated);

                    } else {
                        throw new StaleElementReferenceException("listCells size is not equal 2");
                    }

                    List<WebElement> lstCells = MyWebDriverUtils.findElements(driver, CELL_LOCATOR, LocatorType.TAG, listRows.get(6));

                    if (lstCells != null && lstCells.size() == 2) {
                        WebElement dataCell = lstCells.get(1);
                        dataModified = dataCell.getText();
                        Assert.assertNotNull(dataModified);
                    } else {
                        throw new StaleElementReferenceException("addressCells size is not equal 2");
                    }

                    Assert.assertTrue(dataModified.compareTo(dataCreated) > 0);

                } else {
                    Assert.fail("listRows is null!");
                }
            } else {
                Assert.fail("table is null!");
            }
        } catch (StaleElementReferenceException ex) {
            values_should_be_populated_with_updated_information();
        }
    }

    /*
      Scenario: Verify locking access for a lab client user
     */


    @When("^Click 'Lock' icon for any existing user$")
    public void click_lock_icon_for_any_existing_user() {
        WebElement lock = MyWebDriverUtils.findElement(driver, LOCK_LOCATOR, LocatorType.CSS);
        if (lock != null && lock.getAttribute(ATTRIBUTE_CLASS_LOCATOR).equals(LOCK_VALUE)) {
            WebElement el = MyWebDriverUtils.findElement(driver, LOCK_ICON_LOCATOR, LocatorType.CSS);
            WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

            boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
            if (flag) {
                checkAndClick(el);
            } else {
                Assert.fail("flag is false!");
            }
        }
        WebElement el = MyWebDriverUtils.findElement(driver, LOCK_ICON_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(el);
        } else {
            Assert.fail("flag is false!");
        }
    }

    @Then("^User should be locked and 'User locked successfully' message should be populated$")
    public void user_should_be_locked() {
        WebElement widget = MyWebDriverUtils.findPresenceElement(driver, SUCCESS_LOCATOR, LocatorType.CSS);
        if (widget != null) {
            String title = widget.getText();
            Assert.assertEquals(title, SUCCESS_VALUE);
        }

        WebElement el = MyWebDriverUtils.findElement(driver, MESSAGE_LOCATOR, LocatorType.CSS);
        if (el != null) {
            Assert.assertEquals(el.getText(), MESSAGE_VALUE);
        }

        WebElement lock = MyWebDriverUtils.findElement(driver, LOCK_LOCATOR, LocatorType.CSS);
        if (lock != null) {
            Assert.assertEquals(lock.getAttribute(ATTRIBUTE_CLASS_LOCATOR), LOCK_VALUE);
        }

    }

    @When("^Logout and attempt logging in with the above lab user credentials$")
    public void logout_and_attempt_logging() {
        WebElement el = MyWebDriverUtils.findElement(driver, FIRST_CGI_LAST_CGI_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(el);
        } else {
            Assert.fail("flag is false!");
        }

        WebElement el1 = MyWebDriverUtils.findElement(driver, SIGN_OUT_LOCATOR, LocatorType.CSS);
        WebDriverWait wait1 = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag1 = MyWebDriverUtils.waitInvisibilityOfElement(wait1, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag1) {
            checkAndClick(el1);
        } else {
            Assert.fail("flag is false!");
        }
    }

    @Then("^Account locked message should be populated and user should not be able to login to application$")
    public void account_locked_message_should_be_populated() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, LOGIN_PAGE_URL);

        WebElement element = driver.findElement(By.name(FIND_USERNAME));
        element.clear();
        element.sendKeys(LOCK_USER);

        WebElement el = driver.findElement(By.name(FIND_LOGIN));
        el.clear();
        el.sendKeys(PASSWORD);

        driver.findElement(By.xpath(LOGIN_BUTTON_XPATH)).click();


        WebElement message = driver.findElement(By.cssSelector(LOCKED_MESSAGE_LOCATOR));
        Assert.assertTrue(message.isDisplayed());
    }


    /*
    Scenario: Verify adding notes to a lab client
     */

    @When("^Click on the Add Notes Icon$")
    public void click_on_the_add_notes_icon() {
        WebElement el = MyWebDriverUtils.findElement(driver, ADD_NOTES_ICON_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(el);
        } else {
            Assert.fail("flag is false!");
        }
    }

    @Then("^Update Lab Client Notes page should be displayed$")
    public void update_lab_client_notes_page_should_be_displayed() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, UPDATE_LAB_CLIENTS_NOTES_URL);


        WebElement widget = MyWebDriverUtils.findPresenceElement(driver, WIDGET_ADD_LOCATOR, LocatorType.CSS);
        if (widget != null) {
            String title = widget.getText();
            Assert.assertEquals(title, WIDGET_UPDATE_NOTES_VALUE);
        }
    }

    @When("^Click '\\+' icon and add note. By clicking on '\\+' sign multiple times, multiple notes can be added.Click Update Notes$")
    public void click_plus_icon_and_add_note() {
        for (int i = 0; i < 3; i++) {
            WebElement el = MyWebDriverUtils.findElement(driver, NOTES_PLUS_ICON_LOCATOR, LocatorType.CSS);
            WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

            boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
            if (flag) {
                checkAndClick(el);
            } else {
                Assert.fail("flag is false!");
            }


            List<WebElement> notes = MyWebDriverUtils.findElements(driver, NEW_NOTE_LOCATOR, LocatorType.ID);
            if (notes != null) {
                notes.get(i).clear();
                notes.get(i).sendKeys(NEW_NOTE_VALUE + i);
            } else {
                Assert.fail("notes is null!");
            }
        }

        WebElement button = MyWebDriverUtils.findElement(driver, UPDATE_NOTES_BUTTON_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag1 = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag1) {
            checkAndClick(button);
        } else {
            Assert.fail("flag is false!");
        }

    }

    @Then("^Notes for lab client should be saved successfully along with date stamp$")
    public void check_saved_notes() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, UPDATE_NOTES_URL);


        WebElement widget = MyWebDriverUtils.findPresenceElement(driver, MESSAGE_LOCATOR, LocatorType.CSS);
        if (widget != null) {
            String title = widget.getText();
            Assert.assertEquals(title, NOTES_ALERT_VALUE);
        }

        for (int i = 0; i < 3; i++) {
            boolean flag = false;
            WebElement note = MyWebDriverUtils.findElement(driver, NEW_NOTE_LOCATOR + "[" + i + "]", LocatorType.ID);
            if (note != null) {
                String noteValue = note.getAttribute(ATTRIBUTE_VALUE_LOCATOR);
                if (noteValue.equals(NEW_NOTE_VALUE + 0) || noteValue.equals(NEW_NOTE_VALUE + 1) || noteValue.equals(NEW_NOTE_VALUE + 2)) {
                    flag = true;
                }
                Assert.assertTrue(flag);
            } else {
                Assert.fail("notes is null!");
            }
        }

        WebElement el = MyWebDriverUtils.findElement(driver, "#clientNoteDiv > div > label", LocatorType.CSS);
        if (el != null) {
            String user = el.getText();
            Assert.assertNotNull(user);
            Assert.assertTrue(user.contains("cgilabadmin"));
        } else {
            Assert.fail("el is null!");
        }

    }

    @When("^Click 'Edit' icon against the newly added note$")
    public void click_edit_icon() {
        WebElement button = MyWebDriverUtils.findElement(driver, ICON_NOTES_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(button);
        } else {
            Assert.fail("flag is false!");
        }
    }

    @Then("^Notes should be opened for edit$")
    public void notes_should_be_opened_for_edit() {
        WebElement note = MyWebDriverUtils.findElement(driver, NEW_NOTE_LOCATOR + "[" + 0 + "]", LocatorType.ID);
        if (note != null) {
            String noteValue = note.getAttribute(NOTE_UNLOCK_FOR_EDIT_LOCATOR);
            Assert.assertNotNull(noteValue);

            String noteClass = note.getAttribute(ATTRIBUTE_CLASS_LOCATOR);
            Assert.assertEquals(noteClass, NOTE_UNLOCK_FOR_EDIT_CLASS_VALUE);

            note.clear();
            note.sendKeys(NEW_NOTE_VALUE);

            String value = note.getAttribute(ATTRIBUTE_VALUE_LOCATOR);
            Assert.assertEquals(value, NEW_NOTE_VALUE);


        } else {
            Assert.fail("note is null!");
        }

    }

    /*
    Scenario: Verify adding Clinician to a lab client
     */

    @When("^Click on the Clinician List icon for a Lab Client$")
    public void click_on_the_clinician_list_icon_for_a_lab_client() {
        WebElement icon = MyWebDriverUtils.findElement(driver, CLINICIAN_ICON_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(icon);
        } else {
            Assert.fail("flag is false!");
        }
    }

    @Then("^Clinician List page should be displayed$")
    public void clinician_list_page_should_be_displayed() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, CLINICIAN_LIST_URL);

        WebElement widget = MyWebDriverUtils.findPresenceElement(driver, WIDGET_LAB_LOCATION_LIST_LOCATOR, LocatorType.CSS);
        if (widget != null) {
            String title = widget.getText();
            Assert.assertEquals(title, WIDGET_CLINITIAN_LIST_VALUE);
        }
    }

    @When("^Click on the '\\+' Icon$")
    public void click_on_the_plus_icon() {
        WebElement plusButton = MyWebDriverUtils.findElement(driver, ADD_PHYSICIAN_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(plusButton);
        } else {
            Assert.fail("flag is false!");
        }
    }

    @Then("^Add Physician screen is displayed$")
    public void add_physician_screen_is_displayed() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, ADD_PHYSICIAN_URL);

        WebElement widget = MyWebDriverUtils.findPresenceElement(driver, WIDGET_ADD_LOCATOR, LocatorType.CSS);
        if (widget != null) {
            String title = widget.getText();
            Assert.assertEquals(title, ADD_PHYSICIAN_VALUE);
        }
    }

    @When("^Enter all the information in the Physician screen and click Submit$")
    public void enter_all_the_information() {
        Physician.physicianUserName = StringUtils.generateRandom();
        selectOption(Physician.LAB_CLIENT_LOCATOR, LocatorType.ID, Physician.LAB_CLIENT);
        enterData(Physician.USER_NAME_LOCATOR, Physician.physicianUserName, LocatorType.NAME);
        enterData(Physician.PASSWORD_LOCATOR, Physician.PASSWORD, LocatorType.NAME);
        enterData(Physician.FIRST_NAME_LOCATOR, Physician.FIRST_NAME, LocatorType.NAME);
        enterData(Physician.LAST_NAME_LOCATOR, Physician.LAST_NAME, LocatorType.NAME);
        enterData(Physician.MIDDLE_NAME_LOCATOR, Physician.MIDDLE_NAME, LocatorType.NAME);
        enterData(Physician.MEDICAL_DEGREE_LOCATOR, Physician.MEDICAL_DEGREE, LocatorType.NAME);
        enterData(Physician.PHONE_NUMBER_LOCATOR, Physician.PHONE_NUMBER, LocatorType.NAME);
        enterData(Physician.EMAIL_ADDRESS_LOCATOR, Physician.EMAIL_ADDRESS, LocatorType.NAME);
        enterData(Physician.SALUTATION_LOCATOR, Physician.SALUTATION, LocatorType.NAME);
        enterData(Physician.FIRST_NAME_LOCATOR, Physician.FIRST_NAME, LocatorType.NAME);
        enterData(Physician.MEDICARE_NUMBER_LOCATOR, Physician.MEDICARE_NUMBER, LocatorType.NAME);
        enterData(Physician.MEDICAID_NUMBER_LOCATOR, Physician.MEDICAID_NUMBER, LocatorType.NAME);
        enterData(Physician.UPIN_NUMBER_LOCATOR, Physician.UPIN_NUMBER, LocatorType.NAME);
        enterData(Physician.STATE_LICENCE_LOCATOR, Physician.STATE_LICENCE, LocatorType.NAME);
        enterData(Physician.NPI_LOCATOR, Physician.NPI, LocatorType.NAME);

        selectOption(Physician.COMPOUND_PROFILE_LOCATOR, LocatorType.ID, Physician.COMPOUND_PROFILE);

        WebElement plusButton = MyWebDriverUtils.findElement(driver, Physician.PLUS_ONE_ICON_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(plusButton);
        } else {
            Assert.fail("flag is false!");
        }



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Physician.LOCATION_LOCATOR)));
        selectOption(Physician.LOCATION_LOCATOR, LocatorType.ID, Physician.LOCATION);

        WebElement el = MyWebDriverUtils.findElement(driver, Physician.CHECKBOX_ONE_LOCATOR, LocatorType.CSS);
        checkAndClick(el);


        plusButton = MyWebDriverUtils.findElement(driver, Physician.PLUS_TWO_ICON_LOCATOR, LocatorType.CSS);
        checkAndClick(plusButton);


        el = MyWebDriverUtils.findElement(driver, Physician.CHECKBOX_TWO_LOCATOR, LocatorType.CSS);
        checkAndClick(el);

        WebElement submit = MyWebDriverUtils.findElement(driver, Physician.SUBMIT_LOCATOR , LocatorType.CSS);
        checkAndClick(submit);

    }

    @Then("^Clinician should be added successfully$")
    public void clinician_should_be_added_successfully() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://bmtechsol.com:8080/easytox/clinician/clinicianlist");

        WebElement widget = MyWebDriverUtils.findPresenceElement(driver, "#maincontentdiv > div.page-body > div.alert.alert-success.fade.in > strong", LocatorType.CSS);
        if (widget != null) {
            String title = widget.getText();
            Assert.assertEquals(title, SUCCESS_VALUE);
        }
    }

    private void enterData(String locator, String value, LocatorType type){
        WebElement field = MyWebDriverUtils.findElement(driver, locator, type);
        if (field != null) {
            field.clear();
            field.sendKeys(value);
        } else {
            Assert.fail("field is null!");
        }
    }

    private void selectOption(String locator, LocatorType type, String option){
        WebElement el = MyWebDriverUtils.findElement(driver, locator, type);
        if (el != null) {
            new Select(el).selectByVisibleText(option);
        } else{
            Assert.fail("el is null");
        }
    }

    /*
    Scenario: Verify the Search Results
     */

    @When("^Enter any search criteria and click on search icon$")
    public void enter_any_search_criteria_and_click_on_search_icon() {
        if (searchResult == null) {
            searchResult = new ArrayList<Boolean>();
        }
        WebElement search = MyWebDriverUtils.findElement(driver, SEARCH_LOCATOR, LocatorType.CSS);
        if (search != null) {
            enterData(SEARCH_BUSINESS_NAME, search, searchResult);
            enterData(SEARCH_CITY, search, searchResult);
            enterData(SEARCH_STATE, search, searchResult);
            enterData(SEARCH_ZIP, search, searchResult);
            enterData(SEARCH_CONTACT_PERSON, search, searchResult);
            enterData(SEARCH_CONTACT_NUMBER, search, searchResult);
            enterData(SEARCH_EMAIL, search, searchResult);
        } else {
            Assert.fail("search is null!");
        }
    }

    @Then("^Matching records with entered data should be displayed in the Lab Client list$")
    public void matching_records_should_be_displayed() {
        for (Boolean result : searchResult) {
            Assert.assertTrue(result);
        }
    }

    private void enterData(String value, WebElement el, List<Boolean> list) {
        el.clear();
        el.sendKeys(value);
        list.add(checkTable());
    }

    private boolean checkTable() {
        int i = 0;
        final WebElement table = MyWebDriverUtils.findElement(driver, TABLE_LOCATOR, LocatorType.ID);
        if (table != null) {
            List<WebElement> listRows = MyWebDriverUtils.findElements(driver, ROWS_LOCATOR, LocatorType.TAG, table);
            if (listRows != null) {
                for (WebElement row : listRows) {
                    if (i == 0) {
                        i++;
                        continue;
                    }
                    List<WebElement> listCells = MyWebDriverUtils.findElements(driver, CELL_LOCATOR, LocatorType.TAG, row);
                    return listCells != null && listCells.size() == 9;
                }
            } else {
                Assert.fail("listRows is null!");
            }
        } else {
            Assert.fail("table is null!");
        }


        return false;
    }

    /*
    Scenario Outline: Verify Number of records displayed per page
     */

    @When("^Verify the default number of records displayed$")
    public void verify_the_default_number_of_records_displayed() {
        WebElement el = MyWebDriverUtils.findElement(driver, DROP_DOWN_SELECT_LOCATOR, LocatorType.CSS);
        if (el != null) {
            selectOptions = new Select(el).getAllSelectedOptions();
        }
    }

    @Then("^Default number '10' should be displayed in the dropdown box$")
    public void check_default_value() {
        for (WebElement option : selectOptions) {
            Assert.assertEquals(option.getText(), DEFAULT_NUMBER_OF_RECORDS);
        }
    }

    @When("^clicked on dropdown that shows (.*) of records to be displayed on the Lab Client List page$")
    public void click_on_dropdown(String number) {
        new Select(driver.findElement(By.name(DROP_DOWN_LOCATOR))).selectByVisibleText(number);


    }

    @Then("^user should be able to view and select the options from the list and the corresponding (.*) of records should be displayed on the page$")
    public void check_number_of_records(String number) {
        WebElement table = driver.findElement(By.id(TABLE_LOCATOR));
        int size = table.findElements(By.tagName(ROWS_LOCATOR)).size() - 1;

        WebElement element = driver.findElement(By.id(PAGINATE_LOCATOR));
        List<WebElement> list = element.findElements(By.tagName(LIST_LOCATOR));

        if (number.equals(ALL_NUMBER_OF_RECORDS)) {
            Assert.assertEquals(list.size(), 2);
        } else {
            int num = Integer.parseInt(number);
            if (num <= size) {
                Assert.assertEquals(num, size);
            } else {
                Assert.assertEquals(list.size(), 3);
            }
        }
    }

    /*
    Scenario Outline: Verify data sorting
     */

    @When("^Click on 'v' down arrow icon on (.*)$")
    public void click_on_v_down_arrow_icon(String column) {
        String locator = chooseLocator(column);
        if (locator != null) {
            WebElement el = MyWebDriverUtils.findElement(driver, locator, LocatorType.CSS);
            WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

            boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
            if (flag) {
                checkAndClick(el);
            } else {
                Assert.fail("flag is false!");
            }
        }
    }

    @Then("^Records should be displayed based on the ascending order of the selected field$")
    public void check_ascending_order() {
        try {
            int j;

            WebElement table = driver.findElement(By.id(TABLE_LOCATOR));

            List<WebElement> allRows = table.findElements(By.tagName(ROWS_LOCATOR));

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
            check_ascending_order();
        }

    }

    @When("^Click on Up arrow icon on (.*)$")
    public void click_on_up_arrow_icon(String column) {
        WebElement el = MyWebDriverUtils.findElement(driver, SORT_ASCENDING_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(el);
        } else {
            Assert.fail("flag is false!");
        }

    }

    @Then("^Records should be displayed based on the descending order of the selected field$")
    public void check_descending_order() {
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

    private String chooseLocator(String column) {
        switch (column) {
            case "City":
                return "#example > thead > tr > th:nth-child(3)";
            case "State":
                return "#example > thead > tr > th:nth-child(4)";
            case "Zip":
                return "#example > thead > tr > th:nth-child(5)";
            case "Contact Person":
                return "#example > thead > tr > th:nth-child(6)";
            case "Contact Number":
                return "#example > thead > tr > th:nth-child(7)";
            case "Email":
                return "#example > thead > tr > th:nth-child(8)";
        }
        return null;
    }

    /*
    Scenario Outline: Verify the page navigation
     */

    @When("^Navigate back and forth by selecting page numbers (.*)$")
    public void navigate_button(String button) {
        int i;

        if (button.equals("Next") || button.equals("Prev")) {
            i = 3;
        } else {
            i = Integer.parseInt(button) + 2;
        }

        WebElement el = MyWebDriverUtils.findElement(driver, "#example_paginate > ul > li:nth-child(" + i + ") > a", LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
        if (flag) {
            checkAndClick(el);
        } else {
            Assert.fail("flag is false!");
        }


        String locator = chooseButtonLocator(button);
        if (locator != null) {
            el = MyWebDriverUtils.findElement(driver, locator, LocatorType.CSS);
            wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

            flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, CONTAINER_LOCATOR, LocatorType.ID);
            if (flag) {
                checkAndClick(el);
            } else {
                Assert.fail("flag is false!");
            }
        }

        navigateButton = button;
    }

    @Then("^User should be navigate to the selected page$")
    public void user_should_be_navigate_to_selected_page() {
        WebElement el = MyWebDriverUtils.findElement(driver, PAGINATION_LOCATOR, LocatorType.CSS);
        if (el != null) {
            List<WebElement> list = MyWebDriverUtils.findElements(driver, LIST_LOCATOR, LocatorType.TAG, el);
            if (list != null) {
                WebElement activeButton;
                String attribute;
                switch (navigateButton) {
                    case "Next":
                        activeButton = list.get(3);
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

    @Then("^A text message 'Showing x to y of z entries' should be displayed on the bottom left corner of the list$")
    public void message_should_be_displayed() {
        WebElement el = MyWebDriverUtils.findElement(driver, "#example_info", LocatorType.CSS);
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
            case "3":
                return "#example_paginate > ul > li:nth-child(4) > a";
        }
        return null;
    }

    private void checkAndClick(WebElement element) {
        if (element != null) {
            element.click();
        } else {
            Assert.fail("element is null!");
        }
    }

    private void authorization() {
        driver.navigate().to(LOGIN_PAGE_URL);

        WebElement element = driver.findElement(By.name(FIND_USERNAME));
        element.clear();
        element.sendKeys(LOGIN);

        WebElement el = driver.findElement(By.name(FIND_LOGIN));
        el.clear();
        el.sendKeys(PASSWORD);

        driver.findElement(By.xpath(LOGIN_BUTTON_XPATH)).click();
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
