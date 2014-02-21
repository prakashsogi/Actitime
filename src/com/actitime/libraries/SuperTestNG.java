package com.actitime.libraries;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SuperTestNG
{
	public static  WebDriver driver;
	@BeforeMethod(groups={"All"})
	public void preCondition()
	{
			String xlpath="G:/VtigerWorkspace/ActiTime/excelfiles/config.xlsx";
			String sheet="sheet1";
			String browser=Generic.XLCellValue(xlpath, sheet, 0, 1);
			String URL=Generic.XLCellValue(xlpath, sheet, 1, 1);
			FirefoxProfile prof=new FirefoxProfile();
			String key="browser.helperApps.neverAsk.saveToDisk";
			String value="text/csv";
			prof.setPreference(key, value);
			prof.setPreference("browser.download.folderList", 2);
			prof.setPreference("browser.download.dir", "g:\\Test");
			if(browser.equals("IE"))
			{
				System.setProperty("webdriver.ie.driver", "G:/VtigerWorkspace/ActiTime/exefiles/IEDriverServer.exe");
				driver=new InternetExplorerDriver();
				Reporter.log("opening IE browser",true);
			}
			else if(browser.equals("GC"))
			{
				System.setProperty("webdriver.chrome.driver", "G:/VtigerWorkspace/ActiTime/exefiles/chromedriver.exe");
				driver = new ChromeDriver();
				Reporter.log("opening Chorme Browser", true);
			}
			else
			{
				driver=new FirefoxDriver(prof);
				Reporter.log("opening FireFox Browser", true);
			}
		 	
			//EventFiringWebDriver d = new EventFiringWebDriver(driver);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
			driver.get(URL);
	}// end of Before method
	@AfterMethod(groups={"All"})
	public void postCondition()
	{
		driver.quit();
		Reporter.log("Closing the browser", true);
	}

}

