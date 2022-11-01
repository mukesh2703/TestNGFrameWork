package Maplogik;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;
   
public class studentLogin extends BaseClass {
	
	@FindBy(id="login-student-id")
	public static WebElement StudentID;
	@FindBy(id="login-mobile")
	public static WebElement MobileNumber;
	@FindBy(xpath="(//*[text()='Log in'])")
	public static WebElement LoginButton;
	@FindBy(id="otp_student_id")
	public static WebElement OTPnumber;
	@FindBy(id="test_otp")
	public static WebElement OTPNumb;
	@FindBy(id="login-otp")
	public static WebElement OTP;
	@FindBy(xpath="(//*[text()='Submit'])")
	public static WebElement submit;
	
	
	public  static void StudentURL() throws IOException  {
		String PathLocation="C:\\Users\\Visitor\\eclipse-workspace\\TestngExercise\\src\\test\\resources\\StudentURL.txt";
		File read= new File(PathLocation);
		FileReader file = new FileReader(read);
		BufferedReader BufRead= new BufferedReader(file);
		String StudentURL=BufRead.readLine();
		BufRead.close();
		driver.get(StudentURL);
		driver.manage().window().maximize();
		}

	  
	public static  void StudentCredential() throws IOException, ParseException {
		PageFactory.initElements(driver,studentLogin.class);
		File excel2= new File("C:\\Users\\Visitor\\eclipse-workspace\\TestngExercise\\src\\test\\resources\\LoginCredentiall.xlsx");
		excel2.createNewFile();
		 FileInputStream fis2= new FileInputStream(excel2);
		 XSSFWorkbook book2 =new XSSFWorkbook(fis2);
		 XSSFSheet sheet1= book2.getSheetAt(0);
		 XSSFRow row1= sheet1.getRow(2);
		 XSSFCell cell1= row1.getCell(0);
		 DataFormatter format= new DataFormatter();
		 String StudentIDNum=format.formatCellValue(cell1);
		 XSSFRow row2= sheet1.getRow(3);
		 XSSFCell cell2= row2.getCell(0);
		 String mobileNum=format.formatCellValue(cell2);
		 BaseClass.waitExplicit(driver, studentLogin.StudentID, 10);
		 studentLogin.StudentID.sendKeys(StudentIDNum);
		 BaseClass.waitExplicit(driver, studentLogin.MobileNumber, 10);
		 studentLogin.MobileNumber.sendKeys(mobileNum);
		 BaseClass.waitExplicit(driver, studentLogin.LoginButton, 10);
		 studentLogin.LoginButton.click();
		BaseClass.waitExplicit(driver, studentLogin.OTPNumb, 10);
		String OtpNum=studentLogin.OTPNumb.getText();
		System.out.println(OtpNum);
		BaseClass.waitExplicit(driver, studentLogin.OTP, 10);
		studentLogin.OTP.sendKeys(OtpNum);
		BaseClass.waitExplicit(driver, studentLogin.submit, 30);
//		studentLogin.submit.click();
		
		XSSFWorkbook book =new XSSFWorkbook();
		{
		
		
		XSSFSheet sheet = book.createSheet("OTP");
		XSSFRow row=sheet.createRow(0);
		XSSFCell cell=row.createCell(0);
		cell.setCellValue("Student Login OTP");
		XSSFRow row3=sheet.getRow(0);
		XSSFCell cell3=row3.createCell(1);
		cell3.setCellValue(OtpNum);
		DateFormat formatDate= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date systemDate= new Date();
		String date =formatDate.format(systemDate);
		XSSFRow row4=sheet.createRow(1);
		XSSFCell cell4=row4.createCell(0);
		cell4.setCellValue("Date and Time is");
		XSSFRow row5=sheet.getRow(1);
		XSSFCell cell5=row5.createCell(1);
		cell5.setCellValue(date);
		
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
	}
		FileOutputStream file = new FileOutputStream("C:\\Users\\Visitor\\eclipse-workspace\\TestngExercise\\src\\test\\resources\\OTP2.xlsx");
		book.write(file);
		book.close();
		
		studentLogin.submit.click();
	}
	
	

}
