package com.easytox.automation.steps.lab_pathologist.ET_006;

import com.easytox.automation.driver.DriverBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class PageNavigationSteps {
    private WebDriver driver;
    private static final String easyToxAddress = "http://bmtechsol.com:8080/easytox/";
    private Logger log = Logger.getLogger(PageNavigationSteps.class);

    private int numberOfActivePage;

    @Before
    public void init() {
        DriverBase.instantiateDriverObject();
        driver = DriverBase.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
    }

    @Given("^User login with the physician \"([^\"]*)\" and password \"([^\"]*)\"$$")
    public void loginToEasyTox(String usr, String psw) {
        try {
            driver.navigate().to(easyToxAddress);
            driver.findElement(By.name(WElement.loginPageFieldName)).sendKeys(usr);
            driver.findElement(By.name(WElement.loginPagePasswordField)).sendKeys(psw);
            driver.findElement(By.cssSelector(WElement.loginPageLoginButton)).click();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("^Select Settings -> Lab Pathologist.$")
    public void gotToPathologistPage() {
        try {
            driver.findElement(By.cssSelector(WElement.dropdownToggle)).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector(WElement.menuIconLabPathologist)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^Lab Pathologist List screen is displayed.$")
    public void checkIsItPathologistPage() {
        try {
            Thread.sleep(1000);
            String pageTitle = driver.findElement(By.cssSelector(WElement.pageHeaderTitle)).getText();
            assertTrue(pageTitle.equals("Lab Pathologist List"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("^Navigate back and forth by selecting page numbers (.*)$")
    //todo I should remake this method. I should add checking for 1,2,3 and Prev buttons
    public void selectPageNumber(String button) {
        try {
            Thread.sleep(1000);

            switch (button) {

                /**I click "3" button before I click "Prev" because at the beginning "Prev" doesn't active**/
                case "Prev": {
                    driver.findElement(By.cssSelector(WElement.paginationThirdPage)).click();
                    driver.findElement(By.cssSelector(WElement.paginationPrevButton)).click();
                    break;
                }

                case "1": {
                    driver.findElement(By.cssSelector(WElement.paginationFirstPage)).click();
                    break;
                }

                case "2": {
                    driver.findElement(By.cssSelector(WElement.paginationSecondPage)).click();
                    break;
                }

                case "3": {
                    driver.findElement(By.cssSelector(WElement.paginationThirdPage)).click();
                    break;
                }

                case "Next": {
                    driver.findElement(By.cssSelector(WElement.paginationNextButton)).click();
                    break;
                }

                default:
                    log.info("This type doesn't exist!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^User should be navigate to the selected page(.*)$")
    public void checkNumberOfThePage(String button) {
        List<WebElement> elements = getAllElementsFromPagination();
        switch (button) {
            case "Next": {
                numberOfActivePage = getActivePage(elements);
                assertTrue(numberOfActivePage == 2);
                break;
            }

            case "1": {
                numberOfActivePage = getActivePage(elements);
                assertTrue(numberOfActivePage == 1);
                break;
            }

            case "2": {
                numberOfActivePage = getActivePage(elements);
                assertTrue(numberOfActivePage == 2);
                break;
            }

            case "3": {
                numberOfActivePage = getActivePage(elements);
                assertTrue(numberOfActivePage == 3);
                break;
            }


            case "Prev": {
                numberOfActivePage = getActivePage(elements);
                assertTrue(numberOfActivePage == 2);
                break;
            }
            default:
                log.info("This type doesn't exist!");
        }
    }

    @When("^Checking the message of no of records displayed on the current page bottom left corner of the screen$")
    public void checkTheMessage() {
        boolean isShowedTheMessage = driver.findElement(By.cssSelector(WElement.bottomTextMessage)).isDisplayed();
        assertTrue(isShowedTheMessage);
    }

    @Then("^A text message “Showing x to y of z entries” should be displayed on the bottom left corner of the list.$")
    public void checkTextOfTheMessage() {
        String theMessageShouldBe = "Showing x to y of z entries";
        String theMessageWeHave = driver.findElement(By.cssSelector(WElement.bottomTextMessage)).getText();
        String[] temp = theMessageWeHave.split(" ");

        theMessageWeHave = temp[0] + " x " + temp[2] + " y " + temp[4] + " z " + temp[6];

        assertTrue(theMessageWeHave.equals(theMessageShouldBe));
    }

    private List<WebElement> getAllElementsFromPagination() {
        return driver
                .findElements(By.cssSelector(WElement.pagination));
    }

    private int getActivePage(List<WebElement> webElements) {   //todo I need to improve this method. It take too much time!
        int activePage = 0;
        for (WebElement webElement : webElements) {
            try {
                if (webElement.findElement(By.cssSelector(WElement.thisIsActivePage)).isDisplayed()) {
                    activePage = Integer.valueOf(webElement
                            .findElement(By.cssSelector(WElement.thisIsActivePage))
                            .getText());
                }
            } catch (NoSuchElementException ignored) {
            }
        }

        return activePage;
    }

    @After
    public void close() {
        driver.close();
    }
}
