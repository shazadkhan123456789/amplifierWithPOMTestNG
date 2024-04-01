package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddIntegrationPage {
    WebDriver driver;
    public AddIntegrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[text()='INTEGRATIONS & POLICIES']")
    WebElement integration;

    public void addIntegration(){
        integration.click();
    }
}
