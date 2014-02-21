package com.actitime.libraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class DragDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://127.0.0.1:8080/login.do");
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[@id='loginButton']"))).perform();
		act.contextClick(driver.findElement(By.xpath("//a[@id='loginButton']"))).perform();
		driver.findElement(By.xpath("//a[@id='loginButton']")).click();
		act.sendKeys("Q").perform();
		
		
		
		

	}

}
