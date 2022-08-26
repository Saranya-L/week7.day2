package stepdefinition;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CreateAccounts extends ProjectSpecificMethod{

		@When("Click Sales from App Launcher")
		public void clickSales()
		{
		driver.findElement(By.xpath("//span/p[text()='Sales']")).click();
		}
		@Then("Click on Accounts tab")
		public void clickAccount()
		{
		WebElement tab=driver.findElement(By.xpath("(//span[text()='Accounts'])[1]"));
		JavascriptExecutor execute=(JavascriptExecutor)driver;
		execute.executeScript("arguments[0].click();", tab);
		}
		@When("Click on New button")
		public void clicknew()
		{
		driver.findElement(By.xpath("//div[@title='New']")).click();
		}
		@And("Enter {string} as account name")
		public void enterName(String acctname)
		{
		WebElement name=driver.findElement(By.xpath("(//input[@class='slds-input'])[2]"));
		name.sendKeys(acctname,Keys.ENTER);
		}
		@And("Enter account name as (.*)$")
		public void enterNames(String acctname)
		{
		WebElement name=driver.findElement(By.xpath("(//input[@class='slds-input'])[2]"));
		name.sendKeys(acctname,Keys.ENTER);
		}
		@Then("get the text and Store it")
		public void getText()
		{
		WebElement name=driver.findElement(By.xpath("(//input[@class='slds-input'])[2]"));
		String getname=name.getAttribute("value");
		}
		@Then("get the text and Store it and print")
		public void getTextandPrint()
		{
		WebElement name=driver.findElement(By.xpath("(//input[@class='slds-input'])[2]"));
		String getname=name.getAttribute("value");
		System.out.println(getname);
		}
		@Then("Select Ownership as Public")
		public void selectOwnership()
		{
		WebElement ownership=driver.findElement(By.xpath("(//span[text()='--None--'])[3]"));
		Actions builder1=new Actions(driver);
		builder1.scrollToElement(ownership).perform();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ownership));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",ownership);
		driver.findElement(By.xpath("//span[text()='Public']")).click();
		}
		@When("click Save")
		public void clickSave()
		{
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		}
		@Then("verify Account name as {string}")
		public void verifyacctname(String name)
		{
		String verifyname=driver.findElement(By.xpath("//lightning-formatted-text[@class='custom-truncate']")).getText();
		if(name.equals(verifyname)) {
			System.out.println("Name is verified and its correct");
		}else 
		{
			System.out.println("While verifying name it is found the name is incorrect");
		}
	
		}
		@Then("verify account name as (.*)$")
		public void verifyacctnames(String name)
		{
		String verifyname=driver.findElement(By.xpath("//lightning-formatted-text[@class='custom-truncate']")).getText();
		Assert.assertEquals(name,verifyname);
		System.out.println("Name is verified and its correct");
		}
}
