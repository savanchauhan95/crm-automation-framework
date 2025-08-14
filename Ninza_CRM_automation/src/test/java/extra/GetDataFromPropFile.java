package extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropFile {
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\savan\\eclipse-workspace\\Ninza_CRM_automation\\src\\test\\resources\\commondata.properties");
		
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String BROSWER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");
		
		System.out.println(BROSWER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
	}

}
