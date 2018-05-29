import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TestClass {
    protected static WebDriver driver;

    @BeforeClass
    public static void setupBrowser() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://zalenium:4444/wd/hub"), DesiredCapabilities.firefox());
    }

    @Before
    public void openBrowser() {
        driver.get("https://www.google.fr");
    }

    @Test
    public void FirstTest() {
        WebElement gLuck = driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div[3]/center/input[2]"));
        gLuck.click();
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }
}
