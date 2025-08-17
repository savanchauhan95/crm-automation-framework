package extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDatafromExcelFile {
	
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
	FileInputStream fis = new FileInputStream(
			"C:\\Users\\savan\\git\\Ninzam_CRM\\Ninza_CRM_automation\\src\\test\\resources\\testdata.xlsx");
	
	Workbook wb =   WorkbookFactory.create(fis);
	
    String CampaignName =  wb.getSheet("Campaign").getRow(1).getCell(1).getStringCellValue();
	
}
}
