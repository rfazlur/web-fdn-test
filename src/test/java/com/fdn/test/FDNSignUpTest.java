package com.fdn.test;

import com.fdn.pages.FDNLoginFormPage;
import com.fdn.pages.FDNMainPage;
import com.fdn.pages.FDNRegisterPage;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class FDNSignUpTest {
    public WebDriver driver;
    public WebDriverWait wait;

    FDNMainPage fdnMainPage;
    FDNLoginFormPage fdnLoginFormPage;
    FDNRegisterPage fdnRegisterPage;
    Faker faker;

    @BeforeTest(alwaysRun = true)
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        fdnMainPage = PageFactory.initElements(driver, FDNMainPage.class);
        fdnLoginFormPage = PageFactory.initElements(driver, FDNLoginFormPage.class);
        fdnRegisterPage = PageFactory.initElements(driver, FDNRegisterPage.class);
        wait = new WebDriverWait(driver, 10);
        faker = new Faker();
    }

    @AfterTest(alwaysRun = true)
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
    public void loadLoginForm() {
        fdnMainPage.click_LoginButton();
        fdnLoginFormPage.click_CreateAccountButton();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id-email")));
    }

    @Test(dependsOnMethods = "loadLoginForm")
    public void registerNewUser(){
        String email = faker.internet().safeEmailAddress();
        String username = faker.lorem().characters(3,20);
        String password = faker.internet().password(6,20);
        fdnRegisterPage.setText_Email(email);
        fdnRegisterPage.setText_Username(username);
        fdnRegisterPage.setText_Password(password);
        fdnRegisterPage.setText_ConfirmPassword(password);
        fdnRegisterPage.check_Agree();
        fdnRegisterPage.click_CreateAccount();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-element-id='button-next']")));
    }
    // This Code is for looping test case, but remove all @Test in every method.
//    @Test(invocationCount = 2)
//    public void runner(){
//        setUp();
//        loadPage();
//        loadLoginForm();
//        registerNewUser();
//        tearDown();
//    }

}
