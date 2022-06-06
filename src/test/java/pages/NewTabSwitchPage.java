package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

public class NewTabSwitchPage {
    protected WebDriver driver;

    @FindBy(linkText = "Team")
    private WebElement link;

    //POM constructor for page class
    public NewTabSwitchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public NewTabSwitchPage NewTabSwitch(){

        //fluent wait
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2)) //how often it will be checked for the presence of the element
                .ignoreAll(Collections.singleton(NoSuchElementException.class));

        fluentWait.until(ExpectedConditions.elementToBeClickable(link));

        // method Keys.chord
        String n = Keys.chord(Keys.CONTROL, Keys.ENTER);
        link.sendKeys(n);
        // store window handle ids
        ArrayList<String> w = new ArrayList<String>(driver.getWindowHandles());
        //switch to open tab
        driver.switchTo().window(w.get(1));
        System.out.println("New tab title: " + driver.getTitle());
        //switch to first tab
        driver.switchTo().window(w.get(0));
        System.out.println("First tab title: " + driver.getTitle());

        return new NewTabSwitchPage(driver);
    }
}