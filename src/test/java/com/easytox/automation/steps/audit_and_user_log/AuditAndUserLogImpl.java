package com.easytox.automation.steps.audit_and_user_log;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.LocatorType;
import com.easytox.automation.utils.MyWebDriverUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Alexander on 24.12.2016.
 */
public class AuditAndUserLogImpl {
    private static final String PASSWORD = "admin";
    private static final String LOGIN = "Superadmin";
    private static final String LOGIN_PAGE_URL = "http://bmtechsol.com:8080/easytox/";
    private static final String FIND_USERNAME = "j_username";
    private static final String FIND_PASSWORD = "j_password";
    private static final String LOGIN_BUTTON_XPATH = "//*[@id=\"loginform\"]/div[3]/div/button";
    private static final String LAB_LIST_URL = "http://bmtechsol.com:8080/easytox/lab/list";
    private static final String ADD_PLUS_ICON_LOCATOR = "add";
    private static final String WIDGET_ADD_LAB_LOCATOR = "exampleModalLabel";
    private static final String WIDGET_ADD_LAB_VALUE = "Add Lab";
    private static final String SUBMIT_LOCATOR = "#form > div.modal-footer > button.btn.btn-primary.btn-md";
    private static final String SUCCESS_LOCATOR = "#maincontentdiv > div.page-body > div.alert.alert-success.fade.in";
    private static final String DROP_DOWN_LOCATOR = "#lablist_length > label > select";
    private static final String ALL = "All";
    private static final String LAB_TABLE_LOCATOR = "lablist";
    private static final String COMMA = ", ";
    private static final String SUJANA_LAB_LOCATOR = "#lablist > tbody > tr:nth-child(53) > td:nth-child(2) > form > a";
    private static final String LAB_EDIT_URL = "http://bmtechsol.com:8080/easytox/lab/edit";
    private static final String UPDATE_WIDGET_LOCATOR = "#maincontentdiv > div.page-body > div > div.col-xs-12.col-md-12 > div > div.widget-header > span";
    private static final String UPDATE_WIDGET_VALUE = "Update Lab";
    private static final String ATTRIBUTE_VALUE = "value";
    private static final String ADD_USER_ICON = "#maincontentdiv > div.page-body > div > div.col-xs-12.col-md-12 > div > div.widget-header > div > div:nth-child(4) > form > a";
    private static final String ADD_LAB_ADMIN_PAGE_URL = "http://bmtechsol.com:8080/easytox/user/create";
    private static final String ADD_LAB_ADMIN_WIDGET_LOCATOR = "#maincontentdiv > div.page-body > div > div.widget-header.bg-blue > span";
    private static final String ADD_LAB_ADMIN_WIDGET_VALUE = "Add Lab Admin User";
    private static final String ADD_USER_BUTTON_LOCATOR = "#form > button.btn.btn-primary";
    private static final String USER_SAVE_PAGE_URL = "http://bmtechsol.com:8080/easytox/user/save";
    private static final String TABLE_LOCATOR = "example";
    private static final String DANGER_LOCATOR = "#maincontentdiv > div.page-body > div.alert.alert-danger.fade.in";
    private static final String LIMIT_EXCEEDED = "User limit exceeded";
    private static final String LAB_USER_LOGIN = "Snlabadmin";
    private static final String LAB_USER_PASSWORD = "Test@123";
    private static final String WIDGET_CASE_LIST_LOCATOR = "#maincontentdiv > div.page-body > div > div > div > div.widget-header > span";
    private static final String WIDGET_CASE_LIST_VALUE = "Case List";
    private static final String CASE_LIST_URL = "http://bmtechsol.com:8080/easytox/caseOrder/list";
    private static final String SETTINGS_LOCATOR = "body > div.navbar > div > div > div.navbar-header.pull-right > div > ul > li:nth-child(8) > a";
    private static final String USER_LOCATOR = "#topmenu > li:nth-child(1) > a";
    private static final String USER_LIST_URL = "http://bmtechsol.com:8080/easytox/user/index";
    private static final String WIDGET_USER_LIST_VALUE = "User List";
    private static final String ADD_USER_ICON_LOCATOR = "#example_wrapper > div.toolbar > a:nth-child(1)";
    private static final String WIDGET_ADD_LAB_USER_VALUE = "Add Lab User";
    private static final String LAB_CLIENT_LOCATOR = "#topmenu > li:nth-child(5) > a";
    private static final String LAB_CLIENT_URL = "http://bmtechsol.com:8080/easytox/labClient/list";
    private static final String LAB_CLIENT_VALUE = "Lab Client List";
    private static final String ADD_LAB_CLIENT_ICON = "#example_wrapper > div.toolbar > a";
    private static final String ADD_LAB_CLIENT_URL = "http://bmtechsol.com:8080/easytox/labClient/create";
    private static final String WIDGET_ADD_LAB_CLIENT_VALUE = "Add Lab Client";
    private static final String ADD_LAB_CLIENT_LOCATOR = "#form > div:nth-child(12) > div > button";
    private static final String LAB_CLIENT_SAVE_URL = "http://bmtechsol.com:8080/easytox/labClient/save";
    private static final String DROP_DOWN_LOC = "example_length";
    private static final String PHYSICIAN_LOCATOR = "#topmenu > li:nth-child(10) > a";
    private static final String PHYSICIAN_LIST_PAGE_URL = "http://bmtechsol.com:8080/easytox/clinician/clinicianlist";
    private static final String WIDGET_PHYSICIAN_LIST_LOCATOR = "#maincontentdiv > div.page-body > div.row > div > div > div.widget-header > span";
    private static final String WIDGET_PHYSICIAN_LIST_VALUE = "Physician List";
    private static final String ADD_PHYSICIAN_PAGE_URL = "http://bmtechsol.com:8080/easytox/clinician/create";
    private static final String WIDGET_ADD_PHYSICIAN_VALUE = "Add Physician";
    private static final String AUDIT_LOG_LOCATOR = "#topmenu > li:nth-child(7) > a";
    private static final String AUDIT_LOG_PAGE_URL = "http://bmtechsol.com:8080/easytox/auditLog/list";
    private static final String WIDGET_AUDIT_LOG_VALUE = "Audit Log";
    private static final String LAB_CLIENT_DROP_DOWN_LOCATOR = "labClient";
    private static final String USER_DROP_DOWN_LOCATOR = "user";
    private static final String SEARCH_BUTTON_LOCATOR = "search";
    private static final String TABLE_NAME_LOCATOR = "table";
    private static final String TABLE_NAME_VALUE = "user";
    private static final String EVENT_TYPE_LOCATOR = "eventType";
    private static final String EVENT_TYPE_OPTION = "Insert";
    private static final String EVENT_TYPE_VALUE = "INSERT";
    private static final String DATE_TO_LOCATOR = "example_range_to_2";
    private static final String DATE_FROM_LOCATOR = "example_range_from_2";
    private static final String PAGINATION_LOCATOR = "#example_paginate > ul";
    private static final String ATTRIBUTE_CLASS_LOCATOR = "class";
    private static final String USER_LOG_LOCATOR = "#topmenu > li:nth-child(8) > a";
    private static final String USER_LOG_PAGE_URL = "http://bmtechsol.com:8080/easytox/userLog/list";
    private static final String WIDGET_USER_LOG_VALUE = "User Log";

    private static final String REGEX = "^(\\d+)/(\\w+)/(\\d{4})(\\s)(\\d{2}):(\\d{2}):(\\d{2})$";
    private static final String CELLS_LOCATOR = "./*";
    private static final String SORT_ATTRIBUTE_LOCATOR = "aria-sort";
    private static final String SORT_ATTRIBUTE_VALUE = "ascending";
    private static final String SORT_DESCENDING_VALUE = "descending";
    private static final String SORT_ASCENDING_LOCATOR = "#example > thead > tr > th.sorting_asc";
    private static final String ROWS_LOCATOR = "tr";
    private static final String LIST_LOCATOR = "li";
    private static final String MESSAGE_LOCATOR = "#example_info";


    private static List<WebElement> labClientOptions;
    private static List<WebElement> userOptions;
    private static List<WebElement> columns;
    private static List<List<WebElement>> allCells;
    private static String navigateButton;

    private static String[] columnValues = {"Modified By", "Lab", "Lab Client", "Date/Time",
            "Table Name", "Column Name", "Old Value", "New Value", "Event Type"};
    private static String[] userLogColumns = {"User Name", "Lab", "Lab Client", "Visited URL", "Date/Time", "Case Acc#"};


    private WebDriver driver;

    public AuditAndUserLogImpl() {
        DriverBase.instantiateDriverObject();
        driver = DriverBase.getDriver();
    }

    /*
    Scenario: Create a Lab
     */

    @When("^Login with Superadmin/admin credentials$")
    public void login_with_superadmin() {
        MyWebDriverUtils.authorization(driver, LOGIN_PAGE_URL,
                FIND_USERNAME, LocatorType.NAME, LOGIN,
                FIND_PASSWORD, LocatorType.NAME, PASSWORD,
                LOGIN_BUTTON_XPATH, LocatorType.XPATH);
    }

