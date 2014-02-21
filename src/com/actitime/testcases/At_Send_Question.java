package com.actitime.testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.actitime.libraries.ProjSpecific;
import com.actitime.libraries.SuperTestNG;

public class At_Send_Question extends SuperTestNG
{
	@Test(groups={"Others"})
	public void testAt_Send_Question() throws InterruptedException
	{
		ProjSpecific.Login();
		//driver.findElement(By.xpath("//span[text()='Help & Support']")).click();
		//driver.findElement(By.xpath("//div[contains(text(),'Send a Question to Vendor')]")).click();
		ProjSpecific.SupportMenu("Send a Question to Vendor");
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> it=wh.iterator();
		String parent=it.next();
		String child=it.next();
		driver.switchTo().window(child);
		driver.findElement(By.id("question")).sendKeys("abc");
		driver.findElement(By.id("companyName")).sendKeys("ABC Company");
		driver.close();
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//div[text()='Tasks']")).click();
		driver.findElement(By.linkText("Projects & Customers")).click();
		Thread.sleep(5000);
	}

}
