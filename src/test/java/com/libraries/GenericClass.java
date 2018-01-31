package com.libraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;

import com.libraries.BaseClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class GenericClass {
	public static String configprop=BaseClass.sDirpath+"\\config.properties";
	public static String readexcel=BaseClass.sDirpath+"\\Abof.xlsx";
	static Dimension dSize;
	
	
	//READ data from the config.properties
	
	public static String getdataproperties(String key){
		
		String svalue=null;
		Properties properties=new Properties();
		
		try{
			
				FileInputStream file=new FileInputStream(configprop);
				properties.load(file);
				svalue=properties.getProperty(key);
			
		}catch(Exception e){
			
		}
		return svalue;
		
	}
	//Verify Toast messages
	public static String verifyToastMessage(AppiumDriver driver) throws IOException, TesseractException {
		String result = null;
		File scfile = driver.getScreenshotAs(OutputType.FILE);
		ITesseract instance = new Tesseract();
		try {
			result = instance.doOCR(scfile);
		} catch (TesseractException e) {
			
			throw e;
		}
		return result;
	}
	public static void clickOnEnter(AndroidDriver<?> driver)
	{
		driver.pressKeyCode(AndroidKeyCode.ENTER);
	}
	


}
