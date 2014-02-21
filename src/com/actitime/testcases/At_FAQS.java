package com.actitime.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.actitime.libraries.ProjSpecific;
import com.actitime.libraries.SuperTestNG;

public class At_FAQS extends SuperTestNG
{
	@Test
	public void testAt_FAQS() throws InterruptedException
	{
		ProjSpecific.Login();
		//ProjSpecific.SupportMenu("About actiTIME");
		//Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()='Help & Support']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'About actiTIME')]")).click();
		System.out.println(driver.findElement(By.xpath("//tr[td[contains(text(),'Product Version')]]/td[2]")).getText());
		System.out.println("prakash");
		
	}

}
