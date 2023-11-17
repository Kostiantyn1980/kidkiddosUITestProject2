package Pages;
import Consts.Consts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage extends BasePage {
    private final String BOOKS_BY_LANGUAGE_DROPDOWN = "//a[text()='Books by language']"; //"//a[@href='/collections']";
    private final String LOGIN_ICON_XPATH = "//*[@id='shopify-section-header']/div/header/div/div[3]/div/a[1]";
    public HomePage(WebDriver driver) {
        setWebDriver(driver);
    }
    public void openBooksByLanguageDropdown() throws InterruptedException {
        clickElementByXpath(BOOKS_BY_LANGUAGE_DROPDOWN);
    }
    public void navigateToMainPage() {
        webDriver.get(Consts.MAIN_URL);
    }
    public LoginPage openLoginPage() throws InterruptedException {
        Thread.sleep(2000);
        clickElementByXpath(LOGIN_ICON_XPATH);
        return new LoginPage(webDriver);
    }
}

