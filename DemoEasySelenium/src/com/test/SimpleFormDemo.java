package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleFormDemo {
	WebDriver driver;
	String path = "/home/swapnil/Selenium/Drivers/";
	
  @Test(priority = 1)
  public void launchBrowser() {
	  System.setProperty("webdriver.chrome.driver", path +"chromedriver");
	  driver =  new ChromeDriver();
	  driver.get("http://www.seleniumeasy.com/test/basic-first-form-demo.html");
	  driver.manage().window().maximize();
  }
  
  @Test(priority = 2)
  public void testSingleInput(){
	  driver.findElement(By.id("user-message")).sendKeys("Hello");
	  String msg = driver.findElement(By.id("user-message")).getAttribute("value");
	  System.out.println(msg);
	  driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[1]/div[2]/form/button")).click();
	  String value = driver.findElement(By.id("display")).getText();
	  System.out.println(value);
	  Assert.assertTrue(value.equalsIgnoreCase(msg), "Message is equals");
  }
  
  @Test(priority = 3)
  public void testMultipleInput(){
	 driver.findElement(By.id("sum1")).sendKeys("12");
	 String value1 = driver.findElement(By.id("sum1")).getAttribute("value");
	 int num1 = Integer.parseInt(value1);
	 
	 driver.findElement(By.id("sum2")).sendKeys("21");
	 String value2 = driver.findElement(By.id("sum2")).getAttribute("value");
	 int num2 = Integer.parseInt(value2);
	 
	 driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]/form/button")).click();
	 String sum = driver.findElement(By.id("displayvalue")).getText();
	 
	 int res = num1 +num2;
	 int res2 = Integer.parseInt(sum);
	 System.out.println("Addtion of two no: " +res2);
	 Assert.assertTrue(res==res2 , "Sum is not 33");
	  
  }
  
  
  @Test(priority = 4)
  public void closeBrowser(){
	  if (driver != null)
		  driver.close();
  }
}
