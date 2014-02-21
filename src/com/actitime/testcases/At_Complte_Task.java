package com.actitime.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.actitime.libraries.ProjSpecific;
import com.actitime.libraries.SuperTestNG;

public class At_Complte_Task extends SuperTestNG
{
	@Test
	public void testAt_Complte_Task() throws InterruptedException
	{
		ProjSpecific.Login();
		driver.findElement(By.xpath("//div[text()='Tasks']")).click();
		driver.findElement(By.name("visiableFilterString")).clear();
		driver.findElement(By.name("visiableFilterString")).sendKeys("Bug fixing");
		driver.findElement(By.name("searchTasks")).click();
		String eMsg=driver.findElement(By.xpath("//a[text()='Bug fixing']")).getText();
		driver.findElement(By.xpath("//tr[td[a[text()='Bug fixing']]]//td[7]/input")).click();
		driver.findElement(By.xpath("//input[@value='Complete Selected Tasks']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("visiableFilterString")).clear();
		driver.findElement(By.name("searchTasks")).click();
		driver.findElement(By.xpath("//a[text()='Completed Tasks']")).click();
		Thread.sleep(5000);
		String aMsg=driver.findElement(By.xpath("//a[text()='Bug fixing']")).getText();
		ProjSpecific.verifyMsg(eMsg, aMsg);
	}

}
