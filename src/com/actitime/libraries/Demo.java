package com.actitime.libraries;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Demo extends SuperTestNG
{
	@Test
	public void test123() throws InterruptedException
	{
		String XLPath="G:/VtigerWorkspace/ActiTime/excelfiles/ActiTime.xlsx";																																																																								
		String Sheet="CustandProj";
		ProjSpecific.Login();
		driver.findElement(By.xpath("//div[text()='Tasks']")).click();
		driver.findElement(By.xpath("//input[@value='Create New Tasks']")).click();
		driver.findElement(By.xpath("//tr[8]//tr[2]/td[2]//img")).click();
		driver.findElement(By.xpath("//span[text()='29']")).click();
		ProjSpecific.findListItem(driver.findElement(By.xpath("//tr[8]//tr[2]/td[3]//select")),Generic.XLCellValue(XLPath, Sheet, 0, 7));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//tr[8]//tr[3]/td[2]//img")).click();
		//driver.findElement(By.xpath("//span[text()='23']")).click();
		List<WebElement> we = driver.findElements(By.xpath("//span[text()='23']"));
		System.out.println(we.size());
		we.get(1).click();
		Thread.sleep(2000);
		ProjSpecific.findListItem(driver.findElement(By.xpath("//tr[8]//tr[3]/td[3]//select")),Generic.XLCellValue(XLPath, Sheet, 1, 7));
		Thread.sleep(5000);
	}

}
