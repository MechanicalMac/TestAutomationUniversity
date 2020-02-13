package alerts;

import base.DriverInstance;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends DriverInstance {
    @Test
    public void testFileUpload() {
        var fileUploadPage = homePage.clickFileUpload();
        fileUploadPage.uploadFile("C:\\Users\\landinvitali\\Desktop\\Projects" +
                "\\Automation\\resources\\chromedriver.exe");
        assertEquals(fileUploadPage.getUploadedFiles(), "chromedriver.exe",
                "Uploaded file is unexpected!");
    }
}
