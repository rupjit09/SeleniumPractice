package test1;



import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaDate {

	static WebDriver driver;
	public static void main(String[] args) throws ParseException, InterruptedException {

		
		String dob="01/08/2020";//dd/MM/yyyy
		String[] months= {"January","February","March","April","May","June","July","August","September","October","November","December"};
		SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		Date dt=df.parse(dob);
		Calendar cal=Calendar.getInstance();
		cal.setTime(dt);
		int dayToBeSelected=cal.get(Calendar.DAY_OF_MONTH);
		String monthToBeSelected=months[cal.get(Calendar.MONTH)];
		int yearToBeSelected=cal.get(Calendar.YEAR);
		System.out.println("dayToBeSelected="+dayToBeSelected);
		System.out.println("monthToBeSelected="+monthToBeSelected);
		System.out.println("yearToBeSelected="+yearToBeSelected);

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rdas\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.addExtensions(new File("C:\\Users\\rdas\\Desktop\\selenium\\extension_6_1_7_0.crx"));
		driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Datepicker.html");
		WebDriverWait wait=new WebDriverWait(driver, 120);
		JavascriptExecutor exe=(JavascriptExecutor)driver;
		
		
		//Select date in DatePicker Disabled calender
		WebElement datePicker= driver.findElement(By.xpath("//input[@class='form-control hasDatepicker']"));
		datePicker.click();
		//exe.executeScript("arguments[0].click();", datePicker);
		int defaultYear=Integer.parseInt(driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText());

		//Select Year
		if(defaultYear!=yearToBeSelected) {
		while(defaultYear<yearToBeSelected) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")));
			WebElement rightArrow=driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']"));
			//rightArrow.click();
			exe.executeScript("arguments[0].click();", rightArrow);
			defaultYear=Integer.parseInt(driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText());
		}
		while(defaultYear>yearToBeSelected) {
			System.out.println("defaultYearbeforClick="+defaultYear);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']")));
			WebElement leftArrow=driver.findElement(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']"));
			//leftArrow.click();
			exe.executeScript("arguments[0].click();", leftArrow);

			defaultYear=Integer.parseInt(driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText());
		}	
		}
		String monthDisplayedAfterMatchingYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		
		//Select Month
		if(defaultYear==yearToBeSelected && monthDisplayedAfterMatchingYear!=monthToBeSelected) {
			while(Arrays.asList(months).indexOf(monthDisplayedAfterMatchingYear)<Arrays.asList(months).indexOf(monthToBeSelected)) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")));
				WebElement rightArrow=driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']"));
				//rightArrow.click();
				exe.executeScript("arguments[0].click();", rightArrow);
				monthDisplayedAfterMatchingYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			}
			while(Arrays.asList(months).indexOf(monthDisplayedAfterMatchingYear)>Arrays.asList(months).indexOf(monthToBeSelected)) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']")));
				WebElement leftArrow=driver.findElement(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']"));
				//leftArrow.click();
				exe.executeScript("arguments[0].click();", leftArrow);
				monthDisplayedAfterMatchingYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			}
		}
		
		//selecting day
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//a[contains(text(),'"+dayToBeSelected+"')]")).click();
		
////******************************************************************************/////////
		
		//Select date in DatePicker Enabled calender
		driver.findElement(By.xpath("//input[@class='form-control is-datepick']")).click();
		
		//select Year
		WebElement year=driver.findElement(By.xpath("//select[@class='datepick-month-year' and @title='Change the year']"));
		Select sel=new Select(year);
		sel.selectByVisibleText(String.valueOf(yearToBeSelected));
		
		//select Month
		WebElement month=driver.findElement(By.xpath("//select[@class='datepick-month-year' and @title='Change the month']"));
		sel=new Select(month);
		sel.selectByVisibleText(monthToBeSelected);
		
		//select day

		driver.findElement(By.xpath("//div[contains(@class,'datepick-popup')]//descendant::td//a[contains(@title,'"+dayToBeSelected+"')]")).click();
	}

}
