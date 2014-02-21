package com.actitime.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.actitime.libraries.Generic;
import com.actitime.libraries.ProjSpecific;
import com.actitime.libraries.SuperTestNG;
/*
 * Author-Prakash S
 * Reviewer-Pradeep
 * Approver-Bhanu Prakash
 * LMD-20-01-2014
 */
public class At_Create_Project extends SuperTestNG
{
	@Test(groups={"Create"})
	public void testAt_Create_Project()
	{
		String XLPath="G:/VtigerWorkspace/ActiTime/excelfiles/ActiTime.xlsx";
		String Sheet="CustandProj";
		ProjSpecific.Login();
		ProjSpecific.createCustomer();
	{
		for(int i=0;i<=Generic.XLRow(XLPath, Sheet);i++)
		{
			try{
				
			driver.findElement(By.xpath("//input[@value='Create New Project']")).click();
			ProjSpecific.findListItem(driver.findElement(By.name("customerId")), Generic.XLCellValue(XLPath, Sheet, i, 0));
			driver.findElement(By.name("name")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 4));
			driver.findElement(By.name("createProjectSubmit")).click();
				if(driver.findElement(By.xpath("//span[contains(text(),'roject \""+Generic.XLCellValue(XLPath, Sheet, i, 4)+"\" already exists')]")).isDisplayed())
					{
						System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Project \""+Generic.XLCellValue(XLPath, Sheet, i, 4)+"\" already exists')]")).getText());
						//driver.findElement(By.xpath("//input[contains(@value,'Cancel')]")).click();
						driver.findElement(By.xpath("//td[@id='ButtonPane']/input[2]")).click();
						ProjSpecific.alertPopup();
						continue;
					}
			String aMsg = driver.findElement(By.xpath("//span[@class='successmsg']")).getText();
			ProjSpecific.verifyMsg(Generic.XLCellValue(XLPath, Sheet, i, 5), aMsg);
			}catch(Exception e)
			{
				System.out.println("projcet does not exists and created");
				continue;
			}
		}
	}
		ProjSpecific.LogOut();
		
	}

}
