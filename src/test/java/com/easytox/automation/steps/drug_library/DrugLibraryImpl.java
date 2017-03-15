package com.easytox.automation.steps.drug_library;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.LocatorType;
import com.easytox.automation.utils.MyWebDriverUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 30.12.2016.
 */
public class DrugLibraryImpl {
    private static final String USER_NAME = "SNLabAdmin";
    private static final String PASSWORD = "Test@123";
    private static final String LOGIN_PAGE_URL = "http://bmtechsol.com:8080/easytox/";
    private static final String FIND_USERNAME = "j_username";
    private static final String FIND_PASSWORD = "j_password";
    private static final String LOGIN_BUTTON_XPATH = "//*[@id=\"loginform\"]/div[3]/div/button";
    private static final String CASE_LIST_URL = "http://bmtechsol.com:8080/easytox/caseOrder/list";
    private static final String WIDGET_CASE_LIST_LOCATOR = "#maincontentdiv > div.page-body > div > div > div > div.widget-header > span";
    private static final String WIDGET_CASE_LIST_VALUE = "Case List";
    private static final String LIBRARY_ICON_LOCATOR = "body > div.navbar > div > div > div.navbar-header.pull-right > div > ul > li:nth-child(9) > a";
    private static final String COMPOUND_LIBRARY_ICON_LOCATOR = "body > div.navbar > div > div > div.navbar-header.pull-right > div > ul > li.open > #topmenu > li:nth-child(2) > a";
    private static final String COMPOUND_PAGE_URL = "http://bmtechsol.com:8080/easytox/compound/list";
    private static final String WIDGET_COMPOUND_VALUE = "Compound";
    private static final String ADD_COMPOUND_ICON = "add";
    private static final String WIDGET_ADD_COMPOUND_LOCATOR = "exampleModalLabel";
    private static final String WIDGET_ADD_COMPOUND_VALUE = "Add Compound";
    private static final String SUBMIT_LOCATOR = "#form > div.modal-footer > button.btn.btn-primary.btn-md";
    private static final String ALERT_SUCCESS_LOCATOR = "#maincontentdiv > div.page-body > div.alert.alert-success.fade.in";
    private static final String TABLE_LOCATOR = "example";
    private static final String COMPOUND_WARNING_LOCATOR = "#form > div.modal-body > div.form-group.has-error > div > small:nth-child(3)";
    private static final String DATA_BV_RESULT_ATTRIBUTE_VALUE = "INVALID";
    private static final String DATA_BV_RESULT_ATTRIBUTE = "data-bv-result";
    private static final String ERROR_MESSAGE = "Compound already exists";
    private static final String DRUG_LIBRARY_ICON_LOCATOR = "body > div.navbar > div > div > div.navbar-header.pull-right > div > ul > li.open > #topmenu > li:nth-child(3) > a";
    private static final String DRUG_PAGE_URL = "http://bmtechsol.com:8080/easytox/drug/list";
    private static final String WIDGET_DRUG_LIBRARY_VALUE = "Drug";
    private static final String WIDGET_ADD_DRUG_VALUE = "Add Drug";
    private static final String DRUG_ERROR_MESSAGE = "Drug already exists";
    private static final String COMPOUND_TEST_GROUP_ICON_LOCATOR = "body > div.navbar > div > div > div.navbar-header.pull-right > div > ul > li.open > #topmenu > li:nth-child(4) > a";
    private static final String TEST_CODE_PAGE_URL = "http://bmtechsol.com:8080/easytox/testCode/list";
    private static final String WIDGET_TEST_CODE_VALUE = "TestCode";
    private static final String WIDGET_ADD_TEST_CODE = "Add Test Code";
    private static final String TEST_CODE_ERROR_MESSAGE = "Test Code already exists";
    private static final String VALIDITY_TEST_GROUP_ICON_LOCATOR = "body > div.navbar > div > div > div.navbar-header.pull-right > div > ul > li.open > #topmenu > li:nth-child(5) > a";
    private static final String VALIDITY_TEST_CODE_PAGE_URL = "http://bmtechsol.com:8080/easytox/testCode/validitylist";
    private static final String WIDGET_VALIDITY_TEST_CODE_VALUE = "Validity TestCode";
    private static final String WIDGET_ADD_VALIDITY_TEST_CODE = "Add Validity Test Code";
    private static final String TESTING_PROFILE_ICON_LOCATOR = "body > div.navbar > div > div > div.navbar-header.pull-right > div > ul > li.open > #topmenu > li:nth-child(6) > a";
    private static final String WIDGET_TESTING_PROFILE_VALUE = "Profile";
    private static final String TESTING_PROFILE_PAGE_URL = "http://bmtechsol.com:8080/easytox/profile/list";
    private static final String WIDGET_ADD_TESTING_PROFILE = "Add Profile";
    private static final String DROP_DOWN_MENU_LOCATOR = "#form > div.modal-body > div:nth-child(2) > div > div > ul";
    private static final String VALIDITY_DROP_DOWN = "#form > div.modal-body > div:nth-child(3) > div > div > ul";
    private static final String TEST_SCREEN_BUTTON_LOCATOR = "#form > div.modal-body > div:nth-child(2) > div > div > button";
    private static final String VALIDITY_TEST_GROUP_LOCATOR = "#form > div.modal-body > div:nth-child(3) > div > div > button";
    private static final String LI = "li";
    private static final String LABEL = "label";
    private static final String PROFILE_TESTING_MESSAGE_ERROR = "Profile already exists";


