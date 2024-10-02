package Main.Pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {

	public static WebDriver driver;
	public List<WebElement> links;
	
	
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
	
	public int getNumberlinks() {		
		links = driver.findElements(By.tagName("a"));
		return links.size();
	}
	
	public void verifyLinks() throws IOException {
		String url="";
		for (int i=0; i<links.size(); i++) {
			WebElement element= links.get(i);
			url= element.getAttribute("href");
			try {
				URL newurl = new URL(url);
				HttpURLConnection urlconnection = (HttpURLConnection) newurl.openConnection();
				urlconnection.connect();
				if(urlconnection.getResponseCode()>=400) {
					System.out.println(newurl+" - "+urlconnection.getResponseMessage()+"is a broken link");
				}
				else {
					System.out.println(newurl+ " - "+urlconnection.getResponseMessage());
				}
					
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void teardown() {
		driver.quit();
	}
}
