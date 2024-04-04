package com.testcase;

import Pages.HomePage;
import Pages.ProfilePage;
import Pages.SigninPage;
import baseclass.Baseclass;
import io.qameta.allure.Description;
import io.qameta.allure.Story;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilepageTest extends Baseclass {
    public SigninPage signInPage;
    public HomePage homePage;
    public ProfilePage profilePage;

   public  ProfilepageTest()
   {
       super();
   }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        try {
            initialisation();
            homePage = new HomePage();
            signInPage = homePage.clickSingIn();
            homePage = signInPage.SignIn(properties.getProperty("email"), properties.getProperty("password"));
            Thread.sleep(2000);
            profilePage = homePage.clickProfile();

        } catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    @Test
    @Description("Verify the Published Post in the Profile")
    @Story("Post in Profile")
    public void postInProfileTest() throws InterruptedException {

        WebElement postTitle = driver.findElement(By.xpath("//a[@class='preview-link']//h1"));
        String postHeader = postTitle.getText();
        Assert.assertEquals(postHeader, "First Post", "The actual Post title does not match the expected one.");
    }
}

