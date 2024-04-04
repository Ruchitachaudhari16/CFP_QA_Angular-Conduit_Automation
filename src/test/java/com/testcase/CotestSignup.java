package com.testcase;

import Pages.Signup;
import baseclass.Baseclass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CotestSignup extends Baseclass {
    Signup signup;

    public CotestSignup(){
        super();
    }

    @BeforeMethod
    public void setup()
    {
        initialisation();
        signup= new Signup();
    }
    @Test(dataProvider = "credentials")
    @Description("Verify Signup with valid credentials")

    public void SignupTest(String username,String emailid,String password) throws InterruptedException {
        signup.Signup(username,emailid,password);
    }
}
