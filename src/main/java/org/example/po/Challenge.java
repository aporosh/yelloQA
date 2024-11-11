package org.example.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class Challenge extends BaseSeleniumPage {
    //Адрес страницы
    //public static final String CHALLENGE_URL = "http://158.160.42.61:3000/challenge/1";
    public static final String CHALLENGE_URL = "http://localhost:3000/challenge/1";

    //Локатор для названия приложения
    @FindBy(xpath = "/html/head/title")
    private WebElement pageTitle;

    //Локатор для названия челенджа
    //@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/div[2]/div[1]")
    @FindBy(xpath = "//div[@data-testid=\"head_title\"]")
    private WebElement challengeTitle;


    //Локатор для ссылки из первого поста
    //@FindBy(how = How.XPATH, using = "//li[1]//a")
    //@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div/div/div[2]/li[1]/div[1]/a")
    @FindBy(how = How.XPATH, using = "//a[@data-testid=\"item_title\"]")
    public WebElement link1;

    //Локатор для ссылки из второго поста
    @FindBy(how = How.XPATH, using = "//li[2]//a")
    private static WebElement link2;

    //Локатор для кнопки из первого поста
    //@FindBy(xpath = "//li[1]//button")
    @FindBy(xpath = "//button[@data-testid=\"poster_button\"]")
    public static WebElement button1;

    //Локатор для кнопки из второго поста
    @FindBy(how = How.XPATH, using = "//li[2]//button")
    private WebElement button2;


    //Локатор испытания
    //@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]")
    @FindBy(xpath = "//div[@data-testid=\"trial\"]")
    private WebElement trial;

    //Локатор для получения всех постов в данном испытании
    //@FindBy(xpath = "//li//a")
    @FindBy(xpath = "//li//a[@data-testid=\"item_title\"]")
    public List<WebElement> resultTitles;
   // @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/li/div[1]/a")
//    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/li")
//    public List<WebElement> resultTitles;

    //включение драйвера и инициализация элементов страницы
    public Challenge() {
        driver.get(CHALLENGE_URL);
        PageFactory.initElements(driver, this);
    }

    //получение уникального идентификатора окна браузера
    public String getPageId(){
        String challengePageId = driver.getWindowHandle();
        return challengePageId;
    }

    //Челендж существует
    public boolean isChallenge() {
        return challengeTitle.isDisplayed();
    }
    //Получение названия страницы
    public String getPageTitle(){
        return pageTitle.getText();
    }
    //Видимость блока игры
    public boolean isTrial() {
        return trial.isDisplayed();
    }

    //Метод для получения заголовков из коллекции
    public List<String> getResultTitles() {

        List<String> titles = new ArrayList<>();
        int size = resultTitles.size();
        for (int i = 0; i < size; i++) {
           // System.out.println(resultTitles.get(i).getText());
            titles.add(resultTitles.get(i).getText());
        }
        //System.out.println(titles);
        return titles;
    }
    public  int getSizeTitles() {
          return this.resultTitles.size();
    }


    public Challenge pressButton(){
        button1.click();
        return this;
    }


    //Открытие новой страницы по ссылке из заголовка поста
    public NewPage openNewPageByLink(){
        link1.click();
        return new NewPage();
    }
    public String getLinkText(){
        return link1.getText();
    }

    //Получение цвета у ссылки
    public String getButtonColor(){
       // return button2.getCssValue("background-color");
        return button1.getCssValue("box-shadow");
    }

    //Получение цвета у ссылки
    public String getButtonStyle(){
        //return button2.getAttribute("transition");
        //return button2.getAttribute("animation");
        return button1.getCssValue("animation");
    }

}