    private static List<String> compounds;
    private static List<String> testGroup;
    private static List<String> validityTestGroup;


    private WebDriver driver;

    public DrugLibraryImpl() {
        DriverBase.instantiateDriverObject();
        driver = DriverBase.getDriver();
    }

    /*
    Scenario Outline: Create a Compound
     */

    @When("^Login with SNLabAdmin/Test@123 credentials$")
    public void login() {
        MyWebDriverUtils.authorization(driver, LOGIN_PAGE_URL,
                FIND_USERNAME, LocatorType.NAME, USER_NAME,
                FIND_PASSWORD, LocatorType.NAME, PASSWORD,
                LOGIN_BUTTON_XPATH, LocatorType.XPATH);
    }

    @Then("^User login should be successful$")
    public void check_login() {
        MyWebDriverUtils.checkWidgetCaption(driver, WIDGET_CASE_LIST_LOCATOR, LocatorType.CSS, WIDGET_CASE_LIST_VALUE);
        MyWebDriverUtils.checkCurrentUrl(driver, CASE_LIST_URL);
    }

    @When("^Go to Libraries -> Compound Library$")
    public void go_to_compound_library() {
        MyWebDriverUtils.waitContainerThenClick(driver, LIBRARY_ICON_LOCATOR, LocatorType.CSS);
        MyWebDriverUtils.waitContainerThenClick(driver, COMPOUND_LIBRARY_ICON_LOCATOR, LocatorType.CSS);
    }

    @Then("^Compound page should be open$")
    public void compound_page_should_be_open() {
        MyWebDriverUtils.checkWidgetCaption(driver, WIDGET_CASE_LIST_LOCATOR, LocatorType.CSS, WIDGET_COMPOUND_VALUE);
        MyWebDriverUtils.checkCurrentUrl(driver, COMPOUND_PAGE_URL);
    }

    @When("^Click 'Create Compound' icon$")
    public void click_create_compound_icon() {
        MyWebDriverUtils.waitContainerThenClick(driver, ADD_COMPOUND_ICON, LocatorType.ID);
    }

    @Then("^Add Compound screen should be displayed$")
    public void add_compound_screen_should_be_displayed() {
        MyWebDriverUtils.checkPageCaption(driver, WIDGET_ADD_COMPOUND_LOCATOR, LocatorType.ID, WIDGET_ADD_COMPOUND_VALUE);
    }

    @When("^Enter 'Name' as (\\w+\\d), 'Type' as (\\w+\\s\\w+) and enter all the other data and click Submit.$")
    public void enter_all_data_and_click_submit(String compoundName, String type) {
        try {
            MyWebDriverUtils.enterData(driver, Compound.CLASS_LOCATOR, LocatorType.ID, Compound.CLASS);
            MyWebDriverUtils.selectOption(driver, Compound.TYPE_LOCATOR, LocatorType.ID, type);
            MyWebDriverUtils.selectOption(driver, Compound.RESULT_LOCATOR, LocatorType.ID, Compound.RESULT);
            MyWebDriverUtils.enterData(driver, Compound.BILLING_CODE_LOCATOR, LocatorType.ID, Compound.BILLING_CODE);
            MyWebDriverUtils.enterData(driver, Compound.ORAL_DETECTION_LOCATOR, LocatorType.ID, Compound.ORAL_DETECTION);
            MyWebDriverUtils.enterData(driver, Compound.URINE_DETECTION_LOCATOR, LocatorType.ID, Compound.URINE_DETECTION);
            MyWebDriverUtils.enterData(driver, Compound.NEGATIVE_COMMENTS_LOCATOR, LocatorType.ID, Compound.NEGATIVE_COMMENTS);
            MyWebDriverUtils.enterData(driver, Compound.POSITIVE_COMMENTS_LOCATOR, LocatorType.ID, Compound.POSITIVE_COMMENTS);

            if (compoundName.equals("Compound1") || compoundName.equals("Compound2")) {
                MyWebDriverUtils.enterData(driver, Compound.CUT_OFF_LOCATOR, LocatorType.ID, Compound.CUT_OFF);
            } else {
                MyWebDriverUtils.selectOption(driver, Compound.RANGE_LOCATOR, LocatorType.ID, Compound.RANGE);
                MyWebDriverUtils.enterData(driver, Compound.CUT_OFF_RANGE_LOCATOR, LocatorType.ID, Compound.CUT_OFF_RANGE);
                MyWebDriverUtils.selectOption(driver, Compound.UNITS_LOCATOR, LocatorType.NAME, Compound.UNITS);
            }

            MyWebDriverUtils.enterData(driver, Compound.NAME_LOCATOR, LocatorType.ID, compoundName);

            MyWebDriverUtils.waitContainerThenClick(driver, SUBMIT_LOCATOR, LocatorType.CSS);
            MyWebDriverUtils.waitContainerThenClick(driver, SUBMIT_LOCATOR, LocatorType.CSS);
        } catch (TimeoutException ex) {
            System.out.println("Submit button is disabled");
        }
    }

