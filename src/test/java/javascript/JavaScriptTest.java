package javascript;

import base.DriverInstance;
import org.testng.annotations.Test;

public class JavaScriptTest extends DriverInstance {
    @Test
    public void testScrollToTable() {
        homePage.clickLargeAndDeepDom().scrollToTable();
    }
    @Test
    public void testScrollToFifthParagraph() {
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }
}
