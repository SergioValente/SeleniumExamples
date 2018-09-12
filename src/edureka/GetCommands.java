package edureka;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetCommands {

	WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		GetCommands testObj = new GetCommands();
		
		testObj.invokeBrowser();
		testObj.getCommands();
	}

	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sergio.valente\\eclipse-workspace\\SeleniumExample\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);	
	}
	
	public void getCommands() throws InterruptedException {
		driver.get("http://www.amazon.com");
		driver.findElement(By.linkText("Today's Deals")).click();
		driver.findElement(By.xpath("//*[@id=\"widgetFilters\"]/div[1]/div[2]/span[7]/div/label/span")).click();
		Thread.sleep(2000);
		driver.navigate().back();
	}
}
