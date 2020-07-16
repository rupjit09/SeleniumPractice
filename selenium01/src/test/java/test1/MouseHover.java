package test1;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rdas\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.addExtensions(new File("C:\\Users\\rdas\\Desktop\\selenium\\extension_6_1_7_0.crx"));
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com");
		Actions action=new Actions(driver);
		Thread.sleep(5000);
		action.moveToElement(driver.findElement(By.xpath("//a[@id='highlight-addons']"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'Student Discount')]")).click();
		
	}

}
