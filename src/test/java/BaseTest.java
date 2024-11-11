import org.example.po.BaseSeleniumPage;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public abstract class BaseTest {
     protected static WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromeDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "https://chromedriver.storage.googleapis.com/LATEST_RELEASE_130");
        driver = new ChromeDriver();
       // driver.manage().window().maximize();
       //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        BaseSeleniumPage.setDriver(driver);

    }



//    @Test
//    public void testOpenPage() throws IOException, InterruptedException {
//        driver.get("http://158.160.42.61:3000/challenge/1");
//        Thread.sleep(4000);  // Let the user actually see something!
//        String expectedTitle = "React App";
//        String actualTitle = driver.getTitle();
//        assertEquals(expectedTitle, actualTitle);
//
//    }

//    @AfterEach
//    public  void tearDown() {
//        if (driver !=null) {
//            driver.quit();
//        }
//    }
}
