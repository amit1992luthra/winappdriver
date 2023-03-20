package Banqsoft.bankwinapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class winappassertion {
	public static WindowsDriver driver = null;
	@BeforeClass
	public void setUp(){
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
		cap.setCapability("platformName", "Windows");
		cap.setCapability("deviceName", "WindowsPC");
		try {
			driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap) ;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
		
	@AfterSuite
	public void tearDown() throws InterruptedException{
		driver.quit();
		
	 	
	}
	
	@Test(priority=1)
	public void writeinNotepad(){
		driver.findElementByName("Text Editor").sendKeys("automation");
	}
	@Test(priority=2)
	public void editMenuAndSearch() throws InterruptedException{
		driver.findElementByName("Edit").click();
		 Thread.sleep(3000);
		driver.findElementByAccessibilityId("21").click();
		 Thread.sleep(3000);
		driver.findElementByAccessibilityId("1056").click();
		Thread.sleep(2000);
		driver.findElementByAccessibilityId("1152").sendKeys("auto");
	    Thread.sleep(2000);
	    driver.findElementByAccessibilityId("1").click();
	        
	 	}
}
