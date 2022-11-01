package Maplogik;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;


public class collegeDetails extends BaseClass {
	
	public static Properties property;
	
	@FindBy(xpath="(//section[@id='basic-horizontal-layouts'])//div[@class='col-sm-9']/input")
	public static WebElement Name;
	@FindBy(xpath="//input[@id='logo']")
	public static WebElement Logo;
	@FindBy(xpath="(//section[@id='basic-horizontal-layouts'])//div[@class='col-sm-9']/input[@id='address']")
	public static WebElement Address;
	@FindBy(xpath="(//section[@id='basic-horizontal-layouts'])//div[@class='col-12']//div[@class='col-sm-9']/select[@name='location']")
	public static WebElement District;
	@FindBy(xpath="(//section[@id='basic-horizontal-layouts'])//div[@class='col-12']//div[@class='col-sm-9']/select[@name='affliation']")
	public static WebElement Affliation;
	@FindBy(xpath="(//section[@id='basic-horizontal-layouts'])//div[@class='col-12']//div[@class='col-sm-9']/select[@name='affliated_to']")
	public static WebElement Affliated_to;
	@FindBy (xpath="(//section[@id='basic-horizontal-layouts'])//div[@class='col-12']//div[@class='col-sm-9']/select[@name='college_type']")
	public static WebElement TypeOfCollege;
	
	@FindBy(xpath="(//div[@class='btn-group buttons']/button)[1]")
	public static WebElement CoarsesOffered;
	@FindBy(id="cnt_name")
	public static WebElement ContactPerson;
	@FindBy(id="cnt_number")
	public static WebElement ContactNum;
	@FindBy(id="cnt_email")
	public static WebElement ContactMail;
	@FindBy(id="cnt_name_plc")
	public static WebElement ContactPlacement;
	@FindBy(id="cnt_number_plc")
	public static WebElement ContactPlacNum;
	@FindBy(id="course_email_plc")
	public static WebElement ContactPlacMail;
	
	public static Properties property() throws IOException
	{
		 property = new Properties();
		 FileInputStream fis= new FileInputStream("C:\\Users\\Visitor\\git\\SeleniumWrite\\SeleniumFlip\\config\\config.properties\\prop");
		 property.load(fis);
		return property;
		
	}
	public static void AddDetails() throws IOException {
		PageFactory.initElements(driver, CollegeActivation.class);
		CollegeActivation.Activation.click();
		CollegeActivation.AddNew.click();
		 property = new Properties();
		 fis= new FileInputStream("C:\\Users\\Visitor\\eclipse-workspace\\TestngExercise\\src\\test\\resources\\Properties.txt");
		property.load(fis);
		PageFactory.initElements(driver,collegeDetails.class);
		PageFactory.initElements(driver,BaseClass.class);
		collegeDetails.Name.sendKeys(property.getProperty("CollegeName"));
		collegeDetails.Logo.sendKeys("C:\\Users\\Visitor\\eclipse-workspace\\TestngExercise\\src\\test\\resources\\Logo.jpg");
		collegeDetails.Address.sendKeys(property.getProperty("Address"));
		collegeDetails.District.sendKeys(property.getProperty("District"));
		collegeDetails.Affliation.sendKeys("Autonomous");
		collegeDetails.Affliated_to.sendKeys("Anna University");
		collegeDetails.TypeOfCollege.sendKeys("Professional");
		collegeDetails.CoarsesOffered.click();
		BaseClass.scroll(driver);
		BaseClass.waitExplicit(driver,collegeDetails.ContactPerson , 10);
		collegeDetails.ContactPerson.sendKeys(property.getProperty("ContactPerson"));
		collegeDetails.ContactNum.sendKeys(property.getProperty("ContactNum"));
		collegeDetails.ContactMail.sendKeys(property.getProperty("ContactMail"));
		collegeDetails.ContactPlacement.sendKeys(property.getProperty("ContactPlacement"));
		collegeDetails.ContactPlacNum.sendKeys(property.getProperty("ContactPlacNum"));
		collegeDetails.ContactPlacMail.sendKeys(property.getProperty("ContactPlacMail"));
		collegeDetails.ContactMail.sendKeys(Keys.ENTER);
	}

//
}
