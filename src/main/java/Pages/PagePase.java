package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.time.Duration;

public class PagePase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public PagePase(WebDriver driver){
        PageFactory.initElements(driver,this);
        this .wait=  new WebDriverWait(driver, Duration.ofSeconds(30));


    }
}
