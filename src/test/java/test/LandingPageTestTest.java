package test;

import base.Base;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;

import java.io.IOException;
import java.util.Properties;

import static base.Base.driver;

public class LandingPageTestTest {

    LandingPage landingPage;
    LoginPage loginPage;
    Properties prop;


    public LandingPageTestTest(){
        PageFactory.initElements(driver, this);
    }
    @BeforeClass
    public void setup() throws IOException {
        Base base = new Base(); // Ensure Base is initialized
        Base.initialization();
        prop = Base.prop; // Assigning prop from Base
        loginPage = new LoginPage(driver, prop); // Passing prop to LoginPage constructor
        landingPage = new LandingPage(driver, prop);
    }
    @AfterClass
    public void quit() {
        driver.quit();
    }
    @Test(priority =0)
    public void login() {
        loginPage.login();
    }
    @Test(priority = 1)
    public void uploadFile() throws InterruptedException {

        landingPage.selectFile();

    }
}
