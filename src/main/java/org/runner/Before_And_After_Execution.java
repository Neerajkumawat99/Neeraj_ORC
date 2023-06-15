package org.runner;

import org.global.Global;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Before_And_After_Execution extends Global {

	@Before
	public void beforeExecutedClass(Scenario scenario) {
		System.out.println("Scenario Starts" + "\n" + "Scenario Name: " + scenario.getName());
	}

	@After
	public void afterExecutedClass(Scenario scenario) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		if (scenario.isFailed()) {
			byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshotAs, "image/png");
		}
	}

}
