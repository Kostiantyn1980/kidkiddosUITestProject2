package Pages;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage extends BasePage {
    private final String USERNAME_INPUT_XPATH = "//*[@id='CustomerEmail']";
    private final String PASSWORD_INPUT_XPATH = "//*[@id='CustomerPassword']";
    private final String LOGIN_BUTTON_XPATH = "//*[@id='customer_login']/div/input";
    private final String ERROR_MESSAGE_XPATH = "//div[@class='errors']";
    public LoginPage(WebDriver driver) {
        setWebDriver(driver);
    }
    public void loginWithEmptyCredentials() throws InterruptedException {
        Thread.sleep(2000);
        clickElementByXpath(LOGIN_BUTTON_XPATH);
    }
    public void loginWithIncorrectCredentials(String username, String password) throws InterruptedException {
        Thread.sleep(2000);
        sendTextToElementByXpath(USERNAME_INPUT_XPATH, username);
        sendTextToElementByXpath(PASSWORD_INPUT_XPATH, password);
        clickElementByXpath(LOGIN_BUTTON_XPATH);
    }
    public boolean isErrorMessageDisplayed() {
//        return elementExists(ERROR_MESSAGE_XPATH);
        ////////////////////////////////////////////////
        Boolean isVisible =  elementExists(ERROR_MESSAGE_XPATH);
        return isVisible;



    }
}
