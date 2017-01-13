package testng111;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class actionslinkhome {
	WebDriver d;
public void SetUp12(){
	d.get("http://newtours.demoaut.com/");
	Assert.assertEquals("Welcome: Mercury Tours",d.getTitle());
	WebElement dd=d.findElement(By.linkText("Home"));
	Actions a=new Actions(d);
	Action store=a.moveToElement(dd).click(dd).build();
	store.perform();
	
	
	//WebElement dd1=d.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img"));
	 // String bgColor = dd1.getCssValue("background-color");
      //System.out.println("colour: " + bgColor);     
			//click(d.findElement(By.linkText("Home"))).build().perform();
	
}
@BeforeMethod
public void SetUp1() throws Exception{
	//d= new FirefoxDriver();
	d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.firefox());
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
}
	@AfterMethod
	public void SetUp2(){
		d.close();
	}
}
