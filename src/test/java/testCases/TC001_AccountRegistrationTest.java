package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
     
	
	@Test(groups= {"Regression", "Master"})
	public void verify_Account_registration()
	{
	  
	  logger.info("**** Starting TC001_AccountRegistrationTest ");
	  
	  try 
	  {
	  HomePage hp=new HomePage(driver);
	  hp.clickMyAccount();
	  logger.info("Clicked on MyAccount link....");
	  hp.ClickRegister();
	  logger.info("Clicked on Register");
	  
	  AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
	  
	  logger.info("Providing customer details...");
	  regpage.setFirstname(randomString().toUpperCase());
	  regpage.setLastname(randomString().toUpperCase());
	  regpage.setEmail(randomString()+"@gmail.com");
	  
	  String password=randomAlphanumeric();
	  regpage.setPassword(password);
	  regpage.setConfirmPassword(password);
	  regpage.setTelephone(randomNumber());
	  regpage.setPrivacyPolicy();
	  regpage.clickContinue();
	  
	  logger.info("Validating confirmation message");
	  String confmsg=regpage.getConfirmationMsg();
	  Assert.assertEquals(confmsg, "Your Account Has Been Created!");	
	  
	  }
	
	
	 catch(Exception e)
	 {
		 logger.error("Test Failed...");
		 logger.debug("Debug logs...");
		 Assert.fail();
	 }
	

	
}
}



