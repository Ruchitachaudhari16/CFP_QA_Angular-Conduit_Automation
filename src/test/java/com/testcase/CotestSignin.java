package com.testcase;

import Pages.HomePage;
import Pages.SigninPage;
import baseclass.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CotestSignin extends Baseclass {
    public SigninPage signInPage;
    public HomePage homePage;

    public CotestSignin(){
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        try {
            initialisation();
            homePage = new HomePage();
            signInPage = homePage.clickSingIn();

        } catch (WebDriverException e){
            e.printStackTrace();
        }
    }


    @Test(priority = 1)
    public void signInTest() throws InterruptedException {
        Thread.sleep(2000);
        signInPage.SignIn(properties.getProperty("email"), properties.getProperty("password"));
        Thread.sleep(2000);

        WebElement profile = driver.findElement(By.xpath("/html/body/app-root/app-layout-header/nav/div/ul/li[4]/a"));
        String actualUsername = profile.getText();
        Assert.assertEquals(actualUsername, "Ruchita", "The actual username does not match the expected one.");
    }
}


