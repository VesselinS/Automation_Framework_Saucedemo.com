package tests.qa.automation;

import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.CsvHelper;
import java.io.IOException;

public class UnsuccessfulLoginTest extends TestUtil {

    @DataProvider(name = "csvUserList")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/NotExistingUsers.csv");
    }

    @Test(dataProvider = "csvUserList")
    public void UnsuccessfulLogin(String userName, String password){
        //POM
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName, password);
        loginPage.errorLoginLabel();


    }
}

