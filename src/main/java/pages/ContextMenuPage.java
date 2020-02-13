package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
    private WebDriver driver;
    private By hotSpotBox = By.id("hot-spot");
    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method implements right mouse button click.
     */
    public void rightClickOnHotSpotBox() {
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(hotSpotBox)).perform();
    }
    public String alert_isDisplayed() {
        return driver.switchTo().alert().getText();
    }
    public void alert_pressConfirmButton() {
        driver.switchTo().alert().accept();
    }
}
