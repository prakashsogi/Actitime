package com.actitime.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.actitime.libraries.Generic;
import com.actitime.libraries.ProjSpecific;
import com.actitime.libraries.SuperTestNG;
/*
 * Author- Prakash S
 * Reviewer- Pradeep
 * Approver- Bhanu Prakash
 * LMD-- 21-01-2014
 */

public class At_Delete_Billingtype extends SuperTestNG
{
	@Test(groups={"Delete"})
	public void testAt_Delete_Billingtype()
	{
		String eMsg=" ";
		String aMsg= " ";
		String XLPath="G:/VtigerWorkspace/ActiTime/excelfiles/ActiTime.xlsx";
		String Sheet="Billing";
		ProjSpecific.Login();
		driver.findElement(By.xpath("//div[contains(text(),'Settings')]")).click();
		driver.findElement(By.linkText("Billing Types")).click();
		for(int i=1;i<=Generic.XLRow(XLPath, Sheet);i++)
		{
			 eMsg=Generic.XLCellValue(XLPath, Sheet, i, 4);
			 try
			 {
				 driver.findElement(By.linkText(Generic.XLCellValue(XLPath, Sheet, i, 0))).click();
				 	if(driver.findElement(By.xpath("//input[@value='Delete This Billing Type']")).isEnabled())
				 		{
				 			driver.findElement(By.xpath("//input[@value='Delete This Billing Type']")).click();
				 			ProjSpecific.alertPopup();
				 			aMsg=driver.findElement(By.xpath("//span[@class='successmsg']")).getText();
				 			ProjSpecific.verifyMsg(eMsg, aMsg);
				
				 		}
				 	else
				 		{
				 			Thread.sleep(5000);
				 			//driver.findElement(By.xpath("//td[@id='ButtonPane']/input[2]")).click();
				 			((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//td[@id='ButtonPane']/input[2]")));
				 			continue;
				 		}
			 }
			 catch(Exception e)
			 {
				 System.out.println("No such billing "+Generic.XLCellValue(XLPath, Sheet, i, 0)+" exists");
				 continue;
				 
			 }
		}
	}

}
