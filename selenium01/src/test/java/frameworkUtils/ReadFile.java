package frameworkUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFile {

		public static String getProperty(String propertyName, String propertiesFileLocation) throws IOException {
		Properties prop= new Properties();
		FileInputStream fp=new FileInputStream(propertiesFileLocation);
		prop.load(fp);
		String propertyValue=prop.getProperty(propertyName, "Property Not Found");
		return propertyValue;
		}
}
