package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Collections;

public class DatePickerPage {
    protected WebDriver driver;

    @FindBy(xpath = "//input[@id='datePickerMonthYearInput']")
    private WebElement clickDate;

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    private WebElement selectMonth;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    private WebElement selectYear;

    @FindBy(xpath = "//div[@class='react-datepicker__day react-datepicker__day--008']")
    private WebElement selectDay;

    @FindBy(xpath = "//input[@id='dateAndTimePickerInput']")
    private WebElement clickDateTime;

    @FindBy(xpath = "//span[@class='react-datepicker__month-read-view--selected-month']")
    private WebElement clickDateTimeMonth;

    @FindBy(xpath = "//div[@class='react-datepicker__month-option'][text()='January']")
    private WebElement selectDateTimeMonth;

    @FindBy(xpath = "//span[@class='react-datepicker__year-read-view--selected-year']")
    private WebElement clickDateTimeYear;

    @FindBy(xpath = "//a[@class='react-datepicker__navigation react-datepicker__navigation--years react-datepicker__navigation--years-upcoming']")
    private WebElement selectDateTimeYearArrowUp;

    @FindBy(xpath = "//div[@class='react-datepicker__year-option'][text()='2028']")
    private WebElement selectDateTimeYear;

    @FindBy(xpath = "//div[@class='react-datepicker__day react-datepicker__day--008 react-datepicker__day--weekend']")
    private WebElement selectDateTimeDate;

    @FindBy(xpath = "//ul[@class='react-datepicker__time-list']/li[25]")
    private WebElement selectDateTimeClock;

    //POM constructor for page class
    public DatePickerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DatePickerPage datePicker(){

        //fluent wait
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2)) //how often it will be checked for the presence of the element
                .ignoreAll(Collections.singleton(NoSuchElementException.class));

        fluentWait.until(ExpectedConditions.elementToBeClickable(clickDate));
        clickDate.click();
        fluentWait.until(ExpectedConditions.elementToBeClickable(selectMonth));
        Select month = new Select(selectMonth);
        month.selectByIndex(7);
        fluentWait.until(ExpectedConditions.elementToBeClickable(selectYear));
        Select year = new Select(selectYear);
        year.selectByValue("1983");
        fluentWait.until(ExpectedConditions.elementToBeClickable(selectDay));
        selectDay.click();



        return new DatePickerPage(driver);
    }

    public DatePickerPage dateTimePicker() throws InterruptedException {

        //fluent wait
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2)) //how often it will be checked for the presence of the element
                .ignoreAll(Collections.singleton(NoSuchElementException.class));

        fluentWait.until(ExpectedConditions.elementToBeClickable(clickDateTime));
        clickDateTime.click();
        fluentWait.until(ExpectedConditions.elementToBeClickable(clickDateTimeMonth));
        clickDateTimeMonth.click();
        fluentWait.until(ExpectedConditions.elementToBeClickable(selectDateTimeMonth));
        selectDateTimeMonth.click();
        fluentWait.until(ExpectedConditions.elementToBeClickable(clickDateTimeYear));
        clickDateTimeYear.click();
        fluentWait.until(ExpectedConditions.elementToBeClickable(selectDateTimeYearArrowUp));
        selectDateTimeYearArrowUp.click();
        fluentWait.until(ExpectedConditions.elementToBeClickable(selectDateTimeYear));
        selectDateTimeYear.click();
        fluentWait.until(ExpectedConditions.elementToBeClickable(selectDateTimeDate));
        selectDateTimeDate.click();
        fluentWait.until(ExpectedConditions.elementToBeClickable(selectDateTimeClock));
        selectDateTimeClock.click();




        return new DatePickerPage(driver);
    }
}