    @Then("^A new Compound with (\\w+\\d) and (\\w+\\s\\w+) should be created successfully$")
    public void check_new_compound(String compoundName, String type) {
        if (checkErrorMessage(ERROR_MESSAGE, compoundName)) {
            return;
        }

        MyWebDriverUtils.checkWidgetCaption(driver, ALERT_SUCCESS_LOCATOR, LocatorType.CSS, "Compound " + compoundName + " created");
        MyWebDriverUtils.checkCurrentUrl(driver, COMPOUND_PAGE_URL);

        List<WebElement> cells = MyWebDriverUtils.getCells(driver, TABLE_LOCATOR, LocatorType.ID, 1, 12);
        if (cells != null && cells.size() == 12) {
            if (compoundName.equals("Compound1") || compoundName.equals("Compound2")) {
                Assert.assertEquals(cells.get(4).getText(), "");
                Assert.assertEquals(cells.get(5).getText(), Compound.CUT_OFF);
            } else {
                Assert.assertEquals(cells.get(4).getText(), Compound.RANGE + " " + Compound.CUT_OFF_RANGE);
                Assert.assertEquals(cells.get(5).getText(), "");
            }

            String[] compType = type.split(" ");
            Assert.assertEquals(cells.get(0).getText(), Compound.CLASS);
            Assert.assertEquals(cells.get(1).getText(), compType[0] + compType[1]);
            Assert.assertEquals(cells.get(2).getText(), compoundName);
            Assert.assertEquals(cells.get(3).getText(), Compound.RESULT);
            Assert.assertEquals(cells.get(6).getText(), Compound.POSITIVE_COMMENTS);
            Assert.assertEquals(cells.get(7).getText(), Compound.NEGATIVE_COMMENTS);
            Assert.assertEquals(cells.get(8).getText(), Compound.BILLING_CODE);
            Assert.assertEquals(cells.get(9).getText(), Compound.ORAL_DETECTION);
            Assert.assertEquals(cells.get(10).getText(), Compound.URINE_DETECTION);
        } else {
            Assert.fail("cells is null");
        }

    }

    private boolean checkErrorMessage(String message, String name) {
        try {
            WebElement errorElement = MyWebDriverUtils.findElement(driver, COMPOUND_WARNING_LOCATOR, LocatorType.CSS, 2);
            if (errorElement != null) {
                Assert.assertEquals(errorElement.getAttribute(DATA_BV_RESULT_ATTRIBUTE), DATA_BV_RESULT_ATTRIBUTE_VALUE);
                Assert.assertEquals(errorElement.getText(), message);
                Assert.fail(name + " already exists!");
                return true;
            }
        } catch (TimeoutException ex) {
            System.out.println("errorElement is not visible, compound added!");
        }
        return false;
    }

    /*
    Scenario: While creating a Drug, verify that the Compounds List doesn't contain Validity Testing Compounds
     */

    @When("^Go to Libraries -> Drug Library$")
    public void go_to_drug_library() {
        MyWebDriverUtils.waitContainerThenClick(driver, LIBRARY_ICON_LOCATOR, LocatorType.CSS);
        MyWebDriverUtils.waitContainerThenClick(driver, DRUG_LIBRARY_ICON_LOCATOR, LocatorType.CSS);
    }

