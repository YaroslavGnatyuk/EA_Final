package com.easytox.automation.steps.validating.validating_test_group;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 10.12.2016.
 */
public class ValidatingTestGroupImpl {

    private static final String PASSWORD = "P@ssw0rd123";
    private static final String LOGIN = "lavanya1";
    private static final String FIND_USERNAME = "j_username";
    private static final String FIND_LOGIN = "j_password";
    private static final String LOGIN_PAGE_URL = "http://bmtechsol.com:8080/easytox/";
    private static final String LOGIN_BUTTON_XPATH = "//*[@id=\"loginform\"]/div[3]/div/button";

    private static final String VALIDITY_TEST_GROUP_URL = "http://bmtechsol.com:8080/easytox/testCode/validitylist";
    private static final int TIME_OUT_IN_SECONDS = 10;

    private static final String CELLS_LOCATOR = "./*";
    private static final String ROWS_LOCATOR = "tr";
    private static final String TABLE_LOCATOR = "example";
    private static final String LIST_LOCATOR = "li";

    private static final String ATTRIBUTE_VALUE_LOCATOR = "value";
    private static final String ATTRIBUTE_CLASS_LOCATOR = "class";
    private static final String ATTRIBUTE_CLASS_VALUE = "active";
    private static final int TIME_STOP = 2000;

    private static String testData;
    private static ArrayList<String> tableData = new ArrayList<String>();

    private WebDriver driver;

    public ValidatingTestGroupImpl() {
        DriverBase.instantiateDriverObject();
        driver = DriverBase.getDriver();
    }

    /*
       Scenario: Search Box
     */
    @Given("^the user is Validity Test Group page$")
    public void the_user_is_validity_test_group_page() {
        if (!driver.getCurrentUrl().contains(LOGIN_PAGE_URL)) {
            authorization();
        }

        driver.navigate().to(VALIDITY_TEST_GROUP_URL);
    }

    @When("^entered some text in the Search box in Validity Test Group page$")
    public void entered_some_text_in_the_Search_box() {
        WebElement firstName = MyWebDriverUtils.findElement(driver, SearchBox.FIRST_NAME_LOCATOR, LocatorType.NAME);
        if (firstName != null) {
            firstName.clear();
            firstName.sendKeys(SampleDataUtil.getFirstName());
        } else {
            Assert.fail("firstName is null!");
        }

        WebElement lastName = MyWebDriverUtils.findElement(driver, SearchBox.LAST_NAME_LOCATOR, LocatorType.NAME);
        if (lastName != null) {
            lastName.clear();
            lastName.sendKeys(SampleDataUtil.getLastName());
        } else {
            Assert.fail("lastName is null!");
        }

        WebElement dateOfBirth = MyWebDriverUtils.findElement(driver, SearchBox.DATE_OF_BIRTH_LOCATOR, LocatorType.NAME);
        if (dateOfBirth != null) {
            dateOfBirth.clear();
            dateOfBirth.sendKeys(SearchBox.DATE_OF_BIRTH_VALUE);
        } else {
            Assert.fail("dateOfBirth is null!");
        }

        new Select(driver.findElement(By.id(SearchBox.SELECT_STATUS_LOCATOR)))
                .selectByVisibleText(SearchBox.SELECT_STATUS_VALUE);

        new Select(driver.findElement(By.id(SearchBox.SELECT_PHYSICIAN_LOCATOR)))
                .selectByVisibleText(SearchBox.SELECT_PHYSICIAN_VALUE);

        WebElement caseAcc = MyWebDriverUtils.findElement(driver, SearchBox.CASE_ACC_LOCATOR, LocatorType.CSS);
        if (caseAcc != null) {
            caseAcc.clear();
            caseAcc.sendKeys(StringUtils.generateRandom());
        } else {
            Assert.fail("caseAcc is null!");
        }


        WebElement medRec = MyWebDriverUtils.findElement(driver, SearchBox.MED_REC_LOCATOR, LocatorType.CSS);
        if (medRec != null) {
            medRec.clear();
            medRec.sendKeys(StringUtils.generateRandom());
        } else {
            Assert.fail("medRec is null!");
        }

        WebElement searchButton = MyWebDriverUtils.findElement(driver, SearchBox.SEARCH_BUTTON_LOCATOR, LocatorType.ID);
        if (searchButton != null) {
            searchButton.sendKeys(Keys.ENTER);
        } else {
            Assert.fail("searchButton is null!");
        }
    }

    @Then("^user should be able to view the search results on page$")
    public void user_should_be_able_to_view_the_search_results() {
        WebElement table = MyWebDriverUtils.findElement(driver, SearchBox.TABLE_OF_RESULT_LOCATOR, LocatorType.CSS);

        List<WebElement> allRows = null;
        if (table != null) {
            allRows = MyWebDriverUtils.findElements(driver, ROWS_LOCATOR, LocatorType.TAG, table);
            if (allRows != null) {
                Assert.assertTrue(allRows.size() == 1);
            } else {
                Assert.fail("allRows is null!");
            }
        } else {
            Assert.fail("table is null!");
        }


    }

    /*
      Scenario: Adding a Drug
     */

