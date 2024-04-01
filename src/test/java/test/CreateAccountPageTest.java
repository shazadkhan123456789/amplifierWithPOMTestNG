package test;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.ForgotPasswordPage;
import utils.CommonUtils;

import java.io.IOException;
import java.util.Properties;

import static base.Base.driver;

public class CreateAccountPageTest {
    Properties prop;
    CreateAccountPage createAccountPage;
    CommonUtils base;
    public CreateAccountPageTest(){
        PageFactory.initElements(driver,this);
    }

    @BeforeClass
    public void setup() throws IOException {
        Base base = new Base(); // Ensure Base is initialized
        Base.initialization();
        prop = Base.prop; // Assigning prop from Base
        createAccountPage = new CreateAccountPage(driver, prop); // Passing prop to LoginPage constructor
    }
    @AfterClass
    public void quit() {
        driver.quit();
    }

    @Test(priority = 0)
    public void createAccount() throws InterruptedException {
        createAccountPage.createAccount();
    }


}
