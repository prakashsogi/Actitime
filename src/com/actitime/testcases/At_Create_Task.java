package com.actitime.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
public class At_Create_Task extends SuperTestNG
{
	@Test(groups={"Create"})
	public void testAt_Create_Task() throws InterruptedException
	{
		String XLPath="G:/VtigerWorkspace/ActiTime/excelfiles/ActiTime.xlsx";																																																																								
		String Sheet="CustandProj";
		ProjSpecific.Login();
		ProjSpecific.createTask();
		Thread.sleep(2000);
			for(int i=0;i<=Generic.XLRow(XLPath, Sheet);i++)
			{
				
				ProjSpecific.findListItem(driver.findElement(By.name("customerId")),Generic.XLCellValue(XLPath, Sheet, i, 0));
				ProjSpecific.findListItem(driver.findElement(By.name("projectId")), Generic.XLCellValue(XLPath, Sheet, i, 4));
				driver.findElement(By.xpath("//input[contains(@name,'task[0].name')]")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 6));
				driver.findElement(By.xpath("//tr[8]//tr[2]/td[2]//img")).click();
				if(!driver.findElement(By.xpath("//span[text()='29']")).isDisplayed())
				{
					List<WebElement> we = driver.findElements(By.xpath("//span[text()='29']"));
					for(int j=0;j<we.size();j++)
					{
						if(!we.get(j).isDisplayed())
						{
							continue;
						}
						we.get(j).click();
					}
					
				}
				else
				{
					driver.findElement(By.xpath("//span[text()='29']")).click();
				}
				ProjSpecific.findListItem(driver.findElement(By.xpath("//tr[8]//tr[2]/td[3]//select")),Generic.XLCellValue(XLPath, Sheet, i, 7));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//tr[8]//tr[2]/td[4]//input")).click();
				driver.findElement(By.xpath("//input[@value='Create Tasks']")).click();
				driver.findElement(By.xpath("//input[@value='Create New Tasks']")).click();
				
			}
	}

}
