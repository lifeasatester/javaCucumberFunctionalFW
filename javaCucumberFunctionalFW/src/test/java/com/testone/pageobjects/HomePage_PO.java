package com.testone.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.log4testng.Logger;

import com.testone.framework.common.CommonActionHelper;

public class HomePage_PO extends CommonActionHelper{

	// ***** Local Object and declarations *****
	private static final Logger logger = Logger.getLogger(HomePage_PO.class);
	
	
	// **** LOCATORS ******
		
	@FindBy(xpath = "//div[@id='emailSignUpDialog']")
	public WebElement signUpDialogModal;
	
	@FindBy(xpath = "//div[@id='emailSignUpDialog']//button[@class='close']")
	public WebElement signUpDialogCloseBtn;
			
	@FindBy(xpath="//div [@class='lowes-logo']")
	public WebElement img_logo;
	
	@FindBy(xpath = "//div [@class='navigation js-navigation hide-print']//li[@class='mylowes js-mylowes']")
	public WebElement nav_Signin_MyAccount;
	
	@FindBy(xpath = "//ul[@class='list-horizontal js-list-horizontal']/li") 
	public List<WebElement> nav_QuickLink_Right;
	
	@FindBy(xpath = "//a[@class='navigation-item shop-link js-shop']")
	public WebElement navShop;
	
	@FindBy (xpath = "//div[@class='title section']//h2[contains(text(),'FEATURED CATEGORIES')]/../..//div[@class='grid-16']//p[contains(text(),'Appliances')]")
	public WebElement lnk_Appliances;
	
	@FindBy (xpath = "//span[contains(text(),'Handbags')]")
	public WebElement lnk_Test;
	
}
