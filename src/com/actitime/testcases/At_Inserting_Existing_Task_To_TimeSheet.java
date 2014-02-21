package com.actitime.testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.actitime.libraries.ProjSpecific;
import com.actitime.libraries.SuperTestNG;

public class At_Inserting_Existing_Task_To_TimeSheet extends SuperTestNG 
{
@Test
public void testAt_Inserting_Existing_Task_To_TimeSheet() throws InterruptedException
{
		String NoTasks=" ";
		ProjSpecific.Login();
		driver.findElement(By.xpath("//a[contains(text(),'Insert existing tasks')]")).click();
		Set<String> hnd = driver.getWindowHandles();
		Iterator<String> It=hnd.iterator();
		String parent=It.next();
		String child=It.next();
		driver.switchTo().window(child);
	try{
			//if there are no tasks to insert into time sheet
			NoTasks=driver.findElement(By.xpath("//td[contains(text(),'There are no open tasks to add.')]")).getText();
			System.out.println(NoTasks);
		}catch(Exception e)
		{
			String Tasks=driver.findElement(By.xpath("//td[contains(text(),'Results contain')]")).getText().substring(16, 17);
			//System.out.println(Integer.parseInt(Tasks.substring(16, 17)));
			for(int i=1;i<=Integer.parseInt(Tasks);i++)
				{
					driver.findElement(By.xpath("//table[@id='tasks-table']//tr["+(i+1)+"]/td[4]/input")).click();
					//Thread.sleep(5000);
					//driver.findElement(By.xpath("//input[@type='button']")).click();
				}
			driver.findElement(By.xpath("//input[contains(@value,'Insert Selected Tasks to the Enter Time-Track Page')]")).click();
		}
}
}
