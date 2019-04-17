package com.tns.pruebas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookStorePage extends BasePage {

    List<WebElement> bookCuantities;

    public void addCuatityByBook(int index, String cuantity){
       bookCuantities.get(index).sendKeys("");
       bookCuantities.get(index).sendKeys(cuantity);
    }

    public void getBookCuantities(String element)
    {
        bookCuantities = webDriver.findElements(By.name(element));
    }

    public void addBooksToCar(){
        webDriver.findElement(By.xpath("//*[@id=\"available\"]/input[1]")).click();
    }

    @Override
    public WebElement getWebElement(String element) {
       return webDriver.findElement(By.id(element));
    }

}
