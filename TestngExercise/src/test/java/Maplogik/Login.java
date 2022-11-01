package Maplogik;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePackage.BaseClass;



public class Login extends BaseClass{
	
	@FindBy(id="login-email")
	public static WebElement username;
	@FindBy(id="login-password")
	public static WebElement passsword;
	@FindBy(xpath="(//button[@class='btn btn-primary w-100 waves-effect waves-float waves-light'])")
	public static WebElement loginButton;
	
	public  static void AdminURL() throws IOException {
		String PathLocation="C:\\Users\\Visitor\\eclipse-workspace\\TestngExercise\\src\\test\\resources\\AdminUrl.txt";
		File read= new File(PathLocation);
		FileReader FileReader = new FileReader(read);
		BufferedReader BufRead= new BufferedReader(FileReader);
		String AdminURL=BufRead.readLine();
		BufRead.close();
		driver.get(AdminURL);
		driver.manage().window().maximize();
		}
	
	public static  void Credential() throws IOException {
		File excel= new File("C:\\Users\\Visitor\\eclipse-workspace\\TestngExercise\\src\\test\\resources\\LoginCredentiall.xlsx");
		excel.createNewFile();
		 FileInputStream fis= new FileInputStream(excel);
		 XSSFWorkbook book =new XSSFWorkbook(fis);
		 XSSFSheet sheet= book.getSheetAt(0);
		 String UserName= sheet.getRow(0).getCell(0).getStringCellValue();
		 String Password =sheet.getRow(1).getCell(0).getStringCellValue();
		 username.sendKeys(UserName);
		 passsword.sendKeys(Password);
		 loginButton.click();
			}	
}