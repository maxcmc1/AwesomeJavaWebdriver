package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class YahooSearch {

    WebDriver driver;

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

    private void assertResults() {
        By resultsByCSS = By.cssSelector("#yui_3_10_0_1_1550896065856_398");
        By resultXPath = By.xpath("/*[@id=\"yui_3_10_0_1_1550896065856_398\"]");

        WebElement resultsSpanElement = driver.findElement(By.id("results")).findElement(By.className("compPagination")).findElement(By.tagName("span"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Assert.assertTrue(resultsSpanElement.isDisplayed());


    }

    private void submitSearch() {
        driver.findElement(By.id("uh-search-box")).submit();
    }

    private void typeQuery(String queryString) {
        driver.findElement(By.id("uh-search-box")).sendKeys(queryString);
    }

    private void openMainPage() {

        driver.get("https://www.yahoo.com/");

    }

}
