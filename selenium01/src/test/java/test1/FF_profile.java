package test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class FF_profile {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\rdas\\Desktop\\selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		ProfilesIni pin=new ProfilesIni();
		FirefoxProfile pf=pin.getProfile("default");
		FirefoxOptions opt=new FirefoxOptions();
		opt.setProfile(pf);
		WebDriver driver=new FirefoxDriver(opt);
	}

}
