package test1;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SwitchIframe {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rdas\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.addExtensions(new File("C:\\Users\\rdas\\Desktop\\selenium\\extension_6_1_7_0.crx"));
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html");
		//System.out.println(driver.getPageSource());
		driver.switchTo().frame("classFrame");
		System.out.println(driver.findElement(By.xpath("//a[contains(text(),'org.openqa.selenium.firefox.internal')]")).getText());
		driver.switchTo().defaultContent();
		//getFrame count and framenames
		List<WebElement> frames=driver.findElements(By.tagName("frame"));
		System.out.println("No of frames in the page is = "+frames.size());
		System.out.print("FrameNames are : ");
		for(WebElement s:frames) {
			System.out.print(s.getAttribute("name")+",");
			
		}
		}

}
