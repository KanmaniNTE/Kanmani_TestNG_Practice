package com.orangehrm.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSelectARow {

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
		
		driver.findElement(By.xpath("//label[text() = 'Employee Name']//following::div//input")).sendKeys("Aaliyah");
//		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//button[@type='submit']"))).click().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")).click();
		
		//Delete the Selected row
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash']")).click();
		driver.findElement(By.xpath("//div[@class='orangehrm-modal-footer']//following::i")).click();
		}
		


	public static void waitForElementToBeVisible(WebElement ele, long seconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void clickElementUsingDynamicXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

}