    @Then("^Lab List screen should be displayed$")
    public void lab_list_screen_should_be_displayed() {
        MyWebDriverUtils.checkCurrentUrl(driver, LAB_LIST_URL);
    }

    @When("^Select '\\+' icon next to search box$")
    public void select_plus_icon_next_to_search_box() {
        MyWebDriverUtils.waitContainerThenClick(driver, ADD_PLUS_ICON_LOCATOR, LocatorType.ID);
    }

    @Then("^Add Lab page should be open$")
    public void add_lab_page_should_be_open() {
        MyWebDriverUtils.checkPageCaption(driver, WIDGET_ADD_LAB_LOCATOR, LocatorType.ID, WIDGET_ADD_LAB_VALUE);
    }

    @When("^Enter lab name as 'Sujana Lab' and enter all the required details and click on 'Submit'$")
    public void enter_all_details() {
        Lab.labName = Lab.LAB_NAME + MyWebDriverUtils.getRandomNumber();
        Lab.email = Lab.EMAIL + MyWebDriverUtils.getRandomNumber();
        MyWebDriverUtils.enterData(driver, Lab.LAB_NAME_LOCATOR, LocatorType.ID, Lab.labName);
        MyWebDriverUtils.enterData(driver, Lab.DESCRIPTION_LOCATOR, LocatorType.ID, Lab.DESCRIPTION);
        MyWebDriverUtils.enterData(driver, Lab.EMAIL_LOCATOR, LocatorType.NAME, Lab.email);
        MyWebDriverUtils.enterData(driver, Lab.ADDRESS_1_LOCATOR, LocatorType.NAME, Lab.ADDRESS_1);
        MyWebDriverUtils.enterData(driver, Lab.ADDRESS_2_LOCATOR, LocatorType.NAME, Lab.ADDRESS_2);
        MyWebDriverUtils.enterData(driver, Lab.ZIP_CODE_LOCATOR, LocatorType.ID, Lab.ZIP_CODE);
        MyWebDriverUtils.enterData(driver, Lab.COUNTRY_LOCATOR, LocatorType.NAME, Lab.COUNTRY);
        // MyWebDriverUtils.selectOption(driver, Lab.PLAN_LOCATOR, LocatorType.ID, Lab.PLAN);
        MyWebDriverUtils.waitContainerThenClick(driver, SUBMIT_LOCATOR, LocatorType.CSS);
    }

    @Then("^Added Lab should be displayed in the list$")
    public void added_lab_should_be_displayed_in_the_list() {
        MyWebDriverUtils.checkCurrentUrl(driver, LAB_LIST_URL);
        MyWebDriverUtils.checkWidgetCaption(driver, SUCCESS_LOCATOR, LocatorType.CSS, "Lab " + Lab.labName + " created");
        MyWebDriverUtils.selectOption(driver, DROP_DOWN_LOCATOR, LocatorType.CSS, ALL);

        List<WebElement> cells = MyWebDriverUtils.getCells(driver, LAB_TABLE_LOCATOR, LocatorType.ID, -1, 5);
        if (cells != null && cells.size() == 5) {
            String address = Lab.ADDRESS_1 + COMMA + Lab.ADDRESS_2 + COMMA + Lab.CITY + COMMA + Lab.STATE + COMMA + Lab.ZIP_CODE;
            Assert.assertEquals(cells.get(1).getText(), Lab.labName);
            Assert.assertEquals(cells.get(2).getText(), Lab.DESCRIPTION);
            Assert.assertEquals(cells.get(3).getText(), address);
        } else {
            Assert.fail("cells is null");
        }
    }

    /*
    Scenario: Create a Lab Admin
     */

    @When("^Select 'Sujana Lab' from the lab list$")
    public void select_lab_from_the_lab_list() {
        MyWebDriverUtils.selectOption(driver, DROP_DOWN_LOCATOR, LocatorType.CSS, ALL);
        MyWebDriverUtils.waitContainerThenClick(driver, SUJANA_LAB_LOCATOR, LocatorType.CSS);

    }

    @Then("^Update Lab screen should be displayed$")
    public void update_lab_scree_should_be_displayed() {
        MyWebDriverUtils.checkCurrentUrl(driver, LAB_EDIT_URL);
        MyWebDriverUtils.checkWidgetCaption(driver, UPDATE_WIDGET_LOCATOR, LocatorType.CSS, UPDATE_WIDGET_VALUE);

        WebElement element = MyWebDriverUtils.findElement(driver, Lab.LAB_NAME_LOCATOR, LocatorType.NAME);
        if (element != null) {
            Assert.assertEquals(element.getAttribute(ATTRIBUTE_VALUE), Lab.LAB_NAME);
        }
    }

    @When("^Click 'Add User' icon$")
    public void click_add_user_icon() {
        MyWebDriverUtils.waitContainerThenClick(driver, ADD_USER_ICON, LocatorType.CSS);
    }

    @Then("^Add Lab Admin user screen should be displayed$")
    public void add_lab_admin_user_screen_should_be_displayed() {
        MyWebDriverUtils.checkCurrentUrl(driver, ADD_LAB_ADMIN_PAGE_URL);
        MyWebDriverUtils.checkWidgetCaption(driver, ADD_LAB_ADMIN_WIDGET_LOCATOR, LocatorType.CSS, ADD_LAB_ADMIN_WIDGET_VALUE);
    }

    @When("^Enter 'username/password' as 'Snlabadmin/Test@123' and all the other required information and click 'Add User'$")
    public void enter_all_required_information() {
        User.userName = User.USER_NAME + MyWebDriverUtils.getRandomNumber();

        MyWebDriverUtils.enterData(driver, User.USER_NAME_LOCATOR, LocatorType.NAME, User.userName);
        MyWebDriverUtils.enterData(driver, User.PASSWORD_LOCATOR, LocatorType.NAME, User.PASSWORD);
        MyWebDriverUtils.enterData(driver, User.FIRST_NAME_LOCATOR, LocatorType.NAME, User.FIRST_NAME);
        MyWebDriverUtils.enterData(driver, User.LAST_NAME_LOCATOR, LocatorType.NAME, User.LAST_NAME);
        MyWebDriverUtils.enterData(driver, User.EMAIL_LOCATOR, LocatorType.NAME, User.EMAIL);
        MyWebDriverUtils.enterData(driver, User.PHONE_NUMBER_LOCATOR, LocatorType.NAME, User.PHONE_NUMBER);
        MyWebDriverUtils.selectOption(driver, User.ROLE_LOCATOR, LocatorType.ID, User.ROLE);
        MyWebDriverUtils.waitContainerThenClick(driver, ADD_USER_BUTTON_LOCATOR, LocatorType.CSS);
    }

    @Then("^Lab Admin should be created successfully and displayed in User List$")
    public void lab_admin_should_be_created_successfully() {

        WebElement element = MyWebDriverUtils.findPresenceElement(driver, DANGER_LOCATOR, LocatorType.CSS);
        if (element != null) {
            Assert.assertEquals(element.getText(), LIMIT_EXCEEDED);
            MyWebDriverUtils.checkCurrentUrl(driver, USER_SAVE_PAGE_URL);
            return;
        }

        MyWebDriverUtils.checkWidgetCaption(driver, SUCCESS_LOCATOR, LocatorType.CSS, "User " + User.userName + " Created Sucessfully");
        MyWebDriverUtils.checkCurrentUrl(driver, USER_SAVE_PAGE_URL);
        List<WebElement> cells = MyWebDriverUtils.getCells(driver, TABLE_LOCATOR, LocatorType.ID, -1, 12);
        if (cells != null && cells.size() == 12) {
            Assert.assertEquals(cells.get(1).getText(), User.userName);
            Assert.assertEquals(cells.get(2).getText(), User.FIRST_NAME + " " + User.LAST_NAME);
            Assert.assertEquals(cells.get(4).getText(), User.EMAIL);
            Assert.assertEquals(cells.get(5).getText(), User.ROLE);
            Assert.assertEquals(cells.get(3).getText(), User.PHONE_NUMBER_VIEW);
        } else {
            Assert.fail("cells is null");
        }
    }

    /*
    Scenario: Create a Lab User
     */

    @When("^Login with 'Snlabadmin/Test@123' credentials$")
    public void login_with_snlabadmin() {
        MyWebDriverUtils.authorization(driver, LOGIN_PAGE_URL,
                FIND_USERNAME, LocatorType.NAME, LAB_USER_LOGIN,
                FIND_PASSWORD, LocatorType.NAME, LAB_USER_PASSWORD,
                LOGIN_BUTTON_XPATH, LocatorType.XPATH);
    }

