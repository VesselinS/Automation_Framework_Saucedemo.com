package tests.qa.automation;

import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.CsvHelper;
import java.io.IOException;

public class AddProductIntoCartTest extends TestUtil {

    @DataProvider(name = "csvUserList")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/ExistingUsersProducts.csv");
    }

    @Test(dataProvider = "csvUserList")
    public void AddProductIntoCart(String userName, String password, String product1, String product2, String product3){
        //POM
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login(userName, password);

        Assert.assertTrue(productsPage.checkUserAllPagesButton(), "The burger menu don't appear !");
        productsPage.addItemToTheCart(product1);
        productsPage.addItemToTheCart(product2);
        productsPage.addItemToTheCart(product3);
        productsPage.getItemsInTheCart();

    }
}
