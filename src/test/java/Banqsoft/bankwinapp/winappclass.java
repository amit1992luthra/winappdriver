package Banqsoft.bankwinapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class winappclass {
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
	
	@Test
	public void testapplication(){
		driver.findElementByName("Help").click();
		driver.findElementByName("About Notepad").click();
		String test = driver.findElementByAccessibilityId("13587").getText();
		System.out.println("Actual Result" + test );
		driver.findElementByName("OK").click();
	}
	
	
}
