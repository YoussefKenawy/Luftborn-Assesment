package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LandingPage extends PagePase {



    @FindBy(id = "//srp-results srp-list ]")
    WebElement totalNumberOfDisplayedElements;
    @FindBy(id = "gh-ac")
    WebElement searchBar;
    @FindBy(id = "gh-btn")
    WebElement searchBtn;
    @FindBy(css = "div[class='srp-controls__control srp-controls__count'] span:nth-child(1)")
    WebElement numberOfMatchedResultsTeller;
    @FindBy(css = "div[class='srp-controls__control srp-controls__count'] span:nth-child(2)")
    WebElement searchValueTeller;
    @FindBy(xpath = "//input[@aria-label='Manual']")
    WebElement manualOptionFromTransmission;
    //This is the locator of first search results
    public LandingPage(WebDriver driver) {
        super(driver);

    }

    public void clickOnSearchBar() {
        wait.until(ExpectedConditions.visibilityOf(searchBar)).click();
    }

    public void enterDataToSearchFor(String keyword) {
        searchBar.sendKeys(keyword);
    }

    public void ClickOnSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchBtn)).click();
    }

    /*public List<WebElement> web()
    {
         List<WebElement> element= driver.findElements(By.id("//div/ul/li"));
         return  element;
    }*/
    public String searchResultsValue() {

        return    wait.until(ExpectedConditions.visibilityOf(searchValueTeller)).getText();
    }

    public void ClickOnManualCheckBox() {
       manualOptionFromTransmission.click();
    }

    public Boolean isManualOptionChecked() {
        return manualOptionFromTransmission.isSelected();
    }

    /* public int numberOfDisplayedElemnts()
     {
         //return numberOfMatchedResultsTeller.getText().replaceAll("[^0-9]", "");
        return  list.size();
     }*/
    public String numberOfMatchedSearches() {
        return wait.until(ExpectedConditions.visibilityOf(numberOfMatchedResultsTeller)) .getText().replaceAll("[^0-9]", "");

    }

}