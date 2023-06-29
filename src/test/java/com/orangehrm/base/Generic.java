package com.orangehrm.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.orangehrm.utilities.PropertyFileReading;

public class Generic {

	private WebDriver driver;
	WebDriverWait wait;
	Alert alert ;
	static String projectPropertyFilePath = ".\\Project.properties";
	PropertyFileReading propertyfile = new PropertyFileReading();

//	************** WebDriver methods ********************************

	public void clickElementUsingDynamicXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();

	}

	public void quitBrowser() {
		driver.close();
		driver.quit();
	}

	public void closeCurrentActionWindow() {
		driver.close();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void goBackToPreviousWebPage() {
		driver.navigate().back();
	}

	public void pause(Integer seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


//	************** WebElement methods ********************************
	@BeforeTest
	public WebDriver launchApplication() throws Exception {

		String browserName = propertyfile.readApropertyAndReturnItsValue(projectPropertyFilePath, "browser");

		switch (browserName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					".\\src\\test\\resources\\drivers\\chromedriver_114.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.chrome.driver",
					".\\src\\test\\resources\\drivers\\chromedriver_114.exe");
			driver = new ChromeDriver();
			break;
		}
		
		openApplication();
		maximizeBrowserAndImplicitWait(15);

		return getDriver();
	}

	public WebDriver getDriver() {
		if (driver != null) {
			return driver;
		}
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	@AfterTest
	public void closeCurrentBrowser() {
		getDriver().close();
	}
	
	@AfterSuite
	public void closeAllBrowsers() {
		getDriver().quit();
	}


	public void maximizeBrowserAndImplicitWait(long implicitWaitSeconds) {
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitSeconds));
	}


	public void openApplication() throws Exception {
		String url = propertyfile.readApropertyAndReturnItsValue(projectPropertyFilePath, "demoOrangeHRMUrl");
		getDriver().get(url);
	}


//	************** Robot Class methods ********************************
	public void uploadAFileUsingSendKeys(By by, String pathOfFileToBeUploaded) {
		driver.findElement(by).sendKeys(pathOfFileToBeUploaded);
	}
	// uploadAFileUsingSendKeys(By.id("fileToUpload"),"D:\\sathiya\\Text123.txt"),

	public void uploadAFileUsingRobotClass(String pathOfFile) throws Exception {
		Robot robo = new Robot();
//		C:\Users\LENOVO\Desktop\Vinothini.txt

		StringSelection stringSelection = new StringSelection(pathOfFile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(3000);

		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void enterAKeyUsingRobotClass(String keyName) throws AWTException {
		Robot robo = new Robot();
		switch (keyName) {
		case "a":
			robo.keyPress(KeyEvent.VK_A);
			robo.keyRelease(KeyEvent.VK_A);
			break;

		}

	}

	public static void enterAStringUsingRobotClass(String value) throws AWTException {
		Robot robo = new Robot();
		String[] letters = value.split("");
		for (String eachLetter : letters) {
			switch (eachLetter) {
			case "a":
				robo.keyPress(KeyEvent.VK_A);
				robo.keyRelease(KeyEvent.VK_A);
				break;

			case "b":
				robo.keyPress(KeyEvent.VK_B);
				robo.keyRelease(KeyEvent.VK_B);
				break;

			case "c":
				robo.keyPress(KeyEvent.VK_C);
				robo.keyRelease(KeyEvent.VK_C);
				break;

			case " ":
				robo.keyPress(KeyEvent.VK_SPACE);
				robo.keyRelease(KeyEvent.VK_SPACE);
				break;
			}
		}
	}

	public static void enterTwoKeyUsingRobotClass(String keysName) throws AWTException {
		Robot robo = new Robot();
		switch (keysName) {
		case "ControlA":
			robo.keyPress(KeyEvent.VK_CONTROL);
			robo.keyPress(KeyEvent.VK_A);
			robo.keyRelease(KeyEvent.VK_A);
			robo.keyRelease(KeyEvent.VK_CONTROL);
			break;

		case "CapsA":
			robo.keyPress(KeyEvent.VK_SHIFT);
			robo.keyPress(KeyEvent.VK_A);
			robo.keyRelease(KeyEvent.VK_A);
			robo.keyRelease(KeyEvent.VK_SHIFT);
			break;
		}
	}

//	************** Actions Class methods ********************************
	public void scrollToAnElementUsingActions(WebElement element) {
		Actions actions = new Actions(driver);
		actions.scrollToElement(element).build().perform();
	}

	public void rightClickAnElement(WebElement ele) {
		Actions actions = new Actions(driver);
		actions.contextClick(ele).build().perform();
	}

	public void rightClickOnMouse() {
		Actions actions = new Actions(driver);
		actions.contextClick().build().perform();
	}

	public void launchBrowser(String browserName) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LENOVO\\git\\SaraswathyJavaProject\\drivers\\chromedriver_109.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void launchApplication(String appName, long implicitWaitSeconds) {
		switch (appName) {
		case "Crocs":
			driver.get("https://www.crocs.in/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitSeconds));
		}
	}

	public void clickAnElementUsingActions(WebElement ele) {
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).build().perform();
	}

	public void pressAKeyUsingActionsClass(String keyName) {
		Actions actions = new Actions(driver);
		switch (keyName) {
		case "a":
//			actions.keyDown(Keys.a)
		}
	}

	public void typeInCaptialUsingActions(String text) {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.SHIFT).sendKeys(text).build().perform();
	}

//	************** Alert methods ********************************
	
//	we can write like this 
//	call this method first and accept or dismiss or getText from alert
	public void switchToAlert() {
		alert = getDriver().switchTo().alert();
	}
	
	
	public void acceptAlert() {
//		alert = getDriver().switchTo().alert();
		alert.accept();
	}
	
//	we can write like this too. 
//	this time, you dont need to call switchToAlert() method 
	public void acceptAlert2() {
		alert = getDriver().switchTo().alert();
		alert.accept();
	}

	public void dismissAlert() {
		getDriver().switchTo().alert().dismiss();
	}

	public void getTextFromAlert() {
		try {
			getDriver().switchTo().alert().getText();
		} catch (UnhandledAlertException e) {
			System.out.println(e.getMessage());
		}
	}

	public void sendTextToAlert(String text) {
		alert = getDriver().switchTo().alert();
		alert.sendKeys(text);
	}

	public void sendTextToAlert1(String text) {
		alert = getDriver().switchTo().alert();
		try {
			alert.sendKeys(text);
		} catch (UnhandledAlertException e) {
			System.out.println(e.getMessage());
		}
	}

//	************** Frames methods ********************************
	public int noOfiFramesInWebPage() {
		int noOfiFramesdriver = driver.findElements(By.tagName("iframe")).size();
		return noOfiFramesdriver;
	}

	public void switchToFrameByIndex(int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}

	public void switchToParentWindow() {
		driver.switchTo().parentFrame();
	}

	public void switchToMainWebPage() {
		driver.switchTo().defaultContent();
	}

	public void clickAnElement(WebElement ele) {
		ele.click();
	}
	
	public void switchToFrameUsingFrameIndex(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrameUsingFrameName(String frameName) {
		driver.switchTo().frame(frameName);
	}

	public void switchToFrameUsingWebElementName(WebElement elementName) {
		driver.switchTo().frame(elementName);
	}

//	************** WindowHandling methods ********************************
	public void closeAllChildWindows() {
		String parentWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String eachWindowHandle : allWindowHandles) {
			if (!eachWindowHandle.equals(parentWindowHandle)) {
				driver.switchTo().window(eachWindowHandle);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindowHandle);
		System.out.println(driver.getTitle());
	}

	public void closeAllChildWindows(String parentWinHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String eachWindowHandle : allWindowHandles) {
			if (!eachWindowHandle.equals(parentWinHandle)) {
				driver.switchTo().window(eachWindowHandle);
				driver.close();
			}
		}
		driver.switchTo().window(parentWinHandle);
		System.out.println(driver.getTitle());
	}

	public void switchWindowBasedOnTitle(String windowTitle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String eachWindowHandle : allWindowHandles) {
			driver.switchTo().window(eachWindowHandle);
			if (driver.getTitle().contains(windowTitle)) {
				System.out.println(driver.getTitle());
			}
		}
	}

	public void switchToChildWindow() {
		String parentWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String eachWindowHandle : allWindowHandles) {
			if (!eachWindowHandle.equals(parentWindowHandle)) {
				driver.switchTo().window(eachWindowHandle);
				System.out.println(driver.getTitle());
			}
		}
	}
