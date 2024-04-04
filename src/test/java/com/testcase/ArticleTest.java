package com.testcase;

import Pages.Article;
import Pages.HomePage;
import Pages.SigninPage;
import baseclass.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ArticleTest extends Baseclass {

    public SigninPage signInPage;
    public HomePage homePage;
    public Article newArticlePage;

    public ArticleTest(){
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
            newArticlePage = homePage.clickNewArticle();

        } catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    @Test
    public void publishPostTest() throws InterruptedException {
        Thread.sleep(2000);
        newArticlePage.PublishArticle(properties.getProperty("postTitle"), properties.getProperty("postDescription"), properties.getProperty("writePost"), properties.getProperty("tags"));
        Thread.sleep(3000);

        WebElement postTitle = driver.findElement(By.xpath("/html/body/app-root/app-article-page/div/div[1]/div/h1"));
        String Title = postTitle.getText();
        Assert.assertEquals(Title, "My First Angular Post", "The post title does not match the expected one.");
    }
}

