package com.fidexio.utils;

import org.openqa.selenium.WebElement;

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



}
