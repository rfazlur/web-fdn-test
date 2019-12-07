package com.fdn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FDNRegisterPage {

    public static final String PAGE_URL = "https://account.femaledaily.net/register";

    @FindBy(id = "id-email") WebElement field_Email;
    @FindBy(id = "id-username") WebElement field_Username;
    @FindBy(id = "id-password") WebElement field_Password;
    @FindBy(id = "id-password-confirm") WebElement field_ConfirmPassword;
    @FindBy(xpath = "//*[@data-element-id='register-checkbox']") WebElement checkbox_Agreement;
    @FindBy(xpath = "//*[@value='create account']") WebElement button_CreateAccount;

    WebDriver driver;

    public FDNRegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public void setText_Email(String email){
        field_Email.sendKeys(email);
        Assert.assertEquals(field_Email.getAttribute("value"), email);
    }

    public void setText_Username(String uname){
        field_Username.sendKeys(uname);
        Assert.assertEquals(field_Username.getAttribute("value"), uname);
    }

    public void setText_Password(String pwd){
        field_Password.sendKeys(pwd);
        Assert.assertEquals(field_Password.getAttribute("value"), pwd);
    }

    public void setText_ConfirmPassword(String pwd2){
        field_ConfirmPassword.sendKeys(pwd2);
        Assert.assertEquals(field_ConfirmPassword.getAttribute("value"), pwd2);
    }

    public void check_Agree(){
        checkbox_Agreement.click();
    }

    public void click_CreateAccount(){
        button_CreateAccount.click();
    }


}
