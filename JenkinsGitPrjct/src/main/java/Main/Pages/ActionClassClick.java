package Main.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClassClick {

	public static WebDriver driver;
	Actions action;
	
	public static void BrowserSetUp() {
		WebDriverManager.chromiumdriver().setup();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("headless");
		driver= new ChromeDriver(options);
		driver.get("https://demoqa.com/buttons");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public boolean doubleClick() {
		WebElement doubleclicktn= driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		action = new Actions(driver);
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(doubleclicktn));
		action.doubleClick(doubleclicktn).perform();
		return doubleclicktn.isDisplayed();			
	}
	
	public boolean rightClick() {
		WebElement rightclickbtn= driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
		action= new Actions(driver);
		
		action.contextClick(rightclickbtn).perform();
	
		return rightclickbtn.isDisplayed();
	}
	
	public void teardown() {
		driver.quit();
	}
}
