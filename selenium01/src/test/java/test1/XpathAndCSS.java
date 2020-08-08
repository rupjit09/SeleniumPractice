package test1;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XpathAndCSS {
//xpath Syntax: //tagname[@AttributeName='Attribute_Value'  and|or @2ndattributeName='2ndAttribute_Value']/Following tag
//cssSelector Syntax: tagname[AttributeName='Attribute_Value'] [@2ndattributeName='2ndAttribute_Value']	Following tag
	
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rdas\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.addExtensions(new File("C:\\Users\\rdas\\Desktop\\selenium\\extension_6_1_7_0.crx"));
		driver=new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
	}
	
	@Test
	public void signin() {
		driver.findElement(By.xpath("//span[contains(text(),'Hello, Sign in')]")).click();
		//span[class='nav-line-1'] 
		//Some important way of locating elements in xpath
				driver.findElement(By.xpath("//input[contains(@class,'indis')]")).click();
				driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
				driver.findElement(By.xpath("//div[starts-with(@class,'ig-ip_')]")).click();
				driver.findElement(By.xpath("//div[ends-with(@class,'ig-ip_')]")).click();
				
		//Same done via css selector
				driver.findElement(By.cssSelector("input[class*='indis']")).click();
				driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();//cannot be done in css select as text() is not there in css selector
				driver.findElement(By.cssSelector("div[class^='ig-ip_')]")).click();
				driver.findElement(By.xpath("//div[class$='ig-ip_')]")).click();
			//contains =*
			//starts-with = ^
			//ends-with = $
	}
}
