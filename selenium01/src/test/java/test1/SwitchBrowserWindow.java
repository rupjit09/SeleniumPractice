package test1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SwitchBrowserWindow {

	public static void main(String[] args) throws InterruptedException {

		BasicConfigurator.configure();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rdas\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.addExtensions(new File("C:\\Users\\rdas\\Desktop\\selenium\\extension_6_1_7_0.crx"));
		WebDriver driver=new ChromeDriver(opt);
		//WebDriver driver=new HtmlUnitDriver();
		driver.navigate().to("http://www.popuptest.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String mainWindowID=driver.getWindowHandle();
		String mainWindowTitle=driver.getTitle();
		System.out.println("");
		Logger logger=Logger.getLogger(SwitchBrowserWindow.class);
		logger.debug("WindowId="+mainWindowID);
		logger.debug("Main WindowTitle="+mainWindowTitle);
		driver.findElement(By.linkText("Multi-PopUp Test")).click();
		Thread.sleep(10000);;
		Set<String> allWindowIds=driver.getWindowHandles();
		logger.debug("No of windows="+allWindowIds.size());
		System.out.println("All Window Ids="+allWindowIds);
		ArrayList<String> titles = new ArrayList<String>();
		for(String ids:allWindowIds) {
			System.out.println("wIds="+ids);

			driver.switchTo().window(ids);
			String btitle=driver.getCurrentUrl();
			System.out.println("title="+btitle);
			titles.add(btitle);
		}
		System.out.println("Window Titles="+titles);
		
		
	}

}
