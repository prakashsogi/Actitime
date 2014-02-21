package com.actitime.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.actitime.libraries.Generic;
import com.actitime.libraries.ProjSpecific;
import com.actitime.libraries.SuperTestNG;

public class At_Delete_Task extends SuperTestNG
{
	@Test(groups={"Delete"})
	public void testAt_Delete_Task()
	{
		String XLPath="G:/VtigerWorkspace/ActiTime/excelfiles/ActiTime.xlsx";																																																																								
		String Sheet="CustandProj";
		ProjSpecific.Login();
		driver.findElement(By.xpath("//div[text()='Tasks']")).click();
		for(int i=0;i<=Generic.XLRow(XLPath, Sheet);i++)
		{
			List<WebElement> we = driver.findElements(By.xpath("//tr[td[a[text()='"+Generic.XLCellValue(XLPath, Sheet, i, 6)+"']]]//input[@type='checkbox']"));
			if(we.size()>1)
			{
				for(int j=0;j<we.size();j++)
				{
					//driver.findElement(By.xpath("//tr[td[a[text()='AirtelTask']]]//input[@type='checkbox']")).click();
					we.get(i).click();
				}
			}
			else
			{
				driver.findElement(By.xpath("//tr[td[a[text()='"+Generic.XLCellValue(XLPath, Sheet, i, 6)+"']]]//input[@type='checkbox']")).click();
				
			}
			driver.findElement(By.xpath("//input[@value='Delete Selected Tasks']")).click();
			driver.findElement(By.id("deleteButton")).click();
			
		}
		
	}

}
