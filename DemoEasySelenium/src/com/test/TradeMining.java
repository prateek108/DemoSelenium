package com.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TradeMining {

	WebDriver driver;
	
	@Test
	public void loginTest(){
		System.setProperty("webdriver.chrome.driver", "/home/prateek/Selenium/Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://portal.trademining.com/");
		driver.findElement(By.xpath("//*[@class='nav navbar-nav']/li[3]/a")).click();
	}
	
}
