package Pages;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
public class BasePage {
    private static final Logger logger = LogManager.getLogger(BasePage.class);
    protected static WebDriver webDriver;
    public static WebDriverWait wait;

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 10);
    }
    protected void clickElementByXpath(String xpath) throws InterruptedException {
        try {
            logger.info("Clicking element with xpath: " + xpath);
            Thread.sleep(2000);
            WebElement element = findElementByXpath(xpath);
            Thread.sleep(2000);
            element.click();
        } catch (Exception e) {
            logger.error("Error clicking element with xpath: " + xpath, e);
        }
    }

    protected void sendTextToElementByXpath(String xpath, String text) throws InterruptedException {
        Thread.sleep(2000);
        findElementByXpath(xpath).sendKeys(text);
    }
    protected boolean elementExists(String xpath) {
        try {
            logger.info("Check element with xpath exists: " + xpath);
            //findElementByXpath(xpath);
            webDriver.findElement(By.xpath(xpath));
            return true;
        } catch (Exception err) {
            return false;
        }
    }
    protected WebElement findElementByXpath(String xpath) throws InterruptedException {
        WebElement element;
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element = webDriver.findElement(By.xpath(xpath));
        return element;
    }
    protected String getCurrentPageURL() {
        return webDriver.getCurrentUrl();
    }
    public void takeScreenshot(String name){
        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("Screenshots/" + name + ".jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}