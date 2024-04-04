package Pages;

import baseclass.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Article extends Baseclass {
    @FindBy(xpath = "//input[@placeholder='Article Title']")
    WebElement articleTitle;

    @FindBy(xpath = "/html/body/app-root/app-editor-page/div/div/div/div/form/fieldset/fieldset[2]/input")
    WebElement articleDesc;

    @FindBy(xpath = "/html/body/app-root/app-editor-page/div/div/div/div/form/fieldset/fieldset[3]/textarea")
    WebElement article;

    @FindBy(xpath = "//input[@placeholder='Enter tags']")
    WebElement tagArticle;

    @FindBy(xpath = "/html/body/app-root/app-editor-page/div/div/div/div/form/fieldset/button")
    WebElement publish;

    public Article(){
        PageFactory.initElements(driver, this);
    }

    public void PublishArticle(String title, String description, String writeArticle, String tags){
        articleTitle.sendKeys(title);
        articleDesc.sendKeys(description);
        article.sendKeys(writeArticle);
        tagArticle.sendKeys(tags);

        publish.click();
    }
}

