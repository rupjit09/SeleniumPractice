package test1;

import java.io.IOException;

import frameworkUtils.ReadFile;

public class RoughWork {

	public static void main(String[] args) throws IOException {

		System.out.println(ReadFile.getProperty("browser",System.getProperty("user.dir")+"\\src\\test\\java\\frameworkUtils\\config.properties"));
	}

}
