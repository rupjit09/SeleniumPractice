package test1;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class Random1 {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor exe;
	Actions act;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rdas\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addExtensions(new File("C:\\Users\\rdas\\Desktop\\selenium\\extension_6_1_7_0.crx"));
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.navigate().to("https://www.americangolf.co.uk");
		wait = new WebDriverWait(driver, 120);
		exe = (JavascriptExecutor) driver;
		act = new Actions(driver);
	}

	@Test
	public void validateDriverProductCount() throws InterruptedException {
		WebElement golfClub = driver
				.findElement(By.xpath("//div[@id='header-navigation']//div//a[contains(text(),'Golf Clubs')]"));
		act.moveToElement(golfClub).build().perform();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(
				By.xpath("//div[@class='flyout-left']//span[@class='name'][contains(text(),'Drivers')]"))));
		driver.findElement(By.xpath("//div[@class='flyout-left']//span[@class='name'][contains(text(),'Drivers')]"))
				.click();
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='secondary']//a"));
		for (int x=0;x<links.size();x++) {
			links = driver.findElements(By.xpath("//div[@id='secondary']//a"));
			String url = links.get(x).getAttribute("href");
			if(driver.findElement(By.xpath("//div[@id='secondary']//h3[@class='toggle refinementhead']")).isDisplayed()) {
				exe.executeScript("arguments[0].click()", driver.findElement(By.xpath("//div[@id='secondary']//h3[@class='toggle refinementhead']")));
			}
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//a[@href='" + url + "']//span[@class='refinement-name']")));
			String refinement_name = driver
					.findElement(By.xpath("//a[@href='" + url + "']//span[@class='refinement-name']"))
					.getAttribute("textContent");
			String refinement_count = driver
					.findElement(By.xpath("//a[@href='" + url + "']//span[@class='refinement-count']"))
					.getAttribute("textContent");

			int count = Integer.parseInt(refinement_count.substring(2, refinement_count.length() - 1));
			
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='secondary']//a[@href='"+url+"']")));
			WebElement check=driver.findElement(By.xpath("//div[@id='secondary']//a[@href='"+url+"']"));
			exe.executeScript("arguments[0].click()", check);
			scrollBottom();
			List<WebElement> productsDisplayed = driver.findElements(By.xpath("//li[contains(@id,'liprod-')]"));
			//Validate the count an Assert
			if(count==productsDisplayed.size()) {
				System.out.println("Count Matched for Item "+refinement_name);
			}
			Assert.assertTrue(count==productsDisplayed.size(), "Count of Item"+refinement_name+"didnot matched");
			
			//Uncheck the checkbox
			WebElement uncheck=driver.findElement(By.xpath("//div[@id='secondary']//a[@href='https://www.americangolf.co.uk/golf-clubs/drivers']"));
			exe.executeScript("arguments[0].click()", uncheck);
			Thread.sleep(3000);
			
			
		}

	}

	@AfterMethod
	public void closeBrowser() {
		// driver.quit();
	}

	// The below method helps to scroll to the bottom of the page when dyanamic
	// content loads on scrolling down, this method will keep moving the scroll down
	// till all elements are loaded
	public void scrollBottom() {
		try {
			Object lastHeight = ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

			while (true) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(2000);

				Object newHeight = ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
				if (newHeight.equals(lastHeight)) {
					break;
				}
				lastHeight = newHeight;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
