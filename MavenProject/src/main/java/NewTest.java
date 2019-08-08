import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

 
public class NewTest {
 
	WebDriver driver;
 
  
   @BeforeTest
  public void launchbrowser() {
   
	  System.out.println("launching Mozilla FireFox browser");
	  //System.setProperty("webdriver.gecko.driver","C:\\Users\\tiju thomas\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
	  System.setProperty("webdriver.gecko.driver", "/home/testing/Downloads/geckodriver-v0.24.0-linux64/geckodriver");
	  // FirefoxOptions options = new FirefoxOptions();
	  //options.setCapability("marionette", false);
	  driver = new FirefoxDriver();
  }
  
    
 //@BeforeMethod
  public Void bmthd() {
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	return null;


}
  
 @Test(priority=1)
  public void openADDAGK() {
		driver.navigate().to("https://apartmentadda.com/user/security.php?is_adda_io=0#/visitor/visitor-in");
		driver.findElement(By.name("email")).sendKeys("thomas@3five8.com");
	    driver.findElement(By.name("password")).sendKeys("adda12345");
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    //click on login button
	    driver.findElement(By.id("submit_login")).click();
	    
	}
 @Test(priority=2)
 public void CheckIn() throws InterruptedException {
	    driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='unit_number']")).click();
	    driver.findElement(By.xpath("//div[contains(text(),'Block 1-002')]")).click();
	    driver.findElement(By.xpath("//tr"));	
	    driver.findElement(By.xpath("//button[@type='button'][contains(text(),'CHECK IN')]")).click();
	    //Wait for 5 Sec
	    Thread.sleep(5000);
	    //JavascriptExecutor js = (JavascriptExecutor) driver;
	    //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    //Thread.sleep(5000);
         driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='reason']")).click();
	     driver.findElement(By.xpath("//div[contains(text(),'Personal')]")).click();
	    driver.findElement(By.xpath("//button[@name='save_visiter']")).click();
	    Thread.sleep(5000);
	    
 }
	   
	    @Test(priority=3)
	    public void CheckOut() throws InterruptedException {
	    driver.findElement(By.xpath("//a[@href='#/visitor/visitor-out']")).click();
	    driver.findElement(By.xpath("//button[@type='button' and contains(., 'CHECK OUT')]")).click();
	    Thread.sleep(5000);
	    }
 
 @AfterTest
 public void closeDriver() {
		if(driver!=null) {
			driver.close();
		}
	}
 
}