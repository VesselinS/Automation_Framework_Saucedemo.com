package tests.qa.automation;

import base.TestUtil;
import org.testng.annotations.Test;
import pages.DatePickerPage;

public class DatePickerTest extends TestUtil {

    // Change in config.properties the below url to start the test!
    // https://demoqa.com/date-picker

    @Test

    public void DatePicker() throws InterruptedException {
        DatePickerPage datePickerPage = new DatePickerPage(driver);
        datePickerPage.datePicker();
        datePickerPage.dateTimePicker();


    }
}