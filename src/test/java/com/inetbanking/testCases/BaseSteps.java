package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseSteps {

	ReadConfig readConfig = new ReadConfig();
	public String baseUrl = readConfig.getApplicationUrl();
	public String userId = readConfig.getUserId();
	public String password = readConfig.getPassword();
	public static WebDriver driver;
//	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(@Optional("chrome") String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", readConfig.getEdgePath());
			driver = new EdgeDriver();
		} else {
			Assert.assertTrue(false, "Invalid browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//		logger.getLogger("ebanking");
//		PropertyConfigurator.configure("log4j.properties");
		driver.get(baseUrl);
//		logger.info("Entered URL");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreenshot(WebDriver driver, String tname) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot captured");
	}
}