    @Then("^Drug page should be open$")
    public void check_drug_page() {
        MyWebDriverUtils.checkWidgetCaption(driver, WIDGET_CASE_LIST_LOCATOR, LocatorType.CSS, WIDGET_DRUG_LIBRARY_VALUE);
        MyWebDriverUtils.checkCurrentUrl(driver, DRUG_PAGE_URL);
    }

    @When("^Click 'Add Drug' icon.$")
    public void click_add_drug_icon() {
        MyWebDriverUtils.waitContainerThenClick(driver, ADD_COMPOUND_ICON, LocatorType.ID);
    }

    @Then("^Add Drug screen should be displayed.$")
    public void check_add_drug_screen() {
        MyWebDriverUtils.checkPageCaption(driver, WIDGET_ADD_COMPOUND_LOCATOR, LocatorType.ID, WIDGET_ADD_DRUG_VALUE);
    }

    @When("^Verify the values displayed in 'Compounds' drop down.$")
    public void verify_the_values_displayed_in_compound_drop_down() {
        List<WebElement> compoundsOptions = MyWebDriverUtils.getOptions(driver, Drug.COMPOUNDS_LOCATOR, LocatorType.ID);
        if (compounds == null) {
            compounds = new ArrayList<>();
        }
        if (compoundsOptions != null) {
            for (WebElement option : compoundsOptions) {
                compounds.add(option.getText());
            }
        }
    }

    @Then("^Following values should be displayed in 'Compounds' dropdown: (\\w{8}\\d), (\\w{8}\\d)$")
    public void check_values_in_compound_drop_down(String comp1, String comp2) {
        if (compounds != null) {
            Assert.assertTrue(compounds.contains(comp1) && compounds.contains(comp2));
        }
    }

    @When("^Verify the values NOT displayed in 'Compounds' drop down.$")
    public void verify_the_values_not_displayed_in_compounds_drop_down() {

    }

    @Then("^Following values should NOT be displayed in 'Compounds' dropdown: (\\w{9}\\d), (\\w{9}\\d)$")
    public void check_values_not_in_compound_drop_down(String vComp1, String vComp2) {
        if (compounds != null) {
            Assert.assertFalse(compounds.contains(vComp1));
            Assert.assertFalse(compounds.contains(vComp2));
            compounds.clear();
        }

    }

    /*
    Scenario: Create a Drug
     */

    @When("^Enter 'Name' as '(\\w{7}\\d)', Select '(\\w{8}\\d)' from the drop down and enter all the other data and click Submit.$")
    public void enter_name_and_all_other_data(String name, String compound) {
        Drug.compoundValue = compound;
        MyWebDriverUtils.enterData(driver, Drug.DRUG_NAME_LOCATOR, LocatorType.NAME, name);
        MyWebDriverUtils.selectOption(driver, Drug.ACCESS_PREFIX_LOCATOR, LocatorType.NAME, Drug.ACCESS_PREFIX_VALUE);
        MyWebDriverUtils.selectOption(driver, Drug.COMPOUNDS_LOCATOR, LocatorType.ID, Drug.compoundValue);

        MyWebDriverUtils.waitContainerThenClick(driver, SUBMIT_LOCATOR, LocatorType.CSS);
    }

    @Then("^A new Drug '(\\w{7}\\d)' should be created successfully$")
    public void check_a_new_drug(String name) {
        if (checkErrorMessage(DRUG_ERROR_MESSAGE, name)) {
            return;
        }

        MyWebDriverUtils.checkWidgetCaption(driver, ALERT_SUCCESS_LOCATOR, LocatorType.CSS, "Drug " + name + " created");
        MyWebDriverUtils.checkCurrentUrl(driver, DRUG_PAGE_URL);

        List<WebElement> cells = MyWebDriverUtils.getCells(driver, TABLE_LOCATOR, LocatorType.ID, 1, 4);
        if (cells != null && cells.size() == 4) {
            Assert.assertEquals(cells.get(0).getText(), name);
            Assert.assertEquals(cells.get(1).getText(), Drug.ACCESS_PREFIX_VALUE);
            Assert.assertEquals(cells.get(2).getText(), Drug.compoundValue);
        } else {
            Assert.fail("cells is null");
        }

    }

    /*
    Scenario: Validating Compound Test Group
     */

    @When("^Go to Libraries -> Compound Test Group$")
    public void go_to_compound_test_group() {
        MyWebDriverUtils.waitContainerThenClick(driver, LIBRARY_ICON_LOCATOR, LocatorType.CSS);
        MyWebDriverUtils.waitContainerThenClick(driver, COMPOUND_TEST_GROUP_ICON_LOCATOR, LocatorType.CSS);
    }

