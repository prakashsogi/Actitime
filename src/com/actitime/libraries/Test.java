package com.actitime.libraries;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		FirefoxDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get("http://demo.actitime.com/");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.xpath("//div[text()='Tasks']")).click();
		List<WebElement> we = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("size="+we.size());
		for(int i=0;i<we.size();i++)
		{
			we.get(i).click();
		}
		
		List<WebElement> w = driver.findElements(By.xpath("//table[@class='listTable']/tbody//tr"));
		//table[@class='listTable']/tbody/tr[3]/td[3]/a
		System.out.println("no of links="+w.size());
		for(int i=3;i<w.size();i++)
		{
			System.out.println(driver.findElement(By.xpath("//table[@class='listTable']/tbody/tr["+i+"]/td[3]/a")).getText());
		}

	}

}
