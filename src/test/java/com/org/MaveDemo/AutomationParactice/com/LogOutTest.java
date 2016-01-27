package com.org.MaveDemo.AutomationParactice.com;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTest extends MainAutomationParactice 
{
	
	 @BeforeMethod
	  public void before()
	  {
		  System.out.println("Executing LogoutTest");
	  }
	  
	  @AfterMethod
	  public void after()
	  {
		  System.out.println("Done with LogoutTest");
	  }
	
	@Test(priority=3)
	public void logout() throws IOException
	{
		drv.findElement(By.linkText("Sign out")).click();
		drv.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
		String titleLogout = drv.getTitle();
		
		// CHECKING LOGOUT SUCCESSFUL OR NOT BY GETTING THE TITLE OF THE PAGE
		if(titleLogout.contains("My Store") == true)
		{
			Assert.assertTrue(true);
			
		}
		
		else
		{
			
			takescreenshot("logout");
			Assert.assertTrue(false, "Logout failed");
			drv.close();
		}
	}
	

}
