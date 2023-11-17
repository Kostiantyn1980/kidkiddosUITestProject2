package Pages;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Consts.Consts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    public static final String HARDCOVER_OPTION = "//*[@class='selector-wrapper js product-form__item']//descendant::*[@value='Hardcover']";

    private final By QUANTITY_INPUT = By.xpath("//input[@class='product-form__input']");
    private final By ADD_TO_CART_BUTTON = By.xpath("//div[@class='product-form__item product-form__item--submit']//descendant::*[@type='submit']");

    public ProductPage(WebDriver driver) {
        setWebDriver(driver);
    }

    public void changeFormatToHardcover() throws InterruptedException {
        Thread.sleep(2000);
        clickElementByXpath(HARDCOVER_OPTION);
    }

    public void changeQuantity(int quantity) throws InterruptedException {
        WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(QUANTITY_INPUT));
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));
    }

    public void ClickOnAddToCart() throws InterruptedException {
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(ADD_TO_CART_BUTTON));
        addToCartButton.click();
        Thread.sleep(1000);
    }
    public boolean isHardcoverOptionVisible() {
        return elementExists("//*[@class='selector-wrapper js product-form__item']//descendant::*[@value='Hardcover']");
    }

    public void navigateToCartPage() {
        webDriver.get(Consts.MAIN_URL + "cart");
    }
}