    @Then("^Case List screen should be displayed$")
    public void case_list_screen_should_be_displayed() {
        MyWebDriverUtils.checkWidgetCaption(driver, WIDGET_CASE_LIST_LOCATOR, LocatorType.CSS, WIDGET_CASE_LIST_VALUE);
        MyWebDriverUtils.checkCurrentUrl(driver, CASE_LIST_URL);
    }

    @When("^Select Settings -> User$")
    public void go_to_user_page() {
        MyWebDriverUtils.waitContainerThenClick(driver, SETTINGS_LOCATOR, LocatorType.CSS);
        MyWebDriverUtils.waitContainerThenClick(driver, USER_LOCATOR, LocatorType.CSS);
    }

    @Then("^User List screen should be displayed$")
    public void user_list_screen_should_be_displayed() {
        MyWebDriverUtils.checkWidgetCaption(driver, WIDGET_CASE_LIST_LOCATOR, LocatorType.CSS, WIDGET_USER_LIST_VALUE);
        MyWebDriverUtils.checkCurrentUrl(driver, USER_LIST_URL);
    }

    @When("^Click on '\\+' icon beside Search box$")
    public void click_on_plus_icon_beside_search_box() {
        MyWebDriverUtils.waitContainerThenClick(driver, ADD_USER_ICON_LOCATOR, LocatorType.CSS);
    }

    @Then("^Add Lab User screen should be displayed$")
    public void add_lab_user_screen_should_be_displayed() {
        MyWebDriverUtils.checkWidgetCaption(driver, ADD_LAB_ADMIN_WIDGET_LOCATOR, LocatorType.CSS, WIDGET_ADD_LAB_USER_VALUE);
        MyWebDriverUtils.checkCurrentUrl(driver, ADD_LAB_ADMIN_PAGE_URL);
    }

    @When("^Enter Username/Password as 'labuserone/Test@123'," +
            " Role as 'Lab_Technician' and enter all the other required information and click Submit$")
    public void enter_all_required_data() {
        LabUser.userName = LabUser.USER_NAME + MyWebDriverUtils.getRandomNumber();

        MyWebDriverUtils.enterData(driver, User.USER_NAME_LOCATOR, LocatorType.NAME, LabUser.userName);
        MyWebDriverUtils.enterData(driver, User.PASSWORD_LOCATOR, LocatorType.NAME, LabUser.PASSWORD);
        MyWebDriverUtils.enterData(driver, LabUser.FIRST_NAME_LOCATOR, LocatorType.CSS, User.FIRST_NAME);
        MyWebDriverUtils.enterData(driver, LabUser.LAST_NAME_LOCATOR, LocatorType.CSS, User.LAST_NAME);
        MyWebDriverUtils.enterData(driver, User.EMAIL_LOCATOR, LocatorType.NAME, User.EMAIL);
        MyWebDriverUtils.enterData(driver, User.PHONE_NUMBER_LOCATOR, LocatorType.NAME, User.PHONE_NUMBER);
        MyWebDriverUtils.selectOption(driver, User.ROLE_LOCATOR, LocatorType.NAME, LabUser.ROLE);
        MyWebDriverUtils.waitContainerThenClick(driver, ADD_USER_BUTTON_LOCATOR, LocatorType.CSS);
    }

    @Then("^labuserone should be added to the user list$")
    public void user_should_be_added_to_the_user_list() {
        WebElement element = MyWebDriverUtils.findPresenceElement(driver, DANGER_LOCATOR, LocatorType.CSS);
        if (element != null) {
            Assert.assertEquals(element.getText(), LIMIT_EXCEEDED);
            MyWebDriverUtils.checkCurrentUrl(driver, USER_LIST_URL);
        }
    }

    /*
    Scenario Outline: Create a Lab Client
     */

    @When("^Select Settings -> Lab Client.$")
    public void select_settings_lab_client() {
        MyWebDriverUtils.waitContainerThenClick(driver, SETTINGS_LOCATOR, LocatorType.CSS);
        MyWebDriverUtils.waitContainerThenClick(driver, LAB_CLIENT_LOCATOR, LocatorType.CSS);
    }

    @Then("^LabClient List screen should be displayed$")
    public void lab_client_list_screen_should_be_displayed() {
        MyWebDriverUtils.checkWidgetCaption(driver, WIDGET_CASE_LIST_LOCATOR, LocatorType.CSS, LAB_CLIENT_VALUE);
        MyWebDriverUtils.checkCurrentUrl(driver, LAB_CLIENT_URL);
    }


    @When("^Click on '\\+' icon beside Search box.$")
    public void click_on_plus_icon() {
        MyWebDriverUtils.waitContainerThenClick(driver, ADD_LAB_CLIENT_ICON, LocatorType.CSS);
    }

    @Then("^Add Lab Client screen should be displayed$")
    public void add_lab_client_screen_should_be_displayed() {
        MyWebDriverUtils.checkWidgetCaption(driver, ADD_LAB_ADMIN_WIDGET_LOCATOR, LocatorType.CSS, WIDGET_ADD_LAB_CLIENT_VALUE);
        MyWebDriverUtils.checkCurrentUrl(driver, ADD_LAB_CLIENT_URL);
    }

    @When("^Enter business name as (.*) all required information and click Submit$")
    public void enter_all_required_information_and_click_submit(String businessName) {
        MyWebDriverUtils.enterData(driver, LabClient.BUSINESS_NAME_LOCATOR, LocatorType.NAME, businessName);
        MyWebDriverUtils.enterData(driver, LabClient.ADDRESS_1_LOCATOR, LocatorType.NAME, LabClient.ADDRESS_1);
        MyWebDriverUtils.enterData(driver, LabClient.ADDRESS_2_LOCATOR, LocatorType.NAME, LabClient.ADDRESS_2);
        MyWebDriverUtils.enterData(driver, LabClient.ZIP_CODE_LOCATOR, LocatorType.NAME, LabClient.ZIP_CODE);
        MyWebDriverUtils.enterData(driver, LabClient.CONTACT_PERSON_LOCATOR, LocatorType.NAME, LabClient.CONTACT_PERSON);
        MyWebDriverUtils.enterData(driver, LabClient.CONTACT_NUMBER_LOCATOR, LocatorType.NAME, LabClient.CONTACT_NUMBER);
        MyWebDriverUtils.enterData(driver, LabClient.FAX_NUMBER_LOCATOR, LocatorType.NAME, LabClient.FAX_NUMBER);
        MyWebDriverUtils.enterData(driver, LabClient.CONTACT_EMAIL_LOCATOR, LocatorType.NAME, LabClient.CONTACT_EMAIL);

        MyWebDriverUtils.waitContainerThenClick(driver, ADD_LAB_CLIENT_LOCATOR, LocatorType.CSS);
    }

    @Then("^(.*) should be added to the LabClient list$")
    public void lab_should_be_added(String businessName) {
        MyWebDriverUtils.checkWidgetCaption(driver, SUCCESS_LOCATOR, LocatorType.CSS, "x\nSuccess LabClient " + businessName + " created");
        MyWebDriverUtils.checkCurrentUrl(driver, LAB_CLIENT_SAVE_URL);

        MyWebDriverUtils.selectOption(driver, DROP_DOWN_LOC, LocatorType.NAME, ALL);

        List<WebElement> cells = MyWebDriverUtils.getCells(driver, TABLE_LOCATOR, LocatorType.ID, -1, 9);
        if (cells != null && cells.size() == 9) {
            Assert.assertEquals(cells.get(1).getText(), businessName);
            Assert.assertEquals(cells.get(2).getText(), LabClient.CITY);
            Assert.assertEquals(cells.get(3).getText(), LabClient.STATE);
            Assert.assertEquals(cells.get(4).getText(), LabClient.ZIP_CODE);
            Assert.assertEquals(cells.get(5).getText(), LabClient.CONTACT_PERSON);
            Assert.assertEquals(cells.get(6).getText(), LabClient.VIEW_CONTACT_NUMBER);
            Assert.assertEquals(cells.get(7).getText(), LabClient.CONTACT_EMAIL);
        } else {
            Assert.fail("cells is null!");
        }


    }

    /*
    Scenario Outline: Create a Lab Physician
     */

    @When("^Select Settings -> Physician.$")
    public void select_settings_physician() {
        MyWebDriverUtils.waitContainerThenClick(driver, SETTINGS_LOCATOR, LocatorType.CSS);
        MyWebDriverUtils.waitContainerThenClick(driver, PHYSICIAN_LOCATOR, LocatorType.CSS);
    }

    @Then("^Physician List screen should be displayed.$")
    public void physician_list_screen_should_be_displayed() {
        MyWebDriverUtils.checkWidgetCaption(driver, WIDGET_PHYSICIAN_LIST_LOCATOR, LocatorType.CSS, WIDGET_PHYSICIAN_LIST_VALUE);
        MyWebDriverUtils.checkCurrentUrl(driver, PHYSICIAN_LIST_PAGE_URL);
    }

    @When("^Click on '\\+' icon beside search box$")
    public void click_on_plus() {
        MyWebDriverUtils.waitContainerThenClick(driver, ADD_LAB_CLIENT_ICON, LocatorType.CSS);
    }

