import io.qameta.allure.Allure;
import org.junit.internal.matchers.ThrowableCauseMatcher;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;




public class TestListener  implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.getLifecycle().addAttachment(
                "Скриншот на месте падения теста", "image/png", "png"
                , ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.BYTES)
        );
        if (BaseTest.driver !=null) {
            BaseTest.driver.quit();
        }
    }

    @Override
    public void testSuccessful(ExtensionContext context) {

        if (BaseTest.driver !=null) {
            BaseTest.driver.quit();
        }
    }
}
