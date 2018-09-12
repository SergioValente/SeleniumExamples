package edureka;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1 {

	WebDriver driver;
	JavascriptExecutor jse;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sergio.valente\\eclipse-workspace\\SeleniumExample\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://www.edureka.co");
	}

	public void searchCourse() throws InterruptedException {

		driver.findElement(By.id("homeSearchBar")).sendKeys("java");
		Thread.sleep(2000);

		driver.findElement(By.id("homeSearchBarIcon")).click();
	}

	public void scrollDown() throws InterruptedException {

		Thread.sleep(5000);
		jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 2000)");
		
		driver.findElement(By.xpath("//*[@id=\"footer-blog\"]/a")).click();
	}

	public static void main(String[] args) throws InterruptedException {

		Day1 day1 = new Day1();

		day1.invokeBrowser();
		day1.searchCourse();
		day1.scrollDown();

	}

}
