package test1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.paulhammant.ngwebdriver.ByAngular;

public class DyanamicWebTable {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rdas\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.addExtensions(new File("C:\\Users\\rdas\\Desktop\\selenium\\extension_6_1_7_0.crx"));
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/WebTable.html");
		
		String xp1="//div[contains(@id,'";
		String email_xp="-uiGrid-0005-cell')]//div[@class='ui-grid-cell-contents ng-binding ng-scope']";
		String fname_xp="-uiGrid-0006-cell')]//div[@class='ui-grid-cell-contents ng-binding ng-scope']";
		String gen_xp="-uiGrid-0007-cell')]//div[@class='ui-grid-cell-contents ng-binding ng-scope']";
		String lname_xp="-uiGrid-0008-cell')]//div[@class='ui-grid-cell-contents ng-binding ng-scope']";
		String phone_xp="-uiGrid-0009-cell')]//div[@class='ui-grid-cell-contents ng-binding ng-scope']";
		List<WebElement> records;
		ArrayList<String> FirstName=new ArrayList<String>();
		ArrayList<String> Gender=new ArrayList<String>();
		ArrayList<String> Email=new ArrayList<String>();
		ArrayList<String> Phone=new ArrayList<String>();
		ArrayList<String> Lastname=new ArrayList<String>();

		Select select=new Select(driver.findElement(ByAngular.model("grid.options.paginationPageSize")));
		select.selectByValue("number:20");
		records=driver.findElements(By.xpath("//div[@class='ui-grid-row ng-scope']"));
		int max_page_size=Integer.parseInt((driver.findElement(By.xpath("//span[@class='ui-grid-pager-max-pages-number ng-binding']")).getText()).substring(2));
		for(int j=1;j<=max_page_size;j++) {
		for(int i=0;i<records.size();i++) {
			String final_xpath_Firstname=xp1+i+fname_xp;
			String fname=driver.findElement(By.xpath(final_xpath_Firstname)).getText();
			String final_xpath_Lastname=xp1+i+lname_xp;
			String lname=driver.findElement(By.xpath(final_xpath_Lastname)).getText();
			String final_xpath_email=xp1+i+email_xp;
			String email=driver.findElement(By.xpath(final_xpath_email)).getText();
			String final_xpath_gender=xp1+i+gen_xp;
			String gend=driver.findElement(By.xpath(final_xpath_gender)).getText();
			FirstName.add(fname);
			Lastname.add(lname);
			Email.add(email);
			Gender.add(gend);
		}
		driver.findElement(By.xpath("//button[@class='ui-grid-pager-next']")).click();
		}
		/*String abc=driver.findElement(ByAngular.model("grid.options.paginationPageSize")).getAttribute("class");
		System.out.println("ABC="+abc);*/
		System.out.println("Count of fname records="+FirstName.size());
		System.out.println("Count of lname records="+Lastname.size());
		System.out.println("Firstname="+FirstName);
		System.out.println("Lastname="+Lastname);


		
	}

}
