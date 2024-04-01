package test;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.SecurityFindingsPage;

import java.io.IOException;
import java.util.Properties;

import static base.Base.driver;

public class SecurityFindingsPageTest {
    SecurityFindingsPage seecurityFinding;
    HomePage homePage;
    LandingPage landingPage;
    LoginPage loginPage;
    Properties prop;

    public SecurityFindingsPageTest(){
        PageFactory.initElements(driver,this);
    }

    @BeforeClass
    public void setup() throws IOException {
        Base base = new Base(); // Ensure Base is initialized
        Base.initialization();
        prop = Base.prop; // Assigning prop from Base
        loginPage = new LoginPage(driver, prop); // Passing prop to LoginPage constructor
        landingPage = new LandingPage(driver, prop);
        homePage = new HomePage(driver);
        seecurityFinding = new SecurityFindingsPage(driver);
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
    @Test(priority = 2)
    public void validateHomepage() throws InterruptedException {
        homePage.validatingHomePage();
        Thread.sleep(2000);
    }
    @Test(priority = 3)


    public void securityFinding() throws InterruptedException {
        seecurityFinding.navigateToSecurityFindingPage();
        seecurityFinding.selectingEmployees();
        seecurityFinding.actionOnEmployees();
    }
}