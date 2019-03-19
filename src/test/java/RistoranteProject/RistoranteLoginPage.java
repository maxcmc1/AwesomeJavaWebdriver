package RistoranteProject;

import day2.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RistoranteLoginPage {

    WebDriver driver;

    By idInput = By.xpath("/html/body/div/div/form/div/div[1]/div/input");
    By emailInput = By.xpath("/html/body/div/div/form/div/div[2]/div/input");
    By passwordInput = By.xpath("/html/body/div/div/form/div/div[3]/div/input");
    By buttonElement = By.xpath("/html/body/div/div/form/div/div[4]/button/span[1]");

    @BeforeSuite
    public void suiteSetup () {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/geckodriver");
        driver = new FirefoxDriver(); // we created an instance of firefox driver in our test method
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Test
    public void testRestaurantId() {
        String queryStringId = "maxcmc1989";
        String queryStringEmail = "maxcmc1@gmail.com";
        String queryStringPassword = "maxcmc1989";

        openMainPage();
        typeQueryId(queryStringId);
        typeQueryEmail(queryStringEmail);
        typeQueryPassword(queryStringPassword);
        submitButton();


    }

    private void submitButton() {
        WebElement submitButtonElement = driver.findElement(buttonElement);
        submitButtonElement.submit();

    }

    private void typeQueryPassword(String queryStringPassword) {
        WebElement elementPassword = driver.findElement(passwordInput);
        elementPassword.sendKeys(queryStringPassword);
    }

    private void typeQueryEmail(String queryStringEmail) {
      WebElement elementEmail = driver.findElement(emailInput);
      elementEmail.sendKeys(queryStringEmail);
    }

    private void typeQueryId(String queryStringId) {
        WebElement elementId = driver.findElement(idInput);
        elementId.sendKeys(queryStringId);

    }

    private void openMainPage() {
        driver.get("http://52.9.182.211:3001/v1/log-in");
        Tools.waitForPageLoaded(driver);
    }
}
