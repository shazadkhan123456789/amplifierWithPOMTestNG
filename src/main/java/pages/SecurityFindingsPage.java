package pages;

import base.Base;
import org.bouncycastle.util.Pack;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SecurityFindingsPage {
    WebDriver driver;
    public SecurityFindingsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[text()='SECURITY FINDINGS']")
    WebElement securityFinding;

    @FindBy(css = "[data-testid='table-body'] tr:nth-child(1) td:nth-child(1)")
    WebElement selectingEmployees;

    @FindBy(css = "[role='menuitem']:nth-child(1)")
    WebElement engage;

    @FindBy(xpath = "//*[text()='ACTION']")
    WebElement action;
    @FindBy(css = "body div:nth-child(3) div button")
    WebElement send;

    @FindBy(xpath = "//*[text()='INTEGRATIONS & POLICIES']")
    WebElement integration;
    public void navigateToSecurityFindingPage() throws InterruptedException {
        integration.click();
        Thread.sleep(2000);
        securityFinding.click();
    }
    public void selectingEmployees(){
        Base.waitForAElement(selectingEmployees);
        selectingEmployees.click();
    }
    public void actionOnEmployees() throws InterruptedException {
        Thread.sleep(5000);
        Base.waitForAElement(action);
        action.click();
        Base.waitForAElement(engage);
        engage.click();
        Thread.sleep(2000);
        send.click();
    }

}
