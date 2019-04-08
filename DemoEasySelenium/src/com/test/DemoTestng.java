package com.test;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class DemoTestng {
	WebDriver driver;
	String path = "/home/prateek/Selenium/Drivers/";
	
	@Test
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", path +"chromedriver");
		  driver =  new ChromeDriver();
		  driver.get("http://google.co.in");
		  
	}

}
