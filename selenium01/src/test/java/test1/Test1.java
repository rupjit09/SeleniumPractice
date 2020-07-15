package test1;

import java.io.File;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test1 {
	static WebDriver driver;
	public static void main(String[] args) {
		
				launchBrowser("chrome");
				driver.get("https://www.google.co.in/");
		
		
	}
	
	public static void launchBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\rdas\\Desktop\\selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			//FirefoxBinary binary=new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
			//DesiredCapabilities cap = DesiredCapabilities.firefox();
			//FirefoxOptions options = new FirefoxOptions();
			//cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(binary));
			ProfilesIni prf=new ProfilesIni();
			FirefoxProfile prof= prf.getProfile("default");
			FirefoxOptions opt=new FirefoxOptions();
			opt.setProfile(prof);
			driver = new FirefoxDriver(opt);			
		}else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\rdas\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions opt=new ChromeOptions();
			opt.addExtensions(new File("C:\\Users\\rdas\\Desktop\\selenium\\extension_6_1_7_0.crx"));
			//opt.addArguments("user-data-dri=C:\\Users\\rdas\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
			driver=new ChromeDriver(opt);
		}
	}
}
