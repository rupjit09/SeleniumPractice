package test1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class Test2Locators extends Test1{

	public static void main(String[] args) {
		

		launchBrowser("chrome");
		driver.get("https://www.goindigo.in/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		//locate by xpath
		driver.findElement(By.xpath("//label[contains(text(),'Round Trip')]")).click();
		driver.findElement(By.xpath("//div[@class='ig-input-group field-float']//input[@placeholder='From']")).click();
		//driver.findElement(By.xpath("//div[@class='ig-input-group field-float']//input[@placeholder='From']")).sendKeys("Mumbai");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.findElement(By.xpath("//div[@class='ig-input-group field-float']//input[@placeholder='From']")).sendKeys(Keys.ENTER);

		//driver.findElement(By.xpath("//div[@class='ig-input-group']//div[@class='autocomplete-result station-result clearfix airport-item pop-dest-stn']//div[@class='airport-city'][contains(text(),'Mumbai, India')]")).click();
		driver.findElement(By.xpath("//div[@data-name='Mumbai']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ig-input-group']//input[@placeholder='To' and @name='or-dest']")));
		driver.findElement(By.xpath("//div[@class='ig-input-group']//input[@placeholder='To' and @name='or-dest']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement e1=driver.findElement(By.xpath("//div[@class='ig-input-group']//div[@class='autocomplete-result station-result clearfix airport-item pop-dest-stn' and @data-name='Kolkata']"));
		JavascriptExecutor exe=(JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click();", e1);
		
		//click and set the departure date
		driver.findElement(By.xpath("//div[@class='ig-input-group field-float cal-focus']//input[@placeholder='Departure Date']")).click();
		
		//Some important way of locating elements
		driver.findElement(By.xpath("//input[contains(@class,'indis')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		driver.findElement(By.xpath("//div[starts-with(@class,'ig-ip_')]")).click();
		driver.findElement(By.xpath("//div[ends-with(@class,'ig-ip_')]")).click();
		

		//angular 8 locator
		JavascriptExecutor js=((JavascriptExecutor)driver);
		NgWebDriver ngdriver=new NgWebDriver(js);
		ngdriver.waitForAngularRequestsToFinish();
		driver.findElement(ByAngular.buttonText("")).click();
		/*sample xpath
		//a[contains(text(),'Roston Chase')]//ancestor::tbody//following-sibling::tbody//a[@class='long-name']
		Others that can be used are as below>>
ancestor-------------Selects all ancestors (parent, grandparent, etc.) of the current node
ancestor-or-self-----Selects all ancestors (parent, grandparent, etc.) of the current node and the current node itself
attribute------------Selects all attributes of the current node
child----------------Selects all children of the current node
descendant-----------Selects all descendants (children, grandchildren, etc.) of the current node
descendant-or-self---Selects all descendants (children, grandchildren, etc.) of the current node and the current node itself
following------------Selects everything in the document after the closing tag of the current node
following-sibling----Selects all siblings after the current node
namespace------------Selects all namespace nodes of the current node
parent---------------Selects the parent of the current node
preceding------------Selects all nodes that appear before the current node in the document, except ancestors, attribute nodes and namespace nodes
preceding-sibling----Selects all siblings before the current node
self-----------------Selects the current node
		*/

	}

}
