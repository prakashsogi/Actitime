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

public class At_Create_User extends SuperTestNG
{
	@Test(groups={"Create"})
	public void testAt_Create_User()
	{
		String XLPath="G:/VtigerWorkspace/ActiTime/excelfiles/ActiTime.xlsx";
		String Sheet="users";
		ProjSpecific.Login();
		ProjSpecific.createUser();
			for(int i=0;i<=Generic.XLRow(XLPath, Sheet);i++)
			{
				//driver.findElement(By.xpath("//span[text()='Create New User']")).click();
				driver.findElement(By.xpath("//input[@value='Create New User']")).click();
				driver.findElement(By.name("username")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 0));
				driver.findElement(By.name("passwordText")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 1));
				driver.findElement(By.name("passwordTextRetype")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 2));
				ProjSpecific.findListItem(driver.findElement(By.name("active")), Generic.XLCellValue(XLPath, Sheet, i, 3));
				driver.findElement(By.name("firstName")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 4));
				driver.findElement(By.name("lastName")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 5));
				driver.findElement(By.name("email")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 6));
				driver.findElement(By.name("workdayDurationStr")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 7));
				driver.findElement(By.xpath("//input[@id='overtimeTracking_Enable']")).click();
					if(Generic.XLCellValue(XLPath, Sheet, i, 8).equals("y"))
						{
							driver.findElement(By.xpath("//tr[td[label[contains(text(),' Generate Reports')]]]//td[1]/input")).click();
						}
					if(Generic.XLCellValue(XLPath, Sheet, i, 9).equals("y"))
						{
							driver.findElement(By.xpath("//tr[td[label[contains(text(),'Manage Work')]]]//td[1]/input")).click();
						}
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				//checking the existence of user
					try{
						if(driver.findElement(By.xpath("//span[text()='User \""+Generic.XLCellValue(XLPath, Sheet, i, 0)+"\" is already registered. Please choose other username.']")).isDisplayed())
							{
								System.out.println("User"+Generic.XLCellValue(XLPath, Sheet, i, 0)+"already exists");
								//driver.findElement(By.xpath("//input[contains(@value,'Cancel')]")).click();
								driver.findElement(By.xpath("//td[@class='formbuttonpane']/input[2]")).click();
								ProjSpecific.alertPopup();
								continue;
						}
					}catch(Exception e)
					{
						continue;
					}
				String aMsg=driver.findElement(By.className("successmsg")).getText();
				//System.out.println(aMsg);
				ProjSpecific.verifyMsg(Generic.XLCellValue(XLPath, Sheet, i, 10), aMsg);
			}
			ProjSpecific.LogOut();
		
	}

}
