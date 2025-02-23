import org.example.po.BaseSeleniumPage;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
     protected static WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
       // options.setHeadless(true);
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-linux64/chromedriver");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-win64/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromeDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //"https://chromedriver.storage.googleapis.com/LATEST_RELEASE_130");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
       driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        BaseSeleniumPage.setDriver(driver);
    }


//    @AfterEach
//    public  void tearDown() {
//        if (driver !=null) {
//            driver.quit();
//        }
//    }
}
