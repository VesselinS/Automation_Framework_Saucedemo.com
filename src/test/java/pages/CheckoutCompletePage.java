package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.Collections;

public class CheckoutCompletePage {
        protected WebDriver driver;


        @FindBy(xpath = "//*[text()='THANK YOU FOR YOUR ORDER']")
        private WebElement thanksMessage;

        public CheckoutCompletePage(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public boolean CheckThanksMessage (){

            //fluent wait
            FluentWait fluentWait = new FluentWait(driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(2)) //how often it will be checked for the presence of the element
                    .ignoreAll(Collections.singleton(NoSuchElementException.class));

            fluentWait.until(ExpectedConditions.elementToBeClickable(thanksMessage));

            try {
                boolean result = thanksMessage.isDisplayed();
                return result;
            }catch (NoSuchElementException e) {
                return false;
            }
        }
    }


