package context;

import base.DriverInstance;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextTest extends DriverInstance {
    @Test
    public void contextMenuTest() {
        String textMessage = "You selected a context menu";
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.rightClickOnHotSpotBox();
        assertEquals(contextMenuPage.alert_isDisplayed(), textMessage, "Wrong context menu!");
        contextMenuPage.alert_pressConfirmButton();
    }
}
