package pages;

import com.opencsv.CSVWriter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RegistrationPage {

    protected WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Съгласие')]")
    private WebElement popUpConfirmation;

    @FindBy(xpath = "//div[@id='newsletter_banner_exit_salomon']")
    private WebElement advertisementClose;

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='email_address']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='confirmation']")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/form[1]/div[7]/label[1]/*[1]")
    private WebElement checkboxInput;

    @FindBy(xpath = "//button[@id='create-account']")
    private WebElement RegistrationBtn;

    //POM constructor for page class
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage registration(String firstName, String lastName, String email, String password, String confirmPassword){

        //fluent wait
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2)) //how often it will be checked for the presence of the element
                .ignoreAll(Collections.singleton(NoSuchElementException.class));

        fluentWait.until(ExpectedConditions.elementToBeClickable(popUpConfirmation));
        popUpConfirmation.click();

//        fluentWait.until(ExpectedConditions.elementToBeClickable(advertisementClose));
//        advertisementClose.click();

        fluentWait.until(ExpectedConditions.elementToBeClickable(firstNameInput));

        firstNameInput.click();
        firstNameInput.sendKeys(firstName);

        fluentWait.until(ExpectedConditions.elementToBeClickable(lastNameInput));
        lastNameInput.click();
        lastNameInput.sendKeys(lastName);

        fluentWait.until(ExpectedConditions.elementToBeClickable(emailInput));
        emailInput.click();
        emailInput.sendKeys(email);

        fluentWait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.click();
        passwordInput.sendKeys(password);

        fluentWait.until(ExpectedConditions.elementToBeClickable(confirmPasswordInput));
        confirmPasswordInput.click();
        confirmPasswordInput.sendKeys(confirmPassword);

        fluentWait.until(ExpectedConditions.elementToBeClickable(checkboxInput));
        checkboxInput.click();

        fluentWait.until(ExpectedConditions.elementToBeClickable(RegistrationBtn));
        RegistrationBtn.click();

        return new RegistrationPage(driver);
    }

    public static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public RegistrationPage writeRandomEmailCsv() throws IOException {

        List<String[]> csvData = createCsvDataSimple();

        // default all fields are enclosed in double quotes
        // default separator is a comma
        try (CSVWriter writer = new CSVWriter(new FileWriter("src/test/resources/RegistrationData.csv"))) {
            writer.writeAll(csvData);
        }

        return null;
    }

    public static List<String[]> createCsvDataSimple() {
        String s = getSaltString() + "@gmail.com";

        String[] header = {"Test", "Test", s, "123qwe", "123qwe"};
//        String[] record1 = {"Test", "Test", s, "123qwe", "123qwe"};
//        String[] record2 = {"Test", "Test", s, "123qwe", "123qwe"};

        List<String[]> list = new ArrayList<>();
        list.add(header);
//        list.add(record1);
//        list.add(record2);

        return list;
    }

}