package com.actitime.libraries;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo7 
{
public static void main(String[] args) throws InterruptedException
{
	WebDriver driver = new FirefoxDriver();
	driver.get("http://127.0.0.1:8080/login.do");
	//((JavascriptExecutor) driver).executeScript("alert(Date());");
	//((JavascriptExecutor) driver).executeScript("document.write(Date());");
	
	//FirefoxDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	//driver.get("http://demo.actitime.com/");
	driver.findElement(By.name("username")).sendKeys("admin");
	driver.findElement(By.name("pwd")).sendKeys("manager");
	driver.findElement(By.id("loginButton")).click();
	driver.findElement(By.xpath("//div[text()='Tasks']")).click();
	
	//tr[td[label[span[text()='project aba']]]]
	String project="projectgdg";
	/*driver.findElement(By.id("cpSelector.cpButton.contentsContainer")).click();
	driver.findElement(By.xpath("//tr[td[label[span[text()='"+project+"']]]]//input")).click();
	driver.findElement(By.id("closeButton")).click();
	driver.findElement(By.name("searchTasks")).click();*/
	ProjSpecific.searchTask(driver.findElement(By.id("cpSelector.cpButton.contentsContainer")),project);
	Thread.sleep(5000);
	
	}
	}

