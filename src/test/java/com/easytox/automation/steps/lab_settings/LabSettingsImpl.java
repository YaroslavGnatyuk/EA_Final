package com.easytox.automation.steps.lab_settings;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.LocatorType;
import com.easytox.automation.utils.MyWebDriverUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Alexander on 19.01.2017.
 */
public class LabSettingsImpl {
    private static final String PASSWORD = "Welcome@123";
    private static final String LOGIN = "cgilabadmin";
    private static final String LOGIN_PAGE_URL = "http://bmtechsol.com:8080/easytox/";
    private static final String PASSWORD_LOCATOR = "j_password";
    private static final String LOGIN_LOCATOR = "j_username";
    private static final String LOGIN_BUTTON_XPATH = "//*[@id=\"loginform\"]/div[3]/div/button";
    private static final String WIDGET_CASE_LIST_LOCATOR = "#maincontentdiv > div.page-body > div > div > div > div.widget-header > span";
    private static final String WIDGET_CASE_LIST_VALUE = "Case List";
    private static final String CASE_LIST_URL = "http://bmtechsol.com:8080/easytox/caseOrder/list";
    private static final String SELECT_LAB_LOCATOR = "body > div.navbar > div > div > div.navbar-header.pull-right > div > ul > li:nth-child(7) > a";
    private static final String LAB_SETTINGS_LOCATOR = "body > div.navbar > div > div > div.navbar-header.pull-right > div > ul > li.open > ul > li:nth-child(2) > a";
    private static final String EDIT_LAB_PAGE_URL = "http://bmtechsol.com:8080/easytox/lab/settings";
    private static final String WIDGET_UPDATE_LAB_LOCATOR = "#maincontentdiv > div.page-body > div > div.widget-header > span";
    private static final String WIDGET_UPDATE_VALUE = "Update Lab";
    private static final String LAB_LOGO_LOCATOR = "logo";
    private static final String HELP_BLOCK_LOCATOR = "#settingsform > div.form-group.has-success > div:nth-child(2) > small";
    private static final String HELP_BLOCK_ATTRIBUTE = "data-bv-result";
    private static final String HELP_BLOCK_SUCCESS_VALUE = "VALID";
    private static final String FILE_PATH = "C:\\Users\\Alexander\\Desktop\\media-lab.jpg";
    private static final String EMAIL_PIN = "1234";
    private static final String EMAIL_PIN_LOCATOR = "emailpin";
    private static final String EMAIL_HELP_BLOCK_LOCATOR = "#settingsform > div:nth-child(4) > div:nth-child(2) > small";
    private static final String ICON = "#settingsform > div:nth-child(4) > div:nth-child(2) > span > i";
    private static final String ATTRIBUTE = "value";
    private static final String CLIA_LOCATOR = "cliaId";
    private static final String CLIA_VALUE = "4321";
    private static final String LAB_DIRECTOR_LOCATOR = "labDirector";
    private static final String LAB_DIRECTOR_VALUE = "Sujana";
    private static final String REPORT_TEMPLATE_LOCATOR = "reportTemplate";
    private static final String STANDARD_TEMPLATE = "//*[@id=\"reportTemplate\"]/div[1]/div/label/span";
    private static final String UPDATE_BUTTON_LOCATOR = "#settingsform > div:nth-child(13) > div > button";
    private static final String ALLERT_SUCCESS = "#maincontentdiv > div.page-body > div.alert.alert-success.fade.in";
    private static final String ADD_CONTACT = "#maincontentdiv > div.page-body > div > div.widget-header > div > div > button";
    private static final String NEW_CONTACTS_COUNT = "newcontactscount";

    private static final String UPDATE_BUTTON = "#settingsform > div:nth-child(14) > div > button";
    private static final String LOGO_LOCATOR = "logoExists";
    private static final String IMAGE_LOCATOR = "#settingsform > div:nth-child(3) > div:nth-child(3) > img";
    private static final String SRC = "src";
    private static final String SRC_VALUE = "http://bmtechsol.com:8080/easytox/lab/viewLogo";
    private static final String TRUE = "true";
    private static final String PIN_LOCATOR = "#settingsform > div:nth-child(4) > div:nth-child(3)";
    private static final String PIN_VALUE = "1234";
    private static final String STANDARD_REPORT = "//*[@id=\"reportTemplate\"]/div[1]/div/label/input";


