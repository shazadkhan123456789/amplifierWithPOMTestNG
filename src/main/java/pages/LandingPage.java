package pages;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class LandingPage {

    private WebDriver driver;
    private Properties prop;

    public LandingPage(WebDriver driver, Properties prop){
        this.driver = driver;
        this.prop = prop;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@type='file']")
    WebElement browseFile;
    @FindBy(xpath = "//*[text() = '\"amplifier_data.csv\"  uploaded successfully']")
    WebElement successMessage;

    @FindBy(xpath = "//*[text() = 'PROCEED']")
    WebElement proceed;
    public void selectFile() throws InterruptedException {
        String file = prop.getProperty("demofile");
        browseFile.sendKeys(file);
        Base.waitForAElement(successMessage);
        successMessage.equals("\"amplifier_data.csv\"  uploaded successfully");
        proceed.click();

    }
}
