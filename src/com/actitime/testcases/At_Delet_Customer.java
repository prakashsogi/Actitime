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
public class At_Delet_Customer extends SuperTestNG
{
	@Test(groups={"Delete"})
	public void testAt_Delet_Customer()
	{
		String XLPath="G:/VtigerWorkspace/ActiTime/excelfiles/ActiTime.xlsx";
		String Sheet="CustandProj";
		ProjSpecific.Login();
		//driver.findElement(By.xpath("//div[text()='Tasks']")).click();
		ProjSpecific.createCustomer();
			for(int i=0;i<=Generic.XLRow(XLPath, Sheet);i++)
				{
					String cust=Generic.XLCellValue(XLPath, Sheet, i, 0);
					try{
						List<WebElement> we = driver.findElements(By.xpath("//tr[td[table[tbody[tr[td[a[text()='"+cust+"']]]]]]]//input"));
						if(we.size()>0)
						{
							//driver.findElement(By.xpath("//tr[td[table[tbody[tr[td[a[text()='"+cust+"']]]]]]]//input")).click();
							for(int j=0;j<we.size();j++)
								{
									we.get(j).click();
								}
						}
						else
						{
							driver.findElement(By.xpath("//tr[td[table[tbody[tr[td[a[text()='"+cust+"']]]]]]]//input")).click();
						}
						driver.findElement(By.xpath("//input[@value='Delete Selected']")).click();
						driver.findElement(By.id("deleteButton")).click();
						}catch(Exception e)
						{
							System.out.println("specified "+cust+" is not present");
							continue;
				
						}
				}
		
	}

}