    private static List<WebElement> listTemplate;

    private WebDriver driver;

    public LabSettingsImpl() {
        DriverBase.instantiateDriverObject();
        driver = DriverBase.getDriver();
    }

    /*
    Scenario: Enter Lab Settings
     */

    @When("^Login to Easytox using credentials cgilabadmin/Welcome@123$")
    public void login() {
        MyWebDriverUtils.authorization(driver, LOGIN_PAGE_URL,
                LOGIN_LOCATOR, LocatorType.NAME, LOGIN,
                PASSWORD_LOCATOR, LocatorType.NAME, PASSWORD,
                LOGIN_BUTTON_XPATH, LocatorType.XPATH);
    }

    @Then("^User login should be successful.$")
    public void check_login() {
        MyWebDriverUtils.checkWidgetCaption(driver, WIDGET_CASE_LIST_LOCATOR, LocatorType.CSS, WIDGET_CASE_LIST_VALUE);
        MyWebDriverUtils.checkCurrentUrl(driver, CASE_LIST_URL);
    }

    @When("^Select Lab -> Lab Settings.$")
    public void go_to_lab_settings() {
        MyWebDriverUtils.waitContainerThenClick(driver, SELECT_LAB_LOCATOR, LocatorType.CSS);
        MyWebDriverUtils.waitContainerThenClick(driver, LAB_SETTINGS_LOCATOR, LocatorType.CSS);

    }

    @Then("^Lab Settings screen should be displayed.$")
    public void lab_settings_screen_should_be_displayed() {
        MyWebDriverUtils.checkWidgetCaption(driver, WIDGET_UPDATE_LAB_LOCATOR, LocatorType.CSS, WIDGET_UPDATE_VALUE);
        MyWebDriverUtils.checkCurrentUrl(driver, EDIT_LAB_PAGE_URL);
    }

    @When("^Upload a file to 'Lab Logo'.$")
    public void upload_file_to_lab_logo() {
        File f = new File(FILE_PATH);
        String path = f.getAbsolutePath();
        WebElement el = MyWebDriverUtils.findElement(driver, LAB_LOGO_LOCATOR, LocatorType.NAME);
        if (el != null) {
            el.sendKeys(path);
        }
    }

    @Then("^File with logo should be uploaded successfully.$")
    public void check_uploaded_file() {
        WebElement helpBlock = MyWebDriverUtils.findPresenceElement(driver, HELP_BLOCK_LOCATOR, LocatorType.CSS);
        if (helpBlock != null) {
            Assert.assertEquals(helpBlock.getAttribute(HELP_BLOCK_ATTRIBUTE), HELP_BLOCK_SUCCESS_VALUE);
        }
    }


    @When("^Verify that the logo in the file should be displayed beside 'Lab Logo' input box.$")
    public void verify_logo() {
        WebElement el = MyWebDriverUtils.findPresenceElement(driver, LOGO_LOCATOR, LocatorType.NAME);
        if (el != null) {
            Assert.assertEquals(el.getAttribute(ATTRIBUTE), TRUE);
        }
    }

    @Then("^Uploaded logo should be displayed beside 'Lab Logo' input box.$")
    public void uploaded_logo_should_be_displayed_beside() {
        WebElement logo = MyWebDriverUtils.findPresenceElement(driver, IMAGE_LOCATOR, LocatorType.CSS);
        if (logo != null) {
            Assert.assertEquals(logo.getAttribute(SRC), SRC_VALUE);
            Assert.assertTrue(logo.getSize().getHeight() > 10);
            Assert.assertTrue(logo.getSize().getWidth() > 10);
        }
    }

