package com.testone.framework.common;

import java.util.Locale;

enum OS{
	WINDOWS,
	UNIX,
	POSIX_UNIX,
	MAC,
	OTHER;
	
	/*
	private String version;
	private String arch;
	
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getVersion() {
		return version;		
	}
	
	public void setArch(String arch) {
		this.arch = arch;
	}
	
	public String getArch() {
		return arch;
	}
	
	*/
}


public class OSInfo {
	
	private static OS os;
		
	String osName = System.getProperty("os.name");
	
	public static void setOSName(String osName) {
		
		if(osName == null) {
			System.out.println("OS name missing");
		}
	
		osName = osName.toLowerCase(Locale.ENGLISH);
		if (osName.contains("win")) {
			os = OS.WINDOWS;
			}
		else if (osName.contains("linux")
			  || osName.contains("unix"))			  
		{
			os = OS.UNIX;
		}
		else if (osName.contains("mac")) {
			os = OS.MAC;
		}
		else if (osName.contains("solaris")
			  || osName.contains("sunos")
			  || osName.contains("sun")) 
		{
			os = OS.POSIX_UNIX;
		}
		else {
			os = OS.OTHER;
		}
		
	}
		
	
	public static String getOS() {
		return os.toString();
	}
	
}
