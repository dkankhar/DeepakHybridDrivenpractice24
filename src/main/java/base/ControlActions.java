package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.ConstantPaths;
import utilities.PropOperations;

public class ControlActions {
	protected static WebDriver driver;
	protected static PropOperations propOperation;
	private static WebDriverWait wait;

	public static void launchBrowser() {
		propOperation = new PropOperations(ConstantPaths.PROPERTY_FILEPATH);
		System.setProperty(ConstantPaths.CHROME_DRIVER, ConstantPaths.CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(propOperation.getValue("url"));
		wait = new WebDriverWait(driver, ConstantPaths.WAIT);
	}

	public static void closeBrowser() {
		driver.close();
	}
	
	public static String getValuePropertyFile(String key) {
		return propOperation.getValue(key);
	}

	protected WebElement getElement(String locatorType, String locator, boolean isWaitRequired) {
		WebElement element = null;
		switch (locatorType.toUpperCase()) {
		case ("XPATH"):
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			else
				element = driver.findElement(By.xpath(locator));
		break;
		case ("CSS"):
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
			else
				element = driver.findElement(By.cssSelector(locator));
		break;
		case ("ID"):
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
			else
				element = driver.findElement(By.id(locator));
		break;
		case ("NAME"):
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
			else
				element = driver.findElement(By.name(locator));
		break;
		case ("LINKTEXT"):
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
			else
				element = driver.findElement(By.linkText(locator));
		break;
		case ("PARTIALLINKTEXT"):
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator)));
			else
				element = driver.findElement(By.partialLinkText(locator));
		break;
		case ("CLASSNAME"):
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
			else
				element = driver.findElement(By.className(locator));
		break;
		case ("TAGNAME"):
			if (isWaitRequired)
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locator)));
			else
				element = driver.findElement(By.tagName(locator));
		break;
		}
		return element;
	}

	protected void populateText(WebElement element, String value) {
		element.sendKeys(value);
	}

	protected void clickElement(WebElement element) {
		element.click();
	}
	
	//PageFactoryElementWait
	protected void wait(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
