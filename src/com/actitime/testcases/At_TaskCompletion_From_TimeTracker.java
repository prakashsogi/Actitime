package com.actitime.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.actitime.libraries.Generic;
import com.actitime.libraries.ProjSpecific;
import com.actitime.libraries.SuperTestNG;
/*
 *Author-Prakash S
 * Reviewer-Pradeep
 * Approver- Bhanu Prakaksh
 * LMD-18-01-2014
 */
public class At_TaskCompletion_From_TimeTracker extends SuperTestNG
{
	@Test
	public void testAt_TaskCompletion_From_TimeTracker() throws InterruptedException
	{
		String XLPath="G:/VtigerWorkspace/ActiTime/excelfiles/ActiTime.xlsx";
		String Sheet="CustandProj";
		ProjSpecific.Login();
		String eMsg="Your changes were successfully saved.";
		String aMsg=" ";
		Actions act= new Actions(driver);
			for(int i=0;i<=Generic.XLRow(XLPath, Sheet);i++)
				{
					String proj=Generic.XLCellValue(XLPath, Sheet, i, 4);
					//act.moveToElement(driver.findElement(By.xpath("//tbody[@id='actualTTRows']/tr[1]/td[14]"))).perform();
					act.moveToElement(driver.findElement(By.xpath("//tr[td[contains(text(),'"+proj+"')]]/td[14]"))).perform();
					//driver.findElement(By.xpath("//tbody[@id='actualTTRows']/tr[1]/td[14]//div//div[1]/a")).click();
					driver.findElement(By.xpath("//tr[td[contains(text(),'"+proj+"')]]/td[14]/div/div[1]/a")).click();
					//Thread.sleep(1000);
					driver.findElement(By.xpath("//input[@value='Save Changes']")).click();
					aMsg=driver.findElement(By.xpath("//span[contains(text(),'Your changes were successfully saved.')]")).getText();
					driver.navigate().refresh();
				}
		ProjSpecific.verifyMsg(eMsg, aMsg);
		
	}
}
