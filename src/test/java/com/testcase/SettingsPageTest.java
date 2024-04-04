package com.testcase;

import Pages.HomePage;
import Pages.Settings;
import Pages.SigninPage;
import baseclass.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SettingsPageTest extends Baseclass {
    public SigninPage signinPage;
    public HomePage homePage;
    public Settings settingsPage;

    public SettingsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        try {
            initialisation();
            homePage = new HomePage();
            signinPage = homePage.clickSingIn();
            homePage = signinPage.SignIn(properties.getProperty("email"), properties.getProperty("password"));
            Thread.sleep(2000);
            settingsPage = homePage.clickSettings();

        } catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    @Test(priority = 1)

    public void profileUpdateTest() throws InterruptedException {
        Thread.sleep(2000);
        settingsPage.profileSettings(properties.getProperty("imageURL"), properties.getProperty("username"), properties.getProperty("bio"), properties.getProperty("email"), properties.getProperty("password"));
        Thread.sleep(3000);

        WebElement pfp = driver.findElement(By.xpath("//div[contains(@class,'col-xs-12 col-md-10')]//img"));
        String profilePicUrl = pfp.getAttribute("src");
        Assert.assertEquals(profilePicUrl, "https://i.pinimg.com/originals/d3/f7/c8/d3f7c851eefd164e2229a196fdd15f63.jpg", "The actual profile picture  does not match the expected one.");
    }
}

