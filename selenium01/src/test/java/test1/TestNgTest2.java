package test1;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

public class TestNgTest2 {

	WebDriver driver;
	
	@BeforeTest
	@Parameters("browserName")
	public void setupBrowser(String browserName){
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rdas\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions opt=new ChromeOptions();
			opt.addExtensions(new File("C:\\Users\\rdas\\Desktop\\selenium\\extension_6_1_7_0.crx"));
			driver=new ChromeDriver(opt);
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\rdas\\Desktop\\selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			//FirefoxOptions opt=new FirefoxOptions();
			driver=new FirefoxDriver();
		}
	}
	
	@BeforeMethod
	public void landingPage(){
		driver.get("http://automationtesting.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	@Test(priority=0)
	public void SeleniumTest() {
		driver.findElement(By.xpath("//a[@class='ui builder_button default']//span[contains(text(),'Selenium')]")).click();
	}
	
}