    @When("^clicked on ‘\\+’ button next to search box in Validity Test Group page$")
    public void click_on_plus_button() {
        WebElement el = MyWebDriverUtils.findElement(driver, TestCode.ADD_VALIDITY_TEST_CODE_BUTTON_LOCATOR, LocatorType.ID);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }
    }

    @Then("^Add Validity Test Code popup should be displayed$")
    public void check_popup_() {
        WebElement titleElement = MyWebDriverUtils.findElement(driver, TestCode.TITLE_LOCATOR, LocatorType.ID);
        String title = null;
        if (titleElement != null) {
            title = titleElement.getText();
        }
        Assert.assertEquals(title, TestCode.TITLE_VALUE);
    }

    @When("^Add Validity Test Code popup is displayed$")
    public void add_test_code_popup_is_displayed() {
        WebElement el = MyWebDriverUtils.findElement(driver, TestCode.ADD_VALIDITY_TEST_CODE_BUTTON_LOCATOR, LocatorType.ID);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }
    }

    @Then("^user should be able to enter the data in the fields$")
    public void check_the_possibility_of_data_entry() {
        String testCodeData = StringUtils.generateRandom();

        WebElement testCode = MyWebDriverUtils.findElement(driver, TestCode.TEST_CODE_LOCATOR, LocatorType.ID);
        if (testCode != null) {
            testCode.clear();
            testCode.sendKeys(testCodeData);
            String testValue = testCode.getAttribute(ATTRIBUTE_VALUE_LOCATOR);
            Assert.assertEquals(testValue, testCodeData);
        } else {
            Assert.fail("testCode is null!");
        }

        WebElement description = MyWebDriverUtils.findElement(driver, TestCode.DESCRIPTION_LOCATOR, LocatorType.ID);
        if (description != null) {
            description.clear();
            description.sendKeys(TestCode.DESCRIPTION_VALUE);
            String descriptionValue = description.getAttribute(ATTRIBUTE_VALUE_LOCATOR);
            Assert.assertEquals(descriptionValue, TestCode.DESCRIPTION_VALUE);
        } else {
            Assert.fail("description is null!");
        }

        WebElement compounds = MyWebDriverUtils.findElement(driver, TestCode.COMPOUNDS_LOCATOR, LocatorType.CSS);
        if (compounds != null) {
            compounds.clear();
            compounds.sendKeys(TestCode.COMPOUNDS_VALUE);
            String compoundsValue = compounds.getAttribute(ATTRIBUTE_VALUE_LOCATOR);
            Assert.assertEquals(compoundsValue, TestCode.COMPOUNDS_VALUE);
        } else {
            Assert.fail("compounds is null!");
        }
    }

    @When("^Add Validity Test Code popup is displayed and user entered all the required fields and click on submit$")
    public void submit_all_data() throws InterruptedException {
        WebElement el = MyWebDriverUtils.findElement(driver, TestCode.ADD_VALIDITY_TEST_CODE_BUTTON_LOCATOR, LocatorType.ID);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }

        testData = StringUtils.generateRandom();

        WebElement testCode = MyWebDriverUtils.findElement(driver, TestCode.TEST_CODE_LOCATOR, LocatorType.ID);
        if (testCode != null) {
            testCode.clear();
            testCode.sendKeys(testData);
        } else {
            Assert.fail("testCode is null!");
        }

        WebElement description = MyWebDriverUtils.findElement(driver, TestCode.DESCRIPTION_LOCATOR, LocatorType.ID);
        if (description != null) {
            description.clear();
            description.sendKeys(TestCode.DESCRIPTION_VALUE);
        } else {
            Assert.fail("description is null!");
        }

        WebElement compounds = MyWebDriverUtils.findElement(driver, TestCode.COMPOUNDS_LOCATOR, LocatorType.CSS);
        if (compounds != null) {
            compounds.clear();
            compounds.sendKeys(TestCode.COMPOUNDS_VALUE);
        } else {
            Assert.fail("compounds is null!");
        }

        WebElement tst = MyWebDriverUtils.findElement(driver, TestCode.TST_LOCATOR, LocatorType.CSS);
        if (tst != null) {
            tst.click();
        } else {
            Assert.fail("tst is null!");
        }

        WebElement submit = MyWebDriverUtils.findElement(driver, TestCode.SUBMIT_BUTTON_LOCATOR, LocatorType.CSS);
        if (submit != null) {
            submit.click();
        } else {
            Assert.fail("submit is null!");
        }

    }

    @Then("^user should be able to submit the data and the added test code should be displayed on the list$")
    public void check_add_and_submit_data() {
        try {
            final WebElement table = MyWebDriverUtils.findElement(driver, TABLE_LOCATOR, LocatorType.ID);
            if (table != null) {

                List<WebElement> listRows = MyWebDriverUtils.findElements(driver, ROWS_LOCATOR, LocatorType.TAG, table);
                if (listRows != null) {
                    for (final WebElement row : listRows) {
                        List<WebElement> listCells = MyWebDriverUtils.findElements(driver, CELLS_LOCATOR, LocatorType.TAG, row);
                        if (listCells != null) {
                            for (WebElement cell : listCells) {
                                String cellText = cell.getText();
                                if (cellText.equals(testData)) {
                                    Assert.assertEquals(listCells.get(1).getText(), TestCode.DESCRIPTION_VALUE);
                                    Assert.assertEquals(listCells.get(2).getText(), TestCode.COMPOUNDS_VALUE);
                                    return;
                                }
                            }
                        } else {
                            Assert.fail("listCells is null!");
                        }
                    }
                } else {
                    Assert.fail("listRows is null!");
                }
            } else {
                Assert.fail("table is null!");
            }
        } catch (StaleElementReferenceException ex) {
            check_add_and_submit_data();
        }

    }

    @When("^Add Validity Test Code popup is displayed and user is not entered all the required fields and click on submit$")
    public void check_submit_with_empty_fields() {
        WebElement el = MyWebDriverUtils.findElement(driver, TestCode.ADD_VALIDITY_TEST_CODE_BUTTON_LOCATOR, LocatorType.ID);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }

        WebElement testCode = MyWebDriverUtils.findElement(driver, TestCode.TEST_CODE_LOCATOR, LocatorType.ID);
        if (testCode != null) {
            testCode.clear();
            testCode.sendKeys(StringUtils.generateRandom());
        } else {
            Assert.fail("testCode is null!");
        }


        WebElement description = MyWebDriverUtils.findElement(driver, TestCode.DESCRIPTION_LOCATOR, LocatorType.ID);
        if (description != null) {
            description.clear();
            description.sendKeys(TestCode.DESCRIPTION_VALUE);
        } else {
            Assert.fail("description is null!");
        }


        WebElement submit = MyWebDriverUtils.findElement(driver, TestCode.SUBMIT_BUTTON_LOCATOR, LocatorType.CSS);
        if (submit != null) {
            submit.click();
        } else {
            Assert.fail("submit is null!");
        }
    }

    @Then("^user should be not be able to submit the data and the missing fields should be displayed with red color$")
    public void user_do_not_submit_the_data() throws InterruptedException {
        String title = null;
        WebElement webElement = MyWebDriverUtils.findElement(driver, TestCode.TITLE_LOCATOR, LocatorType.ID);
        if (webElement != null) {
            title = webElement.getText();
        }
        Assert.assertEquals(title, ValidatingTestGroupImpl.TestCode.TITLE_VALUE);

        WebElement helpBlock = MyWebDriverUtils.findElement(driver, TestCode.COMPOUND_HELP_BLOCK_LOCATOR, LocatorType.CSS);
        if (helpBlock != null) {
            Assert.assertEquals(helpBlock.getAttribute(TestCode.HELP_BLOCK_ATTRIBUTE_LOCATOR), TestCode.COMPOUND_HELP_BLOCK_VALUE);
        } else {
            Assert.fail("helpBlock is null!");
        }
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        WebElement submit = driver.findElement(By.cssSelector(TestCode.SUBMIT_BUTTON_LOCATOR));

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && submit != null) {
            Assert.assertEquals(submit.getAttribute(TestCode.SUBMIT_ATTRIBUTE_LOCATOR), TestCode.SUBMIT_ATTRIBUTE_VALUE);
        } else {
            Assert.fail("flag is false or submit is null!");
        }

    }

    @When("^Add Validity Test Code popup is displayed and the user clicks on ‘Close’ button$")
    public void clicks_on_close_button() {
        WebElement el = MyWebDriverUtils.findElement(driver, TestCode.ADD_VALIDITY_TEST_CODE_BUTTON_LOCATOR, LocatorType.ID);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }

        WebElement closeButton = MyWebDriverUtils.findElement(driver, TestCode.CLOSE_BUTTON_LOCATOR, LocatorType.CSS);
        if (closeButton != null) {
            closeButton.click();
        }

    }

    @Then("^the popup should be closed and the user should land on the Validity Test Group page$")
    public void popup_closed_and_user_should_land_on_the_Compound_Test_Group_page_() {
        boolean flag = false;

        String currentUrlFromDriver = driver.getCurrentUrl();
        if (currentUrlFromDriver.equals(VALIDITY_TEST_GROUP_URL) || currentUrlFromDriver.equals(VALIDITY_TEST_GROUP_URL + "#")) {
            flag = true;
        }
        Assert.assertTrue(flag);
    }

    @When("^Add Validity Test Code popup is displayed and the user clicks on ‘x’ button$")
    public void clicks_on_x_button() {
        WebElement el = MyWebDriverUtils.findElement(driver, TestCode.ADD_VALIDITY_TEST_CODE_BUTTON_LOCATOR, LocatorType.ID);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }

        WebElement xButton = MyWebDriverUtils.findElement(driver, ValidatingTestGroupImpl.TestCode.X_BUTTON_LOCATOR, LocatorType.CSS);
        if (xButton != null) {
            xButton.click();
        }
    }


    /*
      Scenario: No of records to be displayed on the page
     */

    @When("^clicked on dropdown that shows (.*) to be displayed on the Validity Test Group page$")
    public void click_on_dropdown(String number) {
        new Select(driver.findElement(By.name(TestCode.DROP_DOWN_LOCATOR))).selectByVisibleText(number);


    }

    @Then("^user should be able to view and select the options from the list and the corresponding (.*) of records should be displayed on the Validity Test Group page.$")
    public void check_number_of_records(String number) throws InterruptedException {
        WebElement table = driver.findElement(By.id(TABLE_LOCATOR));
        int size = table.findElements(By.tagName(ROWS_LOCATOR)).size() - 1;

        WebElement element = driver.findElement(By.id(ValidatingTestGroupImpl.TestCode.PAGINATE_LOCATOR));
        List<WebElement> list = element.findElements(By.tagName(LIST_LOCATOR));

        if (number.equals("All")) {
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
      Scenario: Checking the sorting order of the displayed results
     */

    @When("^clicked on Validity Test Code column of the list$")
    public void click_on_test_code_column() throws InterruptedException {
        Thread.sleep(TIME_STOP);
        driver.findElement(By.cssSelector(ValidatingTestGroupImpl.TestCode.TEST_CODE_COLUMN_LOCATOR)).click();
    }

    @Then("^the list should be displayed in the alphabetical order on the Validity Test Group page$")
    public void display_in_the_alphabetical_orders() {
        int j = 0;

        WebElement table = driver.findElement(By.id(TABLE_LOCATOR));

        List<WebElement> allRows = table.findElements(By.tagName(ROWS_LOCATOR));


        if (allRows.get(0).findElements(By.xpath(CELLS_LOCATOR)).get(0)
                .getAttribute(ValidatingTestGroupImpl.TestCode.SORT_ATTRIBUTE_LOCATOR) != null &&
                allRows.get(0).findElements(By.xpath(CELLS_LOCATOR)).get(0)
                        .getAttribute(ValidatingTestGroupImpl.TestCode.SORT_ATTRIBUTE_LOCATOR).equals(ValidatingTestGroupImpl.TestCode.SORT_ATTRIBUTE_VALUE)) {
            j = 0;
        }

        if (allRows.get(0).findElements(By.xpath(CELLS_LOCATOR)).get(1)
                .getAttribute(ValidatingTestGroupImpl.TestCode.SORT_ATTRIBUTE_LOCATOR) != null &&
                allRows.get(0).findElements(By.xpath(CELLS_LOCATOR)).get(1)
                        .getAttribute(ValidatingTestGroupImpl.TestCode.SORT_ATTRIBUTE_LOCATOR).equals(ValidatingTestGroupImpl.TestCode.SORT_ATTRIBUTE_VALUE)) {
            j = 1;
        }

        if (allRows.get(0).findElements(By.xpath(CELLS_LOCATOR)).get(2)
                .getAttribute(ValidatingTestGroupImpl.TestCode.SORT_ATTRIBUTE_LOCATOR) != null &&
                allRows.get(0).findElements(By.xpath(CELLS_LOCATOR)).get(2)
                        .getAttribute(ValidatingTestGroupImpl.TestCode.SORT_ATTRIBUTE_LOCATOR).equals(ValidatingTestGroupImpl.TestCode.SORT_ATTRIBUTE_VALUE)) {
            j = 2;
        }

        String temp = allRows.get(1).findElements(By.xpath(CELLS_LOCATOR)).get(j).getText();

        for (int i = 2; i < allRows.size(); i++) {
            if (temp.toLowerCase().contains(allRows.get(i).findElements(By.xpath(CELLS_LOCATOR)).get(j).getText().toLowerCase())) {
                Assert.assertTrue(true);
            } else {
                int order = temp.toLowerCase().compareTo(allRows.get(i).findElements(By.xpath(CELLS_LOCATOR)).get(j).getText().toLowerCase());
                Assert.assertTrue(order <= 0);
            }

        }

    }

    @When("^clicked on Description column of the list on the Validity Test Group page$")
    public void click_on_description_column() throws InterruptedException {
        Thread.sleep(TIME_STOP);
        driver.findElement(By.cssSelector(ValidatingTestGroupImpl.TestCode.DESCRIPTION_COLUMN_LOCATOR)).click();
    }

    @When("^clicked on Compounds column of the list on the Validity Test Group page$")
    public void click_on_compounds_column() throws InterruptedException {
        Thread.sleep(TIME_STOP);
        driver.findElement(By.cssSelector(ValidatingTestGroupImpl.TestCode.COMPOUNDS_COLUMN_LOCATOR)).click();
    }

    /*
      Scenario: Click on Edit under Action Column
     */

    @When("^clicked on Edit button under Action column on the Validity Test Group page$")
    public void click_on_edit_button() throws InterruptedException {
        Thread.sleep(TIME_STOP);
        driver.findElement(By.cssSelector(ValidatingTestGroupImpl.TestCode.EDIT_BUTTON_LOCATOR)).click();
    }

    @Then("^“Edit Validity Test Code” popup should be displayed$")
    public void check_edit_test_code_popup() throws InterruptedException {
        WebElement webElement = MyWebDriverUtils.findElement(driver, ValidatingTestGroupImpl.TestCode.TITLE_LOCATOR, LocatorType.ID);
        if (webElement != null) {
            String title = webElement.getText();
            Assert.assertEquals(title, ValidatingTestGroupImpl.TestCode.EDIT_VALIDITY_TEST_CODE);
        } else {
            Assert.fail("webElement is null!");
        }

        WebElement testCode = MyWebDriverUtils.findElement(driver, ValidatingTestGroupImpl.TestCode.TEST_CODE_LOCATOR, LocatorType.ID);
        if (testCode != null) {
            Assert.assertTrue(testCode.getAttribute(ATTRIBUTE_VALUE_LOCATOR) != null);
        } else {
            Assert.fail("testCode is null!");
        }

        WebElement description = MyWebDriverUtils.findElement(driver, ValidatingTestGroupImpl.TestCode.DESCRIPTION_LOCATOR, LocatorType.ID);
        if (description != null) {
            Assert.assertTrue(description.getAttribute(ATTRIBUTE_VALUE_LOCATOR) != null);
        } else {
            Assert.fail("description is null!");
        }

        WebElement compounds = MyWebDriverUtils.findElement(driver, ValidatingTestGroupImpl.TestCode.COMPOUND_EDIT_LOCATOR, LocatorType.CSS);
        if (compounds != null) {
            Assert.assertTrue(compounds.getText() != null);
        } else {
            Assert.fail("compounds is null!");
        }
    }

    @When("^clicked on Edit under Actions column and Edit Validity Test Code is displayed$")
    public void click_on_edit_under_actions_column() throws InterruptedException {
        Thread.sleep(TIME_STOP);
        driver.findElement(By.cssSelector(ValidatingTestGroupImpl.TestCode.EDIT_BUTTON_LOCATOR)).click();

        check_edit_test_code_popup();
    }

    @Then("^user should be able to edit the data on the Validity Test Group page$")
    public void user_should_be_able_to_edit_the_data() {
        edit();
    }

    @When("^Edit Validity Test Code popup is displayed and user can edit the data and click on update button$")
    public void update_test_code() throws InterruptedException {
        Thread.sleep(TIME_STOP);
        driver.findElement(By.cssSelector(ValidatingTestGroupImpl.TestCode.EDIT_BUTTON_LOCATOR)).click();

        edit();

        WebElement updateButton = MyWebDriverUtils.findElement(driver, ValidatingTestGroupImpl.TestCode.UPDATE_BUTTON_LOCATOR, LocatorType.CSS);
        if (updateButton != null) {
            updateButton.click();
        } else {
            Assert.fail("updateButton is null!");
        }

    }

    @Then("^user should be able to update the data and the edited  validity Test Code should be displayed on the list$")
    public void check_list_with_edited_data() throws InterruptedException {
        Thread.sleep(TIME_STOP);

        Assert.assertTrue(driver.findElement(By.cssSelector(ValidatingTestGroupImpl.TestCode.UPDATE_HELP_BLOCK_LOCATOR)).isDisplayed());
        boolean flag = false;
        WebElement table = driver.findElement(By.id(TABLE_LOCATOR));

        List<WebElement> allRows = table.findElements(By.tagName(ROWS_LOCATOR));
        List<WebElement> cells = allRows.get(1).findElements(By.xpath(CELLS_LOCATOR));
        if (cells.get(1).getText().equals(ValidatingTestGroupImpl.TestCode.DESCRIPTION_NEW_VALUE) && cells.get(2).getText().equals(ValidatingTestGroupImpl.TestCode.COMPOUNDS_VALUE)) {
            flag = true;
        }
        Assert.assertTrue(flag);
    }

    @When("^Edit Validity Test Code popup is displayed and the user clicks on ‘Close’ button$")
    public void click_on_close_button_in_edit_test_code_popup() throws InterruptedException {
        Thread.sleep(TIME_STOP);
        driver.findElement(By.cssSelector(ValidatingTestGroupImpl.TestCode.EDIT_BUTTON_LOCATOR)).click();


        WebElement closeButton = MyWebDriverUtils.findElement(driver, ValidatingTestGroupImpl.TestCode.EDIT_CLOSE_BUTTON_LOCATOR, LocatorType.CSS);
        if (closeButton != null) {
            closeButton.click();
        } else {
            Assert.fail("closeButton is null!");
        }
    }

    @When("^Edit Validity Test Code popup is displayed and the user clicks on ‘’x’ button$")
    public void click_on_x_in_edit_test_code_popup() throws InterruptedException {
        Thread.sleep(TIME_STOP);
        driver.findElement(By.cssSelector(ValidatingTestGroupImpl.TestCode.EDIT_BUTTON_LOCATOR)).click();

        WebElement xButton = MyWebDriverUtils.findElement(driver, ValidatingTestGroupImpl.TestCode.EDIT_X_BUTTON_LOCATOR, LocatorType.CSS);
        if (xButton != null) {
            xButton.click();
        } else {
            Assert.fail("xButton is null!");
        }
    }

    /*
      Scenario: Navigating to the next and previous pages
     */

    @When("^clicked on next button on the Validity Test Group page$")
    public void click_on_next_button() throws InterruptedException {
        Thread.sleep(TIME_STOP);
        WebElement table = MyWebDriverUtils.findElement(driver, TABLE_LOCATOR, LocatorType.ID);

        if (table != null) {

            List<WebElement> allRows = table.findElements(By.tagName(ROWS_LOCATOR));
            tableData.clear();
            for (int i = 1; i < allRows.size(); i++) {

                String cellText = allRows.get(i).findElements(By.xpath(CELLS_LOCATOR)).get(0).getText();
                tableData.add(cellText);
            }

            driver.findElement(By.cssSelector(ValidatingTestGroupImpl.TestCode.NEXT_BUTTON_LOCATOR)).click();
        } else {
            Assert.fail("table is null!");
        }
    }

    @Then("^the user should be able to navigate to the next page on the Validity Test Group page$")
    public void navigate_to_the_next_page() {
        boolean flag = false;

        checkList();

        WebElement el = driver.findElement(By.xpath(ValidatingTestGroupImpl.TestCode.PAGINATE_2_LOCATOR));

        if (el.getAttribute(ATTRIBUTE_CLASS_LOCATOR) != null &&
                el.getAttribute(ATTRIBUTE_CLASS_LOCATOR).equals(ATTRIBUTE_CLASS_VALUE)) {
            flag = true;
        }
        Assert.assertTrue(flag);
    }

    @When("^clicked on Prev button on the Validity Test Group page$")
    public void click_on_prev_button() throws InterruptedException {

        Thread.sleep(TIME_STOP);
        driver.findElement(By.cssSelector(ValidatingTestGroupImpl.TestCode.NEXT_BUTTON_LOCATOR)).click();

        WebElement table = MyWebDriverUtils.findElement(driver, TABLE_LOCATOR, LocatorType.ID);
        if (table != null) {
            List<WebElement> allRows = table.findElements(By.tagName(ROWS_LOCATOR));
            tableData.clear();
            for (int i = 1; i < allRows.size(); i++) {
                String cellText = allRows.get(i).findElements(By.xpath(CELLS_LOCATOR)).get(0).getText();
                tableData.add(cellText);
            }
        }

        WebElement prevButton = MyWebDriverUtils.findElement(driver, ValidatingTestGroupImpl.TestCode.PREVIOUS_BUTTON_LOCATOR, LocatorType.CSS);
        if (prevButton != null) {
            prevButton.click();
        } else {
            Assert.fail("prevButton is null!");
        }
    }

    @Then("^the user should be able to navigate to the Previous page on the Validity Test Group page$")
    public void navigate_to_previous_page() {
        boolean flag = false;

        checkList();
        WebElement el = driver.findElement(By.xpath(ValidatingTestGroupImpl.TestCode.PAGINATE_1_LOCATOR));

        if (el.getAttribute(ATTRIBUTE_CLASS_LOCATOR) != null &&
                el.getAttribute(ATTRIBUTE_CLASS_LOCATOR).equals(ATTRIBUTE_CLASS_VALUE)) {
            flag = true;
        }
        Assert.assertTrue(flag);

    }

     /*
       Scenario: Checking the message of no of results displayed on current page
     */

    @When("^the user searches the results on the Validity Test Group page$")
    public void user_searches_the_results() throws InterruptedException {
        WebElement input = MyWebDriverUtils.findElement(driver, ValidatingTestGroupImpl.TestCode.SEARCH_INPUT_LOCATOR, LocatorType.XPATH);
        if (input != null) {
            input.sendKeys(StringUtils.generateRandom());
        } else {
            Assert.fail("input is null!");
        }

    }

    @Then("^the text “Showing x to y of z entries” should be displayed on the bottom left corner of the list on the Validity Test Group page.$")
    public void show_message() {
        WebElement webElement = MyWebDriverUtils.findElement(driver, ValidatingTestGroupImpl.TestCode.MESSAGE_INFO_LOCATOR, LocatorType.ID);
        if (webElement != null) {
            String text = webElement.getText();
            boolean flag = text.contains(ValidatingTestGroupImpl.TestCode.MESSAGE_VALUE);
            Assert.assertTrue(flag);
        } else {
            Assert.fail("webElement is null!");
        }

    }

    /*
      Scenario: Buttons on the Validity Test Group page
     */

    @When("^clicked on maximize button on the Validity Test Group page$")
    public void click_on_maximize_buttons(){
        WebElement el = MyWebDriverUtils.findElement(driver, TestCode.MAXIMIZE_BUTTON_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }
    }

    @Then("^the screen should be maximized on the Validity Test Group page$")
    public void the_screen_should_be_maximized(){
        WebElement el = MyWebDriverUtils.findElement(driver, TestCode.FULL_SCREEN_LOCATOR, LocatorType.ID);
        if(el != null){
            Assert.assertEquals(el.getAttribute(ATTRIBUTE_CLASS_LOCATOR), TestCode.FULL_SCREEN_VALUE);
        }

    }

    @When("^the screen is maximized and clicked on minimize button on the Validity Test Group page$")
    public void the_screen_is_maximized_and_clicked_on_minimize_button(){
        WebElement el = MyWebDriverUtils.findElement(driver, TestCode.MAXIMIZE_BUTTON_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }

        WebElement button = MyWebDriverUtils.findElement(driver, TestCode.MAXIMIZE_BUTTON_LOCATOR, LocatorType.CSS);
        if(button != null){
            button.click();
        } else {
            Assert.fail("button is null!");
        }

    }

    @Then("^the screen should be displayed in normal mode on the Validity Test Group page$")
    public void the_screen_should_be_displayed_in_normal_mode(){
        WebElement el = MyWebDriverUtils.findElement(driver, TestCode.FULL_SCREEN_LOCATOR, LocatorType.ID);
        if (el != null) {
            Assert.assertEquals(el.getAttribute(ATTRIBUTE_CLASS_LOCATOR), ValidatingTestGroupImpl.TestCode.NORMAL_SCREEN_VALUE);
        } else {
            Assert.fail("el is null!");
        }

    }

    @When("^clicked on ‘-‘ button on the Validity Test Group page$")
    public void click_on_sidebar_button(){
        WebElement el = MyWebDriverUtils.findElement(driver, TestCode.SIDEBAR_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("el is null!");
        }
    }

    @Then("^the list should be hidden on the Validity Test Group page$")
    public void the_list_should_be_hidden(){
        WebElement el = MyWebDriverUtils.findElement(driver, TestCode.SIDEBAR_ACTIVE_LOCATOR, LocatorType.CSS);
        if(el != null){
            Assert.assertEquals(el.getAttribute(ATTRIBUTE_CLASS_LOCATOR), TestCode.SIDEBAR_ACTIVE_VALUE);
        }
    }

    @When("^the list is hidden and clicked on ‘\\+‘ button on the Validity Test Group page$")
    public void the_list_is_hidden_and_clicked_on_refresh_button(){
        WebElement el = MyWebDriverUtils.findElement(driver, TestCode.SIDEBAR_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("el is null!");
        }

        WebElement refreshButton = MyWebDriverUtils.findElement(driver, TestCode.REFRESH_BUTTON_LOCATOR, LocatorType.CSS);
        if(refreshButton != null){
            refreshButton.click();
        } else{
            Assert.fail("refreshButton is null!");
        }
    }

    @Then("^the list should be shown on the Validity Test Group page$")
    public void the_list_should_be_shown(){
        WebElement el = MyWebDriverUtils.findElement(driver, TestCode.SIDEBAR_LOCATOR, LocatorType.CSS);

        if(el != null){
            Assert.assertEquals(el.getAttribute(ATTRIBUTE_CLASS_LOCATOR), TestCode.SIDEBAR_VALUE);
        } else{
            Assert.fail("el is null!");
        }
    }

    @When("^the list is hidden and clicked on ‘x‘ button on the Validity Test Group page$")
    public void the_list_is_hidden_and_clicked_on_maximize_button(){
        WebElement el = MyWebDriverUtils.findElement(driver, TestCode.SIDEBAR_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = MyWebDriverUtils.waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("el is null!");
        }

        WebElement maxButton = MyWebDriverUtils.findElement(driver, TestCode.MAXIMIZE_BUTTON_LOCATOR, LocatorType.CSS);
        if(maxButton != null){
            maxButton.click();
        } else {
            Assert.fail("maxButton is null!");
        }
    }

    @Then("^the list should be closed on the Validity Test Group page$")
    public void the_list_should_be_closed(){
        WebElement el = MyWebDriverUtils.findElement(driver, TestCode.FULL_SCREEN_LOCATOR, LocatorType.ID);
        if(el != null){
            Assert.assertEquals(el.getAttribute(ATTRIBUTE_CLASS_LOCATOR), ValidatingTestGroupImpl.TestCode.FULL_SCREEN_VALUE);
        } else {
            Assert.fail("el is null!");
        }

        WebElement el1 = MyWebDriverUtils.findElement(driver, TestCode.SIDEBAR_ACTIVE_LOCATOR, LocatorType.CSS);
        if(el1 != null){
            Assert.assertEquals(el1.getAttribute(ATTRIBUTE_CLASS_LOCATOR), ValidatingTestGroupImpl.TestCode.SIDEBAR_ACTIVE_VALUE);
        } else {
            Assert.fail("el1 is null!");
        }
    }


    private static final class SearchBox {
        private static final String FIRST_NAME_LOCATOR = "firstName";
        private static final String LAST_NAME_LOCATOR = "lastName";
        private static final String DATE_OF_BIRTH_LOCATOR = "dateOfBirth";
        private static final String SELECT_STATUS_LOCATOR = "statusFlag";
        private static final String SELECT_PHYSICIAN_LOCATOR = "physician";
        private static final String CASE_ACC_LOCATOR = "#searchform > div:nth-child(3) > div:nth-child(1) > input";
        private static final String MED_REC_LOCATOR = "#searchform > div:nth-child(3) > div:nth-child(2) > input";
        private static final String SEARCH_BUTTON_LOCATOR = "searchbtn";
        private static final String TABLE_OF_RESULT_LOCATOR = "#searchresults > div > table";

        private static final String DATE_OF_BIRTH_VALUE = "12/08/1993";
        private static final String SELECT_STATUS_VALUE = "InProcess";
        private static final String SELECT_PHYSICIAN_VALUE = "Madhukar Narahari";
    }

    private static final class TestCode {
        private static final String ADD_VALIDITY_TEST_CODE_BUTTON_LOCATOR = "add";
        private static final String CONTAINER_LOCATOR = "loadingDiv";
        private static final String TITLE_LOCATOR = "exampleModalLabel";
        private static final String TEST_CODE_LOCATOR = "test_code";
        private static final String DESCRIPTION_LOCATOR = "description";
        private static final String COMPOUNDS_LOCATOR = "#compounds1 > span > span.selection > span > ul > li > input";
        private static final String COMPOUNDS_EDIT_LOCATOR = "#form1 > div.modal-body > div.form-group.has-error > div > span > span.selection > span > ul > li > input";
        private static final String TST_LOCATOR = "li:nth-child(1).select2-results__option.select2-results__option--highlighted";
        private static final String SUBMIT_BUTTON_LOCATOR = "#form > div.modal-footer > button.btn.btn-primary.btn-md";
        private static final String COMPOUND_HELP_BLOCK_LOCATOR = "#form > div.modal-body > div:nth-child(3) > div > small";
        private static final String HELP_BLOCK_ATTRIBUTE_LOCATOR = "data-bv-result";
        private static final String SUBMIT_ATTRIBUTE_LOCATOR = "disabled";
        private static final String CLOSE_BUTTON_LOCATOR = "#form > div.modal-footer > button.btn.btn-default";
        private static final String X_BUTTON_LOCATOR = "#addTestcodediv > div > button > span";
        private static final String TEST_CODE_COLUMN_LOCATOR = "#example > thead > tr > th:nth-child(1)";
        private static final String DESCRIPTION_COLUMN_LOCATOR = "#example > thead > tr > th:nth-child(2)";
        private static final String COMPOUNDS_COLUMN_LOCATOR = "#example > thead > tr > th:nth-child(3)";
        private static final String SORT_ATTRIBUTE_LOCATOR = "aria-sort";
        private static final String SORT_ATTRIBUTE_VALUE = "ascending";
        private static final String EDIT_BUTTON_LOCATOR = "#editbutton > i";
        private static final String COMPOUND_EDIT_LOCATOR = "#form1 > div.modal-body > div:nth-child(4) > div > span > span.selection > span > ul > li.select2-selection__choice";
        private static final String COMPOUND_X_LOCATOR = "#form1 > div.modal-body > div:nth-child(4) > div > span > span.selection > span > ul > span";
        private static final String COMPOUND_SELECT_LOCATOR = "li:nth-child(1).select2-results__option.select2-results__option--highlighted";
        private static final String UPDATE_BUTTON_LOCATOR = "#form1 > div.modal-footer > button.btn.btn-primary.btn-md";
        private static final String UPDATE_HELP_BLOCK_LOCATOR = "#maincontentdiv > div.page-body > div.alert.alert-success.fade.in";
        private static final String EDIT_CLOSE_BUTTON_LOCATOR = "#form1 > div.modal-footer > button.btn.btn-default";
        private static final String EDIT_X_BUTTON_LOCATOR = "#editTestcodediv > div > button > span";
        private static final String NEXT_BUTTON_LOCATOR = "#example_paginate > ul > li.next > a";
        private static final String PREVIOUS_BUTTON_LOCATOR = "#example_paginate > ul > li.prev > a";
        private static final String PAGINATE_1_LOCATOR = "//*[@id=\"example_paginate\"]/ul/li[2]";
        private static final String PAGINATE_2_LOCATOR = "//*[@id=\"example_paginate\"]/ul/li[3]";
        private static final String MAXIMIZE_BUTTON_LOCATOR = "#fullscreen-toggler > i";
        private static final String FULL_SCREEN_LOCATOR = "fullscreen-toggler";
        private static final String SIDEBAR_LOCATOR = "#maincontentdiv > div.page-header.position-relative > div.header-buttons > a.sidebar-toggler";
        private static final String SIDEBAR_ACTIVE_LOCATOR = "#maincontentdiv > div.page-header.position-relative > div.header-buttons > a.sidebar-toggler.active";
        private static final String REFRESH_BUTTON_LOCATOR = "#refresh-toggler";
        private static final String SEARCH_INPUT_LOCATOR = "//*[@id=\"example_filter\"]/label/input";
        private static final String MESSAGE_INFO_LOCATOR = "example_info";
        private static final String DROP_DOWN_LOCATOR = "example_length";
        private static final String PAGINATE_LOCATOR = "example_paginate";


        private static final String TITLE_VALUE = "Add Validity Test Code";
        private static final String DESCRIPTION_VALUE = "description_data";
        private static final String DESCRIPTION_NEW_VALUE = "newDescription";
        private static final String COMPOUNDS_VALUE = "testv";
        private static final String COMPOUND_HELP_BLOCK_VALUE = "INVALID";
        private static final String SUBMIT_ATTRIBUTE_VALUE = "true";
        private static final String EDIT_VALIDITY_TEST_CODE = "Edit Validity Test Code";
        private static final String FULL_SCREEN_VALUE = "fullscreen active";
        private static final String NORMAL_SCREEN_VALUE = "fullscreen";
        private static final String SIDEBAR_ACTIVE_VALUE = "sidebar-toggler active";
        private static final String SIDEBAR_VALUE = "sidebar-toggler";
        private static final String MESSAGE_VALUE = "Showing 0 to 0 of 0 entries";

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

    private void edit() {
        WebElement description = MyWebDriverUtils.findElement(driver, ValidatingTestGroupImpl.TestCode.DESCRIPTION_LOCATOR, LocatorType.ID);
        if (description != null) {
            description.clear();
            description.sendKeys(ValidatingTestGroupImpl.TestCode.DESCRIPTION_NEW_VALUE);
            Assert.assertEquals(description.getAttribute(ATTRIBUTE_VALUE_LOCATOR), ValidatingTestGroupImpl.TestCode.DESCRIPTION_NEW_VALUE);
        } else {
            Assert.fail("description is null!");
        }

        driver.findElement(By.cssSelector(ValidatingTestGroupImpl.TestCode.COMPOUND_X_LOCATOR)).click();

        WebElement compounds = MyWebDriverUtils.findElement(driver, ValidatingTestGroupImpl.TestCode.COMPOUNDS_EDIT_LOCATOR, LocatorType.CSS);
        if (compounds != null) {
            compounds.sendKeys(ValidatingTestGroupImpl.TestCode.COMPOUNDS_VALUE);
        } else {
            Assert.fail("compounds is null!");
        }

        driver.findElement(By.cssSelector(ValidatingTestGroupImpl.TestCode.COMPOUND_SELECT_LOCATOR)).click();
    }

    private void checkList() {
        WebElement table = MyWebDriverUtils.findElement(driver, TABLE_LOCATOR, LocatorType.ID);
        if (table != null) {
            List<WebElement> allRows = table.findElements(By.tagName(ROWS_LOCATOR));
            for (int i = 1; i < allRows.size(); i++) {
                String cellText = allRows.get(i).findElements(By.xpath(CELLS_LOCATOR)).get(0).getText();
                if (tableData.size() > i) {
                    Assert.assertNotEquals(tableData.get(i - 1), cellText);
                }
            }
        } else {
            Assert.fail("table is null!");
        }
    }

}
