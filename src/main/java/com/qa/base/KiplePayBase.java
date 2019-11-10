package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class KiplePayBase {

	public static AndroidDriver<MobileElement> driver;

	File file;

	public static Properties pro;

	FileInputStream fileinputstream;

	DesiredCapabilities dc = new DesiredCapabilities();

	/*
	 * Constructor For load all file and properties file
	 * By defaults from starting of page
	 */
	public KiplePayBase() {

		super();

		pro = new Properties();

		file = new File("./propertyFile/config.properties");

		try {

			fileinputstream = new FileInputStream(file);

			pro.load(fileinputstream);

		} catch (FileNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

			System.out.println("File Not Able To Load");

		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

			System.out.println("Property Not Able To Load");

		}

	}

	/**
	 * Method For Real devices
	 * 
	 * @throws MalformedURLException
	 */
	public void mobileSetUp() throws MalformedURLException {

		dc.setCapability("platformName", pro.getProperty("Android"));

		dc.setCapability("deviceName", pro.getProperty("AndroidDeviceName"));

		dc.setCapability("unicodeKeyboard", "true");

		dc.setCapability("resetKeyboard", "true");

		dc.setCapability("udid", "993ba090");

		dc.setCapability("platformVersion", "7.1.1");

		dc.setCapability("appPackage", "com.mobi.wallet");

		dc.setCapability("appActivity", "com.mobi.wallet.MainActivity");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(url, dc);

	}

}
