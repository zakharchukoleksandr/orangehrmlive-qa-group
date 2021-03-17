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
        driver.get("https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/auth/login");
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
        WebElement submitButton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));

        //login and chek
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        loginField.sendKeys("opensourcecms");
        passwordField.sendKeys("opensourcecms");
        submitButton.click();


    }

    @AfterMethod
    public void teardown() {
        driver.quit();//close all page of browser
    }

}


