package login;

import base.DriverInstance;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends DriverInstance {

    @Test
    public void testSuccessfulLogin() {
        var loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        var secureAreaPage = loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText()
                        .contains("You logged into a secure area!"),
                        "Alert text incorrect!");
    }
}
