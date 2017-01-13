package testng11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class filedownloadddd11 {
	WebDriver d;
	@Test()
	public void Setup11() throws Exception{
		d.get("http://www.seleniumhq.org/download/");
		d.findElement(By.linkText("3.0.1")).click();
		Thread.sleep(3000);
		new ProcessBuilder("D:\\selenium\\autoit\\filedownload12.exe").start();
		Thread.sleep(8000);
	
	}
	@BeforeMethod
	public void init()
	{
		d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(3,TimeUnit.MINUTES);
	}
	@AfterMethod
	public void stop()
	{
		//d.quit();
	}}
