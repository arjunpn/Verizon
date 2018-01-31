package com.libraries;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.libraries.GenericClass;

import io.appium.java_client.android.AndroidDriver;

public class BaseClass {
	
	public DesiredCapabilities Capabilities;
	public static  String sDirpath=System.getProperty("user.dir");
	public String apkfilepath=sDirpath+"\\apkPath\\pocketrfcdroid-google-release.apk";

	public static  AndroidDriver driver;
	
	
	
	@BeforeMethod
	public void setup()
	{
		try{
		
		Capabilities=new DesiredCapabilities();
		System.out.println(apkfilepath);
		
		Capabilities.setCapability("automationName",GenericClass.getdataproperties("AUTOMATIONNAME"));
		Capabilities.setCapability("platformName",GenericClass.getdataproperties("PLTFORMNAME"));
		Capabilities.setCapability("deviceName",GenericClass.getdataproperties("DEVICENAME"));
		Capabilities.setCapability("platformVersion",GenericClass.getdataproperties("PLTFORMVESION"));
		Capabilities.setCapability("app",apkfilepath );
		Capabilities.setCapability("fullReset", "false");
		Capabilities.setCapability("noReset", "true");
		
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), Capabilities);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
	}
	public void handlekeyboad(){
		try{
			driver.hideKeyboard();
			
		}catch(Exception e){
			
		}
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}
