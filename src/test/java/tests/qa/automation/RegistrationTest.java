package tests.qa.automation;

import base.TestUtil;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utils.CsvHelper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static pages.RegistrationPage.createCsvDataSimple;

public class RegistrationTest extends TestUtil {

    // Change in config.properties the below url to start the test!
    // https://www.obuvki.bg/customer/account/create

    @DataProvider(name = "csvUserList")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/RegistrationData.csv");
    }

    @Test(dataProvider = "csvUserList")
    public void Registration(String firstName, String lastName, String email, String password, String confirmPassword) throws IOException {
        //POM
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.writeRandomEmailCsv();
        registrationPage.registration(firstName, lastName, email, password, confirmPassword);


    }
}
