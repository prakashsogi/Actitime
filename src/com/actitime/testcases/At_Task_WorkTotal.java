package com.actitime.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.actitime.libraries.Generic;
import com.actitime.libraries.ProjSpecific;
import com.actitime.libraries.SuperTestNG;

public class At_Task_WorkTotal extends SuperTestNG
{
	@Test
	
	public void testAt_Task_WorkTotal() throws InterruptedException, IOException
	{
		String XLPath="G:/VtigerWorkspace/ActiTime/excelfiles/ActiTime.xlsx";
		String Sheet="WorkTotal";
		String	xpath,task,s1="";
		ProjSpecific.Login();
		//JavascriptExecutor js=
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)", "");
		for(int i=1;i<=Generic.XLRow(XLPath, Sheet);i++)
		{
			int cell=6;
			for(int j=1;j<Generic.XLColumn(XLPath, Sheet, i);j++)
				{
					task=Generic.XLCellValue(XLPath, Sheet, i, 0);
					try{
						xpath="//tr[td[table[tbody[tr[td[a[contains(text(),'"+task+"')]]]]]]]//td["+cell+"]/table/tbody/tr/td[1]/input";
						s1=s1+Generic.XLIntCellValue(XLPath, Sheet, i, j);
						driver.findElement(By.xpath(xpath)).sendKeys(s1);
						cell++;
						s1="";
						}
					catch(Exception e)
					{
						cell++;
						s1="";
						continue;
					}
				}
		}
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("G:\\task_wokTime2.png"));
		
		
		
	}

}
