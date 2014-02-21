package com.actitime.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.actitime.libraries.ProjSpecific;
import com.actitime.libraries.SuperTestNG;

public class At_DeleteCompleted_Task extends SuperTestNG
{
	@Test
	public void testAt_DeleteCompleted_Task() throws InterruptedException
	{
		ProjSpecific.Login();
		driver.findElement(By.xpath("//div[text()='Tasks']")).click();
		driver.findElement(By.xpath("//a[text()='Completed Tasks']")).click();
		try
		{
		driver.findElement(By.xpath("//tr[td[a[text()='eCommerce business-logic review']]]//input")).click();
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("//a[contains(text(),'Next')]")).click();
			driver.findElement(By.xpath("//tr[td[a[text()='eCommerce business-logic review']]]//input")).click();
			Thread.sleep(5000);
		}
		
		
	}

}
