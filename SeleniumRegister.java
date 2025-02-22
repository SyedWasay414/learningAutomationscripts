package seleniumtest1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class SeleniumRegister {

    public static void main(String[] args) {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver-win64\\chromedriver.exe");
        
        // GeckoDriver setup
        System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-win64\\geckodriver.exe"); // Update path
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
       
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        WebDriver firefoxDriver = new FirefoxDriver();
        
        // Maximize window
       // driver.manage().window().maximize();
       // firefoxDriver.manage().window().maximize();
        
        // Set an implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        firefoxDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // Open the target webpage
        driver.get("https://parabank.parasoft.com");
        firefoxDriver.get("https://parabank.parasoft.com");
        
        // Locate and click the "Register" button
        WebElement registerButton = driver.findElement(By.linkText("Register"));
        registerButton.click();
        
        // Locate and click the "Register" button in Firefox
        WebElement registerButtonff = firefoxDriver.findElement(By.linkText("Register"));
        registerButtonff.click();
        
        // Fill out the registration form
        driver.findElement(By.id("customer.firstName")).sendKeys("Asad");
        firefoxDriver.findElement(By.id("customer.firstName")).sendKeys("Kamran");
        driver.findElement(By.id("customer.lastName")).sendKeys("Jalal");
        firefoxDriver.findElement(By.id("customer.lastName")).sendKeys("Khan");
        driver.findElement(By.id("customer.address.street")).sendKeys("xyz street");
        firefoxDriver.findElement(By.id("customer.address.street")).sendKeys("xyz street");
        driver.findElement(By.id("customer.address.city")).sendKeys("Karachi");
        firefoxDriver.findElement(By.id("customer.address.city")).sendKeys("Lahore");
        driver.findElement(By.id("customer.address.state")).sendKeys("Sindh");
        firefoxDriver.findElement(By.id("customer.address.state")).sendKeys("Punjab");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("789942");
        firefoxDriver.findElement(By.id("customer.address.zipCode")).sendKeys("8764564");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("03385467541");
        firefoxDriver.findElement(By.id("customer.phoneNumber")).sendKeys("03244654864");
        driver.findElement(By.id("customer.ssn")).sendKeys("15644654");
        firefoxDriver.findElement(By.id("customer.ssn")).sendKeys("54545556");
        driver.findElement(By.id("customer.username")).sendKeys("Asad Jalal");
        firefoxDriver.findElement(By.id("customer.username")).sendKeys("Kamran Khan");
        driver.findElement(By.id("customer.password")).sendKeys("KingUser123");
        firefoxDriver.findElement(By.id("customer.password")).sendKeys("KingUser123");
        driver.findElement(By.id("repeatedPassword")).sendKeys("KingUser123");
        firefoxDriver.findElement(By.id("repeatedPassword")).sendKeys("KingUser123");
        
        // Submit the registration form 
         WebElement registerButton2 = driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input"));
         registerButton2.click();
      
        // Submit the registration form for firefox
         WebElement registerButton3 = firefoxDriver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input"));
         registerButton3.click();
         
       //Locate and click of the "Logout" Button
 	    WebElement Logout = driver.findElement(By.linkText("Log Out"));
 	    Logout.click();
 	   
 	    //Locate and click for firefox logout
 	   WebElement Logoutff = firefoxDriver.findElement(By.linkText("Log Out"));
	    Logoutff.click();
    }
}

