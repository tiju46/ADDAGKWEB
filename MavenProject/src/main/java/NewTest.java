import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

 
public class NewTest {
 
	WebDriver driver;
 
  
       @BeforeTest
       public void launchbrowser() {
	        
   
	  System.out.println("######--- launching Mozilla FireFox browser ---######");
	  //System.setProperty("webdriver.gecko.driver","C:\\Users\\tiju thomas\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
	  System.setProperty("webdriver.gecko.driver", "/home/testing/Downloads/geckodriver-v0.24.0-linux64/geckodriver");
	  //options.setCapability("marionette", false);
	  FirefoxOptions options = new FirefoxOptions();
	     File pathToBinary = new File("/home/testing/firefox-62.0/firefox/firefox-bin");
	     FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
	     FirefoxProfile firefoxProfile = new FirefoxProfile();
      options.setHeadless(true);
      driver = new FirefoxDriver(options);
      }
  
        @Test(priority=1)
        public void openADDAGK() throws InterruptedException {
        System.out.println("######--- launching ADDA GateKeeper Web ---######");
		driver.navigate().to("https://apartmentadda.com/user/security.php?is_adda_io=0#/visitor/visitor-in");
		driver.findElement(By.name("email")).sendKeys("thomastiju@yahoo.com");
	    driver.findElement(By.name("password")).sendKeys("adda1234");
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    driver.findElement(By.id("submit_login")).click();
	    System.out.println("Test Case Passed ----- Successfully Logged In");
	    Thread.sleep(5000);
	    }
        
        @Test(priority=2)
        public void CheckIn() throws InterruptedException {
        System.out.println("*****--- Expected Visitor ---*****");
	    driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='unit_number']")).click();
	    driver.findElement(By.xpath("//div[contains(text(),'200-15')]")).click();
	    driver.findElement(By.xpath("//button[@type='button'][contains(text(),'CHECK IN')]")).click();
	    Thread.sleep(5000);
        driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='reason']")).click();
	    driver.findElement(By.xpath("//div[contains(text(),'Personal')]")).click();
	    driver.findElement(By.xpath("//button[@name='save_visiter']")).click();
	    System.out.println("Test Case Passed ----- Visitor Checked In");
	    Thread.sleep(10000);
        }
	   
	    @Test(priority=3)
	    public void CheckOut() throws InterruptedException {
	    driver.findElement(By.xpath("//a[@href='#/visitor/visitor-out']")).click();
	    driver.findElement(By.xpath("//button[@type='button' and contains(., 'CHECK OUT')]")).click();
	    System.out.println("Test Case Passed ----- Visitor Checked Out");
	    Thread.sleep(5000);
	    }
	    
	    // @Test(priority=4)
        public void MAnualCheckIn() throws InterruptedException {
        System.out.println("*****--- Normal Visitor ---*****");
        driver.findElement(By.xpath("//a[@href='#/visitor/visitor-in']")).click();
	    driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='unit_number']")).click();
	    driver.findElement(By.xpath("//div[contains(text(),'200-14')]")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("2255005522");
	    driver.findElement(By.xpath("//input[@id='full_name']")).sendKeys("Normal Visitor");
	    driver.findElement(By.xpath("//input[@id='vehicle_number']")).sendKeys("KA03HY6254");
	    Thread.sleep(5000);
        driver.findElement(By.xpath("//ng-multiselect-dropdown[@id='reason']")).click();
	    driver.findElement(By.xpath("//div[contains(text(),'Personal')]")).click();
	    driver.findElement(By.xpath("//textarea[@id='note']")).sendKeys("Manually Entered Visitor Checkin");
	    driver.findElement(By.xpath("//button[@name='save_visiter']")).click();
	    Thread.sleep(5000);
	    System.out.println("Test Case Passed ----- Visitor Checked In");
        }
	   
	    // @Test(priority=5)
	    public void ManualCheckOut() throws InterruptedException {
	    driver.findElement(By.xpath("//a[@href='#/visitor/visitor-out']")).click();
	    driver.findElement(By.xpath("//button[@type='button' and contains(., 'CHECK OUT')]")).click();
	    Thread.sleep(5000);
	    System.out.println("Test Case Passed ----- Visitor Checked Out");
	    }
	    @Test(priority=5)
	    public void staffcheckin() throws InterruptedException {
	    driver.findElement(By.xpath("//p[contains(text(),'Staff')]")).click();
	    driver.findElement(By.xpath("//button[@type='button'][contains(text(),'CHECK IN')]")).click();
	    Thread.sleep(5000);
	    System.out.println("Test Case Passed ----- Staff Checked In");
	    }
	    @Test(priority=6)
	    public void staffcheckout() throws InterruptedException {
	    driver.findElement(By.xpath("//a[@href='#/staff/staff-out']")).click();
	    driver.findElement(By.xpath("//button[@type='button'][contains(text(),'CHECK OUT')]")).click();
	    Thread.sleep(5000);
	    System.out.println("Test Case Passed ----- Staff Checked Out");
	    }
        @AfterTest
        public void closeDriver() {
		if(driver!=null) {
			driver.close();
	    System.out.println("######--- Browser Closed ---######");
		}
	}
 
}