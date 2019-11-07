package QA.KiplePay;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.GmailOtp;
import com.qa.base.KiplePayBase;
import com.qa.utility.ScrollUtility;


public class KiplePayTest extends KiplePayBase {
	

	GmailOtp gmailOtp;
	ScrollUtility scrollPage;

	@BeforeMethod
	public void launchApp() throws MalformedURLException {

		mobileSetUp();
		gmailOtp = new GmailOtp();
		scrollPage = new ScrollUtility() ;

	}

	@Test
	public void userRegistrationTest() throws InterruptedException, MalformedURLException {

		driver.findElementById("com.mobi.wallet:id/tvSignUp").click();

		Thread.sleep(2000);

		WebElement username = driver.findElementById("com.mobi.wallet:id/edtFullName");
		username.sendKeys("Sagar Tripathi");

		WebElement useremail = driver.findElementById("com.mobi.wallet:id/edtEmail");
		useremail.sendKeys("testqadelhi01@gmail.com");

		WebElement selectCountry = driver.findElementById("com.mobi.wallet:id/tvCountry");
		selectCountry.click();

		driver.findElementByXPath(".//*[@text = 'Anguilla']").click();

		WebElement userPassword = driver.findElementById("com.mobi.wallet:id/edtPassword");
		userPassword.sendKeys("12345678sS");

		WebElement userConfirmPassword = driver.findElementById("com.mobi.wallet:id/edtConfirmPassword");
		userConfirmPassword.sendKeys("12345678sS");
		
		WebElement signUpButton = driver.findElementById("com.mobi.wallet:id/btnSubmit");
		signUpButton.click();
		
		mobileSetUp2();
		
		gmailOtp.getOtpDetails();
		
		System.out.println("out from gmail otp and goining to scrolls ");
	
		
		scrollPage.scrollDown(0.9, 0.1);
	
		
		String otp = driver.findElementByXPath(".//android.view.View[contains(text(),'Unlock your kiplePay account with this secret code')]").getText();
	
		System.out.println(otp);
		

		
		Thread.sleep(10000);
	}

	//@AfterMethod
	public void closeApp() {

		driver.quit();
	}

}
