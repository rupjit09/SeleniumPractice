package frameworkUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {
	
	public static void getScreenShot(WebDriver d1,String OutFilePath) throws IOException {
		TakesScreenshot sc=((TakesScreenshot)d1);
		File srcFile=sc.getScreenshotAs(OutputType.FILE);
		File destFile=new File(OutFilePath);
		FileUtils.copyFile(srcFile, destFile);
		
	}
}
