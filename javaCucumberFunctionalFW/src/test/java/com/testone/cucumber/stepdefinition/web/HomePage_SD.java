package com.testone.cucumber.stepdefinition.web;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.testone.framework.common.CommonActionHelper;
import com.testone.pageobjects.HomePage_PO;

import io.cucumber.java.en.Given;

public class HomePage_SD extends CommonActionHelper {

	private static final Logger logger = Logger.getLogger(HomePage_SD.class);
	HomePage_PO homePagePO = PageFactory.initElements(getDriver(), HomePage_PO.class);
	
		
	@Given ("I am on homepage")
	public void launchSite() {
		initializeDriver();
		
		String url = webPropHelper.getConfigPropProperty("testURL");
		openBaseURL(url);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		
		homePagePO = PageFactory.initElements(getDriver(), HomePage_PO.class);
		
		System.out.println("after url open");
		
//		try {
//			driver.wait(10);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		/*
		if (homePagePO.signUpDialogCloseBtn.isDisplayed()) {
			System.out.println("before closing modal");
			homePagePO.signUpDialogCloseBtn.click();
			System.out.println("after closing modal");	
		}
		else {
			System.out.println("Modal not displayed");
		}
		*/
		
		//homePagePO.img_logo.click();
		//System.out.println("after logo click");
			}
	
	@Given("I click on the signin logo")
	public void clickSigninLogo() {
		
		homePagePO = PageFactory.initElements(getDriver(), HomePage_PO.class);
		System.out.println("before signin click");
		homePagePO.nav_Signin_MyAccount.click();
		System.out.println("after signin click");
		
	}
	
	
	@Given("I click on Appliances link")
	public void clickApplianceLink() {
		
		homePagePO = PageFactory.initElements(getDriver(), HomePage_PO.class);
		
		//homePagePO.lnk_Appliances.click();
		homePagePO.lnk_Test.click();
		
		System.out.println("after click Appliances Link");
		
	}
	
	
	
	
	
}
