package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wdWait;
    public static Actions actions;

    @BeforeEach
    public void setUp() {

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);

        wdWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        actions = new Actions(driver);

        driver.get("https://etherscan.io/register");
        driver.manage().window().maximize();
        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Got it!')]"))).click();
        actions.scrollByAmount(0,100).perform();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
