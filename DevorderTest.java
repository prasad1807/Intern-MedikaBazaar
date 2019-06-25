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
public class DevorderTest {
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
  public String waitForWindow(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Set<String> whNow = driver.getWindowHandles();
    Set<String> whThen = (Set<String>) vars.get("window_handles");
    if (whNow.size() > whThen.size()) {
      whNow.removeAll(whThen);
    }
    return whNow.iterator().next();
  }
  @Test
  public void devorder() {
    driver.get("https://dev.medikabazaar.com/");
    driver.findElement(By.id("x")).click();
    driver.findElement(By.cssSelector(".sign")).click();
    driver.findElement(By.id("email")).sendKeys("prasadandhale18@gmail.com");
    driver.findElement(By.id("pass")).sendKeys("Prasad@18");
    driver.findElement(By.cssSelector("#send2 > span")).click();
    driver.findElement(By.cssSelector(".logo img")).click();
    driver.findElement(By.cssSelector(".col-left .pt_menu:nth-child(1) > .parentMenu span")).click();
    vars.put("window_handles", driver.getWindowHandles());
    driver.findElement(By.cssSelector(".item:nth-child(2) .product-image")).click();
    vars.put("win9821", waitForWindow(2000));
    vars.put("root", driver.getWindowHandle());
    driver.switchTo().window(vars.get("win9821").toString());
    js.executeScript("window.scrollTo(0,67)");
    js.executeScript("window.scrollTo(0,164)");
    driver.findElement(By.id("zipcode")).click();
    driver.findElement(By.id("zipcode")).sendKeys("400038");
    driver.findElement(By.cssSelector("#zip-check > span")).click();
    driver.findElement(By.id("increase")).click();
    driver.findElement(By.id("increase")).click();
    driver.findElement(By.id("increase")).click();
    driver.findElement(By.id("increase")).click();
    driver.findElement(By.cssSelector("#inner_cart_title_36165 > span")).click();
    driver.findElement(By.cssSelector("a:nth-child(1) > .cart-box")).click();
    driver.findElement(By.id("points_all")).click();
    js.executeScript("window.scrollTo(0,92)");
    driver.findElement(By.cssSelector("#reward-points-form .button:nth-child(1) > span > span")).click();
    driver.findElement(By.id("coupon_code")).click();
    js.executeScript("window.scrollTo(0,92)");
    driver.findElement(By.id("coupon_code")).sendKeys("MBBOW");
    driver.findElement(By.cssSelector("#discount-coupon-form .button")).click();
    driver.findElement(By.cssSelector(".btn-proceed-checkout")).click();
    js.executeScript("window.scrollTo(0,151)");
    driver.findElement(By.cssSelector("a:nth-child(1) > .btn")).click();
    driver.findElement(By.cssSelector("#billing-buttons-container > .button")).click();
    driver.findElement(By.cssSelector("#payment-buttons-container > .button")).click();
    driver.findElement(By.id("p_method_zestmoney_zestpay")).click();
    driver.findElement(By.cssSelector("#payment-buttons-container > .button > span")).click();
    driver.findElement(By.cssSelector(".btn-checkout")).click();
    driver.findElement(By.cssSelector(".btn-checkout > span")).click();
  }
}