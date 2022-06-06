package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.Collections;

public class SliderPage {
    protected WebDriver driver;

    @FindBy(xpath = "//*[@type='range']")
    private WebElement sliderElement;

    //POM constructor for page class
    public SliderPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SliderPage Slider(){

        //fluent wait
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2)) //how often it will be checked for the presence of the element
                .ignoreAll(Collections.singleton(NoSuchElementException.class));

        fluentWait.until(ExpectedConditions.elementToBeClickable(sliderElement));

        Actions action = new Actions(driver);
        action.dragAndDropBy(sliderElement, 80, 0).perform();


        return new SliderPage(driver);
    }
}
