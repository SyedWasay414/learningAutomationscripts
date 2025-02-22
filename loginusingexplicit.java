package seleniumtest1;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginusingexplicit {

    private static final Logger LOGGER = Logger.getLogger(loginusingexplicit.class.getName()); // Logger for debugging

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

        String browser = "firefox"; // Change to "chrome" or "firefox" as needed

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver(options);
        }

        // Maximize window
        driver.manage().window().maximize();
        LOGGER.info("Browser window maximized.");

        // Open the target webpage in the first tab
        driver.get("https://parabank.parasoft.com");
        LOGGER.info("Navigated to: " + driver.getCurrentUrl());

        // Perform login/logout in first tab with Explicit Wait
        performLoginAndLogout(driver);

        // Open a new tab using Robot class (Keyboard Shortcut: CTRL+T)
        openNewTab();

        // Switch to new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // Switch to second tab
        LOGGER.info("Switched to new tab.");

        // Open the same/different website in the new tab
        driver.get("https://parabank.parasoft.com");
        LOGGER.info("Navigated to: " + driver.getCurrentUrl());

        // Perform login/logout in second tab with Explicit Wait
        performLoginAndLogout(driver);

        // Close the browser
       // driver.quit();
       // LOGGER.info("Browser closed.");
    }

    // Method to perform login and logout with Explicit Wait and Try-Catch for Exception Handling
    public static void performLoginAndLogout(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Wait for username field and enter value
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            usernameField.sendKeys("Anfal Polani");
            LOGGER.info("Entered username.");

            // Wait for password field and enter value
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            passwordField.sendKeys("KingUser123");
            LOGGER.info("Entered password.");

            // Wait for Submit button and click
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")));
            submitButton.click();
            LOGGER.info("Clicked on login button.");

            // Wait for Logout button and click
            WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log Out")));
            logoutButton.click();
            LOGGER.info("Clicked on logout button.");

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error during login/logout: " + e.getMessage());
        }
    }

    // Method to open a new tab using Robot class with Try-Catch
    public static void openNewTab() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(2000); // Wait for the new tab to open
            LOGGER.info("Opened a new tab.");
        } catch (AWTException | InterruptedException e) {
            LOGGER.log(Level.SEVERE, "Error while opening new tab: " + e.getMessage());
        }
    }
}
