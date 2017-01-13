package testng111;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Webtable1111 {
WebDriver d;
@Test()
public void Setup1(){
	d.get("http://www.tsrtconline.in/oprs-web/");
	Assert.assertEquals("TSRTC Official Website for Online Bus Ticket Booking - tsrtconline.in",d.getTitle());
	d.findElement(By.xpath("//input[@id='txtJourneyDate']")).click();
	List<WebElement>tr_collectioon=d.findElements(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr"));
	System.out.println("no of rows"+tr_collectioon.size());
	List<WebElement>td_collectioon=d.findElements(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td"));
	System.out.println("no of columns"+td_collectioon.size());
	int rownum,colnum;
	rownum=1;
	for(WebElement tr:tr_collectioon){
		List<WebElement>td_collection1=tr.findElements(By.xpath("td"));
		System.out.println("no of columns:"+td_collection1.size());
		colnum=1;
		for(WebElement td:td_collection1){
			System.out.println("row1 # "+rownum+" col1 # "+colnum+",Test="+td.getText());
			colnum++;
			
		}
		rownum++;
	}
}
@BeforeMethod()
public void SetUp2(){
d=new FirefoxDriver();
d.manage().window().maximize();
d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
}

@AfterMethod()
public void SetUp3(){
d.close();;
}
}
