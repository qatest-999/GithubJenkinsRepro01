package Main.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {

	public static WebDriver driver;
	
	public static void BrowserSetUp() {
		WebDriverManager.chromiumdriver().setup();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("headless");
		driver= new ChromeDriver(options);
		driver.get("https://demoqa.com/links");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public String getPageTitle() {
		return  driver.getTitle();
	}
}
