package seleniumtest1;
import java.awt.AWTException;
import java.time.Duration;
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

	public class Loginfundtransferandlogout {
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

	        String browser = "chrome"; // Change to "chrome" or "firefox" as needed

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
	    }
	    
	   // Method to perform login and logout with Explicit Wait and Try-Catch for Exception Handling
	        public static void performLoginAndLogout(WebDriver driver) {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	            try {
	                // Wait for username field and enter value
	                WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
	                usernameField.sendKeys("Richa Chadda");
	                LOGGER.info("Entered username.");

	                // Wait for password field and enter value
	                WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
	                passwordField.sendKeys("KingUser123");
	                LOGGER.info("Entered password.");

	                // Wait for Submit button and click
	                WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")));
	                submitButton.click();
	                LOGGER.info("Clicked on login button.");

	                WebElement FundTransfer = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#leftPanel > ul > li:nth-child(3) > a")));
	                FundTransfer.click();
	                LOGGER.info("Clicked on Fund Transfer.");
	                
	                WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount")));
	                amountField.sendKeys("10");
	                LOGGER.info("Succesfully Amount Entered");
	                
	                WebElement Fromaccountdropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"fromAccountId\"]/option")));
	                Fromaccountdropdown.click();
	                LOGGER.info("Succesfully dropdown value is selected");
	                
	                
	                WebElement transferButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"transferForm\"]/div[2]/input")));
	                transferButton.click();
	                LOGGER.info("Transaction Successfull");
	                
	                
	                
	                // Wait for Logout button and click
	                //WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log Out")));
	               // logoutButton.click();
	               // LOGGER.info("Clicked on logout button.");

	            } catch (Exception e) {
	                LOGGER.log(Level.SEVERE, "Error during login/logout: " + e.getMessage());
	            }
	        
	        
	        }
	    
	    
	    
	    }
	
