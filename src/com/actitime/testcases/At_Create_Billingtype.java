package com.actitime.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.actitime.libraries.Generic;
import com.actitime.libraries.ProjSpecific;
import com.actitime.libraries.SuperTestNG;
/*
 * Author-Prakash
 * Reviewer-Pradeep
 * Approver-Bhanu Prakash
 * LMD-22-01-2014
 */
public class At_Create_Billingtype extends SuperTestNG
{
	@Test(groups={"Create"})
	public void testAt_Create_Billingtype() throws InterruptedException
	{
			String XLPath="G:/VtigerWorkspace/ActiTime/excelfiles/ActiTime.xlsx";
			String Sheet="Billing";
			ProjSpecific.Login();
			driver.findElement(By.xpath("//div[contains(text(),'Settings')]")).click();
			driver.findElement(By.linkText("Billing Types")).click();
				for(int i=1;i<=Generic.XLRow(XLPath, Sheet);i++)
					{
						driver.findElement(By.name("addLeaveType")).click();
						driver.findElement(By.id("name")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 0));
						ProjSpecific.findListItem(driver.findElement(By.name("active")),Generic.XLCellValue(XLPath, Sheet, i, 1));
							if(Generic.XLCellValue(XLPath, Sheet, i, 2).equals("Billable"))
								{
									driver.findElement(By.xpath("//tr[td[table[tbody[tr[td[label[text()='"+Generic.XLCellValue(XLPath, Sheet, i, 2)+"']]]]]]]//input")).click();
								}
							else
								{
									driver.findElement(By.xpath("//tr[td[label[text()='"+Generic.XLCellValue(XLPath, Sheet, i, 2)+"']]]//input"));
								}
			
						driver.findElement(By.xpath("//td[@id='ButtonPane']/input[1]")).click();
						try
						
							{
								driver.findElement(By.xpath("//span[text()='Billing type has been successfully created.']")).isDisplayed();
								continue;
							}
						catch(Exception e)
						{
						Thread.sleep(500);
						try
							{
								driver.findElement(By.xpath("//span[text()='There are errors in the fields highlighted in red.']")).isEnabled();
								System.out.println("duplicate record");
								driver.findElement(By.xpath("//td[@id='ButtonPane']/input[2]")).isEnabled();
								((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//td[@id='ButtonPane']/input[2]")));
								Thread.sleep(1000);
								ProjSpecific.alertPopup();
							}
						catch(Exception e1)
							{
							continue;
							}
						}
			
					}
		
	}

}
