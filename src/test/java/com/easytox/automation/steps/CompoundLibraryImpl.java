package com.easytox.automation.steps;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.LocatorType;
import com.easytox.automation.utils.MyWebDriverUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alexander on 17.02.2017.
 */
public class CompoundLibraryImpl {
    private static final String PASSWORD = "Welcome@123";
    private static final String LOGIN = "cgilabadmin";
    private static final String LOGIN_PAGE_URL = "http://bmtechsol.com:8080/easytox/";
    private static final String FIND_USERNAME = "j_username";
    private static final String FIND_PASSWORD = "j_password";
    private static final String LOGIN_BUTTON_XPATH = "//*[@id=\"loginform\"]/div[3]/div/button";
    private static final String ICON_LOCATOR = "body > div.navbar > div > div > div.navbar-header.pull-right > div > ul > li:nth-child(11) > a";
    private static final String COMPOUND_LIBRARY_ICON_LOCATOR = "body > div.navbar > div > div > div.navbar-header.pull-right > div > ul > li.open > #topmenu > li:nth-child(2) > a";
    private static final String CHOOSE_FILE_LOCATOR = "excelfile";
    private static final String FILE_PATH = "C:\\Users\\Alexander\\Desktop\\report.xlsx";
    private static final String FILE_NAME = "report.xlsx";
    private static final String REGEXP = "^(C:)\\\\(fakepath)\\\\(.*)$";
    private static final String UPLOAD_BUTTON_LOCATOR = "#maincontentdiv > div.page-body > div.row > div > div > div.widget-header > div > div > div.form-group.has-feedback > form.bv-form > input.form-control";

    private static final String ALERT_SUCCESS_LOCATOR = "#maincontentdiv > div.page-body > div.alert.alert-success.fade.in";
    private static final String MESSAGE_REGEXP = "^(\\d*) Compounds imported sucessfully from (\\d*) total rows$";
    private static final String TABLE_LOCATOR = "example";
    private static final String DROP_DOWN_LOCATOR = "example_length";
    private static final String ALL = "All";
    private static final String SEARCH_BOX_LOCATOR = "#example_filter > label > input";
    private static final String STR = "abcdefghk";
    private static final String NOT_FOUND = "No matching records found";
    private static final String NOT_FOUND_ELEMENT = "nElement";
    private static final String FOUND_ELEMENT = "fElement";
    private static final String GOOD_STR = "TestScreen";
    private static final String INFO_MESSAGE_LOCATOR = "example_info";
    private static final String PLUS_BUTTON_LOCATOR = "add";
    private static final String POPUP_ADD_COMPOUND_LOCATOR = "addCompound";
    private static final String SUBMIT_LOCATOR = "#form > div.modal-footer > button.btn.btn-primary.btn-md";
    private static final String COMPOUND_LIST_URL = "http://bmtechsol.com:8080/easytox/compound/list";
    private static final String HELP_BLOCK = "#form > div.modal-body > div.form-group.has-error > div > small:nth-child(2)";
    private static final String CLOSE_BUTTON_LOCATOR = "#form > div.modal-footer > button.btn.btn-default";
    private static final String X_LOCATOR = "#addCompounddiv > div > button";
    private static final String EDIT_BUTTON = "editbutton";
    private static final String EDIT_COMPOUND = "editCompound";

    private static final String SUBMIT_BUTTON_LOCATOR = "#form1 > div.modal-footer > button.btn.btn-primary.btn-md";
    private static final String CLOSE_LOCATOR = "#form1 > div.modal-footer > button.btn.btn-default";
    private static final String X_BUTTON_LOCATOR = "#editCompounddiv > div > button";
    private static final String PAGINATION_LOCATOR = "example_paginate";


    private static int tableSize;
    private static int columnNumber;
    private static Map<String, String> map;
    private static Map<String, String> mapMessage;
    private static Map<String, Integer> mapRecords;

    private WebDriver driver;

    public CompoundLibraryImpl() {
        DriverBase.instantiateDriverObject();
        driver = DriverBase.getDriver();
    }

    /*
    Scenario: Choose File
     */
    @Given("^the user is on Compound Library page$")
    public void the_user_is_on_compound_library_page() {
        String url = driver.getCurrentUrl();
        if (url.contains(LOGIN_PAGE_URL)) {
            driver.get(COMPOUND_LIST_URL);
            return;
        }
        MyWebDriverUtils.authorization(driver, LOGIN_PAGE_URL,
                FIND_USERNAME, LocatorType.NAME, LOGIN,
                FIND_PASSWORD, LocatorType.NAME, PASSWORD,
                LOGIN_BUTTON_XPATH, LocatorType.XPATH);
        MyWebDriverUtils.waitContainerThenClick(driver, ICON_LOCATOR, LocatorType.CSS);
        MyWebDriverUtils.waitContainerThenClick(driver, COMPOUND_LIBRARY_ICON_LOCATOR, LocatorType.CSS);
    }

    @When("^the user clicked on Choose file$")
    public void click_on_choose_file() {
        MyWebDriverUtils.waitContainerThenClick(driver, CHOOSE_FILE_LOCATOR, LocatorType.NAME);
    }

    @Then("^upload popup to select the files should be displayed$")
    public void upload_popup_to_select_the_files_be_displayed() {
    }

    @When("^the user selected the required file to upload$")
    public void the_user_selected_the_required_file_to_upload() {
        File f = new File(FILE_PATH);
        String path = f.getAbsolutePath();
        WebElement el = MyWebDriverUtils.findElement(driver, CHOOSE_FILE_LOCATOR, LocatorType.NAME);
        if (el != null) {
            el.sendKeys(path);
        }
    }

    @Then("^the selected file name should be displayed next to the Choose file$")
    public void the_selected_file_name_should_be_displayed() {
        WebElement file = MyWebDriverUtils.findElement(driver, CHOOSE_FILE_LOCATOR, LocatorType.NAME);
        if (file != null) {
            String filePath = file.getAttribute("value");
            String fileName = "";

            Pattern r = Pattern.compile(REGEXP);
            Matcher m = r.matcher(filePath);
            if (m.find()) {
                fileName = m.group(3);
                Assert.assertEquals(fileName, FILE_NAME);
            } else {
                Assert.fail("does not match the pattern!");
            }
        } else {
            Assert.fail("not found element!");
        }
    }

    @When("^the user selected the required file to upload and click on upload$")
    public void the_user_selected_the_required_file_to_upload_and_click_on_upload() {
        MyWebDriverUtils.selectOption(driver, DROP_DOWN_LOCATOR, LocatorType.NAME, ALL);

        tableSize = MyWebDriverUtils.getRowsSize(driver, TABLE_LOCATOR, LocatorType.ID);
        MyWebDriverUtils.waitContainerThenClick(driver, UPLOAD_BUTTON_LOCATOR, LocatorType.CSS);
    }

