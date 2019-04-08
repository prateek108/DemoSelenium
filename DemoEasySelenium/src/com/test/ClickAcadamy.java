package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClickAcadamy {

	WebDriver driver = null;
	String path = "/home/prateek/Selenium/Drivers/";
	
	@Test(priority = 1)
	public void launchBrowser(){
		System.setProperty("webdriver.chrome.driver", path + "chromedriver");
		driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/interview.php");
	}
	@Test(priority = 2)
	public void clickTabs(){
		driver.findElement(By.xpath(".//*[@id='tablist1-tab2']")).click();
		driver.findElement(By.xpath(".//*[@id='tablist1-tab2']/following-sibling::li[1]")).click();
		System.out.println(driver.findElement(By.xpath(".//*[@id='tablist1-tab2']/parent::ul")).getAttribute("role"));
		driver.findElement(By.xpath(".//*[text()=' Appium ']")).click();
	}
	@Test(priority = 3)
	public void closeBrowser(){
		if (driver != null)
			driver.close();
	}
}