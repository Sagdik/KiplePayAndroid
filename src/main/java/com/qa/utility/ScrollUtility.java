package com.qa.utility;

import org.openqa.selenium.Dimension;
import java.time.Duration;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import com.qa.base.KiplePayBase;


public class ScrollUtility extends KiplePayBase{
	
	@SuppressWarnings("rawtypes")
	public void scrollDown(double value1,double value2) {
	
	Dimension dimension =driver.manage().window().getSize();
	System.out.println(dimension);
	
	Double scrollheight = dimension.getHeight()*value1;
	int scrollStart = scrollheight.intValue();
	System.out.println(scrollStart);
	
	Double scrollheightEnd = dimension.getHeight()*value2;
	int scrollEnd = scrollheightEnd.intValue();
	System.out.println(scrollEnd);
	
	new TouchAction((PerformsTouchActions)driver)
	.press(PointOption.point(0,scrollStart))
	.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
	.moveTo(PointOption.point(0 , scrollEnd))
	.release()
	.perform();

	}
	
	



}
