package stepdefinition;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CreateNewDashboard extends ProjectSpecificMethod{

		@When("click Dashboards from App Launcher")
		public void clickDashboard()
		{
		WebElement dashboard=driver.findElement(By.xpath("//p[text()='Dashboards']"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dashboard));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",dashboard);
		}
		@Then("Click on the New Dashboard option")
		public void newDashboard()
		{
		driver.findElement(By.xpath("//div[@title='New Dashboard']")).click();
		}
		@And("Enter Name as {string}")
		public void enterName(String dashboardName)
		{
		WebElement dashboardFrame1=driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(dashboardFrame1);
		WebElement name=driver.findElement(By.xpath("(//input[@class='slds-input'])[1]"));
		name.sendKeys(dashboardName);
		}
		@And("Enter dashboardname as (.*)$")
		public void enterNames(String dashboardName)
		{
		WebElement dashboardFrame1=driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(dashboardFrame1);
		WebElement name=driver.findElement(By.xpath("(//input[@class='slds-input'])[1]"));
		name.sendKeys(dashboardName);
		}
		@Then("get text and store and print")
		public void getandprint()
		{
			WebElement name=driver.findElement(By.xpath("(//input[@class='slds-input'])[1]"));
			String getname=name.getAttribute("value");
			System.out.println(getname);
		}
		@When("Click on Create")
		public void clickCreate()
		{
		driver.findElement(By.id("submitBtn")).click();
		}
		@Then("Click on Save")
		public void save()
		{
		driver.switchTo().defaultContent();
		WebElement dashboardFrame2=driver.findElement(By.xpath("(//iframe[@title='dashboard'])[1]"));
		driver.switchTo().frame(dashboardFrame2);
		WebElement dashboardFrame3=driver.findElement(By.xpath("(//iframe[@title='dashboard'])[1]"));
		driver.switchTo().frame(dashboardFrame3);
		WebElement save=driver.findElement(By.xpath("//button[text()='Save']"));
		save.click();
		}
		@Then("Click on done")
		public void clickDone()
		{
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		}
		@Then("Verify Dashboard name as {string}")
		public void verifyDashboard(String getname)
		{
		driver.switchTo().defaultContent();
		WebElement dashboardFrame4=driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(dashboardFrame4);
		String verifyname=driver.findElement(By.xpath("//span[@class='slds-page-header__title slds-truncate']")).getText();
		if(getname.equals(verifyname)) {
			System.out.println("Name is verified and its correct");
		}else 
		{
			System.out.println("While verifying name it is found the name is incorrect");
		}
		}
		@Then("Verify dashboard name as (.*)$")
		public void verifyDashboards(String getname)
		{
		driver.switchTo().defaultContent();
		WebElement dashboardFrame4=driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(dashboardFrame4);
		String verifyname=driver.findElement(By.xpath("//span[@class='slds-page-header__title slds-truncate']")).getText();
		Assert.assertEquals(getname,verifyname);
		System.out.println("Name is verified and its correct");
		}
	}
