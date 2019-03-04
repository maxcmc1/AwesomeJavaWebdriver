package day2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleSearch3 {

    @Test
    public void testSearch() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/geckodriver");

        WebDriver driver = new FirefoxDriver();

        driver.get("http://yahoo.com");

        WebElement element = driver.findElement(By.cssSelector("#uh-search-box"));

        String queryString = "Portnov School";

        element.sendKeys(queryString);

        element.submit();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement resultStatesElement = driver.findElement(By.id("yui_3_10_0_1_1549948595611_459"));

        System.out.println(resultStatesElement.getText());

    }

    public void explicitWait(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultStats")));

    }

    public void sleepThread() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
