package seleniumtest1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class seleniumtestclass {

    public static void main(String[] args) {
        // ChromeDriver setup
       System.setProperty("webdriver.chrome.driver", "E:\\chromedriver-win64\\chromedriver.exe"); // Update path
       WebDriver chromeDriver = new ChromeDriver();
       chromeDriver.get("https://parabank.parasoft.com/parabank/register.htm");
        
       System.out.println("Chrome opened: " + chromeDriver.getTitle());
       
    
       
        // GeckoDriver setup
        System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-win64\\geckodriver.exe"); // Update path
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://parabank.parasoft.com/parabank/register.htm");
        System.out.println("Firefox opened: " + firefoxDriver.getTitle());
  
        
    }
}