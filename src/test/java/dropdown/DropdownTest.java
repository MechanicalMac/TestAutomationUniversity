package dropdown;

import base.DriverInstance;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTest extends DriverInstance {

    @Test
    public void testSelectOption() {
        var dropDownPage = homePage.clickDropdown();

        String option = "Option 1";
        dropDownPage.selectFromDropdown(option);
        var selectedOption = dropDownPage.getSelectedOptions();
        assertEquals(selectedOption.size(), 1, "Incorrect number of selections!");
        assertTrue(selectedOption.contains(option), "Option not selected!");
    }
}
