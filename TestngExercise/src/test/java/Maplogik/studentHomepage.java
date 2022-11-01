package Maplogik;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePackage.BaseClass;



public class studentHomepage extends BaseClass {
	
	@FindBy(xpath="//span[text()='Academic Info']")
	public static WebElement AcademicInfo;
	@FindBy(xpath="(//*[text()='Log out'])")
	public static WebElement Logout;
	
	public static File S_ShotBeforeimport() throws IOException {
	File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshot, new File("C:\\Users\\Visitor\\eclipse-workspace\\TestngExercise\\src\\test\\resources\\Beforemarkupload.png"));
	return screenshot;
	}
	public static File S_ShotAfterimport() throws IOException {
	File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshot, new File("C:\\Users\\Visitor\\eclipse-workspace\\TestngExercise\\src\\test\\resources\\AfterMarkupload.png"));
	return screenshot;
	}

}
