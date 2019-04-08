package com.test;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDown {
	WebDriver driver = null;
	String path = "/home/prateek/Selenium/Drivers/";
	
@BeforeMethod
public void launchBrowser(){
	System.setProperty("webdriver.chrome.driver", path + "chromedriver");
	driver = new ChromeDriver();
	driver.get("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
	
}
	
/*@Test(priority = 1)
public void simpleDropdown(){
	
	WebElement element= driver.findElement(By.id("select-demo"));
	Select se=new Select(element);
	se.selectByIndex(2);
	String val1= element.getAttribute("value");
	System.out.println(val1);
	
	WebElement element1 =  driver.findElement(By.className("selected-value"));
	String val2 = element1.getText();
	
	assertTrue(val2.contains(val1), "Dropdown value not equals");
	
	
}

@Test(priority = 2)
public void selectFirstDropdown(){
	WebElement ele = driver.findElement(By.id("multi-select"));
	Select sel = new Select(ele);
	sel.selectByValue("New York");
	String val2= ele.getAttribute("value");
		
	driver.findElement(By.id("printMe")).click();
	
	WebElement ele1 =driver.findElement(By.className("getall-selected"));
	String val3 = ele1.getText();
	
	
	assertTrue(val3.contains(val2));
	
			
}*/

@Test(priority =3)
public void allSelectedDropdown(){
	WebElement ele = driver.findElement(By.id("multi-select"));
	Select sel = new Select(ele);
	sel.selectByValue("New York");
	sel.selectByValue("Ohio");
	sel.selectByValue("Pennsylvania");
	List<WebElement> allSelectedOptions = sel.getAllSelectedOptions();
	for(int i=0;i<allSelectedOptions.size();i++)
	{
		System.out.println(ele.getText());
		
	}
	
	String val4= ele.getAttribute("value");
	
	driver.findElement(By.id("printAll")).click();
	
	WebElement ele1 =driver.findElement(By.className("getall-selected"));
	String val5 = ele1.getText();
	
	//assertTrue(val5.contains(val4));
	
}

/*@AfterMethod
public void exitBrowser(){
	
	if(driver != null){
		driver.close();
	}
	else
	{
		System.out.println("No WebDriver Found");
	}
}*/

}
