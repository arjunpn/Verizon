package com.pages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SearchPage {
	AndroidDriver<?> driver;

	public SearchPage(AndroidDriver<?> driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="android:id/search_app_icon")
	public WebElement searchAppIcon;
		
	@FindBy(id="android:id/search_src_text")
	public WebElement searchTB;
	
	@FindBy(xpath="//android.view.View[@resource-id='com.verzitex.android.pocketrfc:id/coordinatorLayout']//android.widget.LinearLayout[@index='0']//android.view.View[@index='0']//android.widget.ImageButton[@index='0']")
	public WebElement backIcon;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.verzitex.android.pocketrfc:id/rfc_title']")
	public List<WebElement> rfcs;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.verzitex.android.pocketrfc:id/rfc_id']")
	public List<WebElement> SearchResultRfcNums;
	
	public String clickOnRfc(String rfcCriteria)
	{
		for (Iterator<WebElement> iterator = rfcs.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			String x=webElement.getText();
			if(x.contains(rfcCriteria)){
				System.out.println(webElement.getText());
				webElement.click();
				return x;
			}
		}
		return null;
	}
	
	
//	@SuppressWarnings("unchecked")
//	public String retreiveSelectedRfcNum(String selectedElement)
//	{
//		HashMap<Object, Object> map=new HashMap<Object, Object>();
//		for (int i = 0; i < SearchResultRfcNums.size(); i++) {
//			map.put(rfcs.get(i).getText(), SearchResultRfcNums.get(i).getText());
//		}
//		for (Iterator<WebElement> iterator = rfcs.iterator(); iterator.hasNext();)
//		{
//			WebElement webElement = (WebElement) iterator.next();
//			System.out.println(map.get(webElement));
//			if(webElement.equals(selectedElement))
//			{
//				return (String) map.get(selectedElement);
//			}
//		}
//		return null;
//	}
	
	
	
}
