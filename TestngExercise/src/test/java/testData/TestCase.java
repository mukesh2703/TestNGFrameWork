package testData;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import Maplogik.CheckDisplayed;
import Maplogik.CollegeActivation;
import Maplogik.ImportMarks;
import Maplogik.Login;
import Maplogik.collegeDetails;
import Maplogik.studentHomepage;
import Maplogik.studentLogin;
import basePackage.BaseClass;

public class TestCase extends BaseClass{
	static Properties property;
	static FileInputStream fis;
	ExtentSparkReporter spark;
	ExtentReports extent;
	
	@BeforeTest
	public void ExtentReports() {
	  spark = new ExtentSparkReporter("./ExtentReport.html");
	  extent =new ExtentReports();
	 extent.attachReporter(spark);
	}
	@Test(priority=1)
	public void StudentLogin() throws IOException, ParseException  {
		ExtentTest test =extent.createTest("Scenario-2, LogIn StudentId");
		PageFactory.initElements(driver,studentLogin.class);
		PageFactory.initElements(driver,BaseClass.class);
		studentLogin.StudentURL();
		studentLogin.StudentCredential();
		test.log(Status.PASS, "Student id successfully LogIn");
	}
	@Test(priority=2)
	public void BeforeImport() throws IOException {
		ExtentTest test =extent.createTest("Scenario-2, ScreenShot Before Import Marks ");
		PageFactory.initElements(driver,studentHomepage.class);
		BaseClass.waitExplicit(driver, studentHomepage.AcademicInfo, 10);
		studentHomepage.AcademicInfo.click();
		studentHomepage.S_ShotBeforeimport();
		studentHomepage.Logout.click();
		test.log(Status.PASS, "ScreenShot Take Succesfully Before Import Marks");
	}
	@Test(priority=3)
	public void ImportMarks() throws IOException, InterruptedException {
		ExtentTest test =extent.createTest("Scenario-2, Import Marks");
		PageFactory.initElements(driver, Login.class);
		Login.AdminURL();
		Login.Credential();
		PageFactory.initElements(driver, CollegeActivation.class);
		CollegeActivation.Activation.click();
		BaseClass.scroll(driver);
		BaseClass.waitExplicit(driver, CollegeActivation.ImportMarks, 10);
		BaseClass.click(driver, CollegeActivation.ImportMarks);
		PageFactory.initElements(driver, ImportMarks.class);
		ImportMarks.ImMarks();
		ImportMarks.Logout.click();
		test.log(Status.PASS, "College Deleted Sucessfully After validation");
	}
	@Test(priority=4)
	public void AfterImport() throws IOException, ParseException {	
		ExtentTest test =extent.createTest("Scenario-2, ScreenShot After Import Marks ");
		PageFactory.initElements(driver,studentLogin.class);
		PageFactory.initElements(driver,BaseClass.class);
		studentLogin.StudentURL();
		studentLogin.StudentCredential();
		BaseClass.waitExplicit(driver, studentHomepage.AcademicInfo, 20);
		studentHomepage.AcademicInfo.click();
		studentHomepage.S_ShotAfterimport();
		test.log(Status.PASS, "College Deleted Sucessfully After validation");
	}

	@Test(priority=5)
	public  void AdminPagelogin() throws IOException, InterruptedException {
		ExtentTest test =extent.createTest("Scenario-1, LogIn Admin Page");
		PageFactory.initElements(driver, Login.class);
		PageFactory.initElements(driver, BaseClass.class);
		Login.AdminURL();
		Login.Credential();
		test.log(Status.PASS, "AdminPage Login Successfully");	
	}

	@Test(priority=6)
	public  void AddCollege() throws InterruptedException, IOException {
		ExtentTest test =extent.createTest("Scenario-1, Adding New College");		
		PageFactory.initElements(driver, collegeDetails.class);
		collegeDetails.AddDetails();
		test.log(Status.PASS, "New College Added Sucessfully");

	}

	@Test(priority=7)
	public  void ValidatingCollege() throws IOException {
		ExtentTest test =extent.createTest("Scenario-1, Validating College Details");
		PageFactory.initElements(driver,CheckDisplayed.class);
		CheckDisplayed.ValidateLogo();
		CheckDisplayed.ValidateCollege();
		CheckDisplayed.ValidateLocation();
		CheckDisplayed.ValidateIcon();
		CheckDisplayed.deleteclg();
		test.log(Status.PASS, "College Deleted Sucessfully After validation");
	}
	
		
	@AfterClass
	public void ExtentFlush() {
		extent.flush();
	}

}