    @Then("^Test Code page should be open$")
    public void check_test_code_page() {
        MyWebDriverUtils.checkWidgetCaption(driver, WIDGET_CASE_LIST_LOCATOR, LocatorType.CSS, WIDGET_TEST_CODE_VALUE);
        MyWebDriverUtils.checkCurrentUrl(driver, TEST_CODE_PAGE_URL);
    }

    @When("^Click 'Add Test Code' icon.$")
    public void click_add_test_code() {
        MyWebDriverUtils.waitContainerThenClick(driver, ADD_COMPOUND_ICON, LocatorType.ID);
    }

    @Then("^Add Test Code screen should be displayed.$")
    public void check_add_test_code_screen() {
        MyWebDriverUtils.checkPageCaption(driver, WIDGET_ADD_COMPOUND_LOCATOR, LocatorType.ID, WIDGET_ADD_TEST_CODE);
    }

    /*
    Scenario Outline: Create a Compound Test Group
     */

    @When("^Enter 'Test Code' as '(\\w{3}\\s\\w{11})', Select '(\\w{9})' and '(\\w{9})' from the Compounds drop down and enter all the other data and click Submit.$")
    public void enter_test_code_and_all_other_data_and_click_submit(String testCode, String comp1, String comp2) {
        TestCode.compValue1 = comp1;
        TestCode.compValue2 = comp2;
        MyWebDriverUtils.enterData(driver, TestCode.TEST_CODE_LOCATOR, LocatorType.ID, testCode);
        MyWebDriverUtils.enterData(driver, TestCode.DESCRIPTION_LOCATOR, LocatorType.ID, TestCode.DESCRIPTION);
        MyWebDriverUtils.selectOption(driver, TestCode.COMPOUNDS_LOCATOR, LocatorType.ID, TestCode.compValue1);
        MyWebDriverUtils.selectOption(driver, TestCode.COMPOUNDS_LOCATOR, LocatorType.ID, TestCode.compValue2);

        MyWebDriverUtils.waitContainerThenClick(driver, SUBMIT_LOCATOR, LocatorType.CSS);
    }

    @Then("^A new Compound '(\\w{3}\\s\\w{11})' should be created successfully.$")
    public void check_a_new_compound(String testCode) {
        check_compound(testCode, TEST_CODE_PAGE_URL);
    }

    private void check_compound(String testCode, String url) {
        if (checkErrorMessage(TEST_CODE_ERROR_MESSAGE, testCode)) {
            return;
        }

        MyWebDriverUtils.checkWidgetCaption(driver, ALERT_SUCCESS_LOCATOR, LocatorType.CSS, "TestCode " + testCode + " created");
        MyWebDriverUtils.checkCurrentUrl(driver, url);

        while (true) {
            try {
                List<WebElement> cells = MyWebDriverUtils.getCells(driver, TABLE_LOCATOR, LocatorType.ID, 1, 4);
                if (cells != null && cells.size() == 4) {
                    Assert.assertEquals(cells.get(0).getText(), testCode);
                    Assert.assertEquals(cells.get(1).getText(), TestCode.DESCRIPTION);
                    Assert.assertTrue(cells.get(2).getText().contains(TestCode.compValue1) &&
                            cells.get(2).getText().contains(TestCode.compValue2));

                    break;

                } else {
                    Assert.fail("cells is null");
                }
            } catch (StaleElementReferenceException ex) {
                System.out.println("element is not attached to the page document");
            }
        }
    }

    /*
    Scenario: Validating ValidityTest Group
     */

    @When("^Go to Libraries -> Validity Test Group$")
    public void go_to_validity_test_group() {
        MyWebDriverUtils.waitContainerThenClick(driver, LIBRARY_ICON_LOCATOR, LocatorType.CSS);
        MyWebDriverUtils.waitContainerThenClick(driver, VALIDITY_TEST_GROUP_ICON_LOCATOR, LocatorType.CSS);
    }

    @Then("^Validity Test Code page should be open$")
    public void check_validity_test_code_page() {
        MyWebDriverUtils.checkWidgetCaption(driver, WIDGET_CASE_LIST_LOCATOR, LocatorType.CSS, WIDGET_VALIDITY_TEST_CODE_VALUE);
        MyWebDriverUtils.checkCurrentUrl(driver, VALIDITY_TEST_CODE_PAGE_URL);
    }

    @When("^Click 'Add Validity Test Code' icon.$")
    public void click_add_validity_test_code_icon() {
        MyWebDriverUtils.waitContainerThenClick(driver, ADD_COMPOUND_ICON, LocatorType.ID);
    }

