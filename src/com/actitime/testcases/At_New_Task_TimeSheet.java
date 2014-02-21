package com.actitime.testcases;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.actitime.libraries.Generic;
import com.actitime.libraries.ProjSpecific;
import com.actitime.libraries.SuperTestNG;

public class At_New_Task_TimeSheet extends SuperTestNG
{
	@Test
	public void testAt_New_Task_TimeSheet() throws InterruptedException
	{
		String XLPath="G:/VtigerWorkspace/ActiTime/excelfiles/ActiTime.xlsx";																																																																								
		String Sheet="task";
		ProjSpecific.Login();
		//String parent=" ";
		//String child=" ";
				for(int i=0;i<=Generic.XLRow(XLPath, Sheet);i++)
					{
						driver.findElement(By.xpath("//a[text()='Create new tasks']")).click();
						Set<String> wh = driver.getWindowHandles();
						Iterator<String> it = wh.iterator();
						String parent=it.next();
						String child=it.next();
						driver.switchTo().window(child);
						ProjSpecific.findListItem(driver.findElement(By.name("customerId")),"-- new customer --");
						driver.findElement(By.name("customerName")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 0));
						ProjSpecific.findListItem(driver.findElement(By.name("projectId")),"-- new project --");
						driver.findElement(By.name("projectName")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 1));
						driver.findElement(By.xpath("//input[contains(@name,'task[0].name')]")).sendKeys(Generic.XLCellValue(XLPath, Sheet, i, 2));
						driver.findElement(By.xpath("//tr[8]//tr[2]/td[2]//img")).click();
						String k=Generic.XLCellValue(XLPath, Sheet, i, 3).substring(1);
						//System.out.println("k="+k);
								if(!driver.findElement(By.xpath("//span[text()='"+k+"']")).isDisplayed())
								{
										List<WebElement> we = driver.findElements(By.xpath("//span[text()='"+k+"']"));
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
									driver.findElement(By.xpath("//span[text()='"+k+"']")).click();
								}
						ProjSpecific.findListItem(driver.findElement(By.xpath("//tr[8]//tr[2]/td[3]//select")),Generic.XLCellValue(XLPath, Sheet, i, 4));
						//driver.findElement(By.xpath("//span[text()='29']")).click();
						driver.findElement(By.xpath("//input[@value='Create Tasks']")).click();
						String eMsg=Generic.XLCellValue(XLPath, Sheet, i, 5);
						driver.switchTo().window(parent);
						//String aMsg=driver.findElement(By.xpath("//span[contains(text(),'Task was successfully added to the Enter Time-Track page.')]")).getText();
						String aMsg=driver.findElement(By.xpath("//table[@id='SuccessMessages']//tr[4]//span")).getText();
						//System.out.println(driver.findElement(By.xpath("//table[@id='SuccessMessages']//tr[3]//span")).getText());
						Thread.sleep(2000);
						System.out.println(aMsg);
						ProjSpecific.verifyMsg(eMsg, aMsg);
	}
	}

}
