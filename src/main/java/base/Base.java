package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public static Properties prop;

    public Base() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("/home/shazadk/intellije_projects/amplifierTesting/src/main/java/resources/dataFile.properties");
        try {
            prop.load(fis);
            System.out.println("Properties loaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void initialization() {
        String browserUrl=prop.getProperty("url");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(CommonUtils.implicitWait, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(CommonUtils.pageLoadTimeout, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get(browserUrl);
    }
    public static void waitForAElement(WebElement element){
        WebDriverWait w =new WebDriverWait(driver, Duration.ofSeconds(15000));
        w.until(ExpectedConditions.visibilityOf(element));
    }

}
