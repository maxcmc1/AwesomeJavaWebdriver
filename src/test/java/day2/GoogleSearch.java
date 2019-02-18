package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleSearch {

    WebDriver driver;

    By searchInput = By.cssSelector(".gLFyf");

    @BeforeSuite
    public void suiteSetup () {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/geckodriver");
        driver = new FirefoxDriver(); // we created an instance of firefox driver in our test method
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }


    @Test
    public void testSearch() {
        String queryString = "Portnov School";

        openMainPage ();
        typeQuery (queryString);
        submitSearch ();
        assertResults ();

    }

    @Test
    public void testSearch02() {
        String queryString = "Portnov Computer  School";

        openMainPage ();
        typeQuery (queryString);
        submitSearch ();
        assertResults ();

    }

    private void assertResults() {
        WebElement resultStatsElement = driver.findElement(By.id("resultStats"));
        String textFromResults = resultStatsElement.getText();
        String expectedText = "About 172,000 results (0.27 seconds)";
        String actualText = textFromResults;
        Assert.assertEquals(actualText, expectedText);

    }

    private void submitSearch() {
        WebElement element = driver.findElement(searchInput); // 'By' is name of the class, 'cssSelector' - is method
        element.submit();
    }

    private void typeQuery(String queryString) {
        WebElement element = driver.findElement(searchInput);
        element.sendKeys(queryString);
    }

    private void openMainPage() {
        driver.get("http://google.com");
    }

    public void explicitWait (WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultStats")));
    }

    public void sleepThread () {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
