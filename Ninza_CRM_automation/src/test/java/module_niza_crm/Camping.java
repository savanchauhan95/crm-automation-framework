package module_niza_crm;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Camping {
public static void main(String[] args) throws InterruptedException, IOException {
	
	// Data from Properties file.
	FileInputStream fis1 = new FileInputStream(
			"C:\\Users\\savan\\eclipse-workspace\\Ninza_CRM_automation\\src\\test\\resources\\commondata.properties");
	
	Properties pObj = new Properties();
	pObj.load(fis1);
	
	String BROWSER = pObj.getProperty("bro");
	String URL = pObj.getProperty("url");
	String USERNAME = pObj.getProperty("un");
	String PASSWORD = pObj.getProperty("pwd");
	
	//Data from Excel file.
	FileInputStream fis2 = new FileInputStream(
			"C:\\Users\\savan\\git\\Ninzam_CRM\\Ninza_CRM_automation\\src\\test\\resources\\testdata.xlsx");
	
	Workbook wb =   WorkbookFactory.create(fis2);
	
    String CampaignName =  wb.getSheet("Campaign").getRow(1).getCell(1).getStringCellValue();
	
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
	
    driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
    
    WebElement expclsdate = driver.findElement(By.name("expectedCloseDate"));
    expclsdate.sendKeys("");
    
    WebElement campingName = driver.findElement(By.name("campaignName"));
    campingName.sendKeys(CampaignName);
    
    Thread.sleep(4000);
    
    WebElement tgtsize = driver.findElement(By.name("targetSize"));
    tgtsize.sendKeys("15");
    
    driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
    
	
	Thread.sleep(3000);
	driver.quit();
}
}
