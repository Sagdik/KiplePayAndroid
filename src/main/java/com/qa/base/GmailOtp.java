package com.qa.base;



import com.qa.utility.ScrollUtility;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

@SuppressWarnings("deprecation")
public class GmailOtp extends KiplePayBase{


	String otp;
	GmailOtp gmailOtp;
	ScrollUtility scrollPage = new ScrollUtility();
	
	
	@SuppressWarnings("rawtypes")
	public String getOtpDetails() throws InterruptedException{
		
		Activity activity = new Activity("com.google.android.gm", "com.google.android.gm.GmailActivity");
        ((AndroidDriver) driver).startActivity(activity);
		
        Thread.sleep(10000);
		
        driver.findElementByXPath(".//*[@text ='Search mail']").click();
		
		Thread.sleep(10000);
		
		driver.findElementByXPath(".//*[@text ='Search mail']").sendKeys("Kiple");

		((AndroidDriver<MobileElement>)driver).pressKeyCode(AndroidKeyCode.ENTER);
		
		Thread.sleep(5000);
		
		driver.findElementByXPath(".//*[@class = 'android.view.View' and @bounds = '[0,507][1080,736]']").click();			
	
		Thread.sleep(5000);
		
		
		System.out.println("out from gmail otp and goining to scrolls ");
	
		try{
		scrollPage.scrollDown(0.9, 0.1);
		
		Thread.sleep(3000);
		
		otp = driver.findElementById("m_6311986665377687647bodyCell").getText();
		System.out.println(otp);
		
		}catch(Exception e){
			
			scrollPage.scrollDown(0.9, 0.1);
			
			Thread.sleep(3000);
			
		    otp = driver.findElementByXPath("//*[contains(@text,'Unlock your')]").getText();
		  
		}
		
	for(int i =0;i<=2;i++){	
	driver.navigate().back();
	}
		
		return otp;
		
		
	}
	
}
