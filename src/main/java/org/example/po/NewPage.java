package org.example.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class NewPage extends BaseSeleniumPage {
    @FindBy(xpath = "//title")
    private WebElement pageTitle;

    public NewPage() {
        PageFactory.initElements(driver, this);
    }

    public String getTitle(){
        return pageTitle.getText();
    }

    public String getNewPageId(){
       String newPageId = driver.getWindowHandle();
        return newPageId;
    }
}
