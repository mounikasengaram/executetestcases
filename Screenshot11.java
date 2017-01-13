package testng111;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Screenshot11 {
WebDriver d;
@Test()
	public void testAjax() throws Exception
	{
		Assert.assertEquals("Pass",getScreenshot());
		Thread.sleep(4000);
	}
		
		
	public String getScreenshot() throws Exception
	{
		try
		{
			d.get("http://www.seleniumhq.org/");
			d.findElement(By.linkText("Projects11")).click();
			return "pass";
		}
	catch(Exception e)
		{
			DateFormat dateformat=new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
			Date dt=new Date();
			File scrFile=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,new File("E:\\selenium\\testresults\\"+dateformat.format(dt)+".png"));
			return "fail";
		}
		
		
}
	

@BeforeMethod()
public void SetUp21(){
	d= new FirefoxDriver();
	d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	d.manage().window().maximize();
}
@AfterMethod()
public void SetUp45(){
	d.close();
}
}
