package com.test;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
     
    public class takeScreenShotExample{
        public WebDriver driver = null;
        String path = "/home/prateek/Downloads/phantomjs-2.1.1-linux-x86_64/bin/phantomjs";
         
      @Test(priority =1)
      public void openBrowser() throws Exception {
    	  File file = new File(path);				
          System.setProperty("phantomjs.binary.path", file.getAbsolutePath());		
          WebDriver driver = new PhantomJSDriver();
    	  
  		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	  driver.manage().window().maximize();
    	  driver.get("http://52.76.4.159:8080/VZ-Test/");
    	  String URL = driver.getCurrentUrl();
    	  System.out.println(URL);
    	  try{
                
    		  driver.findElement(By.linkText("Logi"));
    		
                 
    	  }
    	  catch (Exception e){
    		  System.out.println("I'm in exception");
    		  getscreenshot();
    		  SendMailSSLWithAttachment();
     	  }
    	  
    	/*  if(URL.contains("VZ-Test")){
    		  System.out.println("All is well");
    	  }
    	  else{
    		  System.out.println("I'm in exception");
    		  getscreenshot();
    		  SendMailSSLWithAttachment();
    	  }*/
      }
      
      @Test(priority =2)
      public void closeBrowser()
      {
    	  if (driver != null)
    	  driver.close();
      }
      
      
      public void SendMailSSLWithAttachment() {
    	  
    			// Create object of Property file
    			Properties props = new Properties();
    	 
    			// this will set host of server- you can change based on your requirement 
    			props.put("mail.smtp.host", "smtp.giantleapsystems.com");
    	 
    			// set the port of socket factory 
    			props.put("mail.smtp.socketFactory.port", "587");
    	 
    			// set socket factory
    			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
    	 
    			// set the authentication to true
    			props.put("mail.smtp.auth", "true");
    	 
    			// set the port of SMTP server
    			props.put("mail.smtp.port", "587");
    	 
    			// This will handle the complete authentication
    			Session session = Session.getDefaultInstance(props,
    	 
    					new javax.mail.Authenticator() {
    	 
    						protected PasswordAuthentication getPasswordAuthentication() {
    	 
    						return new PasswordAuthentication("prateek@giantleapsystems.com", "Prateek123");
    	 
    						}
    	 
    					});
    	 
    			try {
    	 
    				// Create object of MimeMessage class
    				Message message = new MimeMessage(session);
    	 
    				// Set the from address
    				message.setFrom(new InternetAddress("prateek@giantleapsystems.com"));
    	 
    				// Set the recipient address
    				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("prateek@giantleapsystems.com"));
    	            
    				//message.setRecipients(Message.RecipientType.CC,InternetAddress.parse("sandeep@giantleapsystems.com,sushant@giantleapsystems.com"));
    	                        // Add the subject link
    				message.setSubject("Testing Subject");
    	 
    				// Create object to add multimedia type content
    				BodyPart messageBodyPart1 = new MimeBodyPart();
    	 
    				// Set the body of email
    				messageBodyPart1.setText("This is message body");
    	 
    				// Create another object to add another content
    				MimeBodyPart messageBodyPart2 = new MimeBodyPart();
    	 
    				// Mention the file which you want to send
    				String filename = "/home/prateek/desktop/screenshot.png";
    	 
    				// Create data source and pass the filename
    				DataSource source = new FileDataSource(filename);
    	 
    				// set the handler
    				messageBodyPart2.setDataHandler(new DataHandler(source));
    	 
    				// set the file
    				messageBodyPart2.setFileName(filename);
    	 
    				// Create object of MimeMultipart class
    				Multipart multipart = new MimeMultipart();
    	 
    				// add body part 1
    				multipart.addBodyPart(messageBodyPart2);
    	 
    				// add body part 2
    				multipart.addBodyPart(messageBodyPart1);
    	 
    				// set the content
    				message.setContent(multipart);
    	 
    				// finally send the email
    				Transport.send(message);
    	 
    				System.out.println("=====Email Sent=====");
    	 
    			} catch (MessagingException e) {
    	 
    				throw new RuntimeException(e);
    	 
    			}
    	 
    		}
    	 
    	
      
      public void getscreenshot() throws Exception 
      {
              File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
              FileUtils.copyFile(scrFile, new File("/home/prateek/desktop/screenshot.png"));
      }
 }