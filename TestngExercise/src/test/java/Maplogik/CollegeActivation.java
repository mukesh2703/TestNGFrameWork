package Maplogik;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePackage.BaseClass;

public class CollegeActivation extends BaseClass{
	
	@FindBy(xpath="(//span[@class='menu-title text-truncate'])[3]")
	public static WebElement Activation;
	@FindBy(xpath="//section[@id='basic-datatable']/div/div/div/a/span")
	public static WebElement AddNew;
	@FindBy(xpath="//tr[@role='row']//td[text()='Anna University - college of Engineering']/../td/a[@title='Import Marks']")
	public static WebElement ImportMarks;
		
}
