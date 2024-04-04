package Pages;

import baseclass.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage extends Baseclass {
    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement email;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement signIn;

    public SigninPage(){
        PageFactory.initElements(driver, this);
    }

    public HomePage SignIn(String emailInput, String passInput){
        email.sendKeys(emailInput);
        password.sendKeys(passInput);
        signIn.click();

        return new HomePage();
    }
}

