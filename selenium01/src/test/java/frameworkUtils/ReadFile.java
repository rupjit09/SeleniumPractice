package frameworkUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		System.out.println(ReadFile.getProperty("browser"));

	}
	public static String getProperty(String propertyName) throws IOException {
		
		Properties prop= new Properties();
		System.out.println(System.getProperty("user.dir")+"\\src\\test\\java\\frameworkUtils\\config.properties");
		FileInputStream fp=new FileInputStream("C:/Users/rdas/Desktop/selenium/gitrepo/Learnselenium/selenium01/src/test/java/frameworkUtils/config.properties");
		prop.load(fp);
		String propertyValue=prop.getProperty(propertyName, "Property Not Found");
		return propertyValue;
		
	}
}
