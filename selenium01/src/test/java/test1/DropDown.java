package test1;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rdas\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.addExtensions(new File("C:\\Users\\rdas\\Desktop\\selenium\\extension_6_1_7_0.crx"));
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("#login-button")).click();
		System.out.println("Page Title= "+driver.getTitle());
		
		//handle dropdown
		Select sel=new  Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		sel.selectByVisibleText("Name (Z to A)");
		Thread.sleep(5000);
		sel.selectByValue("hilo");
		Thread.sleep(5000);
		sel.selectByIndex(2);
	}

}
