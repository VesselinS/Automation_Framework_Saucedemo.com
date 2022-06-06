package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.Collections;

public class DragAndDropPage {
    protected WebDriver driver;

    @FindBy(xpath = "//div[@id='draggable']")
    private WebElement dragElement;

    @FindBy(xpath = "//div[@id='droppable']")
    private WebElement dropElement;

    //POM constructor for page class
    public DragAndDropPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DragAndDropPage dragDrop(){

        //fluent wait
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2)) //how often it will be checked for the presence of the element
                .ignoreAll(Collections.singleton(NoSuchElementException.class));

        fluentWait.until(ExpectedConditions.elementToBeClickable(dragElement));
        fluentWait.until(ExpectedConditions.elementToBeClickable(dropElement));

        //Creating object of Actions class to build composite actions
        Actions builder = new Actions(driver);

        //Building a drag and drop action
        Action dragAndDrop = builder.clickAndHold(dragElement)
                .moveToElement(dropElement)
                .release(dropElement)
                .build();

        //Performing the drag and drop action
        dragAndDrop.perform();


        return new DragAndDropPage(driver);
    }
}

