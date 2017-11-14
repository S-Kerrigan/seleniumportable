package ForTests_101;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;

public class TestIC001_101 {

	private WebDriver driver;
	private FirefoxProfile profile;

	private String driverPath;
	private String distrPath;

	@BeforeSuite
	public void runningSetup() {
		driverPath      = System.getenv("DriverPath");
		distrPath       = System.getenv("DistrPath");

		profile         = new FirefoxProfile();

		System.setProperty("webdriver.gecko.driver", driverPath);

		driver          = new FirefoxDriver(
			new FirefoxBinary(
					new File(distrPath)
			),
		profile);
	}
	@AfterSuite
	public void close() {
		driver.quit();
	}

	@Test
	public void portableTestAttempt() {
		driver.get("http://google.com/");

		WebElement input    = driver.findElement(By.id("lst-ib"));
		WebElement button   = driver.findElement(By.name("btnK"));

		input.sendKeys("seleniumhq");
		button.click();
	}

}
