package com.fdn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FDNMainPage {

    public static final String PAGE_URL = "https://femaledaily.net/";

    @FindBy(id = "login_home") WebElement button_Login;

    WebDriver driver;

    public FDNMainPage(WebDriver driver){
        this.driver = driver;
    }

    public void click_LoginButton(){
        button_Login.click();
    }
}
