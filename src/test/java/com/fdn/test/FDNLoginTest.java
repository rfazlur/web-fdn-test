package com.fdn.test;

import com.fdn.pages.FDNLoginFormPage;
import com.fdn.pages.FDNMainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FDNLoginTest {
    public WebDriver driver;

    FDNMainPage fdnMainPage;
    FDNLoginFormPage fdnLoginFormPage;

    @BeforeTest()
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        fdnMainPage = PageFactory.initElements(driver, FDNMainPage.class);
        fdnLoginFormPage = PageFactory.initElements(driver, FDNLoginFormPage.class);
    }

    @AfterTest()
    public void tearDown(){
        if (driver!=null){
            driver.quit();
        }
    }

    @Test()
    public void loadPage(){
        driver.get(FDNMainPage.PAGE_URL);
        driver.manage().window().maximize();
    }

    @Test(dependsOnMethods = "loadPage")
    public void loginSuccess(){
        fdnMainPage.click_LoginButton();
        fdnLoginFormPage.setText_UsernameField("jkdfahhb");
        fdnLoginFormPage.setText_PasswordField("tester123");
        fdnLoginFormPage.click_LoginButton();
    }

}
