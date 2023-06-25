package com.orangehrm.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\drivers\\chromedriver_114.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");

		driver.findElement(By.xpath("//button[contains(@class,'orangehrm-login-button')]")).click();

		WebElement link_DashBoard = driver.findElement(By.xpath("//a[contains(@href,'dashboard')]"));
		waitForElementToBeVisible(link_DashBoard, 10);

//		driver.findElement(By.xpath("//a[contains(@href,'viewPimModule')]")).click();
//		driver.findElement(By.xpath("//a[contains(@href,'dashboard')]")).click();

//		String str = null;
//		driver.findElements(By.xpath("//a[contains(@href,'"+str+"')]"));

		List<WebElement> pageLinks = driver.findElements(By.xpath("//ul[@class = 'oxd-main-menu']/li//span"));
		for (WebElement eachPageLink : pageLinks) {
			if (eachPageLink.getText().equalsIgnoreCase("PIM")) {
				eachPageLink.click();
				break;
			}
		}

		String idHeader = driver
				.findElement(By.xpath("//div[@class = 'oxd-table-header']//div[@role = 'columnheader'][2]")).getText();
		System.out.println(idHeader);

		List<WebElement> employeeListHeader = driver
				.findElements(By.xpath("//div[@class = 'oxd-table-header']//div[contains(@class, 'header-cell')]"));
		for (WebElement eachHeader : employeeListHeader) {
			if (!eachHeader.getText().isEmpty() && eachHeader.getText().equalsIgnoreCase("Last Name")) {
//				System.out.println(eachHeader.getText());
//				WebElement sortGivenHeader = driver.findElement(By.xpath(
//						"//div[@class = 'oxd-table-header']//div[contains(@class, 'header-cell')]//div/i"));
//				sortGivenHeader.click();
				eachHeader.findElement(By.xpath(".//div/i")).click();
				;
				Thread.sleep(2000);
				List<WebElement> ascendingOrDecending = driver.findElements(By.xpath(
						"//div[@class = 'oxd-table-header']//div[contains(@class, 'header-cell')]//div//ul//span"));
				for (WebElement each : ascendingOrDecending) {
					if (each.getText().equalsIgnoreCase("ascending")) {
						each.click();
						Thread.sleep(2000);
						break;
					}
				}
				break;
			}
		}

//		WebElement idSort = driver.findElement(By.xpath("//div[@class = 'oxd-table-header']//div[text() = 'Id']//i"));
//		idSort.click();
//		Thread.sleep(2000);
//		List<WebElement> sortingById = driver.findElements(By.xpath("//div[@class = 'oxd-table-header']//div[text() = 'Id']//i//parent::div//span"));
//		for(WebElement each: sortingById) {
//			each.click();
//			Thread.sleep(3000);
//			break;
//		}

//		List<WebElement> headersSorting = driver.findElements(By
//				.xpath("//div[@class = 'oxd-table-header']//div[contains(@class, 'header-cell') and @style ]//div/i"));
//
//		List<WebElement> ascendingOrDecending = driver.findElements(By.xpath(
//				"//div[@class = 'oxd-table-header']//div[contains(@class, 'header-cell') and @style ]//div//span"));

		int noOfRows = driver.findElements(By.xpath("//div[@class ='oxd-table-body']/div")).size();
		for (int i = 1; i <= noOfRows; i++) {
//			driver.findElement(By.xpath("//div[@class ='oxd-table-body']/div["+i+"]//i[contains(@class,'trash')]")).click();
			clickElementUsingDynamicXpath("//div[@class ='oxd-table-body']/div["+i+"]//i[contains(@class,'trash')]");
		}
		
		
	}

	public static void waitForElementToBeVisible(WebElement ele, long seconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void clickElementUsingDynamicXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

}
