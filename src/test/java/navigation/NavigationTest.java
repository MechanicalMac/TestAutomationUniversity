package navigation;

import base.DriverInstance;
import org.testng.annotations.Test;

public class NavigationTest extends DriverInstance {
    @Test
    public void testNavigator() {
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com.ua");
    }
    @Test
    public void switchTabTest() {
        homePage.clickMultipleWindow().clickHere();
        getWindowManager().switchToTab("New Window");
    }
}
