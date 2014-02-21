package com.actitime.testcases;

import org.openqa.selenium.By;
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
public class At_Create_Report_New extends SuperTestNG
{
	@Test(groups={"Create"})
	public void testAt_Create_Report() throws InterruptedException
	{
		String XLPath="G:/VtigerWorkspace/ActiTime/excelfiles/ActiTime.xlsx";
		String Sheet="reports";
		ProjSpecific.Login();
		ProjSpecific.generateReport();
		//Thread.sleep(5000);
		for(int k=1;k<=Generic.XLRow(XLPath, Sheet);k++)
		{
			driver.findElement(By.xpath("//span[contains(text(),'Create Report')]")).click();
			driver.findElement(By.xpath("//span[text()='"+Generic.XLCellValue(XLPath, Sheet, k, 0)+"']")).click();
			driver.findElement(By.id("configureReportParametersButton")).click();
			String type=Generic.XLCellValue(XLPath, Sheet, k, 0);
			for(int i=1;i<=Generic.XLRow(XLPath, Sheet);i++)
			{
				if(Generic.XLCellValue(XLPath, Sheet, i, 2).equals("y"))
				{
					driver.findElement(By.xpath("//tr[td[label[contains(text(),'Selected')]]]/td[1]/input")).click();
					//for local copy it is not working
					String user=Generic.XLCellValue(XLPath, Sheet, i, 3);
						if(type.equals("Overtime"))
							{
								driver.findElement(By.xpath("//select[@name='selectedUserIds']/option[contains(text(),'"+user+"')]")).click();
							}
						else
							{
								driver.findElement(By.xpath("//select[@name='users']/option[contains(text(),'"+user+"')]")).click();
							}
				Thread.sleep(5000);
				}
			}
			driver.findElement(By.id("generateReport")).click();
			driver.findElement(By.id("saveReportAs")).click();
			driver.findElement(By.id("reportName")).sendKeys(Generic.XLCellValue(XLPath, Sheet, k, 5));
			driver.findElement(By.id("saveReport")).click();
	}
	}

}
