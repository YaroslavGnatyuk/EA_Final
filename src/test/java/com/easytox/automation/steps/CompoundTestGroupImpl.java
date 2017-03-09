package com.easytox.automation.steps;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.easytox.automation.utils.LocatorType.XPATH;


/**
 * Created by Alexander on 06.12.2016.
 */
public class CompoundTestGroupImpl {

    private static final String PASSWORD = "P@ssw0rd123";
    private static final String LOGIN = "lavanya1";
    private static final String FIND_USERNAME = "j_username";
    private static final String FIND_LOGIN = "j_password";
    private static final String LOGIN_PAGE_URL = "http://bmtechsol.com:8080/easytox/";
    private static final String LOGIN_BUTTON_XPATH = "//*[@id=\"loginform\"]/div[3]/div/button";
    private static final String COMPOUND_TEST_GROUP_URL = "http://bmtechsol.com:8080/easytox/testCode/list";


    private static final String ATTRIBUTE_VALUE_LOCATOR = "value";
    private static final String ATTRIBUTE_CLASS_LOCATOR = "class";
    private static final String ATTRIBUTE_CLASS_VALUE = "active";
    private static final String CELLS_LOCATOR = "./*";
    private static final String CELL_LOCATOR = "td";
    private static final String TBODY_LOCATOR = "tbody";
    private static final String ROWS_LOCATOR = "tr";
    private static final String TABLE_LOCATOR = "example";
    private static final String LIST_LOCATOR = "li";


    private static final int TIME_OUT_IN_SECONDS = 10;

    private static String testData;
    private static ArrayList<String> tableData = new ArrayList<String>();

    private WebDriver driver;

    public CompoundTestGroupImpl() {
        DriverBase.instantiateDriverObject();
        driver = DriverBase.getDriver();
    }


    @Given("^the user is Compound Test Group page$")
    public void the_user_is_Compound_Test_Group_page() {
        if (!driver.getCurrentUrl().contains(LOGIN_PAGE_URL)) {
            authorization();
        }

        driver.navigate().to(COMPOUND_TEST_GROUP_URL);
    }

    /*
               Scenario: Search Box
     */

    @When("^entered some text in the Search box$")
    public void entered_some_text_in_the_Search_box() {
        WebElement firstName = findElement(driver, SearchBox.FIRST_NAME_LOCATOR, LocatorType.NAME);
        if (firstName != null) {
            firstName.clear();
            firstName.sendKeys(SampleDataUtil.getFirstName());
        } else {
            Assert.fail("firstName is null!");
        }

        WebElement lastName = findElement(driver, SearchBox.LAST_NAME_LOCATOR, LocatorType.NAME);
        if (lastName != null) {
            lastName.clear();
            lastName.sendKeys(SampleDataUtil.getLastName());
        } else {
            Assert.fail("lastName is null!");
        }

        WebElement dateOfBirth = findElement(driver, SearchBox.DATE_OF_BIRTH_LOCATOR, LocatorType.NAME);
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

        WebElement caseAcc = findElement(driver, SearchBox.CASE_ACC_LOCATOR, LocatorType.CSS);
        if (caseAcc != null) {
            caseAcc.clear();
            caseAcc.sendKeys(StringUtils.generateRandom());
        } else {
            Assert.fail("caseAcc is null!");
        }


        WebElement medRec = findElement(driver, SearchBox.MED_REC_LOCATOR, LocatorType.CSS);
        if (medRec != null) {
            medRec.clear();
            medRec.sendKeys(StringUtils.generateRandom());
        } else {
            Assert.fail("medRec is null!");
        }

        WebElement searchButton = findElement(driver, SearchBox.SEARCH_BUTTON_LOCATOR, LocatorType.ID);
        if (searchButton != null) {
            searchButton.sendKeys(Keys.ENTER);
        } else {
            Assert.fail("searchButton is null!");
        }
    }

    @Then("^user should be able to view the search results$")
    public void user_should_be_able_to_view_the_search_results() throws Throwable {
        WebElement table = findElement(driver, SearchBox.TABLE_OF_RESULT_LOCATOR, LocatorType.CSS);

        List<WebElement> allRows = null;
        if (table != null) {
            allRows = table.findElements(By.tagName(ROWS_LOCATOR));
        } else {
            Assert.fail("table is null!");
        }

        if (allRows != null) {
            Assert.assertTrue(allRows.size() == 1);
        } else {
            Assert.fail("allRows is null!");
        }
    }

    /*
          Scenario: Adding a test code
     */