    @Then("^the selected file should be uploaded and data should be loaded under compounds table$")
    public void the_selected_file_should_be_uploaded() {
        WebElement element = MyWebDriverUtils.findVisibilityElement(driver, ALERT_SUCCESS_LOCATOR, LocatorType.CSS);
        if (element != null) {
            String message = element.getText();
            Assert.assertTrue(message.matches(MESSAGE_REGEXP));
        } else {
            Assert.fail("element is null!");
        }
        MyWebDriverUtils.selectOption(driver, DROP_DOWN_LOCATOR, LocatorType.NAME, ALL);

        int new_size = MyWebDriverUtils.getRowsSize(driver, TABLE_LOCATOR, LocatorType.ID);
        Assert.assertTrue(new_size > tableSize);
    }

    /*
    Scenario: Search Box
     */

    @When("^entered some text in the Search box.$")
    public void entered_some_text_in_the_Search_box() {
        if (map == null) {
            map = new HashMap<>();
        }
        if (mapMessage == null) {
            mapMessage = new HashMap<>();
        }
        MyWebDriverUtils.enterData(driver, SEARCH_BOX_LOCATOR, LocatorType.CSS, STR);
        List<WebElement> lst = MyWebDriverUtils.getCells(driver, TABLE_LOCATOR, LocatorType.ID, 1, 1);
        WebElement el = MyWebDriverUtils.findVisibilityElement(driver, INFO_MESSAGE_LOCATOR, LocatorType.ID);
        if (lst != null && el != null) {
            map.put(NOT_FOUND, lst.get(0).getText());
            mapMessage.put(NOT_FOUND_ELEMENT, el.getText());
        } else {
            Assert.fail("not found element!");
        }

        MyWebDriverUtils.enterData(driver, SEARCH_BOX_LOCATOR, LocatorType.CSS, GOOD_STR);
        el = MyWebDriverUtils.findVisibilityElement(driver, INFO_MESSAGE_LOCATOR, LocatorType.ID);
        if (el != null) {
            mapMessage.put(FOUND_ELEMENT, el.getText());
        } else {
            Assert.fail("not found element!");
        }

    }

    @Then("^user should be able to view the search results.$")
    public void user_should_be_able_to_view_search_results() {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(NOT_FOUND)) {
                Assert.assertEquals(entry.getKey(), entry.getValue());
                String message = mapMessage.get(NOT_FOUND_ELEMENT);
                String[] array = message.split(" ");
                Assert.assertEquals(array[1], "0");
                Assert.assertEquals(array[3], "0");
                Assert.assertEquals(array[5], "0");

            }
            String message = mapMessage.get(FOUND_ELEMENT);
            String[] array = message.split(" ");
            Assert.assertTrue(Integer.parseInt(array[1]) > 0);
            Assert.assertTrue(Integer.parseInt(array[3]) > 0);
            Assert.assertTrue(Integer.parseInt(array[5]) > 0);


