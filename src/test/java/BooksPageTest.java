import Pages.BooksResultsPage;
import Pages.ProductPage;
import Pages.CartPage;
import Pages.HomePage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class BooksPageTest extends UseCaseBase {
    private static HomePage homePage;
    private static BooksResultsPage booksResultsPage;
    private static ProductPage productPage;
    private static CartPage cartPage;

    @BeforeAll
    public static void classSetup() {
        homePage = new HomePage(webDriver);
        booksResultsPage = new BooksResultsPage(webDriver);
        productPage = new ProductPage(webDriver);
        cartPage = new CartPage(webDriver);
    }

    @Test
    public void testClickOnBookAndAddToCart() throws InterruptedException {
        homePage.navigateToMainPage();
        homePage.openBooksByLanguageDropdown();
        booksResultsPage.chooseEnglishOnly();
        booksResultsPage.clickOnBook("//img[@alt='I-Love-to-Eat-Fruits-and-Vegetables-kids-bunnies-bedtime-story-Shelley-Admont-English-cover']");
        Thread.sleep(1000);
        productPage.ClickOnAddToCart();
        Thread.sleep(1000);
        assertTrue(cartPage.elementExists("//div[@id='bold-cart-msg']"));
    }

    @Test
    public void testChangeToHardcover() throws InterruptedException {
        homePage.navigateToMainPage();
        homePage.openBooksByLanguageDropdown();
        booksResultsPage.chooseEnglishOnly();
        booksResultsPage.clickOnBook("//img[@alt='I-Love-to-Eat-Fruits-and-Vegetables-kids-bunnies-bedtime-story-Shelley-Admont-English-cover']");

        Thread.sleep(2000);
        productPage.changeFormatToHardcover();

        assertTrue(productPage.isHardcoverOptionVisible());
    }




    @Test
    public void testChangeQuantityAndAddToCart() throws InterruptedException {
        homePage.navigateToMainPage();
        homePage.openBooksByLanguageDropdown();
        booksResultsPage.chooseEnglishOnly();
        booksResultsPage.clickOnBook("//img[@alt='I-Love-to-Eat-Fruits-and-Vegetables-kids-bunnies-bedtime-story-Shelley-Admont-English-cover']");
        Thread.sleep(2000);
        productPage.changeFormatToHardcover();
        Thread.sleep(1000);
        productPage.changeQuantity(5);
        Thread.sleep(1000);
        productPage.ClickOnAddToCart();
        assertTrue(cartPage.elementExists("//div[@class='section-header text-center']"));
        Thread.sleep(1000);

    }

    @Test
    public void testChangeBookQuantityInCart() throws InterruptedException {
        homePage.navigateToMainPage();
        homePage.openBooksByLanguageDropdown();
        booksResultsPage.chooseEnglishOnly();
        booksResultsPage.clickOnBook("//img[@alt='I-Love-to-Eat-Fruits-and-Vegetables-kids-bunnies-bedtime-story-Shelley-Admont-English-cover']");
        Thread.sleep(2000);
        productPage.changeFormatToHardcover();
        Thread.sleep(2000);
        productPage.changeQuantity(5);
        Thread.sleep(1000);
        productPage.ClickOnAddToCart();
        Thread.sleep(1000);
        cartPage.navigateToCartPage();
        Thread.sleep(1000);
        cartPage.changeBookQuantity(6);
        Thread.sleep(1000);
        cartPage.updateCart();
        boolean isElementVisible = cartPage.elementExists("//span[contains(text(), '6')]");
        System.out.println("Is element visible: " + isElementVisible);
        assertTrue(isElementVisible);
//        assertTrue(cartPage.elementExists("//span[contains(text(), '6')]"));
    }
}
