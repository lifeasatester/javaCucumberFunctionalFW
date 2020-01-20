package com.testone.cucumber.stepdefinition.web;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import com.testone.framework.common.CommonActionHelper;
import com.testone.pageobjects.PLP_PO;

import io.cucumber.java.en.Given;

public class PLP_SD extends CommonActionHelper{

	private static final Logger logger = Logger.getLogger(PLP_SD.class);
	PLP_PO plpPO = PageFactory.initElements(getDriver(), PLP_PO.class);	


	@Given("I click on Dishwasher link")
	public void clickDishwasherLink() {
		
		plpPO = PageFactory.initElements(getDriver(), PLP_PO.class);
		
		plpPO.lnk_Dishwashers.click();
		
		System.out.println("after click Dishwashers Link");
		
	}





}
