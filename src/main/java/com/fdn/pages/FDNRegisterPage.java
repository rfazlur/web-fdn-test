package com.fdn.pages;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FDNRegisterPage {

    public static final String PAGE_URL = "https://account.femaledaily.net/register";

    String field_Email = "id-email";
    String field_Username = "id-username";
    String field_Password = "id-password";
    String field_ConfirmPassword = "id-password-confirm";

    WebDriver driver;

    public FDNRegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public void setText_Email(String email){
        WebElement element = driver.findElement(By.id(field_Email));
        element.sendKeys(email);
    }

    public void setText_Username(String uname){
        WebElement element = driver.findElement(By.id(field_Username));
        element.sendKeys(uname);
    }

    public void setText_Password(String passwd1){
        WebElement element = driver.findElement(By.id(field_Password));
        element.sendKeys(passwd1);
    }

    public void setText_PasswordConfirm(String passwd2){
        WebElement element = driver.findElement(By.id(field_ConfirmPassword));
        element.sendKeys(passwd2);
    }




}
