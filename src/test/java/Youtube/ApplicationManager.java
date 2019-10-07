package Youtube;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

public class ApplicationManager {
    public WebDriver driver;

    public void initialization() {

        String browser = BrowserType.CHROME;
        if(browser == BrowserType.FIREFOX){
            //driver = new FirefoxDriver();
            //System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
            System.setProperty("webdriver.gecko.driver","driver/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser == BrowserType.CHROME){
            //driver = new ChromeDriver();
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver(chromeOptions);
        } else if (browser == BrowserType.IE){
            driver = new InternetExplorerDriver();
        }


        //System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        //ChromeOptions chromeOptions = new ChromeOptions();
        //driver = new ChromeDriver(chromeOptions);

        //System.setProperty("webdriver.gecko.driver","driver/geckodriver.exe");
        //driver = new FirefoxDriver();
    }
}
