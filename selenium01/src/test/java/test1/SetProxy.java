package test1;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SetProxy {

	public static void main(String[] args) {

		Proxy pr=new Proxy();
		pr.setProxyAutoconfigUrl("https://hidester.com/proxy/");
		/*//Using DesiredCapabilities but deprecated
		DesiredCapabilities c=new DesiredCapabilities();
		c.setCapability(CapabilityType.PROXY, c); //if we use this then we get error so use Options class
	*/	
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\rdas\\Desktop\\selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		//WebDriver driver=new FirefoxDriver(c); //DesiredCapabilities is deprecated
		FirefoxOptions opt=new FirefoxOptions();
		opt.setProxy(pr);
		WebDriver driver=new FirefoxDriver(opt);
	}

}
