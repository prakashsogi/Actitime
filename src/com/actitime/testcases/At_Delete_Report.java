package com.actitime.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.actitime.libraries.Generic;
import com.actitime.libraries.ProjSpecific;
import com.actitime.libraries.SuperTestNG;
/*
 * Author-Prakash S
 * Reviewer-Pradeep
 * Approver-BhanuPrakash
 * LMD -20-01-2014
 */
public class At_Delete_Report extends SuperTestNG
{
	@Test(groups={"Delete"})
	public void testAt_Delete_Report() throws InterruptedException
	{
		String XLPath="G:/VtigerWorkspace/ActiTime/excelfiles/ActiTime.xlsx";
		String Sheet="reports";
		ProjSpecific.Login();
		driver.findElement(By.xpath("//div[contains(text(),'Reports')]")).click();
		for(int i=1;i<=Generic.XLRow(XLPath, Sheet);i++)
		{
			String Rep=Generic.XLCellValue(XLPath, Sheet, i, 5);
			try{
			driver.findElement(By.xpath("//tbody[tr[td[div[div[text()='"+Rep+"']]]]]//tr[3]/td[4]/div//a[2]/img")).click();
			//Thread.sleep(1000);
			ProjSpecific.alertPopup();
			}catch(Exception e)
			{
				System.out.println("No such "+Rep+" Report exists");
			}
		}
	}

}
