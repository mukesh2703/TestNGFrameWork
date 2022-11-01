package Maplogik;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import basePackage.BaseClass;
    

public class ImportMarks extends BaseClass {

	static WebDriver driver;
	
	@FindBy(id="course_type")
	public static WebElement CoarseType;
	@FindBy(id="course_name")
	public static WebElement CoarseName;
	@FindBy(xpath="//div[@class='col-12']//select[@name='semester']")
	public static WebElement Semester;
	@FindBy(id="import_file")
	public static WebElement ImportFile;
	@FindBy(xpath="//button[@type='submit']")
	public static WebElement Submit;
	@FindBy(xpath="(//span[@class='menu-title text-truncate'])[11]")
	public static WebElement Logout;

	public static void ImMarks() {
//		BaseClass.waitExplicit(driver, ImportMarks.CoarseType, 10);
		Select Type = new Select(CoarseType);
		Type.selectByIndex(2);
//		BaseClass.waitExplicit(driver, ImportMarks.CoarseName, 10);
		Select Coarse = new Select(CoarseName);
		Coarse.selectByIndex(0);
//		BaseClass.waitExplicit(driver, ImportMarks.Semester, 10);
		Select select = new Select(Semester);
		select.selectByIndex(1);
		ImportFile.sendKeys("C:\\Users\\Visitor\\eclipse-workspace\\TestngExercise\\src\\test\\resources\\CGPA.csv");		
		Submit.click();
	}

}
