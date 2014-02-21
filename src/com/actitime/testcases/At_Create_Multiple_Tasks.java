package com.actitime.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.actitime.libraries.Generic;
import com.actitime.libraries.ProjSpecific;
import com.actitime.libraries.SuperTestNG;
/*
 * Author- Prakash
 * Reviewer-Pradeep
 * Approver-BhanuPrakash
 * LMD-22-01-2014
 */
public class At_Create_Multiple_Tasks extends SuperTestNG
{
	@Test
	public void testAt_Create_Multiple_Tasks()
	{
		String XLPath="G:/VtigerWorkspace/ActiTime/excelfiles/ActiTime.xlsx";																																																																								
		String Sheet="multitask";
		ProjSpecific.Login();
		ProjSpecific.createTask();
		for(int i=1;i<=Generic.XLRow(XLPath, Sheet);i++)
		{
			String cust=Generic.XLCellValue(XLPath, Sheet, i, 0);
			int NewTask=i;
			int taskName=0;
			int taskRow=i;
			ProjSpecific.findListItem(driver.findElement(By.name("customerId")),Generic.XLCellValue(XLPath, Sheet, i, 0));
			ProjSpecific.findListItem(driver.findElement(By.name("projectId")), Generic.XLCellValue(XLPath, Sheet, i, 1));
			for(int k=2;k<Generic.XLRow(XLPath, Sheet);k++)
			{
				driver.findElement(By.xpath("//input[contains(@name,'task["+taskName+"].name')]")).sendKeys(Generic.XLCellValue(XLPath, Sheet, NewTask, 2));
				driver.findElement(By.xpath("//tr[8]//tr["+k+"]/td[2]//img")).click();
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
				ProjSpecific.findListItem(driver.findElement(By.xpath("//tr[8]//tr["+k+"]/td[3]//select")),Generic.XLCellValue(XLPath, Sheet, NewTask, 4));
				//Thread.sleep(2000);
				driver.findElement(By.xpath("//tr[8]//tr["+k+"]/td[4]//input")).click();
				if(Generic.XLCellValue(XLPath, Sheet, NewTask, 5).equals("yes"))
					{
						k=2;
						taskName=0;
						i=taskRow;
						break;
					}
				taskName++;
				taskRow++;
				NewTask++;
			}
				driver.findElement(By.xpath("//input[@value='Create Tasks']")).click();
				driver.findElement(By.xpath("//input[@value='Create New Tasks']")).click();
			
		}
		
	}

}
