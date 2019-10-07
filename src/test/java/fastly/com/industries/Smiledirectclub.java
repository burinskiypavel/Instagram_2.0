package fastly.com.industries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Smiledirectclub {
    public WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    void beforeClass() {
        //baseTest.initialization();
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
    }

    @AfterClass
    void afterClass() {
        driver.quit();
    }


    @Test
    public void Test_01_New() throws IOException {
        driver.navigate().to("https://smiledirectclub.com/smileshops/");
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("menu--utility-sign-up-mobile")));
        driver.findElement(By.cssSelector("span[class='close-btn js-close-btn']")).click();

        List<WebElement> statesWeb = driver.findElements(By.cssSelector("p[class='state-header eyebrow bold store-locations']"));
        for(int i = 0; i < statesWeb.size(); i++){

            String statesText = statesWeb.get(i).getText();
            statesWeb.get(i).click();
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a[class='store-link']")));

            //int size = driver.findElements(By.cssSelector("div[class='collapse in']")).size();
            List<String> cities = new ArrayList<>();

            WebElement currenState = driver.findElements(By.cssSelector("div[class='shops-by-state-list panel panel-default']")).get(i);
            List<WebElement> citiesWeb = currenState.findElements(By.cssSelector("a[class='store-link']"));

            for(WebElement match : citiesWeb){
                cities.add(match.getText());
            }
            System.out.println(statesText);

            for(int a = 0; a < cities.size(); a++){

            System.out.println(cities.get(a));
        }
            System.out.println("\n");

    }
}}
