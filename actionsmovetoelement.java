package testng111;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class actionsmovetoelement {
WebDriver d;
public void SetUp1(){
	d.get("http://www.tsrtconline.in/oprs-web/");
	Actions a=new Actions(d);
	WebElement ff=d.findElement(By.linkText("eTicket Login"));
	a.moveToElement(ff);
	WebElement gg=d.findElement(By.linkText("ATB/OPR Login"));
	a.moveToElement(gg);
	a.click().build().perform();
	
}
@BeforeMethod()
public void SetUo11(){

	d=new FirefoxDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
}
@AfterMethod()
public void Setup333(){
	d.close();
}
}
