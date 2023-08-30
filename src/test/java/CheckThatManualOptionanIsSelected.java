import Pages.LandingPage;
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
        softAssert.assertTrue( landingPage.isManualOptionChecked());
        softAssert.assertAll();

    }
}