    @Then("^Add Validity Test Code screen should be displayed.$")
    public void check_add_validity_test_code_screen() {
        MyWebDriverUtils.checkPageCaption(driver, WIDGET_ADD_COMPOUND_LOCATOR, LocatorType.ID, WIDGET_ADD_VALIDITY_TEST_CODE);
    }

    @Then("^Following values should be displayed in 'Compounds' dropdown: (\\w{9}\\d), (\\w{9}\\d)$")
    public void check_compounds_drop_down(String vComp1, String vComp2) {
        if (compounds != null) {
            Assert.assertTrue(compounds.contains(vComp1) && compounds.contains(vComp2));
        }
    }

    @Then("^Following values should NOT be displayed in 'Compounds' dropdown: (\\w{8}\\d), (\\w{8}\\d)$")
    public void check_values_which_should_not_be_displayed(String comp1, String comp2) {
        if (compounds != null) {
            Assert.assertFalse(compounds.contains(comp1));
            Assert.assertFalse(compounds.contains(comp2));
            compounds.clear();
        }
    }

    /*
    Scenario: Create a Validity Test Group
     */

    @When("^Enter 'ValidityTest Code' as '(\\w{3}\\s\\w{10})', Select '(\\w{9}\\d)' and '(\\w{9}\\d)' from the Compounds drop down and enter all the other data and click Submit.$")
    public void enter_validity_test_code_and_all_other_data(String valTestCode, String vComp1, String vComp2) {
        enter_test_code_and_all_other_data_and_click_submit(valTestCode, vComp1, vComp2);
    }

    @Then("^A new Compound '(\\w{3}\\s\\w{10})' should be created successfully$")
    public void a_new_compound_should_be_created_successfully(String valTestCode) {
        check_compound(valTestCode, VALIDITY_TEST_CODE_PAGE_URL);
    }

    /*
    Scenario: Validating Testing Profile
     */

    @When("^Go to Libraries -> Testing Profile$")
    public void go_to_testing_profile() {
        MyWebDriverUtils.waitContainerThenClick(driver, LIBRARY_ICON_LOCATOR, LocatorType.CSS);
        MyWebDriverUtils.waitContainerThenClick(driver, TESTING_PROFILE_ICON_LOCATOR, LocatorType.CSS);
    }

    @Then("^Profile page should be open$")
    public void check_profile_page() {
        MyWebDriverUtils.checkWidgetCaption(driver, WIDGET_CASE_LIST_LOCATOR, LocatorType.CSS, WIDGET_TESTING_PROFILE_VALUE);
        MyWebDriverUtils.checkCurrentUrl(driver, TESTING_PROFILE_PAGE_URL);
    }

    @When("^Click 'Add Profile' icon.$")
    public void click_add_profile_icon() {
        MyWebDriverUtils.waitContainerThenClick(driver, ADD_COMPOUND_ICON, LocatorType.ID);
    }

    @Then("^Add Profile screen should be displayed.$")
    public void check_add_profile_screen() {
        MyWebDriverUtils.checkPageCaption(driver, WIDGET_ADD_COMPOUND_LOCATOR, LocatorType.ID, WIDGET_ADD_TESTING_PROFILE);
    }

    @When("^Verify the values displayed in 'TestScreen Group' drop down.$")
    public void verify_the_values_displayed_in_test_screen_group_drop_down() {
        if (testGroup == null) {
            testGroup = new ArrayList<>();
        }
        MyWebDriverUtils.waitContainerThenClick(driver, TEST_SCREEN_BUTTON_LOCATOR, LocatorType.CSS);
        WebElement dropDown = MyWebDriverUtils.findPresenceElement(driver, DROP_DOWN_MENU_LOCATOR, LocatorType.CSS);
        if (dropDown != null) {
            List<WebElement> list = MyWebDriverUtils.findElements(driver, LI, LocatorType.TAG, dropDown);
            if (list != null) {

                for (int i = 2; i < list.size(); i++) {
                    WebElement child = MyWebDriverUtils.findElement(driver, LABEL, LocatorType.TAG, list.get(i));
                    if (child != null) {
                        String text = child.getText().split(" , ")[0];
                        testGroup.add(text);
                    }
                }
            }
        }
        MyWebDriverUtils.waitContainerThenClick(driver, TEST_SCREEN_BUTTON_LOCATOR, LocatorType.CSS);
    }

    @Then("^Following values should be displayed in 'TestScreen Group' dropdown: (\\w{3}\\s\\w{11})$")
    public void check_values_in_test_screen_group_drop_down(String value) {
        Assert.assertTrue(testGroup.contains(value));
    }

