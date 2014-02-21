package com.actitime.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.actitime.libraries.Generic;
import com.actitime.libraries.ProjSpecific;
import com.actitime.libraries.SuperTestNG;

public class At_Delete_Project extends SuperTestNG
{
	@Test(groups={"Delete"})
	public void testAt_Delete_Project() throws InterruptedException
	{
		String XLPath="G:/VtigerWorkspace/ActiTime/excelfiles/ActiTime.xlsx";
		String Sheet="CustandProj";
		String eMsg=" ";
		String aMsg=" ";
		ProjSpecific.Login();
		ProjSpecific.createCustomer();
			for(int i=0;i<=Generic.XLRow(XLPath, Sheet);i++)
			{
			eMsg=Generic.XLCellValue(XLPath, Sheet, i, 8);
			String proj=Generic.XLCellValue(XLPath, Sheet, i, 4);
			driver.findElement(By.xpath("//tr[td[table[tbody[tr[td[a[text()='"+proj+"']]]]]]]//td[6]/input")).click();
			driver.findElement(By.xpath("//input[@value='Delete Selected']")).click();
			driver.findElement(By.id("deleteButton")).click();
			aMsg=driver.findElement(By.className("successmsg")).getText();
			ProjSpecific.verifyMsg(eMsg, aMsg);
			}	
	}
}