    @Then("^Add Physician screen should be displayed$")
    public void add_physician_screen_should_be_displayed() {
        MyWebDriverUtils.checkWidgetCaption(driver, ADD_LAB_ADMIN_WIDGET_LOCATOR, LocatorType.CSS, WIDGET_ADD_PHYSICIAN_VALUE);
        MyWebDriverUtils.checkCurrentUrl(driver, ADD_PHYSICIAN_PAGE_URL);
    }

    @When("^Enter Username as (.*), Password as 'Test@123' and enter all the other required information and click Submit$")
    public void enter_username_and_all_required_data(String userName) {
        Physician.userName = userName + MyWebDriverUtils.getRandomNumber();

        MyWebDriverUtils.selectOption(driver, Physician.LAB_CLIENT_LOCATOR, LocatorType.ID, Physician.LAB_CLIENT);
        MyWebDriverUtils.enterData(driver, Physician.USER_NAME_LOCATOR, LocatorType.NAME, Physician.userName);
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

    @Then("^(.*) should be added to the physician list$")
    public void physician_should_be_added(String name) {
        MyWebDriverUtils.checkCurrentUrl(driver, PHYSICIAN_LIST_PAGE_URL);
        MyWebDriverUtils.checkWidgetCaption(driver, SUCCESS_LOCATOR, LocatorType.CSS, "x\nSuccess Clinician " + Physician.userName + " created");

        MyWebDriverUtils.selectOption(driver, DROP_DOWN_LOC, LocatorType.NAME, ALL);

        List<WebElement> cells = MyWebDriverUtils.getCells(driver, TABLE_LOCATOR, LocatorType.ID, -1, 8);
        if (cells != null && cells.size() == 8) {
            Assert.assertEquals(cells.get(1).getText(), Physician.userName);
            Assert.assertEquals(cells.get(2).getText(), Physician.FIRST_NAME + " " + Physician.LAST_NAME);
            Assert.assertEquals(cells.get(4).getText(), Physician.SALUTATION);
            Assert.assertEquals(cells.get(5).getText(), Physician.MEDICARE_NUMBER);
            Assert.assertEquals(cells.get(6).getText(), Physician.MEDICAID_NUMBER);
        } else {
            Assert.fail("cells is null!");
        }
    }

    /*
     Scenario: Verify Audit Log
     */


    @When("^Select Settings -> Audit Log$")
    public void select_settings_audit_log() {
        MyWebDriverUtils.waitContainerThenClick(driver, SETTINGS_LOCATOR, LocatorType.CSS);
        MyWebDriverUtils.waitContainerThenClick(driver, AUDIT_LOG_LOCATOR, LocatorType.CSS);
    }

    @Then("^Audit Log Screen should be displayed$")
    public void audit_log_screen_should_be_displayed() {
        MyWebDriverUtils.checkWidgetCaption(driver, WIDGET_CASE_LIST_LOCATOR, LocatorType.CSS, WIDGET_AUDIT_LOG_VALUE);
        MyWebDriverUtils.checkCurrentUrl(driver, AUDIT_LOG_PAGE_URL);
    }

    @When("^Verify the values in 'Lab Client' drop down$")
    public void verify_the_values_in_lab_client_drop_down() {
        labClientOptions = MyWebDriverUtils.getOptions(driver, LAB_CLIENT_DROP_DOWN_LOCATOR, LocatorType.ID);
    }

    @Then("^'(.*)' and '(.*)' values should be displayed$")
    public void check_values(String firstValue, String SecondValue) {
        int i = 0;
        int j = 0;
        if (labClientOptions != null) {
            for (WebElement option : labClientOptions) {
                if (option.getText().equals(firstValue)) {
                    i++;
                }

                if (option.getText().equals(SecondValue)) {
                    j++;
                }
            }
            Assert.assertTrue(i > 0);
            Assert.assertTrue(j > 0);
        } else {
            Assert.fail("labClientOptions is null!");
        }
    }

    @When("^Verify for other values in 'lab Client' drop down$")
    public void verify_for_other_values() {
        labClientOptions = MyWebDriverUtils.getOptions(driver, LAB_CLIENT_DROP_DOWN_LOCATOR, LocatorType.ID);
    }

    @Then("^No other values should be displayed in the Lab Client drop down$")
    public void no_other_values() {
        if (labClientOptions != null) {
            for (WebElement option : labClientOptions) {
                String text = option.getText();
                if (!text.equals("SLabClientOne") && !text.equals("SLabClientTwo") && !text.equals("Select Lab Client")) {
                    Assert.fail(text + " is other value in Lab Client Drop Down");

                }
            }
        } else {
            Assert.fail("labClientOptions is null!");
        }
    }

    @When("^Verify the values in 'User' drop down$")
    public void verify_the_values_in_user_drop_down() {
        userOptions = MyWebDriverUtils.getOptions(driver, USER_DROP_DOWN_LOCATOR, LocatorType.ID);
    }

    @Then("^'SNlabadmin', 'SPhyOne', 'SPhyTwo', 'labuserone' values should be displayed in the User drop down$")
    public void check_valid_values_in_user_drop_down() {
        int i, j, k, m;
        i = j = k = m = 0;
        if (userOptions != null) {
            for (WebElement option : userOptions) {
                String text = option.getText();
                switch (text) {
                    case "SNlabadmin":
                        i++;
                        break;
                    case "SPhyOne":
                        j++;
                        break;
                    case "SPhyTwo":
                        k++;
                        break;
                    case "labuserone":
                        m++;
                        break;
                }
            }

            Assert.assertTrue(i > 0);
            Assert.assertTrue(j > 0);
            Assert.assertTrue(k > 0);
            Assert.assertTrue(m > 0);

        } else {
            Assert.fail("userOptions is null!");
        }
    }

    @When("^Verify for other values in 'User' drop down$")
    public void verify_for_other_values_in_user_drop_down() {
        userOptions = MyWebDriverUtils.getOptions(driver, USER_DROP_DOWN_LOCATOR, LocatorType.ID);
    }

    @Then("^No other values should be displayed in the User drop down$")
    public void no_other_values_in_user_drop_down() {
        if (userOptions != null) {
            for (WebElement option : userOptions) {
                String text = option.getText();
                if (!text.equals("SNlabadmin") && !text.equals("SPhyOne") && !text.equals("SPhyTwo") &&
                        !text.equals("labuserone") && !text.equals("Select User")) {
                    Assert.fail(text + " is other value in User Drop Down");

                }
            }
        } else {
            Assert.fail("userOptions is null!");
        }
    }

    @When("^Verify the columns displayed in the Audit Log$")
    public void verify_the_columns_displayed_in_the_audit_log() {
        columns = MyWebDriverUtils.getTh(driver, TABLE_LOCATOR, LocatorType.ID, 9);
    }

    @Then("^Following columns should be displayed in Audit Log:" +
            " Modified by, Lab, Lab Client, Date/Time, Table Name, Column Name, Old Value, New Value, Event Type$")
    public void check_columns() {
        if (columns != null && columns.size() == 9) {
            for (int i = 0; i < columns.size(); i++) {
                Assert.assertEquals(columns.get(i).getText(), columnValues[i]);
            }
        } else {
            Assert.fail("columns is null!");
        }
    }

    @When("^Verify the values under 'Modified By' column$")
    public void verify_the_value_under_modified_by_column() {
        MyWebDriverUtils.selectOption(driver, DROP_DOWN_LOC, LocatorType.NAME, ALL);

        allCells = MyWebDriverUtils.getAllCells(driver, TABLE_LOCATOR, LocatorType.ID, 9);

    }

    @Then("^Only either of the following values should be displayed under 'Modified By' column:" +
            " 'SNlabadmin', 'SPhyOne', 'SPhyTwo', 'labuserone'." +
            " No other values than above four should be displayed under 'Modified By' column$")
    public void check_modify_by_column() {
        if (allCells != null) {
            for (int i = 1; i < allCells.size(); i++) {
                Assert.assertTrue(allCells.get(i).get(0).getText().equals("SNlabadmin") ||
                        allCells.get(i).get(0).getText().equals("SPhyOne") ||
                        allCells.get(i).get(0).getText().equals("SPhyTwo") ||
                        allCells.get(i).get(0).getText().equals("labuserone"));
            }
        } else {
            Assert.fail("allCells is null!");
        }
    }

    @When("^Verify the values under 'Lab' column$")
    public void verify_the_values_under_lab_column() {
        MyWebDriverUtils.selectOption(driver, DROP_DOWN_LOC, LocatorType.NAME, ALL);

        allCells = MyWebDriverUtils.getAllCells(driver, TABLE_LOCATOR, LocatorType.ID, 9);
    }

    @Then("^Value under 'Lab' column should be 'Sujana Lab' always$")
    public void check_value_lab_column() {
        if (allCells != null) {
            for (int i = 1; i < allCells.size(); i++) {
                Assert.assertTrue(allCells.get(i).get(1).getText().equals("Sujana Lab"));
            }
        } else {
            Assert.fail("allCells is null!");
        }
    }

    @When("^Verify the values under 'Lab Client' column$")
    public void verify_the_values_under_Lab_Client_column() {
        MyWebDriverUtils.selectOption(driver, DROP_DOWN_LOC, LocatorType.NAME, ALL);

        allCells = MyWebDriverUtils.getAllCells(driver, TABLE_LOCATOR, LocatorType.ID, 9);
    }

    @Then("^Value under 'Lab Client' column should be 'SLabClientOne' or 'SLabClientTwo' only. No other values should be displayed$")
    public void check_value_lab_client_column() {
        if (allCells != null) {
            for (int i = 1; i < allCells.size(); i++) {
                Assert.assertTrue(allCells.get(i).get(2).getText().equals("SLabClientOne") ||
                        allCells.get(i).get(2).getText().equals("SLabClientTwo") ||
                        allCells.get(i).get(2).getText().equals(""));
            }
        } else {
            Assert.fail("allCells is null!");
        }
    }

    @When("^Verify the values under 'Date/Time' column$")
    public void verify_the_values_under_date_time_column() {
        MyWebDriverUtils.selectOption(driver, DROP_DOWN_LOC, LocatorType.NAME, ALL);

        allCells = MyWebDriverUtils.getAllCells(driver, TABLE_LOCATOR, LocatorType.ID, 9);
    }

    @Then("^Date and Time of the individual events in the formats 'DD/MMM/YYYY' and 'HH:MM:SS' respectively should be displayed$")
    public void check_date_time_column() {
        if (allCells != null) {
            for (int i = 1; i < allCells.size(); i++) {
                Assert.assertTrue(allCells.get(i).get(3).getText().matches(REGEX));
            }
        } else {
            Assert.fail("allCells is null!");
        }
    }

    @When("^Verify the values in other columns$")
    public void verify_the_values_in_other_column() {
        MyWebDriverUtils.selectOption(driver, DROP_DOWN_LOC, LocatorType.NAME, ALL);

        allCells = MyWebDriverUtils.getAllCells(driver, TABLE_LOCATOR, LocatorType.ID, 9);
    }

    @Then("^Respective table updates should be displayed appropriately for each event$")
    public void check_respective_table_updates() {
        if (allCells != null) {
            for (int i = 1; i < allCells.size(); i++) {
                Assert.assertTrue(!allCells.get(i).get(4).getText().equals(""));
                Assert.assertTrue(!allCells.get(i).get(5).getText().equals(""));
                if(!allCells.get(i).get(6).getText().equals("") && !allCells.get(i).get(7).getText().equals("")){
                    Assert.assertTrue(allCells.get(i).get(8).getText().equals("UPDATE"));
                } else{
                    Assert.assertTrue(allCells.get(i).get(8).getText().equals("INSERT"));
                }
            }
        } else {
            Assert.fail("allCells is null!");
        }
    }

    /*
      Scenario: Verify Audit Log Filters
     */

    @When("^Select a value from 'Lab Client' drop down and click Search$")
    public void select_value_from_lab_client_drop_down() {
        clear_filer();
        MyWebDriverUtils.selectOption(driver, LAB_CLIENT_DROP_DOWN_LOCATOR, LocatorType.ID, "SLabClientOne");

        driver.findElement(By.id(SEARCH_BUTTON_LOCATOR)).sendKeys(Keys.ENTER);

    }

    @Then("^Results corresponding to selected Lab Client should be displayed$")
    public void results_corresponding_to_selected_lab_client() {
        while (true) {
            try {
                allCells = MyWebDriverUtils.getAllCells(driver, TABLE_LOCATOR, LocatorType.ID, 9);
                if (allCells != null) {
                    for (List<WebElement> list : allCells) {
                        Assert.assertTrue(list.get(2).getText().equals("SLabClientOne"));
                    }
                    break;
                } else {
                    Assert.fail("allCells is null!");
                }
            } catch (StaleElementReferenceException ex) {
                System.out.println("element is not attached to the page document");
            }
        }


    }

    @When("^Select a value from 'User' drop down and click Search$")
    public void select_a_value_from_user_drop_down() {
        clear_filer();
        MyWebDriverUtils.selectOption(driver, USER_DROP_DOWN_LOCATOR, LocatorType.ID, "SNlabadmin");

        driver.findElement(By.id(SEARCH_BUTTON_LOCATOR)).sendKeys(Keys.ENTER);
    }

    @Then("^Results corresponding to selected User should be displayed$")
    public void results_corresponding_to_selected_user() {
        while (true) {
            try {
                allCells = MyWebDriverUtils.getAllCells(driver, TABLE_LOCATOR, LocatorType.ID, 9);
                if (allCells != null) {
                    for (List<WebElement> list : allCells) {
                        Assert.assertTrue(list.get(0).getText().equals("SNlabadmin"));
                    }
                } else {
                    Assert.fail("allCells is null!");
                }
                break;
            } catch (StaleElementReferenceException ex) {
                System.out.println("element is not attached to the page document");
            }
        }
    }

    @When("^Select From and To Dates in the Date Range and click Search$")
    public void select_from_and_to_dates_in_the_date_range() {
        clear_filer();

        MyWebDriverUtils.enterData(driver, DATE_FROM_LOCATOR, LocatorType.ID,
                Date.FROM_MONTH + "/" + Date.FROM_DAY + "/" + Date.FROM_YEAR);
        MyWebDriverUtils.enterData(driver, DATE_TO_LOCATOR, LocatorType.ID,
                Date.TO_MONTH + "/" + Date.TO_DAY + "/" + Date.TO_YEAR);

        driver.findElement(By.id(SEARCH_BUTTON_LOCATOR)).sendKeys(Keys.ENTER);
    }

    @Then("^Only records between the selected date range should be displayed$")
    public void check_records() {
        while (true) {
            try {
                allCells = MyWebDriverUtils.getAllCells(driver, TABLE_LOCATOR, LocatorType.ID, 9);
                if (allCells != null) {
                    for (int i = 1; i < allCells.size(); i++) {
                        String date = allCells.get(i).get(3).getText();
                        int[] parseDate = MyWebDriverUtils.parseDate(date);

                        checkDate(parseDate, date);

                        if (parseDate[0] < Date.FROM_YEAR && parseDate[0] > Date.TO_YEAR) {
                            Assert.fail(date + " this date should not be displayed!");
                        }

                    }
                } else {
                    Assert.fail("allCells is null!");
                }
                break;
            } catch (StaleElementReferenceException ex) {
                System.out.println("element is not attached to the page document");
            }
        }
    }

    @When("^Enter a value 'Table Name' field and click Search$")
    public void enter_value_table_name_field() {
        clear_filer();
        MyWebDriverUtils.enterData(driver, TABLE_NAME_LOCATOR, LocatorType.ID, TABLE_NAME_VALUE);

        driver.findElement(By.id(SEARCH_BUTTON_LOCATOR)).sendKeys(Keys.ENTER);
    }

    @Then("^All the records with entered Table Name should be displayed$")
    public void check_all_records() {
        while (true) {
            try {
                allCells = MyWebDriverUtils.getAllCells(driver, TABLE_LOCATOR, LocatorType.ID, 9);
                if (allCells != null) {
                    for (List<WebElement> list : allCells) {
                        Assert.assertTrue(list.get(4).getText().equals(TABLE_NAME_VALUE));
                    }
                } else {
                    Assert.fail("allCells is null!");
                }
                break;
            } catch (StaleElementReferenceException ex) {
                System.out.println("element is not attached to the page document");
            }
        }
    }

    @When("^Select an Event Type from the drop down and click Search$")
    public void select_event_type_from_drop_down() {
        clear_filer();
        MyWebDriverUtils.selectOption(driver, EVENT_TYPE_LOCATOR, LocatorType.ID, EVENT_TYPE_OPTION);

        driver.findElement(By.id(SEARCH_BUTTON_LOCATOR)).sendKeys(Keys.ENTER);
    }

    @Then("^All the records matchin selected 'Event Type' should be displayed$")
    public void check_all_records_matchin_selected_event_type() {
        while (true) {
            try {
                allCells = MyWebDriverUtils.getAllCells(driver, TABLE_LOCATOR, LocatorType.ID, 9);
                if (allCells != null) {
                    for (List<WebElement> list : allCells) {
                        Assert.assertTrue(list.get(8).getText().equals(EVENT_TYPE_VALUE));
                    }
                    break;
                } else {
                    Assert.fail("allCells is null!");
                }

            } catch (StaleElementReferenceException ex) {
                System.out.println("element is not attached to the page document");
            }
        }
    }

    @When("^Select values from two or more filters and click Search$")
    public void select_a_few_filters() {
        clear_filer();
        MyWebDriverUtils.enterData(driver, TABLE_NAME_LOCATOR, LocatorType.ID, TABLE_NAME_VALUE);
        MyWebDriverUtils.selectOption(driver, EVENT_TYPE_LOCATOR, LocatorType.ID, EVENT_TYPE_OPTION);
        MyWebDriverUtils.selectOption(driver, USER_DROP_DOWN_LOCATOR, LocatorType.ID, "SNlabadmin");

        driver.findElement(By.id(SEARCH_BUTTON_LOCATOR)).sendKeys(Keys.ENTER);
    }

    @Then("^Records as per the entered search criteria should be displayed$")
    public void check_records_for_a_given_criteria() {
        while (true) {
            try {
                allCells = MyWebDriverUtils.getAllCells(driver, TABLE_LOCATOR, LocatorType.ID, 9);
                if (allCells != null) {
                    for (List<WebElement> list : allCells) {
                        Assert.assertTrue(list.get(0).getText().equals("SNlabadmin"));
                        Assert.assertTrue(list.get(4).getText().equals(TABLE_NAME_VALUE));
                        Assert.assertTrue(list.get(8).getText().equals(EVENT_TYPE_VALUE));
                    }
                } else {
                    Assert.fail("allCells is null!");
                }
                break;
            } catch (StaleElementReferenceException ex) {
                System.out.println("element is not attached to the page document");
            }
        }
    }

    private void clear_filer() {
        MyWebDriverUtils.selectOption(driver, LAB_CLIENT_DROP_DOWN_LOCATOR, LocatorType.ID, "Select Lab Client");
        MyWebDriverUtils.selectOption(driver, USER_DROP_DOWN_LOCATOR, LocatorType.ID, "Select User");
        MyWebDriverUtils.selectOption(driver, EVENT_TYPE_LOCATOR, LocatorType.ID, "Event Type");
        MyWebDriverUtils.enterData(driver, TABLE_NAME_LOCATOR, LocatorType.ID, "");
        MyWebDriverUtils.enterData(driver, DATE_FROM_LOCATOR, LocatorType.ID, "");
        MyWebDriverUtils.enterData(driver, DATE_TO_LOCATOR, LocatorType.ID, "");

        driver.findElement(By.id(SEARCH_BUTTON_LOCATOR)).sendKeys(Keys.ENTER);
    }

    /*
    Scenario Outline: Verify data Sorting in Audit Log
     */

    @When("^Click on down arrow icon  on (.*)$")
    public void click_on_down_arrow_icon(String column) {
        if (column.equals("Modified By")) {
            MyWebDriverUtils.waitContainerThenClick(driver, SORT_ASCENDING_LOCATOR, LocatorType.CSS);
        }

        String locator = chooseLocator(column);
        MyWebDriverUtils.waitContainerThenClick(driver, locator, LocatorType.CSS);
    }

    @Then("^Records should be displayed based on the ascending order of the selected column$")
    public void check_ascending_order() {
        while (true) {
            try {
                WebElement table = driver.findElement(By.id(TABLE_LOCATOR));
                List<WebElement> allRows = table.findElements(By.tagName(ROWS_LOCATOR));
                int j;
                j = getSortColumn(allRows, 8);
                String temp = allRows.get(1).findElements(By.xpath(CELLS_LOCATOR)).get(j).getText();

                checkData(temp, allRows, 2, j);
                break;
            } catch (StaleElementReferenceException ex) {
                System.out.println("element is not attached to the page document");
            }
        }
    }

    @When("^Click on up arrow icon  on (.*)$")
    public void click_on_up_arrow_icon() {
        MyWebDriverUtils.waitContainerThenClick(driver, SORT_ASCENDING_LOCATOR, LocatorType.CSS);
    }

    @Then("^Records should be displayed based on the descending order of the selected column$")
    public void check_descending_order() {
        int j;

        WebElement table = driver.findElement(By.id(TABLE_LOCATOR));

        List<WebElement> allRows = table.findElements(By.tagName(ROWS_LOCATOR));

        j = getSortDescColumn(allRows, 8);

        String temp = allRows.get(1).findElements(By.xpath(CELLS_LOCATOR)).get(j).getText();

        for (int i = 2; i < allRows.size(); i++) {
            int order = temp.toLowerCase().compareTo(allRows.get(i).findElements(By.xpath(CELLS_LOCATOR)).get(j).getText().toLowerCase());
            Assert.assertTrue(order >= 0);
            temp = allRows.get(i).findElements(By.xpath(CELLS_LOCATOR)).get(j).getText();
        }
    }

    private void checkData(String temp, List<WebElement> allRows, int k, int j) {
        for (int i = k; i < allRows.size(); i++) {
            if (temp.toLowerCase().contains(allRows.get(i).findElements(By.xpath(CELLS_LOCATOR)).get(j).getText().toLowerCase())) {
                Assert.assertTrue(true);
                temp = allRows.get(i).findElements(By.xpath(CELLS_LOCATOR)).get(j).getText();
            } else {
                int order = temp.toLowerCase().compareTo(allRows.get(i).findElements(By.xpath(CELLS_LOCATOR)).get(j).getText().toLowerCase());
                Assert.assertTrue(order <= 0);
                temp = allRows.get(i).findElements(By.xpath(CELLS_LOCATOR)).get(j).getText();
            }
        }
    }

    private String chooseLocator(String column) {
        switch (column) {
            case "Modified By":
                return "#example > thead > tr > th.sorting_desc";
            case "Lab":
                return "#example > thead > tr > th:nth-child(2)";
            case "Lab Client":
                return "#example > thead > tr > th:nth-child(3)";
            case "Date/Time":
                return "#example > thead > tr > th:nth-child(4)";
            case "Table Name":
                return "#example > thead > tr > th:nth-child(5)";
            case "Column Name":
                return "#example > thead > tr > th:nth-child(6)";
            case "Old Value":
                return "#example > thead > tr > th:nth-child(7)";
            case "New Value":
                return "#example > thead > tr > th:nth-child(8)";
            case "Event Type":
                return "#example > thead > tr > th:nth-child(9)";
        }
        return null;
    }

    private int getSortColumn(List<WebElement> rows, int size) {
        for (int i = 0; i < size; i++) {
            if (rows.get(0).findElements(By.xpath(CELLS_LOCATOR)).get(i)
                    .getAttribute(SORT_ATTRIBUTE_LOCATOR) != null &&
                    rows.get(0).findElements(By.xpath(CELLS_LOCATOR)).get(i)
                            .getAttribute(SORT_ATTRIBUTE_LOCATOR).equals(SORT_ATTRIBUTE_VALUE)) {
                return i;
            }
        }
        return 0;
    }

    private int getSortDescColumn(List<WebElement> rows, int size) {
        for (int i = 0; i < size; i++) {
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
      Scenario Outline: Verify the page navigation in Audit Log
     */

    @When("^Navigate back and forth by selecting (.*) in Audit Log$")
    public void navigate(String button) {
        if (button.equals("Prev") || button.equals("1")) {
            MyWebDriverUtils.waitContainerThenClick(driver, "#example_paginate > ul > li:nth-child(3) > a", LocatorType.CSS);
        }

        String locator = chooseButtonLocator(button);
        if (locator != null) {
            MyWebDriverUtils.waitContainerThenClick(driver, locator, LocatorType.CSS);
        }

        navigateButton = button;
    }

    @Then("^user should be navigate to the selected page$")
    public void check_navigate_page() {
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

    @Then("^a text message 'Showing x to y of z entries' should be displayed on the bottom left corner of the list$")
    public void check_message() {
        WebElement el = MyWebDriverUtils.findElement(driver, MESSAGE_LOCATOR, LocatorType.CSS);
        if (el != null) {
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

    /*
    Scenario: Verify User Log
     */

    @When("^Select Settings -> User Log$")
    public void select_settings_user_log() {
        MyWebDriverUtils.waitContainerThenClick(driver, SETTINGS_LOCATOR, LocatorType.CSS);
        MyWebDriverUtils.waitContainerThenClick(driver, USER_LOG_LOCATOR, LocatorType.CSS);
    }

    @Then("^User Log Screen should be displayed$")
    public void user_log_screen_should_be_displayed() {
        MyWebDriverUtils.checkWidgetCaption(driver, WIDGET_CASE_LIST_LOCATOR, LocatorType.CSS, WIDGET_USER_LOG_VALUE);
        MyWebDriverUtils.checkCurrentUrl(driver, USER_LOG_PAGE_URL);
    }

    @When("^Verify the columns displayed in the User log$")
    public void verify_the_columns_displayed_in_the_user_log() {
        columns = MyWebDriverUtils.getTh(driver, TABLE_LOCATOR, LocatorType.ID, 6);
    }

    @Then("^Following columns should be displayed in User Log: User Name, Lab, Lab Client, Visited URL, Date/Time, Case Acc#$")
    public void check_following_columns() {
        if (columns != null && columns.size() == 6) {
            for (int i = 0; i < columns.size(); i++) {
                Assert.assertEquals(columns.get(i).getText(), userLogColumns[i]);
            }
        } else {
            Assert.fail("columns is null!");
        }
    }

    @When("^Verify the values under 'User Name' column$")
    public void verify_the_values_under_user_name_column() {
        MyWebDriverUtils.selectOption(driver, DROP_DOWN_LOC, LocatorType.NAME, ALL);

        allCells = MyWebDriverUtils.getAllCells(driver, TABLE_LOCATOR, LocatorType.ID, 6);
    }

    @Then("^Only either of the following values should be displayed under" +
            " 'User Name' column: 'SNlabadmin', 'SPhyOne', 'SPhyTwo', 'labuserone'." +
            " No other values other than above four should be displayed under 'User Name' column$")
    public void check_user_name_column() {
        if (allCells != null) {
            for (int i = 1; i < allCells.size(); i++) {
                Assert.assertTrue(allCells.get(i).get(0).getText().equals("SNlabadmin") ||
                        allCells.get(i).get(0).getText().equals("SPhyOne") ||
                        allCells.get(i).get(0).getText().equals("SPhyTwo") ||
                        allCells.get(i).get(0).getText().equals("labuserone"));
            }
        } else {
            Assert.fail("allCells is null!");
        }
    }

    @When("^Verify the values under 'Lab' column in User Log$")
    public void verify_the_values_under_lab_column_in_user_log() {
        allCells = MyWebDriverUtils.getAllCells(driver, TABLE_LOCATOR, LocatorType.ID, 6);
    }

    @When("^Verify the values under 'Lab Client' column in User Log$")
    public void verify_the_values_under_lab_client_column_in_user_log() {
        allCells = MyWebDriverUtils.getAllCells(driver, TABLE_LOCATOR, LocatorType.ID, 6);
    }

    @When("^Verify the values under 'Date/Time' column in User Log$")
    public void verify_the_values_under_date_time_column_in_user_log() {
        allCells = MyWebDriverUtils.getAllCells(driver, TABLE_LOCATOR, LocatorType.ID, 6);
    }

    @Then("^Date and Time of the individual events in the formats 'DD/MMM/YYYY' and 'HH:MM:SS' respectively should be displayed in User Log$")
    public void check_date_and_time() {
        if (allCells != null) {
            for (int i = 1; i < allCells.size(); i++) {
                Assert.assertTrue(allCells.get(i).get(4).getText().matches(REGEX));
            }
        } else {
            Assert.fail("allCells is null!");
        }
    }

    @When("^Verify the values under Case Acc# column$")
    public void verify_the_values_under_case_acc_column() {
        allCells = MyWebDriverUtils.getAllCells(driver, TABLE_LOCATOR, LocatorType.ID, 6);
    }

    @Then("^Case Account #s, if any, should be displayed$")
    public void check_case_acc_column() {
        if (allCells != null) {
            for (int i = 1; i < allCells.size(); i++) {
                Assert.assertTrue(allCells.get(i).get(5).getText().equals("#s") || allCells.get(i).get(5).getText().equals(""));
            }
        } else {
            Assert.fail("allCells is null!");
        }
    }

    /*
    Scenario: Verify User Log Filters
     */

    @When("^Select a value from 'Lab Client' drop down and click Search.$")
    public void select_lab_client_drop_down_and_click_search() {
        clear_user_log_filter();
        MyWebDriverUtils.selectOption(driver, LAB_CLIENT_DROP_DOWN_LOCATOR, LocatorType.ID, "SLabClientOne");

        driver.findElement(By.id(SEARCH_BUTTON_LOCATOR)).sendKeys(Keys.ENTER);
    }

    @Then("^Results corresponding to selected Lab Client should be displayed.$")
    public void check_results_to_selected_lab_client() {
        while (true) {
            try {
                allCells = MyWebDriverUtils.getAllCells(driver, TABLE_LOCATOR, LocatorType.ID, 1);
                if (allCells != null) {
                    for (List<WebElement> list : allCells) {
                        Assert.assertTrue(list.get(0).getText().equals("No data available in table"));
                    }
                } else {
                    Assert.fail("allCells is null!");
                }
                break;
            } catch (StaleElementReferenceException ex) {
                System.out.println("element is not attached to the page document");
            }
        }
    }

    @When("^Select a value from 'User' drop down and click Search.$")
    public void select_user_drop_down_and_click_search() {
        clear_user_log_filter();
        MyWebDriverUtils.selectOption(driver, USER_DROP_DOWN_LOCATOR, LocatorType.ID, "SNlabadmin");

        driver.findElement(By.id(SEARCH_BUTTON_LOCATOR)).sendKeys(Keys.ENTER);
    }

    @Then("^Results corresponding to selected User should be displayed.$")
    public void check_results_to_selected_user() {
        while (true) {
            try {
                allCells = MyWebDriverUtils.getAllCells(driver, TABLE_LOCATOR, LocatorType.ID, 6);
                if (allCells != null) {
                    for (List<WebElement> list : allCells) {
                        Assert.assertTrue(list.get(0).getText().equals("SNlabadmin"));
                    }
                } else {
                    Assert.fail("allCells is null!");
                }
                break;
            } catch (StaleElementReferenceException ex) {
                System.out.println("element is not attached to the page document");
            }
        }
    }

    @When("^Select From and To Dates in the Date Range and click Search.$")
    public void select_from_and_to_dates__and_click_search() {
        clear_user_log_filter();

        MyWebDriverUtils.enterData(driver, DATE_FROM_LOCATOR, LocatorType.ID,
                Date.FROM_MONTH + "/" + Date.FROM_DAY + "/" + Date.FROM_YEAR);
        MyWebDriverUtils.enterData(driver, DATE_TO_LOCATOR, LocatorType.ID,
                Date.TO_MONTH + "/" + Date.TO_DAY + "/" + Date.TO_YEAR);

        driver.findElement(By.id(SEARCH_BUTTON_LOCATOR)).sendKeys(Keys.ENTER);
    }

    @Then("^Only records between the selected date range should be displayed.$")
    public void check_the_selected_date_range() {
        while (true) {
            try {
                allCells = MyWebDriverUtils.getAllCells(driver, TABLE_LOCATOR, LocatorType.ID, 6);
                if (allCells != null) {

                    for (List<WebElement> list : allCells) {
                        String date = list.get(3).getText();
                        int[] parseDate = MyWebDriverUtils.parseDate(date);
                        checkDate(parseDate, date);
                    }
                } else {
                    Assert.fail("allCells is null!");
                }
                break;
            } catch (StaleElementReferenceException ex) {
                System.out.println("element is not attached to the page document");
            }
        }
    }

    @When("^Select values from two or more filters and click Search.$")
    public void select_two_or_more_filters_and_click_search() {
        clear_user_log_filter();
        MyWebDriverUtils.selectOption(driver, USER_DROP_DOWN_LOCATOR, LocatorType.ID, "SNlabadmin");

        MyWebDriverUtils.enterData(driver, DATE_FROM_LOCATOR, LocatorType.ID,
                Date.FROM_MONTH + "/" + Date.FROM_DAY + "/" + Date.FROM_YEAR);
        MyWebDriverUtils.enterData(driver, DATE_TO_LOCATOR, LocatorType.ID,
                Date.TO_MONTH + "/" + Date.TO_DAY + "/" + Date.TO_YEAR);

        driver.findElement(By.id(SEARCH_BUTTON_LOCATOR)).sendKeys(Keys.ENTER);
    }

    @Then("^Records as per the entered search criteria should be displayed.$")
    public void check_records_for_the_criteria() {
        while (true) {
            try {
                allCells = MyWebDriverUtils.getAllCells(driver, TABLE_LOCATOR, LocatorType.ID, 6);
                if (allCells != null) {

                    for (List<WebElement> list : allCells) {
                        Assert.assertTrue(list.get(0).getText().equals("SNlabadmin"));
                        String date = list.get(4).getText();
                        int[] parseDate = MyWebDriverUtils.parseDate(date);
                        checkDate(parseDate, date);
                    }
                } else {
                    Assert.fail("allCells is null!");
                }
                break;
            } catch (StaleElementReferenceException ex) {
                System.out.println("element is not attached to the page document");
            }
        }
    }

    private void clear_user_log_filter() {
        MyWebDriverUtils.selectOption(driver, LAB_CLIENT_DROP_DOWN_LOCATOR, LocatorType.ID, "Select Lab Client");
        MyWebDriverUtils.selectOption(driver, USER_DROP_DOWN_LOCATOR, LocatorType.ID, "Select User");
        MyWebDriverUtils.enterData(driver, DATE_FROM_LOCATOR, LocatorType.ID, "");
        MyWebDriverUtils.enterData(driver, DATE_TO_LOCATOR, LocatorType.ID, "");
    }

    private void checkDate(int[] parseDate, String date) {
        if (parseDate[0] > Date.FROM_YEAR && parseDate[0] < Date.TO_YEAR) {
            Assert.assertTrue(true);
        }
        if (parseDate[0] == Date.FROM_YEAR) {
            if (parseDate[1] > Date.FROM_MONTH) {
                Assert.assertTrue(true);
            } else if (parseDate[1] == Date.FROM_MONTH) {
                if (parseDate[2] >= Date.FROM_DAY) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(date + " this date should not be displayed!");
                }
            }
        }
        if (parseDate[0] == Date.TO_YEAR) {
            if (parseDate[1] < Date.TO_MONTH) {
                Assert.assertTrue(true);
            } else if (parseDate[1] == Date.TO_MONTH) {
                if (parseDate[2] <= Date.TO_DAY) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(date + " this date should not be displayed!");
                }
            }
        }

        if (parseDate[0] < Date.FROM_YEAR && parseDate[0] > Date.TO_YEAR) {
            Assert.fail(date + " this date should not be displayed!");
        }
    }

    /*
    Scenario Outline: Verify data Sorting in User Log
     */

    @When("^In User log click on down arrow icon  on (.*)$")
    public void in_user_log_click_on_down_arrow_icon(String column) {
        if (column.equals("User Name")) {
            MyWebDriverUtils.waitContainerThenClick(driver, SORT_ASCENDING_LOCATOR, LocatorType.CSS);
        }
        String locator = getLocator(column);

        if (column.equals("Case Acc#") && locator != null) {
            driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
        } else {
            MyWebDriverUtils.waitContainerThenClick(driver, locator, LocatorType.CSS);
        }
    }

    @Then("^Records should be displayed based on the ascending order of the selected column.$")
    public void check_ascending_order_of_the_selected_column() {
        while (true) {
            try {
                WebElement table = driver.findElement(By.id(TABLE_LOCATOR));
                List<WebElement> allRows = table.findElements(By.tagName(ROWS_LOCATOR));

                int j;
                j = getSortColumn(allRows, 6);
                String temp = allRows.get(1).findElements(By.xpath(CELLS_LOCATOR)).get(j).getText();

                checkData(temp, allRows, 2, j);
                break;
            } catch (StaleElementReferenceException ex) {
                System.out.println("element is not attached to the page document");
            }
        }
    }

    @When("^In User Log click on up arrow icon  on (.*)$")
    public void in_user_log_click_on_up_arrow_icon(String column) {
        if (column.equals("Case Acc#")) {
            driver.findElement(By.cssSelector(SORT_ASCENDING_LOCATOR)).sendKeys(Keys.ENTER);
        } else {
            MyWebDriverUtils.waitContainerThenClick(driver, SORT_ASCENDING_LOCATOR, LocatorType.CSS);
        }
    }

    @Then("^Records should be displayed based on the descending order of the selected column.$")
    public void check_descending_order_of_the_selected_column() {
        int j;

        WebElement table = driver.findElement(By.id(TABLE_LOCATOR));

        List<WebElement> allRows = table.findElements(By.tagName(ROWS_LOCATOR));

        j = getSortDescColumn(allRows, 6);

        String temp = allRows.get(1).findElements(By.xpath(CELLS_LOCATOR)).get(j).getText();

        for (int i = 2; i < allRows.size(); i++) {
            int order = temp.toLowerCase().compareTo(allRows.get(i).findElements(By.xpath(CELLS_LOCATOR)).get(j).getText().toLowerCase());
            Assert.assertTrue(order >= 0);
            temp = allRows.get(i).findElements(By.xpath(CELLS_LOCATOR)).get(j).getText();
        }
    }

    private String getLocator(String column) {
        switch (column) {
            case "User Name":
                return "#example > thead > tr > th.sorting_desc";
            case "Lab":
                return "#example > thead > tr > th:nth-child(2)";
            case "Lab Client":
                return "#example > thead > tr > th:nth-child(3)";
            case "Date/Time":
                return "#example > thead > tr > th:nth-child(5)";
            case "Visited URL":
                return "#example > thead > tr > th:nth-child(4)";
            case "Case Acc#":
                return "#example > thead > tr > th:nth-child(6)";
        }
        return null;
    }

    private static final class Lab {
        private Lab() {
        }

        private static String labName;
        private static String email;


        private static final String LAB_NAME_LOCATOR = "lab_name";
        private static final String DESCRIPTION_LOCATOR = "lab_desc";
        private static final String EMAIL_LOCATOR = "lab_email";
        private static final String ADDRESS_1_LOCATOR = "address1";
        private static final String ADDRESS_2_LOCATOR = "address2";
        private static final String ZIP_CODE_LOCATOR = "zip";
        private static final String COUNTRY_LOCATOR = "country";
        private static final String PLAN_LOCATOR = "plan";

        private static final String LAB_NAME = "Sujana Lab";
        private static final String DESCRIPTION = "description of the lab";
        private static final String EMAIL = "lab@gmail.com";
        private static final String ADDRESS_1 = "address1";
        private static final String ADDRESS_2 = "address2";
        private static final String ZIP_CODE = "12345";
        private static final String CITY = "Schenectady";
        private static final String STATE = "New York";
        private static final String COUNTRY = "USA";
        private static final String PLAN = "plan1 1222.0";
    }

    private static final class User {
        private User() {
        }

        private static String userName;

        private static final String USER_NAME_LOCATOR = "username";
        private static final String PASSWORD_LOCATOR = "password";
        private static final String FIRST_NAME_LOCATOR = "firstName";
        private static final String LAST_NAME_LOCATOR = "lastName";
        private static final String EMAIL_LOCATOR = "email";
        private static final String PHONE_NUMBER_LOCATOR = "contact";
        private static final String ROLE_LOCATOR = "roles";

        private static final String USER_NAME = "Snlabadmin";
        private static final String PASSWORD = "Test@123";
        private static final String FIRST_NAME = "Alexander";
        private static final String LAST_NAME = "Bainaiev";
        private static final String EMAIL = "master@gmail.com";
        private static final String PHONE_NUMBER = "4444444444";
        private static final String ROLE = "LAB_ADMIN";
        private static final String PHONE_NUMBER_VIEW = "(444) 444-4444";
    }

    private static final class LabUser {
        private LabUser() {
        }

        private static String userName;

        private static final String ROLE = "LAB_TECHNICIAN";
        private static final String USER_NAME = "labuserone";
        private static final String PASSWORD = "Test@123";

        private static final String FIRST_NAME_LOCATOR = "#form > div:nth-child(6) > div:nth-child(1) > div > span > input";
        private static final String LAST_NAME_LOCATOR = "#form > div:nth-child(6) > div:nth-child(2) > div > span > input";
    }

    private static final class LabClient {
        private LabClient() {
        }

        private static final String BUSINESS_NAME_LOCATOR = "business_name";
        private static final String ADDRESS_1_LOCATOR = "address_1";
        private static final String ADDRESS_2_LOCATOR = "address_2";
        private static final String ZIP_CODE_LOCATOR = "zip";
        private static final String CONTACT_PERSON_LOCATOR = "contact_person";
        private static final String CONTACT_NUMBER_LOCATOR = "contact_number";
        private static final String FAX_NUMBER_LOCATOR = "faxNumber";
        private static final String CONTACT_EMAIL_LOCATOR = "contact_email";


        private static final String ADDRESS_1 = "address1";
        private static final String ADDRESS_2 = "address2";
        private static final String ZIP_CODE = "33617";
        private static final String CITY = "Tampa";
        private static final String STATE = "Florida";
        private static final String CONTACT_PERSON = "Henry";
        private static final String CONTACT_NUMBER = "7871237870";
        private static final String FAX_NUMBER = "1111111111";
        private static final String CONTACT_EMAIL = "master@gmail.com";
        private static final String VIEW_CONTACT_NUMBER = "(787) 123-7870";
    }

    private static final class Physician {
        private Physician() {
        }

        private static String userName;

        private static final String PASSWORD = "Test@123";
        private static final String FIRST_NAME = "Alexander";
        private static final String MIDDLE_NAME = "Khasanovich";
        private static final String LAST_NAME = "Bainaiev";
        private static final String MEDICAL_DEGREE = "Master";
        private static final String PHONE_NUMBER = "1111111111";
        private static final String EMAIL_ADDRESS = "master@gmail.com";
        private static final String SALUTATION = "Mr";
        private static final String MEDICARE_NUMBER = "123";
        private static final String MEDICAID_NUMBER = "456";
        private static final String UPIN_NUMBER = "789";
        private static final String STATE_LICENCE = "licence";
        private static final String NPI = "npi";
        private static final String COMPOUND_PROFILE = "TestProfile1";
        private static final String LAB_CLIENT = "SLabClientOne";
        private static final String LOCATION = "Dublin";


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

    private static final class Date {
        private Date() {
        }

        private static final int FROM_YEAR = 2016;
        private static final int FROM_MONTH = 1;
        private static final int FROM_DAY = 15;

        private static final int TO_YEAR = 2016;
        private static final int TO_MONTH = 12;
        private static final int TO_DAY = 25;
    }
}
