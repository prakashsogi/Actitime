package com.actitime.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.actitime.libraries.ProjSpecific;
import com.actitime.libraries.SuperTestNG;

public class At_WorkSchedule_Layout extends SuperTestNG
{
	@Test
	public void testAt_WorkSchedule_Layout() throws InterruptedException
	{
		String eMsg="Pass";
		String aMsg="Fail";
		ProjSpecific.Login();
		driver.findElement(By.xpath("//div[contains(text(),'Work Schedule')]")).click();
		
			for(int i=1;i<=4;i++)
			{
				driver.findElement(By.id("formatSelectorElm")).click();
				List<WebElement> we = driver.findElements(By.xpath("//table[@class='popupBody']//tr[1]/td["+i+"]/div/table//tr"));
				driver.findElement(By.xpath("//table[@class='popupBody']//tr[1]/td["+i+"]/div/table")).click();
				List<WebElement> months = driver.findElements(By.xpath("//div[@class='monthName']"));
				//System.out.println("Layout"+i+"has"+we.size());
				if(we.size()==months.size())
				{
					aMsg="Pass";
					//System.out.println(aMsg);
				}
				Thread.sleep(5000);
				
		}
			ProjSpecific.verifyMsg(eMsg, aMsg);
	}

	
}
