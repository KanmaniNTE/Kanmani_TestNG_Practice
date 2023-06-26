package com.orangehrm.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;

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

public class Generic {
	
	WebDriver driver;
	WebDriverWait wait;
	Alert alert = driver.switchTo().alert();
	
	
//	************** WebDriver methods ********************************
	
	public void clickElementUsingDynamicXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
//	************** WebElement methods ********************************
	public void OpenBrowserWithParameter(String browserName) {
		switch(browserName) {
			case "Chrome":
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\git\\VinothiniJavaProject\\drivers\\chromedriver_107.exe");
				driver = new ChromeDriver();
				break;
			case "Firefox":
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\git\\VinothiniJavaProject\\drivers\\geckodriver.exe");
				driver = new ChromeDriver();
				break;
		}
		driver.manage().window().maximize();
		driver.get("");
		driver.findElement(By.id("email")).sendKeys("Sathya08ece@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("TestSathya@123");
		driver.findElement(By.name("login")).click();
	}
	
	public void browserLaunch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\git\\VinothiniJavaProject\\drivers\\chromedriver_107.exe");
		driver = new ChromeDriver();
	}
	
	public void maximizeBrowserWindow() {
		driver.manage().window().maximize();
	}
	
	public void launchBrowserAndMaximizeWindow() {
		browserLaunch();
		maximizeBrowserWindow();
	}
	
	public void launchApplication(String url) {
		driver.get(url);
	}
	
	public void launchApplicationUsingProp() throws Exception {
//		driver.get("facebook.com");
//		driver.get(commonMethods.readAndReturnProperty("facebookURL"));
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
	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}
	
	public void getTextFromAlert() {
		try {
			driver.switchTo().alert().getText();
		}
		catch(UnhandledAlertException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void sendTextToAlert(String text) {
		alert.sendKeys(text);
	}
	
	public void sendTextToAlert1(String text) {
		try {
		alert.sendKeys(text);
		}
		catch(UnhandledAlertException e) {
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
			if(each.getText().equalsIgnoreCase(optionName)) {
				System.out.println("Given option: "+optionName+ " is present in the drop down");
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
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}


}
