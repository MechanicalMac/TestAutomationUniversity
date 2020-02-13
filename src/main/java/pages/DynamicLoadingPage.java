package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private WebDriver driver;
    private String linkXpath_format = ".//a[contains(text(), '%s')]";
    private By link_Example1 = By.xpath(String.format(linkXpath_format, "Example 1"));

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }
    /**
     *
     * @return Click to link "https://the-internet.herokuapp.com/dynamic_loading" and returns next page
     * "https://the-internet.herokuapp.com/dynamic_loading/1".
     */
    public DynamicLoadingExample1Page clickExample1() {
        driver.findElement(link_Example1).click();
        return new DynamicLoadingExample1Page(driver);
    }
}