    @When("^Verify the values NOT displayed in 'TestScreen Group' drop down.$")
    public void verify_the_values_displayed_not_in_test_screen_group_drop_down() {
        if (testGroup == null) {
            verify_the_values_displayed_in_test_screen_group_drop_down();
        }
    }

    @Then("^Following values should NOT be displayed in 'TestScreen Group' dropdown: (\\w{3}\\s\\w{10})$")
    public void check_values_not_in_test_screen_grop_down_list(String value) {
        Assert.assertFalse(testGroup.contains(value));
    }

    @When("^Verify the values displayed in 'Validity Test Group' drop down.$")
    public void verify_the_values_displayed_in_validity_test_group_drop_down() {
        if (validityTestGroup == null) {
            validityTestGroup = new ArrayList<>();
        }
        MyWebDriverUtils.waitContainerThenClick(driver, VALIDITY_TEST_GROUP_LOCATOR, LocatorType.CSS);
        WebElement dropDown = MyWebDriverUtils.findPresenceElement(driver, VALIDITY_DROP_DOWN, LocatorType.CSS);
        if (dropDown != null) {
            List<WebElement> list = MyWebDriverUtils.findElements(driver, LI, LocatorType.TAG, dropDown);
            if (list != null) {

                for (int i = 2; i < list.size(); i++) {
                    WebElement child = MyWebDriverUtils.findElement(driver, LABEL, LocatorType.TAG, list.get(i));
                    if (child != null) {
                        String text = child.getText().split(" , ")[0];
                        validityTestGroup.add(text);
                    }
                }
            }
        }
        MyWebDriverUtils.waitContainerThenClick(driver, VALIDITY_TEST_GROUP_LOCATOR, LocatorType.CSS);
    }

    @Then("^Following values should be displayed in 'Validity Test Group' dropdown: (\\w{3}\\s\\w{10})$")
    public void check_values_in_validity_test_group_drop_down(String value) {
        Assert.assertTrue(validityTestGroup.contains(value));
    }

    @When("^Verify the values NOT displayed in 'Validity Test Group' drop down.$")
    public void verify_the_values_not_displayed_in_validity_drop_down() {
        if (validityTestGroup == null) {
            verify_the_values_displayed_in_validity_test_group_drop_down();
        }
    }

    @Then("^Following values should NOT be displayed in 'TestScreen Group' dropdown: (\\w{3}\\s\\w{11})$")
    public void check_values_not_in_validity_drop_down(String value) {
        Assert.assertFalse(validityTestGroup.contains(value));
    }

    /*
    Scenario: Create a Testing Profile
     */

    @When("^Enter 'Name' as '(\\w{11}\\d{1})', 'Test Screen Group' as '(\\w{3}\\s\\w{11})', 'Validity Test Group' as '(\\w{3}\\s\\w{10})', and click Submit.$")
    public void enter_all_data(String name, String testScreen, String validity) {
        ProfileTesting.name = name;
        ProfileTesting.testScreen = testScreen;
        ProfileTesting.validityTestGroup = validity;
        MyWebDriverUtils.enterData(driver, ProfileTesting.PROFILE_NAME, LocatorType.ID, ProfileTesting.name);

        MyWebDriverUtils.waitContainerThenClick(driver, TEST_SCREEN_BUTTON_LOCATOR, LocatorType.CSS);
        WebElement dropDown = MyWebDriverUtils.findPresenceElement(driver, DROP_DOWN_MENU_LOCATOR, LocatorType.CSS);
        if (dropDown != null) {
            List<WebElement> list = MyWebDriverUtils.findElements(driver, LI, LocatorType.TAG, dropDown);
            if (list != null) {

                for (int i = 2; i < list.size(); i++) {
                    WebElement child = MyWebDriverUtils.findElement(driver, LABEL, LocatorType.TAG, list.get(i));
                    if (child != null) {
                        String text = child.getText().split(" , ")[0];
                        if (text.equals(testScreen)) {
                            child.click();
                        }
                    }
                }
            }
        }
        MyWebDriverUtils.waitContainerThenClick(driver, TEST_SCREEN_BUTTON_LOCATOR, LocatorType.CSS);

        MyWebDriverUtils.waitContainerThenClick(driver, VALIDITY_TEST_GROUP_LOCATOR, LocatorType.CSS);
        WebElement dropD = MyWebDriverUtils.findPresenceElement(driver, VALIDITY_DROP_DOWN, LocatorType.CSS);
        if (dropD != null) {
            List<WebElement> list = MyWebDriverUtils.findElements(driver, LI, LocatorType.TAG, dropD);
            if (list != null) {

                for (int i = 2; i < list.size(); i++) {
                    WebElement child = MyWebDriverUtils.findElement(driver, LABEL, LocatorType.TAG, list.get(i));
                    if (child != null) {
                        String text = child.getText().split(" , ")[0];
                        if (text.equals(validity)) {
                            child.click();
                        }
                    }
                }
            }
        }
        MyWebDriverUtils.waitContainerThenClick(driver, VALIDITY_TEST_GROUP_LOCATOR, LocatorType.CSS);

        try {
            MyWebDriverUtils.waitContainerThenClick(driver, SUBMIT_LOCATOR, LocatorType.CSS);
        } catch (TimeoutException ex) {
            System.out.println("Submit button is disabled");
        }


    }

