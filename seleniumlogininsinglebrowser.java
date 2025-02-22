package seleniumtest1;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class seleniumlogininsinglebrowser {
	
    public static void main(String[] args) throws AWTException, InterruptedException {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver-win64\\chromedriver.exe");

        // Set up GeckoDriver path for Firefox
        System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-win64\\geckodriver.exe");

        // Firefox Options
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

        // Initialize WebDriver (Choose Chrome or Firefox)
        WebDriver driver;  

        String browser = "chrome"; // Change to "chrome" or "firefox" as needed

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver(options);
        }

        // Maximize window
        driver.manage().window().maximize();
        
        // Set an implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(200));

        // Open the target webpage in the first tab
        driver.get("https://parabank.parasoft.com");
        System.out.println(driver.getCurrentUrl());
        
        // Perform login/logout in first tab
        performLoginAndLogout(driver);
        
        // Open a new tab using Robot class (Keyboard Shortcut: CTRL+T)
        openNewTab();

        // Switch to new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // Switch to second tab

        // Open the same/different website in the new tab
        driver.get("https://parabank.parasoft.com");
        System.out.println(driver.getCurrentUrl());
        
        // Perform login/logout in second tab
        performLoginAndLogout(driver);
        
        
        // Close the browser
        //driver.quit();
    }

    
    //Methods which is defined in the series upwards
    
    ///////////////////////////////////////////////////////////////////////////////
    // Method to perform login and logout
    public static void performLoginAndLogout(WebDriver driver) {
        // Sign in with registered credentials
        driver.findElement(By.name("username")).sendKeys("Ali Sohaib");
        driver.findElement(By.name("password")).sendKeys("KingUser123");

        // Locate and click the "Submit" button
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input"));
        submitButton.click();
        
        // Locate and click the "Logout" button
       // WebElement logoutButton = driver.findElement(By.linkText("Log Out"));
        //logoutButton.click();
        
    }
    
    // Method to open a new tab using Robot class
    public static void openNewTab() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(2000); // Wait for the new tab to open
//////////////////////////////////////////////////////////////////////////////////    
    
    }
}