    @When("^Enter Email Pin$")
    public void enterEmailPin() {
        MyWebDriverUtils.enterData(driver, EMAIL_PIN_LOCATOR, LocatorType.NAME, EMAIL_PIN);
        MyWebDriverUtils.waitContainerThenClick(driver, ICON, LocatorType.CSS);
    }

    @Then("^Email Pin should be entered successfully. Pin should be encrypted.$")
    public void check_email_pin() {
        WebElement helpBlock = MyWebDriverUtils.findPresenceElement(driver, EMAIL_HELP_BLOCK_LOCATOR, LocatorType.CSS);
        if (helpBlock != null) {
            Assert.assertEquals(helpBlock.getAttribute(HELP_BLOCK_ATTRIBUTE), HELP_BLOCK_SUCCESS_VALUE);
        }
        WebElement pin = MyWebDriverUtils.findElement(driver, EMAIL_PIN_LOCATOR, LocatorType.NAME);
        if (pin != null) {
            Assert.assertEquals(pin.getAttribute(ATTRIBUTE), EMAIL_PIN);
        }
    }

    @When("^Verify that entered Email Pin is displayed beside 'Email Pin' input box.$")
    public void verify_that_entered_email_pin_is_displayed_beside() {
        WebElement pin = MyWebDriverUtils.findVisibilityElement(driver, PIN_LOCATOR, LocatorType.CSS);
        if (pin != null) {
            Assert.assertTrue(!pin.getText().equals(""));
        } else {
            Assert.fail("email pin is not displayed");
        }
    }

    @Then("^Entered Pin number should be displayed beside 'Email Pin' input box.$")
    public void check_entered_pin_number() {
        WebElement pin = MyWebDriverUtils.findVisibilityElement(driver, PIN_LOCATOR, LocatorType.CSS);
        if (pin != null) {
            Assert.assertEquals(pin.getText(), PIN_VALUE);
        } else {
            Assert.fail("email pin is not displayed");
        }
    }

    @When("^Enter a number in CLIA field.$")
    public void enter_a_number_in_CLIA_field() {
        MyWebDriverUtils.enterData(driver, CLIA_LOCATOR, LocatorType.NAME, CLIA_VALUE);
    }

    @Then("^User should be able to enter CLIA number$")
    public void check_CLIA() {
        WebElement clia = MyWebDriverUtils.findElement(driver, CLIA_LOCATOR, LocatorType.NAME);
        if (clia != null) {
            Assert.assertEquals(clia.getAttribute(ATTRIBUTE), CLIA_VALUE);
        }
    }

    @When("^Enter a value in Lab Director field.$")
    public void enter_lab_director() {
        MyWebDriverUtils.enterData(driver, LAB_DIRECTOR_LOCATOR, LocatorType.NAME, LAB_DIRECTOR_VALUE);
    }

    @Then("^User should be able to enter a valid Lab Director.$")
    public void check_lab_director() {
        WebElement director = MyWebDriverUtils.findElement(driver, LAB_DIRECTOR_LOCATOR, LocatorType.NAME);
        if (director != null) {
            Assert.assertEquals(director.getAttribute(ATTRIBUTE), LAB_DIRECTOR_VALUE);
        }
    }

    // TODO: 19.01.2017 enter fax number

    @When("^Enter a value in Fax Number field.$")
    public void enter_fax_number() {

    }

    @Then("^Fax Number should be entered successfully.$")
    public void check_fax_number() {

    }

    @When("Verify the report template options.")
    public void verify_the_report_template_options() {
        WebElement template = MyWebDriverUtils.findElement(driver, REPORT_TEMPLATE_LOCATOR, LocatorType.ID);
        if (template != null) {
            listTemplate = MyWebDriverUtils.findElements(driver, REPORT_TEMPLATE_LOCATOR, LocatorType.NAME);
        }
    }

