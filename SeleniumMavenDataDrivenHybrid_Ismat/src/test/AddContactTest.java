package test;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.AddContactPage;
import page.Techfios_login;
import reader.ReadData;
import util.BrowserFactory;

public class AddContactTest {
ReadData readExcelData = new ReadData();
	
	String username;
	String password;
	
	String fullname;
	String companyname;
	String email1;
	String phone;
	String address;
	String cityname;
	String statename;
	String zip;
	
	public AddContactTest() throws IOException{
		
		String userdata[][]= readExcelData.getLogInDataFromExcelFile();	
		for(int j=1; j<userdata.length;j++)
		{
			username = userdata[j][0];
			password = userdata[j][1];
			
			fullname = userdata[j][9];
			companyname = userdata[j][10];
			email1 = userdata[j][11];
			phone = userdata[j][12];
			address = userdata[j][13];
			cityname = userdata[j][14];
			statename = userdata[j][15];
			zip = userdata[j][16];
	    }		
	}
		
	@Test
	public void AddContactTest() throws IOException, InterruptedException{
		
		WebDriver driver = BrowserFactory.startBrowser("chrome", "http://techfios.com/test/billing/?ng=login/\r\n");
		
		Techfios_login login = PageFactory.initElements(driver, Techfios_login.class);
		login.login_techfios(username, password);
		System.out.println ("login Sucessfully");
		
		AddContactPage AddContact=PageFactory.initElements(driver, AddContactPage.class);
		AddContact.AddContact_demo(fullname, companyname, email1,
		                           phone, address, cityname, statename, zip);
		
		System.out.println ("A New contact added");
		

		driver.close();

		driver.quit();
					
			
		}
		
}
