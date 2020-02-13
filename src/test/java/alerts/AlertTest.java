package alerts;

import base.DriverInstance;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTest extends DriverInstance {
    @Test
    public void testAcceptAlert () {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        alertsPage.getResult();
        assertEquals(alertsPage.getResult(), "You successfuly clicked an alert");
    }
    @Test
    public void testGetTextFromAlert() {
        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.triggerConfirm();
        String text = alertPage.alert_getText();
        alertPage.alert_clickToDissmiss();
        assertEquals(text, "I am a JS Confirm", "Alert text incorrect!");
    }
    @Test
    public void testSetInputInAlert() {
        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.triggerPrompt();
        String text = "TAU rocks!";
        alertPage.alert_SetInput(text);
        alertPage.alert_clickToAccept();
        assertEquals(alertPage.getResult(), "You entered: " + text, "Result text incorect!");
    }
}