    @Then("^Following four radio options should be available for Report template: (\\w{8}) Template, (\\w{7}) Template, (\\w{6}) Template, (\\w{5}) Template$")
    public void check_report_template(String standard, String tabular, String colour, String chart) {
        String template = "Template";
        if (listTemplate != null) {
            Assert.assertEquals(listTemplate.get(0).getAttribute(ATTRIBUTE), standard + template);
            Assert.assertEquals(listTemplate.get(1).getAttribute(ATTRIBUTE), colour + template);
            Assert.assertEquals(listTemplate.get(2).getAttribute(ATTRIBUTE), tabular + template);
            Assert.assertEquals(listTemplate.get(3).getAttribute(ATTRIBUTE), chart + template);
        }
    }

    @When("^Choose any report template$")
    public void choose_any_report_template() {
        WebElement template = MyWebDriverUtils.findElement(driver, STANDARD_TEMPLATE, LocatorType.XPATH);
        if (template != null) {
            template.click();
        }
    }

    @Then("^User should be able to select desired report template.$")
    public void check_select_desired_report_template() {
        WebElement report = MyWebDriverUtils.findPresenceElement(driver, STANDARD_REPORT, LocatorType.XPATH);
        if (report != null) {
            Assert.assertTrue(report.isSelected());
        } else {
            Assert.fail("report is null!");
        }
    }

    @When("^Click Update$")
    public void click_update() {
        MyWebDriverUtils.waitContainerThenClick(driver, UPDATE_BUTTON_LOCATOR, LocatorType.CSS);
    }

    @Then("^Lab Setting should be saved successfully.$")
    public void lab_settings_should_be_saved_successfully() {
        MyWebDriverUtils.checkPageCaption(driver, ALLERT_SUCCESS, LocatorType.CSS, "x\nSuccess Lab CGI DEMO Lab updated");
        MyWebDriverUtils.checkCurrentUrl(driver, CASE_LIST_URL);
    }

    /*
    Scenario: Add Contact to Lab Settings
     */

    @When("^Click on 'Add Contact' icon.$")
    public void click_on_add_contact_icon() {
        MyWebDriverUtils.waitContainerThenClick(driver, ADD_CONTACT, LocatorType.CSS);
    }

    @Then("^'Contact Info' section should be displayed in the bottom of the screen.$")
    public void check_contact_info_section() {
        WebElement el = MyWebDriverUtils.findPresenceElement(driver, NEW_CONTACTS_COUNT, LocatorType.NAME);
        if (el != null) {
            Assert.assertEquals(el.getAttribute(ATTRIBUTE), "1");
        }
    }

    @When("^Enter the required details.$")
    public void enter_required_details() {
        MyWebDriverUtils.enterData(driver, Contact.CONTACT_NAME_LOCATOR, LocatorType.NAME, Contact.CONTACT_NAME);
        MyWebDriverUtils.enterData(driver, Contact.CONTACT_EMAIL_LOCATOR, LocatorType.NAME, Contact.CONTACT_EMAIL);
        MyWebDriverUtils.enterData(driver, Contact.CONTACT_FAX_LOCATOR, LocatorType.NAME, Contact.CONTACT_FAX);
        MyWebDriverUtils.enterData(driver, Contact.CONTACT_PHONE_LOCATOR, LocatorType.NAME, Contact.CONTACT_PHONE);

        MyWebDriverUtils.waitContainerThenClick(driver, Contact.CONTACT_NAME_LOCATOR, LocatorType.NAME);

    }

    @Then("^Following values should be entered successfully: Contact Name, Contact Email, Contact Fax, Contact Phone$")
    public void check_entered_values() {
        checkValidData(Contact.CONTACT_NAME_HELP_BLOCK);
        checkValidData(Contact.CONTACT_EMAIL_HELP_BLOCK_1);
        checkValidData(Contact.CONTACT_EMAIL_HELP_BLOCK_2);
        checkValidData(Contact.CONTACT_FAX_HELP_BLOCK_1);
        checkValidData(Contact.CONTACT_FAX_HELP_BLOCK_2);
        checkValidData(Contact.CONTACT_PHONE_HELP_BLOCK_1);
        checkValidData(Contact.CONTACT_PHONE_HELP_BLOCK_2);
    }