    @When("^clicked on ‘\\+’ button next to search box$")
    public void click_on_plus_button() throws Throwable {
        WebElement el = findElement(driver, TestCode.ADD_TEST_CODE_BUTTON_LOCATOR, LocatorType.ID);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }

    }

    @Then("^Add Test Code popup should be displayed$")
    public void check_popup_() {
        WebElement titleElement = findElement(driver, TestCode.TITLE_LOCATOR, LocatorType.ID);
        String title = null;
        if (titleElement != null) {
            title = titleElement.getText();
        }
        Assert.assertEquals(title, TestCode.TITLE_VALUE);
        System.out.println("aaaa");

    }

    @When("^Add Test Code popup is displayed$")
    public void add_test_code_popup_is_displayed() throws InterruptedException {
        WebElement el = findElement(driver, TestCode.ADD_TEST_CODE_BUTTON_LOCATOR, LocatorType.ID);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }
    }

    @Then("^user should be able to enter the data in all the fields$")
    public void check_the_possibility_of_data_entry() {
        String testCodeData = StringUtils.generateRandom();

        WebElement testCode = findElement(driver, TestCode.TEST_CODE_LOCATOR, LocatorType.ID);
        if (testCode != null) {
            testCode.clear();
            testCode.sendKeys(testCodeData);
            String testValue = testCode.getAttribute(ATTRIBUTE_VALUE_LOCATOR);
            Assert.assertEquals(testValue, testCodeData);
        } else {
            Assert.fail("testCode is null!");
        }

        WebElement description = findElement(driver, TestCode.DESCRIPTION_LOCATOR, LocatorType.ID);
        if (description != null) {
            description.clear();
            description.sendKeys(TestCode.DESCRIPTION_VALUE);
            String descriptionValue = description.getAttribute(ATTRIBUTE_VALUE_LOCATOR);
            Assert.assertEquals(descriptionValue, TestCode.DESCRIPTION_VALUE);
        } else {
            Assert.fail("description is null!");
        }

        WebElement compounds = findElement(driver, TestCode.COMPOUNDS_LOCATOR, LocatorType.CSS);
        if (compounds != null) {
            compounds.clear();
            compounds.sendKeys(TestCode.COMPOUNDS_VALUE);
            String compoundsValue = compounds.getAttribute(ATTRIBUTE_VALUE_LOCATOR);
            Assert.assertEquals(compoundsValue, TestCode.COMPOUNDS_VALUE);
        } else {
            Assert.fail("compounds is null!");
        }
    }

    @When("^Add Test Code popup is displayed and user entered all the required fields and click on submit$")
    public void submit_all_data() throws InterruptedException {
        WebElement el = findElement(driver, TestCode.ADD_TEST_CODE_BUTTON_LOCATOR, LocatorType.ID);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }

        testData = StringUtils.generateRandom();

        WebElement testCode = findElement(driver, TestCode.TEST_CODE_LOCATOR, LocatorType.ID);
        if (testCode != null) {
            testCode.clear();
            testCode.sendKeys(testData);
        } else {
            Assert.fail("testCode is null!");
        }

        WebElement description = findElement(driver, TestCode.DESCRIPTION_LOCATOR, LocatorType.ID);
        if (description != null) {
            description.clear();
            description.sendKeys(TestCode.DESCRIPTION_VALUE);
        } else {
            Assert.fail("description is null!");
        }

        WebElement compounds = findElement(driver, TestCode.COMPOUNDS_LOCATOR, LocatorType.CSS);
        if (compounds != null) {
            compounds.clear();
            compounds.sendKeys(TestCode.COMPOUNDS_VALUE);
        } else {
            Assert.fail("compounds is null!");
        }

        WebElement tst = findElement(driver, TestCode.TST_LOCATOR, LocatorType.CSS);
        if (tst != null) {
            tst.click();
        } else {
            Assert.fail("tst is null!");
        }

        WebElement submit = findElement(driver, TestCode.SUBMIT_BUTTON_LOCATOR, LocatorType.CSS);
        if (submit != null) {
            submit.click();
        } else {
            Assert.fail("submit is null!");
        }

    }

    @Then("^user should be able to submit the data and the added Test code should be displayed on the list$")
    public void check_add_and_submit_data(){
        try {
            final WebElement table = findElement(driver, TABLE_LOCATOR, LocatorType.ID);
            if (table != null) {

                List<WebElement> listRows = findElements(driver, TIME_OUT_IN_SECONDS, ROWS_LOCATOR, LocatorType.TAG, table);
                if (listRows != null) {
                    for (final WebElement row : listRows) {
                        List<WebElement> listCells = findElements(driver, TIME_OUT_IN_SECONDS, CELLS_LOCATOR, LocatorType.TAG, row);
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

    @When("^Add Test Code popup is displayed and user is not entered all the required fields and click on submit$")
    public void check_submit_with_empty_fields() throws InterruptedException {
        WebElement el = findElement(driver, TestCode.ADD_TEST_CODE_BUTTON_LOCATOR, LocatorType.ID);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }

        WebElement testCode = findElement(driver, TestCode.TEST_CODE_LOCATOR, LocatorType.ID);
        if (testCode != null) {
            testCode.clear();
            testCode.sendKeys(StringUtils.generateRandom());
        } else {
            Assert.fail("testCode is null!");
        }


        WebElement description = findElement(driver, TestCode.DESCRIPTION_LOCATOR, LocatorType.ID);
        if (description != null) {
            description.clear();
            description.sendKeys(TestCode.DESCRIPTION_VALUE);
        } else {
            Assert.fail("description is null!");
        }


        WebElement submit = findElement(driver, TestCode.SUBMIT_BUTTON_LOCATOR, LocatorType.CSS);
        if (submit != null) {
            submit.click();
        } else {
            Assert.fail("submit is null!");
        }
    }

    @Then("^user should not be able to submit the data and should be displayed with the required fields.$")
    public void user_do_not_submit_the_data() throws InterruptedException {
        String title = null;
        WebElement webElement = findElement(driver, TestCode.TITLE_LOCATOR, LocatorType.ID);
        if (webElement != null) {
            title = webElement.getText();
        }
        Assert.assertEquals(title, TestCode.TITLE_VALUE);

        WebElement helpBlock = findElement(driver, TestCode.COMPOUND_HELP_BLOCK_LOCATOR, LocatorType.CSS);
        if (helpBlock != null) {
            Assert.assertEquals(helpBlock.getAttribute(TestCode.HELP_BLOCK_ATTRIBUTE_LOCATOR), TestCode.COMPOUND_HELP_BLOCK_VALUE);
        } else {
            Assert.fail("helpBlock is null!");
        }

        WebElement submit = driver.findElement(By.cssSelector(TestCode.SUBMIT_BUTTON_LOCATOR));
        if (submit != null) {
            Assert.assertEquals(submit.getAttribute(TestCode.SUBMIT_ATTRIBUTE_LOCATOR), TestCode.SUBMIT_ATTRIBUTE_VALUE);
        } else {
            Assert.fail("submit is null!");
        }

    }

    @When("^Add Test Code popup is displayed and the user clicks on ‘Close’ button$")
    public void clicks_on_close_button() throws InterruptedException {
        WebElement el = findElement(driver, TestCode.ADD_TEST_CODE_BUTTON_LOCATOR, LocatorType.ID);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }

        WebElement closeButton = findElement(driver, TestCode.CLOSE_BUTTON_LOCATOR, LocatorType.CSS);
        if (closeButton != null) {
            closeButton.click();
        }

    }

    @Then("^the popup should be closed and the user should land on the Compound Test Group page.$")
    public void popup_closed_and_user_should_land_on_the_Compound_Test_Group_page_() {
        boolean flag = false;

        String currentUrlFromDriver = driver.getCurrentUrl();
        if (currentUrlFromDriver.equals(COMPOUND_TEST_GROUP_URL) || currentUrlFromDriver.equals(COMPOUND_TEST_GROUP_URL + "#")) {
            flag = true;
        }
        Assert.assertTrue(flag);
    }

    @When("^Add Test Code popup is displayed and the user clicks on ‘x’ button$")
    public void clicks_on_x_button() throws InterruptedException {
        WebElement el = findElement(driver, TestCode.ADD_TEST_CODE_BUTTON_LOCATOR, LocatorType.ID);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }

        WebElement xButton = findElement(driver, TestCode.X_BUTTON_LOCATOR, LocatorType.CSS);
        if (xButton != null) {
            xButton.click();
        }
    }

    /*
            Scenario: No of records to be displayed on the page
     */

    @When("^clicked on dropdown that shows (.*) to be displayed on the page$")
    public void click_on_dropdown(String number) {
        new Select(driver.findElement(By.name(TestCode.DROP_DOWN_LOCATOR))).selectByVisibleText(number);


    }

    @Then("^user should be able to view and select the options from the list and the corresponding (.*) of records should be displayed on the page.$")
    public void check_number_of_records(String number){
        WebElement table = driver.findElement(By.id(TABLE_LOCATOR));
        int size = table.findElements(By.tagName(ROWS_LOCATOR)).size() - 1;

        WebElement element = driver.findElement(By.id(TestCode.PAGINATE_LOCATOR));
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


    @When("^clicked on Test Code column of the list$")
    public void click_on_test_code_column() {
        WebElement el = findElement(driver, TestCode.TEST_CODE_COLUMN_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }
    }

    @Then("^the list should be displayed in the alphabetical order$")
    public void display_in_the_alphabetical_orders() {
        int j = 0;

        WebElement table = driver.findElement(By.id(TABLE_LOCATOR));

        List<WebElement> allRows = table.findElements(By.tagName(ROWS_LOCATOR));


        if (allRows.get(0).findElements(By.xpath(CELLS_LOCATOR)).get(0)
                .getAttribute(TestCode.SORT_ATTRIBUTE_LOCATOR) != null &&
                allRows.get(0).findElements(By.xpath(CELLS_LOCATOR)).get(0)
                        .getAttribute(TestCode.SORT_ATTRIBUTE_LOCATOR).equals(TestCode.SORT_ATTRIBUTE_VALUE)) {
            j = 0;
        }

        if (allRows.get(0).findElements(By.xpath(CELLS_LOCATOR)).get(1)
                .getAttribute(TestCode.SORT_ATTRIBUTE_LOCATOR) != null &&
                allRows.get(0).findElements(By.xpath(CELLS_LOCATOR)).get(1)
                        .getAttribute(TestCode.SORT_ATTRIBUTE_LOCATOR).equals(TestCode.SORT_ATTRIBUTE_VALUE)) {
            j = 1;
        }

        if (allRows.get(0).findElements(By.xpath(CELLS_LOCATOR)).get(2)
                .getAttribute(TestCode.SORT_ATTRIBUTE_LOCATOR) != null &&
                allRows.get(0).findElements(By.xpath(CELLS_LOCATOR)).get(2)
                        .getAttribute(TestCode.SORT_ATTRIBUTE_LOCATOR).equals(TestCode.SORT_ATTRIBUTE_VALUE)) {
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

    @When("^clicked on Description column of the list$")
    public void click_on_description_column() {
        WebElement el = findElement(driver, TestCode.DESCRIPTION_COLUMN_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }
    }

    @When("^clicked on Compounds column of the list$")
    public void click_on_compounds_column() {
        WebElement el = findElement(driver, TestCode.COMPOUNDS_COLUMN_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }
    }

    /*
       Scenario: Click on Edit under Action Column
     */

    @When("^clicked on Edit button under Action column$")
    public void click_on_edit_button() throws InterruptedException {
        WebElement el = findElement(driver, TestCode.EDIT_BUTTON_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }
    }

    @Then("^“Edit Test Code” popup should be displayed$")
    public void check_edit_test_code_popup() throws InterruptedException {
        WebElement webElement = findElement(driver, TestCode.TITLE_LOCATOR, LocatorType.ID);
        if (webElement != null) {
            String title = webElement.getText();
            Assert.assertEquals(title, TestCode.EDIT_TITLE_VALUE);
        } else {
            Assert.fail("webElement is null!");
        }

        WebElement testCode = findElement(driver, TestCode.TEST_CODE_LOCATOR, LocatorType.ID);
        if (testCode != null) {
            Assert.assertTrue(testCode.getAttribute(ATTRIBUTE_VALUE_LOCATOR) != null);
        } else {
            Assert.fail("testCode is null!");
        }

        WebElement description = findElement(driver, TestCode.DESCRIPTION_LOCATOR, LocatorType.ID);
        if (description != null) {
            Assert.assertTrue(description.getAttribute(ATTRIBUTE_VALUE_LOCATOR) != null);
        } else {
            Assert.fail("description is null!");
        }

        WebElement compounds = findElement(driver, TestCode.COMPOUND_EDIT_LOCATOR, LocatorType.CSS);
        if (compounds != null) {
            Assert.assertTrue(compounds.getText() != null);
        } else {
            Assert.fail("compounds is null!");
        }
    }

    @When("^clicked on Edit under Actions column and Edit Test Code popup is displayed$")
    public void click_on_edit_under_actions_column() throws InterruptedException {
        WebElement el = findElement(driver, TestCode.EDIT_BUTTON_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }

        check_edit_test_code_popup();
    }

    @Then("^user should be able to edit the data$")
    public void user_should_be_able_to_edit_the_data() {
        edit();
    }

    @When("^Edit Test Code popup is displayed and user can edit the data and click on update button$")
    public void update_test_code() {
        WebElement el = findElement(driver, TestCode.EDIT_BUTTON_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }

        edit();

        WebElement updateButton = findElement(driver, TestCode.UPDATE_BUTTON_LOCATOR, LocatorType.CSS);
        if (updateButton != null) {
            updateButton.click();
        } else {
            Assert.fail("updateButton is null!");
        }

    }

    @Then("^user should be able to update the data and the edited Test Code should be displayed on the list$")
    public void check_list_with_edited_data() {
        try {
            boolean flag = false;
            WebElement table = findElement(driver, TABLE_LOCATOR, LocatorType.ID);
            if (table != null) {
                List<WebElement> el = findElements(driver, TIME_OUT_IN_SECONDS, TBODY_LOCATOR, LocatorType.TAG, table);
                List<WebElement> allRows = findElements(driver, TIME_OUT_IN_SECONDS, ROWS_LOCATOR, LocatorType.TAG, el.get(0));
                if (allRows != null && allRows.size() == 10) {
                    for (WebElement row : allRows) {
                        List<WebElement> cells = findElements(driver, TIME_OUT_IN_SECONDS, CELL_LOCATOR, LocatorType.TAG, row);
                        if (cells != null && cells.size() == 4) {
                            if (cells.get(1).getText().equals(TestCode.DESCRIPTION_NEW_VALUE)
                                    && cells.get(2).getText().equals(TestCode.COMPOUNDS_VALUE)) {
                                flag = true;
                            }
                        } else {
                            throw new StaleElementReferenceException("cells size is not equals 4");
                        }
                        Assert.assertTrue(flag);
                    }
                } else {
                    throw new StaleElementReferenceException("allRows size is not equals 10");
                }
            } else {
                Assert.fail("table is null!");
            }

        } catch (StaleElementReferenceException ex) {
            check_list_with_edited_data();
        }
    }


    @When("^Edit Test Code popup is displayed and the user clicks on ‘Close’ button$")
    public void click_on_close_button_in_edit_test_code_popup() throws InterruptedException {
        WebElement el = findElement(driver, TestCode.EDIT_BUTTON_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }
        WebElement closeButton = findElement(driver, TestCode.EDIT_CLOSE_BUTTON_LOCATOR, LocatorType.CSS);
        if (closeButton != null) {
            closeButton.click();
        } else {
            Assert.fail("closeButton is null!");
        }
    }

    @When("^Edit Test Code popup is displayed and the user clicks on ‘x’ button$")
    public void click_on_x_in_edit_test_code_popup() throws InterruptedException {
        WebElement el = findElement(driver, TestCode.EDIT_BUTTON_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }

        WebElement xButton = findElement(driver, TestCode.EDIT_X_BUTTON_LOCATOR, LocatorType.CSS);
        if (xButton != null) {
            xButton.click();
        } else {
            Assert.fail("xButton is null!");
        }
    }

    /*
      Scenario: Navigating to the next and previous pages
     */

    @When("^clicked on next button$")
    public void click_on_next_button(){
        try {
            WebElement table = findElement(driver, TABLE_LOCATOR, LocatorType.ID);
            if (table != null) {
                WebElement tbody = findElement(driver,TIME_OUT_IN_SECONDS, TBODY_LOCATOR, LocatorType.TAG, table);
                if(tbody != null){
                    List<WebElement> allRows = findElements(driver, TIME_OUT_IN_SECONDS, ROWS_LOCATOR, LocatorType.TAG, table);
                    if (allRows != null) {
                        tableData.clear();
                        for (int i = 1; i < allRows.size(); i++) {
                            List<WebElement> list = findElements(driver, TIME_OUT_IN_SECONDS, CELL_LOCATOR, LocatorType.TAG, allRows.get(i));
                            if (list != null && list.size() == 4) {
                                tableData.add(list.get(0).getText());
                            } else {
                                System.out.println("else block");
                                throw new StaleElementReferenceException("list size is not equal 4");
                            }
                        }
                    } else {
                        Assert.fail("allRows is null!");
                    }

                } else {
                    Assert.fail("tbody is null!");
                }
                WebElement el = findElement(driver, TestCode.NEXT_BUTTON_LOCATOR, LocatorType.CSS);
                WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

                boolean flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
                if (flag && el != null) {
                    el.click();
                } else {
                    Assert.fail("flag is false or el is null!");
                }

            } else {
                Assert.fail("table is null!");
            }
        } catch (StaleElementReferenceException ex) {
            click_on_next_button();
        }
    }


    @Then("^the user should be able to navigate to the next page$")
    public void navigate_to_the_next_page() {
        boolean flag = false;

        checkList();

        WebElement el = findElement(driver, TestCode.PAGINATE_2_LOCATOR, LocatorType.XPATH);
        if (el != null) {
            if (el.getAttribute(ATTRIBUTE_CLASS_LOCATOR) != null &&
                    el.getAttribute(ATTRIBUTE_CLASS_LOCATOR).equals(ATTRIBUTE_CLASS_VALUE)) {
                flag = true;
            }
        } else {
            Assert.fail("el is null!");
        }

        Assert.assertTrue(flag);
    }

    @When("^clicked on Prev button$")
    public void click_on_prev_button() throws InterruptedException {
        try {
            WebElement el = findElement(driver, TestCode.NEXT_BUTTON_LOCATOR, LocatorType.CSS);
            WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

            boolean flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
            if (flag && el != null) {
                el.click();
            } else {
                Assert.fail("flag is false or el is null!");
            }

            WebElement table = findElement(driver, TABLE_LOCATOR, LocatorType.ID);
            if (table != null) {
                WebElement tbody = findElement(driver, TIME_OUT_IN_SECONDS, TBODY_LOCATOR, LocatorType.TAG, table);
                if (tbody != null) {
                    List<WebElement> allRows = findElements(driver, TIME_OUT_IN_SECONDS, ROWS_LOCATOR, LocatorType.TAG, table);
                    if (allRows != null) {
                        tableData.clear();
                        for (int i = 1; i < allRows.size(); i++) {
                            List<WebElement> list = findElements(driver, TIME_OUT_IN_SECONDS, CELL_LOCATOR, LocatorType.TAG, allRows.get(i));
                            if (list != null && list.size() == 4) {
                                tableData.add(list.get(0).getText());
                            } else {
                                throw new StaleElementReferenceException("list size is not equal 4");
                            }
                        }
                    } else {
                        Assert.fail("allRows is null!");
                    }

                } else {
                    Assert.fail("tbody is null!");
                }

            }

            WebElement prevButton = findElement(driver, TestCode.PREVIOUS_BUTTON_LOCATOR, LocatorType.CSS);
            if (prevButton != null) {
                prevButton.click();
            } else {
                Assert.fail("prevButton is null!");
            }
        } catch (StaleElementReferenceException ex) {
            click_on_next_button();
        }
    }

    @Then("^the user should be able to navigate to the Previous page$")
    public void navigate_to_previous_page() {
        boolean flag = false;

        checkList();

        WebElement el = findElement(driver, TestCode.PAGINATE_1_LOCATOR, LocatorType.XPATH);

        if(el != null){
            if (el.getAttribute(ATTRIBUTE_CLASS_LOCATOR) != null &&
                    el.getAttribute(ATTRIBUTE_CLASS_LOCATOR).equals(ATTRIBUTE_CLASS_VALUE)) {
                flag = true;
            }
            Assert.assertTrue(flag);
        } else {
            Assert.fail("el is null!");
        }
    }

    /*
       Scenario: Checking the message of no of results displayed on current page
     */

    @When("^the user searches the results$")
    public void user_searches_the_results() throws InterruptedException {
        WebElement input = findElement(driver, TestCode.SEARCH_INPUT_LOCATOR, XPATH);
        if (input != null) {
            input.sendKeys(StringUtils.generateRandom());
        } else {
            Assert.fail("input is null!");
        }

    }

    @Then("^the text “Showing x to y of z entries” should be displayed on the bottom left corner of the list.$")
    public void show_message() {
        WebElement webElement = findElement(driver, TestCode.MESSAGE_INFO_LOCATOR, LocatorType.ID);
        if (webElement != null) {
            String text = webElement.getText();
            boolean flag = text.contains(TestCode.MESSAGE_VALUE);
            Assert.assertTrue(flag);
        } else {
            Assert.fail("webElement is null!");
        }

    }

    /*
      Scenario: Buttons on the Compound Test Group page
     */

    @When("^clicked on maximize button$")
    public void click_on_maximize_buttons(){
        WebElement el = findElement(driver, TestCode.MAXIMIZE_BUTTON_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }
    }

    @Then("^the screen should be maximized$")
    public void the_screen_should_be_maximized(){
        WebElement el = driver.findElement(By.id(TestCode.FULL_SCREEN_LOCATOR));
        Assert.assertEquals(el.getAttribute(ATTRIBUTE_CLASS_LOCATOR), TestCode.FULL_SCREEN_VALUE);
    }

    @When("^the screen is maximized and clicked on minimize button$")
    public void the_screen_is_maximized_and_clicked_on_minimize_button() throws InterruptedException {
        WebElement el = findElement(driver, TestCode.MAXIMIZE_BUTTON_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }

        el = findElement(driver, TestCode.MAXIMIZE_BUTTON_LOCATOR, LocatorType.CSS);
        wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }
    }

    @Then("^the screen should be displayed in normal mode$")
    public void the_screen_should_be_displayed_in_normal_mode() throws InterruptedException {
        WebElement el = driver.findElement(By.id(TestCode.FULL_SCREEN_LOCATOR));
        Assert.assertEquals(el.getAttribute(ATTRIBUTE_CLASS_LOCATOR), TestCode.NORMAL_SCREEN_VALUE);
    }

    @When("^clicked on ‘-‘ button$")
    public void click_on_sidebar_button(){
        WebElement el = findElement(driver, TestCode.SIDEBAR_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }
    }

    @Then("^the list should be hidden$")
    public void the_list_should_be_hidden(){
        WebElement el = driver.findElement(By.cssSelector(TestCode.SIDEBAR_ACTIVE_LOCATOR));
        Assert.assertEquals(el.getAttribute(ATTRIBUTE_CLASS_LOCATOR), TestCode.SIDEBAR_ACTIVE_VALUE);
    }

    @When("^the list is hidden and clicked on ‘\\+‘ button$")
    public void the_list_is_hidden_and_clicked_on_refresh_button() {
        WebElement el = findElement(driver, TestCode.SIDEBAR_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }

        el = findElement(driver, TestCode.REFRESH_BUTTON_LOCATOR, LocatorType.CSS);
        wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }
    }

    @Then("^the list should be shown$")
    public void the_list_should_be_shown(){
        WebElement el = driver.findElement(By.cssSelector(TestCode.SIDEBAR_LOCATOR));
        Assert.assertEquals(el.getAttribute(ATTRIBUTE_CLASS_LOCATOR), TestCode.SIDEBAR_VALUE);
    }

    @When("^the list is hidden and clicked on ‘x‘ button$")
    public void the_list_is_hidden_and_clicked_on_maximize_button(){
        WebElement el = findElement(driver, TestCode.SIDEBAR_LOCATOR, LocatorType.CSS);
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        boolean flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }

        el = findElement(driver, TestCode.MAXIMIZE_BUTTON_LOCATOR, LocatorType.CSS);
        wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        flag = waitInvisibilityOfElement(wait, TestCode.CONTAINER_LOCATOR, LocatorType.ID);
        if (flag && el != null) {
            el.click();
        } else {
            Assert.fail("flag is false or el is null!");
        }

    }

    @Then("^the list should be closed$")
    public void the_list_should_be_closed(){
        WebElement el = driver.findElement(By.id(TestCode.FULL_SCREEN_LOCATOR));
        Assert.assertEquals(el.getAttribute(ATTRIBUTE_CLASS_LOCATOR), TestCode.FULL_SCREEN_VALUE);

        WebElement el1 = driver.findElement(By.cssSelector(TestCode.SIDEBAR_ACTIVE_LOCATOR));
        Assert.assertEquals(el1.getAttribute(ATTRIBUTE_CLASS_LOCATOR), TestCode.SIDEBAR_ACTIVE_VALUE);


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
        private static final String ADD_TEST_CODE_BUTTON_LOCATOR = "add";
        private static final String CONTAINER_LOCATOR = "loadingDiv";
        private static final String TITLE_LOCATOR = "exampleModalLabel";
        private static final String TEST_CODE_LOCATOR = "test_code";
        private static final String DESCRIPTION_LOCATOR = "description";
        private static final String COMPOUNDS_LOCATOR = "#compounds1 > span > span.selection > span > ul > li > input";
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
        private static final String COMPOUND_EDIT_LOCATOR = "#compounds1 > span > span.selection > span > ul > li.select2-selection__choice";
        private static final String COMPOUND_X_LOCATOR = "#compounds1 > span > span.selection > span > ul > span";
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


        private static final String TITLE_VALUE = "Add Test Code";
        private static final String DESCRIPTION_VALUE = "description_data";
        private static final String DESCRIPTION_NEW_VALUE = "newDescription";
        private static final String COMPOUNDS_VALUE = "Tst";
        private static final String COMPOUND_HELP_BLOCK_VALUE = "INVALID";
        private static final String SUBMIT_ATTRIBUTE_VALUE = "true";
        private static final String EDIT_TITLE_VALUE = "Edit Test Code";
        private static final String FULL_SCREEN_VALUE = "fullscreen active";
        private static final String NORMAL_SCREEN_VALUE = "fullscreen";
        private static final String SIDEBAR_ACTIVE_VALUE = "sidebar-toggler active";
        private static final String SIDEBAR_VALUE = "sidebar-toggler";
        private static final String MESSAGE_VALUE = "Showing 0 to 0 of 0 entries";


    }

    private WebElement findElement(WebDriver driver, final String locator, LocatorType locatorType) {

        final WebDriverWait webDriverWait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        switch (locatorType) {
            case XPATH:
                return webDriverWait
                        .until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
            case CLASS:
                return webDriverWait
                        .until(ExpectedConditions.elementToBeClickable(By.className(locator)));
            case ID:
                return webDriverWait
                        .until(ExpectedConditions.elementToBeClickable(By.id(locator)));
            case TAG:
                return webDriverWait
                        .until(ExpectedConditions.elementToBeClickable(By.tagName(locator)));
            case NAME:
                return webDriverWait
                        .until(ExpectedConditions.elementToBeClickable(By.name(locator)));
            case CSS:
                return webDriverWait
                        .until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));

        }
        return null;
    }

    private WebElement findElement(WebDriver driver, int timeOutInSeconds, final String locator, LocatorType locatorType, final WebElement el) {
        switch (locatorType) {
            case XPATH:
                return (new WebDriverWait(driver, timeOutInSeconds)).until(new ExpectedCondition<WebElement>() {
                    public WebElement apply(WebDriver input) {
                        return el.findElement(By.xpath(locator));
                    }
                });
            case CLASS:
                return (new WebDriverWait(driver, timeOutInSeconds)).until(new ExpectedCondition<WebElement>() {
                    public WebElement apply(WebDriver input) {
                        return el.findElement(By.className(locator));
                    }
                });
            case ID:
                return (new WebDriverWait(driver, timeOutInSeconds)).until(new ExpectedCondition<WebElement>() {
                    public WebElement apply(WebDriver input) {
                        return el.findElement(By.id(locator));
                    }
                });
            case TAG:
                return (new WebDriverWait(driver, timeOutInSeconds)).until(new ExpectedCondition<WebElement>() {
                    public WebElement apply(WebDriver input) {
                        return el.findElement(By.tagName(locator));
                    }
                });
            case NAME:
                return (new WebDriverWait(driver, timeOutInSeconds)).until(new ExpectedCondition<WebElement>() {
                    public WebElement apply(WebDriver input) {
                        return el.findElement(By.name(locator));
                    }
                });
            case CSS:
                return (new WebDriverWait(driver, timeOutInSeconds)).until(new ExpectedCondition<WebElement>() {
                    public WebElement apply(WebDriver input) {
                        return el.findElement(By.cssSelector(locator));
                    }
                });
        }
        return null;
    }

    private List<WebElement> findElements(WebDriver driver, int timeOutInSeconds, final String locator, LocatorType locatorType, final WebElement el) {
        switch (locatorType) {
            case XPATH:
                return (new WebDriverWait(driver, timeOutInSeconds)).until(new ExpectedCondition<List<WebElement>>() {
                    public List<WebElement> apply(WebDriver input) {
                        return el.findElements(By.xpath(locator));
                    }
                });
            case CLASS:
                return (new WebDriverWait(driver, timeOutInSeconds)).until(new ExpectedCondition<List<WebElement>>() {
                    public List<WebElement> apply(WebDriver input) {
                        return el.findElements(By.className(locator));
                    }
                });
            case ID:
                return (new WebDriverWait(driver, timeOutInSeconds)).until(new ExpectedCondition<List<WebElement>>() {
                    public List<WebElement> apply(WebDriver input) {
                        return el.findElements(By.id(locator));
                    }
                });
            case TAG:
                return (new WebDriverWait(driver, timeOutInSeconds)).until(new ExpectedCondition<List<WebElement>>() {
                    public List<WebElement> apply(WebDriver input) {
                        return el.findElements(By.tagName(locator));
                    }
                });
            case NAME:
                return (new WebDriverWait(driver, timeOutInSeconds)).until(new ExpectedCondition<List<WebElement>>() {
                    public List<WebElement> apply(WebDriver input) {
                        return el.findElements(By.name(locator));
                    }
                });
            case CSS:
                return (new WebDriverWait(driver, timeOutInSeconds)).until(new ExpectedCondition<List<WebElement>>() {
                    public List<WebElement> apply(WebDriver input) {
                        return el.findElements(By.cssSelector(locator));
                    }
                });
        }
        return null;
    }

    private boolean waitInvisibilityOfElement(WebDriverWait wait, String locator, LocatorType type) {
        switch (type) {
            case XPATH:
                return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
            case CLASS:
                return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(locator)));
            case ID:
                return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(locator)));
            case TAG:
                return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName(locator)));
            case NAME:
                return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(locator)));
            case CSS:
                return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(locator)));
        }
        return false;
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
        WebElement description = findElement(driver, TestCode.DESCRIPTION_LOCATOR, LocatorType.ID);
        if (description != null) {
            description.clear();
            description.sendKeys(TestCode.DESCRIPTION_NEW_VALUE);
            Assert.assertEquals(description.getAttribute(ATTRIBUTE_VALUE_LOCATOR), TestCode.DESCRIPTION_NEW_VALUE);
        } else {
            Assert.fail("description is null!");
        }

        driver.findElement(By.cssSelector(TestCode.COMPOUND_X_LOCATOR)).click();

        WebElement compounds = findElement(driver, TestCode.COMPOUNDS_LOCATOR, LocatorType.CSS);
        if (compounds != null) {
            compounds.sendKeys(TestCode.COMPOUNDS_VALUE);
        } else {
            Assert.fail("compounds is null!");
        }

        driver.findElement(By.cssSelector(TestCode.COMPOUND_SELECT_LOCATOR)).click();
    }

    private void checkList() {
        WebElement table = findElement(driver, TABLE_LOCATOR, LocatorType.ID);
        if (table != null) {
            List<WebElement> allRows = table.findElements(By.tagName(ROWS_LOCATOR));
            for (int i = 1; i < allRows.size(); i++) {
                String cellText = allRows.get(i).findElements(By.xpath(CELLS_LOCATOR)).get(0).getText();
                Assert.assertNotEquals(tableData.get(i - 1), cellText);
            }
        } else {
            Assert.fail("table is null!");
        }
    }
}


