package org.pages;

import org.global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page extends Global{
	
	public Home_Page() throws Throwable {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	private WebElement logout_Text_Field;
	
	@FindBy(xpath = "//a[contains(text(),' Jobs')]")
	private WebElement job_Label_Field;
	
	@FindBy(xpath = "//button[contains(@title,'Reverify Contact')]")
	private WebElement reverify_Contact_Button;
	
	@FindBy(xpath = "//button[contains(text(),'Create New Job')]")
	private WebElement create_New_Job_Button;
	
	@FindBy(xpath = "//input[@placeholder='Job Name']")
	private WebElement job_Name_Text_Field;
	
	@FindBy(xpath = "//input[@placeholder='Comments']")
	private WebElement comments_Text_Field;
	
	@FindBy(xpath = "//label[contains(text(),'Choose File')]")
	private WebElement choose_File_Button;
	
	@FindBy(xpath = "//button[@type='submit' and @class='btn btn-info submit-width']")
	private WebElement choose_File_Submit_Button;
	
	@FindBy(xpath = "//a[contains(text(),'Search')]")
	private WebElement search_Label;
	
	@FindBy(xpath = "//label[contains(text(),'Reverify Contact')]")
	private WebElement reverify_Contact_Label;
	
	@FindBy(xpath = "//span[contains(text(),'Activity')]")
	private WebElement activity_Label;
	
	@FindBy(xpath = "//input[@type='text' and @placeholder='Search Text']")
	private WebElement search_Text_Input_Field;
	
	@FindBy(xpath = "(//button[contains(text(),'Search')])[2]")
	private WebElement search_Button;
	
	@FindBy(xpath = "//select[contains(@class,'select__activity-status ng-')]")
	private WebElement searched_Contact_Dropdown;
	
	@FindBy(xpath = "(//select[contains(@class,'select__activity-status ng-')]//following::option)[1]")
	private WebElement searched_Contact_Dropdown_Options;
	
	@FindBy(xpath = "//button[contains(text(),'Get Activity Status')]")
	private WebElement get_Activity_Status_Button;
	
	@FindBy(xpath = "//i[@title='Process Status Information']")
	private WebElement process_Status_Information_Icon;
	
	@FindBy(xpath = "//div[@class='col' and contains(text(),'Process Status')]")
	private WebElement process_Status_Details;
	
	@FindBy(xpath = "//button[contains(text(),'Close')]")
	private WebElement process_Status_Close_Button;
	
	@FindBy(xpath = "//div[@id='toast-container']")
	private WebElement csv_File_Uploaded_Status;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	private WebElement tasks_Label;
	
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	private WebElement yes_Button;
	
	@FindBy(xpath = "//*[contains(text(),'Task completed successfully')]")
	private WebElement task_Completed_Successfully_Toast_Message;
	
	@FindBy(xpath = "//button[contains(text(),'Refresh')]")
	private WebElement refresh_Button;

	public WebElement getLogout_Text_Field() {
		return logout_Text_Field;
	}

	public WebElement getJob_Label_Field() {
		return job_Label_Field;
	}

	public WebElement getReverify_Contact_Button() {
		return reverify_Contact_Button;
	}

	public WebElement getCreate_New_Job_Button() {
		return create_New_Job_Button;
	}

	public WebElement getJob_Name_Text_Field() {
		return job_Name_Text_Field;
	}

	public WebElement getComments_Text_Field() {
		return comments_Text_Field;
	}

	public WebElement getChoose_File_Button() {
		return choose_File_Button;
	}

	public WebElement getChoose_File_Submit_Button() {
		return choose_File_Submit_Button;
	}

	public WebElement getSearch_Label() {
		return search_Label;
	}

	public WebElement getReverify_Contact_Label() {
		return reverify_Contact_Label;
	}

	public WebElement getActivity_Label() {
		return activity_Label;
	}

	public WebElement getSearch_Text_Input_Field() {
		return search_Text_Input_Field;
	}

	public WebElement getSearch_Button() {
		return search_Button;
	}

	public WebElement getSearched_Contact_Dropdown() {
		return searched_Contact_Dropdown;
	}

	public WebElement getSearched_Contact_Dropdown_Options() {
		return searched_Contact_Dropdown_Options;
	}

	public WebElement getGet_Activity_Status_Button() {
		return get_Activity_Status_Button;
	}

	public WebElement getProcess_Status_Information_Icon() {
		return process_Status_Information_Icon;
	}

	public WebElement getProcess_Status_Details() {
		return process_Status_Details;
	}

	public WebElement getProcess_Status_Close_Button() {
		return process_Status_Close_Button;
	}

	public WebElement getCsv_File_Uploaded_Status() {
		return csv_File_Uploaded_Status;
	}

	public WebElement getTasks_Label() {
		return tasks_Label;
	}

	public WebElement getYes_Button() {
		return yes_Button;
	}

	public WebElement getTask_Completed_Successfully_Toast_Message() {
		return task_Completed_Successfully_Toast_Message;
	}

	public WebElement getRefresh_Button() {
		return refresh_Button;
	}

}
