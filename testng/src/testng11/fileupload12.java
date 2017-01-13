package testng11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class fileupload12 {
public WebDriver driver;

@BeforeMethod
public void setUp() throws Exception
{
	driver= new FirefoxDriver();
	driver.manage().window().maximize();
}
@Test
public void testFileupload() throws Exception
{
	driver.get("https://www.freepdfconvert.com/");
	driver.findElement(By.id("clientUpload")).click();
	Thread.sleep(1000);
   new ProcessBuilder("D:\\selenium\\autoit\\fileUpload21.exe").start(); 
	Thread.sleep(3000);
	
}

@AfterMethod
public void tearDown() throws Exception {
driver.quit();
}
}

