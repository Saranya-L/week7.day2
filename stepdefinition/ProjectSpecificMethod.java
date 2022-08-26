package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethod  extends  AbstractTestNGCucumberTests{
	public static ChromeDriver driver;
	public static int i=0;

	@BeforeMethod
	public void init() {
		// We have to call WDM for the browser driver !!
		WebDriverManager.chromedriver().setup(); // verify the version, download, set up !

		// Handle Browser notifications
		ChromeOptions options = new ChromeOptions();

		// Notfications
		options.addArguments("--disable-notifications");

		// Launch the browser (chrome)
		driver = new ChromeDriver(options);
		//Load the url
		driver.get("https://login.salesforce.com/");
		//Maximize the browser
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter the username and password,click on login button
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
		
		//Click on the toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//Click View All and click Individuals from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
