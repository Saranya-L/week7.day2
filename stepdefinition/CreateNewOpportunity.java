package stepdefinition;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateNewOpportunity extends ProjectSpecificMethod{

		@When("click Sales from App Launcher")
		public void clickSales() 
		{
		driver.findElement(By.xpath("//span/p[text()='Sales']")).click();
		}
		@Then("click on Opportunity tab")
		public void clickoppurtunity() 
		{
		WebElement tab=driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
		JavascriptExecutor execute=(JavascriptExecutor)driver;
		execute.executeScript("arguments[0].click();", tab);
		}
		@When("click on New button")
		public void clicknew() 
		{
		driver.findElement(By.xpath("//div[@title='New']")).click();
		}
		@And("Enter Opportunity name as {string}")
		public void enterName(String opportunityname) 
		{
		WebElement name=driver.findElement(By.xpath("(//input[@class='slds-input'])[4]"));
		name.sendKeys(opportunityname,Keys.ENTER);
		}
		@And("Enter opportunity name as (.*)$")
		public void enterNames(String opportunityname) 
		{
		WebElement name=driver.findElement(By.xpath("(//input[@class='slds-input'])[4]"));
		name.sendKeys(opportunityname,Keys.ENTER);
		}
		@Then("Get the text and Store it")
		public void getText() 
		{
		WebElement name=driver.findElement(By.xpath("(//input[@class='slds-input'])[4]"));
		String getname=name.getAttribute("value");
		//System.out.println(getname);
		}
		@Then("Get the text and Store it and print")
		public void getTextandprint() 
		{
		WebElement name=driver.findElement(By.xpath("(//input[@class='slds-input'])[4]"));
		String getname=name.getAttribute("value");
		System.out.println(getname);
		}
		@And("Choose close date as Today")
		public void chooseCloseDate() 
		{
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).click();
		WebElement today=driver.findElement(By.xpath("//button[text()='Today']"));
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));

		try {
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click();",today);
		}catch (StaleElementReferenceException e)
		{
			System.out.println("Failed due to stale element exception");
			wait1.until(ExpectedConditions.stalenessOf(today));
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click();",today);
		}
		}
		@And("Select Stage as Need Analysis")
		public void selectStage() 
		{
		driver.findElement(By.xpath("(//button[@data-value='--None--'])[1]")).click();
		WebElement stage=driver.findElement(By.xpath("//span[@title='Needs Analysis']"));
		JavascriptExecutor execute=(JavascriptExecutor)driver;
		execute.executeScript("arguments[0].click();", stage);
		}
		@When("Click Save")
		public void clickSave() 
		{
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		}
		@Then("Verify Oppurtunity Name as {string}")
		public void verifyName(String getname) 
		{
		String verifyname=driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
		if(getname.equals(verifyname)) {
			System.out.println("Name is verified and its correct");
		}else 
		{
			System.out.println("While verifying name it is found the name is incorrect");
		}
		}
		@Then("Verify opportunity name as (.*)$")
		public void verifyNames(String getname) 
		{
		String verifyname=driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
		Assert.assertEquals(getname,verifyname);
		System.out.println("Name is verified and its correct");
		}
		
}


	

