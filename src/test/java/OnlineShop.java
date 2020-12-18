import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Set;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class OnlineShop {
	public WebDriver driver;
 
  @BeforeClass
  
	  public void launch() {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Navin Vishal M\\Downloads\\Abara's\\eclipse\\configuration\\DataProvider\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
  }	
  
  @Test(dataProvider="products")
  public  void DataProvider(String name1,String link) throws InterruptedException {
	  driver.get("https://www.amazon.in/");
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys(name1);
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(link)).click();
	String pt=  driver.getWindowHandle();
	Set<String> cd=driver.getWindowHandles();
	for (String each : cd) {
		if (!pt.equals(each)) {
			driver.switchTo().window(each);
			
		}
		
	}
	driver.findElement(By.id("add-to-cart-button")).click();
	  
  }

 @org.testng.annotations.DataProvider(name="products")
 private Object[][] tc1() {
	 return new Object[][] {
			 {"washing machine","//span[@class='a-size-medium a-color-base a-text-normal'][1]"},
			 {"refridgerator","//span[@class='a-size-medium a-color-base a-text-normal'][1]"},
			 
			 {"iphone 12","//span[@class='a-size-medium a-color-base a-text-normal'][1]",},
			 {"dell laptop","//span[@class='a-size-medium a-color-base a-text-normal'][1]"}
			 
	 };
	

}
 
@AfterClass
public void ovr() {
	driver.quit();

}
}



	



	












