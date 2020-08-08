package test1;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class Random1 {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor exe;
	Actions act;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rdas\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.addExtensions(new File("C:\\Users\\rdas\\Desktop\\selenium\\extension_6_1_7_0.crx"));
		driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.navigate().to("https://www.americangolf.co.uk");
		wait=new WebDriverWait(driver, 120);
		exe=(JavascriptExecutor)driver;
		act=new Actions(driver);
	}
	
	@Test
	public void validateDriverProductCount() {
		WebElement golfClub=driver.findElement(By.xpath("//div[@id='header-navigation']//div//a[contains(text(),'Golf Clubs')]"));
		act.moveToElement(golfClub).build().perform();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='flyout-left']//span[@class='name'][contains(text(),'Drivers')]"))));
		driver.findElement(By.xpath("//div[@class='flyout-left']//span[@class='name'][contains(text(),'Drivers')]")).click();
		WebElement leftBox=driver.findElement(By.xpath("//div[@id='secondary']"));
		WebElement a=driver.findElement(By.xpath("//div[@class='grid-row']//i[@class='icon icon-plus']"));
		//a.click();
		exe.executeScript("arguments[0].click()", a);
		HashMap<String,Integer> driverCounts=new HashMap<String, Integer>();
		List<WebElement> links=driver.findElements(By.xpath("//div[@id='secondary']//a"));
		for (WebElement x:links) {
			String url=x.getAttribute("href");
			WebElement ds=driver.findElement(By.xpath("//a[@href='"+url+"']//span[@class='refinement-name']"));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='"+url+"']//span[@class='refinement-name']")));
			//System.out.println("ds="+ds);
			String refinement_name=driver.findElement(By.xpath("//a[@href='"+url+"']//span[@class='refinement-name']")).getAttribute("textContent");
			String refinement_count=driver.findElement(By.xpath("//a[@href='"+url+"']//span[@class='refinement-count']")).getAttribute("textContent");
			System.out.println("refinement_name="+refinement_name);

			
			int count=Integer.parseInt(refinement_count.substring(2, refinement_count.length()-1));
			System.out.println("refinement_count="+count);
			driverCounts.put(refinement_name, count);
		}
	
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
