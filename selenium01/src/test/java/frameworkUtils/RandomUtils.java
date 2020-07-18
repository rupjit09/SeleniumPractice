package frameworkUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RandomUtils {
	
	
	//The below method takes snapshots
	public static void getScreenShot(WebDriver d1,String OutFilePath) throws IOException {
		TakesScreenshot sc=((TakesScreenshot)d1);
		File srcFile=sc.getScreenshotAs(OutputType.FILE);
		File destFile=new File(OutFilePath);
		FileUtils.copyFile(srcFile, destFile);
		
	}
	
	//The below method add a redborder
	public static void setborder(WebElement e1,WebDriver d1) {
		JavascriptExecutor js=((JavascriptExecutor)d1);
		js.executeScript("argument[0].style.border='3px solid red'", e1);
	}
	
	//The below method can be used to click on webelement by javascript
	public static void clickByJS(WebElement e1,WebDriver d1) {
		JavascriptExecutor js=((JavascriptExecutor)d1);
		js.executeScript("argument[0].click()", e1);
	}
	
	//The below method can be used to scroll to bottom using javascript
	public static void scrollToBottom(WebDriver d1) {
		JavascriptExecutor js=((JavascriptExecutor)d1);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	//The below method can be used to scroll to the mentioned element
		public static void scrollToElement(WebElement e1,WebDriver d1) {
			JavascriptExecutor js=((JavascriptExecutor)d1);
			js.executeScript("argument[0].scrollIntoView(true)",e1);
		}
}
