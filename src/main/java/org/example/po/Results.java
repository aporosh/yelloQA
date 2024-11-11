package org.example.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Results extends BaseSeleniumPage {
    //public static final String RESULTS_URL = "http://158.160.42.61:3000/results/1";
    public static final String RESULTS_URL = "http://localhost:3000/challenge/1/results";
    //*[@id="root"]/div/div/div[1]/div[1]
    @FindBy (xpath = "//div[@data-testid='head_title']")
    private WebElement PageTitle;
    //*[@id="result"]/div/div
    @FindBy(xpath = "//div[@data-testid='empty_results']")
    private WebElement EmptyResults;
    //*[@id="result"]/div/ul/li/a[@data-testid='item_link'] не получаю список таким образом
    //@FindBy(xpath = "//*[@id=\"result\"]/div/ul/li/a")
    @FindBy(xpath = "//*[@id=\"result\"]/div/ul/li/a[@data-testid='item_link']")
    private List<WebElement> ResultList;

   // @FindBy(xpath = "//*[@id=\"allResults\"]")
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[2]")
    public WebElement Checkbox;

    @FindBy(xpath = "//*[@id=\"result\"]/div/ul/li[1]/a[@data-testid='item_link']")
    public WebElement link;

    //включение драйвери и инициализация элементов страницы
    public Results() {
        driver.get(RESULTS_URL);
        PageFactory.initElements(driver, this);
    }

    //Получение названия страницы
    public String getPageTitle(){
        return PageTitle.getText();
    }

    //Есть ли результаты
    public boolean notResults(){
        return EmptyResults.isDisplayed();
    }

    //Получение цвета у ссылки
    public String getLinkColor(){
       return link.getCssValue("color");
    }

    //Открытие новой страницы по ссылке из заголовка
    public NewPage openNewPageByLink(){
        link.click();
        return new NewPage();
    }

    //Получение размера списка результатов
    public int getResultSize() {
        return ResultList.size();
    }

    //Включен ли чекбокс
    public boolean isCheckboxSelected(){
        return Checkbox.isSelected();
    }

    //Переключение checkbox
    public void switchCheckbox() {
        if (Checkbox.isDisplayed()) {
            System.out.println("Checkbox is displayed. Clicking on it now");
            Checkbox.click();
        }

    }

    //Метод для получения заголовков из коллекции
    public List<String> getResultTitles() {

        ArrayList<String> titles = new ArrayList<>();
        int size = ResultList.size();
        for (int i = 0; i < size; i++) {
           // System.out.println(ResultList.get(i).getText());
            titles.add(ResultList.get(i).getText());
        }

        return titles;
    }
}
//    public String getStyles(){
//        System.out.println("color " + link.getCssValue("color"));
//        System.out.println("opacity " + link.getCssValue("opacity"));
//
//
//
//        return link.getAttribute("class");
//    }