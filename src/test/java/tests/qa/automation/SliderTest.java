package tests.qa.automation;

import base.TestUtil;
import org.testng.annotations.Test;
import pages.SliderPage;

public class SliderTest extends TestUtil {

    // Change in config.properties the below url to start the test!
    // http://jqueryui.com/resources/demos/slider/default.html

    @Test

    public void Slider()
    {
        SliderPage sliderPage = new SliderPage(driver);
        sliderPage.slider();


    }
}