//	************** Scrolling methods ********************************

//	************** DropDown methods ********************************
	public void chooseOptionByValue(WebElement ele, String value) {
		Select select = new Select(ele);
		select.selectByValue(value);
	}

	public void selectOptionByIndex(WebElement ele, int optionIndex) {
		Select select = new Select(ele);
		select.selectByIndex(optionIndex);
	}

	public void selectOptionByVisibleText(WebElement ele, String value) {
		Select select = new Select(ele);
		select.selectByVisibleText(value);
	}

	public void printAllOptionFromADropDown(WebElement ele) {
		Select select = new Select(ele);
		List<WebElement> courseAllOptions = select.getOptions();
		for (WebElement each : courseAllOptions) {
			System.out.println(each.getText());
		}

	}

	public void validateAnOptionPresentInDropDown(WebElement ele, String optionName) {
		Select select = new Select(ele);
		List<WebElement> courseAllOptions = select.getOptions();
		for (WebElement each : courseAllOptions) {
			if (each.getText().equalsIgnoreCase(optionName)) {
				System.out.println("Given option: " + optionName + " is present in the drop down");
			}
		}
	}

	public void deSelectOptionByValue(WebElement ele, String value) {
		Select select = new Select(ele);
		select.deselectByValue(value);
	}

//	**************  methods ********************************

//	************** Wait methods ********************************
	public void maximizeAWindow() {
		driver.manage().window().maximize();
	}

	public void waitForAlertToBePresent(long seconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitForElementToBeClickableByLocator(String locatorName, String classText, long seconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

		switch (locatorName) {
		case "id":
			wait.until(ExpectedConditions.elementToBeClickable(By.id(classText)));
			break;
		case "className":
			wait.until(ExpectedConditions.elementToBeClickable(By.className(classText)));
			break;

		case "name":
			wait.until(ExpectedConditions.elementToBeClickable(By.name(classText)));
			break;

		case "tagName":
			wait.until(ExpectedConditions.elementToBeClickable(By.tagName(classText)));
			break;

		case "css selector":
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(classText)));
			break;

		case "xpath":
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(classText)));
			break;

		}
	}

	public void waitForElementToBeClickable(WebElement ele, long seconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void waitForElementToBeVisible(WebElement ele, long seconds) {
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

}
