package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class RfcPage {
	AndroidDriver driver;

	public RfcPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(id="com.verzitex.android.pocketrfc:id/action_favorite")
	public WebElement favoriteIcon;
	
	@FindBy(xpath="//android.widget.ImageView[@index='3']")
	public WebElement optionsMenuIcon;
	
	@FindBy(xpath="//android.widget.TextView[@text='Save']")
	public WebElement saveOption;
	
	@FindBy(id="android:id/button1")
	public WebElement AcceptPopupOption;
	
	@FindBy(id="android:id/button2")
	public WebElement cancelPopupOption;
	
	@FindBy(xpath="//android.view.View[@resource-id='com.verzitex.android.pocketrfc:id/coordinatorLayout']//android.widget.LinearLayout[@index='0']//android.view.View[@index='0']//android.widget.ImageButton[@index='0']")
	public WebElement backIcon;
	
	@FindBy(xpath="//android.widget.TextView[@text='Delete']")
	public WebElement deleteOption;
	
	
	public String rfcOnPage()
	{
		return driver.findElement(By.xpath("//android.view.View[@resource-id='com.verzitex.android.pocketrfc:id/coordinatorLayout']//android.widget.LinearLayout[@index='0']//android.view.View[@index='0']//android.widget.TextView[@index='1']")).getText();
		
	}
	

}
