package com.fidexio.utils;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    public static boolean isAttributePresent(WebElement element, String attribute){
        Boolean result= false;
        try {
            String value= element.getAttribute(attribute);
            if(value!= null){
                result=true;
            }
        }catch (Exception e){}
        return result;

    }

    public static void waitForTitle(String title){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs(title));
        Driver.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    public static void titleAssertion(String expectedTitle){
        Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());
    }
    public static void waitForElement(WebElement element){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(element));
        Driver.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }




}
