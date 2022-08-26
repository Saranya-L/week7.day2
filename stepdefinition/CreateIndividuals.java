package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateIndividuals extends ProjectSpecificMethod{
		@When("click Individuals from App Launcher")
		public void clickIndividuals()
		{
		WebElement indiv=driver.findElement(By.xpath("//p[text()='Individuals']"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(indiv));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",indiv);
		}
		@Then("Click on the Dropdown icon in the Individuals tab")
		public void clickDropdown()
		{
		WebElement drop=driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[14]"));
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOf(drop));
		try {
			wait1.until(ExpectedConditions.visibilityOf(drop));
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click();",drop);
		}catch (StaleElementReferenceException e)
		{
			System.out.println("Failed due to stale element exception");
			wait1.until(ExpectedConditions.visibilityOf(drop));
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click();",drop);
		}}
		@When("Click on New Individual")
		public void newIndividual()
		{
		WebElement newindiv=driver.findElement(By.xpath("//span[text()='New Individual']"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();",newindiv);
		}
		@And("Enter the Last Name as {string}")
		public void lastName(String lastname)
		{
		driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']")).sendKeys(lastname,Keys.ENTER);
		}
		@And("Enter lastname as (.*)$")
		public void lastNames(String lastname)
		{
		driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']")).sendKeys(lastname,Keys.ENTER);
		}
		@Then("get the text and store and print it")
		public void getandprint()
		{
			WebElement name=driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']"));
			String getname=name.getAttribute("value");
			System.out.println(getname);
		}
		@When("click Save button for individuals")
		public void saveButton()
		{
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		}
		@Then("verify Individuals Name as {string}")
		public void individualName(String name)
		{
		String verifyname=driver.findElement(By.xpath("(//span[@class='uiOutputText'])[1]")).getText();
		if(name.equals(verifyname)) {
			System.out.println("Name is verified and its correct");
		}else 
		{
			System.out.println("While verifying name it is found the name is incorrect");
		}
		}
		@Then("verify individual name as (.*)$")
		public void individualNames(String name)
		{
		String verifyname=driver.findElement(By.xpath("(//span[@class='uiOutputText'])[1]")).getText();
		Assert.assertEquals(name,verifyname);
		System.out.println("Name is verified and its correct");
		}
}

