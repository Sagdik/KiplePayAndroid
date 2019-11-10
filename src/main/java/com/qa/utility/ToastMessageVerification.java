package com.qa.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.KiplePayBase;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

public class ToastMessageVerification extends KiplePayBase {

	static String scrShotDir = "screenshots";
	File scrFile;
	static File scrShotDirPath = new java.io.File("./" + scrShotDir + "//");
	String destFile;

	
	/**
	 * Read toast Message from screenshot
	 * @return
	 * @throws TesseractException
	 */
	public String readToastMessage() throws TesseractException {
		String imgName = takeScreenShot();
		String result = null;
		File imageFile = new File(scrShotDirPath, imgName);
		//System.out.println("Image name is :" + imageFile.toString());
		ITesseract instance = new Tesseract();

		File tessDataFolder = LoadLibs.extractTessResources("tessdata"); // Extracts
		instance.setDatapath(tessDataFolder.getAbsolutePath()); // sets tessData
		result = instance.doOCR(imageFile);
		//System.out.println(result);
		return result;
	}

	/**
	 * Takes screenshot of active screen
	 * @return ImageFileName
	 */
	public String takeScreenShot() {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		new File(scrShotDir).mkdirs(); // Create folder under project with name
		// "screenshots" if doesn't exist
		destFile = dateFormat.format(new Date()) + ".png"; // Set file name
		// using current
		// date time.
		try {
			FileUtils.copyFile(scrFile, new File(scrShotDir + "/" + destFile)); // Copy

		} catch (IOException e) {
			System.out.println("Image not transfered");
			e.printStackTrace();
		}
		return destFile;
	}

}