    private void checkValidData(String locator) {
        WebElement helpBlock = MyWebDriverUtils.findPresenceElement(driver, locator, LocatorType.CSS);
        if (helpBlock != null) {
            Assert.assertEquals(helpBlock.getAttribute(HELP_BLOCK_ATTRIBUTE), HELP_BLOCK_SUCCESS_VALUE);
        }
    }

    @When("^Click Update.$")
    public void click_update_button() {
        MyWebDriverUtils.waitContainerThenClick(driver, UPDATE_BUTTON, LocatorType.CSS);
    }

    @Then("^Contact information should be saved successfully.$")
    public void contact_information_should_be_saved_successfully() {
        MyWebDriverUtils.checkPageCaption(driver, ALLERT_SUCCESS, LocatorType.CSS, "x\nSuccess Lab CGI DEMO Lab updated");
        MyWebDriverUtils.checkCurrentUrl(driver, CASE_LIST_URL);
    }

    /*
    Scenario: Verify Lab Logo in the report.
     */

    @When("^Make a note of lab logo.$")
    public void make_a_note_of_lab_logo() {
        verify_logo();
    }

    @Then("^Lab logo should be remembered.$")
    public void lab_logo_should_be_remembered() {
        uploaded_logo_should_be_displayed_beside();
    }

    @When("^Go to Case List$")
    public void go_to_case_list() {
        driver.get(CASE_LIST_URL);
    }

    @Then("^Case List screen should be displayed.$")
    public void case_list_screen_should_be_displayed() {
        MyWebDriverUtils.checkWidgetCaption(driver, WIDGET_CASE_LIST_LOCATOR, LocatorType.CSS, WIDGET_CASE_LIST_VALUE);
        MyWebDriverUtils.checkCurrentUrl(driver, CASE_LIST_URL);
    }

    @When("^Select a report by clicking on PDF icon against any existing case.$")
    public void select_report_by_clicking_on_pdf_icon() {
        MyWebDriverUtils.selectOption(driver, "caseorder_length", LocatorType.NAME, "All");

        WebElement table = MyWebDriverUtils.findElement(driver, "caseorder", LocatorType.ID);
        if (table != null) {
            List<WebElement> lst = MyWebDriverUtils.findElements(driver, "tr", LocatorType.TAG, table);
            if (lst != null) {
                for (int i = 1; i < lst.size(); i++) {
                    WebElement el = MyWebDriverUtils.findElement(driver, "#caseorder > tbody > tr:nth-child(" + i + ") > td:nth-child(9)", LocatorType.CSS);
                    if (el != null) {
                        try {
                            WebElement form = el.findElement(By.tagName("form"));
                            MyWebDriverUtils.waitContainerThenClick(driver, form);
                            break;
                        } catch (NoSuchElementException ex) {
                            System.out.println("No report in this case!");
                        }
                    }

                }
            }
        }


    }

    @Then("^Report should be opened successfully.$")
    public void report_should_be_opened_successfully() throws InterruptedException {
        Thread.sleep(2000);
        File f = new File("C:\\Users\\Alexander\\Downloads\\UC201602040013.PDF");
        Assert.assertTrue(f.exists());

        driver.get("file:///C:/Users/Alexander/Downloads/UC201602040013.PDF");
    }

    @When("^Verify the lab logo on the top left of the report.$")
    public void verify_the_lab_logo() throws IOException {

        /*
        extracting images from downloaded pdf file
         */
        File file = new File("C:\\Users\\Alexander\\Downloads\\UC201602040013.pdf");
        PDDocument document = PDDocument.load(file);

        List<BufferedImage> list =  getImagesFromPDF(document);
        ImageIO.write(list.get(1), "JPEG", new File("C:\\Users\\Alexander\\Desktop\\myPDFs\\logo1.jpg"));

        document.close();

    }

