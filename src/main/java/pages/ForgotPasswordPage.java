package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

import java.util.Properties;

public class ForgotPasswordPage {
    private WebDriver driver;
    private Properties prop;
    public ForgotPasswordPage(WebDriver driver, Properties prop){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.prop = prop;
    }
    @FindBy(xpath = "//*[text()='Forgot password?']")
    WebElement forgotPassword;
    @FindBy(id = ":r2:")
    WebElement email;

    @FindBy(xpath = "//button[@data-testid='button-data-test-id']")
    WebElement submit;

    @FindBy(id = ":r2:")
    WebElement createPassword;
    @FindBy(id = ":r3:")
    WebElement confirmPassword;


    public void forgotPassword() throws InterruptedException {
        forgotPassword.click();
        email.sendKeys(prop.getProperty("username"));
        submit.click();
        Thread.sleep(1000);
        createPassword.sendKeys(prop.getProperty("password"));
        Thread.sleep(1000);
        confirmPassword.sendKeys(prop.getProperty("password"));
        submit.click();
    }

}
