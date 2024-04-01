package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[text()='AMPLIFIER']")
    WebElement amplifierHomePage;

    @FindBy(xpath = "//*[text()='HEALTH DASHBOARD']")
    WebElement healthDashboard;

    @FindBy(xpath = "//*[text()='ORGANIZATION']")
    WebElement Organization;

    @FindBy(xpath = "//*[text()='DEPARTMENTS']")
    WebElement Department;

    @FindBy(xpath = "//*[text()='USERS']")
    WebElement Users;


    @FindBy(xpath = "//*[text()='Everyone']")
    WebElement Everyone;
    public void validatingHomePage(){
        amplifierHomePage.equals("AMPLIFIER");
        healthDashboard.equals("HEALTH DASHBOARD");
        Organization.getAttribute("aria-selected=true");
        Department.equals("DEPARTMENTS");
        Users.equals("USERS");
        Everyone.equals("Everyone");
    }

}
