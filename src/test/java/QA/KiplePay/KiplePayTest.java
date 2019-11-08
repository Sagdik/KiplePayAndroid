package QA.KiplePay;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.GmailOtp;
import com.qa.base.KiplePayBase;
import com.qa.pages.RegistrationPage;
import com.qa.utility.Screenshot;
import com.qa.utility.ScrollUtility;



public class KiplePayTest extends KiplePayBase {
	

	String otp;
	GmailOtp gmailOtp;
	ScrollUtility scrollPage;
	RegistrationPage registrationPage;
	Screenshot screenshot;

	@BeforeMethod
	public void launchApp() throws MalformedURLException {

		gmailOtp = new GmailOtp();
		scrollPage = new ScrollUtility() ;
		registrationPage = new RegistrationPage();
		screenshot = new Screenshot();
		
		

	}

	@Test(priority=1)
	public void userRegistrationTest() throws InterruptedException, MalformedURLException {

		mobileSetUp();
		
		registrationPage.registrationDetails("Sam", "testqadelhi01+3@gmail.com", "12345678@sS", "12345678@sS");


		Thread.sleep(10000);
	
		otp = gmailOtp.getOtpDetails();
	
	 String otpnumberValue = otp.substring(341,347);
	System.out.println(otpnumberValue);

	Thread.sleep(2000);
	driver.findElement(By.xpath(".//*[@resource-id ='com.mobi.wallet:id/edtVerifyCode']")).sendKeys(otpnumberValue);
	
	}

		@AfterMethod
		public void closeApp() {
			
		driver.quit();
		
		}
	}


