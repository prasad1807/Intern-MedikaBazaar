// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
public class GuestlogTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void guestlog() {
    driver.get("https://medikabazaar.com/");
    driver.findElement(By.linkText("Sign In")).click();
    driver.findElement(By.linkText("Continue as a guest")).click();
    driver.findElement(By.id("custname")).click();
    driver.findElement(By.id("custname")).sendKeys("rahul");
    driver.findElement(By.id("mobileNumber")).sendKeys("5678901234");
    driver.findElement(By.id("emailId")).sendKeys("qwerty@gmail.com");
    driver.findElement(By.cssSelector(".button:nth-child(1)")).click();
  }
}