            MyWebDriverUtils.selectOption(driver, DROP_DOWN_LOCATOR, LocatorType.NAME, ALL);
            List<List<WebElement>> allCells = MyWebDriverUtils.getAllCells(driver, TABLE_LOCATOR, LocatorType.ID, 12);
            int count = 0;
            if (allCells != null) {
                for (List<WebElement> lst : allCells) {
                    for (int i = 0; i < 12; i++) {
                        if (lst.get(i).getText().contains(GOOD_STR)) {
                            count++;
                        }
                    }
                    Assert.assertTrue(count > 0);
                    count = 0;
                }

            } else {
                Assert.fail("Table is EMPTY!");
            }
        }


    }

    /*
    Scenario: Adding a compound
    */

    @When("^clicked on '\\+' button next to search box$")
    public void click_on_plus_button() {
        MyWebDriverUtils.waitContainerThenClick(driver, PLUS_BUTTON_LOCATOR, LocatorType.ID);
    }

    @Then("^Add Compound popup should be displayed$")
    public void add_compound_popup_should_be_displayed() {
        WebElement popup = MyWebDriverUtils.findVisibilityElement(driver, POPUP_ADD_COMPOUND_LOCATOR, LocatorType.ID);
        if (popup != null) {
            Assert.assertEquals(popup.getAttribute("style"), "display: block;");
        } else {
            Assert.fail("Element is not found!");
        }
    }

    @When("^Add Compound popup is displayed$")
    public void add_compound_popup_is_displayed() {
        click_on_plus_button();
        WebElement popup = MyWebDriverUtils.findVisibilityElement(driver, POPUP_ADD_COMPOUND_LOCATOR, LocatorType.ID);
        if (popup != null) {
            Assert.assertEquals(popup.getAttribute("style"), "display: block;");
        } else {
            Assert.fail("Element is not found!");
        }
    }

    @Then("^user should be able to enter the data in all the fields.$")
    public void user_should_be_able_to_enter_the_data() {
        Compound.name = Compound.NAME + MyWebDriverUtils.getRandomNumber();

        MyWebDriverUtils.enterData(driver, Compound.NAME_LOCATOR, LocatorType.ID, Compound.name);
        MyWebDriverUtils.enterData(driver, Compound.CLASS_LOCATOR, LocatorType.ID, Compound.CLASS);
        MyWebDriverUtils.selectOption(driver, Compound.TYPE_LOCATOR, LocatorType.ID, Compound.TYPE_1);
        MyWebDriverUtils.enterData(driver, Compound.CUTOFF_LOCATOR, LocatorType.ID, Compound.CUTOFF);
        MyWebDriverUtils.selectOption(driver, Compound.RESULT_LOCATOR, LocatorType.ID, Compound.RESULT_1);
        MyWebDriverUtils.enterData(driver, Compound.BILLING_CODE_LOCATOR, LocatorType.ID, Compound.BILLING_CODE);
        MyWebDriverUtils.enterData(driver, Compound.ORAL_DETECTION_LOCATOR, LocatorType.ID, Compound.ORAL_DETECTION);
        MyWebDriverUtils.enterData(driver, Compound.URINE_DETECTION_LOCATOR, LocatorType.ID, Compound.URINE_DETECTION);
        MyWebDriverUtils.enterData(driver, Compound.POSITIVE_COMMENTS_LOCATOR, LocatorType.ID, Compound.POSITIVE_COMMENTS);
        MyWebDriverUtils.enterData(driver, Compound.NEGATIVE_COMMENTS_LOCATOR, LocatorType.ID, Compound.NEGATIVE_COMMENTS);

        WebElement name = MyWebDriverUtils.findElement(driver, Compound.NAME_LOCATOR, LocatorType.ID);
        if (name != null) {
            Assert.assertEquals(name.getAttribute("value"), Compound.name);
        } else {
            Assert.fail("element is not found!");
        }

        WebElement classType = MyWebDriverUtils.findElement(driver, Compound.CLASS_LOCATOR, LocatorType.ID);
        if (classType != null) {
            Assert.assertEquals(classType.getAttribute("value"), Compound.CLASS);
        } else {
            Assert.fail("element is not found!");
        }

        WebElement type = MyWebDriverUtils.findElement(driver, Compound.TYPE_LOCATOR, LocatorType.ID);
        if (type != null) {
            List<WebElement> lst = new Select(type).getAllSelectedOptions();
            String[] mass = Compound.TYPE_1.split(" ");
            String elType = mass[0] + mass[1];
            for (WebElement el : lst) {
                Assert.assertEquals(el.getAttribute("value"), elType);
            }
        } else {
            Assert.fail("element is not found!");
        }

        WebElement cutoff = MyWebDriverUtils.findElement(driver, Compound.CUTOFF_LOCATOR, LocatorType.ID);
        if (cutoff != null) {
            Assert.assertEquals(cutoff.getAttribute("value"), Compound.CUTOFF);
        } else {
            Assert.fail("element is not found!");
        }

        WebElement result = MyWebDriverUtils.findElement(driver, Compound.RESULT_LOCATOR, LocatorType.ID);
        if (result != null) {
            List<WebElement> lst = new Select(result).getAllSelectedOptions();
            for (WebElement el : lst) {
                Assert.assertEquals(el.getAttribute("value"), Compound.RESULT_1);
            }
        } else {
            Assert.fail("element is not found!");
        }

        WebElement billingCode = MyWebDriverUtils.findElement(driver, Compound.BILLING_CODE_LOCATOR, LocatorType.ID);
        if (billingCode != null) {
            Assert.assertEquals(billingCode.getAttribute("value"), Compound.BILLING_CODE);
        } else {
            Assert.fail("element is not found!");
        }

        WebElement oralDetection = MyWebDriverUtils.findElement(driver, Compound.ORAL_DETECTION_LOCATOR, LocatorType.ID);
        if (oralDetection != null) {
            Assert.assertEquals(oralDetection.getAttribute("value"), Compound.ORAL_DETECTION);
        } else {
            Assert.fail("element is not found!");
        }

        WebElement urineDetection = MyWebDriverUtils.findElement(driver, Compound.URINE_DETECTION_LOCATOR, LocatorType.ID);
        if (urineDetection != null) {
            Assert.assertEquals(urineDetection.getAttribute("value"), Compound.URINE_DETECTION);
        } else {
            Assert.fail("element is not found!");
        }

        WebElement negativeComments = MyWebDriverUtils.findElement(driver, Compound.NEGATIVE_COMMENTS_LOCATOR, LocatorType.ID);
        if (negativeComments != null) {
            Assert.assertEquals(negativeComments.getAttribute("value"), Compound.NEGATIVE_COMMENTS);
        } else {
            Assert.fail("element is not found!");
        }

        WebElement positiveComments = MyWebDriverUtils.findElement(driver, Compound.POSITIVE_COMMENTS_LOCATOR, LocatorType.ID);
        if (positiveComments != null) {
            Assert.assertEquals(positiveComments.getAttribute("value"), Compound.POSITIVE_COMMENTS);
        } else {
            Assert.fail("element is not found!");
        }

        MyWebDriverUtils.selectOption(driver, Compound.TYPE_LOCATOR, LocatorType.ID, Compound.TYPE_2);
        MyWebDriverUtils.selectOption(driver, Compound.RANGE_LOCATOR, LocatorType.ID, Compound.RANGE_1);
        MyWebDriverUtils.enterData(driver, Compound.CUTOFF_RANGE_LOCATOR, LocatorType.ID, Compound.CUTOFF_RANGE);
        MyWebDriverUtils.selectOption(driver, Compound.UNITS_LOCATOR, LocatorType.NAME, Compound.UNITS);
        MyWebDriverUtils.selectOption(driver, Compound.RESULT_LOCATOR, LocatorType.ID, Compound.RESULT_2);

        type = MyWebDriverUtils.findElement(driver, Compound.TYPE_LOCATOR, LocatorType.ID);
        if (type != null) {
            List<WebElement> lst = new Select(type).getAllSelectedOptions();
            String[] mass = Compound.TYPE_2.split(" ");
            String elType = mass[0] + mass[1];
            for (WebElement el : lst) {
                Assert.assertEquals(el.getAttribute("value"), elType);
            }
        } else {
            Assert.fail("element is not found!");
        }

        WebElement range = MyWebDriverUtils.findElement(driver, Compound.RANGE_LOCATOR, LocatorType.ID);
        if (range != null) {
            List<WebElement> lst = new Select(range).getAllSelectedOptions();
            for (WebElement el : lst) {
                Assert.assertEquals(el.getAttribute("value"), "equal");
            }
        } else {
            Assert.fail("element is not found!");
        }

        WebElement cutOffRange = MyWebDriverUtils.findElement(driver, Compound.CUTOFF_RANGE_LOCATOR, LocatorType.ID);
        if (cutOffRange != null) {
            Assert.assertEquals(cutOffRange.getAttribute("value"), Compound.CUTOFF_RANGE);
        } else {
            Assert.fail("element is not found!");
        }

        WebElement units = MyWebDriverUtils.findElement(driver, Compound.UNITS_LOCATOR, LocatorType.NAME);
        if (units != null) {
            List<WebElement> lst = new Select(units).getAllSelectedOptions();
            for (WebElement el : lst) {
                Assert.assertEquals(el.getAttribute("value"), Compound.UNITS);
            }
        } else {
            Assert.fail("element is not found!");
        }

        result = MyWebDriverUtils.findElement(driver, Compound.RESULT_LOCATOR, LocatorType.ID);
        if (result != null) {
            List<WebElement> lst = new Select(result).getAllSelectedOptions();
            for (WebElement el : lst) {
                Assert.assertEquals(el.getAttribute("value"), Compound.RESULT_2);
            }
        } else {
            Assert.fail("element is not found!");
        }

        MyWebDriverUtils.selectOption(driver, Compound.RANGE_LOCATOR, LocatorType.ID, Compound.RANGE_2);
        MyWebDriverUtils.enterData(driver, Compound.MIN_LOCATOR, LocatorType.ID, Compound.MIN);
        MyWebDriverUtils.enterData(driver, Compound.MAX_LOCATOR, LocatorType.ID, Compound.MAX);

        range = MyWebDriverUtils.findElement(driver, Compound.RANGE_LOCATOR, LocatorType.ID);
        if (range != null) {
            List<WebElement> lst = new Select(range).getAllSelectedOptions();
            for (WebElement el : lst) {
                Assert.assertEquals(el.getAttribute("value"), Compound.RANGE_2);
            }
        } else {
            Assert.fail("element is not found!");
        }

        WebElement min = MyWebDriverUtils.findElement(driver, Compound.MIN_LOCATOR, LocatorType.ID);
        if (min != null) {
            Assert.assertEquals(min.getAttribute("value"), Compound.MIN);
        } else {
            Assert.fail("element is not found!");
        }

        WebElement max = MyWebDriverUtils.findElement(driver, Compound.MAX_LOCATOR, LocatorType.ID);
        if (max != null) {
            Assert.assertEquals(max.getAttribute("value"), Compound.MAX);
        } else {
            Assert.fail("element is not found!");
        }

        MyWebDriverUtils.waitContainerThenClick(driver, CLOSE_BUTTON_LOCATOR, LocatorType.CSS);
        MyWebDriverUtils.waitContainerThenClick(driver, CLOSE_BUTTON_LOCATOR, LocatorType.CSS);

    }

    @When("^Add Compound popup is displayed and user entered all the required fields and click on submit$")
    public void enter_data_and_click_submit() {

        click_on_plus_button();

        Compound.name = Compound.NAME + MyWebDriverUtils.getRandomNumber();

        MyWebDriverUtils.enterData(driver, Compound.NAME_LOCATOR, LocatorType.ID, Compound.name);
        MyWebDriverUtils.enterData(driver, Compound.CLASS_LOCATOR, LocatorType.ID, Compound.CLASS);
        MyWebDriverUtils.selectOption(driver, Compound.TYPE_LOCATOR, LocatorType.ID, Compound.TYPE_1);
        MyWebDriverUtils.enterData(driver, Compound.CUTOFF_LOCATOR, LocatorType.ID, Compound.CUTOFF);
        MyWebDriverUtils.selectOption(driver, Compound.RESULT_LOCATOR, LocatorType.ID, Compound.RESULT_1);
        MyWebDriverUtils.enterData(driver, Compound.BILLING_CODE_LOCATOR, LocatorType.ID, Compound.BILLING_CODE);
        MyWebDriverUtils.enterData(driver, Compound.ORAL_DETECTION_LOCATOR, LocatorType.ID, Compound.ORAL_DETECTION);
        MyWebDriverUtils.enterData(driver, Compound.URINE_DETECTION_LOCATOR, LocatorType.ID, Compound.URINE_DETECTION);
        MyWebDriverUtils.enterData(driver, Compound.POSITIVE_COMMENTS_LOCATOR, LocatorType.ID, Compound.POSITIVE_COMMENTS);
        MyWebDriverUtils.enterData(driver, Compound.NEGATIVE_COMMENTS_LOCATOR, LocatorType.ID, Compound.NEGATIVE_COMMENTS);

        MyWebDriverUtils.waitContainerThenClick(driver, SUBMIT_LOCATOR, LocatorType.CSS);
    }

    @Then("^user should be able to submit the data and the added compound should be displayed on the list$")
    public void check_added_compound() {
        String value = "Compound " + Compound.name + " created";
        MyWebDriverUtils.checkPageCaption(driver, ALERT_SUCCESS_LOCATOR, LocatorType.CSS, value);
        MyWebDriverUtils.checkCurrentUrl(driver, COMPOUND_LIST_URL);

        List<WebElement> el = MyWebDriverUtils.getCells(driver, TABLE_LOCATOR, LocatorType.ID, 1, 12);
        if (el != null) {
            Assert.assertEquals(el.get(0).getText(), Compound.CLASS);
            String[] mass = Compound.TYPE_1.split(" ");
            String elType = mass[0] + mass[1];
            Assert.assertEquals(el.get(1).getText(), elType);
            Assert.assertEquals(el.get(2).getText(), Compound.name);
            Assert.assertEquals(el.get(3).getText(), Compound.RESULT_1);
            Assert.assertEquals(el.get(5).getText(), Compound.CUTOFF);
            Assert.assertEquals(el.get(6).getText(), Compound.POSITIVE_COMMENTS);
            Assert.assertEquals(el.get(7).getText(), Compound.NEGATIVE_COMMENTS);
            Assert.assertEquals(el.get(8).getText(), Compound.BILLING_CODE);
            Assert.assertEquals(el.get(9).getText(), Compound.ORAL_DETECTION);
            Assert.assertEquals(el.get(10).getText(), Compound.URINE_DETECTION);
        } else {
            Assert.fail("Element not found!");
        }
    }

    @When("^Add Compound popup is displayed and user is not entered all the required fields and click on submit$")
    public void user_dont_be_able_to_enter_data() {
        click_on_plus_button();
        MyWebDriverUtils.enterData(driver, Compound.CLASS_LOCATOR, LocatorType.ID, Compound.CLASS);
        MyWebDriverUtils.selectOption(driver, Compound.TYPE_LOCATOR, LocatorType.ID, Compound.TYPE_1);
        MyWebDriverUtils.enterData(driver, Compound.CUTOFF_LOCATOR, LocatorType.ID, Compound.CUTOFF);
        MyWebDriverUtils.selectOption(driver, Compound.RESULT_LOCATOR, LocatorType.ID, Compound.RESULT_1);
        MyWebDriverUtils.enterData(driver, Compound.BILLING_CODE_LOCATOR, LocatorType.ID, Compound.BILLING_CODE);
        MyWebDriverUtils.enterData(driver, Compound.ORAL_DETECTION_LOCATOR, LocatorType.ID, Compound.ORAL_DETECTION);
        MyWebDriverUtils.enterData(driver, Compound.URINE_DETECTION_LOCATOR, LocatorType.ID, Compound.URINE_DETECTION);
        MyWebDriverUtils.enterData(driver, Compound.POSITIVE_COMMENTS_LOCATOR, LocatorType.ID, Compound.POSITIVE_COMMENTS);
        MyWebDriverUtils.enterData(driver, Compound.NEGATIVE_COMMENTS_LOCATOR, LocatorType.ID, Compound.NEGATIVE_COMMENTS);

        MyWebDriverUtils.waitContainerThenClick(driver, SUBMIT_LOCATOR, LocatorType.CSS);
    }

    @Then("^user should not be able to submit the data and should be displayed with the missing fields.$")
    public void check_submit_fail() {
        WebElement helpBlock = MyWebDriverUtils.findVisibilityElement(driver, HELP_BLOCK, LocatorType.CSS);
        if (helpBlock != null) {
            Assert.assertEquals(helpBlock.getText(), "The Name is required");
            Assert.assertEquals(helpBlock.getAttribute("data-bv-result"), "INVALID");
        } else {
            Assert.fail("Element is not found!");
        }
        MyWebDriverUtils.waitContainerThenClick(driver, CLOSE_BUTTON_LOCATOR, LocatorType.CSS);

    }

    @When("^Add Compound popup is displayed and the user clicks on 'Close' button$")
    public void click_on_close_button() {
        click_on_plus_button();
        MyWebDriverUtils.waitContainerThenClick(driver, CLOSE_BUTTON_LOCATOR, LocatorType.CSS);
    }

    @Then("^the popup should be closed and the user should land on the Compound Library page.$")
    public void popup_should_be_closed() throws InterruptedException {
        Thread.sleep(1000);
        WebElement popup = MyWebDriverUtils.findPresenceElement(driver, POPUP_ADD_COMPOUND_LOCATOR, LocatorType.ID);
        if (popup != null) {
            Assert.assertEquals(popup.getAttribute("style"), "display: none;");
        } else {
            Assert.fail("Element is not found!");
        }
    }

    @When("^Add Compound popup is displayed and the user clicks on 'x' button$")
    public void click_on_x_button() {
        click_on_plus_button();
        MyWebDriverUtils.waitContainerThenClick(driver, X_LOCATOR, LocatorType.CSS);
    }

    /*
    Scenario: No of records to be displayed on the page
     */

    @When("^clicked on dropdown that shows no of records to be displayed on the page.$")
    public void select_number_of_records() {
        if (mapRecords == null) {
            mapRecords = new HashMap<>();
        }

        MyWebDriverUtils.selectOption(driver, DROP_DOWN_LOCATOR, LocatorType.NAME, "10");

        int size = MyWebDriverUtils.getRowsSize(driver, TABLE_LOCATOR, LocatorType.ID);
        mapRecords.put("10", size);


        MyWebDriverUtils.selectOption(driver, DROP_DOWN_LOCATOR, LocatorType.NAME, "25");

        size = MyWebDriverUtils.getRowsSize(driver, TABLE_LOCATOR, LocatorType.ID);
        mapRecords.put("25", size);


        MyWebDriverUtils.selectOption(driver, DROP_DOWN_LOCATOR, LocatorType.NAME, "50");

        size = MyWebDriverUtils.getRowsSize(driver, TABLE_LOCATOR, LocatorType.ID);
        mapRecords.put("50", size);


        MyWebDriverUtils.selectOption(driver, DROP_DOWN_LOCATOR, LocatorType.NAME, "100");

        size = MyWebDriverUtils.getRowsSize(driver, TABLE_LOCATOR, LocatorType.ID);
        mapRecords.put("100", size);


        MyWebDriverUtils.selectOption(driver, DROP_DOWN_LOCATOR, LocatorType.NAME, "All");

        size = MyWebDriverUtils.getRowsSize(driver, TABLE_LOCATOR, LocatorType.ID);
        mapRecords.put("All", size);

    }

    @Then("^User should be able to view and select the options from the list and the corresponding number of rec should be displayed on the page$")
    public void check_number_of_records() {
        if (mapRecords.get("All") < 10) {
            Assert.assertEquals(mapRecords.get("10").intValue(), mapRecords.get("All").intValue());
        } else {
            Assert.assertEquals(mapRecords.get("10").intValue(), 10);
        }

        if (mapRecords.get("All") < 25) {
            Assert.assertEquals(mapRecords.get("25").intValue(), mapRecords.get("All").intValue());
        } else {
            Assert.assertEquals(mapRecords.get("25").intValue(), 25);
        }

        if (mapRecords.get("All") < 50) {
            Assert.assertEquals(mapRecords.get("50").intValue(), mapRecords.get("All").intValue());
        } else {
            Assert.assertEquals(mapRecords.get("50").intValue(), 50);
        }

        if (mapRecords.get("All") < 100) {
            Assert.assertEquals(mapRecords.get("100").intValue(), mapRecords.get("All").intValue());
        } else {
            Assert.assertEquals(mapRecords.get("100").intValue(), 100);
        }

        WebElement el = MyWebDriverUtils.findElement(driver, INFO_MESSAGE_LOCATOR, LocatorType.ID);
        if (el != null) {
            String text = el.getText();
            int numberOfRecord = Integer.valueOf(text.split(" ")[3]);
            int allRecordsSize = Integer.valueOf(text.split(" ")[5]);
            Assert.assertEquals(numberOfRecord, allRecordsSize);
        }
    }

    /*
        Scenario: Checking the sorting order of the displayed results
     */

    @When("^clicked on Class column of the list$")
    public void click_on_class_column() {
        WebElement el = MyWebDriverUtils.getTh(driver, TABLE_LOCATOR, LocatorType.ID, 12).get(0);
        if (el != null) {
            MyWebDriverUtils.waitContainerThenClick(driver, el);
        } else {
            Assert.fail("element is not found!");
        }
        columnNumber = 0;
    }

    @Then("^the list should be displayed in the alphabetical order.$")
    public void check_alphabetical_order() {
        List<List<WebElement>> lst = MyWebDriverUtils.getAllCells(driver, TABLE_LOCATOR, LocatorType.ID, 12);
        if (lst != null) {
            String temp = lst.get(0).get(columnNumber).getText();
            for (int i = 1; i < lst.size(); i++) {
                System.out.println(temp);
                Assert.assertTrue(checkOrder(temp, lst.get(i).get(columnNumber).getText()));
                temp = lst.get(i).get(columnNumber).getText();
            }
        } else {
            Assert.fail("element is not found!");
        }


    }

    private boolean checkOrder(String str1, String str2) {
        return str1.toLowerCase().compareTo(str2.toLowerCase()) <= 0;
    }

    @When("^clicked on Name column of the list$")
    public void click_on_name_column() {
        WebElement el = MyWebDriverUtils.getTh(driver, TABLE_LOCATOR, LocatorType.ID, 12).get(2);
        if (el != null) {
            MyWebDriverUtils.waitContainerThenClick(driver, el);
        } else {
            Assert.fail("element is not found!");
        }
        columnNumber = 2;
    }

    @When("^clicked on Result column of the list$")
    public void click_on_result_column() {
        WebElement el = MyWebDriverUtils.getTh(driver, TABLE_LOCATOR, LocatorType.ID, 12).get(3);
        if (el != null) {
            MyWebDriverUtils.waitContainerThenClick(driver, el);
        } else {
            Assert.fail("element is not found!");
        }
        columnNumber = 3;
    }

    @When("^clicked on Range column of the list$")
    public void click_on_range_column() {
        WebElement el = MyWebDriverUtils.getTh(driver, TABLE_LOCATOR, LocatorType.ID, 12).get(4);
        if (el != null) {
            MyWebDriverUtils.waitContainerThenClick(driver, el);
        } else {
            Assert.fail("element is not found!");
        }
        columnNumber = 4;
    }

    @Then("^the list should be displayed in the numerical order$")
    public void check_numerical_order() {
        check_alphabetical_order();
    }

    @When("^clicked on Cut off column of the list$")
    public void click_on_cutoff_column() {
        WebElement el = MyWebDriverUtils.getTh(driver, TABLE_LOCATOR, LocatorType.ID, 12).get(5);
        if (el != null) {
            MyWebDriverUtils.waitContainerThenClick(driver, el);
        } else {
            Assert.fail("element is not found!");
        }
        columnNumber = 5;
    }

    @When("^clicked on Positive Comments column of the list$")
    public void click_on_positive_comments_column() {
        WebElement el = MyWebDriverUtils.getTh(driver, TABLE_LOCATOR, LocatorType.ID, 12).get(6);
        if (el != null) {
            MyWebDriverUtils.waitContainerThenClick(driver, el);
        } else {
            Assert.fail("element is not found!");
        }
        columnNumber = 6;
    }

    @When("^clicked on Negative Comments column of the list$")
    public void click_on_negative_comments_column() {
        WebElement el = MyWebDriverUtils.getTh(driver, TABLE_LOCATOR, LocatorType.ID, 12).get(7);
        if (el != null) {
            MyWebDriverUtils.waitContainerThenClick(driver, el);
        } else {
            Assert.fail("element is not found!");
        }
        columnNumber = 7;
    }

    @When("^clicked on billing code column of the list$")
    public void click_on_billin_code_column() {
        WebElement el = MyWebDriverUtils.getTh(driver, TABLE_LOCATOR, LocatorType.ID, 12).get(8);
        if (el != null) {
            MyWebDriverUtils.waitContainerThenClick(driver, el);
        } else {
            Assert.fail("element is not found!");
        }
        columnNumber = 8;
    }

    @When("^clicked on Oral detection column of the list$")
    public void click_on_oral_detection_column() {
        WebElement el = MyWebDriverUtils.getTh(driver, TABLE_LOCATOR, LocatorType.ID, 12).get(9);
        if (el != null) {
            MyWebDriverUtils.waitContainerThenClick(driver, el);
        } else {
            Assert.fail("element is not found!");
        }
        columnNumber = 9;
    }

    @When("^clicked on Urine detection column of the list$")
    public void click_on_urine_detection_column() {
        WebElement el = MyWebDriverUtils.getTh(driver, TABLE_LOCATOR, LocatorType.ID, 12).get(10);
        if (el != null) {
            MyWebDriverUtils.waitContainerThenClick(driver, el);
        } else {
            Assert.fail("element is not found!");
        }
        columnNumber = 10;
    }

    /*
     Scenario: Click on Edit under Action Column
     */

    @When("^clicked on Edit button under Action column.$")
    public void click_on_edit_button_under_action_column() {
        while (true) {
            try {
                WebElement el = MyWebDriverUtils.findElements(driver, EDIT_BUTTON, LocatorType.ID).get(0);
                if (el != null) {
                    MyWebDriverUtils.waitContainerThenClick(driver, el);
                } else {
                    Assert.fail("element is not found!");
                }
                break;
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("#IndexOutOfBoundsException");
            }
        }

    }

    @Then("^'Edit Compound' popup should be displayed$")
    public void edit_compound_popup_should_be_displayed() {
        WebElement el = MyWebDriverUtils.findElement(driver, EDIT_COMPOUND, LocatorType.ID);
        if (el != null) {
            Assert.assertEquals(el.getAttribute("style"), "display: block;");
        } else {
            Assert.fail("element is not found!");
        }
    }

    @When("^clicked on Edit under Actions column and Edit Compound popup is displayed$")
    public void click_on_edit_under_actions_column_and_edit_compound_popup_is_displayed() {
        click_on_edit_button_under_action_column();
    }

    @Then("^user should be able to edit the data.$")
    public void user_should_be_able_to_edit_the_data() {
        Compound.newClass = Compound.NEW_CLASS + MyWebDriverUtils.getRandomNumber();
        Compound.newCutoff = Compound.NEW_CUTOFF + MyWebDriverUtils.getRandomNumber();
        Compound.newBillingCode = Compound.NEW_BILLING_CODE + MyWebDriverUtils.getRandomNumber();
        Compound.newPositiveComments = Compound.NEW_POSITIVE_COMMENTS + MyWebDriverUtils.getRandomNumber();
        Compound.newNegativeComments = Compound.NEW_NEGATIVE_COMMENTS + MyWebDriverUtils.getRandomNumber();

        while (true) {
            try {
                MyWebDriverUtils.enterData(driver, Compound.CLASS_LOCATOR, LocatorType.ID, Compound.newClass);
                MyWebDriverUtils.enterData(driver, Compound.CUTOFF_LOCATOR, LocatorType.NAME, Compound.newCutoff);
                MyWebDriverUtils.selectOption(driver, Compound.RESULT_LOCATOR, LocatorType.NAME, Compound.NEW_RESULT);
                MyWebDriverUtils.enterData(driver, Compound.BILLING_CODE_LOCATOR, LocatorType.ID, Compound.newBillingCode);
                MyWebDriverUtils.enterData(driver, Compound.ORAL_DETECTION_LOCATOR, LocatorType.ID, Compound.NEW_ORAL_DETECTION);
                MyWebDriverUtils.enterData(driver, Compound.URINE_DETECTION_LOCATOR, LocatorType.ID, Compound.NEW_URINE_DETECTION);
                MyWebDriverUtils.enterData(driver, Compound.NEGATIVE_COMMENTS_LOCATOR, LocatorType.ID, Compound.newNegativeComments);
                MyWebDriverUtils.enterData(driver, Compound.POSITIVE_COMMENTS_LOCATOR, LocatorType.ID, Compound.newPositiveComments);
                break;
            } catch (InvalidElementStateException ex) {
                System.out.println("#InvalidElementStateException");
            }
        }


        WebElement classType = MyWebDriverUtils.findElement(driver, Compound.CLASS_LOCATOR, LocatorType.ID);
        if (classType != null) {
            Assert.assertEquals(classType.getAttribute("value"), Compound.newClass);
        } else {
            Assert.fail("element is not found!");
        }

        WebElement cutoff = MyWebDriverUtils.findElement(driver, Compound.CUTOFF_LOCATOR, LocatorType.NAME);
        if (cutoff != null) {
            Assert.assertEquals(cutoff.getAttribute("value"), Compound.newCutoff);
        } else {
            Assert.fail("element is not found!");
        }

        WebElement result = MyWebDriverUtils.findElement(driver, Compound.RESULT_LOCATOR, LocatorType.NAME);
        if (result != null) {
            List<WebElement> lst = new Select(result).getAllSelectedOptions();
            for (WebElement el : lst) {
                Assert.assertEquals(el.getAttribute("value"), Compound.NEW_RESULT);
            }
        } else {
            Assert.fail("element is not found!");
        }

        WebElement billingCode = MyWebDriverUtils.findElement(driver, Compound.BILLING_CODE_LOCATOR, LocatorType.ID);
        if (billingCode != null) {
            Assert.assertEquals(billingCode.getAttribute("value"), Compound.newBillingCode);
        } else {
            Assert.fail("element is not found!");
        }

        WebElement oralDetection = MyWebDriverUtils.findElement(driver, Compound.ORAL_DETECTION_LOCATOR, LocatorType.ID);
        if (oralDetection != null) {
            Assert.assertEquals(oralDetection.getAttribute("value"), Compound.NEW_ORAL_DETECTION);
        } else {
            Assert.fail("element is not found!");
        }

        WebElement urineDetection = MyWebDriverUtils.findElement(driver, Compound.URINE_DETECTION_LOCATOR, LocatorType.ID);
        if (urineDetection != null) {
            Assert.assertEquals(urineDetection.getAttribute("value"), Compound.NEW_URINE_DETECTION);
        } else {
            Assert.fail("element is not found!");
        }

        WebElement negativeComments = MyWebDriverUtils.findElement(driver, Compound.NEGATIVE_COMMENTS_LOCATOR, LocatorType.ID);
        if (negativeComments != null) {
            Assert.assertEquals(negativeComments.getAttribute("value"), Compound.newNegativeComments);
        } else {
            Assert.fail("element is not found!");
        }

        WebElement positiveComments = MyWebDriverUtils.findElement(driver, Compound.POSITIVE_COMMENTS_LOCATOR, LocatorType.ID);
        if (positiveComments != null) {
            Assert.assertEquals(positiveComments.getAttribute("value"), Compound.newPositiveComments);
        } else {
            Assert.fail("element is not found!");
        }

    }

    @When("^Edit Compound popup is displayed and user can edit the data and click on submit$")
    public void edit_data_and_click_submit() {
        click_on_edit_button_under_action_column();
        user_should_be_able_to_edit_the_data();
        WebElement el = MyWebDriverUtils.findElement(driver, Compound.NEGATIVE_COMMENTS_LOCATOR, LocatorType.ID);
        if (el != null) {
            MyWebDriverUtils.waitContainerThenClick(driver, el);
        }

        Compound.name = MyWebDriverUtils.findElement(driver, Compound.NAME_LOCATOR, LocatorType.ID).getAttribute("value");
        MyWebDriverUtils.waitContainerThenClick(driver, SUBMIT_BUTTON_LOCATOR, LocatorType.CSS);
    }

    @Then("^user should be able to submit the data and the edited compound should be displayed on the list$")
    public void check_edited_compound() {
        WebElement el = MyWebDriverUtils.findElement(driver, ALERT_SUCCESS_LOCATOR, LocatorType.CSS);
        if (el != null) {
            Assert.assertEquals(el.getText(), "Compound " + Compound.name + " updated");
        } else {
            Assert.fail("element is not found!");
        }

        List<WebElement> lst = MyWebDriverUtils.getCells(driver, TABLE_LOCATOR, LocatorType.ID, 1, 12);
        if (lst != null) {
            Assert.assertEquals(lst.get(0).getText(), Compound.newClass);
            Assert.assertEquals(lst.get(3).getText(), Compound.NEW_RESULT);
            Assert.assertEquals(lst.get(5).getText(), Compound.newCutoff);
            Assert.assertEquals(lst.get(6).getText(), Compound.newPositiveComments);
            Assert.assertEquals(lst.get(7).getText(), Compound.newNegativeComments);
            Assert.assertEquals(lst.get(8).getText(), Compound.newBillingCode);
            Assert.assertEquals(lst.get(9).getText(), Compound.NEW_ORAL_DETECTION);
            Assert.assertEquals(lst.get(10).getText(), Compound.NEW_URINE_DETECTION);
        } else {
            Assert.fail("element is not found!");
        }
    }

    @When("^Edit Compound popup is displayed and the user clicks on 'Close' button$")
    public void user_click_close_button() {
        click_on_edit_button_under_action_column();

        MyWebDriverUtils.waitContainerThenClick(driver, CLOSE_LOCATOR, LocatorType.CSS);
        MyWebDriverUtils.waitContainerThenClick(driver, CLOSE_LOCATOR, LocatorType.CSS);
    }

    @Then("^the popup should be closed and the user should land on the Compound Library page$")
    public void close_popup() {
        while (true) {
            try {
                WebElement el = MyWebDriverUtils.findPresenceElement(driver, EDIT_COMPOUND, LocatorType.ID);
                if (el != null) {
                    Assert.assertEquals(el.getAttribute("style"), "display: none;");
                } else {
                    Assert.fail("element is not found!");
                }
                break;

            } catch (AssertionError er) {
                System.out.println("#AssertionError");
            }
        }

    }

    @When("^Edit Compound popup is diplayed and the user clicks on 'x' button$")
    public void user_click_on_x_button() {
        while (true) {
            try {
                click_on_edit_button_under_action_column();
                break;
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("#IndexOutOfBoundsException");
            }
        }

        MyWebDriverUtils.waitContainerThenClick(driver, X_BUTTON_LOCATOR, LocatorType.CSS);
    }

    /*
      Scenario: Navigating to the next and previous pages
     */

    @When("^clicked on next button.$")
    public void click_on_next_button() {
        WebElement el = MyWebDriverUtils.findElement(driver, PAGINATION_LOCATOR, LocatorType.ID);
        if (el != null) {
            List<WebElement> lst = MyWebDriverUtils.findElements(driver, "a", LocatorType.TAG, el);
            if (lst != null) {
                System.out.println(lst.size());
                WebElement element = lst.get(lst.size() - 1);
                MyWebDriverUtils.waitContainerThenClick(driver, element);
            } else {
                Assert.fail("element is not found!");
            }
        } else {
            Assert.fail("element is not found!");
        }
    }

    @Then("^the user should be able to navigate to the next page.$")
    public void check_navigate_to_the_next_page() {
        WebElement el = MyWebDriverUtils.findElement(driver, PAGINATION_LOCATOR, LocatorType.ID);
        if (el != null) {
            List<WebElement> lst = MyWebDriverUtils.findElements(driver, "li", LocatorType.TAG, el);
            if (lst != null) {
                WebElement element = lst.get(2);
                Assert.assertEquals(element.getAttribute("class"), "active");
            } else {
                Assert.fail("element is not found!");
            }
        } else {
            Assert.fail("element is not found!");
        }
    }

    @When("^clicked on Prev button.$")
    public void click_on_prev_button() {
        click_on_next_button();

        WebElement el = MyWebDriverUtils.findElement(driver, PAGINATION_LOCATOR, LocatorType.ID);
        if (el != null) {
            List<WebElement> lst = MyWebDriverUtils.findElements(driver, "a", LocatorType.TAG, el);
            if (lst != null) {
                System.out.println(lst.size());
                WebElement element = lst.get(0);
                MyWebDriverUtils.waitContainerThenClick(driver, element);
            } else {
                Assert.fail("element is not found!");
            }
        } else {
            Assert.fail("element is not found!");
        }
    }

    @Then("^the user should be able to navigate to the Previous page.$")
    public void check_navigate_to_previos_page() {
        WebElement el = MyWebDriverUtils.findElement(driver, PAGINATION_LOCATOR, LocatorType.ID);
        if (el != null) {
            List<WebElement> lst = MyWebDriverUtils.findElements(driver, "li", LocatorType.TAG, el);
            if (lst != null) {
                WebElement element = lst.get(1);
                Assert.assertEquals(element.getAttribute("class"), "active");
            } else {
                Assert.fail("element is not found!");
            }
        } else {
            Assert.fail("element is not found!");
        }
    }

    /*
    Scenario: Checking the message of no of results displayed on current page
     */

    @When("^the user searches the results.$")
    public void user_search_results() {
        MyWebDriverUtils.enterData(driver, SEARCH_BOX_LOCATOR, LocatorType.CSS, GOOD_STR);
    }

    @Then("^the text 'Showing x to y of z entries' should be displayed on the bottom left corner of the list.$")
    public void check_message() {
        WebElement el = MyWebDriverUtils.findVisibilityElement(driver, INFO_MESSAGE_LOCATOR, LocatorType.ID);
        if (el != null) {
            String text = el.getText();
            String[] array = text.split(" ");
            array[array.length - 1] = "";
            array[1] = "x";
            array[3] = "y";
            array[5] = "z";
            text = array[0] + " " + array[1] + " " + array[2] + " " + array[3] + " " + array[4] + " " + array[5] + " " + array[6];
            Assert.assertEquals(text, "Showing x to y of z entries");
        } else {
            Assert.fail("element is not found!");
        }
    }


    /*
    Scenario: Add Compound Screen
     */

    @When("^selected Type as Test Screen$")
    public void select_test_screen_type() {
        click_on_plus_button();
        MyWebDriverUtils.selectOption(driver, Compound.TYPE_LOCATOR, LocatorType.ID, Compound.TYPE_1);
    }

    @Then("^the result box should be displayed with 'NEG' and 'POS' options and 'cutoff' text box should be displayed$")
    public void check_result_box_with_neg_and_pos_options() {

        WebElement el = MyWebDriverUtils.findElement(driver, "#form > div.modal-body > div.form-group.range.cutoff", LocatorType.CSS);
        if (el != null) {
            Assert.assertEquals(el.getAttribute("style"), "display: block;");
        } else {
            Assert.fail("element is not found!");
        }

        WebElement select = MyWebDriverUtils.findElement(driver, Compound.RESULT_LOCATOR, LocatorType.ID);
        if (select != null) {
            WebElement neg = new Select(select).getOptions().get(1);
            WebElement pos = new Select(select).getOptions().get(2);

            if (neg != null) {
                Assert.assertEquals(neg.getAttribute("style"), "display: block;");
            } else {
                Assert.fail("element is not found!");
            }

            if (pos != null) {
                Assert.assertEquals(pos.getAttribute("style"), "display: block;");
            } else {
                Assert.fail("element is not found!");
            }
        } else {
            Assert.fail("element is not found!");
        }

    }


    @When("^selected Type as Validity Testing$")
    public void select_validity_testing_type() {

    }

    @Then("^the result box should be displayed with 'NORMAL' and 'ABNORMAL' options and 'range' drop down box should be displayed$")
    public void check_normal_and_abnormal_options() {

    }


    private static final class Compound {
        private Compound() {
        }

        private static String name;
        private static String newClass;
        private static String newCutoff;
        private static String newBillingCode;
        private static String newNegativeComments;
        private static String newPositiveComments;

        private static final String NAME = "Creatinine";
        private static final String CLASS = "Narcotics";
        private static final String TYPE_1 = "Test Screen";
        private static final String TYPE_2 = "Validity Testing";
        private static final String RESULT_1 = "POS";
        private static final String RESULT_2 = "NORMAL";
        private static final String BILLING_CODE = "12345";
        private static final String ORAL_DETECTION = "24 hrs";
        private static final String URINE_DETECTION = "2 days";
        private static final String NEGATIVE_COMMENTS = "test -ve comments";
        private static final String POSITIVE_COMMENTS = "+ve test comments";
        private static final String CUTOFF = "12";
        private static final String RANGE_1 = "=";
        private static final String RANGE_2 = "between";
        private static final String CUTOFF_RANGE = "20";
        private static final String UNITS = "mg/dL";
        private static final String MIN = "10";
        private static final String MAX = "50";

        private static final String NEW_CLASS = "New_Narcotics";
        private static final String NEW_CUTOFF = "15";
        private static final String NEW_RESULT = "NEG";
        private static final String NEW_BILLING_CODE = "33552";
        private static final String NEW_ORAL_DETECTION = "3 days";
        private static final String NEW_URINE_DETECTION = "1 day";
        private static final String NEW_NEGATIVE_COMMENTS = "neg comments";
        private static final String NEW_POSITIVE_COMMENTS = "pos comments";

        private static final String NAME_LOCATOR = "name";
        private static final String CLASS_LOCATOR = "classtype";
        private static final String TYPE_LOCATOR = "type";
        private static final String RESULT_LOCATOR = "result";
        private static final String BILLING_CODE_LOCATOR = "billingCode";
        private static final String ORAL_DETECTION_LOCATOR = "detectionOral";
        private static final String URINE_DETECTION_LOCATOR = "detectionUrine";
        private static final String NEGATIVE_COMMENTS_LOCATOR = "negativeComments";
        private static final String POSITIVE_COMMENTS_LOCATOR = "positiveComments";
        private static final String CUTOFF_LOCATOR = "cutoff";
        private static final String RANGE_LOCATOR = "rangetype";
        private static final String CUTOFF_RANGE_LOCATOR = "cutoffrange";
        private static final String UNITS_LOCATOR = "units";
        private static final String MIN_LOCATOR = "min";
        private static final String MAX_LOCATOR = "max";


    }


}



