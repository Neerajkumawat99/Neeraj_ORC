package org.global;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVReader;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Global {

	public static WebDriver driver;
	public FileInputStream fileInputStream;
	public Properties properties;
	public Logger logger;
	public File file;
	public FileReader fileReader;
	public JSONParser jsonParser;

	public WebDriver getDriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}

	public void enterData(WebElement webElement, String data) {
		webElement.sendKeys(data);
	}

	public void clickButton(WebElement webElement) {
		webElement.click();
	}

	public void clearText(WebElement webElement) {
		webElement.clear();
	}

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void launchURL(String url) {
		driver.get(url);
	}

	public void Scrollpup(WebElement webElement) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
	}

	public void Scrolldown(WebElement webElement) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", webElement);
	}

	public void javascript_Executor_Click_Button(WebElement webElement) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click();", webElement);
	}

	public void uploadfilefromlocal(String file) throws InterruptedException, AWTException {
		StringSelection stringSelection = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Thread.sleep(5000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("Uploaded Sucessfully");
	}

	public Properties readPropertyFileData() {
		try {
			fileInputStream = new FileInputStream(new File(
					System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\Global_Data.properties"));
			properties = new Properties();
			try {
				properties.load(fileInputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}

	public String ReadDataFromCSV(String file, String Data, int row_Count_Details) throws Throwable {
			
			String expected_Data = null;
		

			Reader reader = new FileReader(file);

			CSVReader csvReader = new CSVReader(reader);

			List<String[]> allDataFromCSVFile = csvReader.readAll();

			int rowCount = 0;
			
			for (String[] eachDataFromCSVFile : allDataFromCSVFile) {


				for (String eachDataCellValue : eachDataFromCSVFile) {

					if (rowCount == row_Count_Details) {
						if (eachDataCellValue.contains(Data)) {
							System.out.println(eachDataCellValue);
							expected_Data = eachDataCellValue;
							

						}
					}

				}
				rowCount = rowCount + 1;

			}
			return expected_Data;		
	}

	public Logger readLog4jData() {
		logger = Logger.getLogger(Global.class);
		try {
			PropertyConfigurator.configure(new FileInputStream(
					new File(System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\Log4j.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return logger;
	}

	public void generateJVMReport(String jsonFile) {
		Configuration configuration = new Configuration(
				new File(System.getProperty("user.dir") + "\\src\\main\\resources\\Reports\\CucumberReports"),
				"SalesIntel Orchestration Site Automation");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("OS Name", System.getProperty("os.name"));
		try {
			configuration.addClassifications("Host Name", InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);

		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();

	}

	public static void waitForPageLoad() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String retrieveDataFromJson(String fileName, String jsonRootData, String jsonObjectData)
			throws IOException, ParseException {
		try {
			fileReader = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jsonParser = new JSONParser();
		Object parse = jsonParser.parse(fileReader);

		JSONObject jsonObject = (JSONObject) parse;
		Object object = jsonObject.get(jsonRootData);

		JSONObject jsonObject2 = (JSONObject) object;
		return jsonObject2.get(jsonObjectData).toString();

	}

	public String retrieveJsonObjectFromJsonFile(String fileName, String jsonObjectData)
			throws IOException, ParseException {
		try {
			fileReader = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jsonParser = new JSONParser();
		Object parse = jsonParser.parse(fileReader);

		JSONObject jsonObject1 = (JSONObject) parse;
		return jsonObject1.get(jsonObjectData).toString();

	}

}
