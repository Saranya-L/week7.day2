package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CreateOpportunityWithoutMandatoryFields extends ProjectSpecificMethod{
		
		@When("click sales option from App Launcher")
		public void clickSales()
		{
		driver.findElement(By.xpath("//span/p[text()='Sales']")).click();
		}
		@Then("click on Opportunity tab button")
		public void opportunitytab()
		{
		WebElement tab=driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
		JavascriptExecutor execute=(JavascriptExecutor)driver;
		execute.executeScript("arguments[0].click();", tab);
		}
		@Then("click new for new opportunity")
		public void newOpportunity()
		{
		driver.findElement(By.xpath("//div[@title='New']")).click();
		}
		@And("And Enter Opportunity name in the text box as (.*)$")
		public void opportunityName(String opportunity)
		{
			WebElement name=driver.findElement(By.xpath("(//input[@class='slds-input'])[4]"));
			name.sendKeys(opportunity,Keys.ENTER);
		}
		@And("Choose close date as Tomorrow")
		public void dateTomorrow()
		{
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).click();
		driver.findElement(By.xpath("//button[text()='Today']")).click();
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).click();
		driver.findElement(By.xpath("//td[@class='slds-is-today slds-is-selected']/following-sibling::td[1]")).click();
		}
		@And("Select Stage as Need Analysis option")
		public void selectStage() 
		{
		driver.findElement(By.xpath("(//button[@data-value='--None--'])[1]")).click();
		WebElement stage=driver.findElement(By.xpath("//span[@title='Needs Analysis']"));
		JavascriptExecutor execute=(JavascriptExecutor)driver;
		execute.executeScript("arguments[0].click();", stage);
		}
		@And("Click on Save button")
		public void saveButton()
		{
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		}
		@Then("Verify the Alert message displayed")
		public void verifyAlert()
		{
		String verifyname=driver.findElement(By.xpath("(//div[@role='dialog'])[2]")).getText();
		System.out.println(verifyname);
		}
	}
	

