package com.orangehrm.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestGivenRow {

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

		List<WebElement> pageLinks = driver.findElements(By.xpath("//ul[@class = 'oxd-main-menu']/li//span"));
		for (WebElement eachPageLink : pageLinks) {
			if (eachPageLink.getText().equalsIgnoreCase("PIM")) {
				eachPageLink.click();
				break;
			}
		}
		List<WebElement> SelectARow = driver.findElements(
				By.xpath("//div[contains(@class , 'oxd-table-body')]//div[contains(@class , 'oxd-table-card')]"));
		List<WebElement> SelectACheckBox = driver
				.findElements(By.xpath("//div[contains(@class , 'oxd-table-card-cell-checkbox')]//div//label//i"));
		WebElement number = driver.findElement(By.xpath("//div[@role='cell']//following::div"));
		System.out.println(number.getText());
		System.out.println("The Number of Rows in the WebTable : " + SelectARow.size());

		System.out.println("The values in the Rows are : ");
		for (WebElement eachRowValue : SelectARow) {

			System.out.println(eachRowValue.getText());
			for (WebElement eachCheckBox : SelectACheckBox) {
//				if () {
					eachCheckBox.click();
//			System.out.println(eachCheckBox);

				}
			}
		driver.close();
		}
		


	public static void waitForElementToBeVisible(WebElement ele, long seconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void clickElementUsingDynamicXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

}
