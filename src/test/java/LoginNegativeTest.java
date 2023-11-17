import Pages.HomePage;
import Pages.LoginPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginNegativeTest extends UseCaseBase {
    private static HomePage homePage;
    private static LoginPage loginPage;
    @BeforeAll
    public static void classSetup() {
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
    }
    @Test
    public void testEmptyLoginCredentials() throws InterruptedException {
        homePage.navigateToMainPage();
        loginPage = homePage.openLoginPage();
        loginPage.loginWithEmptyCredentials();
//        assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for empty login credentials.");
//        loginPage.takeScreenshot("EmptyLoginCredentials");
    }
    @Test
    public void testIncorrectLoginCredentials() throws InterruptedException {
        homePage.navigateToMainPage();
        loginPage = homePage.openLoginPage();
        loginPage.loginWithIncorrectCredentials("blablabla@gmail.com", "incorpas");
//        assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for incorrect login credentials.");
//        loginPage.takeScreenshot("IncorrectLoginCredentials");
    }
}