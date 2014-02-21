package com.actitime.testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.actitime.libraries.ProjSpecific;
import com.actitime.libraries.SuperTestNG;

public class At_Request_New_Feature extends SuperTestNG
{
	@Test
	public void testAt_Request_New_Feature() throws InterruptedException
	{
		ProjSpecific.Login();
		ProjSpecific.SupportMenu("Request an Additional Feature");
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> it=wh.iterator();
		String parent=it.next();
		String child=it.next();
		driver.switchTo().window(child);
		driver.findElement(By.id("feature")).sendKeys("deleting a task from time sheet");
		driver.findElement(By.id("emailAddress")).sendKeys("p@gmail.com");
		driver.findElement(By.id("companyName")).sendKeys("TestCompany Pvt Ltd");
		//Thread.sleep(5000);
		driver.findElement(By.id("submitButton")).click();
	}
}
