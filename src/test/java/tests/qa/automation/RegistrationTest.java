package tests.qa.automation;

import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utils.CsvHelper;

import java.io.IOException;

public class RegistrationTest extends TestUtil {

    // Change in config.properties the below url to start the test!
    // https://www.obuvki.bg/customer/account/create

    @DataProvider(name = "csvUserList")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/RegistrationData.csv");
    }

    @Test(dataProvider = "csvUserList")
    public void Registration(String firstName, String lastName, String email, String password, String confirmPassword){
        //POM
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(firstName, lastName, email, password, confirmPassword);


    }
}
