package module_niza_crm;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class PurchaseOrder {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\savan\\eclipse-workspace\\Ninza_CRM_automation\\src\\test\\resources\\commondata.properties");
		
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");
		
		//String BROSWER = "edge";
		
		WebDriver driver = null;
		
		if (BROWSER.equals("edge")) {
			driver = new EdgeDriver(); {
				
			}
		} else {
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(URL);
		
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		
		driver.findElement(By.cssSelector("button[type =submit]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("a[href=\"/purchase-order\"]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("button[class=\"btn btn-info\"]")).click();
		
		WebElement DueDate = driver.findElement(By.name("dueDate"));
		DueDate.sendKeys("14-08-2025");
		
		WebElement Sub =  driver.findElement(By.name("subject"));
		Sub.sendKeys("Test1");
		
		//Contact
		//driver.findElement(By.
		
		WebElement Billingaddress = driver.findElement(By.cssSelector("textarea[name=\"address\"]"));
		Billingaddress.sendKeys("A 11 Sector 78 Noida");
		
		WebElement Shippingaddress = driver.findElement(By.name("address"));
		Shippingaddress.sendKeys("A 111 Sector 78 Noida");
		
		WebElement POBox = driver.findElement(By.name("poBox"));
		POBox.sendKeys("abahhshjs");
		
		
		
		
		
		
		
		Thread.sleep(3000);
		driver.quit();
		
		
	}
	

}
