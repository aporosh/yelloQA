import io.qameta.allure.Description;
import io.qameta.allure.Flaky;
import io.qameta.allure.Owner;
import org.example.po.Challenge;
import org.example.po.Results;
import org.junit.Assert;
//import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@ExtendWith(TestListener.class)
public class CommonChallengeTest extends BaseTest{
    @Test
    @Owner("PAL")
    @DisplayName("Проверка названия приложения")
    @Description("Выполняется сравнение заголовка приложения из header с заранее заданным")
    public void testOpenPage() throws IOException, InterruptedException {
        Challenge challengePage = new Challenge();
        Thread.sleep(2000); // Let the user actually see something!
        String actualTitle = driver.getTitle();
        assertEquals("Yello", actualTitle);
    }

    @Test
    @Owner("PAL")
    @DisplayName("Существует ли данный челендж")
    @Description("Выполняется поиск вэбэлемента, который содержит заголовок челенджа, в неудачном случае элемент не будет найден на странице")
    public void testExistingChallengeTitle() throws IOException, InterruptedException {
        Challenge challengePage = new Challenge();
        Thread.sleep(2000);
        assertTrue("Поиск не осуществился", challengePage.isChallenge());
    }

    @Test
    @Owner("PAL")
    @DisplayName("Существует ли испытание")
    @Description("Выполняется поиск вэбэлемента, который содержит список участников, в неудачном случае элемент не будет найден на странице")
    public void testExistingTrial() throws IOException, InterruptedException {
        Challenge challengePage = new Challenge();
        Thread.sleep(2000);
        assertTrue("Данных для этого челенджа нет", challengePage.isTrial());
    }

    @Test
    @Owner("PAL")
    @DisplayName("Проверка ссылок в постах")
    @Description("Выполняется проверка открытия ссылки из заголовка участника испытания в новом окне браузера")
    public void testClickingOnLinks() throws IOException, InterruptedException {
        Challenge challengePage = new Challenge();

        Thread.sleep(2000);
        String mainWindow = driver.getWindowHandle();
        System.out.println(driver.getCurrentUrl());
        challengePage.openNewPageByLink();
        Thread.sleep(2000);
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

//    @Test
//    @DisplayName("Смена испытания")
//    public void testChangeTrials() throws IOException, InterruptedException {
//        Challenge challengePage = new Challenge();
//        Thread.sleep(4000);
//        String[] trials1 = challengePage.getResultTitles().toArray(new String[0]);
//        System.out.println(trials1);
//        //assertTrue("Поиск не осуществился", challengePage.isChallenge());
//
//    }



    @Test
    @Owner("PAL")
    @DisplayName("Изменение цвета кнопки при наведении")
    public void  testButtonStyles() throws InterruptedException {
        Challenge challengePage = new Challenge();
        Thread.sleep(2000);

        String colorBefore = challengePage.getButtonColor();
        System.out.println(colorBefore);

        Actions actions = new Actions(driver);

        actions.moveToElement(challengePage.button1).pause(50).clickAndHold(challengePage.button1).pause(50).build().perform();
        //System.out.println(challengePage.getButtonColor());
        Thread.sleep(2000);
        System.out.println(challengePage.getButtonStyle());
        String colorAfter = challengePage.getButtonColor();
        System.out.println(colorAfter);

        assertNotEquals(colorBefore, colorAfter);
    }

    @Test
    @Owner("PAL")
    @DisplayName("Изменение цвета кнопки при нажатии")
    public void  testActiveButtonStyles() throws InterruptedException {
        Challenge challengePage = new Challenge();
        Thread.sleep(2000);

        String colorBefore = challengePage.getButtonColor();
        System.out.println(colorBefore);

        Actions actions = new Actions(driver);

        actions.moveToElement(challengePage.button1).pause(30).clickAndHold(challengePage.button1).pause(30).build().perform();

        String colorAfter = challengePage.getButtonColor();
        System.out.println(colorAfter);

        System.out.println(challengePage.getButtonStyle());
         assertNotEquals(colorBefore, colorAfter);
    }


    @Test
    @Owner("PAL")
    @Flaky
    @DisplayName("Появления новой пары соревнующихся после нажатия кнопки")
    public void  testNewTrialMembers() throws InterruptedException {
        Challenge challengePage = new Challenge();
        Thread.sleep(2000);

        System.out.println(challengePage.getSizeTitles());

        List<String> titlesBefore = challengePage.getResultTitles();
        System.out.println(titlesBefore);
       // challengePage.button1.click();
        challengePage.pressButton();
        Thread.sleep(2000);
        List<String> titlesAfter = challengePage.getResultTitles();
        System.out.println(titlesAfter);
        //сравнивается набор из названий участников до нажатия на кнопку и после
        //тест не стабильный т.к. иногда они полносттью совпадают
        //лучше перенести проверку в апи тесты, и проверять что пришел новый айдишник соревнования
        //если оставлять тут надо делать функционал для повтора теста, если он не прошел
        assertNotEquals(titlesBefore, titlesAfter);
    }
}
//
//    @Test
//    public void  testTest() {
//        Challenge challengePage = new Challenge();
//
//        //System.out.println(challengePage.getResultTitles());
//        System.out.println(challengePage.getButtonStyle());
//        System.out.println(challengePage.getButtonColor());
//
//    }
