import Pages.LandingPage;
import com.google.common.base.Verify;
import com.google.common.base.VerifyException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testData.ReadData;

import java.io.IOException;

public class CheckThatManualOptionanIsSelected extends TestBase{
    LandingPage landingPage;

    @DataProvider(name = "ExcelData")
    public Object[][]searchData() throws IOException {
        //read from excel
        ReadData readData = new ReadData();
        return readData.read_data();

    }
    @Test(dataProvider = "ExcelData")
    public void checkTransmissionTypeIsManual(String homeURL,String keyword)
    {
        landingPage=new LandingPage(driver);
        landingPage.clickOnSearchBar();
        landingPage.enterDataToSearchFor(keyword);
        landingPage.ClickOnSearchButton();
        landingPage.ClickOnManualCheckBox();
        Actions actions= new Actions(driver);

        softAssert.assertTrue( landingPage.isManualOptionChecked());
        softAssert.assertAll();
    }
}
