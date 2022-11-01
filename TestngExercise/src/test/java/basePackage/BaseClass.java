package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	public static WebDriver driver;
	public static Properties property;
	public static FileInputStream fis;
	public static XSSFWorkbook book;
	static ExtentSparkReporter spark;
	static ExtentReports extent;

	@BeforeClass
	public static WebDriver Browser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\New folder\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		return driver;
	}

    @AfterClass
	public static void  quitBrowsr() {
		driver.quit();
	}
		
	public static WebDriverWait waitExplicit(WebDriver driver, WebElement webElement, int seconds) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		return wait;
	}

	public static JavascriptExecutor scroll (WebDriver driver){
		JavascriptExecutor scroll = (JavascriptExecutor)driver;
		scroll.executeScript("window.scrollBy(0,2000)", "");
		return scroll;
	}
	public static JavascriptExecutor click(WebDriver driver,WebElement webElement ) {
		JavascriptExecutor EleClick = (JavascriptExecutor) driver;
		EleClick.executeScript("arguments[0].click();", webElement);
		return EleClick;

	}
	public static  void assertion( String expected,String actual){
		Assert.assertEquals(expected,actual);
	}
	
	
	public static FileInputStream Excel(File inputfile) throws FileNotFoundException {
		return fis = new FileInputStream(inputfile);
	}


	public static String ExcelOpen(int sheetnumber,int rownumber,int cellnumber) throws IOException {
		book =new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheetAt(sheetnumber);
		//wbk = new XSSFWorkbook();
		XSSFRow row =sheet.getRow(rownumber);
		XSSFCell cell =row.getCell(cellnumber);
		String Value =cell.getStringCellValue();
		return Value;
	}

	public static Properties property(String FileLocation) throws IOException {
		// TODO Auto-generated method stub
		Properties property = new Properties();
		String file=FileLocation;
		FileInputStream fis= new FileInputStream(file);
		property.load(fis);
		return property;
	}

	public String value(String input) {

		return property.getProperty(input);
	}



}
