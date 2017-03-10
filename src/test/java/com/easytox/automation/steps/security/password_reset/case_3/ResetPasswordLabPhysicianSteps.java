package com.easytox.automation.steps.security.password_reset.case_3;

import com.easytox.automation.driver.DriverBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class ResetPasswordLabPhysicianSteps {
    private WebDriver driver;
    private Logger log = Logger.getLogger(ResetPasswordLabPhysicianSteps.class);
    private static final String easyToxAddress = "http://bmtechsol.com:8080/easytox/";
    private static final String currentLabPage = "http://bmtechsol.com:8080/easytox/caseOrder/list"; //This address we have after successful logging
    private static final String forgotPasswordScreenAddress = "http://bmtechsol.com:8080/easytox/actionItem/forgotPassword";
    private static final String validEmailAddress = "someEmail@gmail.com";

    @Before
    public void init() {
        DriverBase.instantiateDriverObject();
        driver = DriverBase.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @When("^Launch application using link: \"([^\"]*)\"$")
    public void goToLoginPage(String address) {
        driver.navigate().to(address);
    }

    @Then("^Easytox Login screen should be displayed.$")
    public void checkCurrentScreen() {
        String headerTextShouldBe = "Sign In";
        String headerTextWeHave = driver.findElement(By.cssSelector(WElement.panelHeading)).getText();
        assertTrue(headerTextWeHave.equals(headerTextShouldBe));
    }

    @When("^Click \"Click here\" link on Forgot Password.$")
    public void gotToForgotPasswordPage() {
        driver.navigate().to(easyToxAddress);
        driver.findElement(By.linkText("Click here")).click();
    }

    @Then("^Forgot Password screen should be displayed.$")
    public void checkForgotPasswordPage() {
        String currentPage = driver.getCurrentUrl();
        assertTrue(currentPage.equals(forgotPasswordScreenAddress));
    }

    @When("^Enter Username as \"([^\"]*)\", valid email address and click \"Send my Password\" button.$")
    public void sendRequestForRecoveryPassword(String validUser) {
        driver.findElement(By.cssSelector(WElement.forgotPageUsernameField)).sendKeys(validUser);
        driver.findElement(By.cssSelector(WElement.forgotPageEmailField)).sendKeys(validEmailAddress);
        driver.findElement(By.cssSelector(WElement.forgotPageSendMyPasswordButton)).click();
    }

    @Then("^\"Forgot Password Request Submitted\" message should be displayed on the page.$")
    public void checkTheMessage() {
        String messageShouldBe = "Forgot Password request submitted";
        String messageWeHave = driver
                .findElement(By.cssSelector(WElement.loginPage_MessageAfterRequestPasswordRecovery))
                .getText();
        assertTrue(messageWeHave.equals(messageShouldBe));
    }

    @When("^Login to Easytox with \"([^\"]*)\" and \"([^\"]*)\" credentials.$")
    public void loginToEasyTox(String username, String password) {
        driver.navigate().to(easyToxAddress);
        driver.findElement(By.name(WElement.loginPage_fieldName)).sendKeys(username);
        driver.findElement(By.name(WElement.loginPage_passwordField)).sendKeys(password);
        driver.findElement(By.cssSelector(WElement.loginPage_loginButton)).click();
    }

    @Then("^User login should be successful.$")
    public void checkCurrentPage() {
        try {
            Thread.sleep(1000);
            assertTrue(driver.getCurrentUrl().equals(currentLabPage));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("^Click \"Pending Password Requests\" link.$")
    public void clickOnThePendingPasswordRequest() {
        try {
            Thread.sleep(1000);
            driver.findElement(By.cssSelector(WElement.pendingPasswordRequest)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^Following should be displayed:1 Password Requests$")
    public void isPasswordRequestShowed() {
        boolean isPasswordRequestsShowed = driver
                .findElement(By.cssSelector(WElement.passwordRequest))
                .isDisplayed();
        assertTrue(isPasswordRequestsShowed);
    }

    @And("^Forgot Password   \"([^\"]*)\" <link>$")
    public void isForgotPasswordShowed(String labClient) {

        String request = "ForgotPassword " + labClient;
        List<WebElement> li = driver.findElements(By.cssSelector(WElement.userRequestLine));
        // TODO: 3/10/17 remove this comment
        /*Optional<String> result = li.stream()
                .map(e -> e.getText().replace("\n", " "))
                .filter(e -> e.equals(request))
                .findAny();*/
        boolean result = false;
        for (int i = 0; i < li.size(); i++) {
            if(li.get(i).getText().equals(request)){
                result = true;
                break;
            }
        }

        if (!result) {
            assertTrue(isExistLabClient(labClient));
            driver.findElement(By.cssSelector(WElement.pendingPasswordRequest)).click(); //open dropdown window to continue tests
        } else {
            assertTrue(true);
        }
    }

    @And("^See All Requests <Link>$")
    public void isAllRequestLinkShowed() {
        WebElement textLink = driver.findElement(By.linkText(WElement.textLinkSeeAllRequest));
        assertNotNull(textLink);
    }

    @When("^Select Forgot Password   \"([^\"]*)\".$")
    public void selectLabUserOne(String labClient) {
        String request = "ForgotPassword\n" + labClient;
        List<WebElement> li = driver.findElements(By.cssSelector(WElement.userRequestLine));
//        boolean isLabClientExist = li.stream().filter(e -> e.getText().equals(request)).findAny().isPresent();
        boolean isLabClientExist =false;
        for (int i = 0; i < li.size(); i++) {
            if (li.get(i).getText().equals(request)){
                isLabClientExist = true;
                break;
            }
        }
        if(!isLabClientExist){
            getLabClient(labClient).findElement(By.cssSelector(WElement.resetUserPasswordButton)).click();
        }
    }

    @Then("^Reset Password screen with following fields should be displayed: Request by: SPhyTwo$")
    public void isRequestByShowed() {
        try {
            Thread.sleep(1000);
            boolean isRequestByFieldShowed = driver
                    .findElement(By.cssSelector(WElement.resetPasswordPage_RequestByTitle))
                    .isDisplayed();

            String theValueOfRequestByShouldBe = "SPhyTwo";
            String theValueOfRequestByWeHave = driver
                    .findElement(By.cssSelector(WElement.resetPasswordPage_RequestByValue))
                    .getText();

            assertTrue(isRequestByFieldShowed);
            log.info(theValueOfRequestByShouldBe + "\n");
            log.info(theValueOfRequestByWeHave + "\n");
            assertTrue(theValueOfRequestByWeHave.equals(theValueOfRequestByShouldBe));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("^Request Email: <entered valid email ID>$")
    public void isRequestEmailShowed() {
        boolean isRequestEmailFieldShowed = driver
                .findElement(By.cssSelector(WElement.resetPasswordPage_RequestEmailTitle))
                .isDisplayed();
        boolean isRequestEmailValueShowed = driver
                .findElement(By.cssSelector(WElement.resetPasswordPage_RequestEmailValue))
                .isDisplayed();
        assertTrue(isRequestEmailFieldShowed && isRequestEmailValueShowed);
    }

    @And("^New Password <Input Box>$")
    public void isNewPasswordShowed() {
        boolean isNewPasswordTitleShowed = driver
                .findElement(By.cssSelector(WElement.resetPasswordPage_newPasswordFieldTitle))
                .isDisplayed();
        boolean isNewPasswordFieldShowed = driver
                .findElement(By.cssSelector(WElement.resetPasswordPage_newPasswordField))
                .isDisplayed();
        assertTrue(isNewPasswordTitleShowed && isNewPasswordFieldShowed);
    }

    @When("^Enter a new password \"([^\"]*)\" in the \"New Password\" field and click Save.$")
    public void enterNewPassword(String newPassword) {
        try {
            Thread.sleep(1000);
            driver.findElement(By.cssSelector(WElement.resetPasswordPage_newPasswordField)).sendKeys(newPassword);
            driver.findElement(By.cssSelector(WElement.resetPasswordPage_saveButton)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^\"([^\"]*)\" message should be displayed.$")
    public void checkTheResultOfSettingNewPassword(String messageShouldBe) {
        try {
            Thread.sleep(2000);
            String messageWeHave = driver
                    .findElement(By.cssSelector(WElement.resultOfChangePassword))
                    .getText();
            log.info(messageWeHave + "\n");
            log.info(messageShouldBe + "\n");
            assertTrue(messageWeHave.equals(messageShouldBe));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("^Login to the Easytox with login \"([^\"]*)\" and password \"([^\"]*)\" credentials.$")
    public void loginIntoEasyTox(String login, String password) {
        try {
            signOut();
            Thread.sleep(1000);
            driver.findElement(By.name(WElement.loginPage_fieldName)).sendKeys(login);
            driver.findElement(By.name(WElement.loginPage_passwordField)).sendKeys(password);
            driver.findElement(By.cssSelector(WElement.loginPage_loginButton)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^\"Change Password\" screen with following fields should be displayed: Username$")
    public void isUsernameFieldShowed() {
        boolean isUsernameFieldShowed = driver
                .findElement(By.cssSelector(WElement.changePasswordPage_usernameField))
                .isDisplayed();
        assertTrue(isUsernameFieldShowed);
    }

    @And("^Old Password$")
    public void isOldPasswordFieldShowed() {
        boolean isOldPasswordFieldShowed = driver
                .findElement(By.cssSelector(WElement.changePasswordPage_oldPasswordField))
                .isDisplayed();
        assertTrue(isOldPasswordFieldShowed);
    }

    @And("^New Password$")
    public void isNewPasswordFieldShowed() {
        boolean isNewPasswordFieldShowed = driver
                .findElement(By.cssSelector(WElement.changePasswordPage_newPasswordField))
                .isDisplayed();
        assertTrue(isNewPasswordFieldShowed);
    }

    @And("^Confirm Password$")
    public void isConfirmPasswordFieldShowed() {
        boolean isConfirmPasswordFieldShowed = driver
                .findElement(By.cssSelector(WElement.changePasswordPage_confirmPasswordField))
                .isDisplayed();
        assertTrue(isConfirmPasswordFieldShowed);
    }

    @When("^Verify username \"([^\"]*)\" populated in \"Username\" field.$")
    public void checkUsernameInUsernameField(String autoPopulatedUsername){
        try {
            Thread.sleep(1000);

            String autoPopulatedUsernameWeHave = driver
                    .findElement(By.cssSelector(WElement.changePasswordPage_usernameField))
                    .getAttribute("value");
            assertTrue(autoPopulatedUsername.equals(autoPopulatedUsernameWeHave));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^\"SPhyTwo\" should be autopopulated in \"username\" field and it should NOT be editable.$")
    public void isUsernameFieldEditable(){
        String editable = driver
                .findElement(By.cssSelector(WElement.changePasswordPage_usernameField))
                .getAttribute("readonly");
        assertNotNull(editable);
    }

    @When("^Enter \"([^\"]*)\" in the Old Password field.$")
    public void enterOldPassword(String oldPassword){
        driver.findElement(By.cssSelector(WElement.changePasswordPage_oldPasswordField)).sendKeys(oldPassword);
    }

    @Then("^User old password should be successful.$")
    public void checkOldPassword(){
        String oldPassword = driver
                .findElement(By.cssSelector(WElement.changePasswordPage_oldPasswordField))
                .getAttribute("value");
        assertNotNull(oldPassword);
    }

    @When("^Enter \"([^\"]*)\" in the New Password field.$")
    public void enterPassword(String newPassword){
        driver.findElement(By.cssSelector(WElement.changePasswordPage_newPasswordField)).sendKeys(newPassword);
    }

    @Then("^User new password should be successful.$")
    public void checkNewPassword(){
        String newPassword = driver
                .findElement(By.cssSelector(WElement.changePasswordPage_newPasswordField))
                .getAttribute("value");
        assertNotNull(newPassword);
    }

    @When("^Enter \"([^\"]*)\" in the Confirm Password field.$")
    public void enterConfirmPassword(String confirmPassword){
        driver.findElement(By.cssSelector(WElement.changePasswordPage_confirmPasswordField)).sendKeys(confirmPassword);
    }

    @Then("^User entry should be successful.$")
    public void checkConfirmPassword(){
        String confirmPassword = driver
                .findElement(By.cssSelector(WElement.changePasswordPage_confirmPasswordField))
                .getAttribute("value");
        assertNotNull(confirmPassword);
    }

    @When("^Click save.$")
    public void clickSave(){
        driver.findElement(By.cssSelector(WElement.changePasswordPage_saveButton)).click();
    }

    @Then("^Login screen with message \"([^\"]*)\" should be displayed.$")
    public void checkShowedMessage(String messageShouldBeDisplayed){
        try {
            Thread.sleep(1000);

            String theMessageWeHave = driver
                    .findElement(By.cssSelector(WElement.loginPage_passwordChangedSuccessfullyMessage))
                    .getText();
            assertTrue(theMessageWeHave.equals(messageShouldBeDisplayed));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("^Enter \"([^\"]*)\" and \"([^\"]*)\" as user credentials and login.$")
    public void enterNewUserCredentials(String login, String password){
        driver.findElement(By.name(WElement.loginPage_fieldName)).clear();
        driver.findElement(By.name(WElement.loginPage_fieldName)).sendKeys(login);
        driver.findElement(By.name(WElement.loginPage_passwordField)).clear();
        driver.findElement(By.name(WElement.loginPage_passwordField)).sendKeys(password);
        driver.findElement(By.cssSelector(WElement.loginPage_loginButton)).click();
    }

    @Then("^User login should be successful with reset password.$")
    public void checkUserLogging(){
        try {
            Thread.sleep(1000);
            String thePageShouldBe = "http://bmtechsol.com:8080/easytox/orderFrom/list";
            String thePageWeHave = driver.getCurrentUrl();

            log.info(thePageShouldBe + "\n");
            log.info(thePageWeHave + "\n");

            assertTrue(thePageWeHave.equals(thePageShouldBe));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void close() {
        driver.close();
    }

    private void signOut() {
        try {
            Thread.sleep(1000);
            driver.findElement(By.cssSelector(WElement.loginDropDown)).click();
            Thread.sleep(500);
            driver.findElement(By.cssSelector(WElement.signOutField)).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean isExistLabClient(String labClient) {
        try {
            driver.findElement(By.linkText(WElement.textLinkSeeAllRequest)).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector(WElement.searchField)).sendKeys(labClient);
            Thread.sleep(1000);
            WebElement rowWithResult = driver.findElement(By.cssSelector(WElement.firstRowInResultOfSearch));
            return rowWithResult != null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    private WebElement getLabClient(String labClient) {
        List<WebElement> allResults = null;

        try {
            driver.findElement(By.linkText(WElement.textLinkSeeAllRequest)).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector(WElement.searchField)).sendKeys(labClient);
            Thread.sleep(1000);
            new Select(driver.findElement(By.cssSelector(WElement.itemPerPage))).selectByVisibleText("All");
            allResults = driver.findElements(By.cssSelector(WElement.allResultOfSearch));
            Thread.sleep(1000);

            for (int i = 0; i < allResults.size(); i++) {
                boolean isPendingRequest = allResults.get(i)
                        .findElement(By.cssSelector("#example > tbody > tr:nth-child(" + (i + 1) + ") > td:nth-child(6)"))
                        .getText()
                        .equals("Pending");
                if (isPendingRequest) {
                    return allResults.get(i);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}