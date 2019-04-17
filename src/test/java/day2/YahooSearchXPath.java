package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class YahooSearchXPath {

    WebDriver driver;

    By searchInput = By.xpath("//*[@name='p']");
                           // "//*[@name='p']"

    @BeforeSuite
    public void suitSetup() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Test
    public void testSearch() {
        String queryString = "Portnov School";

        openMainPage();
        typeQuery(queryString);
        submitSearch();
        assertResults();

    }

    @Test
    public void testSearch02() {
        String queryString = "Portnov Computer School";

        openMainPage();
        typeQuery(queryString);
        submitSearch();
        assertResults();

    }

    private void assertResults() {
        WebElement resultStatsElement = driver.findElement(By.xpath("//*[@class='compPagination']/span")); //  //*[contains(@name,'rest')]
        System.out.println(resultStatsElement.isDisplayed());
        String textFromResults = resultStatsElement.getText();
        //String xpathValue = "//*[contains(@id,'yui')]";
        //explicitWait(driver, By.xpath(xpathValue));
        //Assert.assertTrue(textFromResults.endsWith("results"));



    }

    //private void explicitWait (WebDriver driver, By element) {
       // WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    //}

    private void submitSearch() {
        WebElement element = driver.findElement(searchInput);
        element.submit();
    }

    private void typeQuery(String queryString) {
        WebElement element = driver.findElement(searchInput);
        element.sendKeys(queryString);

    }

    private void openMainPage() {
        driver.get("https://www.yahoo.com/");
    }

    //public void explicitWait(WebDriver driver){
       // WebDriverWait wait = new WebDriverWait(driver, 10);
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'yui')]")));

    //}

    public void sleepThread(){
       try {
           Thread.sleep(3000);
        } catch (InterruptedException e) {
           e.printStackTrace();
      }
   }

}
