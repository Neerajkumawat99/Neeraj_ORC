package org.stepdefinition;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.global.Global;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pagemanager.Page_Object_Manager;
import org.pages.Login_Page;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps extends Global {
	public static WebDriver driver;
	public static Logger log;
	public static String job_Name;

	@Given("Launch The URL")
	public void launch_the_url() {
		driver = getDriver();
		maximizeWindow();
		implicitWait();
		launchURL(readPropertyFileData().getProperty("url"));
		log = readLog4jData();
		log.info("The URL is Successfully Launched");
	}

	@When("Enter The User Name")
	public void enter_The_User_Name() {

		try {
			enterData(Page_Object_Manager.getInstance().getLoginPage().getUsername_Text_Field(),
					retrieveDataFromJson(
							System.getProperty("user.dir") + "\\src\\main\\resources\\Test_Data\\Json_Data.json",
							"Login_Details", "Username"));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.info("Username is entered");
	}

	@When("Enter The Password")
	public void enter_The_Password() {
		try {
			enterData(Page_Object_Manager.getInstance().getLoginPage().getPassword_Text_Field(),
					retrieveDataFromJson(
							System.getProperty("user.dir") + "\\src\\main\\resources\\Test_Data\\Json_Data.json",
							"Login_Details", "Password"));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Password is entered");
	}

	@When("Click On Remember Me Check Box")
	public void click_On_Remember_Me_Check_Box() {
		try {
			clickButton(Page_Object_Manager.getInstance().getLoginPage().getRemember_Me_Check_Box());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Clicked On Remember Me");
	}

	@When("Click On Submit Button")
	public void click_On_Submit_Button() {
		try {
			clickButton(Page_Object_Manager.getInstance().getLoginPage().getSubmit_Button());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Clicked On Submit Button");
	}

	@When("Click On Logout Button")
	public void click_On_Logout_Button() {
		try {
			WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
			webDriverWait.until(ExpectedConditions
					.visibilityOf(Page_Object_Manager.getInstance().getHome_Page().getLogout_Text_Field()));
			clickButton(Page_Object_Manager.getInstance().getHome_Page().getLogout_Text_Field());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Clicked On Logout Button");
	}

	@When("Click On Job Label")
	public void click_On_Job_Label() {
		try {
			WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
			webDriverWait.until(ExpectedConditions
					.visibilityOf(Page_Object_Manager.getInstance().getHome_Page().getJob_Label_Field()));
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
			javascriptExecutor.executeScript("arguments[0].click();",
					Page_Object_Manager.getInstance().getHome_Page().getJob_Label_Field());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Clicked On Job Label");
	}

	@When("Click On Create New Job")
	public void click_On_Create_New_Job() {
		try {
			Thread.sleep(5000);
			clickButton(Page_Object_Manager.getInstance().getHome_Page().getCreate_New_Job_Button());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Clicked On Create New Job");
	}

	@When("Enter Job Name In Reverify Contact Job Page")
	public void enter_Job_Name_In_Reverify_Contact_Job_Page() throws Throwable {
		Thread.sleep(2000);
		String date_Format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss").format(new Date());
		job_Name = retrieveDataFromJson(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Test_Data\\Json_Data.json", "Upload_File",
				"File_Name") + " " + date_Format;
		System.out.println("File Name from Job Name Filed:" + job_Name);
		enterData(Page_Object_Manager.getInstance().getHome_Page().getJob_Name_Text_Field(), job_Name);
		log.info("Entered The Job Name In Reverify Contact Job Page");

	}

	@When("Enter The Comments In Reverify Contact Job Page")
	public void enter_The_Comments_In_Reverify_Contact_Job_Page() throws Throwable {
		Thread.sleep(2000);
		System.out.println("File Name from comments Filed:" + job_Name);
		enterData(Page_Object_Manager.getInstance().getHome_Page().getComments_Text_Field(), job_Name + " Uploaded");
		log.info("Entered The Comments In Reverify Contact Job Page");
	}

	@When("Upload The CSV File In Reverify Contact Job Page")
	public void upload_The_CSV_File_In_Reverify_Contact_Job_Page() throws Throwable {
		Thread.sleep(2000);
		clickButton(Page_Object_Manager.getInstance().getHome_Page().getChoose_File_Button());
		Thread.sleep(2000);
		uploadfilefromlocal(System.getProperty("user.dir") + "\\src\\main\\resources\\CSV_File_Store\\TestCase1.csv");
		log.info("Uploaded The CSV File From Local Storage");
	}

	@When("Click On Submit Button In Reverify Contact Job Page")
	public void click_On_Submit_Button_In_Reverify_Contact_Job_Page() {
		try {
			Thread.sleep(5000);
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
			javascriptExecutor.executeScript("arguments[0].click();",
					Page_Object_Manager.getInstance().getHome_Page().getChoose_File_Submit_Button());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Clicked On Submit Button In Reverify Contact Job Page");
	}

	@When("Click On Reverify Contact Button")
	public void click_On_Reverify_Contact_Button() {
		try {
			WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
			webDriverWait.until(ExpectedConditions
					.visibilityOf(Page_Object_Manager.getInstance().getHome_Page().getReverify_Contact_Button()));
			clickButton(Page_Object_Manager.getInstance().getHome_Page().getReverify_Contact_Button());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Clicked On Reverify Contact Button");
	}

	@When("Click On Search Label")
	public void click_On_Search_Label() {
		try {

			WebDriverWait webDriverWait = new WebDriverWait(driver, 120);
			webDriverWait.until(ExpectedConditions
					.visibilityOf(Page_Object_Manager.getInstance().getHome_Page().getSearch_Label()));

			Thread.sleep(5000);

			clickButton(Page_Object_Manager.getInstance().getHome_Page().getSearch_Label());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Clicked On Search Label");
	}

	@When("Click On Reverify Contact\\(RV)")
	public void click_On_Reverify_Contact_RV() {
		try {
			Thread.sleep(2000);
			clickButton(Page_Object_Manager.getInstance().getHome_Page().getReverify_Contact_Label());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Clicked On Reverify Contact(RV) Options");
	}

	@When("Click On Actvity Label")
	public void click_On_Actvity_Label() {
		try {
			Thread.sleep(2000);
			clickButton(Page_Object_Manager.getInstance().getHome_Page().getActivity_Label());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Clicked On Actvity Label");
	}

	@When("Enter The Search Contact Deatils From CSV File")
	public void enter_The_Search_Contact_Deatils_From_CSV_File() throws Throwable {
		Thread.sleep(2000);
		String readDataFromCSV = ReadDataFromCSV(
				System.getProperty("user.dir") + "\\src\\main\\resources\\CSV_File_Store\\TestCase1.csv", "@imf.org",
				1);
		System.out.println("Data Received From CSV File:" + readDataFromCSV);
		enterData(Page_Object_Manager.getInstance().getHome_Page().getSearch_Text_Input_Field(), readDataFromCSV);
		log.info("Entered The Search Contact Deatils From CSV File");
	}

	@When("Click On Search Button In Search Actvity")
	public void click_On_Search_Button_In_Search_Actvity() {
		try {
			Thread.sleep(2000);
			clickButton(Page_Object_Manager.getInstance().getHome_Page().getSearch_Button());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Clicked On Search Button");
	}

	@When("Choose The Searched Contact Dropdown Option")
	public void choose_The_Searched_Contact_Dropdown_Option() throws Throwable {
		Thread.sleep(2000);
		clickButton(Page_Object_Manager.getInstance().getHome_Page().getSearched_Contact_Dropdown());

		Thread.sleep(2000);
		clickButton(Page_Object_Manager.getInstance().getHome_Page().getSearched_Contact_Dropdown_Options());

		log.info("Choose The Searched Contact Dropdown Option");
	}

	@When("Click On Get Activity Status")
	public void click_On_Get_Activity_Status() {
		try {
			Thread.sleep(2000);
			clickButton(Page_Object_Manager.getInstance().getHome_Page().getGet_Activity_Status_Button());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Clicked On Get Activity Status");
	}

	@When("Click On Process Status Information Icon")
	public void click_On_Process_Status_Information_Icon() {
		try {
			Thread.sleep(2000);

			WebDriverWait webDriverWait = new WebDriverWait(driver, 120);
			webDriverWait.until(ExpectedConditions.visibilityOf(
					Page_Object_Manager.getInstance().getHome_Page().getProcess_Status_Information_Icon()));
			clickButton(Page_Object_Manager.getInstance().getHome_Page().getProcess_Status_Information_Icon());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Clicked On Process Status Information Icon");
	}

	@Then("Validate Process Status Information")
	public void validate_Process_Status_Information() throws Throwable {
		Thread.sleep(2000);

		System.err.println(Page_Object_Manager.getInstance().getHome_Page().getProcess_Status_Details().getText());
		log.info("Validated The Process Status Information");
	}

	@When("Click On Close Button In Process Status Information")
	public void click_On_Close_Button_In_Process_Status_Information() {
		try {
			Thread.sleep(2000);
			clickButton(Page_Object_Manager.getInstance().getHome_Page().getProcess_Status_Close_Button());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Click On Close Button In Process Status Information");
	}

	@Then("Validate The Toast Message After The CSV File Upload")
	public void validate_The_Toast_Message_After_The_CSV_File_Upload() throws Throwable {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(false);",
				Page_Object_Manager.getInstance().getHome_Page().getLogout_Text_Field());
		if (driver.findElements(By.xpath("//div[@id='toast-container']")).size() != 0) {
			System.err
					.println(Page_Object_Manager.getInstance().getHome_Page().getCsv_File_Uploaded_Status().getText());
		}

		log.info("Validated The Toast Message After The CSV File Upload");
	}

	@When("Click On Task Label")
	public void click_On_Task_Label() {
		try {
			Thread.sleep(2000);
			clickButton(Page_Object_Manager.getInstance().getHome_Page().getTasks_Label());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Clicked On Task Label");
	}

	@When("Click On Latest Uploaded CSV File")
	public void click_On_Latest_Uploaded_CSV_File() throws Throwable {
		System.out.println(job_Name);
		Thread.sleep(600000);

		clickButton(Page_Object_Manager.getInstance().getHome_Page().getRefresh_Button());
		Thread.sleep(2000);

		WebDriverWait webDriverWait = new WebDriverWait(driver, 120);
		webDriverWait.until(ExpectedConditions.visibilityOf(driver
				.findElement(By.xpath("//a[contains(text(),'" + job_Name + "')]//following::td//child::button"))));
		Thread.sleep(2000);
		clickButton(
				driver.findElement(By.xpath("//a[contains(text(),'" + job_Name + "')]//following::td//child::button")));

		Thread.sleep(10000);
		clickButton(Page_Object_Manager.getInstance().getHome_Page().getYes_Button());
		log.info("Clicked On Latest Uploaded CSV File");
	}

	@Then("Validate The Toast Message")
	public void validate_The_Toast_Message() throws Throwable {
		if (driver.findElements(By.xpath("//*[contains(text(),'Task completed successfully')]")).size() != 0) {
			System.err.println(Page_Object_Manager.getInstance().getHome_Page()
					.getTask_Completed_Successfully_Toast_Message().getText());
		}
	}

	@When("Wait For 5 Minutes")
	public void wait_For_5_Minutes() {
		try {
			Thread.sleep(300000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Waited For 5 Minutes");
	}

	@When("Wait For 15 Minutes")
	public void wait_For_15_Minutes() throws Throwable {

		Thread.sleep(300000);
		Actions actions=new Actions(driver);
		actions.moveToElement(Page_Object_Manager.getInstance().getHome_Page().getJob_Label_Field()).build().perform();
		
		Thread.sleep(300000);
		Actions actions1=new Actions(driver);
		actions1.moveToElement(Page_Object_Manager.getInstance().getHome_Page().getTasks_Label()).build().perform();
		
		Thread.sleep(300000);
		Actions actions2=new Actions(driver);
		actions2.moveToElement(Page_Object_Manager.getInstance().getHome_Page().getSearch_Label()).build().perform();

		log.info("Waited For 15 Minutes");
	}
}
