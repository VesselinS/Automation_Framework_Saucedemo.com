package tests.qa.automation;

import base.TestUtil;
import org.testng.annotations.Test;
import pages.NewTabSwitchPage;

public class NewTabSwitchTest extends TestUtil {

    // Change in config.properties the below url to start the test!
    // https://www.tutorialspoint.com/about/about_careers.htm

    @Test

    public void NewTabSwitch()
    {
        NewTabSwitchPage newTabSwitchPage = new NewTabSwitchPage(driver);
        newTabSwitchPage.newTabSwitch();


    }
}