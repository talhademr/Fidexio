package com.fidexio.pages;

import com.fidexio.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout_Page {

    public Logout_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement userNameButton;
    @FindBy(xpath = "//a[@data-menu='logout']")
    public WebElement logoutButton;
    @FindBy(xpath = "//li[@class='#Inbox']")
    public WebElement inbox;
    @FindBy(xpath = "//div[@class='o_dialog_warning modal-body']")
    public WebElement logoutMessage;

}
