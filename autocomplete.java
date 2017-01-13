package testng111;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class autocomplete {
	WebDriver d;
@Test
public void SetUp1(){
	d.get("http://jqueryui.com/autocomplete/");
	Assert.assertEquals("Autocomplete | jQuery UI",d.getTitle());
	d.switchTo().frame(0);
	d.findElement(By.xpath("//input[@id='tags']")).sendKeys("a");
	List<WebElement>f=d.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
	System.out.println(f.size());
	for(WebElement e:f)
	{
		System.out.println(e.getText());
	}
	if(f.size()>=4)
	for(int i=0;i<5;i++)
	{
		d.findElement(By.xpath("//input[@id='tags']")).sendKeys(Keys.ARROW_DOWN);
	}
	d.findElement(By.xpath("//input[@id='tags']")).sendKeys(Keys.ENTER);
	
}
@Parameters("browser")
@BeforeMethod
public void SetUp2(String browser){
	if(browser.equals("FF")){
		d=new FirefoxDriver();
	}
	else if(browser.equals("GC"))
	{
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\lib\\chrome.driver");
	 d=new ChromeDriver();;
	}
	else if(browser.equals("IE"))
	{
		 System.setProperty("webdriver.ie.driver","F:\\Driver Server\\IEDriverServer.exe");
		 d=new InternetExplorerDriver();
	}
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
}
	@AfterMethod
	public void SetUp3(){
		d.close();
	}
}

