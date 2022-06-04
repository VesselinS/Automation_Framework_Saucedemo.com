package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.Collections;

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

        fluentWait.until(ExpectedConditions.elementToBeClickable(advertisementClose));
        advertisementClose.click();

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

}