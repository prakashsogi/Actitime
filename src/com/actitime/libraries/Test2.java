package com.actitime.libraries;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test2 {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		FirefoxDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get("https://demo.vtiger.com/");
		driver.findElement(By.xpath("//button")).click();
		Thread.sleep(5000);
		List<WebElement> we = driver.findElements(By.id("menubar_item_Leads"));
		System.out.println(we.size());
		for(int i=0;i<we.size();i++)
		{
			if (we.get(i).isDisplayed())
				//we.get(i).click();
			{
				((JavascriptExecutor)driver).executeScript("arguments[0].click;",we.get(i));
				System.out.println("vlicked");
			}
		}
		
		;
		driver.findElement(By.xpath("//strong[text()='Add Lead']")).click();
	}

}
