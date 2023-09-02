import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;



public class TestBase {
    static public WebDriver driver;
    static  public ExtentReports extent;

    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void startDriver() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.ebay.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // initialize ExtentXReporter
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Extent Report.html");
         extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }


    @AfterMethod
    public void closeDriver() {
        driver.quit();
        //flush extent report
        extent.flush();
    }
}
