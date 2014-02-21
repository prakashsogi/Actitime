package com.actitime.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.actitime.libraries.Generic;
import com.actitime.libraries.ProjSpecific;
import com.actitime.libraries.SuperTestNG;
/* Author- Prakash
 * Reviewer- Bhanu Prakash
 * Approver-Bhanu Prakash
 * LMD-18-01-2014
 */

public class At_Delete_User extends SuperTestNG
{
	@Test(groups={"Delete"})
	public void testAt_Delete_User()
	{
		String XLPath="G:/VtigerWorkspace/ActiTime/excelfiles/ActiTime.xlsx";
		String Sheet="users";
		ProjSpecific.Login();
		ProjSpecific.createUser();
			for(int i=0;i<=Generic.XLRow(XLPath, Sheet);i++)
			{
				try
				{
				driver.findElement(By.xpath("//a[contains(text(),'"+Generic.XLCellValue(XLPath, Sheet, i, 5)+"')]")).click();
				if(driver.findElement(By.xpath("//input[@value='Delete This User']")).isEnabled())
				{
				driver.findElement(By.xpath("//input[@value='Delete This User']")).click();
				ProjSpecific.alertPopup();
				String aMsg = driver.findElement(By.className("successmsg")).getText();
				System.out.println(aMsg);
				ProjSpecific.verifyMsg(Generic.XLCellValue(XLPath, Sheet, i, 11), aMsg);
				}
				else
				{
					String msg=driver.findElement(By.xpath("//nobr[contains(text(), 'There is time-track reported by this user. This user cannot be deleted')]")).getText();
					System.out.println(msg+Generic.XLCellValue(XLPath, Sheet, i, 5));
				}
				}catch(Exception e)
				{
					System.out.println("No such "+Generic.XLCellValue(XLPath, Sheet, i, 5)+" user is present");
					continue;
				}
			
			}
		ProjSpecific.LogOut();
	}
}
