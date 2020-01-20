package com.testone.framework.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesHelper {

	private static final Logger logger = Logger.getLogger(PropertiesHelper.class);
	private final Properties configProp = new Properties();
	private final Properties testDataProperty = new Properties();
	public String captureOnlyFAIL;
	public String captureScreenShot;

	private PropertiesHelper() {
		
		//Private constructor to restrict new instances
		logger.debug("Read all properties from file");
		
		try {

			// Load the common config properties file.
			FileInputStream configPropFis = getFileInputStream(System.getProperty("user.dir")+ "/src/test/resources/config/config.properties");
			if(configPropFis != null){
					configProp.load(configPropFis);
				}
			
			// Load the Test Data File
			String testdataPropFileName= System.getProperty("testdatafilename");
			if(testdataPropFileName ==null &&("yes".equalsIgnoreCase(getConfigPropProperty("isLocalENV"))||"true".equalsIgnoreCase(getConfigPropProperty("isLocalENV")))){
				testdataPropFileName = getConfigPropProperty("testdatafilename");
			}
			
			logger.debug("testdatafilename::"+testdataPropFileName);
			if(testdataPropFileName != null && testdataPropFileName.length()>1){
				if(!testdataPropFileName.contains(".properties")){
					testdataPropFileName=testdataPropFileName+".properties";
				}
				logger.debug("Final testdatafilename::"+testdataPropFileName);
				FileInputStream testDataPropFis = getFileInputStream(System.getProperty("user.dir")+ "/src/test/resources/test_data/"+testdataPropFileName);
				if(testDataPropFis != null){
					testDataProperty.load(testDataPropFis);
				}
			}
			
			
		}catch (IOException e) { 
			logger.error("PropertiesHelper IOException:: "+e.getMessage());
			e.printStackTrace();
			}
		
		logger.debug("properties file load Done.");
		
	}
	
	//Bill Pugh Solution for SINGLETON PATTERN
	private static class PropertiesHelperSingleton
	{
		private static final PropertiesHelper INSTANCE = new PropertiesHelper();
	}

	public static PropertiesHelper getInstance()
	{
		return PropertiesHelperSingleton.INSTANCE;
	}

	
	
	//getFileInputStream()
	public FileInputStream getFileInputStream(String filePath) {
		FileInputStream fileInputStream = null;
		
		try {
			
			fileInputStream = new FileInputStream(filePath);
			
		} catch (FileNotFoundException e) {
			logger.error("getFileInputStream() exception msg::"+e.getMessage());
			logger.error("FILE NOT FOUND::"+filePath);
			
			e.printStackTrace();
		}
		return fileInputStream;
	}
	
	//	getConfigPropProperty()
	public String getConfigPropProperty(String key){
		return configProp.getProperty(key);
	}
	
	//getTestDataProperty
	public String getTestDataProperty(String key){
		return testDataProperty.getProperty(key);
	}
	
	
}
