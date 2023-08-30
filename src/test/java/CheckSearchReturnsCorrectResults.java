import Pages.LandingPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testData.ReadData;

import java.io.IOException;

public class CheckSearchReturnsCorrectResults extends TestBase{
    LandingPage landingPage;
    SoftAssert softAssert;

    @DataProvider(name = "ExcelData")
 public Object[][]searchData() throws IOException {
     //read from excel
     ReadData readData = new ReadData();

         return readData.read_data();

 }

    @Test (dataProvider = "ExcelData")
    public void checkCorrectSearchResults(String homeURL,String keyword)
    {
       landingPage= new LandingPage(driver);
       landingPage.clickOnSearchBar();
       landingPage.enterDataToSearchFor( keyword);
       landingPage.ClickOnSearchButton();
       Assert.assertTrue(landingPage.searchResultsValue().contains(keyword));
       //This requirement can be validated with many other ways, I've chosen the simplest one.
    }
}
