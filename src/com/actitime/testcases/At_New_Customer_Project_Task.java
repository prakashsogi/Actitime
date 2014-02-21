package com.actitime.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.actitime.libraries.Generic;
import com.actitime.libraries.ProjSpecific;
import com.actitime.libraries.SuperTestNG;
/*
 * Author-Prakash S
 * Reviewer- Pradeep
 * Approver- Bhanu Prakash
 */

public class At_New_Customer_Project_Task extends SuperTestNG
{
	
	@Test
	public void testAt_New_Customer_Project_Task() throws InterruptedException
	{
		String XLPath="G:/VtigerWorkspace/ActiTime/excelfiles/ActiTime.xlsx";
		String Sheet="task";
		ProjSpecific.Login();
		ProjSpecific.createTask();
		for(int i=0;i<=Generic.XLRow(XLPath, Sheet);i++)
		{
		ProjSpecific.findListItem(driver.findElement(By.name("customerId")), "-- new customer --");
		driver.findElement(By.name("customerName")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 0));
		driver.findElement(By.name("projectName")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 1));
		Thread.sleep(5000);
		}
	}
	

}
