package test1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DragNdrop {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rdas\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.addExtensions(new File("C:\\Users\\rdas\\Desktop\\selenium\\extension_6_1_7_0.crx"));
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com");
		driver.findElement(By.xpath("//a[contains(text(),'Droppable')]")).click();
		driver.switchTo().frame(0);
		Actions action=new Actions(driver);
		WebElement src=driver.findElement(By.id("draggable"));
		WebElement dest=driver.findElement(By.id("droppable"));
		//drag and drop method1
		action.clickAndHold(src).moveToElement(dest).build().perform();
		Thread.sleep(5000);
		FileUtils.cleanDirectory(new File("C:\\Users\\rdas\\Desktop\\selenium\\SceenShot"));
		//take Screen Shot
		frameworkUtils.RandomUtils.getScreenShot(driver, "C:\\Users\\rdas\\Desktop\\selenium\\SceenShot\\test1.png");;
		driver.navigate().refresh();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		src=driver.findElement(By.id("draggable"));
		dest=driver.findElement(By.id("droppable"));
		//drag and drop method2
		action.dragAndDrop(src, dest).build().perform();
		Thread.sleep(5000);
		frameworkUtils.RandomUtils.getScreenShot(driver, "C:\\Users\\rdas\\Desktop\\selenium\\SceenShot\\test2.png");;
	}

}
