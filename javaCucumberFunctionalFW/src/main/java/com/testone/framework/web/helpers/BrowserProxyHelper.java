package com.testone.framework.web.helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.Proxy;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;

public class BrowserProxyHelper {

	private static final Logger logger = Logger.getLogger(BrowserProxyHelper.class);
	
	public BrowserMobProxy proxy = null;
	private static Proxy seleniumProxy;
	
	// private constructor to restrict new instances
	private BrowserProxyHelper() {
		if(proxy==null) {
			initiateBrowserMobProxy();
		}
	}

	//Bill Pugh Solution for SINGLETON PATTERN
	private static class BrowserProxyHelperSingleton{
		private static final BrowserProxyHelper INSTANCE = new BrowserProxyHelper();
	}

	public static BrowserProxyHelper getInstance() {
		return BrowserProxyHelperSingleton.INSTANCE;
	}
	
	
	public Proxy initiateBrowserMobProxy() {

		startBrowserMobProxy();
		setProxyCaptureTypes();
		setHarFileName();
		
		logger.debug("------ Started Browser Mob Proxy Server -------");
		return getSeleniumProxy();
	}
	
	
	public void startBrowserMobProxy() {
		logger.debug("-- initiated Start Browser Mob Proxy --");
		
		proxy = new BrowserMobProxyServer();
		proxy.setTrustAllServers(true);
		proxy.start(0);
		
		seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
		
		logger.debug("Browser Mob Proxy Server Started...");
	}
	
	public void setProxyCaptureTypes() {
		if (proxy!=null && proxy.isStarted()) {
			logger.debug("... inside setProxyCaptureTypes... ");
			proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT,CaptureType.RESPONSE_CONTENT);
		}
	}
	
	public void setHarFileName() {
		if (proxy!=null && proxy.isStarted()) {
			proxy.newHar(null); // initial HAR file eg: "http://www.google.com"
		}
	}

	public Proxy getSeleniumProxy() {
		return seleniumProxy;
	}
	

	
}

