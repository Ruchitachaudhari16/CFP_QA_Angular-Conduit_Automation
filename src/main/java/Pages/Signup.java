package Pages;

import baseclass.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signup extends Baseclass {
    @FindBy (xpath= "/html/body/app-root/app-layout-header/nav/div/ul/li[3]/a")
    WebElement Signup;

    @FindBy (xpath= "//input[@formcontrolname='username']")
    WebElement username;

    @FindBy (xpath="//input[@formcontrolname='email']")
    WebElement email;

    @FindBy (xpath ="//input[@formcontrolname='password']")
    WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    WebElement SignUpclick;

    public Signup()
    {
        PageFactory.initElements(driver, this);
    }
public void Signup(String userna,String emailid,String pass)
{
    username.sendKeys(userna);
    email.sendKeys(emailid);
    password.sendKeys(pass);
    Signup.click();
}
}
