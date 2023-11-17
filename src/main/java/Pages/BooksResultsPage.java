package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BooksResultsPage extends BasePage {
    private final String ENGLISH_ONLY_OPTION = "//html/body/div[3]/main/div/div/div[10]/div/a";
//    private final By BOOK_ELEMENT = By.xpath("//div[@class='h4 grid-view-item__title']");
    private final By BOOK_ELEMENT = By.xpath("//img[@alt='I-Love-to-Eat-Fruits-and-Vegetables-kids-bunnies-bedtime-story-Shelley-Admont-English-cover']");

    public void clickElement(WebElement element) {
        element.click();
    }

    public BooksResultsPage(WebDriver driver) {
        setWebDriver(driver);
    }


    public void chooseEnglishOnly() throws InterruptedException {
        clickElementByXpath(ENGLISH_ONLY_OPTION);
    }
    public void clickOnBook(String bookXPath) throws InterruptedException {
        WebElement bookElement = findElementByXpath(bookXPath);
        clickElement(bookElement);
    }

    public boolean elementExists(String xpath) {
        try {
            webDriver.findElement(By.xpath(xpath));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}