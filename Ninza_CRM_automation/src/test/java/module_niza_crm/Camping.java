package module_niza_crm;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Camping {
public static void main(String[] args) throws InterruptedException, IOException {
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
	
	//Login Page.
	driver.findElement(By.id("username")).sendKeys(USERNAME);
	
	driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
	
	Thread.sleep(3000);
	
	//Submit button
	driver.findElement(By.cssSelector("button[type =submit]")).click();
	Thread.sleep(3000);
	
	//After login.
	driver.findElement(By.linkText("Campaigns")).click();
	
//	driver.findElement(By.).click();
	
	Thread.sleep(3000);
	driver.quit();
}
}
