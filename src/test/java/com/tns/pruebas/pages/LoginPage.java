package com.tns.pruebas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public void writeCredentials(String password, String userName){
        webDriver.findElement(By.name("user")).sendKeys(userName);
        webDriver.findElement(By.name("password")).sendKeys(password);
    }

    public void executeButtonAction(){

        webDriver.findElement(By.className("button")).click();
    }

    @Override
    public WebElement getWebElement(String element) {
      return webDriver.findElement(By.id(element));
    }

    public String getApplicationTitle() {
        return webDriver.getTitle();
    }
}
