import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.po.Challenge;
import org.example.po.Results;
//import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.Set;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(TestListener.class)
public class ResultsTest extends BaseTest{
    @Test
    @Owner("PAL")
    @DisplayName("Проверка заголовка страницы")
    @Description("Выполняется сравнение названия страницы с заранее заданным")
    public void testOpenPage() throws IOException, InterruptedException {
        Results resultPage = new Results();
        Thread.sleep(2000);  // Let the user actually see something!
        String actualTitle = resultPage.getPageTitle();
        assertEquals("Результаты", actualTitle);
    }

    @Test
    @Owner("PAL")
    @DisplayName("Проверка ссылки в списке")
    public void testClickingOnLink() throws IOException, InterruptedException {
        Results resultPage = new Results();

        Thread.sleep(4000);  // Let the user actually see something!
        String mainWindow = driver.getWindowHandle();
        System.out.println(driver.getCurrentUrl());
        resultPage.openNewPageByLink();
        Set<String> currentWindows = driver.getWindowHandles();
        System.out.println(currentWindows);
        String window2 = "";
        for (String window : currentWindows) {
            if (!window.equals(mainWindow)) {
                window2 = window;
                break;
            }
        };
        driver.switchTo().window(window2);
        String newWindow = driver.getWindowHandle();
        System.out.println(driver.getCurrentUrl());
        assertNotEquals(mainWindow, newWindow);
    }



    //Проверка изменения стиля при наведении на ссылку
    @Test
    @Owner("PAL")
    public void  testStyles() throws InterruptedException {
        Results resultPage = new Results();
        Thread.sleep(4000);

        System.out.println(resultPage.getLinkColor());
        String colorBefore = resultPage.getLinkColor();

        Actions actions = new Actions(driver);

        actions.moveToElement(resultPage.link).pause(30).build().perform();
        Thread.sleep(2000);
        System.out.println(resultPage.getLinkColor());
        String colorAfter = resultPage.getLinkColor();
        assertNotEquals(colorBefore, colorAfter);
    }


    @Test
    @Owner("PAL")
    public void  testTest() {
        Results resultPage = new Results();
        System.out.println(resultPage.getResultTitles());
        System.out.println(resultPage.getResultSize());
        System.out.println(resultPage.getResultTitles());

    }
}



//    @Test
//    @DisplayName("Проверка изменения списка при переключении чекбокса")
//    public void testSwitchCheckbox() throws IOException, InterruptedException {
//
//        Results resultPage = new Results();
//        Thread.sleep(4000);
//        Integer ResListSizeBefore = resultPage.getResultSize();
//        System.out.println(ResListSizeBefore);
//        System.out.println(resultPage.isCheckboxSelected());
        // resultPage.Checkbox.sendKeys("true");


        //resultPage.switchCheckbox();
//        Actions actions = new Actions(driver);
//
//        actions.moveToElement(resultPage.Checkbox).click(resultPage.Checkbox).pause(20).build().perform();
 //       Thread.sleep(4000);
 //       System.out.println(resultPage.isCheckboxSelected());
//
//        Integer ResListSizeAfter = resultPage.getResultSize();
//        System.out.println(ResListSizeAfter);
//
//        System.out.println(resultPage.getResultTitles());


        //Либо проверять размер списка
        //System.out.println(resultPage.getResultSize());
        //либо проверять в списке наличие строк с opacity

 //   }
