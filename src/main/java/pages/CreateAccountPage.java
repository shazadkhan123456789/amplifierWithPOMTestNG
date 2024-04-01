package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

import java.util.Properties;

public class CreateAccountPage {
    private WebDriver driver;
    private Properties prop;
    public CreateAccountPage(WebDriver driver, Properties prop){
        this.driver = driver;
        this.prop = prop;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[text()='CREATE ONE']")
    WebElement create;

    @FindBy(id = ":r2:")
    WebElement email;

    @FindBy(xpath = "//button[@data-testid='button-data-test-id']")
    WebElement submit;

    @FindBy(id = ":r3:")
    WebElement createPassword;
    @FindBy(id = ":r4:")
    WebElement confirmPassword;

    public void createAccount() throws InterruptedException {
        create.click();
        email.sendKeys(prop.getProperty("username"));
        createPassword.sendKeys(prop.getProperty("password"));
        Thread.sleep(1000);
        confirmPassword.sendKeys(prop.getProperty("password"));
        submit.click();

    }

}
