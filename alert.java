package testng111;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class alert {
	WebDriver d;
	@Test
	public void Setup() throws Exception{
		d.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		Assert.assertEquals("IRCTC Next Generation eTicketing System",d.getTitle());
		d.findElement(By.xpath("//input[@id='loginbutton']")).click();
	Alert al=d.switchTo().alert();
	al.accept();
	d.findElement(By.xpath("//input[@id='usernameId']")).sendKeys("mounika");
	d.findElement(By.xpath("//input[@id='loginbutton']")).click();
	al.accept();
	d.findElement(By.xpath("//input[@class='loginPassword']")).sendKeys("mounika");
	d.findElement(By.xpath("//input[@id='loginbutton']")).click();
	al.accept();
	
	
}
	@Parameters("browser")
	@BeforeMethod
	public void SetUp1(String browser) throws Exception{
			if(browser.equals("FF")){
				//d= new FirefoxDriver();
				d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.firefox());
			}
			else if(browser.equals("GC"))
			{
				System.setProperty("webdriver.chrome.driver","E:\\selenium\\lib\\chrome.driver");
				 d=new ChromeDriver();
			}
			else if(browser.equals("IE"))
			{
				System.setProperty("Webdriver.ie.driver","E:\\selenium\\lib.ie.driver");
				 d=new InternetExplorerDriver();
			}
	
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
		@AfterMethod
		public void SetUp2(){
			d.close();
		}
	}
