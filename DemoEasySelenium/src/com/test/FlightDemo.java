package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlightDemo {
	WebDriver driver = null;
	String path = "/home/prateek/Selenium/Drivers/";

	@Test(priority = 1)
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", path + "chromedriver");
		driver = new ChromeDriver();
		driver.get("https://phptravels.com/demo.php/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@href='//www.phptravels.net']")).click();
		String parent= driver.getWindowHandle();

		for (String handle : driver.getWindowHandles()) {
			if(!parent.equalsIgnoreCase(handle)){
			driver.switchTo().window(handle);
			}
			System.out.println(handle);
		}
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//*[@href='https://www.phptravels.net/flightst']")).click();
	}

	@Test(priority = 2)
	public void quit() {
		driver.quit();
	}
}
