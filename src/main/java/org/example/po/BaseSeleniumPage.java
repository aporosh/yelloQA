package org.example.po;

import org.openqa.selenium.WebDriver;

public abstract class BaseSeleniumPage {
    protected static WebDriver driver;

    public static  void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}
