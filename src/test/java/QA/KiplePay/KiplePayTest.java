package QA.KiplePay;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.GmailOtp;
import com.qa.base.KiplePayBase;
import com.qa.pages.RegistrationPage;
import com.qa.utility.Screenshot;
import com.qa.utility.ScrollUtility;
import com.qa.utility.ToastMessageVerification;

import freemarker.core.NonStringException;
import net.sourceforge.tess4j.TesseractException;

public class KiplePayTest extends KiplePayBase {

	String otp;
	GmailOtp gmailOtp;
	ScrollUtility scrollPage;
	RegistrationPage registrationPage;
	Screenshot screenshot;
	ToastMessageVerification toastMessageVerification;

	@BeforeMethod
	public void launchApp() throws MalformedURLException {

		// Mobile SetUp Method
		mobileSetUp();

		// References of gmail Otp class
		gmailOtp = new GmailOtp();

		// Scroll function for pages and Reference variable
		scrollPage = new ScrollUtility();

		// Registration page reference variable
		registrationPage = new RegistrationPage();

		// take Screenshot References Variable
		screenshot = new Screenshot();

		// Reference Variable for Validation/Toast Message
		toastMessageVerification = new ToastMessageVerification();

	}

	@Test(priority = 1)
	public void userRegistrationTest() throws InterruptedException, MalformedURLException, TesseractException {

		//Registration Data For Kiplepay
		registrationPage.registrationDetails("Sam", "limkokwing01+1@gmail.com", "12345678@sS", "12345678@sS");

		Thread.sleep(5000);

		otp = gmailOtp.getOtpDetails();
		System.out.println(otp);

		//Condition Should be vary According to length of Email 
		String otpnumberValue = otp.substring(340, 346);
		
		System.out.println(otpnumberValue);

		Thread.sleep(2000);
	
		driver.findElement(By.xpath(".//*[@resource-id ='com.mobi.wallet:id/edtVerifyCode']")).sendKeys(otpnumberValue);
		
		Thread.sleep(500);
		String validationMessage = toastMessageVerification.readToastMessage();
		System.out.println(validationMessage);
		//Verification for same email used multiple time
		Assert.assertTrue(validationMessage.contains("Success"));
		

	}

	@AfterMethod
	public void closeApp() {

		driver.quit();

	}
}
