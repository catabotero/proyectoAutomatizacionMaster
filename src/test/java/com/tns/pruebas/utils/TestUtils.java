package com.tns.pruebas.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class TestUtils {

    private static String fileSeperator = System.getProperty("file.separator");

    public static void takeScreenShot(String screenShotName, String testName, WebDriver driver) {

        try {
            File file = new File("Screenshots" + fileSeperator + "Results");

            if (!file.exists()) {
                file.mkdir();
            }

            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File targetFile = new File("Screenshots" + fileSeperator + "Results" + fileSeperator + testName, screenShotName+ ".png");
            FileUtils.copyFile(screenshotFile, targetFile);
            System.out.println("Se creo el archivo" + targetFile.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("An exception occured while taking screenshot " + e.getCause());
        }
    }
}
