package base;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WindowManager;
import java.io.File;
import java.io.IOException;

public class DriverInstance {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new  ChromeDriver(getChromeOptions());
        /*driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
        /*driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);*/
        goHome();
        /*setCookie();*/
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterMethod
    /**
     * Метод создает скриншот окна браузера для каждого упавшего теста.
     */
    public void recordFailure(ITestResult result) {
        if(ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }
    /**
     * This method disable "Chrome is being controlled by automated test software".
     * Нихуя не работает начиная с 65 версии Chrome. Бесполезная ебанина.
     * @return instance of ChromeOptions object.
     */
    private ChromeOptions getChromeOptions() {
        var options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.setHeadless(true); //Тесты ранятся без запуска UI браузера.
        return options;
    }
    /*private void setCookie() {
        var cookie = new Cookie.Builder("cookies", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }*/

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
