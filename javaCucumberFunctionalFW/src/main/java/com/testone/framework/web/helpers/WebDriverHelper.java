package com.testone.framework.web.helpers;

import javax.sound.midi.MidiDevice.Info;

import org.apache.log4j.Logger;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testone.framework.common.CommonActionHelper;
import com.testone.framework.common.Constants;
import com.testone.framework.common.OSInfo;
import com.testone.framework.common.PropertiesHelper;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WebDriverHelper {
	
	//private
	private static final Logger logger = Logger.getLogger(WebDriverHelper.class);
	public PropertiesHelper webPropHelper = PropertiesHelper.getInstance();
	
	public static RemoteWebDriver driver;
	public WebDriverWait wait;
	
	public static String browserType;
	public static String testType; /* web vs device */
	public static String testURL;
	
	public static int explicitWaitTime;
	public static int pageLoadWaitTime;
	
	private String runBrowserHeadless;
	
	/* ---------- Methods ---------- */
	
	//initializeDriver()
	public void initializeDriver() {
					
		System.out.println("Initialize... ");
		
		String isLocalENV = webPropHelper.getConfigPropProperty("isLocalENV");
		String driverType = webPropHelper.getConfigPropProperty("driverType");
		
		testType = System.getProperty("testtype");
		testURL = System.getProperty("testurl");
		
		//testURL = webPropHelper.getConfigPropProperty("testURL");
		
		if(testType==null && ("yes".equalsIgnoreCase(isLocalENV)|| "true".equalsIgnoreCase(isLocalENV))) {
			testType = webPropHelper.getConfigPropProperty("AppType");
			logger.debug("PlatformType: "+testType);
		}	
		
			
		if(browserType==null && ("yes".equalsIgnoreCase(isLocalENV) || "true".equalsIgnoreCase(isLocalENV))) {
			browserType = webPropHelper.getConfigPropProperty("browserType").toLowerCase();
			logger.info("Browser: " +browserType);
		}
				
		
		if("web".equalsIgnoreCase(testType)) {
			initializeWebDriver(browserType, driverType);
		}
		//Test
		
			
	}// End of initializeDriver
	
	
	//initializeWebDriver()
	public void initializeWebDriver(String browserType, String driverType) {
		
		if(driverType.equalsIgnoreCase("local")) 
		{
			logger.debug("Inside initializeWebDriver method.... ");
			
			if("chrome".equalsIgnoreCase(browserType)) {
				launchChromeBrowser(getWebDriverFolderPath("chromedriver"));
			}
			else if ("firefox".equalsIgnoreCase(browserType)) {
				launchFirefoxBrowser(getWebDriverFolderPath("firefox"));
			}
			
		}
		
		
	} //end of initializeWebDriver()
	
	
	public String getWebDriverFolderPath(String driverFileName) {
		
		String finalPath = null;
		String osName = System.getProperty("os.name");
				
		if(osName == null){
			System.out.println("System property null");
		}
		else if(osName != null){
			OSInfo.setOSName(osName);			
		}
		if (OSInfo.getOS().equalsIgnoreCase("windows"))
			finalPath = Constants.DRIVERSFOLDERPATH = Constants.DRIVERSROOTFOLDERPATH+"windows"+driverFileName+".exe";
		else if (OSInfo.getOS().equalsIgnoreCase("mac"))
			finalPath = Constants.DRIVERSFOLDERPATH = Constants.DRIVERSROOTFOLDERPATH + "mac"+driverFileName;
		else if (OSInfo.getOS().equalsIgnoreCase("unix"))
			finalPath = Constants.DRIVERSFOLDERPATH = Constants.DRIVERSROOTFOLDERPATH +"linux/";
		else if (OSInfo.getOS().equalsIgnoreCase("posix_unix"))
			finalPath = Constants.DRIVERSFOLDERPATH = Constants.DRIVERSROOTFOLDERPATH + "linux/";
	
		logger.debug("WebDriver folder path: " + finalPath);
		return finalPath;
		
	}
	
	
	public RemoteWebDriver launchChromeBrowser(String webDriverFolderPath) {
			logger.debug("----- Launching Chrome Browser -----");
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions chromeOptions = new ChromeOptions();
			
			// set Capabilities
			chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			chromeOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
			chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			
			//chromeOptions.setExperimentalOption("excludeSwitches", "[enable-automation]");
			//chromeOptions.setExperimentalOption("useAutomationExtension", false);
			
			// add arguments
			chromeOptions.addArguments("--disable-popup-blocking");
			if(Constants.isBrowserProxyEnabled) {
				logger.debug("---- Browser Proxy Enabled ----");
				chromeOptions.addArguments("-incognito");
				// using BrowserProxyHelper...
				chromeOptions.setCapability(CapabilityType.PROXY, BrowserProxyHelper.getInstance().getSeleniumProxy());
			}
			
			if("yes".equalsIgnoreCase(runBrowserHeadless)) {
				// add / set additional / required chromeOptions
			}
			chromeOptions.addArguments("enable-extensions");
			chromeOptions.addArguments("enable-automation");
			
			
			// Driver instance
			driver = new ChromeDriver(chromeOptions);
			
			return driver;
	}
	
	
	public RemoteWebDriver launchFirefoxBrowser(String webDriverFolderPath) {
		logger.debug("--- Launching Firefox Browser ----");
		WebDriverManager.firefoxdriver().setup();
		
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		
		firefoxOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		firefoxOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
		firefoxOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		
		firefoxOptions.addArguments("--disable-popup-blocking");
		if(Constants.isBrowserProxyEnabled) {
			logger.debug("--- Browser Mob Proxy added ---");
			firefoxOptions.setCapability(CapabilityType.PROXY, BrowserProxyHelper.getInstance().getSeleniumProxy());
		}
		
		if("yes".equalsIgnoreCase(runBrowserHeadless)) {
			// set required capabilities and arguments... 
		}
		
		driver = new FirefoxDriver(firefoxOptions);
		return driver;

	}
	
	
	public boolean openBaseURL (String url) {
		System.out.println("inside open url");
		
		logger.debug("URL: " +url);
		//getDriver().get(url);
		driver.get(url);
		
		boolean isPageLoad = CommonActionHelper.waitForPageLoad(driver);
		return isPageLoad;
				
	}

	public RemoteWebDriver getDriver () {
		return driver;
	}

}
