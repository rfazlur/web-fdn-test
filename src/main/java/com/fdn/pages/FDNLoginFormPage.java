package com.fdn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FDNLoginFormPage {

    public static final String PAGE_URL = "https://account.femaledaily.net/";

    @FindBy(id = "id-email-username") WebElement field_Username;
    @FindBy(id = "id-password") WebElement field_Password;
    @FindBy(xpath = "//input[@value='Login']") WebElement button_Login;

    WebDriver driver;

    public FDNLoginFormPage(WebDriver driver){
        this.driver = driver;
    }

    public void setText_UsernameField(String uname){
        field_Username.sendKeys(uname);
        Assert.assertEquals(field_Username.getAttribute("value"), uname);
    }

    public void setText_PasswordField(String passwd){
        field_Password.sendKeys(passwd);
        Assert.assertEquals(field_Password.getAttribute("value"), passwd);
    }

    public void click_LoginButton(){
        button_Login.click();
    }

}
