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
public class At_Create_Customer extends SuperTestNG
{
	String XLPath="G:/VtigerWorkspace/ActiTime/excelfiles/ActiTime.xlsx";
	String Sheet="CustandProj";
	@Test(groups={"Create"})
	public void testAt_Create_Customer() throws InterruptedException
	{
		ProjSpecific.Login();
		ProjSpecific.createCustomer();
		Thread.sleep(5000);
			for(int i=0;i<=Generic.XLRow(XLPath, Sheet);i++)
				{
				driver.findElement(By.xpath("//input[@value='Create New Customer']")).click();
				driver.findElement(By.name("name")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 0));
				driver.findElement(By.name("description")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 1));
				driver.findElement(By.name("createCustomerSubmit")).click();
					try{// while creating new customer it will search for this text but it is not there
							if(driver.findElement(By.xpath("//span[text()='Customer \""+Generic.XLCellValue(XLPath, Sheet, i, 0)+"\" already exists. Please choose other customer name.']")).isDisplayed())
								{
									System.out.println("customer "+Generic.XLCellValue(XLPath, Sheet, i, 0)+"is already present");
									driver.findElement(By.xpath("//td[@class='formbuttonpane']/input[2]")).click();
									ProjSpecific.alertPopup();
									continue;
								}
					}catch(Exception e)
						{
						continue;
						}
				String aMsg=driver.findElement(By.xpath("//span[@class='successmsg']")).getText();
				System.out.println(aMsg);
				ProjSpecific.verifyMsg(Generic.XLCellValue(XLPath, Sheet, i, 3), aMsg);
				
				}
			ProjSpecific.LogOut();
	}
	

}
