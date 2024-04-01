package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

public class CommonUtils {
    public static int implicitWait=10;
    public static int pageLoadTimeout=100;
    WebDriver driver;
    public CommonUtils(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void switchToParentWindow() throws InterruptedException {
        Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        Thread.sleep(2000);
        driver.switchTo().window(parentWindow);
    }
    public void switchToChildWindow() throws InterruptedException {
        Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        Thread.sleep(2000);
        driver.switchTo().window(childWindow);
    }
    public void closeCurrentTab(){
        driver.close();
    }
    public void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void javaScriptExecuterClick(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
