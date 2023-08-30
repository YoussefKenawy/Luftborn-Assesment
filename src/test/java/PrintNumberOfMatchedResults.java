import Pages.LandingPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testData.ReadData;

import java.io.IOException;

public class PrintNumberOfMatchedResults extends TestBase {
    LandingPage landingPage;
    @DataProvider(name = "ExcelData")
    public Object[][]searchData() throws IOException {
        //read from excel
        ReadData readData = new ReadData();

        return readData.read_data();

    }
    @Test(dataProvider = "ExcelData")
    public void CheckNumberOfResults(String homeURL, String keyword) {
        landingPage = new LandingPage(driver);
        landingPage.clickOnSearchBar();
        landingPage.enterDataToSearchFor(keyword);
        landingPage.ClickOnSearchButton();

        System.out.println("Number of search results: " + landingPage.numberOfMatchedSearches());
// This requirement was not clear, I didn't know what to validate on and the requirements asks for only printing the number of obtained search results.

    }
}
