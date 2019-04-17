package com.tns.pruebas.pages;

import com.tns.pruebas.singleton.WebDriverSingleton;
import com.tns.pruebas.utils.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    protected WebDriver webDriver;

    public BasePage(){
       webDriver = WebDriverSingleton.getWebDriver();
        PageFactory.initElements(webDriver, this);
    }

    public void navigateTo(String url){
        webDriver.navigate().to(url);
        webDriver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    public void takeScreenshoots(String testImage, String testName){
        TestUtils.takeScreenShot(testImage,testName, webDriver);
    }

    abstract WebElement getWebElement(String element);
}
