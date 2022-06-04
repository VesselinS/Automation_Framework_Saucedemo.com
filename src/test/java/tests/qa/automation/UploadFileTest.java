package tests.qa.automation;

import base.TestUtil;
import org.testng.annotations.Test;
import pages.UploadFilePage;

import java.awt.*;


public class UploadFileTest extends TestUtil {

    // Change in config.properties the below url to start the test!
    // https://demoqa.com/upload-download

    @Test
    public void UploadFile() throws AWTException, InterruptedException {
        //POM
        UploadFilePage uploadFile = new UploadFilePage(driver);
        uploadFile.Upload();

    }
}
