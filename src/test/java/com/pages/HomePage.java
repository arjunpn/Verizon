package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class HomePage {
	AndroidDriver driver;

	
	//Initialise the elements or page objects
	public HomePage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	//Capture the elements on HomePage
	@FindBy(id="com.verzitex.android.pocketrfc:id/webview")
	public WebElement welComePage;
	
	@FindBy(id="android:id/button1")
	public WebElement continueBtn;
	
	@FindBy(xpath="//android.support.v4.view.ViewPager[@resource-id='com.verzitex.android.pocketrfc:id/pager']//android.view.View[@resource-id='com.verzitex.android.pocketrfc:id/pager_tabstrip']//android.widget.TextView[@text='Latest']")
	public WebElement latestTab;
	
	@FindBy(id="com.verzitex.android.pocketrfc:id/action_search")
	public WebElement searchIcon;
	
	@FindBy(xpath="//android.view.View[@resource-id='com.verzitex.android.pocketrfc:id/coordinatorLayout']//android.widget.LinearLayout[@index='0']//android.view.View[@index='0']//android.widget.ImageButton[@index='0']")
	public WebElement hamburgerMenu;

}