    @Then("^Lab Logo should be displayed same as the logo noted in Step 3 above.$")
    public void check_lab_logo() throws IOException {
        /*
        verify two images
         */
        File downloadedLogo = new File("C:\\Users\\Alexander\\Desktop\\myPDFs\\logo1.jpg");
        File logo = new File("C:\\Users\\Alexander\\Desktop\\myPDFs\\media-lab.jpg");

        BufferedImage bufferfileInput = ImageIO.read(downloadedLogo);
        DataBuffer datafileInput = bufferfileInput.getData().getDataBuffer();
        int sizefileInput = datafileInput.getSize();

        BufferedImage bufferfileOutPut = ImageIO.read(logo);
        DataBuffer datafileOutPut = bufferfileOutPut.getData().getDataBuffer();
        int sizefileOutPut = datafileOutPut.getSize();

        Boolean matchFlag = true;
        if(sizefileInput == sizefileOutPut) {
            for(int i=0; i<sizefileInput; i++) {
                if(datafileInput.getElem(i) != datafileOutPut.getElem(i)) {
                    matchFlag = false;
                    break;
                }
            }
        }
        else {
            matchFlag = false;
        }

        Assert.assertTrue(matchFlag);
    }

    private static List<BufferedImage> getImagesFromPDF(PDDocument document) throws IOException {
        List<BufferedImage> images = new ArrayList<>();
        for (PDPage page : document.getPages()) {
            images.addAll(getImagesFromResources(page.getResources()));
        }

        return images;
    }

    private static List<BufferedImage> getImagesFromResources(PDResources resources) throws IOException {
        List<BufferedImage> images = new ArrayList<>();

        for (COSName xObjectName : resources.getXObjectNames()) {
            PDXObject xObject = resources.getXObject(xObjectName);

            if (xObject instanceof PDFormXObject) {
                images.addAll(getImagesFromResources(((PDFormXObject) xObject).getResources()));
            } else if (xObject instanceof PDImageXObject) {
                images.add(((PDImageXObject) xObject).getImage());
            }
        }

        return images;
    }

    private static final class Contact {
        private Contact() {
        }

        private static final String CONTACT_NAME_LOCATOR = "newcontact[0].contact_person_name";
        private static final String CONTACT_EMAIL_LOCATOR = "newcontact[0].contact_person_email";
        private static final String CONTACT_FAX_LOCATOR = "newcontact[0].contact_person_phone";
        private static final String CONTACT_PHONE_LOCATOR = "newcontact[0].contact_person_fax";

        private static final String CONTACT_NAME = "Alexander";
        private static final String CONTACT_EMAIL = "alex@gmail.com";
        private static final String CONTACT_FAX = "1234567890";
        private static final String CONTACT_PHONE = "3333333333";

        private static final String CONTACT_NAME_HELP_BLOCK = "#settingsform > div:nth-child(12) > div:nth-child(2) > div:nth-child(2) > small";
        private static final String CONTACT_EMAIL_HELP_BLOCK_1 = "#settingsform > div:nth-child(12) > div:nth-child(2) > div:nth-child(3) > small:nth-child(2)";
        private static final String CONTACT_EMAIL_HELP_BLOCK_2 = "#settingsform > div:nth-child(12) > div:nth-child(2) > div:nth-child(3) > small:nth-child(3)";
        private static final String CONTACT_FAX_HELP_BLOCK_1 = "#settingsform > div:nth-child(12) > div:nth-child(3) > div:nth-child(2) > small:nth-child(2)";
        private static final String CONTACT_FAX_HELP_BLOCK_2 = "#settingsform > div:nth-child(12) > div:nth-child(3) > div:nth-child(2) > small:nth-child(3)";
        private static final String CONTACT_PHONE_HELP_BLOCK_1 = "#settingsform > div:nth-child(12) > div:nth-child(3) > div:nth-child(3) > small:nth-child(2)";
        private static final String CONTACT_PHONE_HELP_BLOCK_2 = "#settingsform > div:nth-child(12) > div:nth-child(3) > div:nth-child(3) > small:nth-child(3)";

    }
}
