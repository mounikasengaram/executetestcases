package testng11;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class Mouseover {
	WebDriver d;
	public void testmouseover() throws Exception
	{
		d.get("https://www.geico.com/");
		Assert.assertEquals("An insurance company for your car, motorcycle and more | GEICO",d.getTitle());
		Actions a = new Actions(d);
		WebElement ele = d.findElement(By.xpath("//a[text()='Products']"));
		a.moveToElement(ele).perform();
		Thread.sleep(3000);
	}
@BeforeMethod
public void SetUp()
{
	d = new FirefoxDriver();
	d.manage().window().maximize();
}
@AfterMethod
public void TearDown()
{
	d.quit();
}
}
