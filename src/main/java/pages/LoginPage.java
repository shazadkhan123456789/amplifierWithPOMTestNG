package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

import java.util.Properties;

import static base.Base.prop;

public class LoginPage {

    private WebDriver driver;
    private Properties prop;

    public LoginPage(WebDriver driver, Properties prop){
        this.driver = driver;
        this.prop = prop;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = ":r0:")
    WebElement emailField;

    @FindBy(id = ":r1:")
    WebElement passwordField;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement keepLoggedIn;

    @FindBy (xpath = "//*[text()='SIGN IN']")
    WebElement submit;

    @FindBy(xpath = "//*[text()='User logged in Sucessfully !']")
    WebElement loginMessage;

    public void login(){
        String successLogin = "User logged in Sucessfully !";
        String uname= prop.getProperty("username");
        String pword=prop.getProperty("password");
        emailField.sendKeys(uname);
        passwordField.sendKeys(pword);
        keepLoggedIn.click();
        submit.click();
        loginMessage.equals(successLogin);
    }
}
