package com.qa.base;



import org.openqa.selenium.WebElement;

import com.qa.utility.ScrollUtility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

@SuppressWarnings("deprecation")
public class GmailOtp extends KiplePayBase{


	@SuppressWarnings({ "deprecation", "unchecked" })
	public void getOtpDetails() throws InterruptedException{
		
		driver.findElementById("com.google.android.gm:id/welcome_tour_got_it").click();
		
		Thread.sleep(5000);
		
		driver.findElementByXPath(".//*[@resource-id ='com.google.android.gm:id/action_done']").click();
		
		
		try{
			Thread.sleep(5000);
			
			driver.findElementById("com.google.android.gm:id/gm_dismiss_button").click();
			
			Thread.sleep(5000);
			
			driver.findElementByXPath(".//*[@text= 'OK']").click();
			
			Thread.sleep(5000);
			
			driver.findElementByXPath(".//*[@text ='Search mail']").click();
			
			Thread.sleep(5000);
			
			driver.findElementByXPath(".//*[@text ='Search mail']").sendKeys("Kiple");

			((AndroidDriver<WebElement>)driver).pressKeyCode(AndroidKeyCode.ENTER);
			
			Thread.sleep(5000);
			
			driver.findElementByXPath(".//*[@class = 'android.view.View' and @bounds = '[0,507][1080,736]']").click();			
		
			Thread.sleep(5000);
			
			
			
		}catch(Exception e){
			
			System.out.println(e);
		}
		
		
		
		
		
	}
	
}
