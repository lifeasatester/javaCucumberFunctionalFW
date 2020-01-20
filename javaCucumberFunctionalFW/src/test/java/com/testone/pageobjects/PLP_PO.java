package com.testone.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.testone.framework.common.CommonActionHelper;

public class PLP_PO extends CommonActionHelper {
	
	
	/*@FindBy (xpath = "//div[@class=\"imagecolumncontainer parbase section\" and @xpath=1]" )
	WebElement kitchenCabinetFirstRow;
	
	// Below is incorrect xpath - gives 6 results
	@FindBy (xpath = "//div[@class=\"imagecolumncontainer parbase section\" and @xpath=1]//a")
	WebElement kitCabFirstRowFirstProduct;
*/	
	
	@FindBy(xpath = "//div[@class='imagecolumncontainer parbase section']//div[@class='grid-16']/a/*[contains(text(),'Dishwashers')]")
	public WebElement lnk_Dishwashers;
	

}
