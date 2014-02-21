package com.actitime.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.actitime.libraries.ProjSpecific;
import com.actitime.libraries.SuperTestNG;

public class At_Listing_EnabledUser extends SuperTestNG
{

	@Test
	public void testAt_Listing_EnabledUser()
	{
		ProjSpecific.Login();
		ProjSpecific.createUser();
		//driver.findElement(By.id("showDisabled")).click();
		List<WebElement> we = driver.findElements(By.xpath("//table[@class='userListTable']//tr"));
		System.out.println(we.size());
		String eMsg="Pass";
		String aMsg="Fail";
		for(int i=3;i<we.size()+1-2;i++)
		{
			
			//System.out.println(driver.findElement(By.xpath("//table[@class='userListTable']//tr["+i+"]/td[2]")).getText());
			String dis=driver.findElement(By.xpath("//table[@class='userListTable']//tr["+i+"]/td[2]")).getText();
			if(driver.findElement(By.id("showDisabled")).isSelected())
			{
				if(dis.equals("enabled") || dis.equals("disabled") )
				{
				 aMsg="Pass";
				 System.out.println("when checkBOX is checked");
				}
			}
			else
			{
				if(dis.equals("enabled"))
				{
					aMsg="Pass";
					System.out.println("when checkBOX is unchecked");
				}
			}
			ProjSpecific.verifyMsg(eMsg, aMsg);
		}
		
		
	}
}
