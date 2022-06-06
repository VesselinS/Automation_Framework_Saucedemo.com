package tests.qa.automation;

import base.TestUtil;
import org.testng.annotations.Test;
import pages.DragAndDropPage;

public class DragAndDropTest extends TestUtil {

    // Change in config.properties the below url to start the test!
    // https://demoqa.com/droppable

    @Test

    public void DragAndDrop()
    {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.dragDrop();


    }
}