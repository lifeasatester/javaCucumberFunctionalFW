package com.testone.framework.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import com.testone.framework.web.helpers.WebDriverHelper;

public class CommonActionHelper extends WebDriverHelper{

	private static final Logger logger = Logger.getLogger(CommonActionHelper.class);
	private WebElement objElement;
	
	private boolean isStepPass = false;

	public static boolean waitForPageLoad(RemoteWebDriver driver) {
		boolean pageLoadWaitFlag = false;
		
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {

			// Override apply method
			public Boolean apply(WebDriver driver) {
				
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
			
		};
			
		WebDriverWait wait = new WebDriverWait(driver, pageLoadWaitTime);
		wait.until(pageLoadCondition);
		pageLoadWaitFlag = true;
		
		return pageLoadWaitFlag;
	}
		
}
