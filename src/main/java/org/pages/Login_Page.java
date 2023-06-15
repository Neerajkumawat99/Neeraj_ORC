package org.pages;

import org.global.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page extends Global {

	public Login_Page() throws Throwable {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='text']")
	private WebElement username_Text_Field;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement password_Text_Field;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement remember_Me_Check_Box;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit_Button;

	public WebElement getUsername_Text_Field() {
		return username_Text_Field;
	}

	public WebElement getPassword_Text_Field() {
		return password_Text_Field;
	}

	public WebElement getRemember_Me_Check_Box() {
		return remember_Me_Check_Box;
	}

	public WebElement getSubmit_Button() {
		return submit_Button;
	}

}
