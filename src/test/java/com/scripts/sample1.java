package com.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.libraries.BaseClass;
import com.libraries.GenericClass;
import com.pages.HomePage;
import com.pages.RfcPage;
import com.pages.SavedPage;
import com.pages.SearchPage;

import io.appium.java_client.android.AndroidKeyCode;



public class sample1 extends BaseClass {
	
	
	
	@Test
	public void verifysample() throws InterruptedException{
	HomePage home=new HomePage(driver);
	SearchPage sp=new SearchPage(driver);
	SavedPage savep=new SavedPage(driver);
	RfcPage rp=new RfcPage(driver);
	try{
		Assert.assertTrue(home.welComePage.isDisplayed(), "WelcomePage is not displayed");
	home.continueBtn.click();
	}
	catch(Exception e){
	}
	Assert.assertTrue(home.searchIcon.isDisplayed(), "The search Icon is displayed");
	home.searchIcon.click();
	Assert.assertTrue(sp.searchTB.isDisplayed(), "The search Icon is displayed");
	sp.searchTB.sendKeys("http");
	GenericClass.clickOnEnter(driver);
	String rfcTitle=sp.clickOnRfc("HTTP/1.0");
	//String rfcID=sp.retreiveSelectedRfcNum(rfcTitle);
	rp.favoriteIcon.click();
	rp.optionsMenu.click();
	rp.saveOption.click();
	rp.AcceptPopupOption.click();
	Thread.sleep(1000);
	rp.backIcon.click();
	sp.backIcon.click();
	home.hamburgerMenu.click();
	savep.savedMenuOption.click();
	System.out.println(savep.checkSavedPagePresent(rfcTitle));
	sp.clickOnRfc("HTTP/1.0");
	rp.optionsMenu.click();
	rp.deleteOption.click();
	rp.AcceptPopupOption.click();;
	
	
	
	}
	
	

}
