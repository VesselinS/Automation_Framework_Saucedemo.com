package tests.qa.automation;

import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utils.CsvHelper;

import java.io.IOException;

public class ProblemUsersTest extends TestUtil {

    @DataProvider(name = "csvUserList")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/ProblemUsersProducts.csv");
    }

    @Test(dataProvider = "csvUserList")
    public void ProblemUsers(String userName, String password, String product1, String product2, String product3){
        //POM
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        ProductsPage productsPage = loginPage.login(userName, password);

        productsPage.userAllPagesButton();
        productsPage.addItemToTheCart(product1);
        productsPage.addItemToTheCart(product2);
        productsPage.addItemToTheCart(product3);
        productsPage.Checkout();
        cartPage.Checkout();
        checkoutInformationPage.Checkout();
        checkoutOverviewPage.Checkout();
        checkoutCompletePage.thanksMessage();

    }
}