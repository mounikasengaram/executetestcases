package testng111;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class amazonlinks {
	WebDriver d;
	@Test()
	public void SetUp(){
	d.get("http://www.amazon.in");
	List<WebElement>f=d.findElements(By.cssSelector("body"));
	System.out.print(f.size());
	String store[]=new String[f.size()];
	int i=0;
	for(WebElement g:f)
	{
		System.out.println("no of links:"+g.getText());
		store[i]=g.getText();
	}
	int j=0;
	for(j=0;j<=f.size();j++){
		d.findElement(By.linkText(store[j])).click();
	}
}
@BeforeMethod()
public void SetUp1(){
	d=new FirefoxDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
}

@AfterMethod()
public void SetUp2(){
	d.close();
}



}
