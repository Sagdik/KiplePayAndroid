package com.qa.base;

import java.util.concurrent.TimeUnit;

import com.qa.utility.ScrollUtility;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

@SuppressWarnings("deprecation")
public class GmailOtp extends KiplePayBase {

	String otp;
	GmailOtp gmailOtp;
	ScrollUtility scrollPage = new ScrollUtility();

	/**
	 * Get The Otp of the KiplePay form Gmail Method To get the Otp and Return to
	 * driver
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	@SuppressWarnings("rawtypes")
	public String getOtpDetails() throws InterruptedException {

		Activity activity = new Activity("com.google.android.gm", "com.google.android.gm.GmailActivity");
		((AndroidDriver) driver).startActivity(activity);

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		driver.findElementByXPath(".//*[@text ='Search mail']").click();

		Thread.sleep(5000);

		driver.findElementByXPath(".//*[@text ='Search mail']").sendKeys("Kiple");

		// Press Enter Button for search page after enter text
		((AndroidDriver<MobileElement>) driver).pressKeyCode(AndroidKeyCode.ENTER);

		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		driver.findElementByXPath(".//*[@class = 'android.view.View' and @bounds = '[0,434][1440,740]']").click();

		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);


		// Condition To scroll the page for Gmail Otp with Catch condition
		try {
			scrollPage.scrollDown(0.9, 0.1);
			Thread.sleep(3000);
			otp = driver.findElementById("m_6311986665377687647bodyCell").getText();
			System.out.println(otp);

		} catch (Exception e) {

			scrollPage.scrollDown(0.9, 0.1);
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			otp = driver.findElementByXPath("//*[contains(@text,'Unlock your')]").getText();

		}

		for (int i = 0; i <= 2; i++) {
			driver.navigate().back();
		}

		return otp;

	}

}
