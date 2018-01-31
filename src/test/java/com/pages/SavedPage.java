package com.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class SavedPage {
	AndroidDriver driver;

	public SavedPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//android.support.v7.widget.RecyclerView[@resource-id='com.verzitex.android.pocketrfc:id/material_drawer_recycler_view']//android.widget.LinearLayout[@index='10']//android.widget.TextView[@text='Saved']")
	public WebElement savedMenuOption;
	
	@FindBy(xpath="//android.support.v4.view.ViewPager[@resource-id='com.verzitex.android.pocketrfc:id/pager']//android.view.View[@resource-id='com.verzitex.android.pocketrfc:id/pager_tabstrip']//android.widget.TextView[@text='Saved']")
	public WebElement savedTab;
	
	@FindBy(id="com.verzitex.android.pocketrfc:id/rfc_fav_image")
	public WebElement favoriteIcon;
	
	@FindBy(id="com.verzitex.android.pocketrfc:id/rfc_saved_image")
	public WebElement savedIcon;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.verzitex.android.pocketrfc:id/rfc_title']")
	public List<WebElement> savedPageList;
	
	public boolean checkSavedPagePresent(String savedPageTitle)
	{
		for (Iterator iterator = savedPageList.iterator(); iterator.hasNext();)
		{
			WebElement webElement = (WebElement) iterator.next();
			if(webElement.getText().contains(savedPageTitle))
			{
				return true;
			}
			
		}
		return false;
	}
	
}
