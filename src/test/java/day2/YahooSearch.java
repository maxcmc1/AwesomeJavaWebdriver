package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class YahooSearch {

    @Test
    public void testSearch() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/geckodriver");

        WebDriver driver = new FirefoxDriver();

        driver.get("http://bing.com");

        WebElement element = driver.findElement(By.cssSelector("#sb_form_q"));

        String queryString = "Portnov School";

        element.sendKeys(queryString);

        element.submit();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement resultStatsElement = driver.findElement(By.cssSelector(".sb_count"));

        System.out.println(resultStatsElement.getText());

    }

    public void explicitWait(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sb_count")));

    }

    public void sleepThread(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