    @Then("^A new Test Profile should be created successfully$")
    public void check_a_new_test_profile() {
        if (checkErrorMessage(PROFILE_TESTING_MESSAGE_ERROR, ProfileTesting.name)) {
            return;
        }
        MyWebDriverUtils.checkWidgetCaption(driver, ALERT_SUCCESS_LOCATOR, LocatorType.CSS, "Profile " + ProfileTesting.name + " created");
        MyWebDriverUtils.checkCurrentUrl(driver, TESTING_PROFILE_PAGE_URL);

        while (true) {
            try {
                List<WebElement> cells = MyWebDriverUtils.getCells(driver, TABLE_LOCATOR, LocatorType.ID, 1, 4);
                if (cells != null && cells.size() == 4) {
                    Assert.assertEquals(cells.get(0).getText(), ProfileTesting.name);
                    Assert.assertEquals(cells.get(1).getText(), ProfileTesting.testScreen);
                    Assert.assertEquals(cells.get(2).getText(), ProfileTesting.validityTestGroup);
                    break;

                } else {
                    Assert.fail("cells is null");
                }
            } catch (StaleElementReferenceException ex) {
                System.out.println("element is not attached to the page document");
            }
        }


    }


    private static final class Compound {
        private Compound() {
        }

        private static final String NAME_LOCATOR = "name";
        private static final String CLASS_LOCATOR = "classtype";
        private static final String TYPE_LOCATOR = "type";
        private static final String RANGE_LOCATOR = "rangetype";
        private static final String CUT_OFF_RANGE_LOCATOR = "cutoffrange";
        private static final String UNITS_LOCATOR = "units";
        private static final String CUT_OFF_LOCATOR = "cutoff";
        private static final String RESULT_LOCATOR = "result";
        private static final String BILLING_CODE_LOCATOR = "billingCode";
        private static final String ORAL_DETECTION_LOCATOR = "detectionOral";
        private static final String URINE_DETECTION_LOCATOR = "detectionUrine";
        private static final String NEGATIVE_COMMENTS_LOCATOR = "negativeComments";
        private static final String POSITIVE_COMMENTS_LOCATOR = "positiveComments";

        private static final String CLASS = "Class";

        private static final String RANGE = "=";
        private static final String CUT_OFF_RANGE = "5";
        private static final String UNITS = "mg/dL";
        private static final String CUT_OFF = "1";
        private static final String RESULT = "POS";
        private static final String BILLING_CODE = "12345";
        private static final String ORAL_DETECTION = "3";
        private static final String URINE_DETECTION = "5";
        private static final String NEGATIVE_COMMENTS = "Negative comments";
        private static final String POSITIVE_COMMENTS = "Positive comments";
    }

    private static final class Drug {
        private Drug() {
        }

        private static String compoundValue;

        private static final String DRUG_NAME_LOCATOR = "drugName";
        private static final String ACCESS_PREFIX_LOCATOR = "accPrefix";
        private static final String COMPOUNDS_LOCATOR = "compounds";

        private static final String ACCESS_PREFIX_VALUE = "Oral";
    }

    private static final class TestCode {
        private TestCode() {
        }

        private static String compValue1;
        private static String compValue2;

        private static final String TEST_CODE_LOCATOR = "test_code";
        private static final String DESCRIPTION_LOCATOR = "description";
        private static final String COMPOUNDS_LOCATOR = "compounds";

        private static final String DESCRIPTION = "description";
    }

    private static final class ProfileTesting {
        private ProfileTesting() {
        }

        private static String name;
        private static String testScreen;
        private static String validityTestGroup;

        private static final String TEST_SCREEN_GROUP_LOCATOR = "testcodes1"; // id
        private static final String PROFILE_NAME = "profileName"; //id, name
        private static final String VALIDITY_TEST_GROUP_LOCATOR = "testcodes2"; // id


    }
}
