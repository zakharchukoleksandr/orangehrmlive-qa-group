import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class LoginLogoutAsseptTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.out.println("Start browser");
        driver = new ChromeDriver();
        System.out.println("Start orangehrm website");
        driver.get("https://opensource-demo.orangehrmlive.com/");
        //the window expands to full screen
        driver.manage().window().maximize();
        //test execution delay = 10 sec.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test(priority = 1, description = "login and check elements")
    public void TestLogin() {
        //define elements
        WebElement loginField = driver.findElement(By.id("txtUsername"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name=\"txtPassword\"]"));
        //chrome devtools - ctrl-f (//input[@name="txtUsername"])
        WebElement submitButton = driver.findElement(By.id("btnLogin"));

        //login and chek
        loginField.sendKeys("Admin");
        passwordField.sendKeys("admin123");
        submitButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("index.php/dashboard"));


    }

    @AfterMethod
    public void teardown() {
        driver.quit();//close all page of browser
    }

}


