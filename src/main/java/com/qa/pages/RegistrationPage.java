package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import com.qa.base.KiplePayBase;

public class RegistrationPage extends KiplePayBase{
	
	public void registrationDetails(String userName ,String emailAddress,String password,String confirmPassword){

	driver.findElementById("com.mobi.wallet:id/tvSignUp").click();

	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

	WebElement username = driver.findElementById("com.mobi.wallet:id/edtFullName");
	username.sendKeys(userName);

	WebElement useremail = driver.findElementById("com.mobi.wallet:id/edtEmail");
	useremail.sendKeys(emailAddress);

	WebElement selectCountry = driver.findElementById("com.mobi.wallet:id/tvCountry");
	selectCountry.click();

	driver.findElementByXPath(".//*[@text = 'Anguilla']").click();

	WebElement userPassword = driver.findElementById("com.mobi.wallet:id/edtPassword");
	userPassword.sendKeys(password);

	WebElement userConfirmPassword = driver.findElementById("com.mobi.wallet:id/edtConfirmPassword");
	userConfirmPassword.sendKeys(confirmPassword);
	
	WebElement signUpButton = driver.findElementById("com.mobi.wallet:id/btnSubmit");
	signUpButton.click();
	}
	
}
