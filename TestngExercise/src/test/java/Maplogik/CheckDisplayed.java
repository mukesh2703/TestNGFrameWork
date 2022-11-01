package Maplogik;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import basePackage.BaseClass;

public class CheckDisplayed extends BaseClass {
	
	
	@FindBy(xpath="(//tr[@role='row']//img[contains(@src,'_Logo.jpg')])")
	public static WebElement Logo;
	@FindBy(xpath="//*[text()='Ramakrishna Engineering College']")
	public static WebElement clgname;	
	@FindBy(xpath="//*[text()='Coimbatore']")
	public static WebElement clgDistrict;
	@FindBy(xpath="//*[@id=\"datatable\"]/tbody/tr[1]/td[4]")
	public static WebElement icons;
	@FindBy(xpath="(//tr[@class='odd']//img[contains(@src,'_Logo.jpg')]/../..)//a[@class='item-edit dlt-college']")
	public static WebElement Delete;
	
	public void chckDisplayed() throws IOException {
		Properties property = new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\Visitor\\eclipse-workspace\\TestngExercise\\src\\test\\resources\\Properties.txt");
		property.load(fis);
		String GetName=CheckDisplayed.clgname.getText();
		Assert.assertEquals(GetName, property.getProperty("ContactPerson"));
		String GetDistrict=CheckDisplayed.clgDistrict.getText();
		Assert.assertEquals(GetDistrict, property.getProperty("District"));
	}
	
	public static boolean ValidateLogo() {
		BaseClass.waitExplicit(driver,Logo , 10);
		boolean Displayed = Logo.isDisplayed();
		Assert.assertEquals(Displayed, true);
		return Displayed;
	}
	public static boolean ValidateCollege() {
		BaseClass.waitExplicit(driver,clgname , 20);
		boolean Displayed = clgname.isDisplayed();
		Assert.assertEquals(Displayed, true);
		return Displayed;
	}
	public static boolean ValidateLocation() {
		BaseClass.waitExplicit(driver,clgDistrict , 10);
		boolean Displayed = clgDistrict.isDisplayed();
		Assert.assertEquals(Displayed, true);
		return Displayed;
	}
	public static boolean ValidateIcon() {
		BaseClass.waitExplicit(driver,icons , 10);
		boolean Displayed = icons.isDisplayed();
		Assert.assertEquals(Displayed, true);
		return Displayed;
	}
	 public static  Alert deleteclg() {
	     CheckDisplayed.Delete.click();
		Alert alert =driver.switchTo().alert();
		 alert.accept();
		return alert;
	 }
	 
}
