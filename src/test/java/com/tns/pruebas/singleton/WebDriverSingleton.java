package com.tns.pruebas.singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {

    private static WebDriver webDriver;

    private WebDriverSingleton() {
        instanceWebDriver();
    }

    public static WebDriver getWebDriver(){
        if(null == webDriver){
            instanceWebDriver();
        }

        return webDriver;
    }

    private static void instanceWebDriver(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
    }
}
