import Pages.LandingPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testData.ReadData;

import java.io.IOException;

public class CheckLandingOnHomePage extends TestBase {


    LandingPage landingPage;

    @DataProvider(name = "ExcelData")
    public Object[][] searchData() throws IOException {
        //read from excel
        ReadData readData = new ReadData();
        return readData.read_data();

    }

    @Test(dataProvider = "ExcelData")
    public void CheckNavigationToHomePage(String homeURL, String keyword) {

        landingPage = new LandingPage(driver);
        softAssert.assertEquals(driver.getCurrentUrl(), homeURL);
        softAssert.assertAll();

        //I have included two  types of reports on of them is the xml report in (report/emailable-report.html)
        // and the other one is the extent report in (Luftborn\Extent Report.html)
        ExtentTest test1 = extent.createTest("Check landing on home page", "this test is to check that user is landing on home page correctly");
        test1.log(Status.INFO, "This step shows usage of log(status, details)");
        // info(details)
        test1.info("This step shows usage of info(details)");


    }
}
