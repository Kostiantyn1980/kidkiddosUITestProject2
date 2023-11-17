package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
    private final By BOOK_QUANTITY_INPUT = By.xpath("//input[@name='updates[]']");
    private final By UPDATE_CART_BUTTON = By.xpath("//input[@class='btn btn--secondary cart__update cart__update--large small--hide']");

  private final By CART_LINK = By.xpath("//div[@class='product-form__item product-form__item--submit']//descendant::*[@type='submit']");


    public CartPage(WebDriver driver) {
        setWebDriver(driver);
    }

    public void navigateToCartPage() throws InterruptedException {
        clickElementByXpath(String.valueOf(CART_LINK));
    }

    public void changeBookQuantity(int quantity) throws InterruptedException {
        WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(BOOK_QUANTITY_INPUT));
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));
    }


    public void updateCart() throws InterruptedException {
        clickElementByXpath(String.valueOf(UPDATE_CART_BUTTON));
    }

//    public boolean elementExists(String xpath) {
//        try {
//            webDriver.findElement(By.xpath(xpath));
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }
public boolean elementExists(String xpath) {
    try {
        System.out.println("Finding element with xpath: " + xpath);
        webDriver.findElement(By.xpath(xpath));
        return true;
    } catch (NoSuchElementException e) {
        return false;
    }
}

    }



