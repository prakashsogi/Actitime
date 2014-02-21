package com.actitime.libraries;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProjSpecific extends SuperTestNG
{
	public static void Login()
	{
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		//driver.findElement(By.xpath("Logout")).click();
	}
	
	public static void LogOut()
	{
		//driver.findElement(By.id("logoutLink")).click();
		driver.findElement(By.linkText("Logout")).click();
		//driver.findElement(By.xpath("//div[@class='logoutContainer']/table/tbody/tr/td[3]")).click();
	}
	
	public static void createCustomer()
	{
		driver.findElement(By.xpath("//div[text()='Tasks']")).click();
		driver.findElement(By.linkText("Projects & Customers")).click();
	}
	
	public static void verifyMsg(String eMsg,String aMsg)
	{
		Assert.assertEquals(eMsg, aMsg);
	}
	
	public static void findListItem(WebElement find,String s)
	{
		//System.out.println(s);
		Select sl=new Select(find);
		sl.selectByVisibleText(s);
	}
	
	public static void createUser()
	{
		driver.findElement(By.xpath("//div[contains(text(),'Users')]")).click();
		
	}
	
	public static void alertPopup()
	{
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	public static void generateReport()
	{
		driver.findElement(By.xpath("//div[contains(text(),'Reports')]")).click();
		//driver.findElement(By.xpath("//span[contains(text(),'Create Report')]")).click();
	}
	
	public static void createTask()
	{
		driver.findElement(By.xpath("//div[text()='Tasks']")).click();
		driver.findElement(By.xpath("//input[@value='Create New Tasks']")).click();
	}
	
	public static int getINT(WebElement we,int beg,int end)
	{
		
		int INT=Integer.parseInt(we.getText().substring(beg, end));
		return INT;
		
	}
	
	public static void SupportMenu(String support)
	{
		driver.findElement(By.xpath("//span[text()='Help & Support']")).click();
		switch(support)
		{
		case "Send a Question to Vendor":
					driver.findElement(By.xpath("//div[contains(text(),'Send a Question to Vendor')]")).click();
					break;
		case "Check for Updates":
					driver.findElement(By.xpath("//div[contains(text(),'Check for Updates')]")).click();	
					break;
		case "Frequently Asked Questions":
					driver.findElement(By.xpath("//div[contains(text(),'Frequently Asked Questions')]")).click();
					break;
		case "About actiTIME":
					driver.findElement(By.xpath("//div[contains(text(),'About actiTIME')]")).click();
					break;
		case "Request an Additional Feature":
					driver.findElement(By.xpath("//div[contains(text(),'Request an Additional Feature')]")).click();
					break;
		default:
				driver.quit();
		}
	}
	
	public static void searchTask(WebElement we,String project)
	{
		driver.findElement(By.id("cpSelector.cpButton.contentsContainer")).click();
		driver.findElement(By.xpath("//tr[td[label[span[text()='"+project+"']]]]//input")).click();
		driver.findElement(By.id("closeButton")).click();
		driver.findElement(By.name("searchTasks")).click();
	}

}
