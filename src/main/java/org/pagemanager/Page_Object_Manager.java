package org.pagemanager;

import org.pages.Home_Page;
import org.pages.Login_Page;

public class Page_Object_Manager {

	private static Page_Object_Manager page_Object_Manager;
	private Login_Page loginPage;
	private Home_Page home_Page;

	private Page_Object_Manager() {
		
	}

	public static Page_Object_Manager getInstance() {
		return (page_Object_Manager == null) ? page_Object_Manager = new Page_Object_Manager() : page_Object_Manager;
	}

	public Login_Page getLoginPage() throws Throwable {
		return (loginPage == null) ? loginPage = new Login_Page() : loginPage;
	}

	public Home_Page getHome_Page() throws Throwable {
		return (home_Page == null) ? home_Page = new Home_Page() : home_Page;
	}
	


}
